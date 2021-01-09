package com.artland.service.impl;

import com.artland.dao.TagMapper;
import com.artland.dao.TagRelationMapper;
import com.artland.entity.*;
import com.artland.service.TagCountService;
import com.artland.service.TagService;
import com.artland.util.PageResult;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
@Service
public class TagCountServiceImpl implements TagCountService {

	@Autowired
	private TagMapper tagMapper;

	@Override
	public List<TagCount> getTagCountsForBlog(Integer userId) {
		return tagMapper.selectTagCountsForBlog(userId);
	}

	@Override
	public List<TagCount> getTagCountsForMedia(Integer userId) {
		return tagMapper.selectTagCountsForMedia(userId);
	}
}
