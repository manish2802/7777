package com.absa.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplicationUtil {

	private static final long MEGABYTE = 1024L * 1024L;

	private static Pattern fileExtnPtrn = Pattern.compile("([^\\s]+(\\.(?i)(docx|xlsx|pdf))$)");

	/**
	 * 
	 * @param bytes
	 * @return
	 */
	public static double bytesToMeg(long bytes) {
		BigDecimal bd = new BigDecimal((double) bytes / MEGABYTE);
		bd = bd.setScale(3, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	/**
	 * 
	 * @param fileName
	 * @return
	 */
	public static String getFileExtension(String fileName) {
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	public static void main(String... k) {
		System.out.println(ApplicationUtil.validateFileExtn("abc.docx"));
	}

	/**
	 * 
	 * @param value
	 * @param places
	 * @return
	 */
	public static double round(double value, int places) {
		if (places < 0)
			throw new IllegalArgumentException();
		BigDecimal bd = new BigDecimal(value);
		bd = bd.setScale(places, RoundingMode.HALF_UP);
		return bd.doubleValue();
	}

	/**
	 * 
	 * @param bytes
	 * @return
	 */
	public static double convertBytesToMeg(long bytes) {

		return (double) bytes / MEGABYTE;
	}

	/**
	 * 
	 * @param userName
	 * @return
	 */
	public static boolean validateFileExtn(String userName) {
		Matcher mtch = fileExtnPtrn.matcher(userName);
		if (mtch.matches()) {
			return true;
		}
		return false;
	}

}
