// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.search;

import java.util.List;

public class SearchResultList
{

    public String nextPage;
    public List results;
    public int total;

    public SearchResultList()
    {
    }

    private SearchResultList(Builder builder)
    {
    /* block-local class not found */
    class Builder {}

        total = Builder.a(builder);
        results = Builder.b(builder);
        nextPage = Builder.c(builder);
    }

    SearchResultList(Builder builder, _cls1 _pcls1)
    {
        this(builder);
    }
}
