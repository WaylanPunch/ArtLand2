package com.artland.service;


import com.artland.controller.vo.MediaDetailVO;
import com.artland.controller.vo.SimpleMediaListVO;
import com.artland.entity.Media;
import com.artland.util.PageQueryUtil;
import com.artland.util.PageResult;

import java.util.List;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
public interface MediaService {

	/**
	 * 保存文件信息
	 * @param media
	 * @return
	 */
	String saveMedia(Media media);

	/**
	 * 文件数据翻页
	 * @param pageUtil
	 * @return
	 */
	PageResult getMediasPage(PageQueryUtil pageUtil);

	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	Boolean deleteBatch(Integer[] ids);

	/**
	 * 获取文件总数
	 * @return
	 */
	int getTotalMedias();

	/**
	 * 根据id获取文件详情
	 *
	 * @param mediaId
	 * @return
	 */
	Media getMediaById(Long mediaId);

	/**
	 * 后台修改文件数据
	 *
	 * @param media
	 * @return
	 */
	String updateMedia(Media media);

	/**
	 * 获取首页文件列表
	 *
	 * @param page
	 * @return
	 */
	PageResult getMediasForIndexPage(int page);

	/**
	 * 首页侧边栏数据列表
	 * 0-点击最多 1-最新发布
	 *
	 * @param type
	 * @return
	 */
	List<SimpleMediaListVO> getMediaListForIndexPage(int type);

	/**
	 * 文件详情
	 *
	 * @param mediaId
	 * @return
	 */
	MediaDetailVO getMediaDetail(Long mediaId);

	/**
	 * 根据标签获取文件列表
	 *
	 * @param tagName
	 * @param page
	 * @return
	 */
	PageResult getMediasPageByTag(String tagName, int page);

	/**
	 * 根据分类获取文件列表
	 *
	 * @param categoryId
	 * @param page
	 * @return
	 */
	PageResult getMediasPageByCategory(String categoryId, int page);

	/**
	 * 根据搜索获取文件列表
	 *
	 * @param keyword
	 * @param page
	 * @return
	 */
	PageResult getMediasPageBySearch(String keyword, int page);

	/**
	 *
	 * @param subUrl
	 * @return
	 */
	MediaDetailVO getMediaDetailBySubUrl(String subUrl);
}
