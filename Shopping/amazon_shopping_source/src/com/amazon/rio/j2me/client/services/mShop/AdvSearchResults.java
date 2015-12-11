// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class AdvSearchResults
{

    private Integer availableCount;
    private List breadcrumbs;
    private String filters;
    private String query;
    private List refinements;
    private List results;
    private List resultsDesc;
    private List sortOptions;
    private List stubs;
    private Integer totalCount;

    public AdvSearchResults()
    {
    }

    public Integer getAvailableCount()
    {
        return availableCount;
    }

    public List getBreadcrumbs()
    {
        return breadcrumbs;
    }

    public String getFilters()
    {
        return filters;
    }

    public String getQuery()
    {
        return query;
    }

    public List getRefinements()
    {
        return refinements;
    }

    public List getResults()
    {
        return results;
    }

    public List getResultsDesc()
    {
        return resultsDesc;
    }

    public List getSortOptions()
    {
        return sortOptions;
    }

    public Integer getTotalCount()
    {
        return totalCount;
    }

    public void setAvailableCount(Integer integer)
    {
        availableCount = integer;
    }

    public void setBreadcrumbs(List list)
    {
        breadcrumbs = list;
    }

    public void setFilters(String s)
    {
        filters = s;
    }

    public void setQuery(String s)
    {
        query = s;
    }

    public void setRefinements(List list)
    {
        refinements = list;
    }

    public void setResults(List list)
    {
        results = list;
    }

    public void setResultsDesc(List list)
    {
        resultsDesc = list;
    }

    public void setSortOptions(List list)
    {
        sortOptions = list;
    }

    public void setStubs(List list)
    {
        stubs = list;
    }

    public void setTotalCount(Integer integer)
    {
        totalCount = integer;
    }
}
