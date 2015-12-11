// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.client;

import com.amazon.searchapp.retailsearch.client.web.CollectionMap;
import com.amazon.searchapp.retailsearch.client.web.HttpMethod;
import com.amazon.searchapp.retailsearch.client.web.ServiceCallListener;
import com.amazon.searchapp.retailsearch.model.SearchResult;

// Referenced classes of package com.amazon.searchapp.retailsearch.client:
//            RetailSearchServiceCall, SearchParameterName, RetailSearchClient

public class SimsServiceCall extends RetailSearchServiceCall
{

    private final String asin;

    public SimsServiceCall(RetailSearchClient retailsearchclient, ServiceCallListener servicecalllistener, String s)
    {
        super(retailsearchclient, servicecalllistener, HttpMethod.GET.getName(), "/s/sims", com/amazon/searchapp/retailsearch/model/SearchResult);
        asin = s;
    }

    protected void buildParameters(CollectionMap collectionmap)
    {
        if (asin != null)
        {
            collectionmap.add(SearchParameterName.ASINS.getName(), asin);
        }
        super.buildParameters(collectionmap);
    }
}
