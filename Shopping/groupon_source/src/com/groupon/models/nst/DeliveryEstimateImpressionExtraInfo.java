// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.nst;

import com.groupon.db.models.Deal;

// Referenced classes of package com.groupon.models.nst:
//            JsonEncodedNSTField

public class DeliveryEstimateImpressionExtraInfo extends JsonEncodedNSTField
{

    private String dealId;
    private String dealType;

    public DeliveryEstimateImpressionExtraInfo(Deal deal)
    {
        addDealInfo(deal);
    }

    public void addDealInfo(Deal deal)
    {
        dealId = deal.remoteId;
        dealType = deal.fulfillmentMethod;
    }
}
