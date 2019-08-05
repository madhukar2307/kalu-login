package com.packages.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.packages.model.Login;
import com.packages.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView("login");
        mav.addObject("login", new Login());
        return mav;
    }
    @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
    public ModelAndView loginProcess(HttpServletRequest request, HttpServletResponse response,
                                     @ModelAttribute("login") Login login) {
        ModelAndView mav = null;
        Login user = loginService.validateUser(login);

        if (null != user) {
            System.out.println("in if");
            mav = new ModelAndView("welcome");
            mav.addObject("firstname", user.getUsername()+" ! You are already registered ");
        } else {
            System.out.println("in else");
            Login reg = loginService.registerUser(login);
            mav = new ModelAndView("welcome");
            mav.addObject("firstname", reg.getUsername() + " ! You are registered now!!");
        }
        return mav;
    }
}

