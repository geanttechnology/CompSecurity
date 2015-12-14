// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.clouddrive.metrics;

import com.amazon.clouddrive.exceptions.CloudDriveException;

public class MetricEvent
{

    private final CloudDriveException mException;
    private final String mOperationName;
    private final int mRetryCount;
    private final long mTimeInMillis;

    public MetricEvent(String s, long l, int i, CloudDriveException clouddriveexception)
    {
        mOperationName = s;
        mTimeInMillis = l;
        mRetryCount = i;
        mException = clouddriveexception;
    }

    public String getOperationName()
    {
        return mOperationName;
    }

    public long getTimeInMillis()
    {
        return mTimeInMillis;
    }

    public boolean hasSucceeded()
    {
        return mException == null;
    }
}
