package com.artland.service.impl;

import com.artland.controller.vo.MediaDetailVO;
import com.artland.controller.vo.SimpleMediaListVO;
import com.artland.dao.CategoryMapper;
import com.artland.dao.CommentMapper;
import com.artland.dao.TagMapper;
import com.artland.dao.TagRelationMapper;
import com.artland.entity.Category;
import com.artland.entity.Tag;
import com.artland.entity.TagRelation;
import com.artland.entity.Media;
import com.artland.service.MediaService;
import com.artland.util.PageQueryUtil;
import com.artland.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
@Service
public class MediaServiceImpl implements MediaService {
	@Autowired
	private MediaMapper mediaMapper;
	@Autowired
	private CategoryMapper categoryMapper;
	@Autowired
	private TagMapper tagMapper;
	@Autowired
	private TagRelationMapper blogTagRelationMapper;
	@Autowired
	private CommentMapper blogCommentMapper;

	/**
	 * 保存文件信息
	 * @param media
	 * @return
	 */
	@Transactional
	@Override
	public String saveMedia(Media media) {
		Category blogCategory = categoryMapper.selectByPrimaryKey(media.getCategoryId());
		if (blogCategory == null) {
			media.setCategoryId(0);
			media.setCategoryName("默认分类");
		} else {
			//设置博客分类名称
			media.setCategoryName(blogCategory.getName());
			//分类的排序值加1
			blogCategory.setRank(blogCategory.getRank() + 1);
		}
		//处理标签数据
		String[] tags = media.getTags().split(",");
		if (tags.length > 6) {
			return "标签数量限制为6";
		}
		//保存文章
		if (mediaMapper.insertSelective(media) > 0) {
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
				blogTagRelation.setBlogId(media.getId());
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
	public PageResult getMediasPage(PageQueryUtil pageUtil) {
		return null;
	}

	@Override
	public Boolean deleteBatch(Integer[] ids) {
		return null;
	}

	@Override
	public int getTotalMedias() {
		return 0;
	}

	@Override
	public Media getMediaById(Long mediaId) {
		return null;
	}

	@Override
	public String updateMedia(Media media) {
		return null;
	}

	@Override
	public PageResult getMediasForIndexPage(int page) {
		return null;
	}

	@Override
	public List<SimpleMediaListVO> getMediaListForIndexPage(int type) {
		return null;
	}

	@Override
	public MediaDetailVO getMediaDetail(Long mediaId) {
		return null;
	}

	@Override
	public PageResult getMediasPageByTag(String tagName, int page) {
		return null;
	}

	@Override
	public PageResult getMediasPageByCategory(String categoryId, int page) {
		return null;
	}

	@Override
	public PageResult getMediasPageBySearch(String keyword, int page) {
		return null;
	}

	@Override
	public MediaDetailVO getMediaDetailBySubUrl(String subUrl) {
		return null;
	}
}
