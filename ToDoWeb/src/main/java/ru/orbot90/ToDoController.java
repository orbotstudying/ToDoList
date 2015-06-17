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
}
