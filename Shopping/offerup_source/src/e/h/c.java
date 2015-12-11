// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package e.h;

import e.k;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

// Referenced classes of package e.h:
//            d, e

public final class c
    implements k
{

    private static AtomicReferenceFieldUpdater b = AtomicReferenceFieldUpdater.newUpdater(e/h/c, e/h/d, "a");
    volatile d a;

    public c()
    {
        a = new d(false, e.a());
    }

    public final void a(k k1)
    {
        if (k1 == null)
        {
            throw new IllegalArgumentException("Subscription can not be null");
        }
        d d1;
        d d2;
        do
        {
            d1 = a;
            if (d1.a)
            {
                k1.b();
                return;
            }
            d2 = new d(d1.a, k1);
        } while (!b.compareAndSet(this, d1, d2));
    }

    public final void b()
    {
        d d1;
        d d2;
        do
        {
            d1 = a;
            if (d1.a)
            {
                return;
            }
            d2 = new d(true, d1.b);
        } while (!b.compareAndSet(this, d1, d2));
        d1.b.b();
    }

    public final boolean c()
    {
        return a.a;
    }

}
