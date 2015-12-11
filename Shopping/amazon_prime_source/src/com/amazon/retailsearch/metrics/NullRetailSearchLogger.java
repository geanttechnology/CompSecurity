// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;

import com.amazon.retailsearch.android.api.log.LogEventHandler;
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

    public void recordCacheHit()
    {
    }

    public void recordDetailPageTransition(String s, DetailPageType detailpagetype)
    {
    }

    public void recordEndOfResults()
    {
    }

    public void recordInlineAddToCartInvoked()
    {
    }

    public void recordLayoutSwitch(String s, String s1)
    {
    }

    public void recordPrefetching()
    {
    }

    public void recordPrefetchingCacheHit()
    {
    }

    public void recordRelatedSearchesInvoked()
    {
    }

    public void recordSimInteraction()
    {
    }

    public void saveSearchInitTime(long l)
    {
    }

    public void searchATFReached(LogEventHandler logeventhandler)
    {
    }

    public void searchFirstByteReceived(LogEventHandler logeventhandler)
    {
    }

    public void searchSRDSAssetsCompleted(LogEventHandler logeventhandler)
    {
    }

    public void searchSRDSAssetsError(String s, Throwable throwable, AssetsServiceCall assetsservicecall, AssetFetchType assetfetchtype)
    {
    }

    public LogEventHandler searchSRDSAssetsStarted(AssetFetchType assetfetchtype)
    {
        return null;
    }

    public void searchSRDSCompleted(LogEventHandler logeventhandler)
    {
    }

    public void searchSRDSError(String s, Throwable throwable, SearchServiceCall searchservicecall)
    {
    }

    public void searchSRDSFirstByteReceived(LogEventHandler logeventhandler)
    {
    }

    public void searchSRDSRefinementsEndParse(LogEventHandler logeventhandler)
    {
    }

    public void searchSRDSResponseBeginParse(LogEventHandler logeventhandler)
    {
    }

    public void searchSRDSResponseEndParse(LogEventHandler logeventhandler)
    {
    }

    public LogEventHandler searchSRDSStarted()
    {
        return null;
    }

    public LogEventHandler searchStarted()
    {
        return null;
    }

    public void trueSearchATFReached(LogEventHandler logeventhandler)
    {
    }

    public LogEventHandler trueSearchStarted()
    {
        return null;
    }
}
