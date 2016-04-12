/*
 *******************************************************************************
 * All rights Reserved, Copyright (C) www.gm-sz.com 2012
 * FileName: Result.java
 * Modify record:
 * NO. |     Date       |    Version      |    Name         |      Content
 * 1   | 2012-4-27      |      1.0        | GMSZ)LuHaosheng | original version
 *******************************************************************************
 */
package com.gmsz.om.common.beans;

import java.io.Serializable;

/**
 * Class name:Result
 * Description: 结果Bean
 * @author LuHaosheng
 */
public class Result implements Serializable {

	private static final long serialVersionUID = 2157760465775288001L;

	/**
	 * 结果ID
	 */
	private int resultId;
	
	/**
	 * 结果值(成功True,失败False)
	 */
	private boolean resultValue;
	
	/**
	 * 消息(一般错误时,需要有错误消息)
	 */
	private String message;
	
	public Result() {
		
	}
	
	public Result(int resultId, boolean resultValue) {
		this.resultId = resultId;
		this.resultValue = resultValue;
	}
	
	public Result(int resultId, boolean resultValue, String message) {
		this.resultId = resultId;
		this.resultValue = resultValue;
		this.message = message;
	}
	
	
	public int getResultId() {
		return resultId;
	}
	
	@Override
	public String toString() {
		return "resultId=" + resultId + "*** resultValue=" + resultValue + "*** message=" + message;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}
	public boolean isResultValue() {
		return resultValue;
	}
	public void setResultValue(boolean resultValue) {
		this.resultValue = resultValue;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
