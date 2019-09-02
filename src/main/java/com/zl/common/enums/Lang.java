package com.zl.common.enums;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  14:56
 */
public enum Lang {
    //中文
    ZH("ZH"),
    //英文
    EN("EN"),
    //繁体中文(台湾)
    ZT("ZT"),
    //繁体中文(香港)
    ZTH("ZTH"),
    //西班牙语
    ES("ES"),
    //葡萄牙语
    PT("PT"),
    //法语
    FR("FR"),
    //德语
    DE("DE"),
    //意大利语
    IT("IT"),
    //俄语
    RU("RU"),
    //日语
    JA("JA"),
    //韩语
    KO("KO"),
    //阿拉伯语
    AR("AR"),
    //土耳其语
    TR("TR"),
    //泰语
    TH("TH"),
    //越南语
    VI("VI"),
    //荷兰语
    NL("NL"),
    //希伯来语
    HE("HE"),
    //印尼语
    ID("ID"),
    //波兰语
    PL("PL"),
    //印地语
    HI("HI"),
    //乌克兰语
    UK("UK"),

    /**** 截止 ****/
    ;
    /**** 截止 ****/

    private String type;

    private Lang(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Lang{" +
            "type='" + type + '\'' +
            '}';
    }
}
