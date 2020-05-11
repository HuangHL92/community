package com.hhu.springboot_community;


import com.hhu.springboot_community.dao.AccessTokenDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootCommunityApplicationTests {
    @Autowired
    private AccessTokenDao accessTokenDao;
    @Test
    void contextLoads() {

        System.out.println(accessTokenDao);

    }

}
