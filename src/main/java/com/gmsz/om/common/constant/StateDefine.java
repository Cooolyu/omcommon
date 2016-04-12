/*
 *******************************************************************************
 * All rights Reserved, Copyright (C) www.gm-sz.com 2013
 * FileName: StateDefine.java
 * Modify record:
 * NO. |     Date       |    Version      |    Name          |      Content
 * 1   | 2013年10月31日        |      1.0        |  GMSZ)LuHaosheng | original version
 *******************************************************************************
 */
package com.gmsz.om.common.constant;

/**
 * Class name:StateDefine
 * Description: please write your description
 * @author LuHaosheng
 */
public class StateDefine {
	public static final String SYS_LOG =  "sysLog";
	public static final String INFO_LOG =  "infoLog";
	
	/*** 文件分隔符*/
	public static final String FILE_SEPARATOR = System.getProperties().getProperty("file.separator");
	
	public static final int FLAG_SUCCESS = 200;
	public static final int FLAG_FAIL_BAD_REQUEST = 400;
	public static final int FLAG_FAIL_UNAUTHORIZED = 401;
	public static final int FLAG_FAIL_FORBIDDEN = 403;
	public static final int FLAG_FAIL_NOT_FOUND = 404;
	public static final int FLAG_FAIL_ERROR = 500;
	public static final int FLAG_IN_PROCESS = 600;
	
	//每页显示数
	@Deprecated
	public static final int PAGE_SIZE = 30;
	/**
	 *维护单号前缀
	 */
	public static final String MLISTNUM_PREFIX = "MTN-";
	
	public static String SERVICE_IP = "";
	
	public static String SERVICE_PORT = "";
	
}
