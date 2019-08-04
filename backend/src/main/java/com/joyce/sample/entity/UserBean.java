package com.joyce.sample.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "user")
public class UserBean {

    @Id
    @Column
    private String userId;

    @Column
    private String password;

    @Column
    private int failedLogin;

    @Column
    private Date lastLoginDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getFailedLogin() {
        return failedLogin;
    }

    public void setFailedLogin(int failedLogin) {
        this.failedLogin = failedLogin;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }
}

