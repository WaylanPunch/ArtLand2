package com.artland.service.impl;

import com.artland.dao.LinkMapper;
import com.artland.entity.Link;
import com.artland.service.LinkService;
import com.artland.util.PageQueryUtil;
import com.artland.util.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author WaylanPunch
 * @email waylanpunch@gmail.com
 * @link https://github.com/WaylanPunch
 * @date 2017-10-31
 */
@Service
public class LinkServiceImpl implements LinkService {

	@Autowired
	private LinkMapper blogLinkMapper;

	@Override
	public PageResult getBlogLinkPage(PageQueryUtil pageUtil) {
		List<Link> links = blogLinkMapper.findLinkList(pageUtil);
		int total = blogLinkMapper.getTotalLinks(pageUtil);
		PageResult pageResult = new PageResult(links, total, pageUtil.getLimit(), pageUtil.getPage());
		return pageResult;
	}

	@Override
	public int getTotalLinks() {
		return blogLinkMapper.getTotalLinks(null);
	}

	@Override
	public Boolean saveLink(Link link) {
		return blogLinkMapper.insertSelective(link) > 0;
	}

	@Override
	public Link selectById(Integer id) {
		return blogLinkMapper.selectByPrimaryKey(id);
	}

	@Override
	public Boolean updateLink(Link tempLink) {
		return blogLinkMapper.updateByPrimaryKeySelective(tempLink) > 0;
	}

	@Override
	public Boolean deleteBatch(Integer[] ids) {
		return blogLinkMapper.deleteBatch(ids) > 0;
	}

	@Override
	public Map<Byte, List<Link>> getLinksForLinkPage() {
		//获取所有链接数据
		List<Link> links = blogLinkMapper.findLinkList(null);
		if (!CollectionUtils.isEmpty(links)) {
			//根据type进行分组
			Map<Byte, List<Link>> linksMap = links.stream().collect(Collectors.groupingBy(Link::getType));
			return linksMap;
		}
		return null;
	}
}
