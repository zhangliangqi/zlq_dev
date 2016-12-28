package cn.zlq.utils;

import cn.zlq.constant.ErrorCodeEnum;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zhangliangqi
 * @Title: PropertiesUtils
 * @Package cn.zlq.utils
 * @Description
 * @date 2016-12-09
 */
public  class PropertiesUtils {


    private static Logger logger = Logger.getLogger(PropertiesUtils.class);

    private static final Lock readLock = new ReentrantReadWriteLock().readLock();

    protected PropertiesUtils(){

    }

    protected synchronized static Properties loadFile(Properties properties, String filename) {
        if (properties != null) {
            return properties;
        }
        properties = new Properties();
        Preconditions.checkArgument(StringUtils.isNotEmpty(filename), ErrorCodeEnum.SYS_ERROR.getValue());
        InputStream in = null;
        try {
            in = ClassLoader.getSystemResourceAsStream(filename);
            properties.load(in);
        } catch (Exception e) {
            logger.error(e);
            throw new RuntimeException(ErrorCodeEnum.SYS_ERROR.getValue());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    logger.error(e);
                }
            }
        }
        return properties;
    }

    protected static String getVal(Properties properties,String fileName,String key) {
        if(properties == null)
            properties = loadFile(properties,fileName);
        readLock.lock();
        String value = properties.getProperty(key);
        readLock.unlock();
        return value;
    }


}
