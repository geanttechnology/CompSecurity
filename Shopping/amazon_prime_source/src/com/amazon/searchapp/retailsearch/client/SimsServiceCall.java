// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.HttpMethod;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.client.web.ServiceException;
import com.amazon.searchapp.retailsearch.model.SearchResult;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            RetailSearchServiceCall, SearchParameterName, RetailSearchClient

public class SimsServiceCall extends RetailSearchServiceCall
{

    private final String asin;
    private final int maxResults;
    private final String merchantId;

    public SimsServiceCall(RetailSearchClient retailsearchclient, ServiceCallListener servicecalllistener, String s, int i, String s1)
    {
        super(retailsearchclient, servicecalllistener, HttpMethod.GET.getName(), "/s/sims", com/amazon/searchapp/retailsearch/model/SearchResult);
        asin = s;
        maxResults = i;
        merchantId = s1;
    }

    protected void buildParameters(CollectionMap collectionmap)
        throws ServiceException
    {
        if (asin != null)
        {
            collectionmap.add(SearchParameterName.ASINS.getName(), asin);
        }
        if (maxResults > 0)
        {
            collectionmap.add("maxResults", String.valueOf(maxResults));
        }
        if (merchantId != null && !merchantId.isEmpty())
        {
            collectionmap.add("sims-merchant-id", merchantId);
        }
        collectionmap.set(SearchParameterName.IMAGE_RESOLUTION.getName(), "0");
        super.buildParameters(collectionmap);
    }
}
