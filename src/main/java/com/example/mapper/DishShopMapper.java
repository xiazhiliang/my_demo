package com.example.mapper;

import com.example.entity.DishBrand;
import com.example.entity.DishShop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author baidu
 * @date 2018/5/13 下午10:30
 * @description ${TODO}
 **/

@Mapper
public interface DishShopMapper {
    Integer insert(DishShop dishShop);

    DishShop getDishShop(@Param("id")Long id);
}
