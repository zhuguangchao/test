package com.example.goods.service.impl;

import com.example.goods.dao.mysql.SkuMapper;
import com.example.goods.pojo.Sku;
import com.example.goods.service.SkuService;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/****
 * @Author:admin
 * @Description:Sku业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    private SkuMapper skuMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Override
    public List<Sku> findAll() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Sku> sku = sqlSession.selectList("select * from tb_user");
        return sku;
    }

    //@Override
    //public List<Sku> findAll() {
    //    return skuMapper.findAll();
    //}

    @Override
    public Sku findById(Long id) {
        return skuMapper.findById(id);
    }

    @Override
    public List<Sku> getAll(){
        return skuMapper.getAllSku();
        //return null;
    }
}
