// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.liverail.library.c;

import com.a.a.a.f;
import com.liverail.library.a.b;
import com.liverail.library.a.c;
import com.liverail.library.b.a;
import java.net.SocketTimeoutException;
import java.util.Date;

// Referenced classes of package com.liverail.library.c:
//            a

class d extends f
{

    final com.liverail.library.c.a a;

    d(com.liverail.library.c.a a1)
    {
        a = a1;
        super();
    }

    public void a()
    {
        com.liverail.library.b.a.b((new StringBuilder("(LR2) ~ LiveRail req start delay=")).append((new Date()).getTime() - com.liverail.library.c.a.c(a)).append("ms").toString());
        com.liverail.library.c.a.b(a, (new Date()).getTime());
    }

    public void a(int i, String s)
    {
        com.liverail.library.b.a.c((new StringBuilder("(LR2) ~ LiveRail req complete ")).append((new Date()).getTime() - com.liverail.library.c.a.c(a)).append("ms ").toString());
        com.liverail.library.c.a.a(a, null);
        com.liverail.library.c.a.a(a, s);
    }

    public void a(Throwable throwable, String s)
    {
        long l = (new Date()).getTime() - com.liverail.library.c.a.c(a);
        com.liverail.library.b.a.e((new StringBuilder("(LR2) ~ LiveRail req failed ")).append(l).append("ms ").append(s).append(" ").append(throwable).toString());
        com.liverail.library.c.a.a(a, null);
        if (throwable instanceof SocketTimeoutException)
        {
            com.liverail.library.c.a.a(a, new b(c.l, (new StringBuilder(String.valueOf(l))).append("ms ").append(throwable.toString()).toString()));
            return;
        } else
        {
            com.liverail.library.c.a.a(a, new b(c.k, (new StringBuilder(String.valueOf(l))).append("ms ").append(throwable.toString()).toString()));
            return;
        }
    }
}
