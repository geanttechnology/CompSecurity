// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.blueshift.bluefront.android.common;

import com.google.common.base.Preconditions;

public final class RequestTimeouts
{

    public static final int DEFAULT_CONNECTION_TIMEOUT_MILLIS = 3000;
    public static final int DEFAULT_RESPONSE_TIMEOUT_MILLIS = 5000;
    private final int mConnectionTimeoutMillis;
    private final int mResponseTimeoutMillis;

    public RequestTimeouts()
    {
        this(5000, 3000);
    }

    public RequestTimeouts(int i, int j)
    {
        boolean flag1 = true;
        super();
        boolean flag;
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Response timeout must be positive.");
        if (j > 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "Connection timeout must be positive.");
        mResponseTimeoutMillis = i;
        mConnectionTimeoutMillis = j;
    }

    public int getConnectionTimeoutMillis()
    {
        return mConnectionTimeoutMillis;
    }

    public int getResponseTimeoutMillis()
    {
        return mResponseTimeoutMillis;
    }
}
