--liquibase formatted sql logicalFilePath:V1_004_DEPARTMENT.sql
--changeset sanasov:1.4 runOnChange:true context:prod
DROP TABLE IF EXISTS department_id;
CREATE TABLE department_id (
  id                              INTEGER                  PRIMARY KEY AUTOINCREMENT,
  title                           VARCHAR(200)             NOT NULL,
  address                         VARCHAR(1000)            NOT NULL,
  foundation_year                 SMALLINT
);