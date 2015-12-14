// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.util.Pair;

// Referenced classes of package com.mopub.mobileads:
//            RewardedVideoData

private static class adNetworkId extends Pair
{

    final String adNetworkId;
    final Class customEventClass;

    public (Class class1, String s)
    {
        super(class1, s);
        customEventClass = class1;
        adNetworkId = s;
    }
}
