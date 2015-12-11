// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.urbanairship.push.iam;

import android.os.Handler;
import android.os.SystemClock;

abstract class Timer
{

    private long elapsedTimeMs;
    private final Handler handler = new Handler();
    private boolean isStarted;
    private long remainingTimeMs;
    private long startTimeMs;
    private final Runnable trigger = new _cls1();

    Timer(long l)
    {
        remainingTimeMs = l;
    }

    long getRunTime()
    {
        if (isStarted)
        {
            return (elapsedTimeMs + SystemClock.elapsedRealtime()) - startTimeMs;
        } else
        {
            return elapsedTimeMs;
        }
    }

    protected abstract void onFinish();

    void start()
    {
        if (isStarted)
        {
            return;
        }
        isStarted = true;
        startTimeMs = SystemClock.elapsedRealtime();
        if (remainingTimeMs > 0L)
        {
            handler.postDelayed(trigger, remainingTimeMs);
            return;
        } else
        {
            handler.post(trigger);
            return;
        }
    }

    void stop()
    {
        if (!isStarted)
        {
            return;
        } else
        {
            elapsedTimeMs = SystemClock.elapsedRealtime() - startTimeMs;
            isStarted = false;
            handler.removeCallbacks(trigger);
            remainingTimeMs = Math.max(0L, remainingTimeMs - (SystemClock.elapsedRealtime() - startTimeMs));
            return;
        }
    }


    private class _cls1
        implements Runnable
    {

        final Timer this$0;

        public void run()
        {
            if (isStarted)
            {
                stop();
                onFinish();
            }
        }

        _cls1()
        {
            this$0 = Timer.this;
            super();
        }
    }

}
