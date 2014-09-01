package org.study.simpleweb.dao.implbatis;


import org.springframework.stereotype.Repository;
import org.study.simpleweb.dao.UserDao;
import org.study.simpleweb.dao.base.implbatis.BaseDaoImplBatis;
import org.study.simpleweb.model.User;

/**
 * Created by haoyuewen on 8/28/14.
 */
@Repository("userDaoImplBatis")
public class UserDaoImplBatis extends BaseDaoImplBatis<User, Integer> implements UserDao {

}
