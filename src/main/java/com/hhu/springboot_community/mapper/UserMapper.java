package com.hhu.springboot_community.mapper;

import com.hhu.springboot_community.dao.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/5/14
 * @version: 1.0
 */

@Mapper
public interface UserMapper {
    public int insertUser(User user);

    public User getUserByToken(String token);

    public User getUserByName(String userName);

    public  User getUser(Integer id);
}
