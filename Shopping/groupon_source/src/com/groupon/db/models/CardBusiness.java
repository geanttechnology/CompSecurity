// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.models;

import android.content.Context;
import com.groupon.db.dao.DaoBusiness;
import com.groupon.util.BuyUtils;
import java.sql.SQLException;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

// Referenced classes of package com.groupon.db.models:
//            Card, Business

public class CardBusiness extends Card
{

    private DaoBusiness businessDao;
    private BuyUtils buyUtil;

    public CardBusiness()
    {
    }

    public void save(String s, Context context, int i, int j)
        throws SQLException
    {
        RoboGuice.getInjector(context).injectMembers(this);
        ((Business)data).channel = s;
        ((Business)data).derivedActualPosition = i;
        ((Business)data).derivedTrackingPosition = j;
        ((Business)data).afterJsonDeserializationPostProcessor(buyUtil);
        businessDao.save((Business)data);
    }
}
