package ru.liga.dao.mapper;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import ru.liga.entity.EmployeeEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class EmployeeMapper implements RowMapper {
    @Override
    public Object mapRow(ResultSet rs, int i) throws SQLException {
        return new EmployeeEntity(
                rs.getLong("id"),
                rs.getString("fio"),
                rs.getString("gender"),
                rs.getLong("department_id"),
                rs.getString("degree"),
                rs.getString("position"),
                rs.getDate("birthday").toLocalDate()
        );
    }
}
