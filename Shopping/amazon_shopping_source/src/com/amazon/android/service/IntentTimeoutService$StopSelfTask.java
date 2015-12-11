// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.android.service;

import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.android.service:
//            IntentTimeoutService

final class startId extends TimerTask
{

    private final int startId;
    final IntentTimeoutService this$0;

    public void doStopSelf()
    {
        if (IntentTimeoutService.access$300(IntentTimeoutService.this).get() == startId)
        {
            onTimeout();
        }
        stopSelf(startId);
    }

    public void run()
    {
        synchronized (IntentTimeoutService.access$100(IntentTimeoutService.this))
        {
            IntentTimeoutService.access$402(IntentTimeoutService.this, null);
        }
        doStopSelf();
        return;
        exception;
        timer;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public (int i)
    {
        this$0 = IntentTimeoutService.this;
        super();
        startId = i;
    }
}
