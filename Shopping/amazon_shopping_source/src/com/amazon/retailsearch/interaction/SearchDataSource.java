// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.interaction;

import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.client.AndroidRetailSearchClient;
import com.amazon.retailsearch.data.EmptySearchTask;
import com.amazon.retailsearch.data.SearchTask;
import com.amazon.retailsearch.data.search.SearchLoader;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.metrics.IssLogger;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.amazon.retailsearch.interaction:
//            SearchChangeListener

public class SearchDataSource
{

    private static final EmptySearchTask EMPTY_SEARCH_TASK = new EmptySearchTask();
    private SearchLoader currentSearchLoader;
    private RetailSearchQuery lastQuery;
    private RetailSearchQuery lastStagedQuery;
    private RetailSearchLogger retailSearchLogger;
    private Set searchChangeListeners;

    public SearchDataSource()
    {
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        searchChangeListeners = new HashSet();
        RetailSearchDaggerGraphController.inject(this);
    }

    public void addSearchChangeListener(SearchChangeListener searchchangelistener)
    {
        searchChangeListeners.add(searchchangelistener);
    }

    public void clear()
    {
        if (currentSearchLoader != null)
        {
            currentSearchLoader.close();
            currentSearchLoader = null;
        }
        searchChangeListeners.clear();
    }

    public SearchTask getCurrentSearch()
    {
        if (currentSearchLoader == null)
        {
            return EMPTY_SEARCH_TASK;
        } else
        {
            return currentSearchLoader;
        }
    }

    public boolean isQueryChangedAfterStaged()
    {
        while (lastStagedQuery == null || lastStagedQuery.equals(lastQuery)) 
        {
            return false;
        }
        return true;
    }

    public void removeSearchChangeListener(SearchChangeListener searchchangelistener)
    {
        searchChangeListeners.remove(searchchangelistener);
    }

    public void stageLastQuery()
    {
        lastStagedQuery = lastQuery;
    }

    public SearchTask submitQuery(final RetailSearchQuery issEngagementData)
    {
        lastQuery = issEngagementData;
        retailSearchLogger.searchStarted();
        if (currentSearchLoader != null)
        {
            currentSearchLoader.close();
        }
        currentSearchLoader = new SearchLoader(AndroidRetailSearchClient.getClient(), issEngagementData.toSearchRequest(), null);
        issEngagementData = issEngagementData.getIssEngagementData();
        if (issEngagementData != null)
        {
            currentSearchLoader.addListener(new com.amazon.retailsearch.data.SearchTask.SearchTaskListener() {

                final SearchDataSource this$0;
                final Map val$issEngagementData;

                public void trackingInfo(TrackingInfo trackinginfo)
                {
                    super.trackingInfo(trackinginfo);
                    IssLogger isslogger = new IssLogger(issEngagementData);
                    isslogger.setRequestId(trackinginfo.getRid());
                    isslogger.submitLog();
                }

            
            {
                this$0 = SearchDataSource.this;
                issEngagementData = map;
                super();
            }
            });
        }
        currentSearchLoader.load();
        for (issEngagementData = searchChangeListeners.iterator(); issEngagementData.hasNext(); ((SearchChangeListener)issEngagementData.next()).onNewSearch(currentSearchLoader)) { }
        return currentSearchLoader;
    }

    public SearchTask submitQuery(String s)
    {
        return submitQuery(RetailSearchQuery.fromUrl(s));
    }

    public SearchTask submitStagedQuery()
    {
        if (lastStagedQuery != null)
        {
            return submitQuery(lastStagedQuery);
        } else
        {
            return EMPTY_SEARCH_TASK;
        }
    }

}
