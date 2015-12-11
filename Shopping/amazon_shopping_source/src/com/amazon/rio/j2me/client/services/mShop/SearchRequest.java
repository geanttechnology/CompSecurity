// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            QueryDescriptor

public class SearchRequest
{

    private List categoryRefinements;
    private String clickStreamOrigin;
    private Boolean includeAddOnItems;
    private int maxImageDimension;
    private int page;
    private String query;
    private QueryDescriptor queryDescriptor;
    private Boolean returnRefinements;
    private int size;

    public SearchRequest()
    {
    }

    public List getCategoryRefinements()
    {
        return categoryRefinements;
    }

    public String getClickStreamOrigin()
    {
        return clickStreamOrigin;
    }

    public Boolean getIncludeAddOnItems()
    {
        return includeAddOnItems;
    }

    public int getMaxImageDimension()
    {
        return maxImageDimension;
    }

    public int getPage()
    {
        return page;
    }

    public String getQuery()
    {
        return query;
    }

    public QueryDescriptor getQueryDescriptor()
    {
        return queryDescriptor;
    }

    public Boolean getReturnRefinements()
    {
        return returnRefinements;
    }

    public int getSize()
    {
        return size;
    }

    public void setCategoryRefinements(List list)
    {
        categoryRefinements = list;
    }

    public void setClickStreamOrigin(String s)
    {
        clickStreamOrigin = s;
    }

    public void setIncludeAddOnItems(Boolean boolean1)
    {
        includeAddOnItems = boolean1;
    }

    public void setMaxImageDimension(int i)
    {
        maxImageDimension = i;
    }

    public void setPage(int i)
    {
        page = i;
    }

    public void setQuery(String s)
    {
        query = s;
    }

    public void setQueryDescriptor(QueryDescriptor querydescriptor)
    {
        queryDescriptor = querydescriptor;
    }

    public void setReturnRefinements(Boolean boolean1)
    {
        returnRefinements = boolean1;
    }

    public void setSize(int i)
    {
        size = i;
    }
}
