package com.hhu.springboot_community.controller;

import com.hhu.springboot_community.dao.Question;
import com.hhu.springboot_community.dao.User;
import com.hhu.springboot_community.mapper.QuestionMapper;
import com.hhu.springboot_community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/5/19
 * @version: 1.0
 */

@Controller
public class PublishController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;

    @RequestMapping("/publish")
    public String publishByGet() {
        return "publish";
    }

    @RequestMapping(value = "/publish", method = {RequestMethod.POST})
    public String publishByPost(Question question, HttpServletRequest request, Model model) {
        User user = null;
        if (StringUtils.isEmpty(question.getTitle())) {
            model.addAttribute("error", "标题不能为空");
            return "publish";
        }
        if (StringUtils.isEmpty(question.getDescription())) {
            model.addAttribute("error", "问题补充不能为空");
            return "publish";
        }
        if (StringUtils.isEmpty(question.getTag())) {
            model.addAttribute("error", "标签不能为空");
            return "publish";
        }
        Cookie[] cookies = request.getCookies();
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("token")) {
                String token = cookies[i].getValue();
                user = userMapper.getUserByToken(token);
                request.getSession().setAttribute("user", user);
                break;
            }
        }
        if (user == null) {
            model.addAttribute("error", "请先登录");
        }
        Question question1 = new Question();
        question1.setTitle(question.getTitle());
        question1.setDescription(question.getDescription());
        question1.setTag(question.getTag());
        question1.setGmtCreat(System.currentTimeMillis());
        question1.setGmtModified(question1.getGmtCreat());
        questionMapper.insertQuestion(question1);
        return "publish";
    }
}
