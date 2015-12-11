// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.b.a.a;
import com.shazam.model.analytics.ScreenOrigin;
import com.shazam.model.store.OrderedPurchaseOptions;
import com.shazam.server.response.news.FeedCard;
import com.shazam.server.response.news.card.Media;

public final class b
    implements a
{

    private final OrderedPurchaseOptions a;

    public b(OrderedPurchaseOptions orderedpurchaseoptions)
    {
        a = orderedpurchaseoptions;
    }

    public final Object a(Object obj)
    {
        obj = (FeedCard)obj;
        Object obj1 = com.shazam.model.store.StoreAnalyticsInfo.Builder.a();
        obj1.origin = ScreenOrigin.HOME;
        obj1.cardType = ((FeedCard) (obj)).type;
        obj1.eventId = ((FeedCard) (obj)).id;
        obj1.trackId = ((FeedCard) (obj)).id;
        obj1.key = ((FeedCard) (obj)).siteKey;
        obj1 = ((com.shazam.model.store.StoreAnalyticsInfo.Builder) (obj1)).b();
        if (((FeedCard) (obj)).media == null)
        {
            obj = Media.EMPTY;
        } else
        {
            obj = ((FeedCard) (obj)).media;
        }
        return a.a(((Media) (obj)).stores, ((com.shazam.model.store.StoreAnalyticsInfo) (obj1)), ((Media) (obj)).urlParams);
    }
}
