// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.player;

import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.shazam.model.player:
//            PlaybackProvider

public class ProviderPlaybackIds
{
    public static class Builder
    {

        public Map providerTrackIdMap;

        public static Builder a()
        {
            return new Builder();
        }

        public static Builder a(ProviderPlaybackIds providerplaybackids)
        {
            Builder builder = new Builder();
            builder.providerTrackIdMap = ProviderPlaybackIds.a(providerplaybackids);
            return builder;
        }

        static Map a(Builder builder)
        {
            return builder.providerTrackIdMap;
        }

        public final ProviderPlaybackIds b()
        {
            return new ProviderPlaybackIds(this, null);
        }

        public Builder()
        {
            providerTrackIdMap = new HashMap();
        }
    }


    private Map providerTrackIdMap;

    private ProviderPlaybackIds()
    {
    }

    private ProviderPlaybackIds(Builder builder)
    {
        providerTrackIdMap = Builder.a(builder);
    }

    ProviderPlaybackIds(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    static Map a(ProviderPlaybackIds providerplaybackids)
    {
        return providerplaybackids.providerTrackIdMap;
    }

    public final String a(PlaybackProvider playbackprovider)
    {
        return (String)providerTrackIdMap.get(playbackprovider);
    }
}
