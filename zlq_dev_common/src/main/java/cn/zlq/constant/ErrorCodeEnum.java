package cn.zlq.constant;

/**
 * Created by xn041911 on 2016/12/9.
 */
public enum ErrorCodeEnum {
    SYS_ERROR("系统错误","0001");
    protected String text;

    protected String value;

    ErrorCodeEnum(String text,String value){
        this.text = text;
        this.value = value;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
