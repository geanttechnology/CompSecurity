// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.dnm;

import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONObject;

// Referenced classes of package com.bestbuy.android.api.lib.models.dnm:
//            DNMProduct, DNMFacetFilter, DNMFacet, DNMSortOption

public class DNMResponse
    implements Serializable
{

    private static final long serialVersionUID = 1L;
    private ArrayList bbyProducts;
    private boolean corrected;
    private String correctedTerm;
    private ArrayList dnmProducts;
    private String errorMsg;
    private ArrayList facetsFilters;
    private String msvPageType;
    private String originalTerm;
    private String pageType;
    private String phoneNumber;
    private ArrayList productSkus;
    private ArrayList selectedFilters;
    private ArrayList sortOptions;
    private String storeAddress;
    private String storeName;
    private boolean termRemovedSinceNoResults;
    private int totalCount;

    public DNMResponse()
    {
    }

    public static DNMResponse loadDNMData(JSONObject jsonobject)
    {
        DNMResponse dnmresponse = new DNMResponse();
        dnmresponse.storeName = jsonobject.optString("storeName");
        dnmresponse.errorMsg = jsonobject.optString("errorMsg");
        dnmresponse.pageType = jsonobject.optString("pageType");
        dnmresponse.msvPageType = jsonobject.optString("msvPageType");
        dnmresponse.phoneNumber = jsonobject.optString("phoneNumber");
        dnmresponse.totalCount = jsonobject.optInt("totalCount");
        if (jsonobject.optJSONArray("itemList") != null)
        {
            dnmresponse.dnmProducts = DNMProduct.loadDNMProducts(jsonobject.optJSONArray("itemList"));
        }
        if (jsonobject.optJSONArray("selectedFacets") != null)
        {
            dnmresponse.selectedFilters = DNMFacetFilter.loadSelectedFilterData(jsonobject.optJSONArray("selectedFacets"));
        }
        if (jsonobject.optJSONArray("facets") != null)
        {
            dnmresponse.facetsFilters = DNMFacet.loadDNMFacetsData(jsonobject.optJSONArray("facets"));
        }
        dnmresponse.sortOptions = DNMSortOption.loadSortOptions();
        dnmresponse.productSkus = new ArrayList();
        if (dnmresponse.dnmProducts != null)
        {
            for (int i = 0; i < dnmresponse.dnmProducts.size(); i++)
            {
                DNMProduct dnmproduct = (DNMProduct)dnmresponse.dnmProducts.get(i);
                dnmresponse.productSkus.add(dnmproduct.getSkuId());
            }

        }
        if (jsonobject.optJSONObject("searchTerm") != null)
        {
            jsonobject = jsonobject.optJSONObject("searchTerm");
            dnmresponse.correctedTerm = jsonobject.optString("correctedTerm", "");
            dnmresponse.originalTerm = jsonobject.optString("originalTerm", "");
            dnmresponse.corrected = jsonobject.optBoolean("corrected");
            dnmresponse.termRemovedSinceNoResults = jsonobject.optBoolean("termRemovedSinceNoResults");
        }
        return dnmresponse;
    }

    public String getCorrectedTerm()
    {
        return correctedTerm;
    }

    public ArrayList getDnmProducts()
    {
        return dnmProducts;
    }

    public String getErrorMsg()
    {
        return errorMsg;
    }

    public ArrayList getFacetsFilters()
    {
        return facetsFilters;
    }

    public String getMsvPageType()
    {
        return msvPageType;
    }

    public String getOriginalTerm()
    {
        return originalTerm;
    }

    public String getPageType()
    {
        return pageType;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public ArrayList getProductSkus()
    {
        return productSkus;
    }

    public ArrayList getProducts()
    {
        return bbyProducts;
    }

    public ArrayList getSelectedFilters()
    {
        return selectedFilters;
    }

    public ArrayList getSortOptions()
    {
        return sortOptions;
    }

    public String getStoreAddress()
    {
        return storeAddress;
    }

    public String getStoreName()
    {
        return storeName;
    }

    public int getTotalCount()
    {
        return totalCount;
    }

    public boolean isCorrected()
    {
        return corrected;
    }

    public boolean isTermRemovedSinceNoResults()
    {
        return termRemovedSinceNoResults;
    }

    public void setBbyProducts(ArrayList arraylist)
    {
        bbyProducts = arraylist;
    }

    public void setDnmProducts(ArrayList arraylist)
    {
        dnmProducts = arraylist;
    }

    public void setTotalCount(int i)
    {
        totalCount = i;
    }
}
