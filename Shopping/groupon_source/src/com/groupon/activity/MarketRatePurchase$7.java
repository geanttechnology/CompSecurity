// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.models.GenericAmount;
import com.groupon.tracking.mobile.sdk.Logger;

// Referenced classes of package com.groupon.activity:
//            MarketRatePurchase, IntentFactory

class val.gBucksAmountValue
    implements android.view.chase._cls7
{

    final MarketRatePurchase this$0;
    final GenericAmount val$gBucksAmount;
    final int val$gBucksAmountValue;

    public void onClick(View view)
    {
        startActivity(MarketRatePurchase.access$900(MarketRatePurchase.this).newMarketRateGBucksIntent(val$gBucksAmount, gBucksDisclaimer));
        logger.logClick("", "groupon_bucks_back_click", "market_rate", (new StringBuilder()).append(hotelId).append(",").append(val$gBucksAmountValue).toString());
    }

    ()
    {
        this$0 = final_marketratepurchase;
        val$gBucksAmount = genericamount;
        val$gBucksAmountValue = I.this;
        super();
    }
}
