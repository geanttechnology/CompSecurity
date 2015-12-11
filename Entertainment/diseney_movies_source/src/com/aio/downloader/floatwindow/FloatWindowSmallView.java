// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.floatwindow;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.aio.downloader.activity.FloatCleanerMaster;
import com.umeng.analytics.MobclickAgent;
import java.lang.reflect.Field;

// Referenced classes of package com.aio.downloader.floatwindow:
//            MyWindowManager

public class FloatWindowSmallView extends LinearLayout
{

    public static TextView percentView;
    private static int statusBarHeight;
    public static int viewHeight;
    public static int viewWidth;
    public static int xLoa = 0;
    private int height;
    private ImageView iv_bigview;
    private android.view.WindowManager.LayoutParams mParams;
    private View view;
    private int width;
    private WindowManager windowManager;
    private float xDownInScreen;
    private float xInScreen;
    private float xInView;
    private float yDownInScreen;
    private float yInScreen;
    private float yInView;

    public FloatWindowSmallView(Context context)
    {
        super(context);
        windowManager = (WindowManager)context.getSystemService("window");
        LayoutInflater.from(context).inflate(0x7f030046, this);
        view = findViewById(0x7f0701eb);
        viewWidth = view.getLayoutParams().width;
        viewHeight = view.getLayoutParams().height;
        percentView = (TextView)findViewById(0x7f0701ec);
        iv_bigview = (ImageView)findViewById(0x7f0701ed);
        context = (WindowManager)getContext().getSystemService("window");
        width = context.getDefaultDisplay().getWidth();
        height = context.getDefaultDisplay().getHeight();
    }

    private void ViewPosition()
    {
        if (xInScreen > (float)(width / 2))
        {
            xLoa = 0;
            mParams.x = width;
            mParams.y = (int)(yInScreen - yInView);
            windowManager.updateViewLayout(this, mParams);
            percentView.setBackgroundResource(0x7f0200b2);
            return;
        } else
        {
            xLoa = 1;
            mParams.x = 0;
            mParams.y = (int)(yInScreen - yInView);
            windowManager.updateViewLayout(this, mParams);
            percentView.setBackgroundResource(0x7f0200b3);
            return;
        }
    }

    private int getStatusBarHeight()
    {
        if (statusBarHeight == 0)
        {
            try
            {
                Class class1 = Class.forName("com.android.internal.R$dimen");
                Object obj = class1.newInstance();
                int i = ((Integer)class1.getField("status_bar_height").get(obj)).intValue();
                statusBarHeight = getResources().getDimensionPixelSize(i);
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
            }
        }
        return statusBarHeight;
    }

    private void openBigWindow()
    {
        MyWindowManager.createBigWindow(getContext());
        MyWindowManager.removeSmallWindow(getContext());
    }

    private void updateViewPosition()
    {
        mParams.x = (int)(xInScreen - xInView);
        mParams.y = (int)(yInScreen - yInView);
        windowManager.updateViewLayout(this, mParams);
    }

    public boolean onTouchEvent(MotionEvent motionevent)
    {
        motionevent.getAction();
        JVM INSTR tableswitch 0 2: default 32
    //                   0 34
    //                   1 214
    //                   2 97;
           goto _L1 _L2 _L3 _L4
_L1:
        return true;
_L2:
        xInView = motionevent.getX();
        yInView = motionevent.getY();
        xDownInScreen = motionevent.getRawX();
        yDownInScreen = motionevent.getRawY() - (float)getStatusBarHeight();
        xInScreen = motionevent.getRawX();
        yInScreen = motionevent.getRawY() - (float)getStatusBarHeight();
        continue; /* Loop/switch isn't completed */
_L4:
        xInScreen = motionevent.getRawX();
        yInScreen = motionevent.getRawY() - (float)getStatusBarHeight();
        updateViewPosition();
        if (xInScreen > (float)(width / 2))
        {
            if ((float)width - xInScreen > (float)(width / 8))
            {
                percentView.setVisibility(8);
                iv_bigview.setVisibility(0);
            }
        } else
        if (xInScreen > (float)(width / 8))
        {
            percentView.setVisibility(8);
            iv_bigview.setVisibility(0);
        }
        continue; /* Loop/switch isn't completed */
_L3:
        if (xDownInScreen - xInScreen >= -20F && yDownInScreen - yInScreen >= -20F)
        {
            motionevent = new Intent(getContext(), com/aio/downloader/activity/FloatCleanerMaster);
            motionevent.setFlags(0x10000000);
            getContext().startActivity(motionevent);
            ViewPosition();
            MobclickAgent.onEvent(getContext(), "float_click");
        } else
        {
            ViewPosition();
        }
        percentView.setVisibility(0);
        iv_bigview.setVisibility(8);
        if (true) goto _L1; else goto _L5
_L5:
    }

    public void setParams(android.view.WindowManager.LayoutParams layoutparams)
    {
        mParams = layoutparams;
    }

}
