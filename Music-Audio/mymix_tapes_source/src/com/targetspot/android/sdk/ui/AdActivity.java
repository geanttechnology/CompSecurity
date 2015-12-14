// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.targetspot.android.sdk.ui;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.LinearLayout;
import com.targetspot.android.sdk.service.AdBreak;
import com.targetspot.android.sdk.service.AdClientImpl;
import com.targetspot.android.sdk.service.AdManager;

public class AdActivity extends Activity
{

    AdClientImpl client;
    boolean finished;
    private Handler handler;
    AdManager manager;

    public AdActivity()
    {
        manager = AdManager.getInstance();
        client = manager.getActiveClient();
        finished = false;
        handler = new Handler() {

            final AdActivity this$0;

            public void handleMessage(Message message)
            {
                if (message.obj instanceof AdBreak)
                {
                    onAdShow((AdBreak)message.obj);
                }
            }

            
            {
                this$0 = AdActivity.this;
                super();
            }
        };
    }

    protected void onAdShow(AdBreak adbreak)
    {
        adbreak = new Runnable() {

            final AdActivity this$0;

            public void run()
            {
                finished = true;
                finish();
            }

            
            {
                this$0 = AdActivity.this;
                super();
            }
        };
        handler.postAtTime(adbreak, SystemClock.uptimeMillis() + 5000L);
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = new LinearLayout(this);
        bundle.setOrientation(1);
        android.widget.LinearLayout.LayoutParams layoutparams = new android.widget.LinearLayout.LayoutParams(-1, -2);
        layoutparams.setMargins(30, 20, 30, 0);
        Button button = new Button(this);
        button.setText("Show More");
        bundle.addView(button, layoutparams);
        setContentView(bundle);
    }

    protected void onPause()
    {
        super.onPause();
    }

    protected void onResume()
    {
        super.onResume();
    }
}
