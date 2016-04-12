package com.spreadwin.weatherclock.support;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.spreadwin.weatherclock.ClockApplication;
import com.thinkland.sdk.android.DataCallBack;
import com.thinkland.sdk.android.JuheData;
import com.thinkland.sdk.android.Parameters;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;
import de.greenrobot.event.EventBus;

/**
 * Created by Lemuel on 2015/12/14.
 */
public class BackService extends Service {
	public static FreeWeather mWeather;
	private EventBus mBus;
	public LocationClient mLocationClient = null;
	public BDLocationListener myListener = new BDLocationListener() {
		@Override
		public void onReceiveLocation(BDLocation location) {
			if (location.getLocType() == BDLocation.TypeNetWorkLocation) {
				JuheDataGet(location.getCity().replace("市", ""));
			} else {
				Toast.makeText(BackService.this, "网络定位失败，请打开网络连接！", Toast.LENGTH_SHORT).show();
			}
			mLocationClient.stop();
		}
	};
	private IBinder myBinder = new MyBinder();

	/*
	 * @Nullable
	 * 
	 * @Override public IBinder onBind(Intent intent) { return null; }
	 */

	@Nullable
	@Override
	public IBinder onBind(Intent intent) {
		return myBinder;
	}

	public class MyBinder extends Binder {
		public BackService getService() {
			return BackService.this;
		}
	}

	@Override
	public void onCreate() {
		super.onCreate();
		mBus = EventBus.getDefault();
		mBus.register(this);
		mLocationClient = new LocationClient(getApplicationContext()); // 声明LocationClient类
		mLocationClient.registerLocationListener(myListener); // 注册监听函数
		initLocation();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		if (isNetConnected(this)) {
			mLocationClient.start();
		} else {
			NetEvent event = new NetEvent();
			event.setIsNetConnected(false);
			mBus.post(event);
		}
		return START_STICKY;
	}

	public boolean isNetConnected(Context context) {
		boolean isConnected = false;
		ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
		isConnected = activeNetwork != null && activeNetwork.isConnectedOrConnecting();
		return isConnected;
	}

	private void initLocation() {
		LocationClientOption option = new LocationClientOption();
		option.setLocationMode(LocationClientOption.LocationMode.Hight_Accuracy);// 可选，默认高精度，设置定位模式，高精度，低功耗，仅设备
		option.setCoorType("bd09ll");// 可选，默认gcj02，设置返回的定位结果坐标系
		int span = 1000;
		option.setScanSpan(span);// 可选，默认0，即仅定位一次，设置发起定位请求的间隔需要大于等于1000ms才是有效的
		option.setIsNeedAddress(true);// 可选，设置是否需要地址信息，默认不需要
		option.setOpenGps(true);// 可选，默认false,设置是否使用gps
		option.setLocationNotify(true);// 可选，默认false，设置是否当gps有效时按照1S1次频率输出GPS结果
		option.setIsNeedLocationDescribe(true);// 可选，默认false，设置是否需要位置语义化结果，可以在BDLocation.getLocationDescribe里得到，结果类似于“在北京天安门附近”
		option.setIsNeedLocationPoiList(true);// 可选，默认false，设置是否需要POI结果，可以在BDLocation.getPoiList里得到
		option.setIgnoreKillProcess(false);// 可选，默认false，定位SDK内部是一个SERVICE，并放到了独立进程，设置是否在stop的时候杀死这个进程，默认杀死
		option.SetIgnoreCacheException(false);// 可选，默认false，设置是否收集CRASH信息，默认收集
		option.setEnableSimulateGps(false);// 可选，默认false，设置是否需要过滤gps仿真结果，默认需要
		mLocationClient.setLocOption(option);
	}

	/**
	 * 总线方法，不可忽略
	 * 
	 * @param event
	 */
	public void onEvent(MyEvent event) {
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		mBus.unregister(this);
	}

