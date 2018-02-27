--如果表scuser存在，先删除表
DROP TABLE if EXISTS `scuser`;
--创建表：scuser
CREATE TABLE `scuser` (
`id`  int(11) NOT NULL AUTO_INCREMENT ,
`username`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`name`  varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL ,
`age`  int(11) NULL DEFAULT NULL ,
`balance`  decimal(10,2) NULL DEFAULT NULL ,
PRIMARY KEY (`id`)
);

--清空表scuser数据
DELETE from `scuser`;

--重新插入数据到scuser
INSERT INTO `scuser` (`username`, `name`, `age`, `balance`) VALUES ('account1', '张三', '20', '100.00');
INSERT INTO `scuser` (`username`, `name`, `age`, `balance`) VALUES ('account2', '李四', '28', '180.00');
INSERT INTO `scuser` (`username`, `name`, `age`, `balance`) VALUES ('account3', '王五', '32', '280.00');
