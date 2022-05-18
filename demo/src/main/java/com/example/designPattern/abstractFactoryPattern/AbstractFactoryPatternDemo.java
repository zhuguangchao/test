package com.example.designPattern.abstractFactoryPattern;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;

/**
 * @Auther: 朱广超
 * @Date: 2020/03/08/13:47
 * @package com.example.designPattern.abstractFactoryPattern
 * @Description:
 */
public class AbstractFactoryPatternDemo {
    public static void main(String[] args) {
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        shape1.draw();
        Shape shape2 = shapeFactory.getShape("RECTANGLE");
        shape2.draw();

        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        Color color1 = colorFactory.getColor("RED");
        color1.fill();

        //SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //String resource = "sqlMapConfig.xml";
        //InputStream inputStream = AbstractFactoryPatternDemo.class.getClassLoader().getResourceAsStream(resource);
        //SqlSessionFactory factory = sqlSessionFactoryBuilder.build(inputStream);
        //SqlSession sqlSession = factory.openSession();
        //Object o = sqlSession.selectOne("select * from tb_user where id = 1148477873208696832");
        //Object mapper = sqlSession.getMapper();
    }
}
