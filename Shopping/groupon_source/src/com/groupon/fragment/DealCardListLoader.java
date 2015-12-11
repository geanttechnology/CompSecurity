// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import com.groupon.db.dao.DaoDealSubsetAttribute;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.Pagination;
import com.groupon.models.EndlessList;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class DealCardListLoader extends commonlib.loader.ListLoaderCallbacks.ListLoader
{

    protected DaoDealSubsetAttribute dealSubsetAttributeDao;
    protected DaoDealSummary dealSummaryDao;
    private boolean forceDownload;
    protected String pagerChannelAndSubchannel;
    protected DaoPagination paginationDao;

    public DealCardListLoader(Class class1, Class class2, Context context, String s)
    {
        super(class1, class2, context);
        RoboGuice.getInjector(context).injectMembers(this);
        pagerChannelAndSubchannel = s;
    }

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    public List loadInBackground()
    {
        Object obj;
        Pagination pagination;
        DealSubsetAttribute dealsubsetattribute;
        if (forceDownload)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        obj = dealSummaryDao.queryForEq("channel", pagerChannelAndSubchannel);
        pagination = (Pagination)paginationDao.queryForFirstEq("channel", pagerChannelAndSubchannel);
        dealsubsetattribute = (DealSubsetAttribute)dealSubsetAttributeDao.queryForFirstEq("channel", pagerChannelAndSubchannel);
        int j = 0;
        int k = 0;
        int i = 0;
        if (pagination != null)
        {
            i = k;
            try
            {
                if (pagination.hasMorePages())
                {
                    i = pagination.getCount();
                }
                k = pagination.getCurrentOffset();
            }
            catch (SQLException sqlexception)
            {
                throw new RuntimeException(sqlexception);
            }
            j = i;
            i = k;
        }
        obj = new EndlessList(((List) (obj)), j, i, dealsubsetattribute);
        return ((List) (obj));
        return null;
    }

    public void setForceDownload(boolean flag)
    {
        forceDownload = flag;
    }

    protected boolean shouldReload(ChannelUpdateEvent channelupdateevent)
    {
        forceDownload = false;
        return Strings.equals(channelupdateevent.getChannel(), pagerChannelAndSubchannel);
    }

    protected volatile boolean shouldReload(UpdateEvent updateevent)
    {
        return shouldReload((ChannelUpdateEvent)updateevent);
    }
}
