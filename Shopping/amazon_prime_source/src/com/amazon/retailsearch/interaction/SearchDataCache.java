// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.interaction;

import android.util.SparseArray;
import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.client.AndroidRetailSearchClient;
import com.amazon.retailsearch.data.search.SearchLoader;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Referenced classes of package com.amazon.retailsearch.interaction:
//            SearchCacheEntry

public class SearchDataCache
{

    private static final int MAX_CACHE_SIZE = 15;
    private final long TTL;
    private SearchLoader activeSearchLoader;
    private SparseArray cache;
    private Queue keyQueue;
    private int prefetchingBudget;
    private int prefetchingCounter;
    private RetailSearchLogger retailSearchLogger;

    public SearchDataCache(long l)
    {
        cache = new SparseArray();
        keyQueue = new LinkedList();
        prefetchingBudget = 0;
        prefetchingCounter = 0;
        activeSearchLoader = null;
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        TTL = l;
    }

    private void addToCache(SearchCacheEntry searchcacheentry)
    {
        if (searchcacheentry == null || searchcacheentry.getSearchLoader() == null)
        {
            return;
        }
        if (cache.size() >= 15)
        {
            int i = ((Integer)keyQueue.remove()).intValue();
            ((SearchCacheEntry)cache.get(i)).getSearchLoader().close();
            cache.remove(i);
        }
        cache.put(searchcacheentry.getKey(), searchcacheentry);
        keyQueue.add(Integer.valueOf(searchcacheentry.getKey()));
    }

    private void removeExpiredCacheEntries()
    {
        ArrayList arraylist = new ArrayList();
        for (int i = 0; i < cache.size(); i++)
        {
            int k = cache.keyAt(i);
            if (((SearchCacheEntry)cache.get(k)).isExpired())
            {
                arraylist.add(Integer.valueOf(k));
            }
        }

        for (int j = 0; j < arraylist.size(); j++)
        {
            int l = ((Integer)arraylist.get(j)).intValue();
            ((SearchCacheEntry)cache.get(l)).getSearchLoader().close();
            cache.remove(l);
        }

    }

    public void addToCache(RetailSearchQuery retailsearchquery, SearchLoader searchloader)
    {
        addToCache(new SearchCacheEntry(retailsearchquery.getCachingKey(), searchloader, false, TTL));
    }

    public void clearAndCloseAll()
    {
        int i;
        for (; cache.size() > 0; cache.remove(i))
        {
            i = cache.keyAt(0);
            ((SearchCacheEntry)cache.get(i)).getSearchLoader().close();
        }

        resetPrefetchingCounter();
    }

    public void clearAndCloseInactive()
    {
        for (int i = 0; i < cache.size(); i++)
        {
            int j = cache.keyAt(i);
            SearchLoader searchloader = ((SearchCacheEntry)cache.get(j)).getSearchLoader();
            if (searchloader != activeSearchLoader)
            {
                searchloader.close();
            }
        }

        cache.clear();
        resetPrefetchingCounter();
    }

    public void closeSearchLoader(SearchLoader searchloader)
    {
        if (activeSearchLoader != null && activeSearchLoader == searchloader)
        {
            searchloader.removeAllListeners();
            return;
        } else
        {
            searchloader.close();
            return;
        }
    }

    public SearchLoader fetch(final RetailSearchQuery query)
    {
        removeExpiredCacheEntries();
        activeSearchLoader = null;
        if (cache.size() == 0)
        {
            return null;
        }
        int i = query.getCachingKey();
        if (cache.indexOfKey(i) > -1)
        {
            SearchCacheEntry searchcacheentry = (SearchCacheEntry)cache.get(i);
            activeSearchLoader = searchcacheentry.getSearchLoader();
            activeSearchLoader.removeAllListeners();
            if (searchcacheentry.isPrefetching())
            {
                retailSearchLogger.recordPrefetchingCacheHit();
                activeSearchLoader.addListener(new com.amazon.retailsearch.data.SearchTask.SearchTaskListener() {

                    final SearchDataCache this$0;
                    final RetailSearchQuery val$query;

                    public void trackingInfo(TrackingInfo trackinginfo)
                    {
                        super.trackingInfo(trackinginfo);
                        if (!query.isPrefetchingAccepted())
                        {
                            query.setPrefetchingAccepted(true);
                            query.setRrid(trackinginfo.getRid());
                            (new SearchLoader(AndroidRetailSearchClient.getClient(), query.toSearchRequest(), null)).load();
                        }
                    }

            
            {
                this$0 = SearchDataCache.this;
                query = retailsearchquery;
                super();
            }
                });
            }
            retailSearchLogger.recordCacheHit();
        }
        return activeSearchLoader;
    }

    public SearchLoader getActiveSearchLoader()
    {
        return activeSearchLoader;
    }

    public int getPrefetchingCounter()
    {
        return prefetchingCounter;
    }

    public void prefetch(RetailSearchQuery retailsearchquery)
    {
        int i;
        for (i = retailsearchquery.getCachingKey(); cache.indexOfKey(i) > -1 || prefetchingBudget > 0 && prefetchingCounter >= prefetchingBudget;)
        {
            return;
        }

        retailsearchquery.setPrefetching(true);
        retailsearchquery = new SearchLoader(AndroidRetailSearchClient.getClient(), retailsearchquery.toSearchRequest(), null);
        retailsearchquery.load();
        retailSearchLogger.recordPrefetching();
        addToCache(new SearchCacheEntry(i, retailsearchquery, true, TTL));
        prefetchingCounter = prefetchingCounter + 1;
    }

    public void reset(int i)
    {
        clearAndCloseAll();
        prefetchingBudget = i;
        activeSearchLoader = null;
    }

    public void resetPrefetchingCounter()
    {
        prefetchingCounter = 0;
    }
}
