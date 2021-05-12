package com.lengqi.aop.controller;

import com.lengqi.aop.service.JournalService;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class JournalController {
    @Autowired
    private JournalService journalService;
    @PostMapping("/journalAdd")
    public boolean add(){
        return journalService.add();
    }
    @GetMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
