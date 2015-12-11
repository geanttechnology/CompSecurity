// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.chromium.net;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class 
    implements ThreadFactory
{

    private final AtomicInteger a = new AtomicInteger(1);

    public final Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable, (new StringBuilder("HttpUrlConnection #")).append(a.getAndIncrement()).toString());
        runnable.setPriority(5);
        return runnable;
    }

    ()
    {
    }
}
