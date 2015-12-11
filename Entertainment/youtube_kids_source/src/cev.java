// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

final class cev
    implements Callable
{

    private Future a;
    private ceq b;

    cev(ceq ceq1, Future future)
    {
        b = ceq1;
        a = future;
        super();
    }

    public final Object call()
    {
        if (!a.isDone())
        {
            ceq.f(b).b("Message %s took longer than %dms to send. Interrupting.", new Object[] {
                ceq.j(b), Integer.valueOf(ceq.m(b))
            });
            a.cancel(true);
        }
        return null;
    }
}
