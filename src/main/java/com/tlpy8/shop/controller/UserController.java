package com.tlpy8.shop.controller;

import com.tlpy8.shop.common.ApiRestResponse;
import com.tlpy8.shop.exception.ImoocMallException;
import com.tlpy8.shop.exception.ImoocMallExceptionEnum;
import com.tlpy8.shop.model.pojo.User;
import com.tlpy8.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/test")
    @ResponseBody
    public User getUserById() {
        return userService.getUser();
    }

    @PostMapping("/register")
    @ResponseBody
    public ApiRestResponse register(@RequestParam("userName") String userName, @RequestParam("password") String password) throws ImoocMallException {
        if (StringUtils.isEmpty(userName)) {
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_USER_NAME);
        }

        if (StringUtils.isEmpty(password)) {
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_PASSWORD);
        }

        // 密码长度不能少于0位
        if(password.length() < 8) {
            return ApiRestResponse.error(ImoocMallExceptionEnum.NEED_PASSWORD_TOO_SHORT);
        }

        userService.register(userName, password);

        return ApiRestResponse.success();
    }

}
