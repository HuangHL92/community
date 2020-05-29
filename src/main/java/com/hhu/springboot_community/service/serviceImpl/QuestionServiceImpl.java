package com.hhu.springboot_community.service.serviceImpl;

import com.hhu.springboot_community.dao.Question;
import com.hhu.springboot_community.dao.QuestionDto;
import com.hhu.springboot_community.dao.User;
import com.hhu.springboot_community.mapper.QuestionMapper;
import com.hhu.springboot_community.mapper.UserMapper;
import com.hhu.springboot_community.service.QuestionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/5/22
 * @version: 1.0
 */
@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private QuestionMapper questionMapper;


    @Override
    public List<QuestionDto> getQuestion() {
        List<QuestionDto> list = new ArrayList<>();
        List<Question> questions = questionMapper.selectAll();
        if(questions!=null){
            for (int i = 0; i < questions.size(); i++) {
                User user = userMapper.getUser(questions.get(i).getCreator());
                QuestionDto questionDto = new QuestionDto();
                BeanUtils.copyProperties(questions.get(i), questionDto);
                questionDto.setUser(user);
                list.add(questionDto);
            }
        }

        return list;
    }

}

