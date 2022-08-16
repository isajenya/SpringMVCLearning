package com.gmail.learnspringmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

        //System.out.println(name + " " + surname + "\t hello!");

        model.addAttribute("message", name + " " + surname + "\t hello!");

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage() {
        return "first/goodbye";
    }

    @GetMapping("/calculate")
    public String calculate(@RequestParam(value = "a") double a,
                            @RequestParam(value = "b") double b,
                            @RequestParam(value = "action") String action,
                            Model model) {
        Double result = null;

        if (action.equals("mul")) {
            result = a * b;
        } else if (action.equals("add")) {
            result = a + b;
        }else if(action.equals("sub")){
            result = a - b;
        }else if(action.equals("div")){
            result = a / b;
        }

        model.addAttribute("result", result);


        return "first/calculator";
    }

}
