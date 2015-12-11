// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.mopub.common.Preconditions;
import java.util.Iterator;
import java.util.Set;

// Referenced classes of package com.mopub.mobileads:
//            MoPubRewardedVideoManager, RewardedVideoData

private static abstract class mThirdPartyId
    implements Runnable
{

    private final Class mCustomEventClass;
    private final String mThirdPartyId;

    protected abstract void forEach(String s);

    public void run()
    {
        for (Iterator iterator = MoPubRewardedVideoManager.access$800(MoPubRewardedVideoManager.access$200()).getMoPubIdsForAdNetwork(mCustomEventClass, mThirdPartyId).iterator(); iterator.hasNext(); forEach((String)iterator.next())) { }
    }

    (Class class1, String s)
    {
        Preconditions.checkNotNull(class1);
        Preconditions.checkNotNull(s);
        mCustomEventClass = class1;
        mThirdPartyId = s;
    }
}
