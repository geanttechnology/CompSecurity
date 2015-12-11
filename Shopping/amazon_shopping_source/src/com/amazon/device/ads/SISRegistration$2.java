// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.device.ads:
//            SISRegistration, Log

class val.latch
    implements igurationListener
{

    final SISRegistration this$0;
    final AtomicBoolean val$canRegister;
    final CountDownLatch val$latch;

    public void onConfigurationFailure()
    {
        Log.w(SISRegistration.access$000(), "Configuration fetching failed so device registration will not proceed.");
        val$latch.countDown();
    }

    public void onConfigurationReady()
    {
        val$canRegister.set(true);
        val$latch.countDown();
    }

    n()
    {
        this$0 = final_sisregistration;
        val$canRegister = atomicboolean;
        val$latch = CountDownLatch.this;
        super();
    }
}
