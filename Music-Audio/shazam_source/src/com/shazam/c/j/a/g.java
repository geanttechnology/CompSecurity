// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.b.a.a;
import com.shazam.model.news.FeedCardType;
import com.shazam.server.response.news.FeedCard;
import java.util.Map;

public final class g
    implements a
{

    private final Map a;

    public g(Map map)
    {
        a = map;
    }

    public final Object a(Object obj)
    {
        obj = (FeedCard)obj;
        FeedCardType feedcardtype = FeedCardType.from(((FeedCard) (obj)).type);
        if (a.get(feedcardtype) == null)
        {
            (new StringBuilder("No converter for newscard type=")).append(feedcardtype.name());
        }
        return (com.shazam.model.news.FeedCard)((a)a.get(feedcardtype)).a(obj);
    }
}
