package com.spreadwin.weatherclock.view;

import java.util.ArrayList;

import com.spreadwin.weatherclock.R;
import com.spreadwin.weatherclock.R.id;
import com.spreadwin.weatherclock.R.layout;
import com.spreadwin.weatherclock.R.string;
import com.spreadwin.weatherclock.support.BackService;
import com.spreadwin.weatherclock.support.FlyItemShow;
import com.spreadwin.weatherclock.support.FlyProgressBar;
import com.spreadwin.weatherclock.support.FormatUtils;
import com.spreadwin.weatherclock.support.FreeWeather;
import com.spreadwin.weatherclock.support.Future;
import com.spreadwin.weatherclock.support.MyEvent;
import com.spreadwin.weatherclock.support.NetEvent;
import com.spreadwin.weatherclock.support.ResUtils;
import com.spreadwin.weatherclock.support.TimeService;
import com.spreadwin.weatherclock.support.BackService.MyBinder;
import com.spreadwin.weatherclock.support.FreeWeather.Result;
import com.spreadwin.weatherclock.support.FreeWeather.Result.Data;
import com.spreadwin.weatherclock.support.FreeWeather.Result.Data.Realtime;
import com.spreadwin.weatherclock.support.FreeWeather.Result.Data.WeatherEntity;
import com.spreadwin.weatherclock.support.FreeWeather.Result.Data.WeatherEntity.Info;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import de.greenrobot.event.EventBus;


public class ClockView {
    private View view;
    private Context mContext;
    private EventBus mBus;
    private FreeWeather mWeather;
    private ArrayList<Future> mFutures = new ArrayList<Future>();
    private TextView mCity, mDate, mWeek, mTempRange, mInfo;
    private ImageView mImage;
    private FlyProgressBar mFlyProgressBar;
    private TextView mSign;
    private FlyItemShow mShow1, mShow2, mShow3, mShow4;
    private ServiceConnection mConn;
    private BackService mService;
    private Runnable mTimeThread;
    private Handler mTimeHandle = new Handler();

    public ClockView(Context context) {
        this.mContext = context;
        view = LayoutInflater.from(mContext).inflate(R.layout.card_clock_view, null);
        initView(view);
    }

    private void initView(View view) {
        mBus = EventBus.getDefault();
        if (!mBus.isRegistered(this)) {
            mBus.register(this);
        }
        mConn = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName name, IBinder service) {
                mService = ((BackService.MyBinder) service).getService();
                if (mService.mWeather != null) {
                    mWeather = mService.mWeather;
                    mFutures.clear();
                    if (mWeather != null) {
                        upDate();
                    }
                }
            }
            @Override
            public void onServiceDisconnected(ComponentName name) {
                mService = null;
            }
        };
        mContext.bindService(new Intent(mContext, BackService.class), mConn, Context.BIND_AUTO_CREATE);

        mCity = (TextView) view.findViewById(R.id.show_city);
        mDate = (TextView) view.findViewById(R.id.show_date);
        mWeek = (TextView) view.findViewById(R.id.show_week);
        mImage = (ImageView) view.findViewById(R.id.show_image);
        mTempRange = (TextView) view.findViewById(R.id.show_temper_range);
        mInfo = (TextView) view.findViewById(R.id.show_temper_info);
        mSign = (TextView) view.findViewById(R.id.show_temper_sign);
        mFlyProgressBar = (FlyProgressBar) view.findViewById(R.id.show_progressbar);
        mFlyProgressBar.setVisibility(View.VISIBLE);
        mSign.setVisibility(View.GONE);

        mShow1 = (FlyItemShow) view.findViewById(R.id.show1);
        mShow2 = (FlyItemShow) view.findViewById(R.id.show2);
        mShow3 = (FlyItemShow) view.findViewById(R.id.show3);
        mShow4 = (FlyItemShow) view.findViewById(R.id.show4);

        mTimeThread = new Runnable() {
            @Override
            public void run() {
                if (FormatUtils.getCurrentTime() == "00:00") {
                    mContext.startService(new Intent(mContext, BackService.class));
                }
                mTimeHandle.postDelayed(mTimeThread, 1000);
            }
        };
    }

    /**
     * 开始执行任务
     */
    private void start() {
        mContext.startService(new Intent(mContext, TimeService.class));
        mTimeHandle.post(mTimeThread);
        mContext.startService(new Intent(mContext, BackService.class));
    }

    /**
     * 获得数据更新界面
     *
     * @param event
     */
    public void onEvent(MyEvent event) {
        mWeather = event.getWeather();
        mFutures.clear();
        if (mWeather != null) {
            upDate();
        }
    }

    /**
     * 网络连接
     *
     * @param event
     */
    public void onEvent(NetEvent event) {
        if (!event.isNetConnected()) {
            mFlyProgressBar.setText("请检查网络连接！");
        }
    }

    /**
     * 更新UI
     */
    private void upDate() {
        //实时天气信息
        FreeWeather.Result.Data.Realtime realtime = mWeather.getResult().getData().getRealtime();
        mCity.setText(realtime.getCity_name());
        mDate.setText(realtime.getDate());
        mWeek.setText(FormatUtils.weekFormat(realtime.getWeek()));
        mImage.setImageResource(ResUtils.todayImageResGet(realtime.getWeather().getInfo()));

        FreeWeather.Result.Data.WeatherEntity.Info info = mWeather.getResult().getData().getWeather().get(0).getInfo();
        String todayHeight = info.getDay().get(2);
        String todayLow = info.getNight().get(2);
        mTempRange.setText(ResUtils.temperFormat(todayHeight, todayLow));

        mInfo.setText(mContext.getString(R.string.info_wind, realtime.getWeather().getInfo(), info.getDay().get(4)));

        setFutures(mShow1, mShow2, mShow3, mShow4);

        mFlyProgressBar.setVisibility(View.GONE);

        mSign.setVisibility(View.VISIBLE);
    }

    public void setFutures(FlyItemShow... shows) {
        for (int j = 1; j <= 4; j++) {
            FreeWeather.Result.Data.WeatherEntity entity = mWeather.getResult().getData().getWeather().get(j);
            String week = mContext.getString(R.string.week, entity.getWeek());//周二
            String date = ResUtils.dataFormat(entity.getDate());//12月2日
            String h_tem = entity.getInfo().getDay().get(2);//高温
            String l_tem = entity.getInfo().getNight().get(2);//低温
            String weather = entity.getInfo().getDay().get(1);//多云
            int resId = ResUtils.FutureImageResIdGet(weather);//天气图标
            Future future = new Future(week, date, ResUtils.temperFormat(h_tem, l_tem), weather, resId);
            shows[j - 1].setFuture(future);
        }
    }

    public View getClockView() {
        return view;
    }

    public void show() {
        if (view!=null){
            view.setVisibility(View.VISIBLE);
        }
        onResume();
    }

    public void hide() {
        if (view != null) {
            view.setVisibility(View.GONE);
        }
        onDestroy();
    }

    public void onResume() {
        start();
        mTimeHandle.post(mTimeThread);
    }

    public void onDestroy() {
        mTimeHandle.removeCallbacks(mTimeThread);
        mBus.unregister(this);
        mContext.unbindService(mConn);
    }
}
