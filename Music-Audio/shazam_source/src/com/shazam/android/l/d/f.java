// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.l.d;

import android.database.Cursor;
import com.shazam.b.a.a;
import com.shazam.j.b;
import com.shazam.j.c;
import com.shazam.model.Track;
import com.shazam.model.TrackLayoutType;
import com.shazam.model.TrackStyle;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.player.PlaybackProvider;
import com.shazam.model.player.PlaylistItem;
import com.shazam.model.player.ProviderPlaybackIds;
import com.shazam.model.player.ProviderPlaybackIdsExtractor;
import com.shazam.model.store.OrderedPurchaseOptions;
import com.shazam.model.store.Store;
import com.shazam.model.store.Stores;
import com.shazam.server.response.play.Streams;
import java.util.Map;

public final class f
    implements a
{

    private final OrderedPurchaseOptions a;
    private final b b;
    private final ProviderPlaybackIdsExtractor c;

    public f(OrderedPurchaseOptions orderedpurchaseoptions, b b1, ProviderPlaybackIdsExtractor providerplaybackidsextractor)
    {
        a = orderedpurchaseoptions;
        b = b1;
        c = providerplaybackidsextractor;
    }

    private Object a(String s, Class class1)
    {
        if (!com.shazam.b.e.a.b(s))
        {
            break MISSING_BLOCK_LABEL_22;
        }
        s = ((String) (b.a(s, class1)));
        return s;
        s;
        return null;
    }

    public final Object a(Object obj)
    {
        Object obj3 = (Cursor)obj;
        Long long1 = com.shazam.android.util.d.a.c(((Cursor) (obj3)), "timestamp");
        String s3 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "requestId");
        String s4 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "trackId");
        String s5 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "trackKey");
        String s8 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "beaconKey");
        Object obj4 = com.shazam.android.util.d.a.g(((Cursor) (obj3)), "trackType");
        String s9 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "campaign");
        String s6 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "title");
        boolean flag1 = com.shazam.android.util.d.a.i(((Cursor) (obj3)), "full");
        obj = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "artUrl");
        Object obj2 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "playWith");
        String s10 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "category");
        TrackStyle trackstyle = TrackStyle.from(com.shazam.android.util.d.a.a(((Cursor) (obj3)), "trackStyle"));
        Object obj1 = (Stores)a(com.shazam.android.util.d.a.a(((Cursor) (obj3)), "stores"), com/shazam/model/store/Stores);
        Object obj5 = (Map)a(com.shazam.android.util.d.a.a(((Cursor) (obj3)), "urlParams"), java/util/Map);
        String s7 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "artist");
        String s = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "likeKey");
        String s1 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "caption");
        String s2 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "postId");
        String s11 = com.shazam.android.util.d.a.a(((Cursor) (obj3)), "eventId");
        obj3 = com.shazam.model.Tag.Status.getStatusForName(com.shazam.android.util.d.a.a(((Cursor) (obj3)), "tagStatus"), null);
        obj2 = (Streams)a(((String) (obj2)), com/shazam/server/response/play/Streams);
        obj4 = TrackLayoutType.getByDatabaseId(((Integer) (obj4)), Track.a());
        Object obj6 = com.shazam.model.store.StoreAnalyticsInfo.Builder.a();
        obj6.trackId = s4;
        obj6.origin = ScreenOrigin.MY_SHAZAM;
        obj6.campaign = s9;
        if (com.shazam.b.e.a.c(s10))
        {
            obj6.trackCategory = s10;
        }
        if (trackstyle != null)
        {
            obj6.trackStyle = trackstyle.getStyle();
        }
        obj6 = ((com.shazam.model.store.StoreAnalyticsInfo.Builder) (obj6)).b();
        obj5 = a.a(((Stores) (obj1)), ((com.shazam.model.store.StoreAnalyticsInfo) (obj6)), ((Map) (obj5)));
        if (((Stores) (obj5)).a() != null && com.shazam.b.e.a.c(((Stores) (obj5)).a().coverArt))
        {
            obj = ((Stores) (obj5)).a().coverArt;
        }
        obj6 = com.shazam.model.player.PlaylistItem.Builder.a();
        obj6.artist = s7;
        obj6.coverArtUrl = ((String) (obj));
        obj6.key = s5;
        obj6.storeData = ((Stores) (obj5));
        obj6.title = s6;
        obj6.streams = ((Streams) (obj2));
        obj1 = obj2;
        if (obj2 == null)
        {
            obj1 = Streams.EMPTY;
        }
        obj2 = com.shazam.model.store.OrderedStores.Builder.a(((Stores) (obj5))).a();
        obj6.providerPlaybackIds = c.a(((Streams) (obj1)), ((com.shazam.model.store.OrderedStores) (obj2)));
        obj1 = ((com.shazam.model.player.PlaylistItem.Builder) (obj6)).b();
        boolean flag;
        if (com.shazam.b.e.a.a(((PlaylistItem) (obj1)).a().a(PlaybackProvider.PREVIEW)) && com.shazam.b.e.a.a(((PlaylistItem) (obj1)).a().a(PlaybackProvider.RDIO)) && com.shazam.b.e.a.a(((PlaylistItem) (obj1)).a().a(PlaybackProvider.SPOTIFY)))
        {
            obj1 = com.shazam.model.preview.PreviewViewData.Builder.a().b();
        } else
        {
            com.shazam.model.preview.PreviewViewData.Builder builder = com.shazam.model.preview.PreviewViewData.Builder.a();
            builder.trackId = s4;
            builder.beaconKey = s8;
            builder.campaign = s9;
            builder.eventId = s11;
            builder.matchCategory = s10;
            builder.screenOrigin = ScreenOrigin.MY_SHAZAM;
            builder.playlistItem = ((PlaylistItem) (obj1));
            obj1 = builder.b();
        }
        obj2 = com.shazam.model.myshazam.MyShazamTag.Builder.a();
        obj2.requestId = s3;
        obj2.timestamp = long1;
        obj2.trackId = s4;
        obj2.trackKey = s5;
        obj2.trackTitle = s6;
        obj2.artUrl = ((String) (obj));
        obj2.artistsDescription = s7;
        obj2.store = ((Stores) (obj5)).a();
        obj2.isFull = flag1;
        if (obj3 == com.shazam.model.Tag.Status.VISUAL && obj4 == TrackLayoutType.LOCAL_WEB)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        obj2.publishable = flag1;
        obj = null;
        if (com.shazam.b.e.a.c(s2))
        {
            obj = com.shazam.model.post.Post.Builder.a();
            obj.likeKey = s;
            obj.caption = s1;
            obj.uuid = s2;
            obj = ((com.shazam.model.post.Post.Builder) (obj)).b();
        }
        obj2.post = ((com.shazam.model.post.Post) (obj));
        obj2.trackStyle = trackstyle;
        obj2.previewViewData = ((com.shazam.model.preview.PreviewViewData) (obj1));
        return ((com.shazam.model.myshazam.MyShazamTag.Builder) (obj2)).b();
    }
}
