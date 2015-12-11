// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c;

import com.shazam.b.a.a;
import com.shazam.model.gimbal.AlternativeTrack;
import com.shazam.model.player.ProviderPlaybackIdsExtractor;
import com.shazam.model.store.Stores;
import com.shazam.server.legacy.track.ContextAwareTrack;

public final class e
    implements a
{

    private final ProviderPlaybackIdsExtractor a;
    private final a b;

    public e(ProviderPlaybackIdsExtractor providerplaybackidsextractor, a a1)
    {
        a = providerplaybackidsextractor;
        b = a1;
    }

    public final Object a(Object obj)
    {
        Object obj1 = (ContextAwareTrack)obj;
        obj = com.shazam.model.gimbal.AlternativeTrack.Builder.a();
        obj.id = ((ContextAwareTrack) (obj1)).getId();
        obj.artist = ((ContextAwareTrack) (obj1)).getSubtitle();
        obj.title = ((ContextAwareTrack) (obj1)).getTitle();
        obj.image = ((ContextAwareTrack) (obj1)).getImage();
        obj.stores = (Stores)b.a(((ContextAwareTrack) (obj1)).getStores());
        com.shazam.model.player.PlaylistItem.Builder builder = com.shazam.model.player.PlaylistItem.Builder.a();
        builder.artist = ((ContextAwareTrack) (obj1)).getSubtitle();
        builder.key = ((ContextAwareTrack) (obj1)).getId();
        builder.streams = ((ContextAwareTrack) (obj1)).getStreams();
        builder.coverArtUrl = ((ContextAwareTrack) (obj1)).getImage();
        builder.title = ((ContextAwareTrack) (obj1)).getTitle();
        builder.providerPlaybackIds = a.a(((ContextAwareTrack) (obj1)).getStreams(), com.shazam.model.store.OrderedStores.Builder.a((Stores)b.a(((ContextAwareTrack) (obj1)).getStores())).a());
        obj1 = com.shazam.model.preview.PreviewViewData.Builder.a();
        obj1.playlistItem = builder.b();
        obj.previewViewData = ((com.shazam.model.preview.PreviewViewData.Builder) (obj1)).b();
        return new AlternativeTrack(((com.shazam.model.gimbal.AlternativeTrack.Builder) (obj)), null);
    }
}
