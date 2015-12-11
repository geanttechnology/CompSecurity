// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.player;

import com.shazam.model.store.Stores;
import com.shazam.server.response.play.Streams;

// Referenced classes of package com.shazam.model.player:
//            ProviderPlaybackIds, PlayerItemStatus

public class PlaylistItem
{
    public static class Builder
    {

        public String artist;
        public String coverArtUrl;
        public String key;
        public ProviderPlaybackIds providerPlaybackIds;
        public PlayerItemStatus status;
        public Stores storeData;
        public Streams streams;
        public String title;

        public static Builder a()
        {
            return new Builder();
        }

        public static Builder a(PlaylistItem playlistitem)
        {
            Builder builder = new Builder();
            builder.coverArtUrl = PlaylistItem.a(playlistitem);
            builder.title = PlaylistItem.b(playlistitem);
            builder.artist = PlaylistItem.c(playlistitem);
            builder.status = PlaylistItem.d(playlistitem);
            builder.storeData = PlaylistItem.e(playlistitem);
            builder.key = PlaylistItem.f(playlistitem);
            builder.providerPlaybackIds = PlaylistItem.g(playlistitem);
            builder.streams = PlaylistItem.h(playlistitem);
            return builder;
        }

        static String a(Builder builder)
        {
            return builder.coverArtUrl;
        }

        static String b(Builder builder)
        {
            return builder.title;
        }

        static String c(Builder builder)
        {
            return builder.artist;
        }

        static PlayerItemStatus d(Builder builder)
        {
            return builder.status;
        }

        static Stores e(Builder builder)
        {
            return builder.storeData;
        }

        static String f(Builder builder)
        {
            return builder.key;
        }

        static ProviderPlaybackIds g(Builder builder)
        {
            return builder.providerPlaybackIds;
        }

        static Streams h(Builder builder)
        {
            return builder.streams;
        }

        public final PlaylistItem b()
        {
            return new PlaylistItem(this, null);
        }

        public Builder()
        {
            status = PlayerItemStatus.defaultStatus();
        }
    }


    public String artist;
    public String coverArtUrl;
    public String key;
    private ProviderPlaybackIds providerPlaybackIds;
    public PlayerItemStatus status;
    public Stores storeData;
    public Streams streams;
    public String title;

    private PlaylistItem()
    {
    }

    private PlaylistItem(Builder builder)
    {
        coverArtUrl = Builder.a(builder);
        title = Builder.b(builder);
        artist = Builder.c(builder);
        status = Builder.d(builder);
        storeData = Builder.e(builder);
        key = Builder.f(builder);
        providerPlaybackIds = Builder.g(builder);
        streams = Builder.h(builder);
    }

    PlaylistItem(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    static String a(PlaylistItem playlistitem)
    {
        return playlistitem.coverArtUrl;
    }

    static String b(PlaylistItem playlistitem)
    {
        return playlistitem.title;
    }

    static String c(PlaylistItem playlistitem)
    {
        return playlistitem.artist;
    }

    static PlayerItemStatus d(PlaylistItem playlistitem)
    {
        return playlistitem.status;
    }

    static Stores e(PlaylistItem playlistitem)
    {
        return playlistitem.storeData;
    }

    static String f(PlaylistItem playlistitem)
    {
        return playlistitem.key;
    }

    static ProviderPlaybackIds g(PlaylistItem playlistitem)
    {
        return playlistitem.providerPlaybackIds;
    }

    static Streams h(PlaylistItem playlistitem)
    {
        return playlistitem.streams;
    }

    public final ProviderPlaybackIds a()
    {
        if (providerPlaybackIds != null)
        {
            return providerPlaybackIds;
        } else
        {
            return ProviderPlaybackIds.Builder.a().b();
        }
    }
}
