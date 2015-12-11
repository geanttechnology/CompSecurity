// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class ExtraOfferListing
{

    private String comments;
    private Integer merchantRating;
    private Integer merchantRatingCount;
    private String merchantRatingMessage;
    private Integer merchantRatingPercentPositive;
    private String shippingCharge;
    private String shippingMessage;
    private String snsDiscountPercent;
    private String snsDiscountedPricePerUnit;
    private String snsSignUpPrice;

    public ExtraOfferListing()
    {
    }

    public String getComments()
    {
        return comments;
    }

    public Integer getMerchantRatingCount()
    {
        return merchantRatingCount;
    }

    public String getMerchantRatingMessage()
    {
        return merchantRatingMessage;
    }

    public Integer getMerchantRatingPercentPositive()
    {
        return merchantRatingPercentPositive;
    }

    public String getShippingCharge()
    {
        return shippingCharge;
    }

    public String getSnsDiscountPercent()
    {
        return snsDiscountPercent;
    }

    public void setComments(String s)
    {
        comments = s;
    }

    public void setMerchantRating(Integer integer)
    {
        merchantRating = integer;
    }

    public void setMerchantRatingCount(Integer integer)
    {
        merchantRatingCount = integer;
    }

    public void setMerchantRatingMessage(String s)
    {
        merchantRatingMessage = s;
    }

    public void setMerchantRatingPercentPositive(Integer integer)
    {
        merchantRatingPercentPositive = integer;
    }

    public void setShippingCharge(String s)
    {
        shippingCharge = s;
    }

    public void setShippingMessage(String s)
    {
        shippingMessage = s;
    }

    public void setSnsDiscountPercent(String s)
    {
        snsDiscountPercent = s;
    }

    public void setSnsDiscountedPricePerUnit(String s)
    {
        snsDiscountedPricePerUnit = s;
    }

    public void setSnsSignUpPrice(String s)
    {
        snsSignUpPrice = s;
    }
}
