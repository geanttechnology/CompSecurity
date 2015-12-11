// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import com.supersonicads.sdk.listeners.OnInterstitialListener;
import com.supersonicads.sdk.listeners.OnOfferWallListener;
import com.supersonicads.sdk.listeners.OnRewardedVideoListener;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

class val.product
    implements Runnable
{

    final s._cls0 this$1;
    final String val$product;

    public void run()
    {
        if (val$product.equalsIgnoreCase(com.supersonicads.sdk.data..()))
        {
            SupersonicWebView.access$2300(_fld0).onRVAdClosed();
        } else
        {
            if (val$product.equalsIgnoreCase(com.supersonicads.sdk.data..()))
            {
                SupersonicWebView.access$2700(_fld0).onInterstitialAdClosed();
                return;
            }
            if (val$product.equalsIgnoreCase(com.supersonicads.sdk.data.ce._cls14.val.product.product()))
            {
                SupersonicWebView.access$3100(_fld0).onOWAdClosed();
                return;
            }
        }
    }

    ()
    {
        this$1 = final_;
        val$product = String.this;
        super();
    }
}
