// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import com.groupon.db.dao.DaoBusiness;
import com.groupon.db.events.BusinessUpdateEvent;
import com.groupon.db.models.Business;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import commonlib.loader.EntityLoader;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public abstract class BusinessDetailLoaderCallbacks
    implements android.app.LoaderManager.LoaderCallbacks
{
    private static class BusinessLoader extends EntityLoader
    {

        private DaoBusiness businessDao;
        private String merchantId;

        public Business loadInBackground()
        {
            Object obj;
            try
            {
                obj = businessDao.queryBuilder().where().eq("channel", merchantId);
                obj = (Business)businessDao.queryForFirst(((Where) (obj)).prepare());
            }
            catch (SQLException sqlexception)
            {
                throw new RuntimeException(sqlexception);
            }
            return ((Business) (obj));
        }

        public volatile Object loadInBackground()
        {
            return loadInBackground();
        }

        protected boolean shouldReload(BusinessUpdateEvent businessupdateevent)
        {
            return businessupdateevent.getBusinessId().equalsIgnoreCase(merchantId);
        }

        protected volatile boolean shouldReload(UpdateEvent updateevent)
        {
            return shouldReload((BusinessUpdateEvent)updateevent);
        }

        public BusinessLoader(Class class1, Class class2, Context context1, String s)
        {
            super(class1, class2, context1);
            RoboGuice.getInjector(context1).injectMembers(this);
            merchantId = s;
        }
    }


    private Context context;
    private String merchantId;

    public BusinessDetailLoaderCallbacks(Context context1, String s)
    {
        context = context1;
        merchantId = s;
    }

    public Loader onCreateLoader(int i, Bundle bundle)
    {
        return new BusinessLoader(com/groupon/db/models/Business, com/groupon/db/events/BusinessUpdateEvent, context, merchantId);
    }

    public void onLoadFinished(Loader loader, Business business)
    {
        onMerchantDetailLoaded(business);
    }

    public volatile void onLoadFinished(Loader loader, Object obj)
    {
        onLoadFinished(loader, (Business)obj);
    }

    public void onLoaderReset(Loader loader)
    {
    }

    public abstract void onMerchantDetailLoaded(Business business);
}
