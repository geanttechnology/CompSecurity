// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import com.groupon.db.dao.DaoSpecial;
import com.groupon.db.events.BusinessSpecialUpdateEvent;
import com.groupon.db.models.Special;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import commonlib.loader.EntityLoader;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.loader:
//            BusinessSpecialLoaderCallback

private static class specialId extends EntityLoader
{

    private DaoSpecial specialDao;
    private String specialId;

    public Special loadInBackground()
    {
        Object obj;
        try
        {
            obj = specialDao.queryBuilder().where().eq("remoteId", specialId);
            obj = (Special)specialDao.queryForFirst(((Where) (obj)).prepare());
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        return ((Special) (obj));
    }

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    protected boolean shouldReload(BusinessSpecialUpdateEvent businessspecialupdateevent)
    {
        return businessspecialupdateevent.getSpecialId().equalsIgnoreCase(specialId);
    }

    protected volatile boolean shouldReload(UpdateEvent updateevent)
    {
        return shouldReload((BusinessSpecialUpdateEvent)updateevent);
    }

    public (Class class1, Class class2, Context context, String s)
    {
        super(class1, class2, context);
        RoboGuice.getInjector(context).injectMembers(this);
        specialId = s;
    }
}
