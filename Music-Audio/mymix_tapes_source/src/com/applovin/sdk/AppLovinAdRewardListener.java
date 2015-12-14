// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.sdk;

import java.util.Map;

// Referenced classes of package com.applovin.sdk:
//            AppLovinAd

public interface AppLovinAdRewardListener
{

    public abstract void userDeclinedToViewAd(AppLovinAd applovinad);

    public abstract void userOverQuota(AppLovinAd applovinad, Map map);

    public abstract void userRewardRejected(AppLovinAd applovinad, Map map);

    public abstract void userRewardVerified(AppLovinAd applovinad, Map map);

    public abstract void validationRequestFailed(AppLovinAd applovinad, int i);
}
