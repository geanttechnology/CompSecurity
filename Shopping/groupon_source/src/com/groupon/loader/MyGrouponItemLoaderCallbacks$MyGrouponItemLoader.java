// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import com.groupon.db.dao.DaoMyGrouponItem;
import com.groupon.db.events.DealUpdateEvent;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.groupon.util.CollectionUtils;
import commonlib.loader.EntityLoader;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.loader:
//            MyGrouponItemLoaderCallbacks

private static class dealId extends EntityLoader
{

    private String dealId;
    private DaoMyGrouponItem myGrouponItemDao;

    public MyGrouponItem loadInBackground()
    {
        MyGrouponItem mygrouponitem;
        try
        {
            mygrouponitem = (MyGrouponItem)CollectionUtils.getFirstItem(myGrouponItemDao.queryForEq("remoteId", dealId), null);
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        return mygrouponitem;
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

    public I(Class class1, Class class2, Context context, String s)
    {
        super(class1, class2, context);
        RoboGuice.getInjector(context).injectMembers(this);
        dealId = s;
    }
}
