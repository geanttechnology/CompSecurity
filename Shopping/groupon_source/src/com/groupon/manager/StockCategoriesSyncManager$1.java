// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.db.dao.DaoStockCategory;
import com.groupon.db.models.StockCategory;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.groupon.manager:
//            StockCategoriesSyncManager

class ockCategoriesResponse
    implements Callable
{

    final StockCategoriesSyncManager this$0;
    final ockCategoriesResponse val$stockCategoriesResponse;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        for (Iterator iterator = val$stockCategoriesResponse.stockCategories.iterator(); iterator.hasNext();)
        {
            StockCategory stockcategory = (StockCategory)iterator.next();
            stockcategory.dealId = StockCategoriesSyncManager.access$000(StockCategoriesSyncManager.this);
            stockcategory.optionId = StockCategoriesSyncManager.access$100(StockCategoriesSyncManager.this);
        }

        StockCategoriesSyncManager.access$200(StockCategoriesSyncManager.this).saveList(val$stockCategoriesResponse.stockCategories);
        return null;
    }

    ockCategoriesResponse()
    {
        this$0 = final_stockcategoriessyncmanager;
        val$stockCategoriesResponse = ockCategoriesResponse.this;
        super();
    }
}
