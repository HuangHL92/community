package com.hhu.springboot_community.controller;
import com.hhu.springboot_community.dao.AccessTokenDao;
import com.hhu.springboot_community.dao.User;
import com.hhu.springboot_community.dao.UserDao;
import com.hhu.springboot_community.mapper.UserMapper;
import com.hhu.springboot_community.util.HttpClientUntil;
import com.hhu.springboot_community.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

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
    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/")
    public String index(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        for(int i=0;i<cookies.length;i++){
            if(cookies[i].getName().equals("token")){
                String token = cookies[i].getValue();
                User user = userMapper.getUserByToken(token);
                request.getSession().setAttribute("user",user);
                break;
            }
        }

        return "index";
    }

    @RequestMapping("/callback")
    public String callback(@RequestParam(name="code") String code, @RequestParam(name="state") String state, HttpServletResponse response) {
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
        System.out.println(resultByGet);
        UserDao userDao = (UserDao) JsonUtil.jsonTOobject(resultByGet,UserDao.class);
        if (userDao!=null && !(userDao.getLogin().equals("HuangHL92"))){
            User user =new User();
            user.setUserName(userDao.getLogin());
            user.setToken(UUID.randomUUID().toString());
            user.setBio(userDao.getBio());
            user.setAvatarUrl(userDao.getAvatar_url());
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            user.setAccountId(userDao.getId());
            userMapper.insertUser(user);
            response.addCookie(new Cookie("token",user.getToken()));
            return "redirect:/";
        }else{
            User user = userMapper.getUserByName("HuangHL92");
            response.addCookie(new Cookie("token",user.getToken()));
            return "redirect:/";
        }
    }

}
