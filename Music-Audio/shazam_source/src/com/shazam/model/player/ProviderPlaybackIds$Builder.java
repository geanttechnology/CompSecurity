// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.player;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.model.player:
//            ProviderPlaybackIds

public static class providerTrackIdMap
{

    public Map providerTrackIdMap;

    public static providerTrackIdMap a()
    {
        return new <init>();
    }

    public static <init> a(ProviderPlaybackIds providerplaybackids)
    {
        <init> <init>1 = new <init>();
        <init>1.providerTrackIdMap = ProviderPlaybackIds.a(providerplaybackids);
        return <init>1;
    }

    static Map a(providerTrackIdMap providertrackidmap)
    {
        return providertrackidmap.providerTrackIdMap;
    }

    public final ProviderPlaybackIds b()
    {
        return new ProviderPlaybackIds(this, null);
    }

    public _cls9()
    {
        providerTrackIdMap = new HashMap();
    }
}
