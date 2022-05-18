package com.example.goods.service;

import com.example.goods.pojo.Sku;
import com.github.pagehelper.PageInfo;

import java.util.List;

/****
 * @Author:admin
 * @Description:Sku业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SkuService {

    /***
     * 查询所有Sku
     * @return
     */
    List<Sku> findAll();

    /**
     * 根据id查询sku
     * @param id
     * @return
     */
    Sku findById(Long id);


    /**
     * 查询所有
     * @return
     */
    List<Sku> getAll();
}
