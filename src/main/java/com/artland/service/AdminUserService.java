package com.artland.service;

import com.artland.entity.AdminUser;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
public interface AdminUserService {

	AdminUser login(String userName, String password);

	/**
	 * 获取用户信息
	 *
	 * @param loginUserId
	 * @return
	 */
	AdminUser getUserDetailById(Integer loginUserId);

	/**
	 * 修改当前登录用户的密码
	 *
	 * @param loginUserId
	 * @param originalPassword
	 * @param newPassword
	 * @return
	 */
	Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword);

	/**
	 * 修改当前登录用户的名称信息
	 *
	 * @param loginUserId
	 * @param loginUserName
	 * @param nickName
	 * @return
	 */
	Boolean updateName(Integer loginUserId, String loginUserName, String nickName);

}
