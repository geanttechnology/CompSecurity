// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.core;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package net.tsz.afinal.core:
//            AsyncTask

class icInteger
    implements ThreadFactory
{

    private final AtomicInteger mCount = new AtomicInteger(1);

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable, (new StringBuilder("AsyncTask #")).append(mCount.getAndIncrement()).toString());
        runnable.setPriority(4);
        return runnable;
    }

    icInteger()
    {
    }
}
