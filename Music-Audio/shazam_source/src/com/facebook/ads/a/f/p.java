// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.f;

import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class p
    implements ThreadFactory
{

    protected final AtomicLong a = new AtomicLong();
    private int b;

    public p()
    {
        b = Thread.currentThread().getPriority();
    }

    public final Thread newThread(Runnable runnable)
    {
        runnable = new Thread(null, runnable, String.format(Locale.ENGLISH, "com.facebook.ads thread-%d %tF %<tT", new Object[] {
            Long.valueOf(a.incrementAndGet()), Long.valueOf(System.currentTimeMillis())
        }), 0L);
        runnable.setPriority(b);
        return runnable;
    }
}
