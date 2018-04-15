package ru.liga.dao;

import org.junit.Test;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.config.TestDaoSpringConfig;
import ru.liga.domain.Employee;
import ru.liga.entity.EmployeeEntity;

import java.sql.Timestamp;
import java.time.LocalDate;

import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class EmployeeDaoTest {
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void findByName(){
        assertEquals("Lecturer", employeeDao.findByFio("Корнев Андрей Алексеевич").get(0).getPosition());
    }

    @Test
    public void insertTest(){
        employeeDao.insert(new EmployeeEntity(15L, "Михайлов Илья Николаевич", "MALE", 1L, "Bachelor", "Student", LocalDate.of(1998, 5, 29)));
        assertEquals("Михайлов Илья Николаевич", employeeDao.findById(15L).getFio());
    }
}
