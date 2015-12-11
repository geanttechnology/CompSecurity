// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe;

import com.sponsorpay.SponsorPay;
import com.sponsorpay.credentials.SPCredentials;
import com.sponsorpay.publisher.SponsorPayPublisher;
import com.sponsorpay.utils.SponsorPayLogger;

// Referenced classes of package com.sponsorpay.publisher.mbe:
//            SPBrandEngageClient

class this._cls0
    implements Runnable
{

    final SPBrandEngageClient this$0;

    public void run()
    {
        if (SPBrandEngageClient.access$11(SPBrandEngageClient.this) != null)
        {
            try
            {
                SponsorPayPublisher.requestNewCoins(SponsorPay.getCurrentCredentials().getCredentialsToken(), SPBrandEngageClient.access$12(SPBrandEngageClient.this), SPBrandEngageClient.access$11(SPBrandEngageClient.this), null, null, SPBrandEngageClient.access$13(SPBrandEngageClient.this));
                return;
            }
            catch (RuntimeException runtimeexception)
            {
                SponsorPayLogger.e("SPBrandEngageClient", "Error in VCS request", runtimeexception);
            }
            return;
        } else
        {
            SponsorPayLogger.d("SPBrandEngageClient", "There's no VCS listener");
            return;
        }
    }

    ()
    {
        this$0 = SPBrandEngageClient.this;
        super();
    }
}
