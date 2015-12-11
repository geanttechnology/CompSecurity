// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.c;

import com.shazam.b.a.a;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.chart.TrackV2;
import com.shazam.model.player.PlaylistItem;
import com.shazam.model.player.ProviderPlaybackIdsExtractor;
import com.shazam.model.store.OrderedPurchaseOptions;
import com.shazam.model.store.Stores;
import com.shazam.server.response.chart.ChartTrack;
import com.shazam.server.response.chart.DefaultImage;
import com.shazam.server.response.details.Heading;
import com.shazam.server.response.play.Stream;
import com.shazam.server.response.play.Streams;

public final class c
    implements a
{

    private final OrderedPurchaseOptions a;
    private final ProviderPlaybackIdsExtractor b;
    private final a c;

    public c(OrderedPurchaseOptions orderedpurchaseoptions, ProviderPlaybackIdsExtractor providerplaybackidsextractor, a a1)
    {
        a = orderedpurchaseoptions;
        b = providerplaybackidsextractor;
        c = a1;
    }

    public final Object a(Object obj)
    {
        boolean flag;
        ChartTrack charttrack = (ChartTrack)obj;
        obj = a;
        Object obj1 = charttrack.stores;
        Object obj2 = com.shazam.model.store.StoreAnalyticsInfo.Builder.a();
        obj2.key = charttrack.key;
        obj2.trackId = charttrack.key;
        obj2.campaign = charttrack.campaignId;
        obj2.origin = ScreenOrigin.HOME;
        Stores stores = ((OrderedPurchaseOptions) (obj)).a(((java.util.Map) (obj1)), ((com.shazam.model.store.StoreAnalyticsInfo.Builder) (obj2)).b(), charttrack.urlParams);
        com.shazam.model.chart.TrackV2.Builder builder;
        com.shazam.model.player.ProviderPlaybackIds providerplaybackids;
        if (charttrack.streams == null)
        {
            obj = Streams.EMPTY;
        } else
        {
            obj = charttrack.streams;
        }
        if (charttrack.heading == null)
        {
            obj1 = Heading.EMPTY;
        } else
        {
            obj1 = charttrack.heading;
        }
        if (charttrack.defaultImage == null)
        {
            obj2 = null;
        } else
        {
            obj2 = charttrack.defaultImage.url;
        }
        providerplaybackids = b.a(((Streams) (obj)), com.shazam.model.store.OrderedStores.Builder.a(stores).a());
        builder = com.shazam.model.chart.TrackV2.Builder.a();
        builder.stores = stores;
        builder.streams = ((Streams) (obj));
        builder.key = charttrack.key;
        builder.title = ((Heading) (obj1)).title;
        builder.artist = ((Heading) (obj1)).subtitle;
        builder.coverArtUrl = stores.a(((String) (obj2)));
        builder.providerPlaybackIds = providerplaybackids;
        if (stores == null)
        {
            break MISSING_BLOCK_LABEL_360;
        }
        if (com.shazam.b.e.a.c(stores.d())) goto _L2; else goto _L1
_L1:
        if (((Streams) (obj)).rdioStream == null)
        {
            obj = Stream.EMPTY;
        } else
        {
            obj = ((Streams) (obj)).rdioStream;
        }
        if (!com.shazam.b.e.a.c(((Stream) (obj)).trackId)) goto _L3; else goto _L2
_L2:
        flag = true;
_L4:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_360;
        }
        obj = com.shazam.model.preview.PreviewViewData.Builder.a();
        obj.matchCategory = charttrack.type;
        obj.beaconKey = charttrack.key;
        obj.campaign = charttrack.campaignId;
        obj.trackId = charttrack.key;
        obj.playlistItem = (PlaylistItem)c.a(charttrack);
        obj = ((com.shazam.model.preview.PreviewViewData.Builder) (obj)).b();
_L5:
        builder.previewViewData = ((com.shazam.model.preview.PreviewViewData) (obj));
        return new TrackV2(builder, null);
_L3:
        flag = false;
          goto _L4
        obj = null;
          goto _L5
    }
}
