package com.example.youtubepopularityrank.controller;

import com.example.youtubepopularityrank.entity.Video;
import com.example.youtubepopularityrank.service.CrawlingService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("crawling")
public class CrawlingController {

    private final CrawlingService crawlingService;

    public CrawlingController(CrawlingService crawlingService) {
        this.crawlingService = crawlingService;
    }

    @GetMapping("")
    public String getList(Model model) {

        List<Video> list = crawlingService.getInfo();
        model.addAttribute("list", list);

        return "lists";
    }
}
