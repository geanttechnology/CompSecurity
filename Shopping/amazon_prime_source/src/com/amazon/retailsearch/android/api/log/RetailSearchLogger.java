// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.log;

import com.amazon.retailsearch.data.assets.AssetFetchType;
import com.amazon.retailsearch.metrics.DetailPageType;
import com.amazon.searchapp.retailsearch.client.AssetsServiceCall;
import com.amazon.searchapp.retailsearch.client.SearchServiceCall;
import java.util.List;

// Referenced classes of package com.amazon.retailsearch.android.api.log:
//            LogEventHandler

public interface RetailSearchLogger
{

    public abstract void error(String s, Throwable throwable);

    public abstract void filterMenuClosed();

    public abstract void filterMenuInvoked(String s);

    public abstract void filterMenuSearch();

    public abstract void recordAsinImpressions(List list);

    public abstract void recordCacheHit();

    public abstract void recordDetailPageTransition(String s, DetailPageType detailpagetype);

    public abstract void recordEndOfResults();

    public abstract void recordInlineAddToCartInvoked();

    public abstract void recordLayoutSwitch(String s, String s1);

    public abstract void recordPrefetching();

    public abstract void recordPrefetchingCacheHit();

    public abstract void recordRelatedSearchesInvoked();

    public abstract void recordSimInteraction();

    public abstract void saveSearchInitTime(long l);

    public abstract void searchATFReached(LogEventHandler logeventhandler);

    public abstract void searchFirstByteReceived(LogEventHandler logeventhandler);

    public abstract void searchSRDSAssetsCompleted(LogEventHandler logeventhandler);

    public abstract void searchSRDSAssetsError(String s, Throwable throwable, AssetsServiceCall assetsservicecall, AssetFetchType assetfetchtype);

    public abstract LogEventHandler searchSRDSAssetsStarted(AssetFetchType assetfetchtype);

    public abstract void searchSRDSCompleted(LogEventHandler logeventhandler);

    public abstract void searchSRDSError(String s, Throwable throwable, SearchServiceCall searchservicecall);

    public abstract void searchSRDSFirstByteReceived(LogEventHandler logeventhandler);

    public abstract void searchSRDSRefinementsEndParse(LogEventHandler logeventhandler);

    public abstract void searchSRDSResponseBeginParse(LogEventHandler logeventhandler);

    public abstract void searchSRDSResponseEndParse(LogEventHandler logeventhandler);

    public abstract LogEventHandler searchSRDSStarted();

    public abstract LogEventHandler searchStarted();

    public abstract void trueSearchATFReached(LogEventHandler logeventhandler);

    public abstract LogEventHandler trueSearchStarted();
}
