// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.amazon.client.metrics:
//            PeriodicMetricReporterImpl

class this._cls0
    implements ThreadFactory
{

    final PeriodicMetricReporterImpl this$0;

    public Thread newThread(Runnable runnable)
    {
        return new Thread(runnable, "PeriodicMetricReporterThread");
    }

    ()
    {
        this$0 = PeriodicMetricReporterImpl.this;
        super();
    }
}
