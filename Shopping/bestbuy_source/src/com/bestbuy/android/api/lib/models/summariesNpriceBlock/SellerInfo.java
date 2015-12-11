// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import gu;
import java.io.Serializable;
import java.util.List;

public class SellerInfo
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String averageScore;
    private List images;
    private String numSellers;
    private String numSellersUrl;
    private String ratingRangeMax;
    private String ratingUrl;
    private String returnPolicyUrl;
    private String seller;
    private String sellerId;
    private String sellerUrl;
    private String shopSellerUrl;

    public SellerInfo()
    {
    }

    public String getAverageScore()
    {
        return averageScore;
    }

    public List getImages()
    {
        return images;
    }

    public String getNumSellers()
    {
        return numSellers;
    }

    public String getNumSellersUrl()
    {
        return numSellersUrl;
    }

    public String getRatingRangeMax()
    {
        return ratingRangeMax;
    }

    public String getRatingUrl()
    {
        return ratingUrl;
    }

    public String getReturnPolicyUrl()
    {
        return returnPolicyUrl;
    }

    public String getSeller()
    {
        return seller;
    }

    public String getSellerId()
    {
        return sellerId;
    }

    public String getSellerUrl()
    {
        return sellerUrl;
    }

    public String getShopSellerUrl()
    {
        return shopSellerUrl;
    }

    public void setAverageScore(String s)
    {
        averageScore = s;
    }

    public void setImages(List list)
    {
        images = list;
    }

    public void setNumSellers(String s)
    {
        numSellers = s;
    }

    public void setNumSellersUrl(String s)
    {
        numSellersUrl = s;
    }

    public void setRatingRangeMax(String s)
    {
        ratingRangeMax = s;
    }

    public void setRatingUrl(String s)
    {
        ratingUrl = s;
    }

    public void setReturnPolicyUrl(String s)
    {
        returnPolicyUrl = s;
    }

    public void setSeller(String s)
    {
        seller = s;
    }

    public void setSellerId(String s)
    {
        sellerId = s;
    }

    public void setSellerUrl(String s)
    {
        sellerUrl = s;
    }

    public void setShopSellerUrl(String s)
    {
        shopSellerUrl = s;
    }
}
