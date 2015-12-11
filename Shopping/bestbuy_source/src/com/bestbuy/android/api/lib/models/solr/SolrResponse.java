// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.solr;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.bestbuy.android.api.lib.models.solr:
//            SolrRequestInfo

public class SolrResponse
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private ArrayList bbyProducts;
    private HashMap categoryMap;
    private ArrayList facets;
    private SolrRequestInfo requestInfo;
    private ArrayList skuList;
    private ArrayList sortOptions;
    private int totalCount;

    public SolrResponse()
    {
        facets = new ArrayList();
        skuList = new ArrayList();
        bbyProducts = new ArrayList();
        sortOptions = new ArrayList();
        categoryMap = new HashMap();
    }

    public ArrayList getBbyProducts()
    {
        return bbyProducts;
    }

    public HashMap getCategoryMap()
    {
        return categoryMap;
    }

    public ArrayList getFacets()
    {
        return facets;
    }

    public SolrRequestInfo getRequestInfo()
    {
        return requestInfo;
    }

    public ArrayList getSkuList()
    {
        return skuList;
    }

    public ArrayList getSortOptions()
    {
        return sortOptions;
    }

    public int getTotalCount()
    {
        return totalCount;
    }

    public void setBbyProducts(ArrayList arraylist)
    {
        bbyProducts = arraylist;
    }

    public void setFacets(ArrayList arraylist)
    {
        facets = arraylist;
    }

    public void setRequestInfo(SolrRequestInfo solrrequestinfo)
    {
        requestInfo = solrrequestinfo;
    }

    public void setSkuList(ArrayList arraylist)
    {
        skuList = arraylist;
    }

    public void setSortOptions(ArrayList arraylist)
    {
        sortOptions = arraylist;
    }

    public void setTotalCount(int i)
    {
        totalCount = i;
    }
}
