// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

class bsq
    implements bsu
{

    final CountDownLatch a;
    final int b;
    final bso c;

    bsq(bso bso1, int i)
    {
        c = bso1;
        b = i;
        super();
        a = new CountDownLatch(b);
    }

    public void a(Exception exception)
    {
        bso.b(c).a(exception);
    }

    public void a(Object obj)
    {
        a.countDown();
        if (a.getCount() == 0L)
        {
            bso.a(c).set(true);
            bso.b(c).a(c);
        }
    }
}
