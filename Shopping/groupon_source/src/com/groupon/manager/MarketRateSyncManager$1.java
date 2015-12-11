// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.db.dao.DaoPagination;
import com.groupon.db.models.Pagination;
import com.groupon.models.MarketRateResultResponse;
import com.groupon.util.IOUtils;
import com.groupon.util.MutableInteger;
import com.j256.ormlite.dao.Dao;
import java.io.InputStream;
import java.util.List;
import java.util.concurrent.Callable;
import org.codehaus.jackson.map.ObjectMapper;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.manager:
//            MarketRateSyncManager, SyncManagerUtils

class val.dealCount
    implements Callable
{

    final MarketRateSyncManager this$0;
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
        Object obj1 = (Dao)paginationDao.get();
        if (!MarketRateSyncManager.access$000(MarketRateSyncManager.this)) goto _L2; else goto _L1
_L1:
        Object obj = MarketRateSyncManager.access$100(MarketRateSyncManager.this);
_L7:
        SyncManagerUtils.deleteRecordsForChannel(((Dao) (obj1)), ((String) (obj)));
        if (val$offset != 0) goto _L4; else goto _L3
_L3:
        obj1 = MarketRateSyncManager.access$200(MarketRateSyncManager.this);
        if (!MarketRateSyncManager.access$000(MarketRateSyncManager.this))
        {
            break MISSING_BLOCK_LABEL_251;
        }
        obj = MarketRateSyncManager.access$100(MarketRateSyncManager.this);
_L9:
        SyncManagerUtils.deleteRecordsForChannel(((Dao) (obj1)), ((String) (obj)));
_L4:
        Pagination pagination;
        obj1 = (MarketRateResultResponse)mapper.readValue(val$inputStream, com/groupon/models/MarketRateResultResponse);
        val$dealCount.set(((MarketRateResultResponse) (obj1)).results.size());
        pagination = ((MarketRateResultResponse) (obj1)).pagination;
        if (!MarketRateSyncManager.access$000(MarketRateSyncManager.this)) goto _L6; else goto _L5
_L5:
        obj = MarketRateSyncManager.access$100(MarketRateSyncManager.this);
_L8:
        pagination.setChannel(((String) (obj)));
        ((MarketRateResultResponse) (obj1)).pagination.setCurrentOffset(val$offset);
        ((MarketRateResultResponse) (obj1)).pagination.setNextOffset(val$offset + val$dealCount.get());
        obj = ((MarketRateResultResponse) (obj1)).pagination;
        boolean flag;
        if (val$dealCount.get() > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ((Pagination) (obj)).setHasMorePages(flag);
        ((DaoPagination)paginationDao.get()).create(((MarketRateResultResponse) (obj1)).pagination);
        IOUtils.close(val$inputStream);
        return null;
_L2:
        obj = "HOTELS";
          goto _L7
_L6:
        obj = "HOTELS";
          goto _L8
        obj;
        IOUtils.close(val$inputStream);
        throw obj;
        obj = "HOTELS";
          goto _L9
    }

    ()
    {
        this$0 = final_marketratesyncmanager;
        val$offset = i;
        val$inputStream = inputstream;
        val$dealCount = MutableInteger.this;
        super();
    }
}
