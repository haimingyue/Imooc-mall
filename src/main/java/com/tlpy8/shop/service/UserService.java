package com.tlpy8.shop.service;

import com.tlpy8.shop.exception.ImoocMallException;
import com.tlpy8.shop.model.pojo.User;

public interface UserService {
    User getUser();

    void register(String userName, String password) throws ImoocMallException;
}
