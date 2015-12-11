// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.fragment.news;

import com.shazam.android.persistence.n.b;
import com.shazam.model.news.CardDismisser;

public final class n
    implements CardDismisser
{

    private final b a;

    public n(b b1)
    {
        a = b1;
    }

    private static String c(String s)
    {
        return (new StringBuilder()).append(s).append(",").toString();
    }

    public final void a(String s)
    {
        a.b("pk_news_feed_dismissed_cards", c(s));
    }

    public final boolean b(String s)
    {
        return a.a("pk_news_feed_dismissed_cards", "").contains(c(s));
    }
}
