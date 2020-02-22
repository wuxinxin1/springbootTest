package com.example.db.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author wuxinxin
 */
@Service
public class JdbcTemplateTestService {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public void selectTest(){
        String sql="select * from mytest.tradelog limit 1";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        System.out.println(maps);
    }


    /**
     * 使用@Transactional这个事务
     * @param i
     * @throws IOException
     */
    //@Transactional(rollbackFor = Exception.class)
    @Transactional(rollbackFor = ArithmeticException.class)
    public void updateTest(int i) throws IOException {
        String sql="update tradelog set tradeid=? where id=1";
        jdbcTemplate.update(sql,i);

        //抛出异常
        //int j = 1/0;
        throw new IOException();
    }


}
