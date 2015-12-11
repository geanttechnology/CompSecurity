// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package c.a.a.a;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package c.a.a.a:
//            k, e

final class g
    implements k
{

    private CountDownLatch b;
    private int c;
    private e d;

    g(e e1, int i)
    {
        d = e1;
        c = i;
        super();
        b = new CountDownLatch(c);
    }

    public final void a()
    {
        b.countDown();
        if (b.getCount() == 0L)
        {
            e.a(d).set(true);
            e.b(d).a();
        }
    }

    public final void a(Exception exception)
    {
        e.b(d).a(exception);
    }
}
