package com.cyl.distributedlock;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author cyl
 * @date 2023-06-16 9:34
 * @description 主启动类
 */
@SpringBootApplication
@MapperScan(basePackages = "com.cyl.distributedlock.mapper")
public class DistributedLockApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedLockApplication.class, args);
    }
}
