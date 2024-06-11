package com.example.mongo.controller;

import com.example.mongo.dto.ScoreDTO;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ScoreController {

    @GetMapping("/search")
    public String searchPage(){
        return "mongo/search";
    }

    @PostMapping("/search")
    public String search(@RequestParam("field") String field,@RequestParam("criteria") String criteria,@RequestParam("value") String value, Model model) {
        List<ScoreDTO> searchList = service.findCriteria(field + "," + criteria + value);
        model.addAttribute("mongolist", searchList);
        return "mongo/list";
    }
}
