// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.network.TrackingRequest;

// Referenced classes of package com.mopub.mobileads:
//            MoPubRewardedVideoManager, AdRequestStatusMapping

static final class rEachMoPubIdRunnable extends rEachMoPubIdRunnable
{

    protected void forEach(String s)
    {
        TrackingRequest.makeTrackingHttpRequest(MoPubRewardedVideoManager.access$600(MoPubRewardedVideoManager.access$200()).getClickTrackerUrlString(s), MoPubRewardedVideoManager.access$700(MoPubRewardedVideoManager.access$200()));
        MoPubRewardedVideoManager.access$600(MoPubRewardedVideoManager.access$200()).clearClickUrl(s);
    }

    rEachMoPubIdRunnable(Class class1, String s)
    {
        super(class1, s);
    }
}
