package cn.zlq.test.web;

import cn.zlq.utils.LocalCacheHandle;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

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
        return "hello world,"+ LocalCacheHandle.get("test1");
    }
}
