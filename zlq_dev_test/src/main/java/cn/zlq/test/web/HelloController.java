package cn.zlq.test.web;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangliangqi
 * @Title: HelloController
 * @Package cn.zlq.test.web
 * @Description
 * @date 2016-06-13
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }
}
