// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.metrics;

import android.os.SystemClock;
import com.amazon.mixtape.utils.ISO8601;
import java.util.Date;

// Referenced classes of package com.amazon.mixtape.metrics:
//            MixtapeMetric

public static class mEventName
    implements MixtapeMetric
{

    private int mCount;
    private double mDuration;
    private final String mEventName;
    private long mFinishTime;
    private boolean mIsError;
    private long mStartTime;
    private String mStartTimestamp;

    public mEventName failed()
    {
        mFinishTime = SystemClock.elapsedRealtime();
        mIsError = true;
        return this;
    }

    public mIsError finished()
    {
        mFinishTime = SystemClock.elapsedRealtime();
        return this;
    }

    public int getCount()
    {
        return mCount;
    }

    public double getDuration()
    {
        if (mStartTime > 0L && mFinishTime > 0L)
        {
            return (double)(mFinishTime - mStartTime);
        } else
        {
            return mDuration;
        }
    }

    public String getEventName()
    {
        return mEventName;
    }

    public boolean isError()
    {
        return mIsError;
    }

    public mIsError start()
    {
        mStartTime = SystemClock.elapsedRealtime();
        mStartTimestamp = ISO8601.getUTCString(new Date());
        return this;
    }

    public (String s)
    {
        mStartTimestamp = null;
        mStartTime = -1L;
        mFinishTime = -1L;
        mEventName = s;
    }
}
