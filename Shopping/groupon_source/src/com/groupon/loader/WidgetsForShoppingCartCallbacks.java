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
import com.groupon.manager.WidgetOnShoppingCartSyncHelper;
import commonlib.adapter.JavaListAdapter;
import commonlib.loader.ListLoaderCallbacks;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class WidgetsForShoppingCartCallbacks extends ListLoaderCallbacks
{
    private static class WidgetsForShoppingCartListLoader extends commonlib.loader.ListLoaderCallbacks.ListLoader
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

        public WidgetsForShoppingCartListLoader(Class class1, Class class2, Context context1, DaoWidgetSummary daowidgetsummary, String s)
        {
            super(class1, class2, context1);
            daoWidgetSummary = daowidgetsummary;
            extendedDatabaseChannel = s;
        }
    }


    private Context context;
    private String extendedDatabaseChannel;
    private DaoWidgetSummary widgetDao;

    public WidgetsForShoppingCartCallbacks(Context context1, JavaListAdapter javalistadapter, String as[])
    {
        super(javalistadapter);
        extendedDatabaseChannel = WidgetOnShoppingCartSyncHelper.staticGetWidgetsChannelName(Channel.SHOPPING_CART.extendedDatabaseChannel(as));
        RoboGuice.getInjector(context1).injectMembers(this);
        context = context1;
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new WidgetsForShoppingCartListLoader(com/groupon/db/models/WidgetSummary, com/groupon/db/events/ChannelUpdateEvent, context, widgetDao, extendedDatabaseChannel);
    }
}
