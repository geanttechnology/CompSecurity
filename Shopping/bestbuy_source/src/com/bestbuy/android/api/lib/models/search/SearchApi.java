// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.search;

import com.bestbuy.android.api.lib.models.store.BBYStore;
import gu;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

// Referenced classes of package com.bestbuy.android.api.lib.models.search:
//            RequestInfo, SuggestQueryInfo, Track

public class SearchApi
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private ArrayList banners;
    public HashMap categoryMap;
    private ArrayList documents;
    private ArrayList facets;
    private boolean plpAvailabilityEnabled;
    private RequestInfo requestInfo;
    public HashMap requestedFacets;
    private ArrayList skuDetails;
    private ArrayList skuList;
    private ArrayList sortOptions;
    private BBYStore storeDetails;
    private SuggestQueryInfo suggestQueryInfo;
    private int total;
    private Track track;

    public SearchApi()
    {
        categoryMap = new HashMap();
        requestedFacets = new HashMap();
    }

    public ArrayList getBanners()
    {
        return banners;
    }

    public HashMap getCategoryMap()
    {
        return categoryMap;
    }

    public ArrayList getDocuments()
    {
        return documents;
    }

    public ArrayList getFacets()
    {
        return facets;
    }

    public RequestInfo getRequestInfo()
    {
        return requestInfo;
    }

    public HashMap getRequestedFacets()
    {
        return requestedFacets;
    }

    public ArrayList getSkuDetails()
    {
        return skuDetails;
    }

    public ArrayList getSkuList()
    {
        return skuList;
    }

    public ArrayList getSortOptions()
    {
        return sortOptions;
    }

    public BBYStore getStoreDetails()
    {
        return storeDetails;
    }

    public SuggestQueryInfo getSuggestQueryInfo()
    {
        return suggestQueryInfo;
    }

    public int getTotal()
    {
        return total;
    }

    public Track getTrack()
    {
        return track;
    }

    public boolean isPlpAvailabilityEnabled()
    {
        return plpAvailabilityEnabled;
    }

    public void setBanners(ArrayList arraylist)
    {
        banners = arraylist;
    }

    public void setCategoryMap(HashMap hashmap)
    {
        categoryMap = hashmap;
    }

    public void setDocuments(ArrayList arraylist)
    {
        documents = arraylist;
    }

    public void setFacets(ArrayList arraylist)
    {
        facets = arraylist;
    }

    public void setPlpAvailabilityEnabled(boolean flag)
    {
        plpAvailabilityEnabled = flag;
    }

    public void setRequestInfo(RequestInfo requestinfo)
    {
        requestInfo = requestinfo;
    }

    public void setRequestedFacets(HashMap hashmap)
    {
        requestedFacets = hashmap;
    }

    public void setSkuDetails(ArrayList arraylist)
    {
        skuDetails = arraylist;
    }

    public void setSkuList(ArrayList arraylist)
    {
        skuList = arraylist;
    }

    public void setSortOptions(ArrayList arraylist)
    {
        sortOptions = arraylist;
    }

    public void setStoreDetails(BBYStore bbystore)
    {
        storeDetails = bbystore;
    }

    public void setSuggestQueryInfo(SuggestQueryInfo suggestqueryinfo)
    {
        suggestQueryInfo = suggestqueryinfo;
    }

    public void setTotal(int i)
    {
        total = i;
    }

    public void setTrack(Track track1)
    {
        track = track1;
    }
}
