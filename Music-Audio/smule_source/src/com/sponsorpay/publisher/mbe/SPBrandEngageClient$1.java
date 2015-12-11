// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import com.sponsorpay.publisher.SponsorPayPublisher;
import com.sponsorpay.utils.SponsorPayLogger;

// Referenced classes of package com.sponsorpay.publisher.mbe:
//            SPBrandEngageClient, SPBrandEngageOffersStatus

class this._cls0 extends BroadcastReceiver
{

    final SPBrandEngageClient this$0;

    public void onReceive(Context context, Intent intent)
    {
        boolean flag = false;
        if (!intent.getBooleanExtra("noConnectivity", false))
        {
            flag = true;
        }
        if (!flag && SPBrandEngageClient.access$0(SPBrandEngageClient.this) == SPBrandEngageOffersStatus.SHOWING_OFFERS)
        {
            SponsorPayLogger.e("SPBrandEngageClient", "Connection has been lost");
            SPBrandEngageClient.access$1(SPBrandEngageClient.this).post(new Runnable() {

                final SPBrandEngageClient._cls1 this$1;

                public void run()
                {
                    SPBrandEngageClient.access$2(this$0, SponsorPayPublisher.getUIString(com.sponsorpay.publisher.SponsorPayPublisher.UIStringIdentifier.MBE_ERROR_DIALOG_MESSAGE_OFFLINE));
                }

            
            {
                this$1 = SPBrandEngageClient._cls1.this;
                super();
            }
            });
        }
    }


    _cls1.this._cls1()
    {
        this$0 = SPBrandEngageClient.this;
        super();
    }
}
