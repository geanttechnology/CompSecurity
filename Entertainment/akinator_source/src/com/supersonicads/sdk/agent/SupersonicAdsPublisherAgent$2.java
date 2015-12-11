// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.agent;

import com.supersonicads.sdk.controller.SupersonicWebView;

// Referenced classes of package com.supersonicads.sdk.agent:
//            SupersonicAdsPublisherAgent

class this._cls0
    implements Runnable
{

    final SupersonicAdsPublisherAgent this$0;

    public void run()
    {
        SupersonicAdsPublisherAgent.access$000(SupersonicAdsPublisherAgent.this).destroy();
        SupersonicAdsPublisherAgent.access$002(SupersonicAdsPublisherAgent.this, null);
    }

    ()
    {
        this$0 = SupersonicAdsPublisherAgent.this;
        super();
    }
}
