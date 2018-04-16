-- liquibase formatted sql logicalFilePath:V1_010_STUDENT.sql
-- changeset sanasov:1.10 runOnChange:true context:prod
ALTER TABLE liga.student ADD COLUMN department_id INTEGER;
UPDATE liga.student SET department_id = (SELECT id FROM  liga.department_id WHERE  liga.student.department_name = title);
ALTER TABLE liga.student DROP COLUMN department_name;