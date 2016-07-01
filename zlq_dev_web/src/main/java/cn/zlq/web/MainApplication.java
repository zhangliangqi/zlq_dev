package cn.zlq.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zhangliangqi
 * @Title: cn.zlq.web.MainApplication
 * @Package PACKAGE_NAME
 * @Description
 * @date 2016-05-24
 */
@EnableAutoConfiguration
@ComponentScan
public class MainApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class,args);
    }
}
