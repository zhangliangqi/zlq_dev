package cn.zlq.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;

/**
 * @author zhangliangqi
 * @Title: LocalCacheHandle
 * @Package cn.zlq.utils
 * @Description
 * @date 2016-11-07
 */
public class LocalCacheHandle {

    private static final Map<String,Object>  map = new ConcurrentHashMap<String, Object>();

   // private static Lock lock = new
    private LocalCacheHandle(){
    }

    public static void set(String key,Object value){
        map.put(key,value);
    }

    public static void set(String key,Object value,Long currs){
        map.put(key,value);
    }

    public static Object get(String key){
        return map.get(key);
    }

    public static boolean containsKey(String key){
        return map.containsKey(key);
    }
}
