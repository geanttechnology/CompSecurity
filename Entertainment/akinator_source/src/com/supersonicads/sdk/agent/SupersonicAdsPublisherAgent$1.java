// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.agent;

import android.app.Activity;
import com.supersonicads.sdk.controller.SupersonicWebView;

// Referenced classes of package com.supersonicads.sdk.agent:
//            SupersonicAdsPublisherAgent

class val.debugMode
    implements Runnable
{

    final SupersonicAdsPublisherAgent this$0;
    final Activity val$activity;
    final int val$debugMode;

    public void run()
    {
        SupersonicAdsPublisherAgent.access$002(SupersonicAdsPublisherAgent.this, new SupersonicWebView(SupersonicAdsPublisherAgent.access$100()));
        SupersonicAdsPublisherAgent.access$000(SupersonicAdsPublisherAgent.this).registerConnectionReceiver(val$activity);
        SupersonicAdsPublisherAgent.access$000(SupersonicAdsPublisherAgent.this).setDebugMode(val$debugMode);
        SupersonicAdsPublisherAgent.access$000(SupersonicAdsPublisherAgent.this).downloadController();
    }

    ()
    {
        this$0 = final_supersonicadspublisheragent;
        val$activity = activity1;
        val$debugMode = I.this;
        super();
    }
}
