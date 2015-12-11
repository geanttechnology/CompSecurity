// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;

public class Price
    implements gu, Serializable
{

    public static final String BUNDLE = "bundle";
    public static final String CLEARANCE = "clearance";
    public static final String COMING_SOON = "ComingSoon";
    public static final String CONTRACT_2_YEARS_NEW = "2_YEARS_NEW";
    public static final String CONTRACT_2_YEARS_UPGRADE = "2_YEARS_UPGRADE";
    public static final String ICR_HIDE_PRICE = "ICR-hidePrice";
    public static final String ICR_NO_PRICE = "ICR-noPrice";
    public static final String ICR_STRIKE_THROUGH = "ICR-strikeThrough";
    public static final String MAP = "MAP";
    public static final String ONSALE = "onSale";
    public static final String REFURBISHED = "refurbished";
    public static final String REGULAR = "regular";
    private static final long serialVersionUID = 1L;
    private double currentPrice;
    private String firstOrderDate;
    private boolean ibPricing;
    private String listingId;
    private double minimumPriceDisplay;
    private String originalPricingType;
    private String pricingType;
    private double regularPrice;
    private double savingsAmount;

    public Price()
    {
    }

    public double getCurrentPrice()
    {
        return currentPrice;
    }

    public String getFirstOrderDate()
    {
        return firstOrderDate;
    }

    public String getListingId()
    {
        return listingId;
    }

    public double getMinimumPriceDisplay()
    {
        return minimumPriceDisplay;
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

    public boolean isIbPricing()
    {
        return ibPricing;
    }

    public void setCurrentPrice(double d)
    {
        currentPrice = d;
    }

    public void setFirstOrderDate(String s)
    {
        firstOrderDate = s;
    }

    public void setIbPricing(boolean flag)
    {
        ibPricing = flag;
    }

    public void setListingId(String s)
    {
        listingId = s;
    }

    public void setMinimumPriceDisplay(double d)
    {
        minimumPriceDisplay = d;
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
}
