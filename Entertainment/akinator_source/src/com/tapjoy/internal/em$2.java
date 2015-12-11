// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.tapjoy.internal:
//            em

final class tDownLatch extends tDownLatch
{

    final em a;

    public final void run()
    {
        try
        {
            em.e();
            em.e(b);
        }
        catch (InterruptedException interruptedexception)
        {
            em.e();
        }
        if (c != null)
        {
            em.e();
            (new StringBuilder("getBrowserInfo countdown using latch: ")).append(c.hashCode()).append(" with count: ").append(c.getCount());
            c.countDown();
        }
    }

    tDownLatch(em em1, em em2, CountDownLatch countdownlatch)
    {
        a = em1;
        super(em2, countdownlatch);
    }
}
