// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.delivery;

import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.insights.delivery:
//            DefaultDeliveryClient

class val.submitWaitLatch
    implements Runnable
{

    final DefaultDeliveryClient this$0;
    final CountDownLatch val$submitWaitLatch;

    public void run()
    {
        val$submitWaitLatch.countDown();
    }

    ()
    {
        this$0 = final_defaultdeliveryclient;
        val$submitWaitLatch = CountDownLatch.this;
        super();
    }
}
