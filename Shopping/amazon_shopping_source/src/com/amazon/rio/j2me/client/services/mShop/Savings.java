// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class Savings
{

    private String availabilityMessage;
    private String discountLabel;
    private String listPrice;
    private String listPriceLabel;
    private Integer percentOff;
    private String prePromoPrice;
    private String prePromoPriceLabel;
    private String promoDiscount;
    private String promoPrice;
    private String promoPriceLabel;

    public Savings()
    {
    }

    public String getPrePromoPrice()
    {
        return prePromoPrice;
    }

    public String getPromoPrice()
    {
        return promoPrice;
    }

    public String getPromoPriceLabel()
    {
        return promoPriceLabel;
    }

    public void setAvailabilityMessage(String s)
    {
        availabilityMessage = s;
    }

    public void setDiscountLabel(String s)
    {
        discountLabel = s;
    }

    public void setListPrice(String s)
    {
        listPrice = s;
    }

    public void setListPriceLabel(String s)
    {
        listPriceLabel = s;
    }

    public void setPercentOff(Integer integer)
    {
        percentOff = integer;
    }

    public void setPrePromoPrice(String s)
    {
        prePromoPrice = s;
    }

    public void setPrePromoPriceLabel(String s)
    {
        prePromoPriceLabel = s;
    }

    public void setPromoDiscount(String s)
    {
        promoDiscount = s;
    }

    public void setPromoPrice(String s)
    {
        promoPrice = s;
    }

    public void setPromoPriceLabel(String s)
    {
        promoPriceLabel = s;
    }
}
