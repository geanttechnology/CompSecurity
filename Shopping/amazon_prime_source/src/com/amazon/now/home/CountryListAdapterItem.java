// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.now.home;


public class CountryListAdapterItem
{

    public final String mCountryName;
    public final int mFlagIcon;

    public CountryListAdapterItem(String s, Integer integer)
    {
        mCountryName = s;
        mFlagIcon = integer.intValue();
    }

    public String getCountryName()
    {
        return mCountryName;
    }

    public Integer getFlagIcon()
    {
        return Integer.valueOf(mFlagIcon);
    }

    public String toString()
    {
        return mCountryName;
    }
}
