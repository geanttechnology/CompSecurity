// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.goldbox;


public class GoldboxLaunchParamters
{

    private String mCategory;
    private String mDealType;
    private String mTitle;

    public GoldboxLaunchParamters(String s, String s1, String s2)
    {
        mDealType = s;
        mCategory = s1;
        mTitle = s2;
    }

    public String getCategory()
    {
        return mCategory;
    }

    public String getDealType()
    {
        return mDealType;
    }

    public String getTitle()
    {
        return mTitle;
    }
}
