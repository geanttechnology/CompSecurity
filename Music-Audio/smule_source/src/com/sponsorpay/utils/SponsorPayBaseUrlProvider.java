// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.sponsorpay.utils:
//            SPUrlProvider, StringUtils

public class SponsorPayBaseUrlProvider
{

    private static SponsorPayBaseUrlProvider INSTANCE = new SponsorPayBaseUrlProvider();
    private SPUrlProvider mUrlProviderOverride;
    private Map urls;

    private SponsorPayBaseUrlProvider()
    {
        urls = new HashMap() {

            final SponsorPayBaseUrlProvider this$0;

            
            {
                this$0 = SponsorPayBaseUrlProvider.this;
                super();
                put("actions", "https://service.sponsorpay.com/actions/v2");
                put("installs", "https://service.sponsorpay.com/installs/v2");
                put("vcs", "https://api.sponsorpay.com/vcs/v1/new_credit.json");
                put("mbe", "https://iframe.sponsorpay.com/mbe");
                put("ofw", "https://iframe.sponsorpay.com/mobile");
                put("interstitial", "https://engine.sponsorpay.com/interstitial");
                put("tracker", "https://engine.sponsorpay.com/tracker");
                put("config", "https://engine.sponsorpay.com/sdk-config");
            }
        };
    }

    public static String getBaseUrl(String s)
    {
        return INSTANCE.getUrl(s);
    }

    private String getUrl(String s)
    {
        String s1 = null;
        if (mUrlProviderOverride != null)
        {
            s1 = mUrlProviderOverride.getBaseUrl(s);
        }
        String s2 = s1;
        if (StringUtils.nullOrEmpty(s1))
        {
            s2 = (String)urls.get(s);
        }
        return s2;
    }

    private void setOverride(SPUrlProvider spurlprovider)
    {
        mUrlProviderOverride = spurlprovider;
    }

    public static void setProviderOverride(SPUrlProvider spurlprovider)
    {
        INSTANCE.setOverride(spurlprovider);
    }

}
