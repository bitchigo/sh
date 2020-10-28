package icu.bitchigo.sh.controller;

import icu.bitchigo.sh.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @GetMapping("login")
    public String login(@RequestBody String json){
        //从json获取
        String username="";
        String password="";
        return loginService.login(username,password);
    }
}
