// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class AdvSearchSuggestionsRequest
{

    private String filters;
    private Integer maxDepartments;
    private Integer maxSuggestions;
    private String query;
    private List toggleRefinements;

    public AdvSearchSuggestionsRequest()
    {
    }

    public String getFilters()
    {
        return filters;
    }

    public Integer getMaxDepartments()
    {
        return maxDepartments;
    }

    public Integer getMaxSuggestions()
    {
        return maxSuggestions;
    }

    public String getQuery()
    {
        return query;
    }

    public List getToggleRefinements()
    {
        return toggleRefinements;
    }

    public void setMaxSuggestions(Integer integer)
    {
        maxSuggestions = integer;
    }

    public void setQuery(String s)
    {
        query = s;
    }
}
