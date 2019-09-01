package com.zl.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author zl
 * @Version 1.0
 * @Description TODO
 * @date 2019/06/24  11:17
 */
public class ZDateUtil {

    public static Date getLastDay(Date date) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_YEAR, -1);
        return calendar.getTime();
    }

    public static Date getDateMinute(Date date, int minute) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minute);
        return calendar.getTime();
    }

    public static List<Date> getForwardNowDay(int num) {
        List<Date> dates = new ArrayList<>(num);
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        for (int i = 0; i < num; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, -1);
            dates.add(calendar.getTime());
        }
        return dates;
    }

    public static List<Date> getForwardDay(Date date, int num) {
        List<Date> dates = new ArrayList<>(num);
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        for (int i = 0; i < num; i++) {
            calendar.add(Calendar.DAY_OF_YEAR, -1);
            dates.add(calendar.getTime());
        }
        return dates;
    }

    public static List<Date> getMonthAllDay(Date date) {
        List<Date> dates = new ArrayList<>();
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        int min = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
        int max = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        for (int i = min; i < max + 1; i++) {
            calendar.set(Calendar.DAY_OF_MONTH, i);
            dates.add(calendar.getTime());
        }
        return dates;
    }

    public static int getDayInMonthIndex(Date date) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static Date getWeekStart(Date nowDay) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTimeInMillis(nowDay.getTime());
        int mondayPlus = getMondayPlus(calendar.get(Calendar.DAY_OF_WEEK));
        calendar.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = calendar.getTime();
        return monday;
    }

    public static Date getWeekEnd(Date nowDay) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTimeInMillis(nowDay.getTime());
        int mondayPlus = getMondayPlus(calendar.get(Calendar.DAY_OF_WEEK));
        calendar.add(GregorianCalendar.DATE, mondayPlus + 6);
        Date monday = calendar.getTime();
        return monday;
    }

    public static Date getLastWeekStart(Date nowDay) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTimeInMillis(nowDay.getTime());
        calendar.add(GregorianCalendar.WEEK_OF_YEAR, -1);
        int mondayPlus = getMondayPlus(calendar.get(Calendar.DAY_OF_WEEK));
        calendar.add(GregorianCalendar.DATE, mondayPlus);
        Date monday = calendar.getTime();
        return monday;
    }

    public static Date getLastWeekEnd(Date nowDay) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTimeInMillis(nowDay.getTime());
        calendar.add(GregorianCalendar.WEEK_OF_YEAR, -1);
        int mondayPlus = getMondayPlus(calendar.get(Calendar.DAY_OF_WEEK));
        calendar.add(GregorianCalendar.DATE, mondayPlus + 6);
        Date monday = calendar.getTime();
        return monday;
    }

    public static Date getMonthStart(Date nowDay) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTimeInMillis(nowDay.getTime());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    public static Date getMonthEnd(Date nowDay) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTimeInMillis(nowDay.getTime());
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    public static Date getLastMonthStart(Date nowDay) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTimeInMillis(nowDay.getTime());
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    public static Date getLastMonthDay(Date nowDay) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTimeInMillis(nowDay.getTime());
        calendar.add(Calendar.MONTH, -1);
        return calendar.getTime();
    }

    public static Date getLastMonthEnd(Date nowDay) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTimeInMillis(nowDay.getTime());
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        return calendar.getTime();
    }

    public static Date getLastYearDay(Date nowDay) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTimeInMillis(nowDay.getTime());
        calendar.add(Calendar.YEAR, -1);
        return calendar.getTime();
    }

    public static int getDateYear(Date date) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        return calendar.get(Calendar.YEAR);
    }

    public static int getDateMonth(Date date) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.setTimeInMillis(date.getTime());
        return calendar.get(Calendar.MONTH) + 1;
    }

    public static int getDateMonthDayNum(int year, int month) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static Date getDateYearMonth(int year, int month) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.getTime();
    }

    public static int getDaySpaceMonths(Date start, Date end) {
        GregorianCalendar startCalendar = (GregorianCalendar)Calendar.getInstance();
        startCalendar.setTime(start);
        startCalendar.set(Calendar.DAY_OF_MONTH, startCalendar.getActualMinimum(Calendar.DAY_OF_MONTH));
        startCalendar.set(Calendar.HOUR_OF_DAY, 0);
        startCalendar.set(Calendar.MINUTE, 0);
        startCalendar.set(Calendar.SECOND, 0);
        GregorianCalendar endCalendar = (GregorianCalendar)Calendar.getInstance();
        endCalendar.setTime(end);
        endCalendar.set(Calendar.DAY_OF_MONTH, startCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        endCalendar.set(Calendar.HOUR_OF_DAY, 23);
        endCalendar.set(Calendar.MINUTE, 59);
        endCalendar.set(Calendar.SECOND, 59);
        int count = 0;
        while (startCalendar.getTime().before(endCalendar.getTime())) {
            count = count + 1;
            startCalendar.add(Calendar.DAY_OF_YEAR, 1);
        }
        return count;
    }

    public static int getMaxMonthDay(int year, int month) {
        GregorianCalendar calendar = (GregorianCalendar)Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    public static Date setDateToMinHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
        return calendar.getTime();
    }

    public static Date setDateToMaxHour(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), 23, 59, 59);
        return calendar.getTime();
    }

    // 获得当前日期与本周一相差的天数
    public static int getMondayPlus(int dayOfWeek) {
        if (dayOfWeek == 1) {
            return -6;
        } else {
            return 2 - dayOfWeek;
        }
    }

    public static Date getParseTime(String time, String pattern) {
        return getParseTime(time, pattern, new Date(System.currentTimeMillis()));
    }

    public static Date getParseTime(String time, String pattern, Date defaultTime) {
        Date date = null;
        if (!StringUtil.isEmpty(time)) {
            try {
                date = new SimpleDateFormat(pattern).parse(time);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        if (null == date) {
            date = defaultTime;
        }
        return date;
    }

    public static java.sql.Date javaDateToSqlDate(Date jDate) {
        return new java.sql.Date(jDate.getTime());
    }

    public static Date composeDayAndTime(Date day, long time) {
        GregorianCalendar dayCalendar = (GregorianCalendar)Calendar.getInstance();
        dayCalendar.setTime(day);
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String stime = timeFormat.format(time);
        String[] times = stime.split(":");
        int hour = Integer.parseInt(times[0]);
        int min = Integer.parseInt(times[1]);
        int sec = Integer.parseInt(times[2]);
        dayCalendar.set(Calendar.HOUR, hour);
        dayCalendar.set(Calendar.MINUTE, min);
        dayCalendar.set(Calendar.SECOND, sec);
        return dayCalendar.getTime();
    }

    public static Date composeDayAndTime(Date day, int hour, int min, int sec) {
        GregorianCalendar dayCalendar = (GregorianCalendar)Calendar.getInstance();
        dayCalendar.setTime(day);
        dayCalendar.set(Calendar.HOUR, hour);
        dayCalendar.set(Calendar.MINUTE, min);
        dayCalendar.set(Calendar.SECOND, sec);
        return dayCalendar.getTime();
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     *
     * @return
     */
    public static int differentDaysByMillisecond(Date startDay, Date endDay) {
        int days = (int)((endDay.getTime() - startDay.getTime()) / (1000 * 3600 * 24));
        return days;
    }

    public static int getNumberOfDaysInMonth(Date date) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    public static java.sql.Date utilDateToSqlDate(Date date) {
        return new java.sql.Date(date.getTime());
    }
}
