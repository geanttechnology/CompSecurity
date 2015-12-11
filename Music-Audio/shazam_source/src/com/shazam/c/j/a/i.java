// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.b.a.a;
import com.shazam.model.news.SocialLoginFeedCard;
import com.shazam.o.k;
import com.shazam.server.response.news.FeedCard;
import java.util.Map;

public final class i
    implements a
{

    public i()
    {
    }

    public final Object a(Object obj)
    {
        Object obj1 = (FeedCard)obj;
        obj = com.shazam.model.news.SocialLoginFeedCard.Builder.a();
        obj.id = ((FeedCard) (obj1)).id;
        obj1 = k.b(((FeedCard) (obj1)).beaconData);
        ((com.shazam.model.news.SocialLoginFeedCard.Builder) (obj)).beaconData.clear();
        ((com.shazam.model.news.SocialLoginFeedCard.Builder) (obj)).beaconData.putAll(((Map) (obj1)));
        return new SocialLoginFeedCard(((com.shazam.model.news.SocialLoginFeedCard.Builder) (obj)), null);
    }
}
