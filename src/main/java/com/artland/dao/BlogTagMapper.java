package com.artland.dao;

import com.artland.entity.BlogTag;
import com.artland.entity.BlogTagCount;
import com.artland.util.PageQueryUtil;
import java.util.List;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
public interface BlogTagMapper {
    int deleteByPrimaryKey(Integer tagId);

    int insert(BlogTag record);

    int insertSelective(BlogTag record);

    BlogTag selectByPrimaryKey(Integer tagId);

    BlogTag selectByTagName(String tagName);

    int updateByPrimaryKeySelective(BlogTag record);

    int updateByPrimaryKey(BlogTag record);

    List<BlogTag> findTagList(PageQueryUtil pageUtil);

    List<BlogTagCount> getTagCount();

    int getTotalTags(PageQueryUtil pageUtil);

    int deleteBatch(Integer[] ids);

    int batchInsertBlogTag(List<BlogTag> tagList);
}