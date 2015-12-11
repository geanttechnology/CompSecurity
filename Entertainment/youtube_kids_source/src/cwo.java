// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.Handler;
import java.util.concurrent.Executor;

public final class cwo
    implements cwv
{

    public final bmi a;
    public final Executor b;
    final bor c;
    final cwu d;
    public final String e;
    public final long f;
    public final long g;
    public final String h;
    final String i;
    public final Runnable j = new cwt(this);
    public volatile long k;
    volatile int l;
    public volatile boolean m;
    private final Handler n;

    public cwo(bmi bmi1, Executor executor, Handler handler, bor bor1, cwu cwu1, String s, long l1, long l2, String s1, String s2)
    {
        a = (bmi)b.a(bmi1);
        b = (Executor)b.a(executor);
        n = (Handler)b.a(handler);
        c = (bor)b.a(bor1);
        d = (cwu)b.a(cwu1);
        e = b.a(s);
        f = l1;
        g = l2;
        h = b.a(s1);
        i = b.a(s2);
        k = 0L;
        l = 0;
        m = false;
    }

    final void a(cse cse)
    {
        n.post(new cwp(this, cse));
    }

    public final void b()
    {
    }
}
