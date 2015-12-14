// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import com.dp.utils.SystemTime;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.client.metrics:
//            DoubleValidator

public class AggregatingTimer
{

    private static final TimeUnit TIMEUNIT;
    private final boolean mAllowRunningTimers;
    private long mLastUpdatedTime;
    private int mRunningCount;
    private double mTotalElapsedTime;
    private int mTotalSamplesCount;

    public AggregatingTimer(boolean flag)
    {
        mRunningCount = 0;
        mTotalSamplesCount = 0;
        mLastUpdatedTime = 0L;
        mTotalElapsedTime = 0.0D;
        mAllowRunningTimers = flag;
    }

    public void addTime(double d, int i)
    {
        DoubleValidator.validateDouble(d);
        mTotalElapsedTime = mTotalElapsedTime + d;
        mTotalSamplesCount = mTotalSamplesCount + i;
    }

    public double getElapsedTime()
    {
        if (!mAllowRunningTimers && mRunningCount > 0)
        {
            throw new IllegalStateException((new StringBuilder()).append("Cannot get elapsed time - ").append(mRunningCount).append(" start calls not matched with stop.").toString());
        } else
        {
            return mTotalElapsedTime;
        }
    }

    public int getSamples()
    {
        return mTotalSamplesCount;
    }

    public int numRunningTimers()
    {
        return mRunningCount;
    }

    public void startTimer()
    {
        long l = SystemTime.now();
        if (mRunningCount > 0)
        {
            mTotalElapsedTime = mTotalElapsedTime + (double)((long)mRunningCount * (l - mLastUpdatedTime));
        }
        mLastUpdatedTime = l;
        mRunningCount = mRunningCount + 1;
    }

    public void stopTimer()
    {
        long l = SystemTime.now();
        if (mRunningCount > 0)
        {
            mTotalElapsedTime = mTotalElapsedTime + (double)((long)mRunningCount * (l - mLastUpdatedTime));
            mRunningCount = mRunningCount - 1;
            mLastUpdatedTime = l;
            mTotalSamplesCount = mTotalSamplesCount + 1;
        }
    }

    static 
    {
        TIMEUNIT = TimeUnit.MILLISECONDS;
    }
}
