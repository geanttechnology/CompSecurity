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

    private long mCount;
    private final String mCounterName;
    private String mStartTimestamp;

    public void increment(long l)
    {
        mCount = mCount + l;
        mStartTimestamp = ISO8601.getUTCString(new Date());
    }

    public (String s)
    {
        mCounterName = s;
        mStartTimestamp = ISO8601.getUTCString(new Date());
    }
}
