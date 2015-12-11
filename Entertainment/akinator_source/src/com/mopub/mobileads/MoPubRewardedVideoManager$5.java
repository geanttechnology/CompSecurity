// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            MoPubRewardedVideoManager, MoPubRewardedVideoListener, MoPubErrorCode

static final class rEachMoPubIdRunnable extends rEachMoPubIdRunnable
{

    final MoPubErrorCode val$errorCode;

    protected void forEach(String s)
    {
        if (MoPubRewardedVideoManager.access$400(MoPubRewardedVideoManager.access$200()) != null)
        {
            MoPubRewardedVideoManager.access$400(MoPubRewardedVideoManager.access$200()).onRewardedVideoPlaybackError(s, val$errorCode);
        }
    }

    rEachMoPubIdRunnable(Class class1, String s, MoPubErrorCode mopuberrorcode)
    {
        val$errorCode = mopuberrorcode;
        super(class1, s);
    }
}
