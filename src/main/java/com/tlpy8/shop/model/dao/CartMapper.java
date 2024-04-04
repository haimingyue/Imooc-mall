package com.tlpy8.shop.model.dao;

import com.tlpy8.shop.model.pojo.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);
}