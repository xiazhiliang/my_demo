package com.example.service;

import com.example.entity.DishBrand;
import com.example.entity.DishShop;

/**
 * @author baidu
 * @date 2018/5/13 下午10:54
 * @description ${TODO}
 **/
public interface DishBrandService {
    /**
     *
     * @param dishBrand
     * @return
     */
    Integer insertDishBrand(DishBrand dishBrand);

    /**
     *
     * @param dishShop
     * @return
     */
    Integer insertDishShop(DishShop dishShop);

    /**
     *
     * @param id
     * @return
     */
    DishBrand getDishBrandById(Long id);

    /**
     *
     * @param id
     * @return
     */
    DishShop getDishShop(Long id);
}
