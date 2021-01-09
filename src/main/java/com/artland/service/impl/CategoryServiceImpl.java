package com.artland.service.impl;

import com.artland.dao.CategoryMapper;
import com.artland.dao.BlogMapper;
import com.artland.entity.Category;
import com.artland.util.PageQueryUtil;
import com.artland.util.PageResult;
import com.artland.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryMapper blogCategoryMapper;
	@Autowired
	private BlogMapper blogMapper;

	@Override
	public PageResult getBlogCategoryPage(PageQueryUtil pageUtil,Integer categoryUserId) {
		List<Category> categoryList = blogCategoryMapper.findCategoryList(pageUtil, categoryUserId);
		int total = blogCategoryMapper.getTotalCategories(pageUtil);
		PageResult pageResult = new PageResult(categoryList, total, pageUtil.getLimit(), pageUtil.getPage());
		return pageResult;
	}

	@Override
	public int getTotalCategories() {
		return blogCategoryMapper.getTotalCategories(null);
	}

	@Override
	public Boolean saveCategory(String categoryName, String categoryIcon) {
		Category temp = blogCategoryMapper.selectByCategoryName(categoryName);
		if (temp == null) {
			Category blogCategory = new Category();
			blogCategory.setName(categoryName);
			blogCategory.setIcon(categoryIcon);
			return blogCategoryMapper.insertSelective(blogCategory) > 0;
		}
		return false;
	}

	@Override
	@Transactional
	public Boolean updateCategory(Integer categoryId, String categoryName, String categoryIcon) {
		Category blogCategory = blogCategoryMapper.selectByPrimaryKey(categoryId);
		if (blogCategory != null) {
			blogCategory.setIcon(categoryIcon);
			blogCategory.setName(categoryName);
			//修改分类实体
			blogMapper.updateBlogCategorys(categoryName, blogCategory.getId(), new Integer[]{categoryId});
			return blogCategoryMapper.updateByPrimaryKeySelective(blogCategory) > 0;
		}
		return false;
	}

	@Override
	@Transactional
	public Boolean deleteBatch(Integer[] ids) {
		if (ids.length < 1) {
			return false;
		}
		//修改tb_blog表
		blogMapper.updateBlogCategorys("默认分类", 0, ids);
		//删除分类数据
		return blogCategoryMapper.deleteBatch(ids) > 0;
	}

	@Override
	public List<Category> getAllCategories() {
		return blogCategoryMapper.findCategoryList(null);
	}

}
