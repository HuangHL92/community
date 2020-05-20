package com.hhu.springboot_community.mapper;

import com.hhu.springboot_community.dao.Question;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface QuestionMapper {
    public  Integer insertQuestion(Question question);
}
