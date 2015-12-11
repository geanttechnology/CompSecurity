// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store;

import gu;
import java.io.Serializable;

public class Attributes
    implements gu, Serializable
{

    private String lowPriceGuaranteedProduct;
    private String magnoliaProduct;
    private String onlineOnly;
    private String specialOrderDelivery;

    public Attributes()
    {
    }

    public String getLowPriceGuaranteedProduct()
    {
        return lowPriceGuaranteedProduct;
    }

    public String getMagnoliaProduct()
    {
        return magnoliaProduct;
    }

    public String getOnlineOnly()
    {
        return onlineOnly;
    }

    public String getSpecialOrderDelivery()
    {
        return specialOrderDelivery;
    }

    public void setLowPriceGuaranteedProduct(String s)
    {
        lowPriceGuaranteedProduct = s;
    }

    public void setMagnoliaProduct(String s)
    {
        magnoliaProduct = s;
    }

    public void setOnlineOnly(String s)
    {
        onlineOnly = s;
    }

    public void setSpecialOrderDelivery(String s)
    {
        specialOrderDelivery = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [magnoliaProduct = ").append(magnoliaProduct).append(", specialOrderDelivery = ").append(specialOrderDelivery).append(", lowPriceGuaranteedProduct = ").append(lowPriceGuaranteedProduct).append(", onlineOnly = ").append(onlineOnly).append("]").toString();
    }
}
