// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.network.TrackingRequest;

// Referenced classes of package com.mopub.mobileads:
//            MoPubRewardedVideoManager, MoPubRewardedVideoListener, AdRequestStatusMapping

final class rEachMoPubIdRunnable extends rEachMoPubIdRunnable
{

    protected final void forEach(String s)
    {
        if (MoPubRewardedVideoManager.access$400(MoPubRewardedVideoManager.access$200()) != null)
        {
            MoPubRewardedVideoManager.access$400(MoPubRewardedVideoManager.access$200()).onRewardedVideoStarted(s);
        }
        TrackingRequest.makeTrackingHttpRequest(MoPubRewardedVideoManager.access$600(MoPubRewardedVideoManager.access$200()).getImpressionTrackerUrlString(s), MoPubRewardedVideoManager.access$700(MoPubRewardedVideoManager.access$200()));
        MoPubRewardedVideoManager.access$600(MoPubRewardedVideoManager.access$200()).clearImpressionUrl(s);
    }

    rEachMoPubIdRunnable(Class class1, String s)
    {
        super(class1, s);
    }
}
