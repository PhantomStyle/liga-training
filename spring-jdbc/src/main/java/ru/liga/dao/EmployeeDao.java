package ru.liga.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.liga.dao.mapper.EmployeeMapper;
import ru.liga.entity.EmployeeEntity;

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
        String sql = "SELECT * FROM liga.employee WHERE ID = ?";
        List<EmployeeEntity> entities = jdbcTemplate.query(
                sql, new Object[]{id}, new EmployeeMapper());
        return entities.isEmpty() ? null : entities.get(0);
    }

    public EmployeeEntity insert(EmployeeEntity entity) {
        String sqlInsert = "INSERT INTO liga.employee (fio, gender,department_id, degree,  position, birthday)"
                + " VALUES (?, ?, ?)";
        jdbcTemplate.update(sqlInsert, new Object[]{
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
        String sqlUpdate = "update liga.employee set" +
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
        String sqlDelete = "delete from liga.employee where id = ?";
        jdbcTemplate.update(sqlDelete, new Object[]{entityId});
    }

    public List<EmployeeEntity> findByFio(String fio) {
        String sql = "SELECT * FROM liga.employee WHERE fio = ?";
        List<EmployeeEntity> entities = jdbcTemplate.query(
                sql, new Object[]{fio}, new EmployeeMapper());
        return entities;
    }

    public EmployeeEntity findByBirthday(String birthday) {
        String sql = "SELECT * FROM liga.employee WHERE birthday = ?";
        List<EmployeeEntity> entities = jdbcTemplate.query(
                sql, new Object[]{birthday}, new EmployeeMapper());
        return entities.isEmpty() ? null : entities.get(0);
    }
}
