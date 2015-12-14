// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;


// Referenced classes of package com.mopub.mobileads:
//            MoPubRewardedVideoManager, MoPubErrorCode

final class rEachMoPubIdRunnable extends rEachMoPubIdRunnable
{

    final MoPubErrorCode val$errorCode;

    protected final void forEach(String s)
    {
        MoPubRewardedVideoManager.access$300(MoPubRewardedVideoManager.access$200(), s);
        MoPubRewardedVideoManager.access$500(MoPubRewardedVideoManager.access$200(), s, val$errorCode);
    }

    rEachMoPubIdRunnable(String s, MoPubErrorCode mopuberrorcode)
    {
        val$errorCode = mopuberrorcode;
        super(final_class1, s);
    }
}
