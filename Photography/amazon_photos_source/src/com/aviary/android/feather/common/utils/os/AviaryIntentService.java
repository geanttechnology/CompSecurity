// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aviary.android.feather.common.utils.os;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;

public abstract class AviaryIntentService extends Service
{
    private final class ServiceHandler extends Handler
    {

        final AviaryIntentService this$0;

        public void handleMessage(Message message)
        {
            onHandleIntent((Intent)message.obj);
            stopSelf(message.arg1);
        }

        public ServiceHandler(Looper looper)
        {
            this$0 = AviaryIntentService.this;
            super(looper);
        }
    }


    private final String mName;
    private boolean mRedelivery;
    private volatile ServiceHandler mServiceHandler;
    private volatile Looper mServiceLooper;

    public AviaryIntentService(String s)
    {
        mName = s;
    }

    public void clearServiceQueue()
    {
        mServiceHandler.removeCallbacksAndMessages(null);
    }

    public Looper getCurrentLooper()
    {
        return mServiceLooper;
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        HandlerThread handlerthread = new HandlerThread((new StringBuilder()).append("IntentService[").append(mName).append("]").toString());
        handlerthread.start();
        mServiceLooper = handlerthread.getLooper();
        mServiceHandler = new ServiceHandler(mServiceLooper);
    }

    public void onDestroy()
    {
        mServiceLooper.quit();
    }

    protected abstract void onHandleIntent(Intent intent);

    public void onStart(Intent intent, int i)
    {
        Message message = mServiceHandler.obtainMessage();
        message.arg1 = i;
        message.obj = intent;
        mServiceHandler.sendMessage(message);
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        onStart(intent, j);
        return !mRedelivery ? 2 : 3;
    }

    public void setIntentRedelivery(boolean flag)
    {
        mRedelivery = flag;
    }
}
