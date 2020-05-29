package com.hhu.springboot_community.dao;


public class User {

  private Integer id;
  private String userName;
  private String bio;
  private String avatarUrl;
  private long gmtCreate;
  private String token;
  private long gmtModified;
  private String accountId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }


  public String getBio() {
    return bio;
  }

  public void setBio(String bio) {
    this.bio = bio;
  }


  public String getAvatarUrl() {
    return avatarUrl;
  }

  public void setAvatarUrl(String avatarUrl) {
    this.avatarUrl = avatarUrl;
  }


  public long getGmtCreate() {
    return gmtCreate;
  }

  public void setGmtCreate(long gmtCreate) {
    this.gmtCreate = gmtCreate;
  }


  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }


  public long getGmtModified() {
    return gmtModified;
  }

  public void setGmtModified(long gmtModified) {
    this.gmtModified = gmtModified;
  }


  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", userName='" + userName + '\'' +
            ", bio='" + bio + '\'' +
            ", avatarUrl='" + avatarUrl + '\'' +
            ", gmtCreate=" + gmtCreate +
            ", token='" + token + '\'' +
            ", gmtModified=" + gmtModified +
            ", accountId='" + accountId + '\'' +
            '}';
  }
}
