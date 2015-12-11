// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import android.app.Application;
import android.content.Context;
import com.groupon.db.models.CouponMerchant;
import com.groupon.db.models.Location;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao, DaoLocation

public class DaoCouponMerchant extends GrouponBaseDao
{

    private Lazy locationDao;

    public DaoCouponMerchant(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public void deleteForChannel(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("channel", s);
        deletebuilder.delete();
    }

    public CouponMerchant getCouponMerchant(String s, String s1)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        querybuilder.where().eq("remoteId", s).and().eq("channel", s1).prepare();
        return (CouponMerchant)queryForFirst(querybuilder.prepare());
    }

    public CouponMerchant getFirstCouponMerchant(String s)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        querybuilder.where().eq("channel", s).prepare();
        return (CouponMerchant)queryForFirst(querybuilder.prepare());
    }

    public long getLastUpdated(String s)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        querybuilder.where().eq("channel", s);
        s = (CouponMerchant)queryForFirst(querybuilder.prepare());
        if (s != null)
        {
            return ((CouponMerchant) (s)).modificationDate.getTime();
        } else
        {
            return 0L;
        }
    }

    public void saveCouponMerchant(CouponMerchant couponmerchant)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("remoteId", couponmerchant.getRemoteId()).and().eq("channel", couponmerchant.channel);
        deletebuilder.delete();
        create(couponmerchant);
        Location location;
        for (couponmerchant = couponmerchant.getMerchantLocations().iterator(); couponmerchant.hasNext(); ((DaoLocation)locationDao.get()).create(location))
        {
            location = (Location)couponmerchant.next();
        }

    }

    public void setApplication(Application application)
    {
        super.setApplication(application);
        locationDao = new Lazy(application) {

            final DaoCouponMerchant this$0;

            
            {
                this$0 = DaoCouponMerchant.this;
                super(context);
            }
        };
    }
}
