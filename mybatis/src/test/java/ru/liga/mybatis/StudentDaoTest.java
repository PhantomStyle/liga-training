package ru.liga.mybatis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.mybatis.config.TestDaoSpringConfig;
import ru.liga.mybatis.dao.StudentDao;
import ru.liga.mybatis.entity.StudentEntity;
import static org.junit.Assert.*;
import java.time.LocalDate;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class StudentDaoTest {
    @Autowired
    StudentDao studentDao;

    @Test
    public void crudTest(){
        studentDao.insert(new StudentEntity(100L, "Kek",
                "MALE", 3L, 1L, LocalDate.now()));
        studentDao.update(new StudentEntity(101L, "Kek",
                "MALE", 3L, 1L, LocalDate.now()));
        assertEquals("Kek", studentDao.select(101L).getFio());
        studentDao.delete(101L);
        assertNull(studentDao.select(101L));
    }
}
