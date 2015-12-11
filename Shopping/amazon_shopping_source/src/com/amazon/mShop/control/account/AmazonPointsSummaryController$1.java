// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.account;

import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.PointsSummaryResponse;

// Referenced classes of package com.amazon.mShop.control.account:
//            AmazonPointsSummaryController, AmazonPointsSummarySubscriber

class val.value
    implements Runnable
{

    final AmazonPointsSummaryController this$0;
    final ServiceCall val$sc;
    final PointsSummaryResponse val$value;

    public void run()
    {
        if (AmazonPointsSummaryController.access$000(AmazonPointsSummaryController.this, val$sc))
        {
            AmazonPointsSummaryController.access$100(AmazonPointsSummaryController.this);
            if (val$value != null)
            {
                AmazonPointsSummaryController.access$200(AmazonPointsSummaryController.this).onReceiveAmazonPointsSummary(val$value.getSummaryRows());
            }
        }
    }

    ()
    {
        this$0 = final_amazonpointssummarycontroller;
        val$sc = servicecall;
        val$value = PointsSummaryResponse.this;
        super();
    }
}
