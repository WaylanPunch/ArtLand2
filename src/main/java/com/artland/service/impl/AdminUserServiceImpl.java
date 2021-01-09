package com.artland.service.impl;

import com.artland.dao.UserMapper;
import com.artland.entity.User;
import com.artland.service.AdminUserService;
import com.artland.util.MD5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Resource
	private UserMapper adminUserMapper;

	@Override
	public User login(String userName, String password) {
		String passwordMd5 = MD5Util.MD5Encode(password, "UTF-8");
		return adminUserMapper.login(userName, passwordMd5);
	}

	@Override
	public User getUserDetailById(Integer loginUserId) {
		return adminUserMapper.selectByPrimaryKey(loginUserId);
	}

	@Override
	public Boolean updatePassword(Integer loginUserId, String originalPassword, String newPassword) {
		User adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
		//当前用户非空才可以进行更改
		if (adminUser != null) {
			String originalPasswordMd5 = MD5Util.MD5Encode(originalPassword, "UTF-8");
			String newPasswordMd5 = MD5Util.MD5Encode(newPassword, "UTF-8");
			//比较原密码是否正确
			if (originalPasswordMd5.equals(adminUser.getPassword())) {
				//设置新密码并修改
				adminUser.setPassword(newPasswordMd5);
				if (adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0) {
					//修改成功则返回true
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Boolean updateName(Integer loginUserId, String loginUserName, String nickName) {
		User adminUser = adminUserMapper.selectByPrimaryKey(loginUserId);
		//当前用户非空才可以进行更改
		if (adminUser != null) {
			//修改信息
			adminUser.setLoginUserName(loginUserName);
			adminUser.setNickName(nickName);
			if (adminUserMapper.updateByPrimaryKeySelective(adminUser) > 0) {
				//修改成功则返回true
				return true;
			}
		}
		return false;
	}
}
