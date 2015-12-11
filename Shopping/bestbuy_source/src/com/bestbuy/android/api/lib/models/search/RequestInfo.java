// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.search;

import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.api.lib.models.search:
//            CategoryFacets, Sort

public class RequestInfo
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private ArrayList appliedFacets;
    private CategoryFacets categoryFacet;
    private String query;
    private Sort sort;

    public RequestInfo()
    {
    }

    public ArrayList getAppliedFacets()
    {
        return appliedFacets;
    }

    public CategoryFacets getCategoryFacet()
    {
        return categoryFacet;
    }

    public String getQuery()
    {
        return query;
    }

    public Sort getSort()
    {
        return sort;
    }

    public void setAppliedFacets(ArrayList arraylist)
    {
        appliedFacets = arraylist;
    }

    public void setCategoryFacet(CategoryFacets categoryfacets)
    {
        categoryFacet = categoryfacets;
    }

    public void setQuery(String s)
    {
        query = s;
    }

    public void setSort(Sort sort1)
    {
        sort = sort1;
    }
}
