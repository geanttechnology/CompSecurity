// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.sponsorpay.utils;

import java.util.HashMap;

// Referenced classes of package com.sponsorpay.utils:
//            SponsorPayBaseUrlProvider

class put extends HashMap
{

    final SponsorPayBaseUrlProvider this$0;

    ()
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
}
