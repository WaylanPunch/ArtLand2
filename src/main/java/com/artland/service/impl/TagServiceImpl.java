package com.artland.service.impl;

import com.artland.dao.TagMapper;
import com.artland.dao.TagRelationMapper;
import com.artland.entity.*;
import com.artland.service.TagService;
import com.artland.util.PageQueryUtil;
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
public class TagServiceImpl implements TagService {

	@Autowired
	private TagMapper tagMapper;

	@Autowired
	private TagRelationMapper tagRelationMapper;

	/**
	 * 查询标签的分页数据
	 *
	 * @param pageIndex
	 * @param pageSize
	 * @param userId
	 * @return
	 */
	@Override
	public PageResult getTagsByPage(int pageIndex, int pageSize, Integer userId) {
		TagExample tagExample = new TagExample();
		TagExample.Criteria criteria = tagExample.createCriteria();
		criteria.andUserIdEqualTo(userId);

		int offset = (pageIndex - 1) * pageSize;
		RowBounds rowBounds = new RowBounds(offset, pageSize);

		List<Tag> tags = tagMapper.selectByExampleWithRowbounds(tagExample, rowBounds);
		long totalCount = tagMapper.countByExample(tagExample);

		PageResult pageResult = new PageResult(tags, totalCount, pageSize, pageIndex);

		return pageResult;
	}

	/**
	 * 查询标签的总数目
	 *
	 * @return
	 */
	@Override
	public long getTagsCount(Integer userId) {
		TagExample tagExample = new TagExample();
		TagExample.Criteria criteria = tagExample.createCriteria();
		criteria.andUserIdEqualTo(userId);
		return tagMapper.countByExample(tagExample);
	}

	/**
	 * 新建/更新标签
	 *
	 * @param name
	 * @param userId
	 * @return
	 */
	@Override
	public Boolean saveTag(String name, Integer userId) {
		TagExample tagExample = new TagExample();
		TagExample.Criteria criteria = tagExample.createCriteria();
		criteria.andNameEqualTo(name);
		criteria.andUserIdEqualTo(userId);
		List<Tag> tags = tagMapper.selectByExample(tagExample);
		if (CollectionUtils.isEmpty(tags)) {
			Tag tag = new Tag();
			tag.setName(name);
			tag.setCreateTime(new Date());
			tag.setIsDeleted((byte) 0);
			tag.setUserId(userId);
			return tagMapper.insertSelective(tag) > 0;
		}
		return false;
	}

	/**
	 * 根据Id删除标签
	 *
	 * @param id
	 * @return
	 */
	@Override
	public Boolean deleteTagById(Integer id) {
		//已存在关联关系不删除
		TagRelationExample tagRelationExample = new TagRelationExample();
		TagRelationExample.Criteria criteria = tagRelationExample.createCriteria();
		criteria.andTagIdEqualTo(id);
		List<TagRelation> tagRelations = tagRelationMapper.selectByExample(tagRelationExample);
		if (!CollectionUtils.isEmpty(tagRelations)) {
			return false;
		}
		return tagMapper.deleteTagById(id) > 0;
	}

	/**
	 * 根据多个Id批量删除标签
	 *
	 * @param ids
	 * @return
	 */
	@Override
	public Boolean deleteTagsByIds(Integer[] ids) {
		//已存在关联关系不删除
		List<Integer> relations = tagRelationMapper.selectDistinctTagsByIds(ids);
		if (!CollectionUtils.isEmpty(relations)) {
			return false;
		}
		//删除tag
		return tagMapper.deleteTagsByIds(ids) > 0;
	}
}
