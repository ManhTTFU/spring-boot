# 🧩 Spring Boot CRUD Project

Dự án **Spring Boot CRUD** minh họa cách tạo API quản lý sinh viên (Create, Read, Update, Delete).

---

## ⚙️ Công nghệ sử dụng
- Java 17
- Spring Boot 3.x
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- Lombok

# Query DB tạo 2 bảng student_tracker và employee_directory
create database if not exists `student_tracker`;
use `student_tracker`;

drop table if exists `student`;

create table `student` (
`id` int not null auto_increment,
`first_name` varchar(45) default null,
`last_name` varchar(45) default null,
`email` varchar(45) default null,
primary key(`id`)
) engine=InnoDB auto_increment= 1 default charset=latin1;

--
create database if not exists `employee_directory`;
use `employee_directory`;

drop table if exists `employee`;

create table `employee` (
`id` int not null auto_increment,
`first_name` varchar(45) default null,
`last_name` varchar(45) default null,
`email` varchar(45) default null,
primary key(`id`)
) engine=InnoDB auto_increment= 1 default charset=latin1;

-- ----
-- --- Data for table `employeee`
-- ---

insert into `employee` values
(1, 'Leslie', 'Andrews', 'leslie@gmail.com'),
(2, 'Peter', 'Parker', 'pêtr@gmail.com');

# Setup application.properties

spring.datasource.url=jdbc:mysql://127.0.0.1:3306/employee_directory || student_tracker
spring.datasource.username=springstudent
spring.datasource.password=springstudent
