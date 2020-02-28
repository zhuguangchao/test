package com.example.goods.service.impl;

import com.example.goods.dao.SkuMapper;
import com.example.goods.pojo.Sku;
import com.example.goods.service.SkuService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/****
 * @Author:admin
 * @Description:Sku业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuMapper skuMapper;


    @Override
    public List<Sku> findAll() {
        return skuMapper.findAll();
    }

    @Override
    public Sku findById(Long id) {
        return skuMapper.findById(id).get();
    }
}
