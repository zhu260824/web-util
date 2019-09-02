package com.zl.common.config;

import java.util.Properties;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  11:05
 */
public class SystemUtil {
    private static Properties props = null;

    /**
     *获得系统属性集
     */
    static {
        props = System.getProperties();
    }

    /**
     * 操作系统名称
     */
    public static String getOSName() {
        return props.getProperty("os.name");
    }

    /**
     * 操作系统名称
     */
    public static String getOSArch() {
        return props.getProperty("os.arch");
    }

    /**
     * 操作系统版本
     */
    public static String getOSVersion() {
        return props.getProperty("os.version");
    }

    public static String getProperty(String key) {
        return props.getProperty(key);
    }

    public static void main(String[] args) {
        System.out.println(getOSName());
        System.out.println(getOSArch());
        System.out.println(getOSVersion());
        System.out.println("Java的运行环境版本：" + getProperty("java.version"));
        System.out.println("Java的运行环境供应商：" + getProperty("java.vendor"));
        System.out.println("Java供应商的URL：" + getProperty("java.vendor.url"));
        System.out.println("Java的安装路径：" + getProperty("java.home"));
        System.out.println("Java的虚拟机规范版本：" + getProperty("java.vm.specification.version"));
        System.out.println("Java的虚拟机规范供应商：" + getProperty("java.vm.specification.vendor"));
        System.out.println("Java的虚拟机规范名称：" + getProperty("java.vm.specification.name"));
        System.out.println("Java的虚拟机实现版本：" + getProperty("java.vm.version"));
        System.out.println("Java的虚拟机实现供应商：" + getProperty("java.vm.vendor"));
        System.out.println("Java的虚拟机实现名称：" + getProperty("java.vm.name"));
        System.out.println("Java运行时环境规范版本：" + getProperty("java.specification.version"));
        System.out.println("Java运行时环境规范供应商：" + getProperty("java.specification.vender"));
        System.out.println("Java运行时环境规范名称：" + getProperty("java.specification.name"));
        System.out.println("Java的类格式版本号：" + getProperty("java.class.version"));
        System.out.println("Java的类路径：" + getProperty("java.class.path"));
        System.out.println("加载库时搜索的路径列表：" + getProperty("java.library.path"));
        System.out.println("默认的临时文件路径：" + getProperty("java.io.tmpdir"));
        System.out.println("一个或多个扩展目录的路径：" + getProperty("java.ext.dirs"));
        System.out.println("操作系统的名称：" + getProperty("os.name"));
        System.out.println("操作系统的构架：" + getProperty("os.arch"));
        System.out.println("操作系统的版本：" + getProperty("os.version"));
        System.out.println("文件分隔符：" + getProperty("file.separator")); //在 unix 系统中是”／”
        System.out.println("路径分隔符：" + getProperty("path.separator")); //在 unix 系统中是”:”
        System.out.println("行分隔符：" + getProperty("line.separator")); //在 unix 系统中是”/n”
        System.out.println("用户的账户名称：" + getProperty("user.name"));
        System.out.println("用户的主目录：" + getProperty("user.home"));
        System.out.println("用户的当前工作目录：" + getProperty("user.dir"));
    }
}
