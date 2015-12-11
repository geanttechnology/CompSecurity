// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

public class AdvSearchRequest
{

    private String clickStreamOrigin;
    private Integer count;
    private String filters;
    private Boolean includeAddOnItems;
    private Boolean isPrefetch;
    private Integer offset;
    private String query;
    private Boolean returnCorrections;
    private Boolean returnProducts;
    private Boolean returnRefinements;
    private Boolean returnStubs;
    private String sortId;
    private List toggleRefinements;

    public AdvSearchRequest()
    {
    }

    public String getClickStreamOrigin()
    {
        return clickStreamOrigin;
    }

    public Integer getCount()
    {
        return count;
    }

    public String getFilters()
    {
        return filters;
    }

    public Boolean getIncludeAddOnItems()
    {
        return includeAddOnItems;
    }

    public Boolean getIsPrefetch()
    {
        return isPrefetch;
    }

    public Integer getOffset()
    {
        return offset;
    }

    public String getQuery()
    {
        return query;
    }

    public Boolean getReturnCorrections()
    {
        return returnCorrections;
    }

    public Boolean getReturnProducts()
    {
        return returnProducts;
    }

    public Boolean getReturnRefinements()
    {
        return returnRefinements;
    }

    public Boolean getReturnStubs()
    {
        return returnStubs;
    }

    public String getSortId()
    {
        return sortId;
    }

    public List getToggleRefinements()
    {
        return toggleRefinements;
    }

    public void setClickStreamOrigin(String s)
    {
        clickStreamOrigin = s;
    }

    public void setCount(Integer integer)
    {
        count = integer;
    }

    public void setFilters(String s)
    {
        filters = s;
    }

    public void setIncludeAddOnItems(Boolean boolean1)
    {
        includeAddOnItems = boolean1;
    }

    public void setIsPrefetch(Boolean boolean1)
    {
        isPrefetch = boolean1;
    }

    public void setOffset(Integer integer)
    {
        offset = integer;
    }

    public void setQuery(String s)
    {
        query = s;
    }

    public void setReturnCorrections(Boolean boolean1)
    {
        returnCorrections = boolean1;
    }

    public void setReturnProducts(Boolean boolean1)
    {
        returnProducts = boolean1;
    }

    public void setReturnRefinements(Boolean boolean1)
    {
        returnRefinements = boolean1;
    }

    public void setReturnStubs(Boolean boolean1)
    {
        returnStubs = boolean1;
    }

    public void setSortId(String s)
    {
        sortId = s;
    }

    public void setToggleRefinements(List list)
    {
        toggleRefinements = list;
    }
}
