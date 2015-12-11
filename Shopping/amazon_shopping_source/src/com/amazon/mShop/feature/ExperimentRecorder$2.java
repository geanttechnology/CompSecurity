// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.feature;

import android.util.Log;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.Null;
import com.amazon.rio.j2me.client.services.mShop.PostMetricsResponseListener;

// Referenced classes of package com.amazon.mShop.feature:
//            ExperimentRecorder

class this._cls0
    implements PostMetricsResponseListener
{

    final ExperimentRecorder this$0;

    public void cancelled(ServiceCall servicecall)
    {
        if (ExperimentRecorder.access$900())
        {
            Log.d(ExperimentRecorder.access$600(), "Post metrics cancelled");
        }
    }

    public void completed(Null null1, ServiceCall servicecall)
    {
        if (ExperimentRecorder.access$900())
        {
            Log.d(ExperimentRecorder.access$600(), "Finished posting metrics");
        }
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
        Log.e(ExperimentRecorder.access$600(), "Failed to post metrics", exception);
    }

    l()
    {
        this$0 = ExperimentRecorder.this;
        super();
    }
}
