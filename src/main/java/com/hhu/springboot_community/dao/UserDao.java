package com.hhu.springboot_community.dao;

import java.util.UUID;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/5/9
 * @version: 1.0
 */

public class UserDao {

    private String login;
    private String id;
    private String bio;
    private String avatar_url;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "login='" + login + '\'' +
                ", id='" + id + '\'' +
                ", bio='" + bio + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                '}';
    }

}
