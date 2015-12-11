// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import android.app.Application;
import android.content.Context;
import com.groupon.db.models.Location;
import com.groupon.db.models.Shipment;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.UpdateBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao, DaoLocation, DaoShipment

public class DaoMyGrouponItem extends GrouponBaseDao
{

    private Lazy locationDao;
    private Lazy shipmentDao;

    public DaoMyGrouponItem(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public void clearAll()
        throws SQLException
    {
        delete(deleteBuilder().prepare());
    }

    public void deleteRecordsForCategory(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        Where where = deletebuilder.where();
        where.eq("category", s);
        deletebuilder.setWhere(where);
        deletebuilder.delete();
    }

    public long getLastUpdatedByGrouponId(String s)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        querybuilder.where().eq("remoteId", s);
        s = (MyGrouponItem)queryForFirst(querybuilder.prepare());
        if (s != null)
        {
            return ((MyGrouponItem) (s)).modificationDate.getTime();
        } else
        {
            return 0L;
        }
    }

    public void removeMyGrouponItem(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("remoteId", s);
        deletebuilder.delete();
    }

    public void save(MyGrouponItem mygrouponitem)
        throws SQLException
    {
        removeMyGrouponItem(mygrouponitem.remoteId);
        create(mygrouponitem);
        Location location;
        for (Iterator iterator = mygrouponitem.getRedemptionLocations().iterator(); iterator.hasNext(); ((DaoLocation)locationDao.get()).create(location))
        {
            location = (Location)iterator.next();
        }

        Shipment shipment;
        for (mygrouponitem = mygrouponitem.getShipments().iterator(); mygrouponitem.hasNext(); ((DaoShipment)shipmentDao.get()).create(shipment))
        {
            shipment = (Shipment)mygrouponitem.next();
        }

    }

    public void setApplication(Application application)
    {
        super.setApplication(application);
        locationDao = new Lazy(application) {

            final DaoMyGrouponItem this$0;

            
            {
                this$0 = DaoMyGrouponItem.this;
                super(context);
            }
        };
        shipmentDao = new Lazy(application) {

            final DaoMyGrouponItem this$0;

            
            {
                this$0 = DaoMyGrouponItem.this;
                super(context);
            }
        };
    }

    public void updateBookingStatusById(String s, String s1)
        throws SQLException
    {
        UpdateBuilder updatebuilder = updateBuilder();
        Where where = updatebuilder.where();
        where.eq("remoteId", s);
        updatebuilder.updateColumnValue("localBookingInfoStatus", s1);
        updatebuilder.setWhere(where);
        updatebuilder.update();
    }

    public void updateGrouponNumberAndLocatedById(String s, String s1, boolean flag)
        throws SQLException
    {
        UpdateBuilder updatebuilder = updateBuilder();
        Where where = updatebuilder.where();
        where.eq("remoteId", s);
        updatebuilder.updateColumnValue("grouponNumber", s1);
        updatebuilder.updateColumnValue("located", Boolean.valueOf(flag));
        updatebuilder.setWhere(where);
        updatebuilder.update();
    }
}
