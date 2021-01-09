package com.artland.service;

import com.artland.entity.TagCount;
import com.artland.util.PageResult;

import java.util.List;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
public interface TagCountService {


	/**
	 *
	 * @return
	 */
	List<TagCount> getTagCountsForBlog(Integer userId);

	/**
	 *
	 * @return
	 */
	List<TagCount> getTagCountsForMedia(Integer userId);
}
