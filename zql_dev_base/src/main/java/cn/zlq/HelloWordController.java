package cn.zlq;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangliangqi
 * @Title: HelloWordController
 * @Package cn.zlq.web
 * @Description
 * @date 2016-05-24
 */
@RestController
public class HelloWordController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello word";
    }
}
