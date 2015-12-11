// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.barcodeSearch;

import com.amazon.mShop.control.PagedListingBrowser;
import com.amazon.mShop.control.ServiceController;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.CategoryResult;
import com.amazon.rio.j2me.client.services.mShop.MShopService;
import com.amazon.rio.j2me.client.services.mShop.QueryDescriptor;
import com.amazon.rio.j2me.client.services.mShop.QueryResponseListener;
import com.amazon.rio.j2me.client.services.mShop.SearchRequest;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import com.amazon.rio.j2me.client.services.mShop.SearchResultsCounts;

public class BarcodeSearchBrowser extends PagedListingBrowser
    implements QueryResponseListener
{

    private QueryDescriptor descriptor;
    private int maxImageDimension;
    private int maximumAvailableCount;
    private int pageSize;

    public BarcodeSearchBrowser(QueryDescriptor querydescriptor, int i, int j, int k, int l)
    {
        super(i, j);
        descriptor = querydescriptor;
        pageSize = i;
        maxImageDimension = k;
        maximumAvailableCount = l;
    }

    public void receivedCategoryResult(CategoryResult categoryresult, int i, ServiceCall servicecall)
    {
    }

    public void receivedCounts(SearchResultsCounts searchresultscounts, ServiceCall servicecall)
    {
        availableCountReceived(Math.min(maximumAvailableCount, searchresultscounts.getAvailableCount()), servicecall);
    }

    public void receivedImage(byte abyte0[], int i, ServiceCall servicecall)
    {
        imageReceived(abyte0, i, servicecall);
    }

    public void receivedQueryDescriptor(QueryDescriptor querydescriptor, ServiceCall servicecall)
    {
    }

    public void receivedSearchResult(SearchResult searchresult, int i, ServiceCall servicecall)
    {
        objectReceived(searchresult, i, servicecall);
    }

    public void setQueryDescriptor(QueryDescriptor querydescriptor)
    {
        descriptor = querydescriptor;
    }

    protected ServiceCall startPageRequest(int i)
    {
        SearchRequest searchrequest = new SearchRequest();
        searchrequest.setSize(pageSize);
        searchrequest.setMaxImageDimension(maxImageDimension);
        searchrequest.setPage(i + 1);
        searchrequest.setReturnRefinements(Boolean.FALSE);
        searchrequest.setQueryDescriptor(descriptor);
        searchrequest.setCategoryRefinements(null);
        searchrequest.setQuery(null);
        searchrequest.setIncludeAddOnItems(Boolean.TRUE);
        return ServiceController.getMShopService().query(searchrequest, this);
    }
}
