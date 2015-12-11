// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp.protectionservices;

import gu;
import java.io.Serializable;

public class Column
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String planType;
    private String price;
    private String serviceInFeature;

    public Column()
    {
    }

    public String getPlanType()
    {
        return planType;
    }

    public String getPrice()
    {
        return price;
    }

    public String getServiceInFeature()
    {
        return serviceInFeature;
    }

    public void setPlanType(String s)
    {
        planType = s;
    }

    public void setPrice(String s)
    {
        price = s;
    }

    public void setServiceInFeature(String s)
    {
        serviceInFeature = s;
    }
}
