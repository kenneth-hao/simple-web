package org.study.simpleweb.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Assert;
import org.junit.Test;
import org.study.simpleweb.base.BaseTest;
import org.study.simpleweb.model.User;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBeanByType;

/**
 * Created by haoyuewen on 8/30/14.
 */
@DataSet
public class UserDaoTest extends BaseTest {

    /* The logger instance for this class */
    private static Log logger = LogFactory.getLog(UserDaoTest.class);

    @SpringBeanByType
    private UserDao userDao;

    @Test
    public void findByIdTest() {
        User u = userDao.findById(1000);
        Assert.assertNotNull(u);
        Assert.assertEquals("Jack", u.getUserName());
        Assert.assertEquals("123456", u.getPassword());
        Assert.assertEquals(Short.valueOf("1"), u.getUserType());
        Assert.assertEquals(Short.valueOf("0"), u.getLocked());
        Assert.assertEquals(Integer.valueOf(10), u.getCredit());
    }

    @Test
    @ExpectedDataSet
    // Spring 事务提交 要比 ExceptedDataSet assertEqualObject 晚一些,
    // 会导致 assertObject DataSet 中的数据与空表做比较, 必然会失败
    // 所以, 必须禁用事务
    @Transactional(TransactionMode.DISABLED)
    public void insertTest() {
        User u = new User();
        u.setUserName("Kenneth");
        u.setPassword("123456");
        u.setUserType((short) 1);
        u.setCredit(20);
        u.setLocked((short) 0);
        userDao.insert(u);
    }

    @Test
    @ExpectedDataSet
    @Transactional(TransactionMode.DISABLED)
    public void updateTest() {
        User u = userDao.findById(1000);
        u.setUserName("Jacky");
        u.setPassword("12345");
        u.setUserType((short) 0);
        u.setLocked((short) 1);
        u.setCredit(20);
        userDao.update(u);
    }

    @Test
    @Transactional(TransactionMode.DISABLED)
    public void deleteTest() {
        userDao.delete(1000);
        User u = userDao.findById(1000);
        Assert.assertNull(u);
    }

}
