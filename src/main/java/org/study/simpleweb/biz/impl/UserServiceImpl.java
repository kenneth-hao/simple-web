package org.study.simpleweb.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.study.simpleweb.biz.UserService;
import org.study.simpleweb.dao.UserDao;
import org.study.simpleweb.model.User;

/**
 * Created by haoyuewen on 8/28/14.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int insertUser(User user) {
        return 0;
    }

}
