// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a;


// Referenced classes of package com.a.a:
//            e, m, o

private class d
    implements Runnable
{

    final e a;
    private final m b;
    private final o c;
    private final Runnable d;

    public void run()
    {
        if (b.isCanceled())
        {
            b.finish("canceled-at-delivery");
        } else
        {
            if (c.a())
            {
                b.deliverResponse(c.a);
            } else
            {
                b.deliverError(c.c);
            }
            if (c.d)
            {
                b.addMarker("intermediate-response");
            } else
            {
                b.finish("done");
            }
            if (d != null)
            {
                d.run();
                return;
            }
        }
    }

    public nnable(e e1, m m1, o o1, Runnable runnable)
    {
        a = e1;
        super();
        b = m1;
        c = o1;
        d = runnable;
    }
}
