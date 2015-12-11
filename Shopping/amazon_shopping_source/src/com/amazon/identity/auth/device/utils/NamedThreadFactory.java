// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class NamedThreadFactory
    implements ThreadFactory
{

    private final String mName;
    private final AtomicInteger mThreadNum = new AtomicInteger(1);

    NamedThreadFactory(String s)
    {
        mName = s;
    }

    public String getName()
    {
        return mName;
    }

    public Thread newThread(Runnable runnable)
    {
        return new Thread(runnable, String.format("%s#%d", new Object[] {
            mName, Integer.valueOf(mThreadNum.getAndIncrement())
        }));
    }
}
