package cn.zlq.utils;

import com.google.common.primitives.Longs;

import java.util.Properties;

/**
 * @author zhangliangqi
 * @Title: RedisPropertiesUtils
 * @Package cn.zlq.utils
 * @Description
 * @date 2016-12-09
 */
public class RedisPropertiesUtils extends PropertiesUtils {

    private static final String REDIS_PATH = "redis/redis.properties";

    private static Properties properties;

    static {
        properties = loadFile(properties, REDIS_PATH);
    }

    private RedisPropertiesUtils() {
        super();
    }

    public static String getValue(String key) {
        return getVal(properties, REDIS_PATH, key);
    }

    public static String getDefMaxTotal() {
        return getValue("DEFAULT_MAX_TOTAL");
    }

    public static String getDefMaxIdle() {
        return getValue("DEFAULT_MAX_IDLE");
    }

    public static String getDefMinIdle() {
        return getValue("DEFAULT_MIN_IDLE");
    }

    public static Integer getMaxTotal() {
        return Integer.valueOf(getValue("maxTotal"));
    }

    public static Integer getMaxIdle() {
        return Integer.valueOf(getValue("maxIdle"));
    }

    public static Integer getMinIdle() {
        return Integer.valueOf(getValue("minIdle"));
    }

    public static String getRedisHost() {
        return getValue("redis_host");
    }

    public static Integer getRedisPort() {
        return Integer.valueOf(getValue("redis_port"));
    }

    public static Long getCollectTimeOut() {
        return Long.valueOf(getValue("redis_timeout"));
    }
}

