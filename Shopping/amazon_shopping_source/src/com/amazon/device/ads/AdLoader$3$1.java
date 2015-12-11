// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.amazon.device.ads:
//            AdError, AdLoader, StartUpWaiter, InternalAdRegistration, 
//            IInternalAdRegistration, AdSlot, AdTargetingOptions

class this._cls0
    implements Runnable
{

    final l.adSlots this$0;

    public void run()
    {
        AdLoader.access$200(new AdError(Code.NETWORK_ERROR, "The configuration was unable to be loaded"), adSlots);
    }

    ()
    {
        this$0 = this._cls0.this;
        super();
    }

    // Unreferenced inner class com/amazon/device/ads/AdLoader$3

/* anonymous class */
    static final class AdLoader._cls3 extends StartUpWaiter
    {

        final AdSlot val$adSlots[];
        final AdTargetingOptions val$requestOptions;
        final int val$timeout;

        protected void startUpFailed()
        {
            (new Handler(Looper.getMainLooper())).post(new AdLoader._cls3._cls1());
        }

        protected void startUpReady()
        {
            InternalAdRegistration.getInstance().register();
            AdLoader.access$100(timeout, requestOptions, adSlots);
        }

            
            {
                timeout = i;
                requestOptions = adtargetingoptions;
                adSlots = aadslot;
                super();
            }
    }

}
