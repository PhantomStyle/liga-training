package ru.liga.repository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.config.TestDaoSpringConfig;
import ru.liga.dao.EmployeeDao;
import ru.liga.dao.StudentDao;
import ru.liga.entity.DepartmentEntity;
import ru.liga.entity.EmployeeEntity;
import ru.liga.entity.StudentEntity;

import java.time.LocalDate;
import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class DbDepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private EmployeeDao employeeDao;


    @Test
    public void test() {
        StudentEntity studentEntity = new StudentEntity(100L, "Pam Pam Papam",
                "MALE", 30L, 50L, LocalDate.now());
        EmployeeEntity employeeEntity = new EmployeeEntity(22L, "Kek Kek Kek",
                "MALE", 30L, "The most important kek", "keker", LocalDate.now());
        DepartmentEntity entity = new DepartmentEntity(30L, "ipovs",
                "Moscow", 1095, Collections.singletonList(employeeEntity), Collections.singletonList(studentEntity));

        repository.save(entity);
        assertEquals("Kek Kek Kek", employeeDao.findById(22L).getFio());
        assertEquals("Pam Pam Papam", studentDao.findById(100L).getFio());

        repository.deleteById(30L);

        assertNull(studentDao.findById(100L));
        assertNull(employeeDao.findById(22L));
    }
}
