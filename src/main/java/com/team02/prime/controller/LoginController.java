package com.team02.prime.controller;

import com.team02.prime.model.UserVO;
import com.team02.prime.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * login form HTML
     * @return
     */
    @GetMapping("/login/login")
    public String login(){

        return "login/login";
    }

    /**
     * login 수행
     * @param userVO
     * @param model
     * @param request
     * @return
     */
    @PostMapping("/login/login")
    public String loginExecute(@ModelAttribute UserVO userVO
            , Model model
            , HttpServletRequest request){

        this.userService.login(userVO, request);
        return "login/login_result";
    }
}
