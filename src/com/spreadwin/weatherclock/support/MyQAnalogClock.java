package com.spreadwin.weatherclock.support;

import com.spreadwin.weatherclock.R;
import com.spreadwin.weatherclock.R.drawable;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.text.format.Time;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;


/**
 * @author Lemuel
 * @email ming.li@spreadwin.com
 */
public class MyQAnalogClock extends View {
	 //时钟盘，分针、秒针、时针对象
    Bitmap mBmpDial;
    Bitmap mBmpHour;
    Bitmap mBmpMinute;
    Bitmap mBmpSecond;

    BitmapDrawable bmdHour;
    BitmapDrawable bmdMinute;
    BitmapDrawable bmdSecond;
    BitmapDrawable bmdDial;

    Paint mPaint;
    Handler tickHandler;

    int mWidth;
    int mHeigh;
    int mTempWidth;
    int mTempHeigh;
    int centerX;
    int centerY;

    int availableWidth = 250;
    int availableHeight = 250;


    public MyQAnalogClock(Context context, AttributeSet attr) {
        this(context);
    }

    public MyQAnalogClock(Context context) {
        super(context);

        mBmpHour = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_shi_v9);//
        bmdHour = new BitmapDrawable(mBmpHour);

        mBmpMinute = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_fen_v9);//
        bmdMinute = new BitmapDrawable(mBmpMinute);

        mBmpSecond = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_miao_v9);//
        bmdSecond = new BitmapDrawable(mBmpSecond);

        mBmpDial = BitmapFactory.decodeResource(getResources(),
                R.drawable.ic_clockdial5_v9);//
        bmdDial = new BitmapDrawable(mBmpDial);
        mWidth = mBmpDial.getWidth();
        mHeigh = mBmpDial.getHeight();
        centerX = availableWidth / 2;
        centerY = availableHeight / 2;

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setFilterBitmap(true);
        mPaint.setColor(Color.BLUE);
        run();
    }

    public void run() {
        tickHandler = new Handler();
        tickHandler.post(tickRunnable);
    }

    private Runnable tickRunnable = new Runnable() {
        public void run() {
            postInvalidate();
            tickHandler.postDelayed(tickRunnable, 1000);
        }
    };

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG));

        Time t = new Time(); 
        t.setToNow(); 
        int hour = t.hour;
        int minute = t.minute;
        int second = t.second;
        float hourRotate = hour * 30.0f + minute / 60.0f * 30.0f;
        float minuteRotate = minute * 6.0f;
        float secondRotate = second * 6.0f;

        boolean scaled = false;

        if (availableWidth < mWidth || availableHeight < mHeigh) {
            scaled = true;
            float scale = Math.min((float) availableWidth / (float) mWidth,
                    (float) availableHeight / (float) mHeigh);
            canvas.save();
            canvas.scale(scale, scale, centerX, centerY);
        }

        bmdDial.setBounds(centerX - (mWidth / 2), centerY - (mHeigh / 2),
                centerX + (mWidth / 2), centerY + (mHeigh / 2));
        bmdDial.draw(canvas);
        //
        mTempWidth = bmdHour.getIntrinsicWidth();
        mTempHeigh = bmdHour.getIntrinsicHeight();
        canvas.save();
        canvas.rotate(hourRotate, centerX, centerY);
        bmdHour.setBounds(centerX - (mTempWidth / 2), centerY - mTempHeigh
                , centerX + (mTempWidth / 2), centerY
                /*+ (mTempHeigh / 2)*/);
        bmdHour.draw(canvas);

        canvas.restore();
        //
        mTempWidth = bmdMinute.getIntrinsicWidth();
        mTempHeigh = bmdMinute.getIntrinsicHeight();
        canvas.save();
        canvas.rotate(minuteRotate, centerX, centerY);
        bmdMinute.setBounds(centerX - (mTempWidth / 2), centerY - mTempHeigh
                , centerX + (mTempWidth / 2), centerY
                /*+ (mTempHeigh / 2)*/);
        bmdMinute.draw(canvas);

        canvas.restore();

        mTempWidth = bmdSecond.getIntrinsicWidth();
        mTempHeigh = bmdSecond.getIntrinsicHeight();
        canvas.rotate(secondRotate, centerX, centerY);
        bmdSecond.setBounds(centerX - (mTempWidth / 2), centerY + 22 - mTempHeigh
                , centerX + (mTempWidth / 2), centerY + 22
               /* + (mTempHeigh / 2)*/);
        bmdSecond.draw(canvas);

        mPaint.setColor(Color.GRAY);
        canvas.drawCircle(centerX, centerY
                , 4, mPaint);
        canvas.save();


        if (scaled) {
            canvas.restore();
        }
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        tickHandler.removeCallbacks(tickRunnable);
        if (mBmpDial != null && !mBmpDial.isRecycled()) {
            Log.d("clock", "Bmp recycle");
            mBmpDial.recycle();
            mBmpDial = null;
        }
        if (mBmpHour != null && !mBmpHour.isRecycled()) {
            mBmpHour.recycle();
            mBmpHour = null;
        }
        if (mBmpMinute != null && !mBmpMinute.isRecycled()) {
            mBmpMinute.recycle();
            mBmpMinute = null;
        }
        if (mBmpSecond != null && !mBmpSecond.isRecycled()) {
            mBmpSecond.recycle();
            mBmpSecond = null;
        }
        mPaint = null;
        System.gc();
    }

}