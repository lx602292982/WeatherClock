package com.spreadwin.weatherclock;

import com.spreadwin.weatherclock.view.ClockView;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {

	private ClockView mClockView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (mClockView == null) {
			mClockView = new ClockView(this);
		}
		setContentView(mClockView.getClockView());
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		mClockView.onDestroy();
	}

	@Override
	protected void onResume() {
		super.onResume();
		mClockView.onResume();
	}
}
