// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;

import android.util.Log;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.Null;
import com.amazon.rio.j2me.client.services.mShop.PostMetricsResponseListener;

// Referenced classes of package com.amazon.mShop.net:
//            MShopAggregatedClientMetrics

static final class sResponseListener
    implements PostMetricsResponseListener
{

    public void cancelled(ServiceCall servicecall)
    {
        if (MShopAggregatedClientMetrics.access$000())
        {
            Log.v("Amazon", "post metrics cancelled");
        }
    }

    public void completed(Null null1, ServiceCall servicecall)
    {
        if (MShopAggregatedClientMetrics.access$000())
        {
            Log.v("Amazon", "post metrics completed");
        }
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
        if (MShopAggregatedClientMetrics.access$000())
        {
            Log.d("Amazon", (new StringBuilder()).append("post metrics failed: ").append(exception).toString());
        }
    }

    sResponseListener()
    {
    }
}
