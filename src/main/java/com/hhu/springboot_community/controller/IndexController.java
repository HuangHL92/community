package com.hhu.springboot_community.controller;

import com.hhu.springboot_community.dao.AccessTokenDao;
import com.hhu.springboot_community.dao.UserDao;
import com.hhu.springboot_community.util.HttpClientUntil;
import com.hhu.springboot_community.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/5/7
 * @version: 1.0
 */
@Controller
public class IndexController {
    @Value("${github.client.id}")
    String client_id;
    @Value("${github.client.secret}")
    String client_secret;
    @Value("${github.redirect.uri}")
    String redirect_uri;

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/callback")
    public String callback(@RequestParam(name="code") String code,@RequestParam(name="state") String state) {
        AccessTokenDao accessTokenDao =new AccessTokenDao();
        accessTokenDao.setClient_id(client_id);
        accessTokenDao.setClient_secret(client_secret);
        accessTokenDao.setCode(code);
        accessTokenDao.setRedirect_uri(redirect_uri);
        accessTokenDao.setState(state);
        String url = "https://github.com/login/oauth/access_token";
        String resultByPost = HttpClientUntil.getResultByPost(url, accessTokenDao);
        String[] strings = resultByPost.split("&");
        String userToken = strings[0].split("=")[1];
        String urlUser = "https://api.github.com/user"+"?access_token="+userToken;
        String resultByGet = HttpClientUntil.getResultByGet(urlUser);
        UserDao userDao = (UserDao) JsonUtil.jsonTOobject(resultByGet,UserDao.class);
        System.out.println(userDao.getLogin());
        return "index";
    }

}
