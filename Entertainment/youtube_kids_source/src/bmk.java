// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Random;

public final class bmk
{

    public final long a;
    private final long b;
    private final long c;
    private final Random d;
    private long e;

    public bmk()
    {
        this(1000L, 30000L, 5L);
    }

    private bmk(long l, long l1, long l2)
    {
        d = new Random();
        e = 0L;
        b = 1000L;
        c = 30000L;
        boolean flag;
        if (5L >= 1L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        b.a(flag);
        a = 5L;
    }

    public final boolean a()
    {
        if (e >= a)
        {
            return false;
        }
        long l1 = (long)((1.0D + d.nextDouble()) * (double)b * Math.pow(2D, e));
        long l = l1;
        if (l1 > c)
        {
            l = c;
        }
        try
        {
            bmo.d((new StringBuilder(42)).append("Sleeping thread for ").append(l).append("ms").toString());
            Thread.sleep(l);
            e = e + 1L;
        }
        catch (InterruptedException interruptedexception)
        {
            bmo.a("Thread interrupted", interruptedexception);
            return false;
        }
        return true;
    }
}
