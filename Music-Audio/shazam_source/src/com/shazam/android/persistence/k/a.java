// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.persistence.k;

import com.shazam.android.persistence.n.b;
import com.shazam.j.c;
import com.shazam.k.o;
import com.shazam.model.news.Feed;

public final class a
    implements o
{

    private final b b;
    private final com.shazam.j.b c;

    public a(b b1, com.shazam.j.b b2)
    {
        b = b1;
        c = b2;
    }

    public final Feed a()
    {
        Object obj;
        obj = b.h("pk_news_feed_repository");
        if (!com.shazam.b.e.a.c(((String) (obj))))
        {
            break MISSING_BLOCK_LABEL_38;
        }
        obj = (Feed)c.a(((String) (obj)), com/shazam/model/news/Feed);
        return ((Feed) (obj));
        c c1;
        c1;
        return null;
    }

    public final void a(Feed feed)
    {
        try
        {
            b.b("pk_news_feed_repository", c.a(feed));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Feed feed)
        {
            return;
        }
    }

    public final void b()
    {
        b.i("pk_news_feed_repository");
    }
}
