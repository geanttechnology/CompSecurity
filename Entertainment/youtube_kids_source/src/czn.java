// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.SystemClock;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class czn
{

    final bxd a;
    public long b;
    public long c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public int i;
    final czk j;
    private Runnable k;

    czn(czk czk1, ebv ebv1, bxd bxd)
    {
        j = czk1;
        super();
        c = 0L;
        d = 0L;
        e = 0L;
        f = 0L;
        g = 0L;
        h = 0L;
        i = 8;
        k = new czo(this);
        a = bxd;
        if (ebv1 != null)
        {
            c = TimeUnit.SECONDS.toMillis(ebv1.a);
            d = TimeUnit.SECONDS.toMillis(ebv1.b);
            e = TimeUnit.SECONDS.toMillis(ebv1.c);
        }
    }

    private long b(int l)
    {
        long l1 = SystemClock.elapsedRealtime();
        long l2 = b;
        i = l;
        b = l1;
        return l1 - l2;
    }

    void a()
    {
        b();
        a(8);
    }

    void a(int l)
    {
        switch (czl.b[i - 1])
        {
        default:
            return;

        case 1: // '\001'
        case 5: // '\005'
            f = f + b(l);
            return;

        case 6: // '\006'
            h = h + b(l);
            return;

        case 2: // '\002'
            g = g + b(l);
            return;

        case 3: // '\003'
        case 4: // '\004'
        case 7: // '\007'
            b(l);
            return;
        }
    }

    void a(long l)
    {
        if (czk.b(j) != null)
        {
            czk.b(j).cancel(false);
        }
        czk.a(j, czk.c(j).schedule(k, l, TimeUnit.MILLISECONDS));
    }

    void b()
    {
        if (czk.b(j) != null)
        {
            czk.b(j).cancel(false);
        }
    }
}
