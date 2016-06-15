package com.bigdata.caicf;

import com.alibaba.fastjson.JSON;
import com.bigdata.caicf.dao.PageDataMapper;
import com.bigdata.caicf.dao.PageInfoMapper;
import com.bigdata.caicf.model.PageData;
import com.bigdata.caicf.model.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.Date;

/**
 * Created by caicf on 2016/6/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDB {

    @Autowired
    private PageDataMapper pageDataMapper;

    @Autowired
    private PageInfoMapper pageInfoMapper;

    @Test
    public void test1() throws ClassNotFoundException, SQLException {
        PageInfo pageInfo=pageInfoMapper.selectByPrimaryKey(1);
        System.out.println(JSON.toJSONString(pageInfo));

        String str=JSON.toJSONString(pageInfo);

        PageData pageData=new PageData();
        pageData.setValue("fsdafsaf");
        pageData.setDate(new Date());
        pageData.setObjId(2);
        int i=pageDataMapper.insert(pageData);


        PageInfo info1= JSON.parseObject(str,PageInfo.class);
        System.out.println(info1.getComments());
        //JDBC操作可行System.out.println(i);
//        String sql="select * from page_data";
//        Class.forName("com.mysql.jdbc.Driver");
//        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bigdata", "root", "8860");
//        PreparedStatement preparedStatement=conn.prepareStatement(sql);
//        ResultSet resultSet=preparedStatement.executeQuery();
//        while (resultSet.next()){
//            System.out.println(          resultSet.getString(2)   );
//            System.out.println(          resultSet.getString(3)   );
//        }



    }

}
