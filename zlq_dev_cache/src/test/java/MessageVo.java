import org.msgpack.annotation.Message;

import java.util.List;

/**
 * @author zhangliangqi
 * @Title: MessageVo
 * @Package PACKAGE_NAME
 * @Description
 * @date 2016-12-20
 */
@Message
public class MessageVo {

    private String str ;

    private Integer count;

    private Boolean isEmpty;

    private List list;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Boolean getEmpty() {
        return isEmpty;
    }

    public void setEmpty(Boolean empty) {
        isEmpty = empty;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "MessageVo{" +
                "str='" + str + '\'' +
                ", count=" + count +
                ", isEmpty=" + isEmpty +
                '}';
    }
}
