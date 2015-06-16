package ru.orbot90;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class ToDoController {
    @Autowired
    StringEncryptor encryptor;
    @RequestMapping(value = "/")
    public String login(ModelMap model, @RequestParam(value = "login", required = false)String login,
                        @RequestParam(value="password", required = false)String password) {

        if(authorize.Authorization.login(login, password)) {
            String encrypted = encryptor.encrypt(password);
            model.addAttribute("password", encrypted);
            return "success";
        } else {
            return "login";
        }
    }
}
