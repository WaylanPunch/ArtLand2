package com.artland.service;

import com.artland.util.PageQueryUtil;
import com.artland.util.PageResult;
import com.artland.entity.BlogTagCount;

import java.util.List;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
public interface TagService {

	/**
	 * 查询标签的分页数据
	 *
	 * @param pageUtil
	 * @return
	 */
	PageResult getBlogTagPage(PageQueryUtil pageUtil);

	int getTotalTags();

	Boolean saveTag(String tagName);

	Boolean deleteBatch(Integer[] ids);

	List<BlogTagCount> getBlogTagCountForIndex();
}
