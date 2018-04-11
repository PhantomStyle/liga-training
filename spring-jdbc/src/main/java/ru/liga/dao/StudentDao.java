package ru.liga.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.liga.dao.mapper.StudentMapper;
import ru.liga.entity.StudentEntity;

import java.util.List;

public class StudentDao {


    JdbcTemplate jdbcTemplate;

    public StudentDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public StudentEntity insert(StudentEntity entity) {
        String sqlInsert = "INSERT INTO student (id, fio, gender,department_id, studentGroupId, birthday)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlInsert, new Object[]{
                entity.getId(),
                entity.getFio(),
                entity.getGender(),
                entity.getDepartment_id(),
                entity.getStudentGroupId(),
                entity.getBirthday()
        });
        return entity;
    }


    public StudentEntity update(StudentEntity entity) {
        String sqlUpdate = "update liga.student set" +
                " id = ?," +
                " fio = ?," +
                " gender = ?," +
                " department_id = ?," +
                " studentGroupId = ?," +
                " birthday = ?" +
                " where id = ?";
        jdbcTemplate.update(sqlUpdate, new Object[]{
                entity.getId(),
                entity.getFio(),
                entity.getGender(),
                entity.getDepartment_id(),
                entity.getStudentGroupId(),
                entity.getBirthday()
        });
        return entity;
    }

    public void delete(Long entityId) {
        String sqlDelete = "delete from liga.student where id = ?";
        jdbcTemplate.update(sqlDelete, new Object[]{entityId});
    }

    public List<StudentEntity> selectByDepartmentId(Long department_id){
        String sql = "SELECT * FROM liga.student WHERE department_id = ?";
        List<StudentEntity> entities = jdbcTemplate.query(
                sql, new Object[]{department_id}, new StudentMapper());
        return entities;
    }

    public List<StudentEntity> selectById(Long id){
        String sql = "SELECT * FROM liga.student WHERE id = ?";
        List<StudentEntity> entities = jdbcTemplate.query(
                sql, new Object[]{id}, new StudentMapper());
        return entities;
    }

}
