package com.example.NotificationMail.controller;


import com.example.NotificationMail.service.MainService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class MainController {
    @Autowired
    MainService mainService;

    //@ResponseBody
    @GetMapping("/")
    public ModelAndView firstFunction() throws Exception{

        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @ResponseBody
    @PostMapping("/sendmail")
    public String sendMail(HttpServletRequest request) throws Exception{

        mainService.sendMail(request.getParameter("mailId"));
        return "Mail has been sent to concerned mail Id";
    }
}
