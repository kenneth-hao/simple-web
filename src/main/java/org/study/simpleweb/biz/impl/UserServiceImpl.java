package org.study.simpleweb.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.study.simpleweb.biz.UserService;
import org.study.simpleweb.dao.UserDao;

/**
 * Created by haoyuewen on 8/28/14.
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int insertUser(User user) {
        return 0;
    }

}
