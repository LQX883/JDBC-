CREATE DATABASE IF NOT EXISTS DateTest
    DEFAULT CHARACTER SET utf8mb4
    DEFAULT COLLATE utf8mb4_unicode_ci;

USE DateTest;

DROP TABLE IF EXISTS student;
DROP TABLE IF EXISTS college;

CREATE TABLE college (
    id   VARCHAR(32)  NOT NULL COMMENT '学院编号',
    name VARCHAR(64)  NOT NULL COMMENT '学院名称',
    code VARCHAR(32)  NOT NULL COMMENT '学院代码',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学院表';

CREATE TABLE student (
    id               VARCHAR(32)     NOT NULL COMMENT '学号',
    name             VARCHAR(64)     NOT NULL COMMENT '姓名',
    major            VARCHAR(64)     DEFAULT NULL COMMENT '专业',
    age              INT             DEFAULT NULL COMMENT '年龄',
    enrollment_time  DATE            DEFAULT NULL COMMENT '入学时间',
    graduated        TINYINT(1)      DEFAULT 0 COMMENT '是否毕业',
    tuition          DECIMAL(10, 2)  DEFAULT NULL COMMENT '学费',
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='学生表';
