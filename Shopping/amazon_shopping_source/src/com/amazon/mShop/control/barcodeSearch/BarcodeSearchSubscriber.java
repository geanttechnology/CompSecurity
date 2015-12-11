// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.barcodeSearch;

import com.amazon.mShop.control.GenericSubscriber;
import com.amazon.rio.j2me.client.services.mShop.QueryDescriptor;
import com.amazon.rio.j2me.client.services.mShop.SearchResult;

public interface BarcodeSearchSubscriber
    extends GenericSubscriber
{

    public abstract void onCompleted();

    public abstract void onImageReceived(byte abyte0[], int i);

    public abstract void onMatchedItemReceived(SearchResult searchresult);

    public abstract void onMatchedItemThumbnailReceived(byte abyte0[]);

    public abstract void onMatchedItemsReturnedReceived(boolean flag);

    public abstract void onQueryDescriptorReceived(QueryDescriptor querydescriptor);

    public abstract void onResultsTitleReceived(String s);

    public abstract void onSearchResultReceived(SearchResult searchresult, int i);
}
