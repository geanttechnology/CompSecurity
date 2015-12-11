// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.d.a;

import e.h;
import e.k;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

// Referenced classes of package e.d.a:
//            t

final class s
    implements k
{

    private static AtomicIntegerFieldUpdater d = AtomicIntegerFieldUpdater.newUpdater(e/d/a/s, "b");
    final h a;
    volatile int b;
    volatile boolean c;

    public s(h h1)
    {
        c = false;
        a = h1;
    }

    public final void b()
    {
        if (d.getAndSet(this, 1) == 0)
        {
            a.a(new t(this));
        }
    }

    public final boolean c()
    {
        return c;
    }

}
