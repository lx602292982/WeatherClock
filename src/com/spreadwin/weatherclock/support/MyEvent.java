package com.spreadwin.weatherclock.support;

public class MyEvent {
    private FreeWeather weather;


    public MyEvent(FreeWeather weather) {
        this.weather = weather;
    }

    public FreeWeather getWeather() {
        return weather;
    }
}
