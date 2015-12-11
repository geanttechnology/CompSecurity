// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.mbe.mediation;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

// Referenced classes of package com.sponsorpay.publisher.mbe.mediation:
//            SPBrandEngageMediationAdapter, SPTPNVideoValidationResult, SPTPNVideoEvent

class this._cls0 extends Handler
{

    final SPBrandEngageMediationAdapter this$0;

    public void handleMessage(Message message)
    {
        switch (message.what)
        {
        default:
            return;

        case 1: // '\001'
            sendValidationEvent(SPTPNVideoValidationResult.SPTPNValidationTimeout);
            return;

        case 2: // '\002'
            sendVideoEvent(SPTPNVideoEvent.SPTPNVideoEventTimeout);
            break;
        }
    }

    (Looper looper)
    {
        this$0 = SPBrandEngageMediationAdapter.this;
        super(looper);
    }
}
