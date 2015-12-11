// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.b.a.a;
import com.shazam.model.Actions;
import com.shazam.model.Factory;
import com.shazam.model.news.TrackInfoCard;
import com.shazam.server.response.news.Content;
import com.shazam.server.response.news.FeedCard;
import com.shazam.server.response.news.From;

public final class k
    implements a
{

    private final a a;
    private final Factory b;

    public k(a a1, Factory factory)
    {
        a = a1;
        b = factory;
    }

    public final Object a(Object obj)
    {
        Object obj1 = (FeedCard)obj;
        TrackInfoCard trackinfocard = (TrackInfoCard)a.a(obj1);
        obj = com.shazam.model.news.TagFeedCard.Builder.a();
        obj.timestamp = ((FeedCard) (obj1)).timestamp;
        obj.id = ((FeedCard) (obj1)).id;
        obj.urlParams = ((FeedCard) (obj1)).urlParams;
        obj.trackInfoCard = trackinfocard;
        obj = ((com.shazam.model.news.TagFeedCard.Builder) (obj)).a(com.shazam.o.k.b(((FeedCard) (obj1)).beaconData));
        obj.actions = (Actions)((a)b.create(trackinfocard)).a(obj1);
        obj1 = ((FeedCard) (obj1)).content;
        if (obj1 != null)
        {
            obj1 = ((Content) (obj1)).from;
            if (obj1 != null)
            {
                obj.authorId = ((From) (obj1)).id;
                obj.authorName = ((From) (obj1)).name;
                obj.authorImageUrl = ((From) (obj1)).avatar;
                obj.event = ((From) (obj1)).event;
            }
        }
        return ((com.shazam.model.news.TagFeedCard.Builder) (obj)).b();
    }
}
