// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe;

import android.os.Handler;
import android.os.Message;
import com.sponsorpay.publisher.SponsorPayPublisher;
import com.sponsorpay.utils.SponsorPayLogger;

// Referenced classes of package com.sponsorpay.publisher.mbe:
//            SPBrandEngageClient

class this._cls0 extends Handler
{

    final SPBrandEngageClient this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 2: // '\002'
            SponsorPayLogger.d("SPBrandEngageClient", "Timeout reached, canceling request...");
            SPBrandEngageClient.access$3(SPBrandEngageClient.this, 0);
            return;

        case 1: // '\001'
            SPBrandEngageClient.access$2(SPBrandEngageClient.this, SponsorPayPublisher.getUIString(com.sponsorpay.publisher.StringIdentifier.MBE_ERROR_DIALOG_MESSAGE_DEFAULT));
            return;
        }
    }

    ngIdentifier()
    {
        this$0 = SPBrandEngageClient.this;
        super();
    }
}
