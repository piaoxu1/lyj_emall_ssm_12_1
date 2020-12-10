package com.controller;

import com.entity.Users;
import com.service.CartService;
import com.service.GoodService;
import com.service.UserService;
import com.utils.SafeUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @Resource
    private GoodService goodService;
    @Resource
    private CartService cartService;

    /**
     * 用户登录
     */
    @GetMapping("/login")
    public String log() {
        return "/index/login.jsp";
    }

    @PostMapping("/login")
    public String login(Users user, HttpServletRequest request, HttpSession session) {
        Users loginUser = userService.getByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (Objects.isNull(loginUser)) {
            request.setAttribute("msg", "用户密码错误");
            return "/index/login.jsp";
        }
        session.setAttribute("user", loginUser);
        //还原购物车
        session.setAttribute("cartCount", 0);
        String referer = request.getHeader("referer");
        System.out.println(referer);
        return "/index/index.jsp";
//        return "redirect:index";
    }
    /**
     * 加入购物车
     */
  @PostMapping("/cartBuy")
  public @ResponseBody boolean cartBuy(int goodId, HttpSession session){
      Users user=(Users) session.getAttribute("user");
      return cartService.save(goodId,user.getId());
  }
    /**
     *  查看购物车
     */
//    @GetMapping("/cart")
//    public String cart(HttpServletRequest request, HttpSession session){
//        Users user=(Users) session.getAttribute("user");
//        request.setAttribute("cartList", cartService.getList(user.getId()));
//        request.setAttribute("cartCount", cartService.getCount(user.getId()));
//        request.setAttribute("carTotal", cartService.getTotal(user.getId()));
//        return "/index/cart.jsp";
//    }
    /**
     * 用户注册
     */
    @GetMapping("/register")

    public String reg() {
        return "/index/register.jsp";
    }

    /**
     * 用户注册
     */
    @PostMapping("/register")
    public String register(Users user, HttpServletRequest request) {
        if (user.getUsername().isEmpty()) {
            request.setAttribute("msg", "用户名不能为空");
        } else if (Objects.nonNull(userService.getByUsername(user.getUsername()))) {
            request.setAttribute("msg", "用户名已存在");
        } else {
            userService.add(user);
            request.setAttribute("msg", "注册成功,可以登录");
            return "/index/login.jsp";
        }
        return "/index/register.jsp";
    }

    /*
     *修改密码
     */
    @GetMapping("/passowrd")

    public String password() {
       return "/index/password.jsp";
    }

    /*
     *修改密码
     */
    @PostMapping("passwordUpdate")
    public String passwordUpdate(String password, String passwordNew, HttpServletRequest request,
                                 HttpSession session) {
        Users user = (Users) session.getAttribute("user");
        user = userService.get(user.getId());
        if (!user.getPassword().equals(SafeUtil.encode(password))) {
            request.setAttribute("msg", "原密码错误");
        } else {
            userService.updatePassword(user.getId(), passwordNew);
            request.setAttribute("msg", " 密码修改成功");
        }
        return "/index/password.jsp";
    }
    /**
     * 注销登录
     */
@GetMapping("/logout")
    public String logout(HttpSession session){
    session.removeAttribute("user");
    session.removeAttribute("cartCount");
    return "/index/login.jsp";
}
/**
 * 收货地址
 */
@GetMapping("/address")
    public String address(){
    return "/indrx/address.jsp";
}
    /**
     * 修改信息
     */
    @PostMapping("/addressUpdate")
    public String addressUpdate(String name,String phone,String address,
                                HttpServletRequest request,HttpSession session){
        Users user=(Users) session.getAttribute("user");
        userService.update(user.getId(),name,phone,address);//更新数据库
        session.setAttribute("user",userService.get(user.getId()));//更新session
        request.setAttribute("msg","信息修改成功");
        return "/index/address.jsp";
    }
}