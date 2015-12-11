// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.b.a.a;
import com.shazam.model.Actions;
import com.shazam.model.news.TvFeedCard;
import com.shazam.o.k;
import com.shazam.server.response.news.Content;
import com.shazam.server.response.news.Dimensions;
import com.shazam.server.response.news.FeedCard;
import com.shazam.server.response.news.Image;
import com.shazam.server.response.news.Overlays;
import java.util.Map;

public final class m
    implements a
{

    private final a a;

    public m(a a1)
    {
        a = a1;
    }

    public final Object a(Object obj)
    {
        Object obj2 = (FeedCard)obj;
        Object obj1 = ((FeedCard) (obj2)).content;
        obj = com.shazam.model.news.TvFeedCard.Builder.a();
        obj.id = ((FeedCard) (obj2)).id;
        obj.timestamp = ((FeedCard) (obj2)).timestamp;
        obj.actions = (Actions)a.a(obj2);
        obj2 = k.b(((FeedCard) (obj2)).beaconData);
        ((com.shazam.model.news.TvFeedCard.Builder) (obj)).beaconData.clear();
        ((com.shazam.model.news.TvFeedCard.Builder) (obj)).beaconData.putAll(((Map) (obj2)));
        obj2 = ((Content) (obj1)).image;
        if (obj2 != null)
        {
            obj.image = ((Image) (obj2)).url;
            obj2 = ((Image) (obj2)).dimensions;
            if (obj2 != null)
            {
                obj.imageRatio = (float)((Dimensions) (obj2)).height / (float)((Dimensions) (obj2)).width;
            }
        }
        obj1 = ((Content) (obj1)).overlays;
        if (obj1 != null)
        {
            obj.overlayTitle = ((Overlays) (obj1)).title;
            obj.overlayBody = ((Overlays) (obj1)).subtitle;
            obj.overlayDecoration = ((Overlays) (obj1)).decoration;
            obj1 = ((Overlays) (obj1)).image;
            if (obj1 != null)
            {
                obj.overlayImage = ((Image) (obj1)).url;
                obj1 = ((Image) (obj1)).dimensions;
                if (obj1 != null)
                {
                    obj.overlayImageRatio = (float)((Dimensions) (obj1)).height / (float)((Dimensions) (obj1)).width;
                }
            }
        }
        return new TvFeedCard(((com.shazam.model.news.TvFeedCard.Builder) (obj)));
    }
}
