package org.study.simpleweb.dao;

import org.apache.commons.lang.time.DateUtils;
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

    @SpringBeanByType
    private UserDao userDao;

    @Test
    @DataSet
    public void findByIdTest() {
        User u = userDao.findById(new Integer(1000));
        Assert.assertNotNull(u);
        Assert.assertEquals("Jack", u.getUserName());
    }

    @Test
    // 用于每次验证插入时, 清空数据库,
    @DataSet("UserDaoTest.empty.xml")
    @ExpectedDataSet
    // Spring 事务提交 要比 ExceptedDataSet assertEqualObject 晚一些,
    // 会导致 assertObject DataSet 中的数据与空表做比较, 必然会失败
    // 所以, 必须禁用事务
    @Transactional(TransactionMode.DISABLED)
    public void insertTest() throws Exception {
        User u = new User();
        u.setUserName("Kenneth");
        u.setPassword("123456");
        u.setUserType((short) 1);
        u.setCredit(20);
        u.setLocked((short) 0);
        u.setLastVisit(DateUtils.parseDate("2011/6/6", new String[] { "yyyy/MM/dd" }));
        u.setLastIp("127.0.0.1");
        userDao.insert(u);
    }

}
