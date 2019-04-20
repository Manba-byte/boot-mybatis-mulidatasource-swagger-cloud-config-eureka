package com.example.mulidatesource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableEurekaClient
//@RestController 测试是否取到git仓库的值
public class MulidatesourceApplication {


    public static void main(String[] args) {
        SpringApplication.run(MulidatesourceApplication.class, args);
    }

    /*@Value("${spring.datasource.test1.type}")
    String bb;

    @RequestMapping("/aa")
    public void aa(){
        System.out.println(bb);
    }*/
}
