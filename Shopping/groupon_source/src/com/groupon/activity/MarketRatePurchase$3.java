// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.view.View;
import com.groupon.Channel;
import com.groupon.service.AttributionService;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.LoggingUtils;

// Referenced classes of package com.groupon.activity:
//            MarketRatePurchase

class this._cls0
    implements android.view.chase._cls3
{

    final MarketRatePurchase this$0;

    public void onClick(View view)
    {
        logger.logClick("", "confirm_purchase_click", "market_rate", hotelId);
        if (MarketRatePurchase.access$000(MarketRatePurchase.this) == null)
        {
            MarketRatePurchase.access$100(MarketRatePurchase.this);
            return;
        } else
        {
            logger.logDealPurchaseInitiation("", channel.name(), hotelId, 1, MarketRatePurchase.access$200(MarketRatePurchase.this), "", MarketRatePurchase.access$300(MarketRatePurchase.this), MarketRatePurchase.access$400(MarketRatePurchase.this).getAttributionCid(), MarketRatePurchase.access$400(MarketRatePurchase.this).getAttributionId(), MarketRatePurchase.access$400(MarketRatePurchase.this).getAttributionType(), MarketRatePurchase.access$400(MarketRatePurchase.this).getDeepLinkTimeOverlap(Long.valueOf(System.currentTimeMillis())).longValue(), MarketRatePurchase.access$400(MarketRatePurchase.this).getAttributionDownloadId(), MarketRatePurchase.access$400(MarketRatePurchase.this).getAttributionDownloadCid(), "", "", "", MarketRatePurchase.access$600(MarketRatePurchase.this).getMarketRateExtraInfoString(productType, MarketRatePurchase.access$500(MarketRatePurchase.this)));
            MarketRatePurchase.access$700(MarketRatePurchase.this);
            return;
        }
    }

    ()
    {
        this$0 = MarketRatePurchase.this;
        super();
    }
}
