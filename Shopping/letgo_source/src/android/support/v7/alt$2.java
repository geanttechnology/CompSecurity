// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package android.support.v7:
//            alw, alt

class b
    implements alw
{

    final CountDownLatch a;
    final int b;
    final alt c;

    public void a(Exception exception)
    {
        alt.b(c).a(exception);
    }

    public void a(Object obj)
    {
        a.countDown();
        if (a.getCount() == 0L)
        {
            alt.a(c).set(true);
            alt.b(c).a(c);
        }
    }

    tDownLatch(alt alt1, int i)
    {
        c = alt1;
        b = i;
        super();
        a = new CountDownLatch(b);
    }
}
