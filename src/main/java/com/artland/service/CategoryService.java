package com.artland.service;

import com.artland.entity.BlogCategory;
import com.artland.util.PageQueryUtil;
import com.artland.util.PageResult;

import java.util.List;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
public interface CategoryService {

	/**
	 * 查询分类的分页数据
	 *
	 * @param pageUtil
	 * @return
	 */
	PageResult getBlogCategoryPage(PageQueryUtil pageUtil);

	int getTotalCategories();

	/**
	 * 添加分类数据
	 *
	 * @param categoryName
	 * @param categoryIcon
	 * @return
	 */
	Boolean saveCategory(String categoryName, String categoryIcon);

	Boolean updateCategory(Integer categoryId, String categoryName, String categoryIcon);

	Boolean deleteBatch(Integer[] ids);

	List<BlogCategory> getAllCategories();
}
