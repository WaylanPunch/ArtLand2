package com.artland.service.impl;

import com.artland.dao.*;
import com.artland.entity.Blog;
import com.artland.entity.Category;
import com.artland.entity.Tag;
import com.artland.entity.TagRelation;
import com.artland.util.MarkDownUtil;
import com.artland.util.PageQueryUtil;
import com.artland.util.PageResult;
import com.artland.util.PatternUtil;
import com.artland.controller.vo.BlogDetailVO;
import com.artland.controller.vo.BlogListVO;
import com.artland.controller.vo.SimpleBlogListVO;
import com.artland.service.BlogService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
@Service
public class BlogServiceImpl implements BlogService {

	@Autowired
	private BlogMapper blogMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private TagMapper tagMapper;
	@Autowired
	private TagRelationMapper blogTagRelationMapper;
	@Autowired
	private CommentMapper blogCommentMapper;

	@Override
	@Transactional
	public String saveBlog(Blog blog) {
		Category blogCategory = categoryMapper.selectByPrimaryKey(blog.getCategoryId());
		if (blogCategory == null) {
			blog.setCategoryId(0);
			blog.setCategoryName("默认分类");
		} else {
			//设置博客分类名称
			blog.setCategoryName(blogCategory.getName());
			//分类的排序值加1
			blogCategory.setRank(blogCategory.getRank() + 1);
		}
		//处理标签数据
		String[] tags = blog.getTags().split(",");
		if (tags.length > 6) {
			return "标签数量限制为6";
		}
		//保存文章
		if (blogMapper.insertSelective(blog) > 0) {
			//新增的tag对象
			List<Tag> tagListForInsert = new ArrayList<>();
			//所有的tag对象，用于建立关系数据
			List<Tag> allTagsList = new ArrayList<>();
			for (int i = 0; i < tags.length; i++) {
				Tag tag = tagMapper.selectByTagName(tags[i]);
				if (tag == null) {
					//不存在就新增
					Tag tempTag = new Tag();
					tempTag.setName(tags[i]);
					tagListForInsert.add(tempTag);
				} else {
					allTagsList.add(tag);
				}
			}
			//新增标签数据并修改分类排序值
			if (!CollectionUtils.isEmpty(tagListForInsert)) {
				tagMapper.batchInsertBlogTag(tagListForInsert);
			}
			categoryMapper.updateByPrimaryKeySelective(blogCategory);
			List<TagRelation> blogTagRelations = new ArrayList<>();
			//新增关系数据
			allTagsList.addAll(tagListForInsert);
			for (Tag tag : allTagsList) {
				TagRelation blogTagRelation = new TagRelation();
				blogTagRelation.setBlogId(blog.getId());
				blogTagRelation.setTagId(tag.getId());
				blogTagRelations.add(blogTagRelation);
			}
			if (blogTagRelationMapper.batchInsert(blogTagRelations) > 0) {
				return "success";
			}
		}
		return "保存失败";
	}

	@Override
	public PageResult getBlogsPage(PageQueryUtil pageUtil) {
		List<Blog> blogList = blogMapper.findBlogList(pageUtil);
		int total = blogMapper.getTotalBlogs(pageUtil);
		PageResult pageResult = new PageResult(blogList, total, pageUtil.getLimit(), pageUtil.getPage());
		return pageResult;
	}

	@Override
	public Boolean deleteBatch(Integer[] ids) {
		return blogMapper.deleteBatch(ids) > 0;
	}

	@Override
	public int getTotalBlogs() {
		return blogMapper.getTotalBlogs(null);
	}

	@Override
	public Blog getBlogById(Long blogId) {
		return blogMapper.selectByPrimaryKey(blogId);
	}

