package cn.zlq.test;

/**
 * @author zhangliangqi
 * @Title: MainTest
 * @Package cn.zlq.test
 * @Description
 * @date 2016-06-30
 */
public class MainTest {

    public static void main(String[] args) {
        String str="";
        str= "222"+5+"3333";
        String s = "666"+str+"7777";
        System.out.println(s);

        StringBuffer sb = new StringBuffer();
        sb.append("222"+5).append("3333");
        StringBuffer sbf = new StringBuffer();
        sbf.append("666").append(sb).append("7777");
        System.out.println(sbf.toString());
    }
}
