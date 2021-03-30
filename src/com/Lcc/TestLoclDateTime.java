package com.Lcc;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @Description:
 * @Author: liaocongcong
 * @Date: 2021/3/30 11:02
 */
public class TestLoclDateTime {
    public static void main(String[] args) {
        //获取当前时间
        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println("当前时间："+nowTime );


        //自定义时间 of(int year, int month, int dayOfMonth, int hour, int minute, int second, int nanoOfSecond)
        LocalDateTime endTime = LocalDateTime.of(2020, 5, 20, 5, 20, 10,00);
        System.out.println("设定的时间 ："+endTime);


        //比较   现在的时间 比 设定的时间 之前  返回的类型是Boolean类型
        boolean isBefore = nowTime.isBefore(endTime);
        System.out.println("现在的时间 比 设定的时间 之前"+isBefore);
        //比较   现在的时间 和 设定的时候  相等  返回类型是Boolean类型
        boolean euqal =nowTime.equals(endTime);
        System.out.println("现在的时间 和 设定的时候 相等"+euqal);
        //比较  现在的时间 比 设定的时间 之后  返回的类型是Boolean类型
        boolean isAfter = nowTime.isAfter(endTime);
        System.out.println("现在的时间 比 设定的时间 之后"+isAfter);

        // 获取当前时间
        int year = nowTime.getYear();
        int monthValue = nowTime.getMonthValue();
        int dayofMonth = nowTime.getDayOfMonth();
        int hour = nowTime.getHour();
        int minute = nowTime.getMinute();
        int second = nowTime.getSecond();
        System.out.println("获得时间：" + year + "年" +monthValue+"月"+dayofMonth+"日" + hour+"时"+minute+"分"+second+"秒");// 打印当前时间的
        DayOfWeek dayofWeek = nowTime.getDayOfWeek();//获取星期几
        System.out.println("获得星期:"+dayofWeek);
        int dayofYear = nowTime.getDayOfYear();//获取当前日子为年的第几天
        System.out.println("全年:"+dayofYear+"天");


        System.out.println("-------------------计算年份-----------------------");
        // 获取一年之前.minusYears(1) 这个 1 代表一年之前，如果是2就是两年之前
        LocalDateTime minusYears = nowTime.minusYears(1);
        System.out.println(minusYears);
        LocalDateTime plusYears = nowTime.plusYears(1);//一年之后
        System.out.println(plusYears);
        LocalDateTime minusMonths = nowTime.minusMonths(1);//一个月前
        System.out.println(minusMonths);
        LocalDateTime plusMonths = nowTime.plusMonths(1);//一个月后
        System.out.println(plusMonths);
        LocalDateTime BeforeWeek = nowTime.minusWeeks(1);//一个星期前
        System.out.println(BeforeWeek);
        LocalDateTime AfterWeek = nowTime.plusWeeks(1);//一个星期后
        System.out.println(AfterWeek);
        LocalDateTime minusDays = nowTime.minusDays(1);//一天前
        System.out.println(minusDays);
        LocalDateTime plusDays = nowTime.plusDays(1);//一天后
        System.out.println(plusDays);
        LocalDateTime minusHours = nowTime.minusHours(1);//一个小时前
        System.out.println(minusHours);
        LocalDateTime plusHours = nowTime.plusHours(1);//一个小时后
        System.out.println(plusHours);
        LocalDateTime minusMinutes = nowTime.minusMinutes(1);//一分钟前
        System.out.println(minusMinutes);
        LocalDateTime plusMinutes = nowTime.plusMinutes(1);//一分钟后
        System.out.println(plusMinutes);
        LocalDateTime minusSeconds = nowTime.minusSeconds(1);//一秒前
        System.out.println(minusSeconds);
        LocalDateTime plusSeconds = nowTime.plusSeconds(1);//一秒后
        System.out.println(plusSeconds);
        LocalDateTime minusTime = nowTime.minus(23, ChronoUnit.MONTHS);//当前时间减少23个月
        System.out.println(minusTime);

        System.out.println("-----------------时间差-----------------------");
        //计算时间差
        Duration duration = Duration.between(nowTime,endTime);//时间差
        long durationdays = duration.toDays(); //相差的天数
        System.out.println("duration相差"+durationdays+"天");
        long durationhours = duration.toHours();//相差的小时数
        System.out.println("duration相差"+durationhours+"小时");
        long durationminutes = duration.toMinutes();//相差的分钟数
        System.out.println("duration相差"+durationminutes+"分钟");
        long durationmillis = duration.toMillis();//相差毫秒数
        System.out.println("duration相差"+durationmillis+"毫秒");
        long durationnanos = duration.toNanos();//相差的纳秒数
        System.out.println("duration相差"+durationnanos+"纳秒");


        System.out.println("---------------------获取特殊时间--------------------");
        //根据需求需要取得当天的零点
        LocalDateTime today_start = LocalDateTime.of(LocalDate.now(), LocalTime.MIN);//当天零点
        System.out.println(today_start);
        LocalDateTime today_end = LocalDateTime.of(LocalDate.now(), LocalTime.MAX);//获取当天结束时间
        System.out.println(today_end);

        System.out.println("---------------------LocalDataTime转化--------------------");
        //LocalDataTIme的转化
        String localDataTimeString= nowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime StringLocalDataTime = LocalDateTime.parse("2017-09-28 17:07:05",DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));//String转化为LocalDataTime
        System.out.println("LocalDateTime转成String类型的时间："+localDataTimeString);
        System.out.println("String类型的时间转成LocalDateTime："+StringLocalDataTime);

        System.out.println("---------------------Data转化--------------------");
        //Date的转化
        Date date = Date.from(nowTime.atZone(ZoneId.systemDefault()).toInstant());
        LocalDateTime dateTime = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());//转化为LocalDataTime
        System.out.println(dateTime);
        String dataString = nowTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));//转为为String
        System.out.println(dataString);

        
    }
}