package com.example.goods.dao.mysql;

import com.example.goods.pojo.Sku;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/****
 * @Author:admin
 * @Description:Sku的Dao
 * @Date 2019/6/14 0:12
 *****/
public interface SkuMapper{

    List<Sku> findAll();

    //@Query(value = "select new com.example.goods.pojo.Sku(id,name) from tb_sku")
    List<Sku> getAllSku();

    Sku findById(@Param("id") Long id);
}
