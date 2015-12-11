// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.db.dao.DaoStockCategory;
import com.groupon.db.events.StockCategoriesUpdateEvent;
import com.groupon.db.models.StockCategory;
import com.groupon.http.synchronous.SyncHttp;
import com.groupon.util.IOUtils;
import com.groupon.util.ObjectMapperWrapper;
import com.groupon.util.PausableThreadPoolExecutor;
import com.squareup.otto.Bus;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.groupon.manager:
//            GrouponSyncManager

public class StockCategoriesSyncManager extends GrouponSyncManager
{
    protected static class StockCategoriesResponse
    {

        public List stockCategories;

        protected StockCategoriesResponse()
        {
        }
    }


    private String dealId;
    private Bus globalBus;
    protected ObjectMapperWrapper mapper;
    private String optionId;
    private DaoStockCategory stockCategoryDao;

    public StockCategoriesSyncManager(Context context)
    {
        super(context);
    }

    public StockCategoriesSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor)
    {
        super(context, pausablethreadpoolexecutor);
    }

    protected volatile void doSync(Object obj)
        throws Exception
    {
        doSync((Void)obj);
    }

    protected void doSync(Void void1)
        throws Exception
    {
        void1 = Arrays.asList(new Object[] {
            "option_id", optionId
        });
        void1 = (InputStream)(new SyncHttp(context, java/io/InputStream, String.format("https:/deals/%s/stock", new Object[] {
            dealId
        }), void1.toArray())).call();
        final StockCategoriesResponse stockCategoriesResponse = (StockCategoriesResponse)mapper.readValue(void1, com/groupon/manager/StockCategoriesSyncManager$StockCategoriesResponse);
        stockCategoryDao.callBatchTasks(new Callable() {

            final StockCategoriesSyncManager this$0;
            final StockCategoriesResponse val$stockCategoriesResponse;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                for (Iterator iterator = stockCategoriesResponse.stockCategories.iterator(); iterator.hasNext();)
                {
                    StockCategory stockcategory = (StockCategory)iterator.next();
                    stockcategory.dealId = dealId;
                    stockcategory.optionId = optionId;
                }

                stockCategoryDao.saveList(stockCategoriesResponse.stockCategories);
                return null;
            }

            
            {
                this$0 = StockCategoriesSyncManager.this;
                stockCategoriesResponse = stockcategoriesresponse;
                super();
            }
        });
        globalBus.post(new StockCategoriesUpdateEvent(dealId, optionId));
        IOUtils.close(void1);
        return;
        Exception exception;
        exception;
        IOUtils.close(void1);
        throw exception;
    }

    public String getDealId()
    {
        return dealId;
    }

    public String getOptionId()
    {
        return optionId;
    }

    protected long lastUpdated()
        throws Exception
    {
        StockCategory stockcategory = stockCategoryDao.getByDealIdAndOptionId(dealId, optionId);
        if (stockcategory != null)
        {
            return stockcategory.modificationDate.getTime();
        } else
        {
            return 0L;
        }
    }

    public void setDealId(String s)
    {
        dealId = s;
    }

    public void setOptionId(String s)
    {
        optionId = s;
    }



}
