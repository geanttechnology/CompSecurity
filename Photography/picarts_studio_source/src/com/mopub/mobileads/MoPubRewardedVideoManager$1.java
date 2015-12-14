// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.logging.MoPubLog;

// Referenced classes of package com.mopub.mobileads:
//            MoPubRewardedVideoManager, CustomEventRewardedVideo, MoPubErrorCode

class val.customEvent
    implements Runnable
{

    final MoPubRewardedVideoManager this$0;
    final CustomEventRewardedVideo val$customEvent;

    public void run()
    {
        MoPubLog.d("Custom Event failed to load rewarded video in a timely fashion.");
        MoPubRewardedVideoManager.onRewardedVideoLoadFailure(val$customEvent.getClass(), val$customEvent.getAdNetworkId(), MoPubErrorCode.NETWORK_TIMEOUT);
        val$customEvent.onInvalidate();
    }

    ()
    {
        this$0 = final_mopubrewardedvideomanager;
        val$customEvent = CustomEventRewardedVideo.this;
        super();
    }
}
