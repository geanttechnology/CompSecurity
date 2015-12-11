// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;

final class rp extends Handler
{

    final Runnable a;
    long b;
    final rl c;

    public rp(rl rl1)
    {
        c = rl1;
        super();
        a = new rq(this, rl1);
    }

    static void a(rp rp1)
    {
        long l1 = 1000L;
        if (!rp1.c.k)
        {
            rl.a(rp1.c, rp1.c.c.h(), rp1.c.c.i(), rp1.c.c.j());
            Runnable runnable = rp1.a;
            long l = l1;
            if (rp1.b > 0L)
            {
                l = l1;
                if (rp1.b <= 1000L)
                {
                    l = rp1.b;
                }
            }
            rp1.postDelayed(runnable, l);
            rp1.b = 0x7fffffffffffffffL;
        }
    }

    public final void a()
    {
        removeCallbacks(a);
    }
}
