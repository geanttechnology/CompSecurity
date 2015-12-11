// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.b.a.a;
import com.shazam.model.news.SponsoredFeedCard;
import com.shazam.server.response.news.FeedCard;

public final class j
    implements a
{

    public j()
    {
    }

    public final Object a(Object obj)
    {
        obj = (FeedCard)obj;
        com.shazam.model.news.SponsoredFeedCard.Builder builder = com.shazam.model.news.SponsoredFeedCard.Builder.a();
        builder.id = ((FeedCard) (obj)).id;
        builder.providerName = ((FeedCard) (obj)).providerName;
        builder.siteKey = ((FeedCard) (obj)).siteKey;
        return new SponsoredFeedCard(builder, null);
    }
}
