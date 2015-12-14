// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import com.applovin.sdk.AppLovinLogger;
import java.util.Map;

// Referenced classes of package com.applovin.impl.sdk:
//            z, AppLovinSdkImpl

class aa
    implements AppLovinAdRewardListener
{

    final z a;

    aa(z z1)
    {
        a = z1;
        super();
    }

    public void userDeclinedToViewAd(AppLovinAd applovinad)
    {
        z.d(a).getLogger().d("IncentivizedAdController", "User declined to view");
    }

    public void userOverQuota(AppLovinAd applovinad, Map map)
    {
        z.d(a).getLogger().d("IncentivizedAdController", (new StringBuilder()).append("User over quota: ").append(map).toString());
    }

    public void userRewardRejected(AppLovinAd applovinad, Map map)
    {
        z.d(a).getLogger().d("IncentivizedAdController", (new StringBuilder()).append("Reward rejected: ").append(map).toString());
    }

    public void userRewardVerified(AppLovinAd applovinad, Map map)
    {
        z.d(a).getLogger().d("IncentivizedAdController", (new StringBuilder()).append("Reward validated: ").append(map).toString());
    }

    public void validationRequestFailed(AppLovinAd applovinad, int i)
    {
        z.d(a).getLogger().d("IncentivizedAdController", (new StringBuilder()).append("Reward validation failed: ").append(i).toString());
    }
}
