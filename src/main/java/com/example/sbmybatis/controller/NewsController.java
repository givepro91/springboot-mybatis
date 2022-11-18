package com.example.sbmybatis.controller;

import com.example.sbmybatis.dao.NewsDAO;
import com.example.sbmybatis.dto.NewsDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class NewsController {

    private final NewsDAO newsDAO;

    @GetMapping("/news")
    public @ResponseBody Map<String, Object> news() {
        final Map<String, Object> hashMap = new HashMap<>();
        final List<NewsDTO> newsDTOList = newsDAO.listNews();

        log.info("news->" + newsDTOList.toString());
        hashMap.put("news_list", newsDTOList);

        return hashMap;
    }

    @PostMapping("/news")
    public @ResponseBody Map<String, Object> createNews(@RequestBody NewsDTO newsDTO) {
        log.info("news insert->" + newsDTO.toString());
        newsDAO.createNews(newsDTO);

        final Map<String, Object> hashMap = new HashMap<>();
        final List<NewsDTO> newsDTOList = newsDAO.listNews();
        log.info("news->" + newsDTOList.toString());
        hashMap.put("news_list", newsDTOList);

        return hashMap;
    }

}
