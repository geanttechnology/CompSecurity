// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;

import com.apprupt.sdk.mediation.ValueExchangeCompletion;

public class CvContentOptions
{

    public final boolean adColony;
    public final String adSpaceId;
    public final String categories;
    public final boolean hardwareAcceleration;
    public final boolean interstitial;
    public CvSDK.CvInterstitialListener interstitialListener;
    public final String keywords;
    public final boolean valueExchange;
    public final ValueExchangeCompletion valueExchangeCompletion;

    public CvContentOptions(int i, String s, String s1, boolean flag, boolean flag1, boolean flag2)
    {
        this(String.valueOf(i), s, s1, flag, flag1, flag2);
    }

    public CvContentOptions(String s, String s1, String s2, boolean flag, boolean flag1, boolean flag2)
    {
        this(s, s1, s2, flag, flag1, flag2, null);
    }

    public CvContentOptions(String s, String s1, String s2, boolean flag, boolean flag1, boolean flag2, ValueExchangeCompletion valueexchangecompletion)
    {
        interstitialListener = null;
        adSpaceId = s;
        s = s2;
        if (s2 == null)
        {
            s = "";
        }
        keywords = s;
        s = s1;
        if (s1 == null)
        {
            s = "";
        }
        categories = s;
        interstitial = flag;
        adColony = flag1;
        if (valueexchangecompletion != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        valueExchange = flag;
        valueExchangeCompletion = valueexchangecompletion;
        hardwareAcceleration = flag2;
    }
}
