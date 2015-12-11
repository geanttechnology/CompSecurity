// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class OfferListingsRequest
{

    private String asin;
    private String conditionType;
    private int page;
    private String productGroupId;
    private int size;
    private String sort;

    public OfferListingsRequest()
    {
    }

    public String getAsin()
    {
        return asin;
    }

    public String getConditionType()
    {
        return conditionType;
    }

    public int getPage()
    {
        return page;
    }

    public String getProductGroupId()
    {
        return productGroupId;
    }

    public int getSize()
    {
        return size;
    }

    public String getSort()
    {
        return sort;
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setConditionType(String s)
    {
        conditionType = s;
    }

    public void setPage(int i)
    {
        page = i;
    }

    public void setSize(int i)
    {
        size = i;
    }
}
