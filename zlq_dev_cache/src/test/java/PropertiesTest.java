import cn.zlq.utils.RedisPropertiesUtils;

/**
 * @author zhangliangqi
 * @Title: PropertiesTest
 * @Package PACKAGE_NAME
 * @Description
 * @date 2016-12-09
 */
public class PropertiesTest {

    public static void main(String[] args) {
        System.out.println(RedisPropertiesUtils.getValue("redis_host"));
    }
}
