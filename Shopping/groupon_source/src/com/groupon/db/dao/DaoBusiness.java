// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import android.app.Application;
import android.content.Context;
import com.groupon.db.models.Business;
import com.groupon.db.models.Category;
import com.groupon.db.models.Deal;
import com.groupon.db.models.Location;
import com.groupon.db.models.Special;
import com.groupon.db.models.Tip;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao, DaoTip, DaoLocation, DaoSpecial, 
//            DaoCategory, DaoDeal

public class DaoBusiness extends GrouponBaseDao
{

    private Lazy categoryDao;
    private Lazy dealDao;
    private Lazy locationDao;
    private Lazy specialDao;
    private Lazy tipDao;

    public DaoBusiness(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public void clearByChannelId(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("channel", s);
        deletebuilder.delete();
    }

    public int deleteByChannelPrefix(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().like("channel", (new StringBuilder()).append(s).append('%').toString());
        return deletebuilder.delete();
    }

    public void save(Business business)
        throws SQLException
    {
        ((DaoTip)tipDao.get()).clearByBusinessChannelId(business.remoteId);
        createIfNotExists(business);
        Location location;
        for (Iterator iterator = business.getLocations().iterator(); iterator.hasNext(); ((DaoLocation)locationDao.get()).create(location))
        {
            location = (Location)iterator.next();
        }

        for (Iterator iterator1 = business.getSpecials().iterator(); iterator1.hasNext();)
        {
            Object obj = (Special)iterator1.next();
            try
            {
                ((DaoSpecial)specialDao.get()).create(obj);
                obj = ((Special) (obj)).getCategories().iterator();
                while (((Iterator) (obj)).hasNext()) 
                {
                    Category category = (Category)((Iterator) (obj)).next();
                    ((DaoCategory)categoryDao.get()).create(category);
                }
            }
            catch (SQLException sqlexception1) { }
        }

        Tip tip;
        for (Iterator iterator2 = business.getTips().iterator(); iterator2.hasNext(); ((DaoTip)tipDao.get()).create(tip))
        {
            tip = (Tip)iterator2.next();
            tip.businessChannelId = business.remoteId;
        }

        for (business = business.getDeals().iterator(); business.hasNext();)
        {
            Deal deal = (Deal)business.next();
            try
            {
                ((DaoDeal)dealDao.get()).save(deal);
            }
            catch (SQLException sqlexception) { }
        }

    }

    public void setApplication(Application application)
    {
        super.setApplication(application);
        dealDao = new Lazy(application) {

            final DaoBusiness this$0;

            
            {
                this$0 = DaoBusiness.this;
                super(context);
            }
        };
        tipDao = new Lazy(application) {

            final DaoBusiness this$0;

            
            {
                this$0 = DaoBusiness.this;
                super(context);
            }
        };
        categoryDao = new Lazy(application) {

            final DaoBusiness this$0;

            
            {
                this$0 = DaoBusiness.this;
                super(context);
            }
        };
        specialDao = new Lazy(application) {

            final DaoBusiness this$0;

            
            {
                this$0 = DaoBusiness.this;
                super(context);
            }
        };
        locationDao = new Lazy(application) {

            final DaoBusiness this$0;

            
            {
                this$0 = DaoBusiness.this;
                super(context);
            }
        };
    }
}
