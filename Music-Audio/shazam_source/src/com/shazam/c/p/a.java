// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.p;

import com.shazam.model.TrackLayoutType;
import com.shazam.model.tag.MiniTagResultItem;
import java.util.Collections;

public final class a
    implements com.shazam.b.a.a
{

    public a()
    {
    }

    public final Object a(Object obj)
    {
        obj = (MiniTagResultItem)obj;
        com.shazam.model.Tag.Builder builder = com.shazam.model.Tag.Builder.a();
        builder.eventId = ((MiniTagResultItem) (obj)).tagId;
        com.shazam.model.Track.Builder builder1 = com.shazam.model.Track.Builder.a();
        builder1.isFull = false;
        builder1.id = ((MiniTagResultItem) (obj)).trackId;
        builder1.title = ((MiniTagResultItem) (obj)).title;
        builder1.artistName = ((MiniTagResultItem) (obj)).artist;
        Object obj1 = com.shazam.model.Art.Builder.a();
        obj1.artUrl = ((MiniTagResultItem) (obj)).coverArtUrl;
        builder1.art = ((com.shazam.model.Art.Builder) (obj1)).b();
        obj1 = com.shazam.model.store.Stores.Builder.a();
        obj1.stores = Collections.singletonList(((MiniTagResultItem) (obj)).store);
        builder1.stores = ((com.shazam.model.store.Stores.Builder) (obj1)).b();
        builder1.trackLayoutType = TrackLayoutType.MUSIC;
        builder.track = builder1.b();
        return builder.b();
    }
}
