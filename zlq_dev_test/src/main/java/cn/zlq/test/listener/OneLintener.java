package cn.zlq.test.listener;

import cn.zlq.utils.LocalCacheHandle;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhangliangqi
 * @Title: OneLintener
 * @Package cn.zlq.test.listener
 * @Description
 * @date 2016-07-01
 */
public class OneLintener  implements ApplicationListener{

    private static  int count = 0;

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        if(LocalCacheHandle.containsKey("test1")){
            System.out.println("count++;"+count+";cache["+LocalCacheHandle.get("test1"));
            count++;
        }else {
            LocalCacheHandle.set("test1", applicationEvent.getSource());
        }
        System.out.println("你好 我是监听器1 one lintener run"+System.currentTimeMillis());
    }
}

