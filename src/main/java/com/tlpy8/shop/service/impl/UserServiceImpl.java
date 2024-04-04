package com.tlpy8.shop.service.impl;

import com.tlpy8.shop.exception.ImoocMallException;
import com.tlpy8.shop.exception.ImoocMallExceptionEnum;
import com.tlpy8.shop.model.dao.UserMapper;
import com.tlpy8.shop.model.pojo.User;
import com.tlpy8.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUser() {
        return userMapper.selectByPrimaryKey(1);
    }

    @Override
    public void register(String userName, String password) throws ImoocMallException {
        // 查询用户名是否存在
        User result = userMapper.selectByName(userName);
        if (result != null) {
            throw new ImoocMallException(ImoocMallExceptionEnum.NAME_EXITS);
        }

        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);

        int count = userMapper.insertSelective(user);
        if (count == 0) {
            throw new ImoocMallException(ImoocMallExceptionEnum.INSERT_FAIL);
        }
    }
}