package org.study.simpleweb.biz;


import org.study.simpleweb.model.User;

/**
 * Created by haoyuewen on 8/28/14.
 */
public interface UserService {

    /**
     * add User
     *
     * @param user
     * @return
     */
    int insertUser(User user);
}