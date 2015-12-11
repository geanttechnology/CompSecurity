// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class BuyAsinRequest
{

    private String asin;
    private String clickStreamOrigin;
    private String dealId;
    private String listId;
    private String listItemId;
    private String offerId;
    private String oneClickShippingSpeed;

    public BuyAsinRequest()
    {
    }

    public String getAsin()
    {
        return asin;
    }

    public String getClickStreamOrigin()
    {
        return clickStreamOrigin;
    }

    public String getDealId()
    {
        return dealId;
    }

    public String getListId()
    {
        return listId;
    }

    public String getListItemId()
    {
        return listItemId;
    }

    public String getOfferId()
    {
        return offerId;
    }

    public String getOneClickShippingSpeed()
    {
        return oneClickShippingSpeed;
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setClickStreamOrigin(String s)
    {
        clickStreamOrigin = s;
    }

    public void setOfferId(String s)
    {
        offerId = s;
    }

    public void setOneClickShippingSpeed(String s)
    {
        oneClickShippingSpeed = s;
    }
}
