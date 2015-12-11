// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import android.content.Context;
import com.groupon.db.dao.DaoCollection;
import java.sql.SQLException;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.db.models:
//            Card, DealCollection

public class CollectionCard extends Card
{

    private DaoCollection collectionDao;

    public CollectionCard()
    {
    }

    public void save(String s, Context context, int i, int j)
        throws SQLException
    {
        RoboGuice.getInjector(context).injectMembers(this);
        ((DealCollection)data).channel = s;
        ((DealCollection)data).derivedActualPosition = i;
        ((DealCollection)data).derivedTrackingPosition = j;
        ((DealCollection)data).afterJsonDeserializationPostProcessor();
        collectionDao.save((DealCollection)data);
    }
}
