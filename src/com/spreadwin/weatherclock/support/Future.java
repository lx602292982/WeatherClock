package com.spreadwin.weatherclock.support;

/**
 * @author Lemuel
 * @email ming.li@spreadwin.com
 * ������δ������״̬
 */
public class Future {
    private String week;
    private String data;
    private String temRange;
    private String info;
    private String wind;
    private int resId;


    public Future(String week, String data, String temperRange, String info, String wind,int resId) {
        this.week = week;
        this.data = data;
        this.temRange = temperRange;
        this.info = info;
        this.wind = wind;
        this.resId = resId;
    }

    public Future(String week, String data, String temperRange, String info,int resId) {
        this.week = week;
        this.data = data;
        this.temRange = temperRange;
        this.info = info;
        this.resId = resId;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTemperRange() {
        return temRange;
    }

    public void setTemperRange(String temperRange) {
        this.temRange = temperRange;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
