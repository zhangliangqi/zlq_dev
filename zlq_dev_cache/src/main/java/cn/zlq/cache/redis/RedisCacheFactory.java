package cn.zlq.cache.redis;

/**
 * @author zhangliangqi
 * @Title: RedisCacheFactory
 * @Package cn.zlq.cache.redis
 * @Description
 * @date 2016-12-09
 */
public enum RedisCacheFactory {
    INSTANCE;

    private RedisCacheUtils redisUtils;

    private RedisCacheFactory() {
        redisUtils = new RedisCacheUtils();
    }

    public RedisCacheUtils getInstance() {
        return redisUtils;
    }
}
