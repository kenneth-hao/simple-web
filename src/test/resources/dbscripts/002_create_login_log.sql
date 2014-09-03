CREATE TABLE `t_login_log` (
  `login_log_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '日志 Id ',
  `user_id` int(11) NOT NULL DEFAULT '0' COMMENT '发布者 Id ',
  `ip` varchar(30) NOT NULL COMMENT '登陆 IP ',
  `login_datetime` datetime NOT NULL COMMENT '登陆时间',
  PRIMARY KEY (`login_log_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;