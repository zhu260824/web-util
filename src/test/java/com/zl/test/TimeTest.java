package com.zl.test;

import com.zl.common.date.ZDateUtil;
import org.junit.Test;

import java.util.Date;

/**
 * @author ZL 朱林</a>
 * @Version 1.0
 * @Description TODO
 * @date 2019/09/02  10:55
 */
public class TimeTest {
    @Test
    public void testTime01(){
        int month=  ZDateUtil.getDateMonth(new Date(System.currentTimeMillis()));
        System.out.println(month);
    }
}
