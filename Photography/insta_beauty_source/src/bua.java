// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

final class bua
    implements ThreadFactory
{

    final String a;
    final AtomicLong b;

    bua(String s, AtomicLong atomiclong)
    {
        a = s;
        b = atomiclong;
        super();
    }

    public Thread newThread(Runnable runnable)
    {
        runnable = Executors.defaultThreadFactory().newThread(new bub(this, runnable));
        runnable.setName((new StringBuilder()).append(a).append(b.getAndIncrement()).toString());
        return runnable;
    }
}
