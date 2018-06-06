package com.example.web.controller;

import com.example.service.DishBrandService;
import com.example.web.controller.vo.ApiResultVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author baidu
 * @date 2018/6/3 下午10:06
 * @description ${TODO}
 **/

@RestController
@RequestMapping("/api/dish")
public class DishBrandController {
    private final static Logger LOGGER = LoggerFactory.getLogger(DishBrandController.class);
    @Autowired
    private DishBrandService dishBrandService;

    @RequestMapping("/list")
    public ApiResultVO list(){
        dishBrandService.getDishBrandById(1l);
        return new ApiResultVO();
    }
}
