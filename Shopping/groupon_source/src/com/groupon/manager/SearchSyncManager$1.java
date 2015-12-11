// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.db.dao.DaoDealSubsetAttribute;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.Pagination;
import com.groupon.models.DealsResponse;
import com.groupon.models.dealsearch.OtherDeals;
import com.groupon.models.dealsearch.SearchResponse;
import com.groupon.util.IOUtils;
import com.groupon.util.MutableInteger;
import com.j256.ormlite.dao.Dao;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import org.codehaus.jackson.map.ObjectMapper;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.manager:
//            SearchSyncManager, SyncManagerUtils

class val.dealCount
    implements Callable
{

    final SearchSyncManager this$0;
    final MutableInteger val$dealCount;
    final InputStream val$inputStream;
    final int val$offset;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        Object obj;
        SyncManagerUtils.deleteRecordsForChannel((Dao)paginationDao.get(), channel);
        SyncManagerUtils.deleteRecordsForChannel((Dao)dealSubsetAttributeDao.get(), channel);
        if (val$offset == 0)
        {
            SyncManagerUtils.deleteRecordsForChannel(dealSummaryDao, channel);
        }
        SyncManagerUtils.deleteRecordsForChannel(dealSummaryDao, SearchSyncManager.access$000(SearchSyncManager.this));
        obj = (SearchResponse)mapper.readValue(val$inputStream, com/groupon/models/dealsearch/SearchResponse);
        if (((SearchResponse) (obj)).otherDeals != null && ((SearchResponse) (obj)).otherDeals.backfill != null && ((SearchResponse) (obj)).otherDeals.backfill.dealSubsetAttributes != null)
        {
            DealSubsetAttribute dealsubsetattribute;
            for (Iterator iterator = ((SearchResponse) (obj)).otherDeals.backfill.dealSubsetAttributes.iterator(); iterator.hasNext(); ((DaoDealSubsetAttribute)dealSubsetAttributeDao.get()).create(dealsubsetattribute))
            {
                dealsubsetattribute = (DealSubsetAttribute)iterator.next();
                dealsubsetattribute.channel = channel;
            }

        }
          goto _L1
        obj;
        IOUtils.close(val$inputStream);
_L5:
        return null;
_L1:
        if (((SearchResponse) (obj)).deals != null)
        {
            val$dealCount.set(((SearchResponse) (obj)).deals.size());
        }
        if (((SearchResponse) (obj)).pagination == null) goto _L3; else goto _L2
_L2:
        Object obj1;
        ((SearchResponse) (obj)).pagination.setChannel(channel);
        ((SearchResponse) (obj)).pagination.setCurrentOffset(val$offset);
        ((SearchResponse) (obj)).pagination.setNextOffset(val$offset + val$dealCount.get());
        obj1 = ((SearchResponse) (obj)).pagination;
        int i;
        boolean flag;
        if (val$dealCount.get() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((Pagination) (obj1)).setHasMorePages(flag);
        ((DaoPagination)paginationDao.get()).create(((SearchResponse) (obj)).pagination);
_L3:
        if (val$offset != 0) goto _L5; else goto _L4
_L4:
        obj1 = SearchSyncManager.this;
        if (((SearchResponse) (obj)).pagination == null)
        {
            break MISSING_BLOCK_LABEL_370;
        }
        i = ((SearchResponse) (obj)).pagination.getCount();
_L6:
        ((SearchSyncManager) (obj1)).logGlobalSearchDealSearch(i);
          goto _L5
        i = val$dealCount.get();
          goto _L6
    }

    e()
    {
        this$0 = final_searchsyncmanager;
        val$offset = i;
        val$inputStream = inputstream;
        val$dealCount = MutableInteger.this;
        super();
    }
}
