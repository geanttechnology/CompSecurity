// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.os.CountDownTimer;
import com.supersonicads.sdk.utils.Logger;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

class val.loadAttemp extends CountDownTimer
{

    final SupersonicWebView this$0;
    final int val$loadAttemp;

    public void onFinish()
    {
        Logger.i(SupersonicWebView.access$300(SupersonicWebView.this), "Loading Controller Timer Finish");
        if (val$loadAttemp == 2)
        {
            SupersonicWebView.access$1700(SupersonicWebView.this).cancel();
            if (SupersonicWebView.access$1900(SupersonicWebView.this))
            {
                SupersonicWebView.access$3600(SupersonicWebView.this, com.supersonicads.sdk.data..BrandConnect);
            }
            if (SupersonicWebView.access$2400(SupersonicWebView.this))
            {
                SupersonicWebView.access$3600(SupersonicWebView.this, com.supersonicads.sdk.data..Interstitial);
            }
            if (SupersonicWebView.access$2800(SupersonicWebView.this))
            {
                SupersonicWebView.access$3600(SupersonicWebView.this, com.supersonicads.sdk.data..OfferWall);
            }
            if (SupersonicWebView.access$3200(SupersonicWebView.this))
            {
                SupersonicWebView.access$3600(SupersonicWebView.this, com.supersonicads.sdk.data..OfferWallCredits);
            }
            return;
        } else
        {
            load(2);
            return;
        }
    }

    public void onTick(long l)
    {
        Logger.i(SupersonicWebView.access$300(SupersonicWebView.this), (new StringBuilder()).append("Loading Controller Timer Tick ").append(l).toString());
    }

    (long l1, int i)
    {
        this$0 = final_supersonicwebview;
        val$loadAttemp = i;
        super(J.this, l1);
    }
}
