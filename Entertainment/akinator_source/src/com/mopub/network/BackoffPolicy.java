// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import com.mopub.volley.VolleyError;

public abstract class BackoffPolicy
{

    protected int mBackoffMs;
    protected int mBackoffMultiplier;
    protected int mDefaultBackoffTimeMs;
    protected int mMaxBackoffTimeMs;
    protected int mMaxRetries;
    protected int mRetryCount;

    public BackoffPolicy()
    {
    }

    public abstract void backoff(VolleyError volleyerror)
        throws VolleyError;

    public int getBackoffMs()
    {
        return mBackoffMs;
    }

    public int getRetryCount()
    {
        return mRetryCount;
    }

    public boolean hasAttemptRemaining()
    {
        return mRetryCount < mMaxRetries;
    }
}
