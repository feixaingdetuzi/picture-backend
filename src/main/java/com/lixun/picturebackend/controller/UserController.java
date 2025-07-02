package com.lixun.picturebackend.controller;

import com.lixun.picturebackend.common.BaseResponse;
import com.lixun.picturebackend.common.ResultUtils;
import com.lixun.picturebackend.exception.ErrorCode;
import com.lixun.picturebackend.exception.ThrowUtils;
import com.lixun.picturebackend.model.dto.user.UserRegisterRequest;
import com.lixun.picturebackend.model.entity.User;
import com.lixun.picturebackend.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;
    /**
     * 用户注册接口
     */
    @PostMapping("/register")
    public BaseResponse<Long> register(@RequestBody UserRegisterRequest userRegisterRequest) {
        ThrowUtils.throwIf(userRegisterRequest==null, ErrorCode.PARAMS_ERROR);
        String userAccount = userRegisterRequest.getUserAccount();
        String userPassword = userRegisterRequest.getUserPassword();
        String checkPassword = userRegisterRequest.getCheckPassword();
        long result = userService.userRegister(userAccount, userPassword, checkPassword);
        return ResultUtils.success(result);
    }
}
