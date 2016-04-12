package com.spreadwin.weatherclock.support;

import com.spreadwin.weatherclock.R;
import com.spreadwin.weatherclock.R.id;
import com.spreadwin.weatherclock.R.layout;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * @author Lemuel
 * @email ming.li@spreadwin.com
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class FlyProgressBar extends LinearLayout{

    private TextView mTextView;
    private ProgressBar mBar;

    public FlyProgressBar(Context context) {
        this(context, null);
    }

    public FlyProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlyProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.progressbar, this, true);
        mTextView = (TextView) view.findViewById(R.id.progressbar_text);
        mBar = (ProgressBar) findViewById(R.id.progressBar_small);
    }

    public void setText(String s){
        mTextView.setText(s);
        mBar.setVisibility(GONE);

    }
}