	@Override
	@Transactional
	public String updateBlog(Blog blog) {
		Blog blogForUpdate = blogMapper.selectByPrimaryKey(blog.getId());
		if (blogForUpdate == null) {
			return "数据不存在";
		}
		blogForUpdate.setTitle(blog.getTitle());
		blogForUpdate.setSubUrl(blog.getSubUrl());
		blogForUpdate.setContent(blog.getContent());
		blogForUpdate.setCoverImage(blog.getCoverImage());
		blogForUpdate.setStatus(blog.getStatus());
		blogForUpdate.setEnableComment(blog.getEnableComment());
		Category blogCategory = categoryMapper.selectByPrimaryKey(blog.getCategoryId());
		if (blogCategory == null) {
			blogForUpdate.setCategoryId(0);
			blogForUpdate.setCategoryName("默认分类");
		} else {
			//设置博客分类名称
			blogForUpdate.setCategoryName(blogCategory.getName());
			blogForUpdate.setCategoryId(blogCategory.getId());
			//分类的排序值加1
			blogCategory.setRank(blogCategory.getRank() + 1);
		}
		//处理标签数据
		String[] tags = blog.getTags().split(",");
		if (tags.length > 6) {
			return "标签数量限制为6";
		}
		blogForUpdate.setTags(blog.getTags());
		//新增的tag对象
		List<Tag> tagListForInsert = new ArrayList<>();
		//所有的tag对象，用于建立关系数据
		List<Tag> allTagsList = new ArrayList<>();
		for (int i = 0; i < tags.length; i++) {
			Tag tag = tagMapper.selectByTagName(tags[i]);
			if (tag == null) {
				//不存在就新增
				Tag tempTag = new Tag();
				tempTag.setName(tags[i]);
				tagListForInsert.add(tempTag);
			} else {
				allTagsList.add(tag);
			}
		}
		//新增标签数据不为空->新增标签数据
		if (!CollectionUtils.isEmpty(tagListForInsert)) {
			tagMapper.batchInsertBlogTag(tagListForInsert);
		}
		List<TagRelation> blogTagRelations = new ArrayList<>();
		//新增关系数据
		allTagsList.addAll(tagListForInsert);
		for (Tag tag : allTagsList) {
			TagRelation blogTagRelation = new TagRelation();
			blogTagRelation.setBlogId(blog.getId());
			blogTagRelation.setTagId(tag.getId());
			blogTagRelations.add(blogTagRelation);
		}
		//修改blog信息->修改分类排序值->删除原关系数据->保存新的关系数据
		categoryMapper.updateByPrimaryKeySelective(blogCategory);
		blogTagRelationMapper.deleteByBlogId(blog.getId());
		blogTagRelationMapper.batchInsert(blogTagRelations);
		if (blogMapper.updateByPrimaryKeySelective(blogForUpdate) > 0) {
			return "success";
		}
		return "修改失败";
	}

	@Override
	public PageResult getBlogsForIndexPage(int page) {
		Map params = new HashMap();
		params.put("page", page);
		//每页8条
		params.put("limit", 8);
		params.put("blogStatus", 1);//过滤发布状态下的数据
		PageQueryUtil pageUtil = new PageQueryUtil(params);
		List<Blog> blogList = blogMapper.findBlogList(pageUtil);
		List<BlogListVO> blogListVOS = getBlogListVOsByBlogs(blogList);
		int total = blogMapper.getTotalBlogs(pageUtil);
		PageResult pageResult = new PageResult(blogListVOS, total, pageUtil.getLimit(), pageUtil.getPage());
		return pageResult;
	}

	@Override
	public List<SimpleBlogListVO> getBlogListForIndexPage(int type) {
		List<SimpleBlogListVO> simpleBlogListVOS = new ArrayList<>();
		List<Blog> blogs = blogMapper.findBlogListByType(type, 9);
		if (!CollectionUtils.isEmpty(blogs)) {
			for (Blog blog : blogs) {
				SimpleBlogListVO simpleBlogListVO = new SimpleBlogListVO();
				BeanUtils.copyProperties(blog, simpleBlogListVO);
				simpleBlogListVOS.add(simpleBlogListVO);
			}
		}
		return simpleBlogListVOS;
	}

	@Override
	public BlogDetailVO getBlogDetail(Long id) {
		Blog blog = blogMapper.selectByPrimaryKey(id);
		//不为空且状态为已发布
		BlogDetailVO blogDetailVO = getBlogDetailVO(blog);
		if (blogDetailVO != null) {
			return blogDetailVO;
		}
		return null;
	}

	@Override
	public PageResult getBlogsPageByTag(String tagName, int page) {
		if (PatternUtil.validKeyword(tagName)) {
			Tag tag = tagMapper.selectByTagName(tagName);
			if (tag != null && page > 0) {
				Map param = new HashMap();
				param.put("page", page);
				param.put("limit", 9);
				param.put("tagId", tag.getId());
				PageQueryUtil pageUtil = new PageQueryUtil(param);
				List<Blog> blogList = blogMapper.getBlogsPageByTagId(pageUtil);
				List<BlogListVO> blogListVOS = getBlogListVOsByBlogs(blogList);
				int total = blogMapper.getTotalBlogsByTagId(pageUtil);
				PageResult pageResult = new PageResult(blogListVOS, total, pageUtil.getLimit(), pageUtil.getPage());
				return pageResult;
			}
		}
		return null;
	}

