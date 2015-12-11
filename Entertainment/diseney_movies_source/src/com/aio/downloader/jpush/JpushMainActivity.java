// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.jpush;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import cn.jpush.android.api.JPushInterface;
import com.umeng.analytics.MobclickAgent;

public class JpushMainActivity extends Activity
{
    public class MessageReceiver extends BroadcastReceiver
    {

        final JpushMainActivity this$0;

        public void onReceive(Context context, Intent intent)
        {
            if ("com.example.jpushdemo.MESSAGE_RECEIVED_ACTION".equals(intent.getAction()))
            {
                context = intent.getStringExtra("message");
                intent.getStringExtra("extras");
                (new StringBuilder()).append((new StringBuilder("message : ")).append(context).append("\n").toString());
            }
        }

        public MessageReceiver()
        {
            this$0 = JpushMainActivity.this;
            super();
        }
    }


    public static final String KEY_EXTRAS = "extras";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_TITLE = "title";
    public static final String MESSAGE_RECEIVED_ACTION = "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION";
    public static boolean isForeground = false;
    private MessageReceiver mMessageReceiver;

    public JpushMainActivity()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030063);
        registerMessageReceiver();
    }

    protected void onDestroy()
    {
        unregisterReceiver(mMessageReceiver);
        super.onDestroy();
    }

    protected void onPause()
    {
        isForeground = false;
        JPushInterface.init(this);
        MobclickAgent.onPause(this);
        super.onPause();
    }

    protected void onResume()
    {
        isForeground = true;
        JPushInterface.onResume(this);
        MobclickAgent.onResume(this);
        super.onResume();
    }

    public void registerMessageReceiver()
    {
        mMessageReceiver = new MessageReceiver();
        IntentFilter intentfilter = new IntentFilter();
        intentfilter.setPriority(1000);
        intentfilter.addAction("com.example.jpushdemo.MESSAGE_RECEIVED_ACTION");
        registerReceiver(mMessageReceiver, intentfilter);
    }

}
