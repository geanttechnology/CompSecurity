// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
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

// Referenced classes of package com.groupon.loader:
//            BusinessDetailLoaderCallbacks

private static class merchantId extends EntityLoader
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

    public (Class class1, Class class2, Context context, String s)
    {
        super(class1, class2, context);
        RoboGuice.getInjector(context).injectMembers(this);
        merchantId = s;
    }
}
