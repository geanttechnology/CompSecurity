// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import com.groupon.db.dao.DaoMyGrouponItem;
import com.groupon.db.events.DealUpdateEvent;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.groupon.util.CollectionUtils;
import commonlib.loader.EntityLoader;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public abstract class MyGrouponItemLoaderCallbacks
    implements android.app.LoaderManager.LoaderCallbacks
{
    private static class MyGrouponItemLoader extends EntityLoader
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

        public MyGrouponItemLoader(Class class1, Class class2, Context context1, String s)
        {
            super(class1, class2, context1);
            RoboGuice.getInjector(context1).injectMembers(this);
            dealId = s;
        }
    }


    private Context context;
    private String dealId;

    public MyGrouponItemLoaderCallbacks(Context context1, String s)
    {
        context = context1;
        dealId = s;
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new MyGrouponItemLoader(com/groupon/db/models/mygroupons/MyGrouponItem, com/groupon/db/events/DealUpdateEvent, context, dealId);
    }

    public abstract void onDealLoaded(MyGrouponItem mygrouponitem);

    public void onLoadFinished(Loader loader, MyGrouponItem mygrouponitem)
    {
        onDealLoaded(mygrouponitem);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (MyGrouponItem)obj);
    }

    public void onLoaderReset(Loader loader)
    {
    }
}
