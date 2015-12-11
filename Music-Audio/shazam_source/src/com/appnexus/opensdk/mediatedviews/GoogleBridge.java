// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import com.appnexus.opensdk.MediatedBannerAdView;
import com.appnexus.opensdk.MediatedInterstitialAdView;

class GoogleBridge
{

    GoogleBridge()
    {
    }

    static MediatedBannerAdView a(String s)
    {
        s = (MediatedBannerAdView)Class.forName(s).newInstance();
        return s;
        s;
_L2:
        return null;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }

    static boolean a()
    {
        boolean flag = false;
        Class class1;
        try
        {
            class1 = Class.forName("com.google.android.gms.ads.a");
        }
        catch (ClassNotFoundException classnotfoundexception)
        {
            return false;
        }
        if (class1 != null)
        {
            flag = true;
        }
        return flag;
    }

    static MediatedInterstitialAdView b(String s)
    {
        s = (MediatedInterstitialAdView)Class.forName(s).newInstance();
        return s;
        s;
_L2:
        return null;
        s;
        continue; /* Loop/switch isn't completed */
        s;
        continue; /* Loop/switch isn't completed */
        s;
        if (true) goto _L2; else goto _L1
_L1:
    }
}
