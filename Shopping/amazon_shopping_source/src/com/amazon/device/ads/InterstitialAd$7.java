// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;


// Referenced classes of package com.amazon.device.ads:
//            InterstitialAd

class this._cls0
    implements Runnable
{

    final InterstitialAd this$0;

    public void run()
    {
        callOnAdDismissed();
        submitAndResetMetrics();
    }

    ()
    {
        this$0 = InterstitialAd.this;
        super();
    }
}
