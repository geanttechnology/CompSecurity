// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.models.GenericAmount;

// Referenced classes of package com.groupon.activity:
//            MarketRateReservation, IntentFactory

class val.gBucksDisclaimer
    implements android.view.ation._cls4
{

    final MarketRateReservation this$0;
    final GenericAmount val$gBucksAmount;
    final String val$gBucksDisclaimer;

    public void onClick(View view)
    {
        startActivity(MarketRateReservation.access$200(MarketRateReservation.this).newMarketRateGBucksIntent(val$gBucksAmount, val$gBucksDisclaimer));
    }

    ()
    {
        this$0 = final_marketratereservation;
        val$gBucksAmount = genericamount;
        val$gBucksDisclaimer = String.this;
        super();
    }
}
