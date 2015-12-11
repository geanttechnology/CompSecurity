// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;

public class Attributes
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private boolean lowPriceGuaranteedProduct;
    private boolean marketplace;
    private boolean onlineOnly;
    private boolean parentalAdvisory;
    private boolean specialOrderDelivery;

    public Attributes()
    {
    }

    public boolean isLowPriceGuaranteedProduct()
    {
        return lowPriceGuaranteedProduct;
    }

    public boolean isMarketplace()
    {
        return marketplace;
    }

    public boolean isOnlineOnly()
    {
        return onlineOnly;
    }

    public boolean isParentalAdvisory()
    {
        return parentalAdvisory;
    }

    public boolean isSpecialOrderDelivery()
    {
        return specialOrderDelivery;
    }

    public void setLowPriceGuaranteedProduct(boolean flag)
    {
        lowPriceGuaranteedProduct = flag;
    }

    public void setMarketplace(boolean flag)
    {
        marketplace = flag;
    }

    public void setOnlineOnly(boolean flag)
    {
        onlineOnly = flag;
    }

    public void setParentalAdvisory(boolean flag)
    {
        parentalAdvisory = flag;
    }

    public void setSpecialOrderDelivery(boolean flag)
    {
        specialOrderDelivery = flag;
    }
}
