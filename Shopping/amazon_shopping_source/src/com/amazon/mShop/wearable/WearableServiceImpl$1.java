// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.wearable;

import android.util.Log;
import com.amazon.rio.j2me.client.services.ServiceCall;
import com.amazon.rio.j2me.client.services.mShop.CategoryResult;
import com.amazon.rio.j2me.client.services.mShop.QueryDescriptor;
import com.amazon.rio.j2me.client.services.mShop.SearchResponseListener;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;
import com.amazon.rio.j2me.client.services.mShop.SearchResultsCounts;

// Referenced classes of package com.amazon.mShop.wearable:
//            WearableServiceImpl, SearchResultListener, RioSearchResultTransformer

class rmer
    implements SearchResponseListener
{

    final WearableServiceImpl this$0;
    final SearchResultListener val$listener;
    final RioSearchResultTransformer val$resultTransformer;

    public void aboutToReceiveArrayOfSize(int i, ServiceCall servicecall)
    {
    }

    public void cancelled(ServiceCall servicecall)
    {
        val$listener.onError("Failed query", null);
    }

    public void completed(ServiceCall servicecall)
    {
        val$listener.onSuccess();
    }

    public void error(Exception exception, ServiceCall servicecall)
    {
        Log.e(WearableServiceImpl.access$000(), "Failed to search", exception);
        val$listener.onError("Failed to query", exception);
    }

    public void receivedCategoryResult(CategoryResult categoryresult, int i, ServiceCall servicecall)
    {
    }

    public void receivedCounts(SearchResultsCounts searchresultscounts, ServiceCall servicecall)
    {
    }

    public void receivedImage(byte abyte0[], int i, ServiceCall servicecall)
    {
    }

    public void receivedQueryDescriptor(QueryDescriptor querydescriptor, ServiceCall servicecall)
    {
    }

    public void receivedSearchResult(SearchResult searchresult, int i, ServiceCall servicecall)
    {
        searchresult = val$resultTransformer.apply(searchresult);
        if (searchresult != null)
        {
            val$listener.onFoundProduct(searchresult);
        }
    }

    rmer()
    {
        this$0 = final_wearableserviceimpl;
        val$listener = searchresultlistener;
        val$resultTransformer = RioSearchResultTransformer.this;
        super();
    }
}
