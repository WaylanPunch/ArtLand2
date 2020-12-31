package com.artland.dao;

import com.artland.entity.BlogConfig;

import java.util.List;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
public interface BlogConfigMapper {
    List<BlogConfig> selectAll();

    BlogConfig selectByPrimaryKey(String configName);

    int updateByPrimaryKeySelective(BlogConfig record);

}