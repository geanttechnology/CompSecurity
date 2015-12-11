// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.b.a.a;
import com.shazam.model.Actions;
import com.shazam.model.news.Content;
import com.shazam.model.news.GeneralAnnouncementFeedCard;
import com.shazam.model.preview.PreviewViewDataUrlDecorator;
import com.shazam.model.store.Store;
import com.shazam.model.store.Stores;
import com.shazam.o.k;
import com.shazam.server.response.news.FeedCard;
import com.shazam.server.response.news.card.Media;
import com.shazam.server.response.news.card.MediaTrack;
import com.shazam.server.response.play.Streams;
import java.util.Map;

public final class h
    implements a
{

    private final a a;
    private final a b;
    private final PreviewViewDataUrlDecorator c;
    private final a d;

    public h(a a1, a a2, PreviewViewDataUrlDecorator previewviewdataurldecorator, a a3)
    {
        a = a1;
        b = a2;
        c = previewviewdataurldecorator;
        d = a3;
    }

    public final Object a(Object obj)
    {
        FeedCard feedcard = (FeedCard)obj;
        Stores stores = (Stores)a.a(feedcard);
        obj = stores.a();
        Object obj1;
        Object obj2;
        com.shazam.model.player.PlaylistItem.Builder builder;
        if (obj != null)
        {
            obj = ((Store) (obj)).coverArt;
        } else
        {
            obj = null;
        }
        if (feedcard.media == null)
        {
            obj2 = Media.EMPTY;
        } else
        {
            obj2 = feedcard.media;
        }
        if (((Media) (obj2)).streams == null)
        {
            obj1 = Streams.EMPTY;
        } else
        {
            obj1 = ((Media) (obj2)).streams;
        }
        if (((Media) (obj2)).track == null)
        {
            obj2 = MediaTrack.EMPTY;
        } else
        {
            obj2 = ((Media) (obj2)).track;
        }
        builder = com.shazam.model.player.PlaylistItem.Builder.a();
        builder.streams = ((Streams) (obj1));
        builder.title = ((MediaTrack) (obj2)).title;
        builder.artist = ((MediaTrack) (obj2)).subtitle;
        builder.key = ((MediaTrack) (obj2)).id;
        builder.coverArtUrl = ((String) (obj));
        obj1 = builder.b();
        obj = com.shazam.model.news.GeneralAnnouncementFeedCard.Builder.a();
        obj.id = feedcard.id;
        obj.timestamp = feedcard.timestamp;
        obj.content = (Content)b.a(feedcard.content);
        obj2 = com.shazam.model.details.InteractiveInfo.Builder.a();
        obj2.previewViewData = PreviewViewDataUrlDecorator.a(com.shazam.model.preview.PreviewViewData.Builder.a().b(), ((com.shazam.model.player.PlaylistItem) (obj1)), stores);
        obj2.stores = stores;
        obj.interactiveInfo = ((com.shazam.model.details.InteractiveInfo.Builder) (obj2)).b();
        obj.actions = (Actions)d.a(feedcard);
        obj1 = k.b(feedcard.beaconData);
        ((com.shazam.model.news.GeneralAnnouncementFeedCard.Builder) (obj)).beaconData.clear();
        ((com.shazam.model.news.GeneralAnnouncementFeedCard.Builder) (obj)).beaconData.putAll(((Map) (obj1)));
        return new GeneralAnnouncementFeedCard(((com.shazam.model.news.GeneralAnnouncementFeedCard.Builder) (obj)), null);
    }
}
