// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.c;

import e.k;
import java.util.concurrent.Future;

// Referenced classes of package e.d.c:
//            g

final class h
    implements k
{

    private final Future a;
    private g b;

    private h(g g1, Future future)
    {
        b = g1;
        super();
        a = future;
    }

    h(g g1, Future future, byte byte0)
    {
        this(g1, future);
    }

    public final void b()
    {
        if (b.get() != Thread.currentThread())
        {
            a.cancel(true);
            return;
        } else
        {
            a.cancel(false);
            return;
        }
    }

    public final boolean c()
    {
        return a.isCancelled();
    }
}
