// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import android.os.SystemClock;
import com.groupon.db.dao.DaoDeal;
import com.groupon.db.events.DealUpdateEvent;
import com.groupon.db.models.Deal;
import com.groupon.tracking.mobile.sdk.Logger;
import commonlib.loader.EntityLoader;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class DealLoader extends EntityLoader
{

    private DaoDeal dealDao;
    private String dealId;
    private Logger logger;

    public DealLoader(Class class1, Class class2, Context context, String s)
    {
        super(class1, class2, context);
        RoboGuice.getInjector(context).injectMembers(this);
        dealId = s;
    }

    public Deal loadInBackground()
    {
        Deal deal;
        long l;
        long l1;
        try
        {
            l = SystemClock.currentThreadTimeMillis();
            deal = (Deal)dealDao.queryForFirstEq("remoteId", dealId);
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        if (deal == null)
        {
            break MISSING_BLOCK_LABEL_53;
        }
        l1 = SystemClock.currentThreadTimeMillis();
        logger.logGeneralEvent("deal_performance", "load_deal_from_db", dealId, (int)(l1 - l), Logger.NULL_NST_FIELD);
        return deal;
    }

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    protected boolean shouldReload(DealUpdateEvent dealupdateevent)
    {
        return dealupdateevent.getDealId().equalsIgnoreCase(dealId);
    }

    protected volatile boolean shouldReload(UpdateEvent updateevent)
    {
        return shouldReload((DealUpdateEvent)updateevent);
    }
}
