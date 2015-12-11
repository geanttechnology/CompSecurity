// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.mShop.net:
//            MetricsAggregator, MetricsSender

public class MetricsCollector
{

    private static final Thread sCollectingThread;
    private static final LinkedBlockingQueue sCompletedEventsQueue = new LinkedBlockingQueue(500);

    public MetricsCollector()
    {
    }

    private static void collect(Collection collection)
    {
        MetricsSender.postAllMetrics(MetricsAggregator.aggregate(collection));
    }

    public static void queueEvent(MetricsAggregator.MetricEvent metricevent)
    {
        sCompletedEventsQueue.offer(metricevent);
    }

    static 
    {
        sCollectingThread = new Thread(new Runnable() {

            public void run()
            {
_L3:
                ArrayList arraylist = new ArrayList();
                long l1;
                l1 = SystemClock.elapsedRealtime();
                arraylist.add((MetricsAggregator.MetricEvent)MetricsCollector.sCompletedEventsQueue.take());
_L6:
                long l2 = SystemClock.elapsedRealtime();
                if (l2 - l1 <= 0x1d4c0L) goto _L2; else goto _L1
_L1:
                MetricsCollector.sCompletedEventsQueue.drainTo(arraylist);
                MetricsCollector.collect(arraylist);
                  goto _L3
_L2:
                long l = 0x1d4c0L;
                if (arraylist.size() < 30)
                {
                    break MISSING_BLOCK_LABEL_98;
                }
                if (l2 > l1 + 60000L) goto _L1; else goto _L4
_L4:
                l = (l1 + 60000L) - l2;
                MetricsAggregator.MetricEvent metricevent = (MetricsAggregator.MetricEvent)MetricsCollector.sCompletedEventsQueue.poll(l, TimeUnit.MILLISECONDS);
                if (metricevent == null) goto _L1; else goto _L5
_L5:
                arraylist.add(metricevent);
                  goto _L6
                InterruptedException interruptedexception;
                interruptedexception;
                Log.e("Amazon", interruptedexception.toString());
                  goto _L1
            }

        });
        sCollectingThread.start();
    }


}
