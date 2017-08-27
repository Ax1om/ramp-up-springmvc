package com.nrqapps.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mauricio on 8/27/17.
 * NrqApps © 2017
 */
@Controller
public class MainController {

    @RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
    public String homePage(ModelMap modelMap){
        modelMap.addAttribute("message", "Hello World!");
        return "index";
    }
}
