USE `artland_db`;


/*Table structure for table `tb_media` */

DROP TABLE IF EXISTS `tb_media`;

CREATE TABLE `tb_media` (
  `media_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'media表主键id',
  `media_title` varchar(256) NOT NULL COMMENT 'media标题',
  `media_sub_url` varchar(256) NOT NULL COMMENT 'media自定义路径url',
  `media_cover_image` varchar(256) NOT NULL COMMENT 'media封面图',
  `media_description` varchar(512) NOT NULL COMMENT 'media描述',
  `media_content` varchar(1024) NOT NULL COMMENT 'media内容',
  `media_dimension` varchar(12) NOT NULL COMMENT 'media尺寸',
  `media_resolution` varchar(12) NOT NULL COMMENT 'media分辨率',
  `media_format` varchar(12) NOT NULL COMMENT 'media格式',
  `media_duration` varchar(12) NOT NULL COMMENT 'media时长',
  `media_license` varchar(512) NOT NULL COMMENT 'media证书',
  `media_category_id` int(11) NOT NULL COMMENT 'media分类id',
  `media_category_name` varchar(50) NOT NULL COMMENT 'media分类(冗余字段)',
  `media_tags` varchar(200) NOT NULL COMMENT 'media标签',
  `media_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0-草稿 1-发布',
  `media_views` bigint(20) NOT NULL DEFAULT '0' COMMENT '阅读量',
  `enable_comment` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0-允许评论 1-不允许评论',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`media_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tb_media_category` */

DROP TABLE IF EXISTS `tb_media_category`;

CREATE TABLE `tb_media_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类表主键',
  `category_name` varchar(50) NOT NULL COMMENT '分类的名称',
  `category_icon` varchar(50) NOT NULL COMMENT '分类的图标',
  `category_rank` int(11) NOT NULL DEFAULT '1' COMMENT '分类的排序值 被使用的越多数值越大',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tb_media_comment` */

DROP TABLE IF EXISTS `tb_media_comment`;

CREATE TABLE `tb_media_comment` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `media_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '关联的media主键',
  `commentator` varchar(50) NOT NULL DEFAULT '' COMMENT '评论者名称',
  `email` varchar(100) NOT NULL DEFAULT '' COMMENT '评论人的邮箱',
  `website_url` varchar(50) NOT NULL DEFAULT '' COMMENT '网址',
  `comment_body` varchar(200) NOT NULL DEFAULT '' COMMENT '评论内容',
  `comment_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论提交时间',
  `commentator_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '评论时的ip地址',
  `reply_body` varchar(200) NOT NULL DEFAULT '' COMMENT '回复内容',
  `reply_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '回复时间',
  `comment_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否审核通过 0-未审核 1-审核通过',
  `is_deleted` tinyint(4) DEFAULT '0' COMMENT '是否删除 0-未删除 1-已删除',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Table structure for table `tb_media_tag` */

DROP TABLE IF EXISTS `tb_media_tag`;

CREATE TABLE `tb_media_tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签表主键id',
  `tag_name` varchar(100) NOT NULL COMMENT '标签名称',
  `is_deleted` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*Table structure for table `tb_media_tag_relation` */

DROP TABLE IF EXISTS `tb_media_tag_relation`;

CREATE TABLE `tb_media_tag_relation` (
  `relation_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '关系表id',
  `media_id` bigint(20) NOT NULL COMMENT 'mediaid',
  `tag_id` int(11) NOT NULL COMMENT '标签id',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
  PRIMARY KEY (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

