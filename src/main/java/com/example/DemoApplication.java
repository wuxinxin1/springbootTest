package com.example;

import com.example.db.jdbc.JdbcService;
import com.example.db.jdbctemplate.JdbcTemplateTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.sql.SQLException;

/**
 * @author wuxinxin
 */
@SpringBootApplication
@RestController
@RequestMapping("/test")
public class DemoApplication {

    @Autowired
    private JdbcTemplateTestService jdbcTemplateTestService;

    @Autowired
    private JdbcService jdbcService;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/test1")
    public String test1(){
        return "hello spring boot";
    }

    /**
     *  //测试jdbcTemplate
     *  1.jdbcTemplate是对jdbc的封装，操作jdbcTemplate相当于操作jdbc
     * @return
     */

    @GetMapping("/test2")
    public String jdbcTemplateTest(){
        jdbcTemplateTestService.selectTest();
        return "success";
    }

    @GetMapping("/test2/{tradeId}")
    public String jdbcTemplateTest(@PathVariable("tradeId") int tradeId) throws IOException {
        jdbcTemplateTestService.updateTest(tradeId);
        return "success";
    }


    /**
     * 测试jdbc
     * @return
     * @throws IOException
     */
    @GetMapping("/test3")
    public String jdbcTemplateTest3() throws IOException, SQLException {
        jdbcService.selectTest();
        return "success";
    }
}
