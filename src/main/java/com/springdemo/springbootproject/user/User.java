package com.springdemo.springbootproject.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity(name = "tblusers")
@Table(name = "tblusers")
public class User {

    @Id
    @Column(name = "userid", updatable = false, nullable = false, columnDefinition = "TEXT")
    private String userId;

    @Column(name = "password", columnDefinition = "TEXT")
    @JsonIgnore
    private String password;

    @Column(name = "fullname", columnDefinition = "TEXT")
    private String fullName;

    @Column(name = "roleid", columnDefinition = "TEXT")
    private String roleId;

    public User() {
    }

    public User(String userId, String password, String fullName, String roleId) {
        this.userId = userId;
        this.password = password;
        this.fullName = fullName;
        this.roleId = roleId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonIgnore
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
