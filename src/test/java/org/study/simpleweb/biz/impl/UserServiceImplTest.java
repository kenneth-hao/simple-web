package org.study.simpleweb.biz.impl;

import org.junit.Test;
import org.study.simpleweb.base.BaseTest;
import org.study.simpleweb.biz.UserService;
import org.study.simpleweb.model.User;
import org.unitils.spring.annotation.SpringBeanByType;

/**
 * Created by haoyuewen on 8/28/14.
 */
public class UserServiceImplTest extends BaseTest {

    @SpringBeanByType
    private UserService userService;

    @Test
    public void testInsertUser() {
        User user = new User();
        userService.saveUser(user);

    }

}
