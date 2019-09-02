package com.zl.common.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Locale;

/**
 * @author ZL @朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  15:28
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext mContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.mContext = applicationContext;
    }

    // 传入线程中
    public static <T> T getBean(String beanName) {
        return (T) mContext.getBean(beanName);
    }

    // 国际化使用
    public static String getMessage(String key) {
        return mContext.getMessage(key, null, Locale.getDefault());
    }

    // 获取当前环境参数
    public static String getActiveProfile() {
        String[] profiles = mContext.getEnvironment().getActiveProfiles();
        if (profiles != null && profiles.length > 0) {
            return profiles[0];
        }
        return "";
    }
}
