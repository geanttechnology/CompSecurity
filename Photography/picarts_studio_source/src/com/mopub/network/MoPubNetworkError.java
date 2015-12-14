// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyError;

public class MoPubNetworkError extends VolleyError
{

    private final Reason mReason;
    private final Integer mRefreshTimeMillis;

    public MoPubNetworkError(Reason reason)
    {
        mReason = reason;
        mRefreshTimeMillis = null;
    }

    public MoPubNetworkError(NetworkResponse networkresponse, Reason reason)
    {
        super(networkresponse);
        mReason = reason;
        mRefreshTimeMillis = null;
    }

    public MoPubNetworkError(String s, Reason reason)
    {
        this(s, reason, ((Integer) (null)));
    }

    public MoPubNetworkError(String s, Reason reason, Integer integer)
    {
        super(s);
        mReason = reason;
        mRefreshTimeMillis = integer;
    }

    public MoPubNetworkError(String s, Throwable throwable, Reason reason)
    {
        super(s, throwable);
        mReason = reason;
        mRefreshTimeMillis = null;
    }

    public MoPubNetworkError(Throwable throwable, Reason reason)
    {
        super(throwable);
        mReason = reason;
        mRefreshTimeMillis = null;
    }

    public Reason getReason()
    {
        return mReason;
    }

    public Integer getRefreshTimeMillis()
    {
        return mRefreshTimeMillis;
    }
}
