package com.hotel.VaishnoBleach.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HeadController {
    @RequestMapping("/index")
    public String home(){
        return "index";
    }
    @RequestMapping("/")
    public String home2(){
        return "index";
    }
    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    @RequestMapping("/room")
    public String room(){
        return "room";
    }
    @RequestMapping("/gallery")
    public String services(){
        return "gallery";
    }
    @RequestMapping("/testimonial")
    public String testimonial(){
        return "testimonial";
    }
}
