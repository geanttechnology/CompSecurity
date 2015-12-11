// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.mash.api;

import android.view.View;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.mShop.AmazonAlertDialog;
import com.amazon.mShop.aiv.AmazonInstantVideoProxy;
import com.amazon.mShop.util.ActivityUtils;

// Referenced classes of package com.amazon.mShop.mash.api:
//            MASHAivPlugin

class val.dialog
    implements android.view.geRunnable._cls1
{

    final ctivity this$0;
    final MetricEvent val$clickMetrics;
    final AmazonAlertDialog val$dialog;

    public void onClick(View view)
    {
        val$clickMetrics.addCounter("Counter", 1.0D);
        cess._mth600(this._cls0.this).record(val$clickMetrics);
        val$dialog.dismiss();
        if (AmazonInstantVideoProxy.getInstance().isAIVBeta())
        {
            view = "B00N2886IU";
        } else
        {
            view = "B00N28818A";
        }
        ActivityUtils.startAppstoreActivityWithAsin(ctivity, view, null, null, null);
    }

    ()
    {
        this$0 = final_;
        val$clickMetrics = metricevent;
        val$dialog = AmazonAlertDialog.this;
        super();
    }
}
