// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;


// Referenced classes of package com.groupon.db.models:
//            Deal, Option, PricingMetadata, ShippingOption

public class Price
{

    public int amount;
    public String currencyCode;
    public String formattedAmount;
    public Deal parentDeal;
    public Option parentOption;
    public PricingMetadata parentPricingMetadata;
    public ShippingOption parentShippingOption;
    public Long primaryKey;

    public Price()
    {
        amount = 0;
        currencyCode = "";
        formattedAmount = "";
    }
}
