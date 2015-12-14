// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.metrics;

import com.amazon.mixtape.utils.ISO8601;
import java.util.Date;

// Referenced classes of package com.amazon.mixtape.metrics:
//            MixtapeMetric

public static class mStartTimestamp
    implements MixtapeMetric
{

    private int mCount;
    private final String mEventName;
    private boolean mIsError;
    private String mStartTimestamp;

    public mStartTimestamp errored()
    {
        mIsError = true;
        return this;
    }

    public int getCount()
    {
        return mCount;
    }

    public String getEventName()
    {
        return mEventName;
    }

    public boolean isError()
    {
        return mIsError;
    }

    public mIsError setCount(int i)
    {
        mCount = i;
        return this;
    }

    public (String s)
    {
        mCount = 1;
        mEventName = s;
        mStartTimestamp = ISO8601.getUTCString(new Date());
    }
}
