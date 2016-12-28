import cn.zlq.cache.redis.RedisCacheFactory;
import com.google.common.collect.Lists;
import org.msgpack.MessagePack;
import org.msgpack.annotation.Message;
import org.msgpack.template.ListTemplate;
import org.msgpack.template.Template;
import org.msgpack.template.Templates;
import org.msgpack.template.builder.ReflectionTemplateBuilder;
import org.msgpack.type.Value;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.yaml.snakeyaml.tokens.Token.ID.Value;

/**
 * @author zhangliangqi
 * @Title: MsgPackTest
 * @Package PACKAGE_NAME
 * @Description
 * @date 2016-12-20
 */
public class MsgPackTest {

    public static void main(String[] args) {
        MessagePack pack = new MessagePack();
        try {
            byte[] bt = pack.write("123456");
            Value tt = pack.read(bt);
            System.out.println(tt.toString());

            MessageVo vo = new MessageVo();
            vo.setCount(1);
            vo.setEmpty(true);
            vo.setStr("我很好");

            MessageVo vo1 = new MessageVo();
            vo1.setCount(2);
            vo1.setEmpty(true);
            vo1.setStr("我很好2");

            List<MessageVo> vos = Lists.newArrayList();
            vos.add(vo);
            vos.add(vo1);

            System.out.println(vos.toString());
            Class cls = vo.getClass();
            Annotation[] as = cls.getAnnotations();
            System.out.println(as[0].annotationType().getName().equals(Message.class.getName()));
            System.out.println(as[0].toString());
            pack = new MessagePack();
            byte[] bb = pack.write(vos);
            Template<List<MessageVo>> vot = Templates.tList(pack.lookup(MessageVo.class));
            List<MessageVo> vv = pack.read(bb, vot);
            System.out.println(vv.toString());

            RedisCacheFactory.INSTANCE.getInstance().setValue(0001,"test1222","123456ddd");

            System.out.println(RedisCacheFactory.INSTANCE.getInstance().getStringValue(0001,"test1222"));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
