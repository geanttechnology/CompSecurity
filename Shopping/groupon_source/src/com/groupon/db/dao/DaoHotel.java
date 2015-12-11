// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import android.app.Application;
import android.content.Context;
import com.groupon.db.models.Hotel;
import com.groupon.db.models.HotelReview;
import com.groupon.db.models.HotelReviews;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao, DaoHotelReviews, DaoHotelReview

public class DaoHotel extends GrouponBaseDao
{

    private Lazy daoHotelReview;
    private Lazy daoHotelReviews;

    public DaoHotel(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public Hotel getByHotelId(String s)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        Where where = querybuilder.where();
        where.eq("remoteId", s);
        querybuilder.setWhere(where);
        return (Hotel)queryForFirst(querybuilder.prepare());
    }

    public void replace(Hotel hotel)
        throws SQLException
    {
        Object obj = deleteBuilder();
        ((DeleteBuilder) (obj)).where().eq("remoteId", hotel.remoteId);
        ((DeleteBuilder) (obj)).delete();
        create(hotel);
        obj = hotel.hotelReviews.iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            HotelReviews hotelreviews = (HotelReviews)((Iterator) (obj)).next();
            hotelreviews.parentHotel = hotel;
            ((DaoHotelReviews)daoHotelReviews.get()).create(hotelreviews);
            if (hotelreviews.reviews != null)
            {
                Iterator iterator = hotelreviews.reviews.iterator();
                while (iterator.hasNext()) 
                {
                    HotelReview hotelreview = (HotelReview)iterator.next();
                    hotelreview.parentHotelReviews = hotelreviews;
                    ((DaoHotelReview)daoHotelReview.get()).create(hotelreview);
                }
            }
        } while (true);
    }

    public void setApplication(Application application)
    {
        super.setApplication(application);
        daoHotelReviews = new Lazy(application) {

            final DaoHotel this$0;

            
            {
                this$0 = DaoHotel.this;
                super(context);
            }
        };
        daoHotelReview = new Lazy(application) {

            final DaoHotel this$0;

            
            {
                this$0 = DaoHotel.this;
                super(context);
            }
        };
    }
}
