package com.spreadwin.weatherclock;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.thinkland.sdk.android.JuheSDKInitializer;

import android.app.Application;

public class ClockApplication extends Application {
	public static final String TAG = ClockApplication.class.getSimpleName();

	private RequestQueue mRequestQueue;
	private static ClockApplication mInstance;

	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;
		JuheSDKInitializer.initialize(getApplicationContext());
	}

	public static synchronized ClockApplication getInstance() {
		return mInstance;
	}

	public RequestQueue getRequestQueue() {
		if (mRequestQueue == null) {
			mRequestQueue = Volley.newRequestQueue(getApplicationContext());
		}
		return mRequestQueue;
	}

	public <T> void addToRequestQueue(Request<T> req) {
		req.setTag(TAG);
		getRequestQueue().add(req);
	}

}
