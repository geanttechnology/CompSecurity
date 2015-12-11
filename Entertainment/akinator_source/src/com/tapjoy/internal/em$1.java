// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.util.Log;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.tapjoy.internal:
//            em, ev

final class tDownLatch extends tDownLatch
{

    final em a;

    public final void run()
    {
        em.e();
        em.a(b, new ev(em.a(a), em.b(a), em.c(a)));
        try
        {
            em.d(b).d();
        }
        catch (InterruptedException interruptedexception)
        {
            Log.e(em.e(), "Interrupted initing js engine");
        }
        em.e();
        if (c != null)
        {
            em.e();
            (new StringBuilder("js exec init countdown using latch: ")).append(c.hashCode()).append(" with count: ").append(c.getCount());
            c.countDown();
        }
    }

    tDownLatch(em em1, em em2, CountDownLatch countdownlatch)
    {
        a = em1;
        super(em2, countdownlatch);
    }
}
