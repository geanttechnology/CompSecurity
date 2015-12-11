// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.player;

import com.shazam.model.store.Stores;
import com.shazam.server.response.play.Streams;

// Referenced classes of package com.shazam.model.player:
//            PlaylistItem, PlayerItemStatus, ProviderPlaybackIds

public static class ultStatus
{

    public String artist;
    public String coverArtUrl;
    public String key;
    public ProviderPlaybackIds providerPlaybackIds;
    public PlayerItemStatus status;
    public Stores storeData;
    public Streams streams;
    public String title;

    public static ultStatus a()
    {
        return new <init>();
    }

    public static <init> a(PlaylistItem playlistitem)
    {
        <init> <init>1 = new <init>();
        <init>1.coverArtUrl = PlaylistItem.a(playlistitem);
        <init>1.title = PlaylistItem.b(playlistitem);
        <init>1.artist = PlaylistItem.c(playlistitem);
        <init>1.status = PlaylistItem.d(playlistitem);
        <init>1.storeData = PlaylistItem.e(playlistitem);
        <init>1.key = PlaylistItem.f(playlistitem);
        <init>1.providerPlaybackIds = PlaylistItem.g(playlistitem);
        <init>1.streams = PlaylistItem.h(playlistitem);
        return <init>1;
    }

    static String a(streams streams1)
    {
        return streams1.coverArtUrl;
    }

    static String b(coverArtUrl coverarturl)
    {
        return coverarturl.title;
    }

    static String c(title title1)
    {
        return title1.artist;
    }

    static PlayerItemStatus d(artist artist1)
    {
        return artist1.status;
    }

    static Stores e(status status1)
    {
        return status1.storeData;
    }

    static String f(storeData storedata)
    {
        return storedata.key;
    }

    static ProviderPlaybackIds g(key key1)
    {
        return key1.providerPlaybackIds;
    }

    static Streams h(providerPlaybackIds providerplaybackids)
    {
        return providerplaybackids.streams;
    }

    public final PlaylistItem b()
    {
        return new PlaylistItem(this, null);
    }

    public ()
    {
        status = PlayerItemStatus.defaultStatus();
    }
}
