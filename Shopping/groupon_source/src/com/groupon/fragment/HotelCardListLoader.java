// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import com.groupon.db.dao.DaoMarketRateResult;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.Pagination;
import com.groupon.models.EndlessList;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class HotelCardListLoader extends commonlib.loader.ListLoaderCallbacks.ListLoader
{

    private String channel;
    private DaoMarketRateResult marketRateDao;
    private DaoPagination paginationDao;

    public HotelCardListLoader(Class class1, Class class2, Context context, String s)
    {
        super(class1, class2, context);
        RoboGuice.getInjector(context).injectMembers(this);
        channel = s;
    }

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    public List loadInBackground()
    {
        Object obj;
        Pagination pagination;
        int i;
        int j;
        int k;
        try
        {
            obj = marketRateDao.queryForEq("channel", channel);
            pagination = (Pagination)paginationDao.queryForFirstEq("channel", channel);
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        j = 0;
        k = 0;
        i = 0;
        if (pagination == null)
        {
            break MISSING_BLOCK_LABEL_70;
        }
        i = k;
        if (pagination.hasMorePages())
        {
            i = pagination.getCount();
        }
        k = pagination.getCurrentOffset();
        j = i;
        i = k;
        obj = new EndlessList(((List) (obj)), j, i, null);
        return ((List) (obj));
    }

    protected boolean shouldReload(ChannelUpdateEvent channelupdateevent)
    {
        return Strings.equals(channelupdateevent.getChannel(), channel);
    }

    protected volatile boolean shouldReload(UpdateEvent updateevent)
    {
        return shouldReload((ChannelUpdateEvent)updateevent);
    }
}
