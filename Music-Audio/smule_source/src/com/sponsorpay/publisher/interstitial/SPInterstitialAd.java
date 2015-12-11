// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.publisher.interstitial;

import java.util.Collections;
import java.util.Map;

public class SPInterstitialAd
{

    private String mAdId;
    private String mProviderType;

    public SPInterstitialAd(String s, String s1)
    {
        mProviderType = s;
        mAdId = s1;
    }

    public String getAdId()
    {
        return mAdId;
    }

    public Map getContextData()
    {
        return Collections.emptyMap();
    }

    public String getProviderType()
    {
        return mProviderType;
    }
}
