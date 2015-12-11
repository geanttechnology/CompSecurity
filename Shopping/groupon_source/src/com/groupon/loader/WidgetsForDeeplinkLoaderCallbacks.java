// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import com.groupon.db.dao.DaoWidgetSummary;
import com.groupon.db.events.ChannelUpdateEvent;
import com.groupon.db.models.WidgetSummary;
import com.groupon.util.PendingAdapterWrapper;
import commonlib.adapter.JavaListAdapter;
import commonlib.loader.ListLoaderCallbacks;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class WidgetsForDeeplinkLoaderCallbacks extends ListLoaderCallbacks
{
    private static class WidgetsForDeepLinkListLoader extends commonlib.loader.ListLoaderCallbacks.ListLoader
    {

        private DaoWidgetSummary daoWidgetSummary;
        private String dbChannel;

        public volatile Object loadInBackground()
        {
            return loadInBackground();
        }

        public List loadInBackground()
        {
            List list;
            try
            {
                list = daoWidgetSummary.getListByChannelId(dbChannel);
            }
            catch (SQLException sqlexception)
            {
                throw new RuntimeException(sqlexception);
            }
            return list;
        }

        protected boolean shouldReload(ChannelUpdateEvent channelupdateevent)
        {
            return Strings.equals(channelupdateevent.getChannel(), dbChannel);
        }

        protected volatile boolean shouldReload(UpdateEvent updateevent)
        {
            return shouldReload((ChannelUpdateEvent)updateevent);
        }

        public WidgetsForDeepLinkListLoader(Class class1, Class class2, Context context1, DaoWidgetSummary daowidgetsummary, String s)
        {
            super(class1, class2, context1);
            daoWidgetSummary = daowidgetsummary;
            dbChannel = s;
        }
    }


    private Context context;
    private DaoWidgetSummary daoWidgetSummary;
    private String dbChannel;
    private PendingAdapterWrapper pendingAdapterWrapper;

    public WidgetsForDeeplinkLoaderCallbacks(Context context1, JavaListAdapter javalistadapter, String s, PendingAdapterWrapper pendingadapterwrapper)
    {
        super(javalistadapter);
        dbChannel = s;
        RoboGuice.getInjector(context1).injectMembers(this);
        context = context1;
        pendingAdapterWrapper = pendingadapterwrapper;
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new WidgetsForDeepLinkListLoader(com/groupon/db/models/WidgetSummary, com/groupon/db/events/ChannelUpdateEvent, context, daoWidgetSummary, dbChannel);
    }

    public void onLoaderReset(Loader loader)
    {
        pendingAdapterWrapper.enableAppending(true);
        super.onLoaderReset(loader);
    }
}
