package com.artland.service;

import com.artland.entity.Comment;
import com.artland.util.PageQueryUtil;
import com.artland.util.PageResult;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
public interface CommentService {
	/**
	 * 添加评论
	 *
	 * @param blogComment
	 * @return
	 */
	Boolean addComment(Comment blogComment);

	/**
	 * 后台管理系统中评论分页功能
	 *
	 * @param pageUtil
	 * @return
	 */
	PageResult getCommentsPage(PageQueryUtil pageUtil);

	int getTotalComments();

	/**
	 * 批量审核
	 *
	 * @param ids
	 * @return
	 */
	Boolean checkDone(Integer[] ids);

	/**
	 * 批量删除
	 *
	 * @param ids
	 * @return
	 */
	Boolean deleteBatch(Integer[] ids);

	/**
	 * 添加回复
	 *
	 * @param commentId
	 * @param replyBody
	 * @return
	 */
	Boolean reply(Long commentId, String replyBody);

	/**
	 * 根据文章id和分页参数获取文章的评论列表
	 *
	 * @param blogId
	 * @param page
	 * @return
	 */
	PageResult getCommentPageByBlogIdAndPageNum(Long blogId, int page);
}
