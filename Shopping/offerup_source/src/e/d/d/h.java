// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.d;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;

public final class h
    implements ThreadFactory
{

    private static AtomicLongFieldUpdater c = AtomicLongFieldUpdater.newUpdater(e/d/d/h, "a");
    volatile long a;
    private String b;

    public h(String s)
    {
        b = s;
    }

    public final Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable, (new StringBuilder()).append(b).append(c.incrementAndGet(this)).toString());
        runnable.setDaemon(true);
        return runnable;
    }

}
