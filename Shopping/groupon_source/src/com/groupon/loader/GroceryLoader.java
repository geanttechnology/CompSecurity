// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.loader;

import android.content.Context;
import com.groupon.db.dao.DaoSnapGroceryDetails;
import com.groupon.db.events.GroceryUpdateEvent;
import com.groupon.db.models.SnapGroceryDetail;
import commonlib.loader.EntityLoader;
import commonlib.loader.event.UpdateEvent;
import java.sql.SQLException;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;

public class GroceryLoader extends EntityLoader
{

    DaoSnapGroceryDetails daoSnapGroceryDetails;
    protected String dbChannel;
    protected String groceryId;

    public GroceryLoader(Class class1, Class class2, Context context, String s, String s1)
    {
        super(class1, class2, context);
        RoboGuice.getInjector(context).injectMembers(this);
        groceryId = s;
        dbChannel = s1;
    }

    public SnapGroceryDetail loadInBackground()
    {
        SnapGroceryDetail snapgrocerydetail;
        try
        {
            snapgrocerydetail = daoSnapGroceryDetails.getByGroceryId(groceryId);
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        return snapgrocerydetail;
    }

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    protected boolean shouldReload(GroceryUpdateEvent groceryupdateevent)
    {
        return groceryupdateevent.getGroceryId().equalsIgnoreCase(groceryId);
    }

    protected volatile boolean shouldReload(UpdateEvent updateevent)
    {
        return shouldReload((GroceryUpdateEvent)updateevent);
    }
}
