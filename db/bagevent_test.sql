-- 创建数据库
CREATE DATABASE bagevent_test;

-- 使用数据库
USE bagevent_test;

-- 创建数据表
CREATE TABLE user(
`user_id` INT(11) NOT NULL AUTO_INCREMENT, 
`user_name` VARCHAR(50) NOT NULL COMMENT '用户名', 
`email` VARCHAR(64) NOT NULL COMMENT '邮箱（用户账户）', 
`cellphone` VARCHAR(100) NOT NULL COMMENT '电话（用户账户）', 
`password` VARCHAR(255) NOT NULL COMMENT '密码', 
`salt` VARCHAR(255), 
`state` BIT(1) NOT NULL COMMENT '0删除， 1正常', 
`create_time` TIMESTAMP,
PRIMARY KEY (`user_id`));

-- 创建用户登陆日志表
CREATE TABLE user_login_log(
`login_id` INT(11) NOT NULL AUTO_INCREMENT, 
`user_id` INT(11) NOT NULL COMMENT '用户表ID', 
`create_time` TIMESTAMP, 
`login_ip` VARCHAR(100) NOT NULL, 
PRIMARY KEY (`login_id`));
