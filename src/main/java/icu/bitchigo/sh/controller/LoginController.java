package icu.bitchigo.sh.controller;

import com.alibaba.fastjson.JSON;
import icu.bitchigo.sh.pojo.to.LoginUser;
import icu.bitchigo.sh.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;
    @PostMapping(value = "login")
    public Map login(@RequestBody String json){

        LoginUser loginUser = JSON.parseObject(json, LoginUser.class);
        return loginService.login(loginUser);
    }
}
