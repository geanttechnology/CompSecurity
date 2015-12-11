// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.k;

import com.shazam.b.a.a;
import com.shazam.model.chart.TrackV2;
import com.shazam.model.player.PlaylistItemStatusChecker;

public final class d
    implements a
{

    private final PlaylistItemStatusChecker a;

    public d(PlaylistItemStatusChecker playlistitemstatuschecker)
    {
        a = playlistitemstatuschecker;
    }

    public final Object a(Object obj)
    {
        obj = (TrackV2)obj;
        com.shazam.model.player.PlaylistItem.Builder builder = com.shazam.model.player.PlaylistItem.Builder.a();
        builder.streams = ((TrackV2) (obj)).streams;
        builder.key = ((TrackV2) (obj)).key;
        builder.title = ((TrackV2) (obj)).title;
        builder.artist = ((TrackV2) (obj)).artist;
        builder.coverArtUrl = ((TrackV2) (obj)).coverArtUrl;
        builder.providerPlaybackIds = ((TrackV2) (obj)).a();
        builder.storeData = ((TrackV2) (obj)).b();
        builder.status = a.a(((TrackV2) (obj)).key);
        return builder.b();
    }
}
