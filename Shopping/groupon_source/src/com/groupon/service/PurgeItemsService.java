// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.groupon.db.dao.DaoBusiness;
import com.groupon.db.dao.DaoBusinessSummary;
import com.groupon.db.dao.DaoCouponCategory;
import com.groupon.db.dao.DaoCouponDetail;
import com.groupon.db.dao.DaoCouponMerchant;
import com.groupon.db.dao.DaoCouponSummary;
import com.groupon.db.dao.DaoDeal;
import com.groupon.db.dao.DaoDealSubsetAttribute;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.dao.DaoHotel;
import com.groupon.db.dao.DaoMarketRateResult;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.dao.DaoSnapGroceryDetails;
import com.groupon.db.dao.DaoStockCategory;
import com.groupon.db.dao.DaoWidgetSummary;
import com.groupon.db.models.Pagination;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import roboguice.util.Ln;

// Referenced classes of package com.groupon.service:
//            GrouponRoboWakefulIntentService

public class PurgeItemsService extends GrouponRoboWakefulIntentService
{

    private static int PURGE_ITEMS_REQUEST_CODE = 100;
    protected DaoBusiness daoBusiness;
    protected DaoBusinessSummary daoBusinessSummary;
    protected DaoCouponCategory daoCouponCategory;
    protected DaoCouponDetail daoCouponDetail;
    protected DaoCouponMerchant daoCouponMerchant;
    protected DaoCouponSummary daoCouponSummary;
    private DaoDeal daoDeal;
    protected DaoDealSubsetAttribute daoDealSubsetAttribute;
    private DaoDealSummary daoDealSummary;
    private DaoHotel daoHotel;
    private DaoMarketRateResult daoMarketRateResult;
    protected DaoPagination daoPagination;
    protected DaoSnapGroceryDetails daoSnapGroceryDetails;
    protected DaoStockCategory daoStockCategory;
    private DaoWidgetSummary daoWidgetSummary;

    public PurgeItemsService()
    {
        super("PurgeItemsService");
        Ln.d("PurgeItemsService: Starting PurgeItemsService", new Object[0]);
    }

    public static PendingIntent getIntentForAppCreate(Context context)
    {
        Intent intent = new Intent(context, com/groupon/service/PurgeItemsService);
        return PendingIntent.getService(context, PURGE_ITEMS_REQUEST_CODE, intent, 0x8000000);
    }

    public static boolean isAlarmSet(Context context)
    {
        Intent intent = new Intent(context, com/groupon/service/PurgeItemsService);
        return PendingIntent.getService(context, PURGE_ITEMS_REQUEST_CODE, intent, 0x20000000) != null;
    }

    protected void doWakefulWork(Intent intent)
    {
        Ln.d("PurgeItemsService: Start purge items", new Object[0]);
        purgeTables();
        Ln.d("PurgeItemsService: End purge items", new Object[0]);
        return;
        intent;
        Ln.e((new StringBuilder()).append("PurgeItemsService: Error on purge items ").append(intent.getMessage()).toString(), new Object[0]);
        Ln.d("PurgeItemsService: End purge items", new Object[0]);
        return;
        intent;
        Ln.d("PurgeItemsService: End purge items", new Object[0]);
        throw intent;
    }

    public void purgeTables()
    {
        Object obj;
        try
        {
            obj = new Date(System.currentTimeMillis() - 0x5265c00L);
            Pagination pagination;
            for (Iterator iterator = daoPagination.queryBuilder().where().lt("modificationDate", obj).query().iterator(); iterator.hasNext(); daoPagination.delete(pagination))
            {
                pagination = (Pagination)iterator.next();
                daoDealSummary.deleteByChannelId(pagination.getChannel());
                daoDealSubsetAttribute.deleteByChannelId(pagination.getChannel());
                daoMarketRateResult.deleteByChannelId(pagination.getChannel());
            }

        }
        // Misplaced declaration of an exception variable
        catch (Object obj)
        {
            Ln.w(((Throwable) (obj)));
            return;
        }
        DeleteBuilder deletebuilder = daoDeal.deleteBuilder();
        deletebuilder.where().lt("modificationDate", obj);
        deletebuilder.delete();
        deletebuilder = daoStockCategory.deleteBuilder();
        deletebuilder.where().lt("modificationDate", obj);
        deletebuilder.delete();
        deletebuilder = daoDealSummary.deleteBuilder();
        deletebuilder.where().lt("modificationDate", obj);
        deletebuilder.delete();
        deletebuilder = daoWidgetSummary.deleteBuilder();
        deletebuilder.where().lt("modificationDate", obj);
        deletebuilder.delete();
        deletebuilder = daoMarketRateResult.deleteBuilder();
        deletebuilder.where().lt("modificationDate", obj);
        deletebuilder.delete();
        deletebuilder = daoHotel.deleteBuilder();
        deletebuilder.where().lt("modificationDate", obj);
        deletebuilder.delete();
        deletebuilder = daoCouponDetail.deleteBuilder();
        deletebuilder.where().lt("modificationDate", obj);
        deletebuilder.delete();
        deletebuilder = daoCouponSummary.deleteBuilder();
        deletebuilder.where().lt("modificationDate", obj);
        deletebuilder.delete();
        deletebuilder = daoCouponMerchant.deleteBuilder();
        deletebuilder.where().lt("modificationDate", obj);
        deletebuilder.delete();
        deletebuilder = daoCouponCategory.deleteBuilder();
        deletebuilder.where().lt("modificationDate", obj);
        deletebuilder.delete();
        deletebuilder = daoBusiness.deleteBuilder();
        deletebuilder.where().lt("modificationDate", obj);
        deletebuilder.delete();
        deletebuilder = daoBusinessSummary.deleteBuilder();
        deletebuilder.where().lt("modificationDate", obj);
        deletebuilder.delete();
        deletebuilder = daoSnapGroceryDetails.deleteBuilder();
        deletebuilder.where().lt("modificationDate", obj);
        deletebuilder.delete();
        return;
    }

}
