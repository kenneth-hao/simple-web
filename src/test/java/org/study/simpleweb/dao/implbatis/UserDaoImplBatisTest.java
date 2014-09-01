package org.study.simpleweb.dao.implbatis;

import org.apache.commons.lang.time.DateUtils;
import org.junit.Assert;
import org.junit.Test;
import org.study.simpleweb.base.BaseTest;
import org.study.simpleweb.dao.UserDao;
import org.study.simpleweb.model.User;
import org.unitils.database.annotations.Transactional;
import org.unitils.database.util.TransactionMode;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;

/**
 * Created by haoyuewen on 8/30/14.
 */
@DataSet
public class UserDaoImplBatisTest extends BaseTest {

    @SpringBean("userDaoImplBatis")
    private UserDao userDao;

    @Test
    public void findByIdTest() {
        User u = userDao.findById(new Integer(1000));
        Assert.assertNotNull(u);
        Assert.assertEquals("Jack", u.getUserName());
    }

    @Test
    @DataSet("UserDaoImplBatisTest.empty.xml")
    @ExpectedDataSet
    @Transactional(TransactionMode.ROLLBACK)
    public void insertTest() throws Exception {
        User u = new User();
        u.setUserName("Kenneth");
        u.setPassword("12345");
        u.setUserType((short) 1);
        u.setCredit((short) 20);
        u.setLocked((short) 0);
        u.setLastVisit(DateUtils.parseDate("2011/6/6", new String[] { "yyyy/MM/dd" }));
        u.setLastIp("127.0.0.1");
        userDao.insert(u);
        userDao.commit();
    }

}
