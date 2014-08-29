package org.study.simpleweb.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.study.simpleweb.base.BaseTest;
import org.study.simpleweb.model.User;

/**
 * Created by haoyuewen on 8/28/14.
 */
public class UserServiceImplTest extends BaseTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUser() {
        User user = new User();
        user.setNickname("TestNickName");
        user.setState(1);
        userService.insertUser(user);
    }

}
