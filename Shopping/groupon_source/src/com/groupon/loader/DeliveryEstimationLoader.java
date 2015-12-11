// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import com.groupon.db.dao.DaoDeliveryEstimation;
import com.groupon.db.events.DeliveryEstimationUpdateEvent;
import com.groupon.db.models.DeliveryEstimation;
import commonlib.loader.EntityLoader;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class DeliveryEstimationLoader extends EntityLoader
{

    private String dealUuid;
    private DaoDeliveryEstimation deliveryAndEstimationDao;

    public DeliveryEstimationLoader(Class class1, Class class2, Context context, String s, String s1)
    {
        super(class1, class2, context);
        RoboGuice.getInjector(context).injectMembers(this);
        dealUuid = s;
    }

    public DeliveryEstimation loadInBackground()
    {
        DeliveryEstimation deliveryestimation;
        try
        {
            deliveryestimation = (DeliveryEstimation)deliveryAndEstimationDao.queryForFirstEq("dealUuid", dealUuid);
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        return deliveryestimation;
    }

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    protected boolean shouldReload(DeliveryEstimationUpdateEvent deliveryestimationupdateevent)
    {
        return deliveryestimationupdateevent.getDealUuid().equals(dealUuid);
    }

    protected volatile boolean shouldReload(UpdateEvent updateevent)
    {
        return shouldReload((DeliveryEstimationUpdateEvent)updateevent);
    }
}
