 DROP TABLE IF EXISTS student;
 DROP TABLE IF EXISTS department_id;
 DROP TABLE IF EXISTS employee;

CREATE TABLE student (
  id                 BIGINT PRIMARY KEY IDENTITY,
  fio                VARCHAR(400),
  gender             VARCHAR(100),
  department_id      VARCHAR(100),
  course             INTEGER,
  birthday           DATE NOT NULL
);
CREATE TABLE department_id (
  id                              BIGINT                   PRIMARY KEY IDENTITY,
  title                           VARCHAR(200)             NOT NULL,
  address                         VARCHAR(1000)            NOT NULL,
  foundation_year                 INTEGER
);
CREATE TABLE employee (
  id             BIGINT PRIMARY KEY IDENTITY,
  fio            VARCHAR(400),
  gender         VARCHAR(100),
  department_id  BIGINT,
  degree         VARCHAR(200),
  position       VARCHAR(200),
  birthday       DATE NOT NULL
);