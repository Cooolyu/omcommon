/*
 *******************************************************************************
 * All rights Reserved, Copyright (C) www.gm-sz.com 2012
 * FileName: CharacterUtil.java
 * Modify record:
 * NO. |     Date       |    Version      |    Name         |      Content
 * 1   | 2012-8-2        |      1.0        | GMSZ)LuHaosheng | original version
 *******************************************************************************
 */
package com.gmsz.om.common.utils;

/**
 * Class name:CharacterUtil
 * Description: 字符工具类
 * @author LuHaosheng
 */
public class CharacterUtil {
	
	private static CharacterUtil chrUtil = null;

	private CharacterUtil() {
		
	}
	
	public synchronized static CharacterUtil getInstance() {
		if (chrUtil == null) chrUtil = new CharacterUtil();
		return chrUtil;
	}
	
	/**
	 * Description: 转义可能引起数据库查询结果不正确的字符:\,%,_
	 * @param original
	 * @return
	 */
	public String changeDbSpecialCharacter(String original) {
		if (original == null)
			return null;
		else
			return original.replace("\\","\\\\").replace("%", "\\%").replace("_", "\\_");
	}
	
	/**
	 * Description: 转义HTML实体字符:&,<,>,",空格
	 * @param original
	 * @return
	 */
	public String changeHtml2Normal(String original) {
		if (original == null)
			return null;
		else
			return original.replace("&", "&amp;").replace("<", "&lt;").replace(">", "&gt;").replace("\"", "&quot;").replace(" ", "&nbsp;");
	}
	
// ******* 2013-02-27 GuoRuofei add start *******
	/**
	 * Description: 还原HTML实体字符:&,<,>,",空格
	 * @param original
	 * @return
	 */
	public String changeNormal2Html(String original) {
		if (original == null)
			return null;
		else
			return original.replace("&amp;", "&").replace("&lt;", "<").replace("&gt;", ">").replace("&quot;", "\"").replace("&nbsp;", " ");
	}
// ******* 2013-02-27 GuoRuofei add end *******
}
