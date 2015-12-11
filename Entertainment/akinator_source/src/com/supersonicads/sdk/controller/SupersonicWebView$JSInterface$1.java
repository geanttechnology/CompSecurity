// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.util.Log;
import com.supersonicads.sdk.data.AdUnitsReady;
import com.supersonicads.sdk.data.AdUnitsState;
import com.supersonicads.sdk.listeners.OnRewardedVideoListener;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

class val.product
    implements Runnable
{

    final eOffers this$1;
    final AdUnitsReady val$adUnitsReady;
    final String val$product;

    public void run()
    {
label0:
        {
            boolean flag;
            if (Integer.parseInt(val$adUnitsReady.getNumOfAdUnits()) > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (val$product.equalsIgnoreCase(com.supersonicads.sdk.data.t.t()))
            {
                SupersonicWebView.access$3500(_fld0).setRewardedVideoInitSuccess(true);
                if (!flag)
                {
                    break label0;
                }
                Log.d(SupersonicWebView.access$300(_fld0), "onRVInitSuccess()");
                SupersonicWebView.access$2300(_fld0).onRVInitSuccess(val$adUnitsReady);
            }
            return;
        }
        SupersonicWebView.access$2300(_fld0).onRVNoMoreOffers();
    }

    ()
    {
        this$1 = final_;
        val$adUnitsReady = adunitsready;
        val$product = String.this;
        super();
    }
}
