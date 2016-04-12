package com.spreadwin.weatherclock.support;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;

/**
 * Created by Lemuel on 2015/12/14.
 * 定时服务
 */
public class TimeService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intent mIntent = new Intent(this, AlarmReceiver.class);
        PendingIntent pIntent = PendingIntent.getBroadcast(this, 0, mIntent, 0);
        //开始时间
        long startTime = SystemClock.elapsedRealtime();
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        //15分钟发送一个广播，时间到了将发送pIntent这个广播，在alarmReceiver中接受广播
        alarmManager.setRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, startTime, 15 *60 * 1000, pIntent);
        return START_STICKY;
    }
}
