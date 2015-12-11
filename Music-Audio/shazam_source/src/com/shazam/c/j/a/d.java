// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.b.a.a;
import com.shazam.model.Actions;
import com.shazam.model.news.ArtistJustJoinedFeedCard;
import com.shazam.o.k;
import com.shazam.server.response.follow.FollowData;
import com.shazam.server.response.news.Content;
import com.shazam.server.response.news.FeedCard;
import com.shazam.server.response.news.Image;
import com.shazam.server.response.news.card.Media;
import java.util.List;
import java.util.Map;

public final class d
    implements a
{

    private final a a;
    private final a b;
    private final a c;

    public d(a a1, a a2, a a3)
    {
        a = a1;
        b = a2;
        c = a3;
    }

    public final Object a(Object obj)
    {
        FeedCard feedcard = (FeedCard)obj;
        FollowData followdata;
        com.shazam.model.news.ArtistJustJoinedFeedCard.Builder builder;
        if (feedcard.media == null)
        {
            obj = Media.EMPTY;
        } else
        {
            obj = feedcard.media;
        }
        if (feedcard.followKey == null)
        {
            followdata = FollowData.EMPTY;
        } else
        {
            followdata = feedcard.followKey;
        }
        builder = com.shazam.model.news.ArtistJustJoinedFeedCard.Builder.a();
        builder.body = feedcard.content.body;
        builder.followData = (com.shazam.model.follow.FollowData)c.a(followdata);
        builder.headline = feedcard.content.headline;
        builder.id = feedcard.id;
        builder.imageUrl = feedcard.content.image.url;
        builder.timestamp = feedcard.timestamp;
        builder.actions = (Actions)a.a(feedcard);
        obj = (List)b.a(((Media) (obj)).tracks);
        builder.tracks.clear();
        builder.tracks.addAll(((java.util.Collection) (obj)));
        obj = k.b(feedcard.beaconData);
        builder.beaconData.clear();
        builder.beaconData.putAll(((Map) (obj)));
        return new ArtistJustJoinedFeedCard(builder, null);
    }
}
