package org.example.project2.controller;

import org.springframework.ui.Model;
import org.example.project2.entity.User;
import org.example.project2.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @RequestMapping("/")
    public String test(){
        System.out.println("wtf");
        return "login";
    }
    @Autowired
    private UserMapper userMapper;

    @RequestMapping ("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {

        User user = userMapper.selectByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            // 用户名和密码匹配，认为登录成功
            // 这里可以进行页面跳转，比如跳转到主页面
            model.addAttribute("successMessage", user.getFullName()+"登录成功"); // 登录成功消息
            return "main";
        } else {
            // 用户名或密码错误，弹窗提示错误信息
            // 返回登录页面，并在页面加载时执行JavaScript弹窗
            String errorMessage = "用户名或密码错误";
            model.addAttribute("errorMessage", errorMessage); // 将错误消息添加到模型中
            return "login";
        }
    }

}
