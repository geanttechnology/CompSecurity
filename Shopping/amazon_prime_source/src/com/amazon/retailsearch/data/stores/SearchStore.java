// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.stores;


public class SearchStore
{

    private final String mBadgeUrl;
    private final String mImageUrl;
    private final String mMerchantId;
    private final String mName;
    private final String mStoreColor;
    private final String mUrl;

    public SearchStore(String s, String s1, String s2, String s3, String s4, String s5)
    {
        mName = s;
        mMerchantId = s1;
        mUrl = s2;
        mImageUrl = s3;
        mBadgeUrl = s4;
        mStoreColor = s5;
    }

    public String getBadgeUrl()
    {
        return mBadgeUrl;
    }

    public String getImageUrl()
    {
        return mImageUrl;
    }

    public String getMerchantId()
    {
        return mMerchantId;
    }

    public String getStoreColor()
    {
        return mStoreColor;
    }

    public String getStoreName()
    {
        return mName;
    }

    public String getStoreUrl()
    {
        return mUrl;
    }
}
