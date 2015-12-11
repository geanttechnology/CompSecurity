// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.avod.sdk.internal;

import android.util.Log;

public class CleanupGuard
{

    private volatile Throwable mResourceAllocationSource;

    public CleanupGuard()
    {
    }

    public void close()
    {
        mResourceAllocationSource = null;
    }

    public boolean isOpen()
    {
        return mResourceAllocationSource != null;
    }

    public void open(String s)
    {
        if (s == null)
        {
            throw new NullPointerException("Need a resource");
        } else
        {
            mResourceAllocationSource = new Throwable((new StringBuilder()).append("Cleanup method '").append(s).append("' not called").toString());
            return;
        }
    }

    public void warnIfOpen()
    {
        if (!isOpen())
        {
            return;
        } else
        {
            Log.w("AmazonInstantVideoSDK", "Resources were acquired by AmazonInstantVideo but never released, see stacktrace for details", mResourceAllocationSource);
            return;
        }
    }
}
