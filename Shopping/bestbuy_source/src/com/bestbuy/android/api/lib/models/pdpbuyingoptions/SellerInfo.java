// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpbuyingoptions;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

public class SellerInfo
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private double averageScore;
    private ArrayList images;
    private double ratingRangeMax;
    private String sellerId;
    private String sellerName;
    private String sellerUrl;

    public SellerInfo()
    {
    }

    public double getAverageScore()
    {
        return averageScore;
    }

    public ArrayList getImages()
    {
        return images;
    }

    public double getRatingRangeMax()
    {
        return ratingRangeMax;
    }

    public String getSellerId()
    {
        return sellerId;
    }

    public String getSellerName()
    {
        return sellerName;
    }

    public String getSellerUrl()
    {
        return sellerUrl;
    }

    public void setAverageScore(double d)
    {
        averageScore = d;
    }

    public void setImages(ArrayList arraylist)
    {
        images = arraylist;
    }

    public void setRatingRangeMax(double d)
    {
        ratingRangeMax = d;
    }

    public void setSellerId(String s)
    {
        sellerId = s;
    }

    public void setSellerName(String s)
    {
        sellerName = s;
    }

    public void setSellerUrl(String s)
    {
        sellerUrl = s;
    }
}
