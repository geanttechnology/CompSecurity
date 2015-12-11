// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.data.assets.AssetFetchType;
import com.amazon.searchapp.retailsearch.client.AssetsServiceCall;
import com.amazon.searchapp.retailsearch.client.SearchServiceCall;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.metrics:
//            DetailPageType

public class NullRetailSearchLogger
    implements RetailSearchLogger
{

    public NullRetailSearchLogger()
    {
    }

    public void error(String s, Throwable throwable)
    {
    }

    public void filterMenuClosed()
    {
    }

    public void filterMenuInvoked(String s)
    {
    }

    public void filterMenuSearch()
    {
    }

    public void recordAsinImpressions(List list)
    {
    }

    public void recordDetailPageTransition(String s, DetailPageType detailpagetype)
    {
    }

    public void recordEndOfResults()
    {
    }

    public void recordFlowInvoked()
    {
    }

    public void recordLayoutSwitch(String s, String s1)
    {
    }

    public void recordRelatedSearchesInvoked()
    {
    }

    public void recordSnapItInvoked()
    {
    }

    public void saveSearchInitTime(long l)
    {
    }

    public void searchATFReached()
    {
    }

    public void searchFirstByteReceived()
    {
    }

    public void searchSRDSAssetsCompleted()
    {
    }

    public void searchSRDSAssetsError(String s, Throwable throwable, AssetsServiceCall assetsservicecall, AssetFetchType assetfetchtype)
    {
    }

    public void searchSRDSAssetsStarted(AssetFetchType assetfetchtype)
    {
    }

    public void searchSRDSCompleted()
    {
    }

    public void searchSRDSError(String s, Throwable throwable, SearchServiceCall searchservicecall)
    {
    }

    public void searchSRDSResponseBeginParse()
    {
    }

    public void searchSRDSResponseEndParse()
    {
    }

    public void searchSRDSStarted()
    {
    }

    public void searchStarted()
    {
    }
}
