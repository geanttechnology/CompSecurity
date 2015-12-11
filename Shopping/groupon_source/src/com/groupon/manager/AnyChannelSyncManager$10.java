// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.db.dao.DaoDealSubsetAttribute;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.Pagination;
import com.groupon.models.DealsResponse;
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
//            AnyChannelSyncManager, SyncManagerUtils, AsyncHttp, WidgetsSyncHelper

class val.nameValueParams
    implements Callable
{

    final AnyChannelSyncManager this$0;
    final MutableInteger val$dealCount;
    final InputStream val$m;
    final Object val$nameValueParams[];
    final int val$offset;
    final AsyncHttp val$widgetsAsyncHttp;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        InputStream inputstream;
        Object obj1;
        DealsResponse dealsresponse;
        SyncManagerUtils.deleteRecordsForChannel((Dao)paginationDao.get(), channel);
        SyncManagerUtils.deleteRecordsForChannel((Dao)dealSubsetAttributeDao.get(), channel);
        if (val$offset == 0)
        {
            SyncManagerUtils.deleteRecordsForChannel(dealSummaryDao, channel);
        }
        dealsresponse = (DealsResponse)mapper.readValue(val$m, com/groupon/models/DealsResponse);
        val$dealCount.set(dealsresponse.deals.size());
        if (dealsresponse.pagination != null)
        {
            dealsresponse.pagination.setChannel(channel);
            dealsresponse.pagination.setCurrentOffset(val$offset);
            dealsresponse.pagination.setNextOffset(val$offset + val$dealCount.get());
            Object obj = dealsresponse.pagination;
            DealSubsetAttribute dealsubsetattribute;
            boolean flag;
            if (val$dealCount.get() > 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            ((Pagination) (obj)).setHasMorePages(flag);
            ((DaoPagination)paginationDao.get()).create(dealsresponse.pagination);
        }
        if (dealsresponse.dealSubsetAttributes != null)
        {
            for (obj = dealsresponse.dealSubsetAttributes.iterator(); ((Iterator) (obj)).hasNext(); ((DaoDealSubsetAttribute)dealSubsetAttributeDao.get()).create(dealsubsetattribute))
            {
                dealsubsetattribute = (DealSubsetAttribute)((Iterator) (obj)).next();
                dealsubsetattribute.channel = channel;
            }

        }
        if (val$widgetsAsyncHttp == null)
        {
            break MISSING_BLOCK_LABEL_338;
        }
        obj1 = null;
        inputstream = null;
        InputStream inputstream1 = (InputStream)val$widgetsAsyncHttp.get();
        inputstream = inputstream1;
        obj1 = inputstream1;
        AnyChannelSyncManager.access$000(AnyChannelSyncManager.this).process(inputstream1, val$widgetsAsyncHttp.getParams());
        if (inputstream1 != null)
        {
            IOUtils.close(inputstream1);
        }
_L2:
        if (val$offset == 0 && val$dealCount.get() > 0)
        {
            logDealSearch(getFragmentName(), getNstChannel(), val$nameValueParams, "full_list", searchCategory, dealsresponse.relevanceService, val$dealCount.get());
        }
        return null;
        obj1;
        if (inputstream != null)
        {
            IOUtils.close(inputstream);
        }
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        if (obj1 != null)
        {
            IOUtils.close(((java.io.Closeable) (obj1)));
        }
        throw exception;
    }

    ()
    {
        this$0 = final_anychannelsyncmanager;
        val$offset = i;
        val$m = inputstream;
        val$dealCount = mutableinteger;
        val$widgetsAsyncHttp = asynchttp;
        val$nameValueParams = _5B_Ljava.lang.Object_3B_.this;
        super();
    }
}
