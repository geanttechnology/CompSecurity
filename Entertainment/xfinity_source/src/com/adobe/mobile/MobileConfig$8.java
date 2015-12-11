// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

// Referenced classes of package com.adobe.mobile:
//            MobileConfig, StaticMethods, AnalyticsWorker

class r extends BroadcastReceiver
{

    final MobileConfig this$0;

    public void onReceive(Context context, Intent intent)
    {
        MobileConfig.access$402(MobileConfig.this, getNetworkConnectivity(context));
        if (MobileConfig.access$400(MobileConfig.this))
        {
            StaticMethods.logDebugFormat("Analytics - Network status changed (reachable)", new Object[0]);
            AnalyticsWorker.sharedInstance().kick(false);
            return;
        } else
        {
            StaticMethods.logDebugFormat("Analytics - Network status changed (unreachable)", new Object[0]);
            return;
        }
    }

    ()
    {
        this$0 = MobileConfig.this;
        super();
    }
}
