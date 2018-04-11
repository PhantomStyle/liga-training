package ru.liga.dao.mapper;

import org.springframework.jdbc.core.RowMapper;
import ru.liga.entity.StudentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class StudentMapper implements RowMapper{
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        return new StudentEntity(
                rs.getLong("id"),
                rs.getString("fio"),
                rs.getString("gender"),
                rs.getLong("department_id"),
                rs.getString("studentGroupId"),
                LocalDate.parse(rs.getString("birthday"))
        );
    }
}
