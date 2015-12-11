// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.b.a.a;
import com.shazam.model.Actions;
import com.shazam.model.news.WhatsNewFeedCard;
import com.shazam.o.k;
import com.shazam.server.response.news.Content;
import com.shazam.server.response.news.FeedCard;
import java.util.Map;

public final class o
    implements a
{

    private final a a;

    public o(a a1)
    {
        a = a1;
    }

    public final Object a(Object obj)
    {
        obj = (FeedCard)obj;
        com.shazam.model.news.WhatsNewFeedCard.Builder builder = com.shazam.model.news.WhatsNewFeedCard.Builder.a();
        builder.timestamp = ((FeedCard) (obj)).timestamp;
        builder.id = ((FeedCard) (obj)).id;
        builder.actions = (Actions)a.a(obj);
        Map map = k.b(((FeedCard) (obj)).beaconData);
        builder.beaconData.clear();
        builder.beaconData.putAll(map);
        if (((FeedCard) (obj)).content != null)
        {
            builder.body = ((FeedCard) (obj)).content.body;
            builder.title = ((FeedCard) (obj)).content.headline;
        }
        return new WhatsNewFeedCard(builder, null);
    }
}
