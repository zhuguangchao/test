package com.example.goods.controller;

import com.example.goods.entity.Result;
import com.example.goods.entity.StatusCode;
import com.example.goods.pojo.Sku;
import com.example.goods.service.SkuService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/****
 * @Author:admin
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/sku")
public class SkuController {

    @Autowired
    public SkuService skuService;

    /***
     * 查询Sku全部数据
     * @return
     */
    @GetMapping
    public Result<List<Sku>> findAll() {
        //调用SkuService实现查询所有Sku
        List<Sku> list = skuService.findAll();
        return new Result<List<Sku>>(true, StatusCode.OK, "查询成功", list);
    }

    /***
     * 查询Sku单个数据
     * @return
     */
    @GetMapping("/{id}")
    public Result<Sku> findById(@PathVariable Long id) {
        //调用SkuService实现查询所有Sku
        Sku sku = skuService.findById(id);
        return new Result<Sku>(true, StatusCode.OK, "查询成功", sku);
    }
}
