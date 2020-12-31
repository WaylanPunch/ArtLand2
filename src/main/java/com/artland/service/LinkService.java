package com.artland.service;

import com.artland.entity.BlogLink;
import com.artland.util.PageQueryUtil;
import com.artland.util.PageResult;

import java.util.List;
import java.util.Map;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
public interface LinkService {
	/**
	 * 查询友链的分页数据
	 *
	 * @param pageUtil
	 * @return
	 */
	PageResult getBlogLinkPage(PageQueryUtil pageUtil);

	int getTotalLinks();

	Boolean saveLink(BlogLink link);

	BlogLink selectById(Integer id);

	Boolean updateLink(BlogLink tempLink);

	Boolean deleteBatch(Integer[] ids);

	/**
	 * 返回友链页面所需的所有数据
	 *
	 * @return
	 */
	Map<Byte, List<BlogLink>> getLinksForLinkPage();
}
