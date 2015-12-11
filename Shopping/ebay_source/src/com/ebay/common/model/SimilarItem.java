// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model;

import com.ebay.nautilus.domain.data.ItemCurrency;

public class SimilarItem
{

    public int bidCount;
    public ItemCurrency buyItNowPrice;
    public String country;
    public ItemCurrency currentPrice;
    public String globalId;
    public String imageURL;
    public String itemId;
    public ItemCurrency originalPrice;
    public ItemCurrency originalRetailPrice;
    public String pricingTreatment;
    public String primaryCategoryId;
    public String primaryCategoryName;
    public ItemCurrency shippingCost;
    public String shippingType;
    public boolean soldOffEbay;
    public boolean soldOnEbay;
    public String subtitle;
    public long timeLeft;
    public String title;
    public String viewItemURL;

    public SimilarItem()
    {
    }

    public String toString()
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("bidCount: ").append(bidCount).append('\n');
        stringbuilder.append("buyItNowPrice: ").append(buyItNowPrice).append('\n');
        stringbuilder.append("country: ").append(country).append('\n');
        stringbuilder.append("currentPrice: ").append(currentPrice).append('\n');
        stringbuilder.append("originalRetailPrice: ").append(originalRetailPrice).append('\n');
        stringbuilder.append("pricingTreatment: ").append(pricingTreatment).append('\n');
        stringbuilder.append("soldOffEbay: ").append(soldOffEbay).append('\n');
        stringbuilder.append("soldOnEbay: ").append(soldOnEbay).append('\n');
        stringbuilder.append("globalId: ").append(globalId).append('\n');
        stringbuilder.append("imageURL: ").append(imageURL).append('\n');
        stringbuilder.append("itemId: ").append(itemId).append('\n');
        stringbuilder.append("originalPrice: ").append(originalPrice).append('\n');
        stringbuilder.append("primaryCategoryId: ").append(primaryCategoryId).append('\n');
        stringbuilder.append("primaryCategoryName: ").append(primaryCategoryName).append('\n');
        stringbuilder.append("shippingCost: ").append(shippingCost).append('\n');
        stringbuilder.append("shippingType: ").append(shippingType).append('\n');
        stringbuilder.append("subtitle: ").append(subtitle).append('\n');
        stringbuilder.append("title: ").append(title).append('\n');
        stringbuilder.append("timeLeft: ").append(timeLeft).append('\n');
        stringbuilder.append("viewItemURL: ").append(viewItemURL).append('\n');
        return stringbuilder.toString();
    }
}
