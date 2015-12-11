// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.content.dm;

import com.ebay.common.net.api.search.ISearchEventTracker;
import com.ebay.common.net.api.search.SearchConfiguration;
import com.ebay.common.net.api.search.SearchParameters;

// Referenced classes of package com.ebay.common.content.dm:
//            SearchDataManager

private class searchTracker
{

    public SearchConfiguration config;
    public searchTracker ownerObserver;
    public SearchParameters searchParameters;
    public ISearchEventTracker searchTracker;
    final SearchDataManager this$0;

    public (SearchParameters searchparameters, SearchConfiguration searchconfiguration,  , ISearchEventTracker isearcheventtracker)
    {
        this$0 = SearchDataManager.this;
        super();
        searchParameters = searchparameters.clone();
        config = searchconfiguration;
        ownerObserver = ;
        searchTracker = isearcheventtracker;
    }
}
