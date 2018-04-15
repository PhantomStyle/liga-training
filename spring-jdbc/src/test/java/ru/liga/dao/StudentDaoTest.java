package ru.liga.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.config.TestDaoSpringConfig;
import ru.liga.entity.StudentEntity;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class StudentDaoTest {
    @Autowired
    StudentDao studentDao;

    @Test
    public void whenId3Return(){
        assertEquals("Котвица Мария Александровна", studentDao.findById(3L).getFio());
    }

    @Test
    public void updateTest(){
        studentDao.update(new StudentEntity(1L, "Михайлов Илья Николаевич", "Male", 1L, 1L, LocalDate.of(1998, 5, 29)));
        assertEquals("Михайлов Илья Николаевич", studentDao.findById(1L).getFio());
    }
}