	@Override
	public PageResult getBlogsPageByCategory(String categoryName, int page) {
		if (PatternUtil.validKeyword(categoryName)) {
			Category blogCategory = categoryMapper.selectByCategoryName(categoryName);
			if ("默认分类".equals(categoryName) && blogCategory == null) {
				blogCategory = new Category();
				blogCategory.setId(0);
			}
			if (blogCategory != null && page > 0) {
				Map param = new HashMap();
				param.put("page", page);
				param.put("limit", 9);
				param.put("blogCategoryId", blogCategory.getId());
				param.put("blogStatus", 1);//过滤发布状态下的数据
				PageQueryUtil pageUtil = new PageQueryUtil(param);
				List<Blog> blogList = blogMapper.findBlogList(pageUtil);
				List<BlogListVO> blogListVOS = getBlogListVOsByBlogs(blogList);
				int total = blogMapper.getTotalBlogs(pageUtil);
				PageResult pageResult = new PageResult(blogListVOS, total, pageUtil.getLimit(), pageUtil.getPage());
				return pageResult;
			}
		}
		return null;
	}

	@Override
	public PageResult getBlogsPageBySearch(String keyword, int page) {
		if (page > 0 && PatternUtil.validKeyword(keyword)) {
			Map param = new HashMap();
			param.put("page", page);
			param.put("limit", 9);
			param.put("keyword", keyword);
			param.put("blogStatus", 1);//过滤发布状态下的数据
			PageQueryUtil pageUtil = new PageQueryUtil(param);
			List<Blog> blogList = blogMapper.findBlogList(pageUtil);
			List<BlogListVO> blogListVOS = getBlogListVOsByBlogs(blogList);
			int total = blogMapper.getTotalBlogs(pageUtil);
			PageResult pageResult = new PageResult(blogListVOS, total, pageUtil.getLimit(), pageUtil.getPage());
			return pageResult;
		}
		return null;
	}

	@Override
	public BlogDetailVO getBlogDetailBySubUrl(String subUrl) {
		Blog blog = blogMapper.selectBySubUrl(subUrl);
		//不为空且状态为已发布
		BlogDetailVO blogDetailVO = getBlogDetailVO(blog);
		if (blogDetailVO != null) {
			return blogDetailVO;
		}
		return null;
	}

	/**
	 * 方法抽取
	 *
	 * @param blog
	 * @return
	 */
	private BlogDetailVO getBlogDetailVO(Blog blog) {
		if (blog != null && blog.getStatus() == 1) {
			//增加浏览量
			blog.setViews(blog.getViews() + 1);
			blogMapper.updateByPrimaryKey(blog);
			BlogDetailVO blogDetailVO = new BlogDetailVO();
			BeanUtils.copyProperties(blog, blogDetailVO);
			blogDetailVO.setContent(MarkDownUtil.mdToHtml(blogDetailVO.getContent()));
			Category blogCategory = categoryMapper.selectByPrimaryKey(blog.getCategoryId());
			if (blogCategory == null) {
				blogCategory = new Category();
				blogCategory.setId(0);
				blogCategory.setName("默认分类");
				blogCategory.setIcon("/admin/dist/img/category/00.png");
			}
			//分类信息
			blogDetailVO.setCategoryIcon(blogCategory.getIcon());
			if (!StringUtils.isEmpty(blog.getTags())) {
				//标签设置
				List<String> tags = Arrays.asList(blog.getTags().split(","));
				blogDetailVO.setTags(tags);
			}
			//设置评论数
			Map params = new HashMap();
			params.put("blogId", blog.getId());
			params.put("commentStatus", 1);//过滤审核通过的数据
			blogDetailVO.setCommentCount(blogCommentMapper.getTotalBlogComments(params));
			return blogDetailVO;
		}
		return null;
	}

	private List<BlogListVO> getBlogListVOsByBlogs(List<Blog> blogList) {
		List<BlogListVO> blogListVOS = new ArrayList<>();
		if (!CollectionUtils.isEmpty(blogList)) {
			List<Integer> categoryIds = blogList.stream().map(Blog::getCategoryId).collect(Collectors.toList());
			Map<Integer, String> blogCategoryMap = new HashMap<>();
			if (!CollectionUtils.isEmpty(categoryIds)) {
				List<Category> blogCategories = categoryMapper.selectByCategoryIds(categoryIds);
				if (!CollectionUtils.isEmpty(blogCategories)) {
					blogCategoryMap = blogCategories.stream().collect(Collectors.toMap(Category::getId, Category::getIcon, (key1, key2) -> key2));
				}
			}
			for (Blog blog : blogList) {
				BlogListVO blogListVO = new BlogListVO();
				BeanUtils.copyProperties(blog, blogListVO);
				if (blogCategoryMap.containsKey(blog.getCategoryId())) {
					blogListVO.setCategoryIcon(blogCategoryMap.get(blog.getCategoryId()));
				} else {
					blogListVO.setCategoryId(0);
					blogListVO.setCategoryName("默认分类");
					blogListVO.setCategoryIcon("/admin/dist/img/category/00.png");
				}
				blogListVOS.add(blogListVO);
			}
		}
		return blogListVOS;
	}

}
