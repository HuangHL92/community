package com.hhu.springboot_community.mapper;

import com.hhu.springboot_community.dao.Question;
import com.hhu.springboot_community.dao.QuestionDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuestionMapper {
    public  Integer insertQuestion(Question question);

    public List<Question> selectAll();
}
