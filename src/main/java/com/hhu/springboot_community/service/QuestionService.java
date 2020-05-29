package com.hhu.springboot_community.service;

import com.hhu.springboot_community.dao.QuestionDto;
import java.util.List;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/5/22
 * @version: 1.0
 */

public interface QuestionService  {
    public List<QuestionDto> getQuestion();
}
