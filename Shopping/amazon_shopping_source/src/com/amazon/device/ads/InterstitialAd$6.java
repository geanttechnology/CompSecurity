// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            InterstitialAd, AdError

class val.error
    implements Runnable
{

    final InterstitialAd this$0;
    final AdError val$error;

    public void run()
    {
        callOnAdFailedToLoad(val$error);
        submitAndResetMetrics();
    }

    ()
    {
        this$0 = final_interstitialad;
        val$error = AdError.this;
        super();
    }
}
