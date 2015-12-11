// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j;

import com.shazam.b.a.a;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.follow.FollowData;
import com.shazam.model.player.ProviderPlaybackIdsExtractor;
import com.shazam.model.store.Store;
import com.shazam.model.store.Stores;
import com.shazam.server.response.news.Content;
import com.shazam.server.response.news.FeedCard;
import com.shazam.server.response.news.Image;
import com.shazam.server.response.news.Overlays;
import com.shazam.server.response.news.card.Media;
import com.shazam.server.response.news.card.MediaArtist;
import com.shazam.server.response.news.card.MediaTrack;
import com.shazam.server.response.play.Streams;
import java.util.List;

public final class b
    implements a
{

    private final a a;
    private final ProviderPlaybackIdsExtractor b;
    private final a c;

    public b(a a1, ProviderPlaybackIdsExtractor providerplaybackidsextractor, a a2)
    {
        a = a1;
        b = providerplaybackidsextractor;
        c = a2;
    }

    private static String a(FeedCard feedcard, Store store)
    {
        Object obj = null;
        if (store != null && com.shazam.b.e.a.c(store.coverArt))
        {
            feedcard = store.coverArt;
        } else
        {
            store = feedcard.content;
            feedcard = obj;
            if (store != null)
            {
                feedcard = obj;
                if (((Content) (store)).overlays != null)
                {
                    feedcard = obj;
                    if (((Content) (store)).overlays.image != null)
                    {
                        return ((Content) (store)).overlays.image.url;
                    }
                }
            }
        }
        return feedcard;
    }

    public final Object a(Object obj)
    {
        FeedCard feedcard = (FeedCard)obj;
        Stores stores = (Stores)a.a(feedcard);
        Store store = stores.a();
        Object obj1;
        com.shazam.model.news.TrackInfoCard.Builder builder;
        com.shazam.model.details.InteractiveInfo.Builder builder1;
        com.shazam.model.preview.PreviewViewData.Builder builder2;
        if (feedcard.media == null)
        {
            obj = Media.EMPTY;
        } else
        {
            obj = feedcard.media;
        }
        if (((Media) (obj)).track == null)
        {
            obj1 = MediaTrack.EMPTY;
        } else
        {
            obj1 = ((Media) (obj)).track;
        }
        builder = com.shazam.model.news.TrackInfoCard.Builder.a();
        builder.id = feedcard.id;
        builder.trackKey = ((MediaTrack) (obj1)).id;
        builder.coverArtUrl = a(feedcard, store);
        builder1 = com.shazam.model.details.InteractiveInfo.Builder.a();
        builder2 = com.shazam.model.preview.PreviewViewData.Builder.a();
        store = stores.a();
        if (store != null && com.shazam.b.e.a.c(store.previewUrl))
        {
            builder2.eventId = feedcard.id;
            builder2.screenOrigin = ScreenOrigin.HOME;
            Streams streams;
            Object obj2;
            if (((Media) (obj)).streams == null)
            {
                streams = Streams.EMPTY;
            } else
            {
                streams = ((Media) (obj)).streams;
            }
            obj2 = feedcard.content;
            if (obj2 != null && ((Content) (obj2)).overlays != null)
            {
                obj2 = ((Content) (obj2)).overlays;
                com.shazam.model.player.ProviderPlaybackIds providerplaybackids = b.a(streams, com.shazam.model.store.OrderedStores.Builder.a(stores).a());
                com.shazam.model.player.PlaylistItem.Builder builder3 = com.shazam.model.player.PlaylistItem.Builder.a();
                builder3.artist = ((Overlays) (obj2)).subtitle;
                builder3.key = ((MediaTrack) (obj1)).id;
                builder3.streams = streams;
                builder3.coverArtUrl = a(feedcard, stores.a());
                builder3.title = ((Overlays) (obj2)).title;
                builder3.providerPlaybackIds = providerplaybackids;
                obj1 = builder3.b();
            } else
            {
                obj1 = null;
            }
            builder2.playlistItem = ((com.shazam.model.player.PlaylistItem) (obj1));
        }
        builder1.previewViewData = builder2.b();
        builder1.stores = stores;
        obj = ((Media) (obj)).getMediaArtists();
        if (com.shazam.o.b.b(((java.util.Collection) (obj))))
        {
            obj = (MediaArtist)((List) (obj)).get(0);
            obj1 = com.shazam.model.follow.FollowData.Builder.a((FollowData)c.a(((MediaArtist) (obj)).follow));
            obj1.artistId = ((MediaArtist) (obj)).id;
            builder1.followData = ((com.shazam.model.follow.FollowData.Builder) (obj1)).b();
        }
        builder.interactiveInfo = builder1.b();
        obj = feedcard.content;
        if (obj != null)
        {
            obj = ((Content) (obj)).overlays;
            if (obj != null)
            {
                builder.trackArtist = ((Overlays) (obj)).subtitle;
                builder.trackTitle = ((Overlays) (obj)).title;
            }
        }
        return builder.b();
    }
}
