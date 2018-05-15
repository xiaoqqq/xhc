package com.xhc.xhcapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xhc.xhcapi.dao")
@SpringBootApplication
public class XhcApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(XhcApiApplication.class, args);
    }
}
