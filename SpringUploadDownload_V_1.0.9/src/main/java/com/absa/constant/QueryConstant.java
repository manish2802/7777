package com.absa.constant;

public class QueryConstant {

	public static String IBOC = new StringBuilder(
			"SELECT ID, APP_NAME, VERSION , ENVIRONMENT, FILE_SIZE,FILE_INFO,REL_NOTES , SUP_OS,PLIST_FILE_NAME,IPA_FILE_NAME  FROM IBOC_BUILD_RELEASE")
					.toString();

}
