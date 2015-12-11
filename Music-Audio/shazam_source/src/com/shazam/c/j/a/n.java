// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.b.a.a;
import com.shazam.model.news.VideoFeedCard;
import com.shazam.o.k;
import com.shazam.server.response.news.Content;
import com.shazam.server.response.news.FeedCard;
import java.util.Map;

public final class n
    implements a
{

    public n()
    {
    }

    public final Object a(Object obj)
    {
        Object obj1 = (FeedCard)obj;
        obj = com.shazam.model.news.VideoFeedCard.Builder.a();
        obj.id = ((FeedCard) (obj1)).id;
        obj.headline = ((FeedCard) (obj1)).content.headline;
        obj.url = ((FeedCard) (obj1)).content.url;
        obj1 = k.b(((FeedCard) (obj1)).beaconData);
        ((com.shazam.model.news.VideoFeedCard.Builder) (obj)).beaconData.clear();
        ((com.shazam.model.news.VideoFeedCard.Builder) (obj)).beaconData.putAll(((Map) (obj1)));
        return new VideoFeedCard(((com.shazam.model.news.VideoFeedCard.Builder) (obj)), null);
    }
}
