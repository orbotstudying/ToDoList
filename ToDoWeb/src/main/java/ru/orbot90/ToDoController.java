package ru.orbot90;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ToDoController {
    @RequestMapping(value = "/")
    public String login(ModelMap model, @RequestParam(value = "login", required = false)String login,
                        @RequestParam(value="password", required = false)String password) {

        if(authorize.Authorization.login(login, password)) {
            return "success";
        } else {
            return "login";
        }
    }

    @RequestMapping("/join")
    public String register(ModelMap model, @RequestParam(value = "username", required = false) String userName,
                           @RequestParam(value="password", required = false) String password) {
        if(null != userName && null != password) {
            switch(authorize.Authorization.register(userName, password)) {
                case 0:
                    return "successfullyjoined";
            }
        }
        return "register";
    }

    @RequestMapping("/main")
    public String showMainPage(ModelMap model) {
        return "main";
    }
}
