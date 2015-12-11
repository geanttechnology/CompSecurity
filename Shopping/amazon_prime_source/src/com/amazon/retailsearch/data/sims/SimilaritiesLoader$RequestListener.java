// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.data.sims;

import android.support.v4.util.LruCache;
import com.amazon.searchapp.retailsearch.client.web.AbstractServiceCallListener;
import com.amazon.searchapp.retailsearch.model.SearchResult;

// Referenced classes of package com.amazon.retailsearch.data.sims:
//            SimilaritiesLoader

private static class listener extends AbstractServiceCallListener
{

    private final int cacheKey;
    private final result listener;

    public void error(Exception exception)
    {
        listener.or(exception);
    }

    public void result(SearchResult searchresult)
    {
        LruCache lrucache = SimilaritiesLoader.access$000();
        lrucache;
        JVM INSTR monitorenter ;
        LruCache lrucache1;
        int i;
        lrucache1 = SimilaritiesLoader.access$000();
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
        listener.ult(searchresult);
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

    public ner(ner ner, int i)
    {
        cacheKey = i;
        listener = ner;
    }
}
