package com.hhu.springboot_community;


import com.hhu.springboot_community.dao.AccessTokenDao;
import com.hhu.springboot_community.dao.User;
import com.hhu.springboot_community.dao.UserDao;
import com.hhu.springboot_community.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootCommunityApplicationTests {
    @Autowired
    private UserMapper userMapper ;
    @Test
    void contextLoads() {
//        UserDao userDao = new UserDao();
//        userDao.setId("1");
//        userDao.setLogin("2");
//        userDao.setBio("3");
//        userDao.setAvatarUrl("4");
//      userMapper.InsertUser(userDao);
//        User user = userMapper.getUserByToken();
//        System.out.println(user);

    }

}
