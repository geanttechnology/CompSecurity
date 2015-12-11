// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.util.Log;
import com.supersonicads.sdk.data.AdUnitsState;
import com.supersonicads.sdk.listeners.OnInterstitialListener;
import com.supersonicads.sdk.listeners.OnOfferWallListener;
import com.supersonicads.sdk.listeners.OnRewardedVideoListener;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

class val.message
    implements Runnable
{

    final SupersonicWebView this$0;
    final String val$message;
    final com.supersonicads.sdk.data. val$type;

    public void run()
    {
        if (com.supersonicads.sdk.data..BrandConnect != val$type) goto _L2; else goto _L1
_L1:
        SupersonicWebView.access$3500(SupersonicWebView.this).setRewardedVideoInitSuccess(false);
        Log.d(SupersonicWebView.access$300(SupersonicWebView.this), (new StringBuilder()).append("onRVInitFail(message:").append(val$message).append(")").toString());
        SupersonicWebView.access$2300(SupersonicWebView.this).onRVInitFail(val$message);
_L4:
        return;
_L2:
        if (com.supersonicads.sdk.data..Interstitial != val$type)
        {
            break; /* Loop/switch isn't completed */
        }
        SupersonicWebView.access$3500(SupersonicWebView.this).setInterstitialInitSuccess(false);
        if (SupersonicWebView.access$3500(SupersonicWebView.this).reportInitInterstitial())
        {
            Log.d(SupersonicWebView.access$300(SupersonicWebView.this), (new StringBuilder()).append("onInterstitialInitFail(message:").append(val$message).append(")").toString());
            SupersonicWebView.access$2700(SupersonicWebView.this).onInterstitialInitFail(val$message);
            SupersonicWebView.access$3500(SupersonicWebView.this).setReportInitInterstitial(false);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
        if (com.supersonicads.sdk.data..OfferWall == val$type)
        {
            SupersonicWebView.access$3100(SupersonicWebView.this).onOWShowFail(val$message);
            return;
        }
        if (com.supersonicads.sdk.data..OfferWallCredits == val$type)
        {
            SupersonicWebView.access$3100(SupersonicWebView.this).onGetOWCreditsFailed(val$message);
            return;
        }
        if (true) goto _L4; else goto _L5
_L5:
    }

    r()
    {
        this$0 = final_supersonicwebview;
        val$type = ;
        val$message = String.this;
        super();
    }
}
