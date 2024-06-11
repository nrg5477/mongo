package com.example.mongo.controller;

import com.example.mongo.dto.ScoreDTO;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/score")
public class ScoreController {

    @GetMapping("/search")
    public String searchPage(){
        return "mongo/search";
    }

    @PostMapping("/search")
    public String search(@RequestParam("field") String field,@RequestParam("criteria") String criteria,@RequestParam("value") String value, Model model) {
        List<ScoreDTO> searchList = service.findCriteria(field + "," + criteria + value);
//        List<ScoreDTO> searchList = service.findCriteria(field, value);
        model.addAttribute("mongolist", searchList);
        return "mongo/list";
    }

    //id로 조회할수 있도록 작업
    @GetMapping("/read")
    public String getScoreById(@RequestParam("key") String key,@RequestParam("value") String value,@RequestParam("action") String action, Model model) {
        ScoreDTO document = service.findById(key, value);
        String view="";
        if (action.equals("read")) {
            view = "mongo/mongo_detail";
        } else {
            view = "mongo/mongo_update";
        }
        model.addAttribute("document", document);
        return view;
    }

    @GetMapping("/read2")
    public String read2(@RequestParam("value") String value, @RequestParam("action") String action, Model model) {
        ScoreDTO document = service.findById(value);
        String view = "";
        if (action.equals("read")) {
            view = "mongo/mongo_detail";
        } else {
            view = "mongo/mongo_update";
        }
        model.addAttribute("document", document);
        return view;
    }
}
