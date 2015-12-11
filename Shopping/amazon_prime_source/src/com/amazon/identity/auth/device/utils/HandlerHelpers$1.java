// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            HandlerHelpers

static final class val.latch
    implements Runnable
{

    final CountDownLatch val$latch;
    final Runnable val$runnable;

    public void run()
    {
        val$runnable.run();
        val$latch.countDown();
        return;
        Exception exception;
        exception;
        val$latch.countDown();
        throw exception;
    }

    (Runnable runnable1, CountDownLatch countdownlatch)
    {
        val$runnable = runnable1;
        val$latch = countdownlatch;
        super();
    }
}
