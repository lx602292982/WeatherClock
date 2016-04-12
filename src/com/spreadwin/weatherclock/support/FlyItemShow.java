package com.spreadwin.weatherclock.support;

import com.spreadwin.weatherclock.R;
import com.spreadwin.weatherclock.R.id;
import com.spreadwin.weatherclock.R.layout;
import com.spreadwin.weatherclock.R.string;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * @author Lemuel
 * @email ming.li@spreadwin.com
 */
@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class FlyItemShow extends LinearLayout {

    private TextView mWeek;
    private TextView mDate;
    private ImageView mImg;
    private TextView mRange;

    public FlyItemShow(Context context) {
        this(context, null);
    }

    public FlyItemShow(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlyItemShow(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        View v = LayoutInflater.from(context).inflate(R.layout.item_show, this, true);
        mWeek = (TextView) v.findViewById(R.id.show_future_week);
        mDate = (TextView) v.findViewById(R.id.show_future_data);
        mImg = (ImageView) v.findViewById(R.id.show_future_image);
        mRange = (TextView)v. findViewById(R.id.show_future_temper_range);
    }

    public void setFuture(Future future){
        mWeek.setText(future.getWeek());
        mDate.setText(future.getData());
        mRange.setText(getContext().getString(R.string.tempe,future.getTemperRange()));
        mImg.setImageResource(ResUtils.FutureImageResIdGet(future.getInfo()));
    }
}
