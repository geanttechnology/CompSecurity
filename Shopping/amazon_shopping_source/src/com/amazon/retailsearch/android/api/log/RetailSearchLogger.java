// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.log;

import com.amazon.retailsearch.data.assets.AssetFetchType;
import com.amazon.retailsearch.metrics.DetailPageType;
import com.amazon.searchapp.retailsearch.client.AssetsServiceCall;
import com.amazon.searchapp.retailsearch.client.SearchServiceCall;
import java.util.List;

public interface RetailSearchLogger
{

    public abstract void error(String s, Throwable throwable);

    public abstract void filterMenuClosed();

    public abstract void filterMenuInvoked(String s);

    public abstract void filterMenuSearch();

    public abstract void recordAsinImpressions(List list);

    public abstract void recordDetailPageTransition(String s, DetailPageType detailpagetype);

    public abstract void recordEndOfResults();

    public abstract void recordLayoutSwitch(String s, String s1);

    public abstract void recordRelatedSearchesInvoked();

    public abstract void saveSearchInitTime(long l);

    public abstract void searchATFReached();

    public abstract void searchFirstByteReceived();

    public abstract void searchSRDSAssetsCompleted();

    public abstract void searchSRDSAssetsError(String s, Throwable throwable, AssetsServiceCall assetsservicecall, AssetFetchType assetfetchtype);

    public abstract void searchSRDSAssetsStarted(AssetFetchType assetfetchtype);

    public abstract void searchSRDSCompleted();

    public abstract void searchSRDSError(String s, Throwable throwable, SearchServiceCall searchservicecall);

    public abstract void searchSRDSResponseBeginParse();

    public abstract void searchSRDSResponseEndParse();

    public abstract void searchSRDSStarted();

    public abstract void searchStarted();
}
