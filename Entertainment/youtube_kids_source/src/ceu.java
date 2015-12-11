// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.Queue;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;

final class ceu
    implements Callable
{

    private ceq a;

    ceu(ceq ceq1)
    {
        a = ceq1;
        super();
    }

    private Void a()
    {
        boolean flag = true;
        cex cex1 = ceq.j(a);
        if (System.currentTimeMillis() - cex1.e <= (long)cex.a)
        {
            flag = false;
        }
        if (!flag) goto _L2; else goto _L1
_L1:
        ceq.f(a).b("Message: %s is older than %dms. Dropping.", new Object[] {
            ceq.j(a), Integer.valueOf(cex.a)
        });
        ceq.k(a).poll();
        ceq.a(a, ceq.j(a).b, 4);
_L4:
        ceq.c(a);
        return null;
_L2:
        ceq.a(a, ceq.j(a).c, ceq.j(a).d, ceq.j(a).b);
        if (ceq.l(a) != null)
        {
            ceq.l(a).cancel(true);
        }
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        ceq.c(a);
        throw exception;
    }

    public final Object call()
    {
        return a();
    }
}
