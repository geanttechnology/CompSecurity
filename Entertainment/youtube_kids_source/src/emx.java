// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class emx
{

    public Integer a;
    private String b;
    private Boolean c;
    private Thread.UncaughtExceptionHandler d;
    private ThreadFactory e;

    public emx()
    {
        b = null;
        c = null;
        a = null;
        d = null;
        e = null;
    }

    public final emx a(String s)
    {
        String.format(s, new Object[] {
            Integer.valueOf(0)
        });
        b = s;
        return this;
    }

    public final ThreadFactory a()
    {
        String s = b;
        Integer integer = a;
        ThreadFactory threadfactory = Executors.defaultThreadFactory();
        AtomicLong atomiclong;
        if (s != null)
        {
            atomiclong = new AtomicLong(0L);
        } else
        {
            atomiclong = null;
        }
        return new emy(threadfactory, s, atomiclong, null, integer, null);
    }
}
