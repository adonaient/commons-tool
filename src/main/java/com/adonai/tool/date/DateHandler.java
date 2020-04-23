package com.adonai.tool.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class DateHandler {
	public static String getDate(String format) {
		if (format == null) {
			format = "HH:mm:ss";
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}

	public static String[] getStringFromDate(Date date, String... formats) {
		String[] dates = new String[formats.length];
		for (int i = 0; i < formats.length; i++) {
			dates[i] = new SimpleDateFormat(formats[i]).format(date);
		}
		return dates;
	}

	public static String getStringFromDate(Date date, String format) {
		return new SimpleDateFormat(format).format(date);
	}

	public static String getDateAddSec(String format, int addSec) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, addSec);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(calendar.getTime());
	}

	public static Date getDateAddSec(Date date, int addSec) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.SECOND, addSec);
		return calendar.getTime();
	}

	public static Date getDate(String format, String source, int calendarField, int addField) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getDate(format, source));
		calendar.add(calendarField, addField);
		return calendar.getTime();
	}

	/**
	 * Date를 가지고와서 삽입한 필드의 값을 추가하여 Date를 리턴
	 * 
	 * @param date          원본Date
	 * @param calendarField Calendar.YEAR(년), Calendar.MONTH(월), Calendar.DATE(일),
	 *                      Calendar.SECOND(초)
	 * @param addField      calendarField값에 추가할값을 넣는다
	 * @return calendar.getTime()
	 */
	public static Date getDate(Date date, int calendarField, int addField) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(calendarField, addField);
		return calendar.getTime();
	}

	public static String getDateAddDay(String format, int addDay) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, addDay);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(calendar.getTime());
	}

	public static String getDateAddMonth(String format, int addMonth) {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, addMonth);
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(calendar.getTime());
	}

	public static Date getDate(String format, String source) {
		if (source == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static int getTimeAddSec(int time, int addSec) {
		int[] timeAry = new int[] { time / 10000, 0, 0 };
		time -= timeAry[0] * 10000;
		timeAry[1] = time / 100;
		time -= timeAry[1] * 100;
		timeAry[2] = time / 1;
		// int arg9999 = time - timeAry[2] * 1;
		int totalSec = timeAry[0] * 3600 + timeAry[1] * 60 + timeAry[2] + addSec;
		int hour = totalSec / 3600;
		int min = (totalSec - totalSec / 3600 * 3600) / 60;
		int sec = totalSec - totalSec / 3600 * 3600 - (totalSec - totalSec / 3600 * 3600) / 60 * 60;
		int rtVal = hour * 10000 + min * 100 + sec;
		return rtVal;
	}

	public static int getTimeGapSec(int start, int end) {
		int[] startAry = new int[] { start / 10000, 0, 0 };
		start -= startAry[0] * 10000;
		startAry[1] = start / 100;
		start -= startAry[1] * 100;
		startAry[2] = start;
		int[] endAry = new int[] { end / 10000, 0, 0 };
		end -= endAry[0] * 10000;
		endAry[1] = end / 100;
		end -= endAry[1] * 100;
		endAry[2] = end;
		int totalSecStart = startAry[0] * 3600 + startAry[1] * 60 + startAry[2];
		int totalSecEnd = endAry[0] * 3600 + endAry[1] * 60 + endAry[2];
		return totalSecEnd - totalSecStart;
	}

	public static double getTimeGapMin(int start, int end) {
		return (double) (getTimeGapSec(start, end) / 60);
	}

	public static double getTimeGapSec(Date start, Date end) {
		double gap = 0.0D;
		Calendar startCl = Calendar.getInstance();
		Calendar endCl = Calendar.getInstance();
		startCl.setTime(start);
		endCl.setTime(end);
		gap = (double) (endCl.getTimeInMillis() - startCl.getTimeInMillis()) * 0.001D;
		return (double) Math.round(gap * 1000.0D) / 1000.0D;
	}

	public static double getPerformanceTime(long startTime) {
		return (double) (System.nanoTime() - startTime) / 1000000.0D;
	}
}
