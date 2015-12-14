// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.os.Handler;
import com.mopub.common.Preconditions;

public abstract class RepeatingHandlerRunnable
    implements Runnable
{

    protected final Handler mHandler;
    private volatile boolean mIsRunning;
    private volatile long mUpdateIntervalMillis;

    RepeatingHandlerRunnable(Handler handler)
    {
        Preconditions.checkNotNull(handler);
        mHandler = handler;
    }

    public abstract void doWork();

    public void run()
    {
        if (mIsRunning)
        {
            doWork();
            mHandler.postDelayed(this, mUpdateIntervalMillis);
        }
    }

    boolean shouldBeRunning()
    {
        return mIsRunning;
    }

    public void startRepeating(long l)
    {
        boolean flag;
        if (l > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "intervalMillis must be greater than 0. Saw: %d", new Object[] {
            Long.valueOf(l)
        });
        mUpdateIntervalMillis = l;
        if (!mIsRunning)
        {
            mIsRunning = true;
            mHandler.post(this);
        }
    }

    public void stop()
    {
        mIsRunning = false;
    }
}
