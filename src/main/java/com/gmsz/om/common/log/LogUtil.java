/*
 *******************************************************************************
 * All rights Reserved, Copyright (C) www.gm-sz.com 2012
 * FileName: LogUtil.java
 * Modify record:
 * NO. |     Date       |    Version      |    Name         |      Content
 * 1   | 2012-4-20      |      1.0        | GMSZ)LuHaosheng | original version
 *******************************************************************************
 */
package com.gmsz.om.common.log;

import org.aspectj.lang.JoinPoint;

/**
 * Class name:LogUtil
 * Description: 写日志的工具类
 * @author LuHaosheng
 */
public class LogUtil {

	/**
	 * Description: 获得类,方法信息
	 * @param joinPoint
	 * @return
	 */
	public static String getInformation(JoinPoint joinPoint) {
		StringBuilder messageBuilder = new StringBuilder("--Class: ");
		String name = joinPoint.getSignature().getName();
		Object targetClass = joinPoint.getTarget();
		messageBuilder.append(targetClass.getClass().getSimpleName())
			.append("  --Method: ")
			.append(name);
		return messageBuilder.toString();
	}
	
	/**
	 * Description: 获得异常信息
	 * @param ex
	 * @return
	 */
	public static String getExceptions(Exception ex) {
		String message = null;
		StackTraceElement[] trace = ex.getStackTrace();
		for (StackTraceElement s : trace) {
			if (s.getClassName().startsWith("com.gmsz.om")) {
				message = ("*** Exception happened"
					+ " --Class: " + s.getClassName()
					+ " --Method: " + s.getMethodName()
					+ " --Line: " + s.getLineNumber()
					+ " --Type: " + ex.toString());
			}
		}
		return message;
	}
}
