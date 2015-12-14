// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sina.weibo.sdk.component.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.TextView;

public class LoadingBar extends TextView
{

    private static final int MAX_PROGRESS = 100;
    private Handler mHander;
    private Paint mPaint;
    private int mProgress;
    private int mProgressColor;
    private Runnable mRunnable = new Runnable() {

        final LoadingBar this$0;

        public void run()
        {
            LoadingBar loadingbar = LoadingBar.this;
            loadingbar.mProgress = loadingbar.mProgress + 1;
            drawProgress(mProgress);
        }

            
            {
                this$0 = LoadingBar.this;
                super();
            }
    };

    public LoadingBar(Context context)
    {
        super(context);
        init(context);
    }

    public LoadingBar(Context context, AttributeSet attributeset)
    {
        super(context, attributeset);
        init(context);
    }

    public LoadingBar(Context context, AttributeSet attributeset, int i)
    {
        super(context, attributeset, i);
        init(context);
    }

    private Rect getRect()
    {
        int i = getLeft();
        int j = getTop();
        return new Rect(0, 0, (getLeft() + ((getRight() - getLeft()) * mProgress) / 100) - i, getBottom() - j);
    }

    private void init(Context context)
    {
        mHander = new Handler();
        mPaint = new Paint();
        initSkin();
    }

    public void drawProgress(int i)
    {
        if (i < 7)
        {
            mHander.postDelayed(mRunnable, 70L);
        } else
        {
            mHander.removeCallbacks(mRunnable);
            mProgress = i;
        }
        invalidate();
    }

    public void initSkin()
    {
        mProgressColor = 0xff4d90fe;
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        mPaint.setColor(mProgressColor);
        canvas.drawRect(getRect(), mPaint);
    }


}
