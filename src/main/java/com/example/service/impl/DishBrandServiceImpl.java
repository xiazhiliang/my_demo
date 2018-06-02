package com.example.service.impl;

import com.example.configuration.datasource.DataSource;
import com.example.entity.DishBrand;
import com.example.entity.DishShop;
import com.example.mapper.DishBrandMapper;
import com.example.mapper.DishShopMapper;
import com.example.service.DishBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author baidu
 * @date 2018/5/13 下午10:57
 * @description ${TODO}
 **/
@Service("dishBrandService")
public class DishBrandServiceImpl implements DishBrandService {

    @Autowired
    private DishBrandMapper dishBrandMapper;
    @Autowired
    private DishShopMapper dishShopMapper;

    @Override
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertDishBrand(DishBrand dishBrand) {
        return dishBrandMapper.insert(dishBrand);
    }

    @Override
    @DataSource
    @Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
    public Integer insertDishShop(DishShop dishShop) {
        dishShopMapper.insert(dishShop);
        throw new RuntimeException("我抛出异常了");
    }

    @Override
    public DishBrand getDishBrandById(Long id) {
        return dishBrandMapper.getDishBrand(id);
    }

    @Override
    @DataSource
    public DishShop getDishShop(Long id) {
        return dishShopMapper.getDishShop(id);
    }

}
