package com.artland.service.impl;

import com.artland.dao.ConfigMapper;
import com.artland.entity.Config;
import com.artland.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
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
public class ConfigServiceImpl implements ConfigService {
	@Autowired
	private ConfigMapper configMapper;

	public static final String websiteName = "WAYLANPUNCH";
	public static final String websiteDescription = "WAYLANPUNCH是SpringBoot2+Thymeleaf+Mybatis建造的个人博客网站.SpringBoot实战博客源码.个人博客搭建";
	public static final String websiteLogo = "/admin/dist/img/logo2.png";
	public static final String websiteIcon = "/admin/dist/img/favicon.png";

	public static final String yourAvatar = "/admin/dist/img/13.png";
	public static final String yourEmail = "waylanpunch@gmail.com";
	public static final String yourName = "WaylanPunch";

	public static final String footerAbout = "A Blog Website.";
	public static final String footerICP = "浙ICP备 xxxxxx-x号";
	public static final String footerCopyRight = "@2017 WaylanPunch";
	public static final String footerPoweredBy = "WAYLANPUNCH";
	public static final String footerPoweredByURL = "https://github.com/WaylanPunch/";

	@Override
	public int updateConfig(String configName, String configValue) {
		Config blogConfig = configMapper.selectByPrimaryKey(configName);
		if (blogConfig != null) {
			blogConfig.setValue(configValue);
			blogConfig.setUpdateTime(new Date());
			return configMapper.updateByPrimaryKeySelective(blogConfig);
		}
		return 0;
	}

	@Override
	public Map<String, String> getAllConfigs() {
		//获取所有的map并封装为map
		List<Config> blogConfigs = configMapper.selectAll();
		Map<String, String> configMap = blogConfigs.stream().collect(Collectors.toMap(Config::getName, Config::getValue));
		for (Map.Entry<String, String> config : configMap.entrySet()) {
			if ("websiteName".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
				config.setValue(websiteName);
			}
			if ("websiteDescription".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
				config.setValue(websiteDescription);
			}
			if ("websiteLogo".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
				config.setValue(websiteLogo);
			}
			if ("websiteIcon".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
				config.setValue(websiteIcon);
			}
			if ("yourAvatar".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
				config.setValue(yourAvatar);
			}
			if ("yourEmail".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
				config.setValue(yourEmail);
			}
			if ("yourName".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
				config.setValue(yourName);
			}
			if ("footerAbout".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
				config.setValue(footerAbout);
			}
			if ("footerICP".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
				config.setValue(footerICP);
			}
			if ("footerCopyRight".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
				config.setValue(footerCopyRight);
			}
			if ("footerPoweredBy".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
				config.setValue(footerPoweredBy);
			}
			if ("footerPoweredByURL".equals(config.getKey()) && StringUtils.isEmpty(config.getValue())) {
				config.setValue(footerPoweredByURL);
			}
		}
		return configMap;
	}
}
