package ru.liga.mybatis.dao;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.liga.mybatis.entity.EmployeeEntity;

public interface EmployeeDao {
    @Select("SELECT * FROM employee\n" +
            "        WHERE id = #{id}")
    EmployeeEntity select(Long id);

    @Select("SELECT * FROM employee WHERE department_id = #{departmentId}")
    EmployeeEntity selectByDepartmentId(Long departmentId);

}
