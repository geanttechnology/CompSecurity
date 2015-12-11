// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.interaction;

import com.amazon.retailsearch.data.search.SearchLoader;

public class SearchCacheEntry
{

    private final long TTL;
    private boolean isPrefetching;
    private int key;
    private SearchLoader searchLoader;
    private final long time = System.nanoTime();

    public SearchCacheEntry(int i, SearchLoader searchloader, boolean flag, long l)
    {
        key = i;
        searchLoader = searchloader;
        isPrefetching = flag;
        TTL = l;
    }

    public int getKey()
    {
        return key;
    }

    public SearchLoader getSearchLoader()
    {
        return searchLoader;
    }

    public boolean isExpired()
    {
        return System.nanoTime() - time > TTL;
    }

    public boolean isPrefetching()
    {
        return isPrefetching;
    }
}
