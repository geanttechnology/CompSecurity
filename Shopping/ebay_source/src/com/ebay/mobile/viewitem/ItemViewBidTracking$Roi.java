// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.viewitem;

import com.ebay.mobile.dcs.DcsBoolean;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

// Referenced classes of package com.ebay.mobile.viewitem:
//            ItemViewBidTracking

public static class totalCostWithShipping
{

    public final String iafToken;
    public String roiUrl;
    public final ItemCurrency totalCostWithShipping;
    public final boolean usePlaceOfferRoi;

    public (String s, ItemCurrency itemcurrency)
    {
        roiUrl = null;
        usePlaceOfferRoi = DeviceConfiguration.getAsync().get(DcsBoolean.PlaceOfferRoi);
        iafToken = s;
        totalCostWithShipping = itemcurrency;
    }
}
