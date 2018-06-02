package com.example.mapper;

import com.example.entity.DishBrand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author baidu
 * @date 2018/5/13 下午10:30
 * @description ${TODO}
 **/

@Mapper
public interface DishBrandMapper {
    Integer insert(DishBrand dishBrand);
    DishBrand getDishBrand(@Param("id")Long id);
}
