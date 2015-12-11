// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.b.a.a;
import com.shazam.model.Actions;
import com.shazam.o.k;
import com.shazam.server.response.news.Content;
import com.shazam.server.response.news.FeedCard;

public final class f
    implements a
{

    private final a a;

    public f(a a1)
    {
        a = a1;
    }

    public final Object a(Object obj)
    {
        obj = (FeedCard)obj;
        com.shazam.model.news.ChartFeedCard.Builder builder = com.shazam.model.news.ChartFeedCard.Builder.a();
        builder.id = ((FeedCard) (obj)).id;
        builder.timestamp = ((FeedCard) (obj)).timestamp;
        builder.url = ((FeedCard) (obj)).content.url;
        builder.title = ((FeedCard) (obj)).content.headline;
        builder.hideHeader = ((FeedCard) (obj)).content.hideHeader;
        builder.actions = (Actions)a.a(obj);
        return builder.a(k.b(((FeedCard) (obj)).beaconData)).b();
    }
}
