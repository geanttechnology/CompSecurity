// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.dao.DaoTip;
import com.groupon.db.events.BusinessTipsUpdateEvent;
import com.groupon.db.models.Pagination;
import com.groupon.models.EndlessList;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Strings;

// Referenced classes of package com.groupon.fragment:
//            BusinessTipsFragment

private static class tipsBusinessChannelId extends commonlib.loader.der
{

    private DaoPagination paginationDao;
    private DaoTip tipDao;
    private String tipsBusinessChannelId;

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    public List loadInBackground()
    {
        Object obj;
        Pagination pagination;
        int i;
        int j;
        int k;
        try
        {
            obj = tipDao.queryBuilder().orderBy("updatedAt", false).where().eq("businessChannelId", tipsBusinessChannelId);
            obj = tipDao.query(((Where) (obj)).prepare());
            pagination = (Pagination)paginationDao.queryForFirstEq("channel", tipsBusinessChannelId);
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        j = 0;
        k = 0;
        i = 0;
        if (pagination == null)
        {
            break MISSING_BLOCK_LABEL_94;
        }
        i = k;
        if (pagination.hasMorePages())
        {
            i = pagination.getCount();
        }
        k = pagination.getCurrentOffset();
        j = i;
        i = k;
        obj = new EndlessList(((List) (obj)), j, i, null);
        return ((List) (obj));
    }

    protected boolean shouldReload(BusinessTipsUpdateEvent businesstipsupdateevent)
    {
        return Strings.equals(businesstipsupdateevent.getBusinessId(), tipsBusinessChannelId);
    }

    protected volatile boolean shouldReload(UpdateEvent updateevent)
    {
        return shouldReload((BusinessTipsUpdateEvent)updateevent);
    }

    public (Class class1, Class class2, Context context, String s)
    {
        super(class1, class2, context);
        RoboGuice.getInjector(context).injectMembers(this);
        tipsBusinessChannelId = s;
    }
}
