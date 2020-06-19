create database dbname;
use dbname;
-- 管理员表
create table admin
(
    user   varchar(8)  not null,
    passwd varchar(16) not null,
    email  varchar(20) not null,
    primary key (user, email)
);
-- 学生表
create table stu
(
    sno   bigint(12)  not null
        primary key,
    sname varchar(20) not null,
    sage  int(2)      not null
);
-- 教师表
create table tea
(
    tno   int         not null
        primary key,
    tname varchar(25) not null,
    tage  int         not null
);
-- 课程表
create table course
(
    cno     int         not null
        primary key,
    cname   varchar(40) not null,
    ctea    varchar(25) not null,
    cnumber int         not null
);
-- 学院表
create table department
(
    dno     int         not null
        primary key,
    dname   varchar(30) not null,
    dtea    varchar(25) not null,
    dnumber int         not null
);

-- 插入管理员
insert into admin (user, passwd, email) values('admin', '666', '1759895304@qq.com');
insert into admin (user, passwd, email) values('root',  '123', '0123456789@qq.com');

-- 插入学生
insert into stu (sno, sname, sage) values (1826702010, '黄晓明', 28);
insert into stu (sno, sname, sage) values (1826702011, '佟大为', 29);
insert into stu (sno, sname, sage) values (1826702012, '古天乐', 40);
insert into stu (sno, sname, sage) values (1826702013, '陈小龙', 55);

-- 插入教师
insert into tea (tno, tname, tage) values(10000,'李大钊',33);
insert into tea (tno, tname, tage) values(10001,'刘德华',50);
insert into tea (tno, tname, tage) values(10002,'张学友',55);
insert into tea (tno, tname, tage) values(10003,'陈奕迅',45);

-- 插入课程
insert into course (cno, cname, ctea, cnumber) values(40001, '算法分析','李大钊',40);
insert into course (cno, cname, ctea, cnumber) values(40002, 'Java语言程序设计', '张学友',66);
insert into course (cno, cname, ctea, cnumber) values(40003, 'C++语言程序设计','刘德华',45);
insert into course (cno, cname, ctea, cnumber) values(40004, '大学体育','陈奕迅', 60);
-- 插入学院
insert into department (dno, dname, dtea, dnumber) values(60001, '软件学院', '陈奕迅', 660);
insert into department (dno, dname, dtea, dnumber) values(60002, '音乐学院', '张学友', 500);
insert into department (dno, dname, dtea, dnumber) values(60003, '计算机学院', '李大钊', 400);
insert into department (dno, dname, dtea, dnumber) values(60004, '物理学院', '刘德华', 550);