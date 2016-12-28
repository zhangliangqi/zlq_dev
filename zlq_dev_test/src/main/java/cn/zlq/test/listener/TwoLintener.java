package cn.zlq.test.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

/**
 * @author zhangliangqi
 * @Title: TwoLintener
 * @Package cn.zlq.test.listener
 * @Description
 * @date 2016-07-01
 */
public class TwoLintener implements ApplicationListener{
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println(" 我是监听器2 two lintener ,"+applicationEvent.getTimestamp());
    }
}
