// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


public class SearchSuggestion
{

    private Boolean autoSearch;
    private String department;
    private String filters;
    private String query;
    private String rawId;

    public SearchSuggestion()
    {
    }

    public Boolean getAutoSearch()
    {
        return autoSearch;
    }

    public String getDepartment()
    {
        return department;
    }

    public String getFilters()
    {
        return filters;
    }

    public String getQuery()
    {
        return query;
    }

    public void setAutoSearch(Boolean boolean1)
    {
        autoSearch = boolean1;
    }

    public void setDepartment(String s)
    {
        department = s;
    }

    public void setFilters(String s)
    {
        filters = s;
    }

    public void setQuery(String s)
    {
        query = s;
    }

    public void setRawId(String s)
    {
        rawId = s;
    }
}
