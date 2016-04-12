/*
 *******************************************************************************
 * All rights Reserved, Copyright (C) www.gm-sz.com 2012
 * FileName: TimeUtil.java
 * Modify record:
 * NO. |     Date       |    Version      |    Name         |      Content
 * 1   | 2012-5-14        |      1.0        | GMSZ)LuHaosheng | original version
 *******************************************************************************
 */
package com.gmsz.om.common.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Class name:TimeUtil Description: 时间,日期工具类
 * 
 * @author LuHaosheng
 */
public class TimeUtil {

	// 定义默认的日期格式
	private static final String PATTERN = "yyyy-MM-dd";

	/**
	 * Description: 时间转字符串,返回字符串格式:yyyy-MM-dd HH:mm
	 * 
	 * @param date
	 * @return
	 */
	public static String time2String(Date date) {
		String dateStr = null;
		if (date != null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			dateStr = format.format(date);
		}

		return dateStr;
	}

	public static String time2StringNew(Date date) {
		String dateStr = null;
		if (date != null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			dateStr = format.format(date);
		}

		return dateStr;
	}

	/**
	 * Description: 时间转字符串,返回字符串格式:yyyy-MM-dd
	 * 
	 * @param date
	 * @return
	 */
	public static String date2String(Date date) {
		String dateStr = null;
		if (date != null) {
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			dateStr = format.format(date);
		}

		return dateStr;
	}

	/**
	 * Description: 将字符串"yyyy-MM-dd"转为日期类型
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date stringToDate(String dateStr) throws ParseException {
		DateFormat daytimeFormat = new SimpleDateFormat("yyyy-MM-dd");
		return daytimeFormat.parse(dateStr);
	}

	/**
	 * Description: 将yyyy-MM-dd 00:00分的时间转换为yyyy-MM-dd 23:59分
	 * 
	 * @param date
	 * @return
	 */
	public static Date start2End(Date date) {
		date.setTime(date.getTime() + 86399000);
		return date;
	}

	/**
	 * Description: 将字符串"yyyy-MM-dd HH:mm"转为日期类型
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date string2Time(String dateStr) throws ParseException {
		DateFormat daytimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		return daytimeFormat.parse(dateStr);
	}

	/**
	 * Description: 将string 按指定格式转化为日期
	 * 
	 * @param dateStr
	 * @return
	 * @throws ParseException
	 */
	public static Date string2Time(String dateStr, String pattern) throws ParseException {
		DateFormat daytimeFormat = new SimpleDateFormat(pattern == null ? PATTERN : pattern);
		return daytimeFormat.parse(dateStr);
	}

	/**
	 * 获取现在时间的前半小时
	 * */
	public static String getBeforHalfHourOfNow() {
		Calendar a = Calendar.getInstance();
		a.set(Calendar.MINUTE, -60);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		return sdf.format(a.getTime());

	}

	// 创建指定格式的SimpleDateFormat实例，若不指定格式，则使用默认日期格式
	private static SimpleDateFormat getSimpleDateFormatInstance(String pattern) {
		return new SimpleDateFormat(pattern == null ? PATTERN : pattern);
	}

	// 将Date按指定格式转换为字符串表示
	public static String parseDate2String(Date date, String pattern) {
		return getSimpleDateFormatInstance(pattern).format(date);
	}

	// 默认日期格式
	public static String parseDate2String(Date date) {
		return parseDate2String(date, null);
	}

	// 获取指定格式的当前系统时间String
	public static String getCurrentTime(String pattern) {
		return parseDate2String(new Date(), pattern);
	}

	// 获取默认格式的当前系统时间,返回如"1988-03-16"的字符串
	public static String getCurrentTime() {
		return getCurrentTime(null);
	}
	/**
	 * 
	 * Description:日期加上几天后的时间
	 * 
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static String addDayTime(int day, Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, day);
		return parseDate2String(cal.getTime());
	}
	/**
	 * 
	 * Description:取得当前加几天的时间 返回是 yyyy-MM-dd 00:00:00
	 * 
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static Date addDateBegin(int day, Date date) throws ParseException {
		String today = date2String(date);
		DateFormat daytimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = daytimeFormat.parse(today + " 00:00:00");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}

	/**
	 * 
	 * Description:取得当前日期加几天后的最后时间 yyyy-MM-dd 23:59:59
	 * 
	 * @param day
	 * @return
	 * @throws ParseException
	 */
	public static Date getDateEnd(int day, Date date) throws ParseException {
		String today = date2String(date);
		DateFormat daytimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date1 = daytimeFormat.parse(today + " 23:59:59");
		Calendar cal = Calendar.getInstance();
		cal.setTime(date1);
		cal.add(Calendar.DATE, day);
		return cal.getTime();
	}

	public static Date getDateAddMonth(Date date, int month) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, month);
		return cal.getTime();
	}

	/**
	 * Description: 获取本月第一天
	 * @return
	 */
	public static String getCurrMonthBegin() {
		Calendar c = Calendar.getInstance();
		c.add(Calendar.MONTH, 0);
		c.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(c.getTime());
	}
	/**
	 * Description: 获取本月最后一天
	 * @return
	 */
	public static String getCurrMonthEnd() {
		Calendar ca = Calendar.getInstance();    
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(ca.getTime());
	}
	/**
	 * Description: 获取某个日期所在月的最后一天
	 * @return
	 */
	public static String getMonthEndDay(Date date) {
		Calendar ca = Calendar.getInstance(); 
		ca.setTime(date);
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));  
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		return format.format(ca.getTime());
	}


	public static void main(String[] args) throws ParseException {
		System.out.println(TimeUtil.addDateBegin(-1 - 1, new Date()));
	}

}
