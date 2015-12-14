// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics.customer;

import android.os.AsyncTask;
import com.amazon.gallery.foundation.utils.log.GLogger;
import java.util.List;

// Referenced classes of package com.amazon.gallery.foundation.metrics.customer:
//            CustomerMetricsProfiler, MetricsPublisher, CustomerMetricsInfo

class val.metrics extends AsyncTask
{

    final CustomerMetricsProfiler this$0;
    final List val$metrics;

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected transient Void doInBackground(Void avoid[])
    {
        if (!CustomerMetricsProfiler.access$000(CustomerMetricsProfiler.this).send(val$metrics))
        {
            GLogger.d(CustomerMetricsProfiler.access$100(), "Failed to publish metrics, will save for later.", new Object[0]);
        }
        CustomerMetricsProfiler.access$200(CustomerMetricsProfiler.this).reset();
        return null;
    }

    ()
    {
        this$0 = final_customermetricsprofiler;
        val$metrics = List.this;
        super();
    }
}
