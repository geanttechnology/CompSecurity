// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l;

import com.shazam.b.a.a;
import com.shazam.model.TrackLayoutType;
import com.shazam.model.player.PlaylistItem;

public final class p
    implements a
{

    public p()
    {
    }

    public final Object a(Object obj)
    {
        obj = (PlaylistItem)obj;
        com.shazam.model.Tag.Builder builder = com.shazam.model.Tag.Builder.a();
        com.shazam.model.Track.Builder builder1 = com.shazam.model.Track.Builder.a();
        builder1.isFull = false;
        builder1.streams = ((PlaylistItem) (obj)).streams;
        builder1.trackLayoutType = TrackLayoutType.MUSIC;
        builder1.id = ((PlaylistItem) (obj)).key;
        builder1.key = ((PlaylistItem) (obj)).key;
        builder1.title = ((PlaylistItem) (obj)).title;
        builder1.artistName = ((PlaylistItem) (obj)).artist;
        com.shazam.model.Art.Builder builder2 = com.shazam.model.Art.Builder.a();
        builder2.artUrl = ((PlaylistItem) (obj)).coverArtUrl;
        builder1.art = builder2.b();
        builder.track = builder1.b();
        return builder.b();
    }
}
