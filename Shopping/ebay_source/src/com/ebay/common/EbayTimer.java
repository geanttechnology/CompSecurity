// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;

import android.os.Handler;

public class EbayTimer extends Handler
    implements Runnable
{
    public static interface OnTimerEvent
    {

        public abstract void OnTimer();
    }


    private final long delayMs;
    private boolean notifyOnStart;
    private OnTimerEvent onTimerEvent;
    private boolean timerRunning;

    public EbayTimer(long l)
    {
        timerRunning = false;
        notifyOnStart = true;
        delayMs = l;
    }

    public boolean isTimerRunning()
    {
        return timerRunning;
    }

    public void run()
    {
        if (timerRunning)
        {
            if (onTimerEvent != null)
            {
                onTimerEvent.OnTimer();
            }
            postDelayed(this, delayMs);
        }
    }

    public EbayTimer setNotifyOnStart(boolean flag)
    {
        notifyOnStart = flag;
        return this;
    }

    public final void setOnTimerEvent(OnTimerEvent ontimerevent)
    {
        onTimerEvent = ontimerevent;
    }

    public final void start()
    {
label0:
        {
            if (!timerRunning)
            {
                timerRunning = true;
                if (!notifyOnStart)
                {
                    break label0;
                }
                post(this);
            }
            return;
        }
        postDelayed(this, delayMs);
    }

    public final void stop()
    {
        timerRunning = false;
        removeCallbacks(this);
    }
}
