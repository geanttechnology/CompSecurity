// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.solr;

import java.io.Serializable;
import java.util.HashMap;

// Referenced classes of package com.bestbuy.android.api.lib.models.solr:
//            CategoryFacet, SortOption

public class SolrRequestInfo
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private CategoryFacet categoryFacet;
    private String queryString;
    private HashMap requestedFacets;
    private SortOption sortOption;

    public SolrRequestInfo()
    {
    }

    public CategoryFacet getCategoryFacet()
    {
        return categoryFacet;
    }

    public String getQueryString()
    {
        return queryString;
    }

    public HashMap getRequestedFacets()
    {
        return requestedFacets;
    }

    public SortOption getSortOption()
    {
        return sortOption;
    }

    public void setCategoryFacet(CategoryFacet categoryfacet)
    {
        categoryFacet = categoryfacet;
    }

    public void setQueryString(String s)
    {
        queryString = s;
    }

    public void setRequestedFacets(HashMap hashmap)
    {
        requestedFacets = hashmap;
    }

    public void setSortOption(SortOption sortoption)
    {
        sortOption = sortoption;
    }
}
