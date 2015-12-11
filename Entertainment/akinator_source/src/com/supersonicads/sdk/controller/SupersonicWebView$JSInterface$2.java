// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonicads.sdk.controller;

import android.text.TextUtils;
import com.supersonicads.sdk.listeners.OnOfferWallListener;
import com.supersonicads.sdk.listeners.OnRewardedVideoListener;
import com.supersonicads.sdk.utils.SupersonicSharedPrefHelper;

// Referenced classes of package com.supersonicads.sdk.controller:
//            SupersonicWebView

class val.value
    implements Runnable
{

    final val.value this$1;
    final String val$appKey;
    final int val$credits;
    final boolean val$mMd5Signature;
    final boolean val$mTotalCreditsFlag;
    final String val$mlatestCompeltionsTime;
    final String val$product;
    final int val$totalCredits;
    final String val$userId;
    final String val$value;

    public void run()
    {
        if (val$product.equalsIgnoreCase(com.supersonicads.sdk.data.t.t()))
        {
            SupersonicWebView.access$2300(_fld0).onRVAdCredited(val$credits);
        } else
        if (val$product.equalsIgnoreCase(com.supersonicads.sdk.data.ace._cls2.val.product.product()) && val$mMd5Signature && SupersonicWebView.access$3100(_fld0).onOWAdCredited(val$credits, val$totalCredits, val$mTotalCreditsFlag) && !TextUtils.isEmpty(val$mlatestCompeltionsTime))
        {
            if (SupersonicSharedPrefHelper.getSupersonicPrefHelper().setLatestCompeltionsTime(val$mlatestCompeltionsTime, val$appKey, val$userId))
            {
                SupersonicWebView.access$4300(_fld0, val$value, true, null, null);
                return;
            } else
            {
                SupersonicWebView.access$4300(_fld0, val$value, false, "Time Stamp could not be stored", null);
                return;
            }
        }
    }

    ()
    {
        this$1 = final_;
        val$product = s;
        val$credits = i;
        val$mMd5Signature = flag;
        val$totalCredits = j;
        val$mTotalCreditsFlag = flag1;
        val$mlatestCompeltionsTime = s1;
        val$appKey = s2;
        val$userId = s3;
        val$value = String.this;
        super();
    }
}
