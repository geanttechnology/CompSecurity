// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import com.groupon.db.dao.DaoMyGrouponItemSummary;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.events.MyGrouponsUpdateEvent;
import com.groupon.db.models.Pagination;
import com.groupon.models.EndlessList;
import commonlib.loader.event.UpdateEvent;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

public class MyGrouponsListLoader extends commonlib.loader.ListLoaderCallbacks.ListLoader
{

    private String category;
    private DaoMyGrouponItemSummary daoMyGrouponItemSummary;
    private DaoPagination daoPagination;
    private AtomicBoolean forceDownload;

    public MyGrouponsListLoader(Class class1, Class class2, Context context, String s)
    {
        super(class1, class2, context);
        forceDownload = new AtomicBoolean();
        RoboGuice.getInjector(context).injectMembers(this);
        category = s;
    }

    public boolean isForceDownload()
    {
        return forceDownload.get();
    }

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    public List loadInBackground()
    {
        Object obj = null;
        Pagination pagination;
        if (forceDownload.get())
        {
            break MISSING_BLOCK_LABEL_95;
        }
        obj = daoMyGrouponItemSummary.queryForEq("category", category);
        pagination = (Pagination)daoPagination.queryForFirstEq("channel", category);
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
            catch (Exception exception)
            {
                throw new RuntimeException(exception);
            }
            j = i;
            i = k;
        }
        obj = new EndlessList(((List) (obj)), j, i, null);
        return ((List) (obj));
    }

    public void setForceDownload(boolean flag)
    {
        forceDownload.set(flag);
    }

    protected boolean shouldReload(MyGrouponsUpdateEvent mygrouponsupdateevent)
    {
        forceDownload.set(false);
        return Strings.equals(mygrouponsupdateevent.getCategory(), category);
    }

    protected volatile boolean shouldReload(UpdateEvent updateevent)
    {
        return shouldReload((MyGrouponsUpdateEvent)updateevent);
    }
}
