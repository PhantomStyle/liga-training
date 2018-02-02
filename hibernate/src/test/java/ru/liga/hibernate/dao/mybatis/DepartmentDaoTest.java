package ru.liga.hibernate.dao.mybatis;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.liga.hibernate.config.TestDaoSpringConfig;


import static org.junit.Assert.assertEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDaoSpringConfig.class})
public class DepartmentDaoTest {

    @Autowired
    private MDepartmentDao departmentDao;

    @Before
    public void init() {

    }

    @Test
    public void select() {
        assertEquals(1, departmentDao.selectByFoundationYear(1933).size());
    }

}