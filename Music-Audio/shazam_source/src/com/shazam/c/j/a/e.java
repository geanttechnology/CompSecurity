// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.b.a.a;
import com.shazam.model.Actions;
import com.shazam.model.Factory;
import com.shazam.model.news.TrackInfoCard;
import com.shazam.o.k;
import com.shazam.server.response.like.Like;
import com.shazam.server.response.news.Caption;
import com.shazam.server.response.news.Content;
import com.shazam.server.response.news.FeedCard;
import com.shazam.server.response.news.From;

public final class e
    implements a
{

    private final a a;
    private final Factory b;
    private final a c;

    public e(a a1, Factory factory, a a2)
    {
        a = a1;
        b = factory;
        c = a2;
    }

    public final Object a(Object obj)
    {
        FeedCard feedcard = (FeedCard)obj;
        com.shazam.model.news.ArtistPostFeedCard.Builder builder = com.shazam.model.news.ArtistPostFeedCard.Builder.a();
        obj = (TrackInfoCard)a.a(feedcard);
        Object obj1 = (a)b.create(obj);
        com.shazam.model.news.TagFeedCard.Builder builder1 = com.shazam.model.news.TagFeedCard.Builder.a();
        builder1.timestamp = feedcard.timestamp;
        builder1.id = feedcard.id;
        builder1.urlParams = feedcard.urlParams;
        builder1.trackInfoCard = ((TrackInfoCard) (obj));
        builder1.actions = (Actions)((a) (obj1)).a(feedcard);
        obj = builder1.a(k.b(feedcard.beaconData));
        obj1 = feedcard.content;
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
        builder.tagNewsCardBuilder = ((com.shazam.model.news.TagFeedCard.Builder) (obj));
        obj1 = c;
        if (feedcard.like == null)
        {
            obj = Like.EMPTY;
        } else
        {
            obj = feedcard.like;
        }
        builder.like = (com.shazam.model.like.Like)((a) (obj1)).a(obj);
        if (feedcard.content != null && feedcard.content.caption != null)
        {
            builder.captionText = feedcard.content.caption.text;
        }
        return builder.b();
    }
}
