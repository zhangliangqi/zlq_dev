package cn.zlq.cache;

import org.apache.log4j.Logger;
import org.msgpack.MessagePack;
import org.msgpack.type.Value;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangliangqi
 * @Title: CacheBaseUtils
 * @Package cn.zlq.cache.redis
 * @Description
 * @date 2016-12-07
 */
public abstract class CacheBaseUtils<T> {

    protected static Logger logger = Logger.getLogger(CacheBaseUtils.class);

    public static final Integer DEFUALT_TIME_OUT = 60;//默认超时时间

    public static final MessagePack messagePack = new MessagePack();//默认超时时间

    public abstract String getStringValue(Integer namespace, String key);

    public abstract Integer getIntegerValue(Integer namespace, String key);

    public abstract Boolean getBooleanValue(Integer namespace, String key);

    public abstract Double getDoubleValue(Integer namespace, String key);

    public abstract Object getObjectValue(Integer namespace, String key, Class<T> cls);

    public abstract Value getValue(Integer namespace, String key);

    public abstract List<T> getObjectListValue(Integer namespace, String key,Class cls);

    public abstract Map<String,Object> getMapValue(Integer namespace, String key);

    public abstract Set<Object> getSetValue(Integer namespace, String key);

    public abstract void setValue(Integer namespace, String key, Object o, Integer timeOut);

    public abstract void setValue(Integer namespace, String key, String value);

    public abstract void setValue(Integer namespace, String key, T o);

    public abstract void setValue(Integer namespace, String key, List<T> objs);

    public abstract void removeKey(Integer namespace, String key);

    protected static byte[] serializable(Integer namespace, String key) {
        byte[] result = new byte[0];
        try {
            if (namespace == null || namespace == 0) {
                result = messagePack.write(key);
            } else {
                result = messagePack.write(namespace +"-"+ key);
            }
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    protected static byte[] serializable(String key) {
        byte[] result = new byte[0];
        try {
            result = messagePack.write(key);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }

    protected static byte[] serializableObject(Object obj) {
        byte[] result = new byte[0];
        try {
            result = messagePack.write(obj);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        return result;
    }
}
