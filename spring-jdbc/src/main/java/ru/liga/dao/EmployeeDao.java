package ru.liga.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.liga.dao.mapper.EmployeeMapper;
import ru.liga.entity.EmployeeEntity;

import java.time.LocalDate;
import java.util.List;

public class EmployeeDao {

    JdbcTemplate jdbcTemplate;

    public EmployeeDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public EmployeeEntity save(EmployeeEntity entity){
        if (findById(Long.valueOf(entity.getId())) == null) {
            return insert(entity);
        } else {
            return update(entity);
        }
    }

    public EmployeeEntity findById(Long id) {
        String sql = "SELECT * FROM employee WHERE ID = ?";
        List<EmployeeEntity> entities = jdbcTemplate.query(
                sql, new Object[]{id}, new EmployeeMapper());
        return entities.isEmpty() ? null : entities.get(0);
    }

    public EmployeeEntity insert(EmployeeEntity entity) {
        String sqlInsert = "INSERT INTO employee (id, fio, gender,department_id, degree,  position, birthday)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sqlInsert, new Object[]{
                entity.getId(),
                entity.getFio(),
                entity.getGender(),
                entity.getDepartment(),
                entity.getDegree(),
                entity.getPosition(),
                entity.getBirthday()
        });
        return entity;
    }

    public EmployeeEntity update(EmployeeEntity entity) {
        String sqlUpdate = "update employee set" +
                " fio = ?," +
                " gender = ?," +
                " department_id = ?," +
                " degree = ?," +
                " position = ?," +
                " birthday = ?" +
                " where id = ?";
        jdbcTemplate.update(sqlUpdate, new Object[]{
                entity.getFio(),
                entity.getGender(),
                entity.getDepartment(),
                entity.getDegree(),
                entity.getPosition(),
                entity.getBirthday(),
                entity.getId()
        });
        return entity;
    }

    public void delete(Long entityId) {
        String sqlDelete = "delete from employee where id = ?";
        jdbcTemplate.update(sqlDelete, new Object[]{entityId});
    }

    public List<EmployeeEntity> findByFio(String fio) {
        String sql = "SELECT * FROM employee WHERE fio = ?";
        List<EmployeeEntity> entities = jdbcTemplate.query(
                sql, new Object[]{fio}, new EmployeeMapper());
        return entities;
    }

    public List<EmployeeEntity> findByDepartmentId(Long departmentId) {
        String sql = "SELECT * FROM liga.employee WHERE department_id = ?";
        return jdbcTemplate.query(sql, new EmployeeMapper(), departmentId);
    }
//
//    public EmployeeEntity insertWithId(EmployeeEntity entity) {
//        String sql = "INSERT INTO liga.employee " +
//                "(id, fio, gender, department_id, degree, position, birthday)" +
//                "VALUES (?, ?, ?, ?, ?, ?, ?)";
//        jdbcTemplate.update(sql,
//                entity.getId(),
//                entity.getFio(),
//                entity.getGender(),
//                entity.getDepartment_id(),
//                entity.getDegree(),
//                entity.getPosition(),
//                entity.getBirthday()
//        );
//        return entity;
//    }

}
