// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home;

import gu;
import java.io.Serializable;

public class CustomOfferPrice
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x925e55ac5d557f5eL;
    private String currentPrice;
    private boolean onSale;
    private String priceType;
    private String regularPrice;
    private String savingsAmount;

    public CustomOfferPrice()
    {
    }

    public String getCurrentPrice()
    {
        return currentPrice;
    }

    public String getPriceType()
    {
        return priceType;
    }

    public String getRegularPrice()
    {
        return regularPrice;
    }

    public String getSavingsAmount()
    {
        return savingsAmount;
    }

    public boolean isOnSale()
    {
        return onSale;
    }

    public void setCurrentPrice(String s)
    {
        currentPrice = s;
    }

    public void setOnSale(boolean flag)
    {
        onSale = flag;
    }

    public void setPriceType(String s)
    {
        priceType = s;
    }

    public void setRegularPrice(String s)
    {
        regularPrice = s;
    }

    public void setSavingsAmount(String s)
    {
        savingsAmount = s;
    }
}
