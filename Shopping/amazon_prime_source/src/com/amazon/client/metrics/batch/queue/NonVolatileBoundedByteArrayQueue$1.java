// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.metrics.batch.queue;

import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.PeriodicMetricReporter;
import com.amazon.dp.logger.DPLogger;
import java.io.File;
import java.util.Comparator;

// Referenced classes of package com.amazon.client.metrics.batch.queue:
//            NonVolatileBoundedByteArrayQueue

class this._cls0
    implements Comparator
{

    final NonVolatileBoundedByteArrayQueue this$0;

    public int compare(File file, File file1)
    {
        Long long1 = new Long(0L);
        Long long2 = Long.valueOf(file.getName());
        file = long2;
_L1:
        long1 = new Long(0L);
        long2 = Long.valueOf(file1.getName());
        file1 = long2;
_L2:
        return file.compareTo(file1);
        NumberFormatException numberformatexception;
        numberformatexception;
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("queueRead.NumberFormatException", 1.0D);
        NonVolatileBoundedByteArrayQueue.access$000().error("readPersistedData", (new StringBuilder()).append("Unsupported file name format: ").append(file.getName()).toString(), new Object[0]);
        file = long1;
          goto _L1
        numberformatexception;
        mPeriodicMetricReporter.getMetricEvent().incrementCounter("queueRead.NumberFormatException", 1.0D);
        NonVolatileBoundedByteArrayQueue.access$000().error("readPersistedData", (new StringBuilder()).append("Unsupported file name format: ").append(file1.getName()).toString(), new Object[0]);
        file1 = long1;
          goto _L2
    }

    public volatile int compare(Object obj, Object obj1)
    {
        return compare((File)obj, (File)obj1);
    }

    ()
    {
        this$0 = NonVolatileBoundedByteArrayQueue.this;
        super();
    }
}
