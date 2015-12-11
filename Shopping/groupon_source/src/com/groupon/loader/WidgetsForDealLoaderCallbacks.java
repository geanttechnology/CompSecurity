// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import com.groupon.Channel;
import com.groupon.db.dao.DaoWidgetSummary;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.WidgetSummary;
import com.groupon.manager.WidgetOnDealDetailsSyncHelper;
import commonlib.adapter.JavaListAdapter;
import commonlib.loader.ListLoaderCallbacks;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class WidgetsForDealLoaderCallbacks extends ListLoaderCallbacks
{
    private static class WidgetsForDealListLoader extends commonlib.loader.ListLoaderCallbacks.ListLoader
    {

        private DaoWidgetSummary daoWidgetSummary;
        private String extendedDatabaseChannel;

        public volatile Object loadInBackground()
        {
            return loadInBackground();
        }

        public List loadInBackground()
        {
            List list;
            try
            {
                list = daoWidgetSummary.getListByChannelId(extendedDatabaseChannel);
            }
            catch (SQLException sqlexception)
            {
                throw new RuntimeException(sqlexception);
            }
            return list;
        }

        protected boolean shouldReload(ChannelUpdateEvent channelupdateevent)
        {
            return Strings.equals(channelupdateevent.getChannel(), extendedDatabaseChannel);
        }

        protected volatile boolean shouldReload(UpdateEvent updateevent)
        {
            return shouldReload((ChannelUpdateEvent)updateevent);
        }

        public WidgetsForDealListLoader(Class class1, Class class2, Context context1, DaoWidgetSummary daowidgetsummary, String s)
        {
            super(class1, class2, context1);
            daoWidgetSummary = daowidgetsummary;
            extendedDatabaseChannel = s;
        }
    }


    private Context context;
    private String extendedDatabaseChannel;
    private DaoWidgetSummary widgetDao;

    public WidgetsForDealLoaderCallbacks(Context context1, JavaListAdapter javalistadapter, String s)
    {
        super(javalistadapter);
        extendedDatabaseChannel = WidgetOnDealDetailsSyncHelper.staticGetWidgetsChannelName(Channel.DEAL_WIDGET.extendedDatabaseChannel(s));
        RoboGuice.getInjector(context1).injectMembers(this);
        context = context1;
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new WidgetsForDealListLoader(com/groupon/db/models/WidgetSummary, com/groupon/db/events/ChannelUpdateEvent, context, widgetDao, extendedDatabaseChannel);
    }
}
