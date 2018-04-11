package ru.liga.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.config.TestDaoSpringConfig;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class StudentDaoTest {
    @Autowired
    StudentDao studentDao;

    @Test
    public void whenId3Return(){
        System.out.println(studentDao.selectById(3L).size());
        assertEquals(0, studentDao.selectById(3L).size());
    }
}
