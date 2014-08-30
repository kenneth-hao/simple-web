package org.study.simpleweb.dao.implbatis;


import org.springframework.stereotype.Repository;
import org.study.simpleweb.dao.UserDao;
import org.study.simpleweb.model.User;

/**
 * Created by haoyuewen on 8/28/14.
 */
@Repository
public class UserDaoImplBatis implements UserDao {

    @Override
    public int insertUser(User user) {
        return 0;
    }

}
