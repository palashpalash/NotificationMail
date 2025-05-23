package com.example.NotificationMail.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Base64;

@Controller

public class NotificationController {


    @GetMapping("/notificationacceptance/{details}")
    public ModelAndView NotificationResponse(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("notification");
        return modelAndView;
    }

    @ResponseBody
    @GetMapping("/verifynotification/{details}")
    public String handleNotification(@PathVariable String details) {
        System.out.println(details);
        String notificationdata=new String(Base64.getDecoder().decode(details));
        System.out.println(notificationdata);
        return "You clicked: " + notificationdata.split(",")[2];
    }
}
