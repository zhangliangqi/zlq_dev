import org.msgpack.annotation.Message;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangliangqi
 * @Title: CommonCollections
 * @Description
 * @date 2016-12-23
 */
@Message
public class CommonCollections {

    private List list;

    private Map map;

    private Set set;


    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
    }

    @Override
    public String toString() {
        return "CommonCollections{" +
                "list=" + list +
                ", map=" + map +
                ", set=" + set +
                '}';
    }
}
