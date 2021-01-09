USE `artland_db`;


CREATE TABLE `tb_user` (
                           `id` int NOT NULL AUTO_INCREMENT COMMENT '管理员id',
                           `username` varchar(50) NOT NULL COMMENT '管理员登陆名称',
                           `password` varchar(50) NOT NULL COMMENT '管理员登陆密码',
                           `nickname` varchar(50) NOT NULL COMMENT '管理员显示昵称',
                           `locked` tinyint DEFAULT '0' COMMENT '是否锁定 0未锁定 1已锁定无法登陆',
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_blog` (
                           `id` bigint NOT NULL AUTO_INCREMENT COMMENT '博客表主键id',
                           `title` varchar(200) NOT NULL COMMENT '博客标题',
                           `sub_url` varchar(200) NOT NULL COMMENT '博客自定义路径url',
                           `cover_image` varchar(200) NOT NULL COMMENT '博客封面图',
                           `content` mediumtext NOT NULL COMMENT '博客内容',
                           `category_id` int NOT NULL COMMENT '博客分类id',
                           `category_name` varchar(50) NOT NULL COMMENT '博客分类(冗余字段)',
                           `tags` varchar(200) NOT NULL COMMENT '博客标签',
                           `status` tinyint NOT NULL DEFAULT '0' COMMENT '0-草稿 1-发布',
                           `views` bigint NOT NULL DEFAULT '0' COMMENT '阅读量',
                           `enable_comment` tinyint NOT NULL DEFAULT '0' COMMENT '0-允许评论 1-不允许评论',
                           `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
                           `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
                           `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                           `user_id` int DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


CREATE TABLE `tb_comment` (
                              `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
                              `blog_id` bigint NOT NULL DEFAULT '0' COMMENT '关联的blog主键',
                              `media_id` bigint DEFAULT NULL,
                              `commentator` varchar(50) NOT NULL DEFAULT '' COMMENT '评论者名称',
                              `email` varchar(100) NOT NULL DEFAULT '' COMMENT '评论人的邮箱',
                              `website_url` varchar(50) NOT NULL DEFAULT '' COMMENT '网址',
                              `comment_body` varchar(200) NOT NULL DEFAULT '' COMMENT '评论内容',
                              `comment_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论提交时间',
                              `commentator_ip` varchar(20) NOT NULL DEFAULT '' COMMENT '评论时的ip地址',
                              `reply_body` varchar(200) NOT NULL DEFAULT '' COMMENT '回复内容',
                              `reply_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '回复时间',
                              `comment_status` tinyint NOT NULL DEFAULT '0' COMMENT '是否审核通过 0-未审核 1-审核通过',
                              `is_deleted` tinyint DEFAULT '0' COMMENT '是否删除 0-未删除 1-已删除',
                              `user_id` int DEFAULT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_category` (
                               `id` int NOT NULL AUTO_INCREMENT COMMENT '分类表主键',
                               `name` varchar(50) NOT NULL COMMENT '分类的名称',
                               `icon` varchar(50) NOT NULL COMMENT '分类的图标',
                               `rank` int NOT NULL DEFAULT '1' COMMENT '分类的排序值 被使用的越多数值越大',
                               `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
                               `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                               `user_id` int DEFAULT NULL COMMENT '用户ID',
                               PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;


CREATE TABLE `tb_config` (
                             `name` varchar(100) NOT NULL DEFAULT '' COMMENT '配置项的名称',
                             `value` varchar(200) NOT NULL DEFAULT '' COMMENT '配置项的值',
                             `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                             `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                             `user_id` int DEFAULT NULL,
                             PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_link` (
                           `id` int NOT NULL AUTO_INCREMENT COMMENT '友链表主键id',
                           `type` tinyint NOT NULL DEFAULT '0' COMMENT '友链类别 0-友链 1-推荐 2-个人网站',
                           `name` varchar(50) NOT NULL COMMENT '网站名称',
                           `url` varchar(100) NOT NULL COMMENT '网站链接',
                           `description` varchar(100) NOT NULL COMMENT '网站描述',
                           `rank` int NOT NULL DEFAULT '0' COMMENT '用于列表排序',
                           `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除 0-未删除 1-已删除',
                           `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
                           `user_id` int DEFAULT NULL,
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_media` (
                            `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'media表主键id',
                            `title` varchar(256) NOT NULL COMMENT 'media标题',
                            `sub_url` varchar(256) NOT NULL COMMENT 'media自定义路径url',
                            `cover_image` varchar(256) NOT NULL COMMENT 'media封面图',
                            `description` varchar(512) NOT NULL COMMENT 'media描述',
                            `content` varchar(1024) NOT NULL COMMENT 'media内容',
                            `dimension` varchar(12) NOT NULL COMMENT 'media尺寸',
                            `resolution` varchar(12) NOT NULL COMMENT 'media分辨率',
                            `format` varchar(12) NOT NULL COMMENT 'media格式',
                            `duration` varchar(12) NOT NULL COMMENT 'media时长',
                            `size` varchar(12) DEFAULT NULL,
                            `license` varchar(512) NOT NULL COMMENT 'media证书',
                            `status` tinyint NOT NULL DEFAULT '0' COMMENT '0-草稿 1-发布',
                            `price` decimal(8,2) DEFAULT NULL COMMENT 'media价格',
                            `purchases` bigint DEFAULT NULL COMMENT '购买次数',
                            `views` bigint NOT NULL DEFAULT '0' COMMENT '阅读量',
                            `downloads` bigint DEFAULT NULL COMMENT '下载次数',
                            `category_id` int NOT NULL COMMENT 'media分类id',
                            `category_name` varchar(50) NOT NULL COMMENT 'media分类(冗余字段)',
                            `tags` varchar(200) NOT NULL COMMENT 'media标签',
                            `enable_comment` tinyint NOT NULL DEFAULT '0' COMMENT '0-允许评论 1-不允许评论',
                            `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
                            `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
                            `update_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '修改时间',
                            `user_id` int DEFAULT NULL,
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `tb_tag` (
                          `id` int NOT NULL AUTO_INCREMENT COMMENT '标签表主键id',
                          `name` varchar(100) NOT NULL COMMENT '标签名称',
                          `is_deleted` tinyint NOT NULL DEFAULT '0' COMMENT '是否删除 0=否 1=是',
                          `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                          `user_id` int DEFAULT NULL,
                          PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=137 DEFAULT CHARSET=utf8;

CREATE TABLE `tb_tag_relation` (
                                   `id` bigint NOT NULL AUTO_INCREMENT COMMENT '关系表id',
                                   `blog_id` bigint NOT NULL COMMENT '博客id',
                                   `media_id` bigint DEFAULT NULL,
                                   `tag_id` int NOT NULL COMMENT '标签id',
                                   `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '添加时间',
                                   `user_id` int DEFAULT NULL,
                                   PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=282 DEFAULT CHARSET=utf8;




