// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import com.groupon.db.dao.DaoWidgetSummary;
import com.groupon.db.events.ChannelUpdateEvent;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import java.util.List;
import roboguice.util.Strings;

public class WidgetsForThankYouLoader extends commonlib.loader.ListLoaderCallbacks.ListLoader
{

    private DaoWidgetSummary daoWidgetSummary;
    private String extendedDatabaseChannel;
    private boolean forceDownload;

    public WidgetsForThankYouLoader(Class class1, Class class2, Context context, DaoWidgetSummary daowidgetsummary, String s)
    {
        super(class1, class2, context);
        daoWidgetSummary = daowidgetsummary;
        extendedDatabaseChannel = s;
    }

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    public List loadInBackground()
    {
        if (forceDownload)
        {
            return null;
        }
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

    public void setForceDownload(boolean flag)
    {
        forceDownload = flag;
    }

    protected boolean shouldReload(ChannelUpdateEvent channelupdateevent)
    {
        forceDownload = false;
        return Strings.equals(channelupdateevent.getChannel(), extendedDatabaseChannel);
    }

    protected volatile boolean shouldReload(UpdateEvent updateevent)
    {
        return shouldReload((ChannelUpdateEvent)updateevent);
    }
}
