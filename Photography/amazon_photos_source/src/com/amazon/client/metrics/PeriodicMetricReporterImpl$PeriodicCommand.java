// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.client.metrics:
//            PeriodicMetricReporterImpl

protected final class this._cls0
    implements Runnable
{

    private final AtomicBoolean mIsActive = new AtomicBoolean(true);
    final PeriodicMetricReporterImpl this$0;

    public void run()
    {
        if (!mIsActive.get())
        {
            break MISSING_BLOCK_LABEL_17;
        }
        PeriodicMetricReporterImpl.access$000(PeriodicMetricReporterImpl.this);
        return;
        Throwable throwable;
        throwable;
    }

    public ()
    {
        this$0 = PeriodicMetricReporterImpl.this;
        super();
    }
}
