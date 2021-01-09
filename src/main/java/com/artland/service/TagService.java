package com.artland.service;

import com.artland.util.PageQueryUtil;
import com.artland.util.PageResult;
import com.artland.entity.TagCount;

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
	 * @param pageIndex
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	PageResult getTagsByPage(int pageIndex, int pageSize, Integer userId);

	/**
	 * 查询标签的总数目
	 *
	 * @return
	 */
	long getTagsCount(Integer userId);

	/**
	 * 新建/更新标签
	 *
	 * @param name
	 * @param userId
	 * @return
	 */
	Boolean saveTag(String name, Integer userId);

	/**
	 * 根据Id删除标签
	 * @param id
	 * @return
	 */
	Boolean deleteTagById(Integer id);

	/**
	 * 根据多个Id批量删除标签
	 * @param ids
	 * @return
	 */
	Boolean deleteTagsByIds(Integer[] ids);

}
