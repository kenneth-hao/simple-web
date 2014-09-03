package org.study.simpleweb.model;


import java.io.Serializable;

/**
 * Created by haoyuewen on 8/28/14.
 */
public class User implements Serializable {

    private Integer userId;
    private String userName;
    private String password;
    private Short userType;
    private Short locked;
    private Integer credit;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Short getUserType() {
        return userType;
    }

    public void setUserType(Short userType) {
        this.userType = userType;
    }

    public Short getLocked() {
        return locked;
    }

    public void setLocked(Short locked) {
        this.locked = locked;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

}
