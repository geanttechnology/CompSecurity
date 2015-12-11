// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.b.a.a;
import com.shazam.model.Actions;
import com.shazam.model.Factory;
import com.shazam.model.news.Content;
import com.shazam.model.news.TrackAnnouncementFeedCard;
import com.shazam.model.news.TrackInfoCard;
import com.shazam.o.k;
import com.shazam.server.response.news.FeedCard;
import java.util.Map;

public final class l
    implements a
{

    private final a a;
    private final a b;
    private final Factory c;

    public l(a a1, a a2, Factory factory)
    {
        a = a1;
        b = a2;
        c = factory;
    }

    public final Object a(Object obj)
    {
        Object obj1 = (FeedCard)obj;
        TrackInfoCard trackinfocard = (TrackInfoCard)b.a(obj1);
        a a1 = (a)c.create(trackinfocard);
        obj = com.shazam.model.news.TrackAnnouncementFeedCard.Builder.a();
        obj.id = ((FeedCard) (obj1)).id;
        obj.timestamp = ((FeedCard) (obj1)).timestamp;
        obj.content = (Content)a.a(((FeedCard) (obj1)).content);
        obj.trackInfo = trackinfocard;
        obj.actions = (Actions)a1.a(obj1);
        obj1 = k.b(((FeedCard) (obj1)).beaconData);
        ((com.shazam.model.news.TrackAnnouncementFeedCard.Builder) (obj)).beaconData.clear();
        ((com.shazam.model.news.TrackAnnouncementFeedCard.Builder) (obj)).beaconData.putAll(((Map) (obj1)));
        return new TrackAnnouncementFeedCard(((com.shazam.model.news.TrackAnnouncementFeedCard.Builder) (obj)), null);
    }
}
