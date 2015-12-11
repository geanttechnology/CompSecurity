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
import com.amazon.retailsearch.data.search.SearchLoaderLogger;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.experiment.FeatureStateUtil;
import com.amazon.retailsearch.metrics.IssLogger;
import com.amazon.retailsearch.util.Utils;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.retailsearch.interaction:
//            SearchDataCache, SearchChangeListener

public class SearchDataSource
{

    private static final EmptySearchTask EMPTY_SEARCH_TASK = new EmptySearchTask();
    private SearchDataCache cache;
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
        long l;
        if ("T1".equals(FeatureStateUtil.getSearchResultsCachingTreatment()))
        {
            l = 5L;
        } else
        if ("T2".equals(FeatureStateUtil.getSearchResultsCachingTreatment()))
        {
            l = 10L;
        } else
        if ("T3".equals(FeatureStateUtil.getSearchResultsCachingTreatment()))
        {
            l = 15L;
        } else
        if ("T4".equals(FeatureStateUtil.getSearchResultsCachingTreatment()))
        {
            l = 20L;
        } else
        {
            l = 15L;
        }
        cache = new SearchDataCache(TimeUnit.NANOSECONDS.convert(l, TimeUnit.MINUTES));
    }

    public void addSearchChangeListener(SearchChangeListener searchchangelistener)
    {
        searchChangeListeners.add(searchchangelistener);
    }

    public void clear()
    {
        if (currentSearchLoader != null)
        {
            cache.closeSearchLoader(currentSearchLoader);
            currentSearchLoader = null;
        }
        searchChangeListeners.clear();
    }

    public void clearCache()
    {
        cache.clearAndCloseAll();
    }

    public RetailSearchQuery cloneLastQuery()
    {
        RetailSearchQuery retailsearchquery;
        try
        {
            retailsearchquery = lastQuery.clone();
        }
        catch (CloneNotSupportedException clonenotsupportedexception)
        {
            return null;
        }
        return retailsearchquery;
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

    public int getPrefetchingCounter()
    {
        return cache.getPrefetchingCounter();
    }

    public SearchLoaderLogger getSearchLoaderLogger()
    {
        if (currentSearchLoader == null)
        {
            return null;
        } else
        {
            return currentSearchLoader.getLogger();
        }
    }

    public boolean isATFLogged()
    {
        return currentSearchLoader == null || currentSearchLoader.getLogger().isATFLogged();
    }

    public boolean isFilterQueryChangedAfterStaged()
    {
        if (lastStagedQuery != null)
        {
            if (lastQuery == null)
            {
                return true;
            }
            if (lastQuery != lastStagedQuery && (!Utils.isEqual(lastStagedQuery.getAlias(), lastQuery.getAlias()) || !Utils.isEqual(lastStagedQuery.getKeywords(), lastQuery.getKeywords()) || !Utils.isEqual(lastStagedQuery.getRefTag(), lastQuery.getRefTag()) || !Utils.isEqual(Long.valueOf(lastStagedQuery.getNode()), Long.valueOf(lastQuery.getNode())) || !Utils.isEqual(lastStagedQuery.getSearchUrl(), lastQuery.getSearchUrl()) || !Utils.isEqual(lastStagedQuery.getSearchMethod(), lastQuery.getSearchMethod()) || !Utils.isEqual(lastStagedQuery.getMerchantId(), lastQuery.getMerchantId()) || !Utils.isEqual(lastStagedQuery.getStoreDiscriminator(), lastQuery.getStoreDiscriminator()) || !Utils.isEqual(lastStagedQuery.getBbnId(), lastQuery.getBbnId())))
            {
                return true;
            }
        }
        return false;
    }

    public void logATF()
    {
        if (currentSearchLoader != null)
        {
            currentSearchLoader.getLogger().completeSearchLogging();
        }
    }

    public void prefetchQuery(RetailSearchQuery retailsearchquery)
    {
        cache.prefetch(retailsearchquery);
    }

    public void removeSearchChangeListener(SearchChangeListener searchchangelistener)
    {
        searchChangeListeners.remove(searchchangelistener);
    }

    public void resetCache(int i)
    {
        cache.reset(i);
    }

    public void stageLastQuery()
    {
        lastStagedQuery = cloneLastQuery();
        lastStagedQuery.removePrefetchingFlags();
    }

    public SearchTask submitQuery(final RetailSearchQuery issEngagementData)
    {
        boolean flag;
        lastQuery = issEngagementData;
        com.amazon.retailsearch.android.api.log.LogEventHandler logeventhandler = retailSearchLogger.searchStarted();
        com.amazon.retailsearch.android.api.log.LogEventHandler logeventhandler1 = retailSearchLogger.trueSearchStarted();
        flag = false;
        currentSearchLoader = cache.fetch(issEngagementData);
        if (currentSearchLoader != null)
        {
            flag = true;
        } else
        {
            currentSearchLoader = new SearchLoader(AndroidRetailSearchClient.getClient(), issEngagementData.toSearchRequest(), null);
        }
        currentSearchLoader.getLogger().setSearchLogEventHandler(logeventhandler);
        currentSearchLoader.getLogger().setTrueSearchLogEventHandler(logeventhandler1);
        if (!"C".equals(FeatureStateUtil.getSearchResultsCachingTreatment())) goto _L2; else goto _L1
_L1:
        cache.clearAndCloseInactive();
_L4:
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
        if (!flag)
        {
            currentSearchLoader.load();
        }
        for (issEngagementData = searchChangeListeners.iterator(); issEngagementData.hasNext(); ((SearchChangeListener)issEngagementData.next()).onNewSearch(currentSearchLoader)) { }
        break; /* Loop/switch isn't completed */
_L2:
        cache.resetPrefetchingCounter();
        if (!flag)
        {
            cache.addToCache(issEngagementData, currentSearchLoader);
        }
        if (true) goto _L4; else goto _L3
_L3:
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
