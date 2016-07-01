package cn.zlq.test.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author zhangliangqi
 * @Title: OneLintener
 * @Package cn.zlq.test.listener
 * @Description
 * @date 2016-07-01
 */
public class OneLintener  implements ApplicationListener{
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println("one lintener run");
    }
}
