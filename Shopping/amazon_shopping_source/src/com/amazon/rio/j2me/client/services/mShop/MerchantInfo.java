// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class MerchantInfo
{

    private Boolean isAmazon;
    private String logo;
    private String merchantId;
    private String merchantName;
    private String sellerDetailsPageUrl;

    public MerchantInfo()
    {
    }

    public Boolean getIsAmazon()
    {
        return isAmazon;
    }

    public String getMerchantId()
    {
        return merchantId;
    }

    public String getMerchantName()
    {
        return merchantName;
    }

    public void setIsAmazon(Boolean boolean1)
    {
        isAmazon = boolean1;
    }

    public void setLogo(String s)
    {
        logo = s;
    }

    public void setMerchantId(String s)
    {
        merchantId = s;
    }

    public void setMerchantName(String s)
    {
        merchantName = s;
    }

    public void setSellerDetailsPageUrl(String s)
    {
        sellerDetailsPageUrl = s;
    }
}
