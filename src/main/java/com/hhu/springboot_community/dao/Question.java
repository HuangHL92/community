package com.hhu.springboot_community.dao;

import lombok.Data;

@Data
public class Question {

  private Integer id;
  private String title;
  private String description;
  private long gmtCreat;
  private long gmtModified;
  private Integer creator;
  private Integer commentCount;
  private Integer viewCount;
  private Integer likeCount;
  private String tag;
}
