// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.c;

import e.h.b;
import e.k;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package e.d.c:
//            g

final class i extends AtomicBoolean
    implements k
{

    private g a;
    private b b;

    public i(g g1, b b1)
    {
        a = g1;
        b = b1;
    }

    public final void b()
    {
        if (compareAndSet(false, true))
        {
            b.b(a);
        }
    }

    public final boolean c()
    {
        return a.c();
    }
}
