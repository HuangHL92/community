package com.hhu.springboot_community.dao;

import lombok.Data;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/5/22
 * @version: 1.0
 */
@Data
public class QuestionDto {
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
    private User user;

}
