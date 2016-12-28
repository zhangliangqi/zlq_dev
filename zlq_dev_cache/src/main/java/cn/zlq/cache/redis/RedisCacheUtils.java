package cn.zlq.cache.redis;

import cn.zlq.cache.CacheBaseUtils;
import cn.zlq.utils.RedisPropertiesUtils;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.msgpack.template.MapTemplate;
import org.msgpack.template.SetTemplate;
import org.msgpack.template.Template;
import org.msgpack.template.Templates;
import org.msgpack.type.Value;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.io.IOException;
import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangliangqi
 * @Title: RedisCacheUtils
 * @Description
 * @date 2016-12-28
 */
public class RedisCacheUtils<T> extends CacheBaseUtils<T> {

    //private static JedisPool jedisPool;单机模式用
    private static ShardedJedisPool jedisPool;//集群模式

    private static GenericObjectPoolConfig config;

    private static List<JedisShardInfo> jredis = Lists.newArrayList();

    private void init() {
        synchronized (RedisCacheFactory.class) {
            if (config == null) {
                config = new GenericObjectPoolConfig();
                config.setMaxIdle(RedisPropertiesUtils.getMaxIdle());
                config.setMaxTotal(RedisPropertiesUtils.getMaxTotal());
                config.setMinIdle(RedisPropertiesUtils.getMinIdle());
            }
            if (jredis.size() < 1) {
                String hosts = RedisPropertiesUtils.getRedisHost();
                String[] host = StringUtils.split(hosts, ",");
                for (String h : host) {
                    String[] hostPort = StringUtils.split(h, ":");
                    JedisShardInfo info = new JedisShardInfo(hostPort[0], hostPort[1]);
                    if (hostPort.length == 3) {
                        info.setPassword(hostPort[2]);
                    }
                    jredis.add(info);
                }
            }
            jedisPool = new ShardedJedisPool(config, jredis);
        }
    }

    public RedisCacheUtils(){
        init();
    }

    public void setJredis(List<JedisShardInfo> redis) {
        jredis = redis;
        init();
    }

    @Override
    public String getStringValue(Integer namespace, String key) {
        return Strings.emptyToNull(this.getValue(namespace, key).toString());
    }

    @Override
    public Integer getIntegerValue(Integer namespace, String key) {
        return this.getValue(namespace, key).asIntegerValue().intValue();
    }

    @Override
    public Boolean getBooleanValue(Integer namespace, String key) {
        return this.getValue(namespace, key).asBooleanValue().getBoolean();
    }

    @Override
    public Double getDoubleValue(Integer namespace, String key) {
        return this.getValue(namespace, key).asIntegerValue().doubleValue();
    }

    @Override
    public Object getObjectValue(Integer namespace, String key, Class<T> cls) {
        T t = null;
        ShardedJedis resource = null;
        try {
            resource = jedisPool.getResource();
            t = messagePack.read(resource.get(serializable(namespace, key)), cls);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        } finally {
            jedisPool.returnResource(resource);
        }
        return t;
    }

    @Override
    public Value getValue(Integer namespace, String key) {
        Value value = null;
        ShardedJedis resource = null;
        try {
            resource = jedisPool.getResource();
            value = messagePack.read(resource.get(serializable(namespace, key)));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            jedisPool.returnResource(resource);
        }
        return value;
    }

    @Override
    public List<T> getObjectListValue(Integer namespace, String key, Class cls) {
        Template<List<T>> template = messagePack.lookup(cls);
        List<T> list = Lists.newArrayList();
        ShardedJedis resource = null;
        try {
            resource = jedisPool.getResource();
            list = messagePack.read(resource.get(serializable(namespace, key)), template);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            jedisPool.returnResource(resource);
        }
        return list;
    }

    @Override
    public Map<String, Object> getMapValue(Integer namespace, String key) {
        Template<Object> template = messagePack.lookup(Object.class);
        Map<String, Object> map = Maps.newConcurrentMap();
        ShardedJedis resource = null;
        try {
            resource = jedisPool.getResource();
            map = messagePack.read(resource.get(serializable(namespace, key)), new MapTemplate<String, Object>(Templates.TString, template));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            jedisPool.returnResource(resource);
        }
        return map;
    }

    @Override
    public Set<Object> getSetValue(Integer namespace, String key) {
        Template<Object> template = messagePack.lookup(Object.class);
        Set<Object> set = Sets.newHashSet();
        ShardedJedis resource = null;
        try {
            resource = jedisPool.getResource();
            set = messagePack.read(resource.get(serializable(namespace, key)), new SetTemplate<Object>(template));
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        } finally {
            jedisPool.returnResource(resource);
        }
        return set;
    }

    @Override
    public void setValue(Integer namespace, String key, Object value, Integer timeOut) {
        jedisPool.getResource().setex(serializable(namespace, key), timeOut.intValue(), serializableObject(value));
    }

    @Override
    public void setValue(Integer namespace, String key, String value) {
        this.setValue(namespace, key, value, DEFUALT_TIME_OUT);
    }

    @Override
    public void setValue(Integer namespace, String key, T o) {
        this.setValue(namespace, key, o, DEFUALT_TIME_OUT);
    }

    @Override
    public void setValue(Integer namespace, String key, List<T> objs) {
        this.setValue(namespace, key, objs, DEFUALT_TIME_OUT);
    }

    @Override
    public void removeKey(Integer namespace, String key) {
        jedisPool.getResource().del(serializable(namespace, key));
    }
}
