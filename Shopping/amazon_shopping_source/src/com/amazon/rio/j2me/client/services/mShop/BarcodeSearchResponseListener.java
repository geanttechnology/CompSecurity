// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import com.amazon.rio.j2me.client.services.ResponseListener;
import com.amazon.rio.j2me.client.services.ServiceCall;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            SearchResultsCounts, SearchResult, QueryDescriptor

public interface BarcodeSearchResponseListener
    extends ResponseListener
{

    public abstract void aboutToReceiveArrayOfSize(int i, ServiceCall servicecall);

    public abstract void completed(ServiceCall servicecall);

    public abstract void receivedCounts(SearchResultsCounts searchresultscounts, ServiceCall servicecall);

    public abstract void receivedImage(byte abyte0[], int i, ServiceCall servicecall);

    public abstract void receivedMatchedItem(SearchResult searchresult, ServiceCall servicecall);

    public abstract void receivedMatchedItemThumbnail(byte abyte0[], ServiceCall servicecall);

    public abstract void receivedMatchedItemsReturned(Boolean boolean1, ServiceCall servicecall);

    public abstract void receivedQueryDescriptor(QueryDescriptor querydescriptor, ServiceCall servicecall);

    public abstract void receivedResultsTitle(String s, ServiceCall servicecall);

    public abstract void receivedSearchResult(SearchResult searchresult, int i, ServiceCall servicecall);
}
