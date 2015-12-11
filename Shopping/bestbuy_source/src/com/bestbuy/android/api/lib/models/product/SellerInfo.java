// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.product;

import java.io.Serializable;
import org.json.JSONObject;

public class SellerInfo
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private String averageScore;
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

    public static SellerInfo getSellerInfo(JSONObject jsonobject)
    {
        SellerInfo sellerinfo = new SellerInfo();
        sellerinfo.seller = jsonobject.optString("seller", "");
        sellerinfo.sellerId = jsonobject.optString("sellerId", "");
        sellerinfo.averageScore = jsonobject.optString("averageScore", "");
        sellerinfo.ratingRangeMax = jsonobject.optString("ratingRangeMax", "");
        sellerinfo.sellerUrl = jsonobject.optString("sellerUrl", "");
        sellerinfo.ratingUrl = jsonobject.optString("ratingUrl", "");
        sellerinfo.returnPolicyUrl = jsonobject.optString("returnPolicyUrl", "");
        sellerinfo.shopSellerUrl = jsonobject.optString("shopSellerUrl", "");
        return sellerinfo;
    }

    public String getAverageScore()
    {
        return averageScore;
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
}
