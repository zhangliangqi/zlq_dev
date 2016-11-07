package cn.zlq.test.web;

import cn.zlq.test.listener.OneLintener;
import cn.zlq.test.listener.TwoLintener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;

/**
 * @author zhangliangqi
 * @Title: cn.zlq.test.web.TestApplication
 * @Package PACKAGE_NAME
 * @Description
 * @date 2016-06-13
 */
@SpringBootApplication
public class TestApplication {

    public static void main(String[] args) {

        SpringApplication application =new SpringApplication(TestApplication.class);
        ApplicationListener [] listeners = new ApplicationListener[]{new OneLintener(), new TwoLintener()};
        application.addListeners(listeners);
        application.run(args);
    }

}
