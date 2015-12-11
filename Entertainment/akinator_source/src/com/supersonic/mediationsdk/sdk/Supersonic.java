// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.supersonic.mediationsdk.sdk;

import com.supersonic.mediationsdk.logger.LoggingApi;

// Referenced classes of package com.supersonic.mediationsdk.sdk:
//            RewardedVideoApi, InterstitialApi, OfferwallApi

public interface Supersonic
    extends RewardedVideoApi, InterstitialApi, OfferwallApi, LoggingApi
{

    public abstract void removeInterstitialListener();

    public abstract void removeOfferwallListener();

    public abstract void removeRewardedVideoListener();
}
