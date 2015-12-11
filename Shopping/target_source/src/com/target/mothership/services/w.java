// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services;

import com.google.a.a.e;

// Referenced classes of package com.target.mothership.services:
//            o, z, x

public abstract class w
{

    private o mRequestRetryable;
    private z mResponseCode;

    public w()
    {
    }

    public final e getRequestRetryable()
    {
        return e.c(mRequestRetryable);
    }

    public final z getResponseCode()
    {
        return mResponseCode;
    }

    public String getTag()
    {
        return null;
    }

    public abstract void onError(x x);

    public final void onError(x x, o o)
    {
        mRequestRetryable = o;
        onError(x);
    }

    public abstract void onResult(Object obj);

    public final void onResult(Object obj, z z, o o)
    {
        mRequestRetryable = o;
        mResponseCode = z;
        onResult(obj);
    }
}
