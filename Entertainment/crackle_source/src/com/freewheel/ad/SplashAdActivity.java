// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.freewheel.ad;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.gotv.crackle.Application;
import java.util.Timer;
import java.util.TimerTask;
import tv.freewheel.ad.interfaces.ISlot;

public class SplashAdActivity extends Activity
{
    private class HomeTask extends TimerTask
    {

        final SplashAdActivity this$0;

        public void run()
        {
            Application.getInstance().startHomeActivity(SplashAdActivity.this);
            finish();
        }

        private HomeTask()
        {
            this$0 = SplashAdActivity.this;
            super();
        }

    }


    private static ISlot sSlot;
    private Timer mTimer;

    public SplashAdActivity()
    {
    }

    public static void setSlot(ISlot islot)
    {
        sSlot = islot;
        if (sSlot != null)
        {
            sSlot.setParameter("renderer.html.shouldUseDip", "true");
        }
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030070);
        bundle = (RelativeLayout)findViewById(0x7f0a00be);
        mTimer = new Timer();
        if (sSlot != null)
        {
            sSlot.setParameter("renderer.html.shouldUseDip", "true");
            android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, -1);
            layoutparams.addRule(13);
            ViewGroup viewgroup = sSlot.getBase();
            viewgroup.setLayoutParams(layoutparams);
            try
            {
                ((ViewGroup)viewgroup.getParent()).removeView(viewgroup);
            }
            catch (Exception exception) { }
            bundle.addView(viewgroup);
            sSlot.play();
            mTimer.schedule(new HomeTask(), 5000L);
            return;
        } else
        {
            mTimer.schedule(new HomeTask(), 0L);
            return;
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    protected void onStop()
    {
        sSlot = null;
        if (mTimer != null)
        {
            mTimer.cancel();
            mTimer = null;
        }
        if (!isFinishing())
        {
            finish();
        }
        super.onStop();
    }
}
