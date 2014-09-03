CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户 Id ',
  `user_name` varchar(30) NOT NULL COMMENT '用户名',
  `password` varchar(30) NOT NULL DEFAULT '' COMMENT '密码',
  `user_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '1:普通用户 2:管理员',
  `locked` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0:未锁定 1:锁定',
  `credit` int(11) DEFAULT NULL COMMENT '积分',
  PRIMARY KEY (`user_id`),
  KEY `AK_AK_USER_USER_NAME` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
