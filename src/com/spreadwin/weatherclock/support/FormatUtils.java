package com.spreadwin.weatherclock.support;

import android.text.format.Time;

/**
 * @author Lemuel
 * @email ming.li@spreadwin.com
 */
public class FormatUtils {
	/**
     * 获取当前时间
     * @return
     */
	public static String getCurrentTime() {
		Time t = new Time(); 
		t.setToNow(); 
		int year = t.year;
		int month = t.month;
		int date = t.monthDay;
		int hour = t.hour; // 0-23
		int minute = t.minute;
		int second = t.second;
		return (hour < 10 ? "0" + hour : hour) + ":" + (minute < 10 ? "0" + minute : minute);
	}

    /**
     * 星期格式化
     * @param week
     * @return
     */
	public static String weekFormat(int week) {
		String weekName = null;
		switch (week) {
		  case 1:weekName = "星期一";break;
          case 2:weekName = "星期二";break;
          case 3:weekName = "星期三";break;
          case 4:weekName = "星期四";break;
          case 5:weekName = "星期五";break;
          case 6:weekName = "星期六";break;
          case 7:weekName = "星期日";break;
		}
		return weekName;
	}
}
