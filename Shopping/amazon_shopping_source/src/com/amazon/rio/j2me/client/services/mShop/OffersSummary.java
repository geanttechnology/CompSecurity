// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class OffersSummary
{

    private int count;
    private String highestPrice;
    private String lowestPrice;
    private Boolean someViolateMap;

    public OffersSummary()
    {
    }

    public int getCount()
    {
        return count;
    }

    public String getLowestPrice()
    {
        return lowestPrice;
    }

    public void setCount(int i)
    {
        count = i;
    }

    public void setHighestPrice(String s)
    {
        highestPrice = s;
    }

    public void setLowestPrice(String s)
    {
        lowestPrice = s;
    }

    public void setSomeViolateMap(Boolean boolean1)
    {
        someViolateMap = boolean1;
    }
}
