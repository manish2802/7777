package com.absa.util;

public class CommonUtil {

	/**
	 * if notEmpty:true otherwise:false
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNotEmpty(String str) {
		boolean flag = true;
		if (str == null || "".equalsIgnoreCase(str)) {
			flag = false;
			return flag;
		}
		return flag;
	}
	
	

}
