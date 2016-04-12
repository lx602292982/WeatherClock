package com.spreadwin.weatherclock.support;

import com.spreadwin.weatherclock.R;
import com.spreadwin.weatherclock.R.drawable;

/**
 * @author Lemuel
 * @email ming.li@spreadwin.com
 */
public class ResUtils {
	/**
	 * 天气小图
	 * 
	 * @param s
	 * @return
	 */
	public static int FutureImageResIdGet(String s) {
		int imageRes = 0;
		if (s.equals("晴")) {
			imageRes = R.drawable.sunny;
		} else if (s.equals("多云")) {
			imageRes = R.drawable.cloudy;
		} else if (s.equals("阴")) {
			imageRes = R.drawable.shade;
		} else if (s.equals("阵雨")) {
			imageRes = R.drawable.shower;
		} else if (s.equals("雷阵雨")) {
			imageRes = R.drawable.thundershower;
		} else if (s.equals("雷阵雨伴有冰雹")) {
			imageRes = R.drawable.thundershowerhail;
		} else if (s.equals("小雨")) {
			imageRes = R.drawable.spit;
		} else if (s.equals("中雨")) {
			imageRes = R.drawable.moderaterain;
		} else if (s.equals("大雨")) {
			imageRes = R.drawable.heavyrain;
		} else if (s.equals("暴雨")) {
			imageRes = R.drawable.rainstorm;
		} else if (s.equals("大暴雨")) {
			imageRes = R.drawable.downpour;
		} else if (s.equals("特大暴雨")) {
			imageRes = R.drawable.extraordinary;
		} else if (s.equals("阵雪")) {
			imageRes = R.drawable.snowshower;
		} else if (s.equals("小雪")) {
			imageRes = R.drawable.scouther;
		} else if (s.equals("中雪")) {
			imageRes = R.drawable.moderatesnow;
		} else if (s.equals("大雪")) {
			imageRes = R.drawable.heavysnow;
		} else if (s.equals("暴雪")) {
			imageRes = R.drawable.heavysnowfall;
		} else if (s.equals("雾")) {
			imageRes = R.drawable.fog;
		} else if (s.equals("冻雨")) {
			imageRes = R.drawable.freezingrain;
		} else if (s.equals("沙尘暴")) {
			imageRes = R.drawable.sandstorm;
		} else if (s.equals("小雨-中雨")) {
			imageRes = R.drawable.light_moderate_rain;
		} else if (s.equals("中雨-大雨")) {
			imageRes = R.drawable.moderate_heavy_rain;
		} else if (s.equals("大雨-暴雨")) {
			imageRes = R.drawable.heavy_rainstorm;
		} else if (s.equals("暴雨-大暴雨")) {
			imageRes = R.drawable.heavy_torrential_rain;
		} else if (s.equals("大暴雨-特大暴雨")) {
			imageRes = R.drawable.torrentialrains;
		} else if (s.equals("小雪-中雪")) {
			imageRes = R.drawable.light_moderate_snow;
		} else if (s.equals("中雪-大雪")) {
			imageRes = R.drawable.moderate_heavy_snow;
		} else if (s.equals("大雪-暴雪")) {
			imageRes = R.drawable.heavysnow_snowfall;
		} else if (s.equals("浮尘")) {
			imageRes = R.drawable.dust;
		} else if (s.equals("扬沙")) {
			imageRes = R.drawable.sand;
		} else if (s.equals("强沙尘暴")) {
			imageRes = R.drawable.strong_sandstorm;
		} else if (s.equals("霾")) {
			imageRes = R.drawable.haze;
		} else {
			imageRes = R.drawable.sunny;
		}
		return imageRes;

	}

	 /**
     * 天气大图
     * @param s
     * @return
     */
	public static int todayImageResGet(String s) {
		int imageRes = 0;
		if (s.equals("晴")) {
			imageRes = R.drawable.sunny00;
		} else if (s.equals("多云")) {
			imageRes = R.drawable.cloudy01;
		} else if (s.equals("阴")) {
			imageRes = R.drawable.shade02;
		} else if (s.equals("阵雨")) {
			imageRes = R.drawable.shower03;
		} else if (s.equals("雷阵雨")) {
			imageRes = R.drawable.thundershower04;
		} else if (s.equals("雷阵雨伴有冰雹")) {
			imageRes = R.drawable.thundershowerhail05;
		} else if (s.equals("小雨")) {
			imageRes = R.drawable.spit07;
		} else if (s.equals("中雨")) {
			imageRes = R.drawable.moderaterain08;
		} else if (s.equals("大雨")) {
			imageRes = R.drawable.heavyrain09;
		} else if (s.equals("暴雨")) {
			imageRes = R.drawable.rainstorm10;
		} else if (s.equals("大暴雨")) {
			imageRes = R.drawable.downpour11;
		} else if (s.equals("特大暴雨")) {
			imageRes = R.drawable.extraordinary12;
		} else if (s.equals("阵雪")) {
			imageRes = R.drawable.snowshower13;
		} else if (s.equals("小雪")) {
			imageRes = R.drawable.scouther14;
		} else if (s.equals("中雪")) {
			imageRes = R.drawable.moderatesnow15;
		} else if (s.equals("大雪")) {
			imageRes = R.drawable.heavysnow16;
		} else if (s.equals("暴雪")) {
			imageRes = R.drawable.heavysnowfall17;
		} else if (s.equals("雾")) {
			imageRes = R.drawable.fog18;
		} else if (s.equals("冻雨")) {
			imageRes = R.drawable.freezingrain19;
		} else if (s.equals("沙尘暴")) {
			imageRes = R.drawable.sandstorm20;
		} else if (s.equals("小雨-中雨")) {
			imageRes = R.drawable.light_moderate_rain21;
		} else if (s.equals("中雨-大雨")) {
			imageRes = R.drawable.moderate_heavy_rain22;
		} else if (s.equals("大雨-暴雨")) {
			imageRes = R.drawable.heavy_rainstorm23;
		} else if (s.equals("暴雨-大暴雨")) {
			imageRes = R.drawable.heavy_torrential_rain24;
		} else if (s.equals("大暴雨-特大暴雨")) {
			imageRes = R.drawable.torrentialrains25;
		} else if (s.equals("小雪-中雪")) {
			imageRes = R.drawable.light_moderate_snow26;
		} else if (s.equals("中雪-大雪")) {
			imageRes = R.drawable.moderate_heavy_snow27;
		} else if (s.equals("大雪-暴雪")) {
			imageRes = R.drawable.heavysnow_snowfall28;
		} else if (s.equals("浮尘")) {
			imageRes = R.drawable.dust29;
		} else if (s.equals("扬沙")) {
			imageRes = R.drawable.sand30;
		} else if (s.equals("强沙尘暴")) {
			imageRes = R.drawable.strong_sandstorm31;
		} else if (s.equals("霾")) {
			imageRes = R.drawable.haze53;
		} else {
			imageRes = R.drawable.sunny00;
		}
		return imageRes;
	}

    /**
     * 高低温格式化
     * @param height
     * @param low
     * @return
     */
    public static String temperFormat(String height, String low) {
        return height + "~" + low;
    }

    public static String dataFormat(String s) {
        String[] split = s.split("-");
        return split[1] + "月" + split[2] + "日";
    }
}
