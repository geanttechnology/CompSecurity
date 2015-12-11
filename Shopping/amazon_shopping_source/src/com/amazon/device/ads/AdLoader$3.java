// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.amazon.device.ads:
//            StartUpWaiter, AdLoader, InternalAdRegistration, IInternalAdRegistration, 
//            AdSlot, AdTargetingOptions, AdError

static final class er extends StartUpWaiter
{

    final AdSlot val$adSlots[];
    final AdTargetingOptions val$requestOptions;
    final int val$timeout;

    protected void startUpFailed()
    {
        (new Handler(Looper.getMainLooper())).post(new Runnable() {

            final AdLoader._cls3 this$0;

            public void run()
            {
                AdLoader.access$200(new AdError(AdError.ErrorCode.NETWORK_ERROR, "The configuration was unable to be loaded"), adSlots);
            }

            
            {
                this$0 = AdLoader._cls3.this;
                super();
            }
        });
    }

    protected void startUpReady()
    {
        InternalAdRegistration.getInstance().register();
        AdLoader.access$100(val$timeout, val$requestOptions, val$adSlots);
    }

    Options(int i, AdTargetingOptions adtargetingoptions, AdSlot aadslot[])
    {
        val$timeout = i;
        val$requestOptions = adtargetingoptions;
        val$adSlots = aadslot;
        super();
    }
}
