// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.chart;

import com.shazam.model.player.ProviderPlaybackIds;
import com.shazam.model.preview.PreviewViewData;
import com.shazam.model.store.Stores;
import com.shazam.server.response.play.Streams;

public class TrackV2
{
    public static class Builder
    {

        public String artist;
        public String coverArtUrl;
        public String key;
        public PreviewViewData previewViewData;
        public ProviderPlaybackIds providerPlaybackIds;
        public Stores stores;
        public Streams streams;
        public String title;

        public static Builder a()
        {
            return new Builder();
        }

        static String a(Builder builder)
        {
            return builder.title;
        }

        static String b(Builder builder)
        {
            return builder.artist;
        }

        static String c(Builder builder)
        {
            return builder.coverArtUrl;
        }

        static String d(Builder builder)
        {
            return builder.key;
        }

        static ProviderPlaybackIds e(Builder builder)
        {
            return builder.providerPlaybackIds;
        }

        static Stores f(Builder builder)
        {
            return builder.stores;
        }

        static PreviewViewData g(Builder builder)
        {
            return builder.previewViewData;
        }

        static Streams h(Builder builder)
        {
            return builder.streams;
        }

        public Builder()
        {
        }
    }


    public String artist;
    public String coverArtUrl;
    public String key;
    public PreviewViewData previewViewData;
    private ProviderPlaybackIds providerPlaybackIds;
    private Stores stores;
    public Streams streams;
    public String title;

    private TrackV2()
    {
    }

    private TrackV2(Builder builder)
    {
        title = Builder.a(builder);
        artist = Builder.b(builder);
        coverArtUrl = Builder.c(builder);
        key = Builder.d(builder);
        providerPlaybackIds = Builder.e(builder);
        stores = Builder.f(builder);
        previewViewData = Builder.g(builder);
        streams = Builder.h(builder);
    }


    public final ProviderPlaybackIds a()
    {
        if (providerPlaybackIds == null)
        {
            return com.shazam.model.player.ProviderPlaybackIds.Builder.a().b();
        } else
        {
            return providerPlaybackIds;
        }
    }

    public final Stores b()
    {
        if (stores == null)
        {
            return com.shazam.model.store.Stores.Builder.a().b();
        } else
        {
            return stores;
        }
    }
}
