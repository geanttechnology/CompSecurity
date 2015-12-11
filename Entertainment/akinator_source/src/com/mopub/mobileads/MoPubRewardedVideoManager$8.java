// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.MoPubReward;
import java.util.HashSet;

// Referenced classes of package com.mopub.mobileads:
//            MoPubRewardedVideoManager, RewardedVideoData, MoPubRewardedVideoListener

static final class val.moPubReward
    implements Runnable
{

    final Class val$customEventClass;
    final MoPubReward val$moPubReward;
    final String val$thirdPartyId;

    public void run()
    {
        HashSet hashset = new HashSet(MoPubRewardedVideoManager.access$800(MoPubRewardedVideoManager.access$200()).getMoPubIdsForAdNetwork(val$customEventClass, val$thirdPartyId));
        if (MoPubRewardedVideoManager.access$400(MoPubRewardedVideoManager.access$200()) != null)
        {
            MoPubRewardedVideoManager.access$400(MoPubRewardedVideoManager.access$200()).onRewardedVideoCompleted(hashset, val$moPubReward);
        }
    }

    (Class class1, String s, MoPubReward mopubreward)
    {
        val$customEventClass = class1;
        val$thirdPartyId = s;
        val$moPubReward = mopubreward;
        super();
    }
}
