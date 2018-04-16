package ru.liga.mybatis.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import ru.liga.mybatis.entity.StudentEntity;

import java.util.List;

public interface StudentDao {

    @Insert("insert into student (id, fio, gender, department_id, studentGroupId, birthday)\n" +
            "        values (\n" +
            "            #{id, jdbcType=INTEGER},\n" +
            "            #{fio, jdbcType=VARCHAR},\n" +
            "            #{gender, jdbcType=VARCHAR},\n" +
            "            #{department_id, jdbcType=INTEGER},\n" +
            "            #{studentGroupId, jdbcType=INTEGER},\n" +
            "            #{birthday, jdbcType=TIMESTAMP}")
    StudentEntity insert(StudentEntity entity);

    @Update("update student\n" +
            "        SET\n" +
            "            id           = #{id, jdbcType=INTEGER},\n" +
            "            fio           = #{fio, jdbcType=VARCHAR},\n" +
            "            gender           = #{gender, jdbcType=VARCHAR},\n" +
            "            department_id           = #{department_id, jdbcType=INTEGER},\n" +
            "            studentGroupId         = #{studentGroupId, jdbcType=INTEGER},\n" +
            "            birthday = #{birthday, jdbcType=TIMESTAMP}\n" +
            "        WHERE id = #{id}")
    StudentEntity update(StudentEntity entity);

    @Delete("delete from student\n" +
            "        where id = #{id}")
    void delete(Long entityId);

    @Select("SELECT *\n" +
            "        FROM student\n" +
            "        WHERE id = #{id}")
    StudentEntity select(Long id);

    @Select("SELECT *\n" +
            "        FROM student\n" +
            "        WHERE department_id = #{department_id}")
    List<StudentEntity> selectByDepartmentId(Integer year);

    @Select("SELECT *\n" +
            "        FROM student\n" +
            "        WHERE fio = #{fio}")
    StudentEntity selectByFio(String title);
}