	/**
	 * 聚合SDK请求天气数据
	 * 
	 * @param city
	 */
	public void JuheDataGet(String city) {
		Parameters params = new Parameters();
		try {
			params.add("cityname", URLEncoder.encode(city, "utf-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		JuheData.executeWithAPI(this, 73, "http://op.juhe.cn/onebox/weather/query", JuheData.GET, params,
				new DataCallBack() {
					@Override
					public void onSuccess(int i, String s) {
						mWeather = new Gson().fromJson(s, new TypeToken<FreeWeather>() {
						}.getType());
						mBus.post(new MyEvent(mWeather));
						// 发送广播通知更新天气卡片
						// Intent it = new
						// Intent("com.intent.action.flyaudiosky.SERVICE.TOLAUNCHER");
						// FreeWeather.Result.Data.Realtime realtime =
						// mWeather.getResult().getData().getRealtime();
						// FreeWeather.Result.Data.WeatherEntity.Info info =
						// mWeather.getResult().getData().getWeather()
						// .get(0).getInfo();
						// it.putExtra("city", realtime.getCity_name());
						// it.putExtra("temp",
						// realtime.getWeather().getTemperature());
						// it.putExtra("info", realtime.getWeather().getInfo());
						// it.putExtra("todayHeight", info.getDay().get(2));
						// it.putExtra("todayLow", info.getNight().get(2));
						// sendBroadcast(it);

					}

					@Override
					public void onFinish() {
					}

					@Override
					public void onFailure(int i, String s, Throwable throwable) {
						Toast.makeText(BackService.this, "数据请求失败,请重试！", Toast.LENGTH_SHORT).show();
					}
				});
	}

	/**
	 * 通过城市名获得天气信息，通过Volley。。。
	 *
	 * @param cityName
	 */
	public void dataGet(String cityName) {
		String city = null;
		try {
			city = URLEncoder.encode(cityName, "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String mUrl = "http://op.juhe.cn/onebox/weather/query?cityname=" + city
				+ "&key=69850c26b0052d0d55220746d7f89bb5";
		StringRequest strReq = new StringRequest(Request.Method.GET, mUrl, new Response.Listener<String>() {
			@Override
			public void onResponse(String response) {
				// Log.d("--------天气预报", response);

				mWeather = new Gson().fromJson(response, new TypeToken<FreeWeather>() {
				}.getType());
				mBus.post(new MyEvent(mWeather));
			}
		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Log.d("---------->网络请求错误", error.toString());
			}
		});
		ClockApplication.getInstance().addToRequestQueue(strReq);
	}

	public static class WeatherReceiver extends BroadcastReceiver {
		public WeatherReceiver() {

		}

		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals("com.spreadwin.request.getweatherinfo")) {
				if (mWeather != null) {
					context.sendBroadcast(new Intent("com.spreadwin.response.weatherinfo")
							.putExtra("city", mWeather.getResult().getData().getRealtime().getCity_name())
							.putExtra("tem", mWeather.getResult().getData().getRealtime().getWeather().getTemperature())
							.putExtra("info", mWeather.getResult().getData().getRealtime().getWeather().getInfo()));
				} else {
					context.sendBroadcast(new Intent("com.spreadwin.response.weatherinfo").putExtra("city", "未知")
							.putExtra("tem", "null").putExtra("info", "未知"));
				}
			}
			// if
			// (intent.getAction().equals("com.intent.action.FLYAUDIOSKY.SERVICE"))
			// {
			// Intent it = new
			// Intent("com.intent.action.flyaudiosky.SERVICE.TOLAUNCHER");
			// if (mWeather != null) {
			// FreeWeather.Result.Data.Realtime realtime =
			// mWeather.getResult().getData().getRealtime();
			// FreeWeather.Result.Data.WeatherEntity.Info info =
			// mWeather.getResult().getData().getWeather().get(0)
			// .getInfo();
			// it.putExtra("city", realtime.getCity_name());
			// it.putExtra("temp", realtime.getWeather().getTemperature());
			// it.putExtra("info", realtime.getWeather().getInfo());
			// it.putExtra("todayHeight", info.getDay().get(2));
			// it.putExtra("todayLow", info.getNight().get(2));
			// context.sendBroadcast(it);
			// } else {
			// it.putExtra("city", "未知");
			// it.putExtra("temp", "--");
			// it.putExtra("info", "--");
			// it.putExtra("todayHeight", "--");
			// it.putExtra("todayLow", "--");
			// context.sendBroadcast(it);
			// }
			//
			// }
		}
	}
}
