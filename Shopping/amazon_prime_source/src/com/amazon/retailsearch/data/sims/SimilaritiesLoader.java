// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.sims;

import android.support.v4.util.LruCache;
import android.text.TextUtils;
import com.amazon.retailsearch.client.AndroidRetailSearchClient;
import com.amazon.retailsearch.log.AppLog;
import com.amazon.retailsearch.log.MessageLogger;
import com.amazon.searchapp.retailsearch.client.RetailSearchClient;
import com.amazon.searchapp.retailsearch.client.SimsServiceCall;
import com.amazon.searchapp.retailsearch.client.web.AbstractServiceCallListener;
import com.amazon.searchapp.retailsearch.entity.SearchResultEntity;
import com.amazon.searchapp.retailsearch.model.SearchResult;
import java.io.IOException;

public class SimilaritiesLoader
{
    private static class RequestListener extends AbstractServiceCallListener
    {

        private final int cacheKey;
        private final SimsListener listener;

        public void error(Exception exception)
        {
            listener.error(exception);
        }

        public void result(SearchResult searchresult)
        {
            LruCache lrucache = SimilaritiesLoader.simCache;
            lrucache;
            JVM INSTR monitorenter ;
            LruCache lrucache1;
            int i;
            lrucache1 = SimilaritiesLoader.simCache;
            i = cacheKey;
            if (searchresult != null)
            {
                break MISSING_BLOCK_LABEL_50;
            }
            SearchResult searchresult1 = SimilaritiesLoader.EMPTY_SIM;
_L1:
            lrucache1.put(Integer.valueOf(i), searchresult1);
            lrucache;
            JVM INSTR monitorexit ;
            listener.result(searchresult);
            return;
            searchresult1 = searchresult;
              goto _L1
            searchresult;
            lrucache;
            JVM INSTR monitorexit ;
            throw searchresult;
        }

        public volatile void result(Object obj)
        {
            result((SearchResult)obj);
        }

        public RequestListener(SimsListener simslistener, int i)
        {
            cacheKey = i;
            listener = simslistener;
        }
    }

    public static interface SimsListener
    {

        public abstract void error(Exception exception);

        public abstract void result(SearchResult searchresult);
    }


    public static final SearchResult EMPTY_SIM = new SearchResultEntity();
    private static final int PRIME = 29;
    private static final MessageLogger log = AppLog.getLog(com/amazon/retailsearch/data/sims/SimilaritiesLoader);
    private static final LruCache simCache = new LruCache(1024);

    private SimilaritiesLoader()
    {
    }

    private static int getCacheKey(String s, int i, String s1)
    {
        int k = 0;
        int j;
        if (TextUtils.isEmpty(s))
        {
            j = 0;
        } else
        {
            j = s.hashCode();
        }
        if (!TextUtils.isEmpty(s1))
        {
            k = s1.hashCode();
        }
        return ((j + 29) * 29 + i) * 29 + k;
    }

    public static void getSims(SimsListener simslistener, String s, int i, String s1)
    {
        int j;
        j = getCacheKey(s, i, s1);
        SearchResult searchresult;
        synchronized (simCache)
        {
            searchresult = (SearchResult)simCache.get(Integer.valueOf(j));
        }
        if (searchresult != null)
        {
            simslistener.result(searchresult);
            return;
        }
        break MISSING_BLOCK_LABEL_55;
        simslistener;
        lrucache;
        JVM INSTR monitorexit ;
        throw simslistener;
        s = AndroidRetailSearchClient.getClient().similarities(new RequestListener(simslistener, j), s, i, s1);
        try
        {
            s.execute();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            log.error("Failed to load sims data", s);
        }
        simslistener.error(s);
        return;
    }


}
