// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.opl;


public class PurchaseParams
{

    private String mAsin;
    private String mCheckoutUrl;
    private String mClickStreamOrigin;
    private String mDealId;
    private boolean mIsCartPurchase;
    private String mListId;
    private String mListItemId;
    private String mOfferId;
    private String mOneClickShippingSpeed;

    public PurchaseParams()
    {
    }

    public PurchaseParams(String s, String s1, String s2, String s3, String s4, String s5, String s6)
    {
        mAsin = s;
        mOfferId = s1;
        mListId = s2;
        mListItemId = s3;
        mDealId = s4;
        mOneClickShippingSpeed = s5;
        mClickStreamOrigin = s6;
    }

    public String getAsin()
    {
        return mAsin;
    }

    public String getCheckoutUrl()
    {
        return mCheckoutUrl;
    }

    public String getClickStreamOrigin()
    {
        return mClickStreamOrigin;
    }

    public String getListId()
    {
        return mListId;
    }

    public String getListItemId()
    {
        return mListItemId;
    }

    public String getOfferId()
    {
        return mOfferId;
    }

    public String getOneClickShippingSpeed()
    {
        return mOneClickShippingSpeed;
    }

    public boolean isCartPurchase()
    {
        return mIsCartPurchase;
    }

    public void setCheckoutUrl(String s)
    {
        mCheckoutUrl = s;
    }

    public void setIsCartPurchase(boolean flag)
    {
        mIsCartPurchase = flag;
    }
}
