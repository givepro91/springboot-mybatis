package com.example.sbmybatis.dao;

import com.example.sbmybatis.dto.NewsDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

// SQL 코드와 매핑되는 껍데기 메소드를 인터페이스로 생성하며, 인터페이스에 Mapper라는 어노테이션을 지정.
@Mapper
public interface NewsDAO {
    List<NewsDTO> listNews();
    void createNews(NewsDTO param);
}
