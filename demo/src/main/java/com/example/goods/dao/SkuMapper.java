package com.example.goods.dao;

import com.example.goods.pojo.Sku;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/****
 * @Author:admin
 * @Description:Sku的Dao
 * @Date 2019/6/14 0:12
 *****/
public interface SkuMapper extends CrudRepository<Sku, Long> {

    List<Sku> findAll();
}
