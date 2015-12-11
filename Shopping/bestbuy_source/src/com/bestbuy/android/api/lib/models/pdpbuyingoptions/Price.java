// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpbuyingoptions;

import gu;
import java.io.Serializable;

public class Price
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private double currentPrice;
    private String listingId;
    private String originalPricingType;
    private String pricingType;
    private double regularPrice;
    private double savingsAmount;
    private double shippingCost;
    private double totalPrice;

    public Price()
    {
    }

    public double getCurrentPrice()
    {
        return currentPrice;
    }

    public String getListingId()
    {
        return listingId;
    }

    public String getOriginalPricingType()
    {
        return originalPricingType;
    }

    public String getPricingType()
    {
        return pricingType;
    }

    public double getRegularPrice()
    {
        return regularPrice;
    }

    public double getSavingsAmount()
    {
        return savingsAmount;
    }

    public double getShippingCost()
    {
        return shippingCost;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }

    public void setCurrentPrice(double d)
    {
        currentPrice = d;
    }

    public void setListingId(String s)
    {
        listingId = s;
    }

    public void setOriginalPricingType(String s)
    {
        originalPricingType = s;
    }

    public void setPricingType(String s)
    {
        pricingType = s;
    }

    public void setRegularPrice(double d)
    {
        regularPrice = d;
    }

    public void setSavingsAmount(double d)
    {
        savingsAmount = d;
    }

    public void setShippingCost(double d)
    {
        shippingCost = d;
    }

    public void setTotalPrice(double d)
    {
        totalPrice = d;
    }
}
