// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j;

import com.shazam.b.b.b;
import com.shazam.model.configuration.FacebookConfiguration;
import com.shazam.model.news.CardDismisser;
import com.shazam.server.response.news.Feed;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class a
    implements com.shazam.b.a.a
{

    final FacebookConfiguration a;
    final CardDismisser b;
    private final com.shazam.b.a.a c;

    public a(com.shazam.b.a.a a1, FacebookConfiguration facebookconfiguration, CardDismisser carddismisser)
    {
        c = a1;
        a = facebookconfiguration;
        b = carddismisser;
    }

    public final Object a(Object obj)
    {
        Feed feed = (Feed)obj;
        java.net.URL url;
        com.shazam.model.news.Feed.Builder builder;
        if (feed.feedCards == null)
        {
            obj = Collections.emptyList();
        } else
        {
            obj = feed.feedCards;
        }
        obj = new ArrayList(com.shazam.b.b.b.a(((java.util.Collection) (obj)), new _cls1()));
        obj = (List)c.a(obj);
        url = com.shazam.b.c.a.a(feed.previous);
        builder = com.shazam.model.news.Feed.Builder.a();
        builder.scrollHint = feed.scrollHint;
        builder.feedCards.clear();
        builder.feedCards.addAll(((java.util.Collection) (obj)));
        builder.olderItemsUrl = url;
        return new com.shazam.model.news.Feed(builder, null);
    }

    /* member class not found */
    class _cls1 {}

}
