// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.content.Context;
import com.groupon.db.dao.DaoDeal;
import com.groupon.db.dao.DaoStockCategory;
import com.groupon.db.events.StockCategoriesUpdateEvent;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Option;
import com.groupon.db.models.StockCategory;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.activity:
//            StockCategories

private static class <init> extends commonlib.loader.der
{

    private DaoDeal dealDao;
    private String dealId;
    private String optionId;
    private DaoStockCategory stockCategoryDao;

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    public List loadInBackground()
    {
        ArrayList arraylist;
        Object obj;
        Object obj1;
        Iterator iterator;
        try
        {
            obj = (Deal)dealDao.queryForFirstEq("remoteId", dealId);
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        obj1 = null;
        arraylist = obj1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        arraylist = null;
        iterator = ((Deal) (obj)).getOptions().iterator();
_L2:
        obj = arraylist;
        if (!iterator.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = (Option)iterator.next();
        if (!((Option) (obj)).remoteId.equals(optionId)) goto _L2; else goto _L1
_L1:
        arraylist = obj1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_100;
        }
        arraylist = obj1;
        if (((Option) (obj)).stockCategories != null)
        {
            arraylist = new ArrayList(((Option) (obj)).stockCategories);
        }
        if (arraylist == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        obj = arraylist;
        if (!arraylist.isEmpty())
        {
            break MISSING_BLOCK_LABEL_131;
        }
        obj = stockCategoryDao.getListByDealIdAndOptionId(dealId, optionId);
        return ((List) (obj));
    }

    protected boolean shouldReload(StockCategoriesUpdateEvent stockcategoriesupdateevent)
    {
        return stockcategoriesupdateevent.getDealId().equals(dealId) && stockcategoriesupdateevent.getOptionId().equals(optionId);
    }

    protected volatile boolean shouldReload(UpdateEvent updateevent)
    {
        return shouldReload((StockCategoriesUpdateEvent)updateevent);
    }

    private (Context context, String s, String s1)
    {
        super(com/groupon/db/models/StockCategory, com/groupon/db/events/StockCategoriesUpdateEvent, context);
        RoboGuice.getInjector(context).injectMembers(this);
        dealId = s;
        optionId = s1;
    }

    optionId(Context context, String s, String s1, optionId optionid)
    {
        this(context, s, s1);
    }
}
