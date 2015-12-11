// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import android.content.Context;
import com.groupon.db.dao.DaoBand;
import java.sql.SQLException;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.db.models:
//            Card, Band

public class CardBand extends Card
{

    private DaoBand bandDao;

    public CardBand()
    {
    }

    public void save(String s, Context context, int i, int j)
        throws SQLException
    {
        RoboGuice.getInjector(context).injectMembers(this);
        ((Band)data).channel = s;
        ((Band)data).derivedActualPosition = i;
        ((Band)data).derivedTrackingPosition = j;
        bandDao.create(data);
    }
}
