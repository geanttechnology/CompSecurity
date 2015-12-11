// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.c.j.a;

import com.shazam.b.a.a;
import com.shazam.c.i;
import com.shazam.server.response.news.FeedCard;
import java.util.Collections;
import java.util.List;

public final class c
    implements a
{

    private final i a;

    public c(i j)
    {
        a = j;
    }

    public final Object a(Object obj)
    {
        FeedCard feedcard = (FeedCard)obj;
        com.shazam.model.Actions.Builder builder = com.shazam.model.Actions.Builder.a();
        i j = a;
        if (feedcard.actions == null)
        {
            obj = Collections.emptyList();
        } else
        {
            obj = feedcard.actions;
        }
        builder.actions = (List)j.a(obj);
        builder.urlParams = feedcard.urlParams;
        return builder.b();
    }
}
