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

// Referenced classes of package com.groupon.loader:
//            WidgetsForShoppingCartCallbacks

private static class extendedDatabaseChannel extends commonlib.loader.r
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

    public Y(Class class1, Class class2, Context context, DaoWidgetSummary daowidgetsummary, String s)
    {
        super(class1, class2, context);
        daoWidgetSummary = daowidgetsummary;
        extendedDatabaseChannel = s;
    }
}
