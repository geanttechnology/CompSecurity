// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import com.google.common.collect.Sets;
import java.util.Set;

public class SearchQuery
{

    private final Set genreFilters = Sets.newHashSet();
    private final Set networkFilters = Sets.newHashSet();
    private String titleFilter;

    public SearchQuery()
    {
        titleFilter = "";
    }

    public void clear()
    {
        titleFilter = "";
        networkFilters.clear();
        genreFilters.clear();
    }

    public Set getGenreFilters()
    {
        return genreFilters;
    }

    public Set getNetworkFilters()
    {
        return networkFilters;
    }

    public Set getTagFilters()
    {
        return Sets.union(networkFilters, genreFilters);
    }

    public String getTitleFilter()
    {
        return titleFilter;
    }

    public boolean isEmpty()
    {
        return titleFilter.isEmpty() && getTagFilters().isEmpty();
    }

    public void setTitleFilter(String s)
    {
        titleFilter = s;
    }
}
