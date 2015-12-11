// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.k;

import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.player.PlaylistItemStatusChecker;
import com.shazam.model.player.ProviderPlaybackIdsExtractor;
import com.shazam.model.store.OrderedPurchaseOptions;
import com.shazam.model.store.Store;
import com.shazam.model.store.Stores;
import com.shazam.server.response.chart.ChartTrack;
import com.shazam.server.response.chart.DefaultImage;
import com.shazam.server.response.details.Heading;
import com.shazam.server.response.play.Streams;

public final class a
    implements com.shazam.b.a.a
{

    private final OrderedPurchaseOptions a;
    private final PlaylistItemStatusChecker b;
    private final ProviderPlaybackIdsExtractor c;

    public a(OrderedPurchaseOptions orderedpurchaseoptions, PlaylistItemStatusChecker playlistitemstatuschecker, ProviderPlaybackIdsExtractor providerplaybackidsextractor)
    {
        a = orderedpurchaseoptions;
        b = playlistitemstatuschecker;
        c = providerplaybackidsextractor;
    }

    public final Object a(Object obj)
    {
        Object obj2 = null;
        ChartTrack charttrack = (ChartTrack)obj;
        obj = a;
        Object obj1 = charttrack.stores;
        Object obj3 = com.shazam.model.store.StoreAnalyticsInfo.Builder.a();
        obj3.key = charttrack.key;
        obj3.screenName = ScreenOrigin.PLAYER.value;
        obj3 = ((OrderedPurchaseOptions) (obj)).a(((java.util.Map) (obj1)), ((com.shazam.model.store.StoreAnalyticsInfo.Builder) (obj3)).b(), charttrack.urlParams);
        obj = ((Stores) (obj3)).a();
        com.shazam.model.player.ProviderPlaybackIds providerplaybackids;
        com.shazam.model.player.PlaylistItem.Builder builder;
        if (obj == null)
        {
            if (charttrack.defaultImage == null)
            {
                obj = null;
            } else
            {
                obj = charttrack.defaultImage.url;
            }
        } else
        {
            obj = ((Store) (obj)).coverArt;
        }
        if (charttrack.streams == null)
        {
            obj1 = Streams.EMPTY;
        } else
        {
            obj1 = charttrack.streams;
        }
        providerplaybackids = c.a(((Streams) (obj1)), com.shazam.model.store.OrderedStores.Builder.a(((Stores) (obj3))).a());
        builder = com.shazam.model.player.PlaylistItem.Builder.a();
        builder.streams = ((Streams) (obj1));
        builder.key = charttrack.key;
        if (charttrack.heading == null)
        {
            obj1 = null;
        } else
        {
            obj1 = charttrack.heading.title;
        }
        builder.title = ((String) (obj1));
        if (charttrack.heading == null)
        {
            obj1 = obj2;
        } else
        {
            obj1 = charttrack.heading.subtitle;
        }
        builder.artist = ((String) (obj1));
        builder.coverArtUrl = ((String) (obj));
        builder.providerPlaybackIds = providerplaybackids;
        builder.storeData = ((Stores) (obj3));
        builder.status = b.a(charttrack.key);
        return builder.b();
    }
}
