// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import com.ebay.nautilus.domain.data.ItemCurrency;
import java.util.Date;

// Referenced classes of package com.ebay.common.model:
//            EbayDeals

public static class energyRating
{

    public ItemCurrency convertedCurrentPrice;
    public Date endDate;
    public String energyRating;
    public long id;
    public String imageUrl;
    public ItemCurrency origRetailPrice;
    public int savingsRate;
    public ItemCurrency shippingCost;
    public String title;

    public rency()
    {
        id = 0L;
        imageUrl = null;
        title = null;
        convertedCurrentPrice = null;
        origRetailPrice = null;
        endDate = null;
        shippingCost = null;
        savingsRate = 0;
        energyRating = null;
    }
}
