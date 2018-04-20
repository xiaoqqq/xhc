package com.xhc.xcxapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xhc.xcxapi.dao")
@SpringBootApplication
public class XcxApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(XcxApiApplication.class, args);
    }
}
