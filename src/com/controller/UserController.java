package com.controller;

import com.entity.Users;
import com.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * 用户控制器
 */
@Controller
@RequestMapping("/index")
public class UserController {
    @Resource
    private UserService userService;
    /**
     * 用户登录
     */
    @GetMapping("/login")
    public String log(){
        return "/index/login.jsp";
    }

    @PostMapping("/login")
    public String login(Users user, HttpServletRequest request, HttpSession session){
        Users loginUser = userService.getByUsernameAndPassword(user.getUsername(),user.getPassword());
        if (Objects.isNull(loginUser)){
            request.setAttribute("msg","用户密码错误");
            return "/index/login.jsp";
        }
        session.setAttribute("user",loginUser);
        //还原购物车
        session.setAttribute("cartCount",0);
        String referer = request.getHeader("referer");
        System.out.println(referer);
        return "/index/index.jsp";
//        return "redirect:index";
    }
    /**
     * 用户注册
     */
    @GetMapping("/register")

    public String reg(){
        return "/index/register.jsp";
    }
    /**
     * 用户注册
     */
    @PostMapping("/register")
    public String register(Users user,HttpServletRequest request){
        if (user.getUsername().isEmpty()){
          request.setAttribute("msg","用户名不能为空");
        }else if(Objects.nonNull(userService.getByUsername(user.getUsername()))){
            request.setAttribute("msg","用户名已存在");
        }else {
            userService.add(user);
            request.setAttribute("msg","注册成功,可以登录");
            return "/index/login.jsp";
        }
        return "/index/register.jsp";
    }
}
