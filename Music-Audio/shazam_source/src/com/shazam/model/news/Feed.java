// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.news;

import java.net.URL;
import java.util.Collections;
import java.util.List;

public class Feed
{

    private List feedCards;
    public URL olderItemsUrl;
    public String scrollHint;

    private Feed()
    {
    }

    private Feed(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        scrollHint = Builder.a(builder);
        feedCards = Builder.b(builder);
        olderItemsUrl = Builder.c(builder);
    }

    public Feed(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }

    public final List a()
    {
        if (feedCards == null)
        {
            return Collections.emptyList();
        } else
        {
            return feedCards;
        }
    }
}
