/*
Navicat MySQL Data Transfer

Source Server         : Account
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : 疫情上报系统

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-03-18 17:07:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collegeadmin
-- ----------------------------
DROP TABLE IF EXISTS `collegeadmin`;
CREATE TABLE `collegeadmin` (
  `id` int(100) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `college` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collegeadmin
-- ----------------------------
INSERT INTO `collegeadmin` VALUES ('1', 'admin1', '123', '计算机');
INSERT INTO `collegeadmin` VALUES ('2', 'admin', '123', '设计学院');
INSERT INTO `collegeadmin` VALUES ('3', 'admin3', '123', '外国语学院');

-- ----------------------------
-- Table structure for schooloffice
-- ----------------------------
DROP TABLE IF EXISTS `schooloffice`;
CREATE TABLE `schooloffice` (
  `id` int(100) NOT NULL,
  `name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of schooloffice
-- ----------------------------
INSERT INTO `schooloffice` VALUES ('1', 'admin2', '123');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(100) NOT NULL,
  `name` varchar(255) NOT NULL,
  `class2` varchar(255) NOT NULL,
  `college` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `number` varchar(100) NOT NULL,
  `teachernumber` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '祁甜', '17卓越', '计算机', '123', '173', '123');
INSERT INTO `student` VALUES ('2', '张三', '设计一班', '设计学院', '123', '173', '123');
INSERT INTO `student` VALUES ('3', '李四', '英语二班', '外国语学院', '123', '182', '123');
INSERT INTO `student` VALUES ('4', '胜利', '17计师', '计算机', '123', '173', '123');
INSERT INTO `student` VALUES ('5', '王五', '设计二班', '设计学院', '123', '173', '123');
INSERT INTO `student` VALUES ('6', '小明', '英语一班', '外国语学院', '123', '173', '123');

-- ----------------------------
-- Table structure for yiqing
-- ----------------------------
DROP TABLE IF EXISTS `yiqing`;
CREATE TABLE `yiqing` (
  `name1` varchar(255) DEFAULT NULL,
  `college` varchar(255) NOT NULL,
  `class1` varchar(255) NOT NULL,
  `date` varchar(255) NOT NULL,
  `place` varchar(255) NOT NULL,
  `wuhan` varchar(255) NOT NULL,
  `hubei` varchar(255) NOT NULL,
  `wuhancontact` varchar(255) NOT NULL,
  `hubeicontact` varchar(255) NOT NULL,
  `back` varchar(255) NOT NULL,
  `suspected` varchar(255) NOT NULL,
  `confirm` varchar(255) NOT NULL,
  `state` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`date`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of yiqing
-- ----------------------------
INSERT INTO `yiqing` VALUES ('王五', '设计学院', '设计二班', '2020-02-17', '湖北荆州', '否', '是', '是', '是', '否', '是', '否', '已审核');
INSERT INTO `yiqing` VALUES ('小明', '外国语学院', '英语一班', '2020-03-01', '甘肃省兰州市', '否', '否', '是', '是', '否', '是', '是', null);
INSERT INTO `yiqing` VALUES ('李四', '外国语学院', '英语二班', '2020-03-13', '重庆', '否', '否', '否', '否', '是', '否', '否', null);
INSERT INTO `yiqing` VALUES ('胜利', '计算机', '17计师', '2020-03-15', '湖北武汉', '是', '是', '是', '是', '否', '否', '否', '已审核');
INSERT INTO `yiqing` VALUES ('张三', '设计学院', '设计一班', '2020-03-16', '北京', '否', '否', '否', '否', '否', '否', '否', '已审核');
INSERT INTO `yiqing` VALUES ('祁甜', '计算机', '17卓越', '2020-03-17', '甘肃省敦煌市', '否', '否', '否', '否', '否', '否', '否', '已审核');
INSERT INTO `yiqing` VALUES (null, '计算机', '17卓越', '2020-03-18', '甘肃省敦煌市', '否', '否', '否', '否', '否', '否', '否', null);
