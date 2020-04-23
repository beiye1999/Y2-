package com.bdqn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bdqn.*.dao")//加载mapper接口所在的目录
public class CarApplication {

    public static void main(String[] args) {
        SpringApplication.run(CarApplication.class, args);

    }

}
