// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.services.apigee.n.b.a;


public class d
{

    private static final String YES = "Y";
    private String mCatEntryId;
    private String mDpci;
    private String mImageUrl;
    private String mPickupInStore;
    private String mPrice;
    private String mPriceEyebrow;
    private String mPriceLabel;
    private String mPriceMessage;
    private String mProductSlug;
    private String mPurchasingChannel;
    private String mTcin;
    private String mTitle;

    public d()
    {
    }

    public String a()
    {
        return mPrice;
    }

    public String b()
    {
        return mPriceLabel;
    }

    public String c()
    {
        return mPriceMessage;
    }

    public String d()
    {
        return mPriceEyebrow;
    }

    public String e()
    {
        return mPurchasingChannel;
    }

    public boolean f()
    {
        return "Y".equalsIgnoreCase(mPickupInStore);
    }

    public String g()
    {
        return mTitle;
    }

    public String h()
    {
        return mTcin;
    }

    public String i()
    {
        return mDpci;
    }

    public String j()
    {
        return mImageUrl;
    }

    public String k()
    {
        return mProductSlug;
    }

    public String l()
    {
        return mCatEntryId;
    }
}
