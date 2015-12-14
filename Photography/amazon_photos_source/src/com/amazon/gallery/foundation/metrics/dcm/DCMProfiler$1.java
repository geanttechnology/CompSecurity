// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.foundation.metrics.dcm;

import android.os.AsyncTask;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;

// Referenced classes of package com.amazon.gallery.foundation.metrics.dcm:
//            DCMProfiler

class this._cls0 extends AsyncTask
{

    final DCMProfiler this$0;

    protected transient MetricEvent doInBackground(Void avoid[])
    {
        return DCMProfiler.access$000(DCMProfiler.this).createMetricEvent("Photos", "Workaround");
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    ()
    {
        this$0 = DCMProfiler.this;
        super();
    }
}
