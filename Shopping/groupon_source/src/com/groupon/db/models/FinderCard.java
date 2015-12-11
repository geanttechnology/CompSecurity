// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import android.content.Context;
import com.groupon.db.dao.DaoFinder;
import java.sql.SQLException;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.db.models:
//            Card, Finder

public class FinderCard extends Card
{

    private DaoFinder finderDao;

    public FinderCard()
    {
    }

    public void save(String s, Context context, int i, int j)
        throws SQLException
    {
        RoboGuice.getInjector(context).injectMembers(this);
        ((Finder)data).channel = s;
        ((Finder)data).derivedActualPosition = i;
        ((Finder)data).derivedTrackingPosition = j;
        ((Finder)data).afterJsonDeserializationPostProcessor();
        finderDao.save((Finder)data);
    }
}
