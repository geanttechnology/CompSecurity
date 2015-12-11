// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class IntentTimeoutService extends Service
{
    final class ServiceHandler extends Handler
    {

        final IntentTimeoutService this$0;

        public void handleMessage(Message message)
        {
label0:
            {
                handleIntent((Intent)message.obj);
                synchronized (timer)
                {
                    if (!timerCancelled)
                    {
                        break label0;
                    }
                }
                return;
            }
            latestStartId.set(message.arg1);
            if (lastTask != null)
            {
                lastTask.cancel();
                timer.purge();
                lastTask.doStopSelf();
            }
            lastTask = new StopSelfTask(message.arg1);
            timer.schedule(lastTask, timeout);
            timer1;
            JVM INSTR monitorexit ;
            return;
            message;
            timer1;
            JVM INSTR monitorexit ;
            throw message;
        }

        public ServiceHandler(Looper looper)
        {
            this$0 = IntentTimeoutService.this;
            super(looper);
        }
    }

    final class StopSelfTask extends TimerTask
    {

        private final int startId;
        final IntentTimeoutService this$0;

        public void doStopSelf()
        {
            if (latestStartId.get() == startId)
            {
                onTimeout();
            }
            stopSelf(startId);
        }

        public void run()
        {
            synchronized (timer)
            {
                lastTask = null;
            }
            doStopSelf();
            return;
            exception;
            timer1;
            JVM INSTR monitorexit ;
            throw exception;
        }

        public StopSelfTask(int i)
        {
            this$0 = IntentTimeoutService.this;
            super();
            startId = i;
        }
    }


    private boolean isFirstIntent;
    private StopSelfTask lastTask;
    private AtomicInteger latestStartId;
    private final int priority;
    private volatile ServiceHandler serviceHandler;
    private volatile Looper serviceLooper;
    private final String serviceName;
    private long timeout;
    private final Timer timer;
    private volatile boolean timerCancelled;

    public IntentTimeoutService(String s)
    {
        this(s, 0);
    }

    public IntentTimeoutService(String s, int i)
    {
        timer = new Timer();
        timerCancelled = false;
        timeout = 30000L;
        isFirstIntent = true;
        latestStartId = new AtomicInteger(-1);
        serviceName = s;
        priority = i;
    }

    private void handleIntent(Intent intent)
    {
        if (isFirstIntent)
        {
            beforeFirstHandleIntent(intent);
            isFirstIntent = false;
        }
        onHandleIntent(intent);
    }

    protected void beforeFirstHandleIntent(Intent intent)
    {
    }

    public IBinder onBind(Intent intent)
    {
        return null;
    }

    public void onCreate()
    {
        super.onCreate();
        HandlerThread handlerthread = new HandlerThread((new StringBuilder()).append("IntentTimeoutService[").append(serviceName).append("]").toString(), priority);
        handlerthread.start();
        serviceLooper = handlerthread.getLooper();
        serviceHandler = new ServiceHandler(serviceLooper);
    }

    public void onDestroy()
    {
        serviceLooper.quit();
        synchronized (timer)
        {
            timer.cancel();
            timerCancelled = true;
        }
        return;
        exception;
        timer1;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected abstract void onHandleIntent(Intent intent);

    public void onStart(Intent intent, int i)
    {
        Message message = serviceHandler.obtainMessage();
        message.arg1 = i;
        message.obj = intent;
        serviceHandler.sendMessage(message);
    }

    public int onStartCommand(Intent intent, int i, int j)
    {
        onStart(intent, j);
        return 3;
    }

    protected void onTimeout()
    {
    }

    public void setTimeout(long l)
    {
        timeout = l;
    }







/*
    static StopSelfTask access$402(IntentTimeoutService intenttimeoutservice, StopSelfTask stopselftask)
    {
        intenttimeoutservice.lastTask = stopselftask;
        return stopselftask;
    }

*/

}
