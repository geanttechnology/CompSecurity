// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.crittercism.app.Crittercism;
import com.groupon.db.models.Band;
import com.groupon.db.models.BugReportEmail;
import com.groupon.db.models.Business;
import com.groupon.db.models.BusinessSummary;
import com.groupon.db.models.CategorizationItem;
import com.groupon.db.models.Category;
import com.groupon.db.models.CollectionCardAttribute;
import com.groupon.db.models.CouponCategory;
import com.groupon.db.models.CouponDetail;
import com.groupon.db.models.CouponMerchant;
import com.groupon.db.models.CouponSummary;
import com.groupon.db.models.CustomField;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealCollection;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.DealType;
import com.groupon.db.models.DeliveryEstimation;
import com.groupon.db.models.Division;
import com.groupon.db.models.ExternalDealProvider;
import com.groupon.db.models.Finder;
import com.groupon.db.models.GiftWrappingCharge;
import com.groupon.db.models.GiftingCategory;
import com.groupon.db.models.GiftingTheme;
import com.groupon.db.models.Hotel;
import com.groupon.db.models.HotelReview;
import com.groupon.db.models.HotelReviews;
import com.groupon.db.models.Image;
import com.groupon.db.models.InAppMessage;
import com.groupon.db.models.Incentive;
import com.groupon.db.models.InventoryService;
import com.groupon.db.models.LegalDisclosure;
import com.groupon.db.models.Location;
import com.groupon.db.models.MarketRateResult;
import com.groupon.db.models.Merchant;
import com.groupon.db.models.Option;
import com.groupon.db.models.Pagination;
import com.groupon.db.models.Price;
import com.groupon.db.models.PricingMetadata;
import com.groupon.db.models.Rating;
import com.groupon.db.models.Recommendation;
import com.groupon.db.models.SchedulerOption;
import com.groupon.db.models.Shipment;
import com.groupon.db.models.ShippingOption;
import com.groupon.db.models.SnapGroceryDetail;
import com.groupon.db.models.Special;
import com.groupon.db.models.StockCategory;
import com.groupon.db.models.StockValue;
import com.groupon.db.models.Tip;
import com.groupon.db.models.Trait;
import com.groupon.db.models.UiTreatment;
import com.groupon.db.models.Video;
import com.groupon.db.models.WidgetSummary;
import com.groupon.db.models.mygroupons.MyGrouponItem;
import com.groupon.db.models.mygroupons.MyGrouponItemSummary;
import com.groupon.tracking.mobile.sdk.Logger;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import roboguice.RoboGuice;
import roboguice.inject.ContextScopedRoboInjector;
import roboguice.util.Ln;

public class GrouponOrmLiteHelper extends OrmLiteSqliteOpenHelper
{

    private static final String DATABASE_NAME = "deals_v2.db";
    private static final int DATABASE_VERSION = 61;
    private static final Class cacheManagementTables[] = {
        com/groupon/db/models/DealSummary, com/groupon/db/models/Deal, com/groupon/db/models/Location, com/groupon/db/models/Option, com/groupon/db/models/Price, com/groupon/db/models/Rating, com/groupon/db/models/Tip, com/groupon/db/models/Recommendation, com/groupon/db/models/Image, com/groupon/db/models/Pagination, 
        com/groupon/db/models/DealType, com/groupon/db/models/CategorizationItem, com/groupon/db/models/Division, com/groupon/db/models/Merchant, com/groupon/db/models/InAppMessage, com/groupon/db/models/PricingMetadata, com/groupon/db/models/SchedulerOption, com/groupon/db/models/InventoryService, com/groupon/db/models/GiftWrappingCharge, com/groupon/db/models/Shipment, 
        com/groupon/db/models/ShippingOption, com/groupon/db/models/DealSubsetAttribute, com/groupon/db/models/WidgetSummary, com/groupon/db/models/Trait, com/groupon/db/models/mygroupons/MyGrouponItem, com/groupon/db/models/mygroupons/MyGrouponItemSummary, com/groupon/db/models/Business, com/groupon/db/models/BusinessSummary, com/groupon/db/models/Special, com/groupon/db/models/Category, 
        com/groupon/db/models/CustomField, com/groupon/db/models/StockCategory, com/groupon/db/models/StockValue, com/groupon/db/models/Incentive, com/groupon/db/models/Video, com/groupon/db/models/LegalDisclosure, com/groupon/db/models/MarketRateResult, com/groupon/db/models/Hotel, com/groupon/db/models/HotelReviews, com/groupon/db/models/HotelReview, 
        com/groupon/db/models/CouponMerchant, com/groupon/db/models/CouponCategory, com/groupon/db/models/CouponSummary, com/groupon/db/models/CouponDetail, com/groupon/db/models/ExternalDealProvider, com/groupon/db/models/SnapGroceryDetail, com/groupon/db/models/Finder, com/groupon/db/models/Band, com/groupon/db/models/DealCollection, com/groupon/db/models/CollectionCardAttribute, 
        com/groupon/db/models/UiTreatment, com/groupon/db/models/GiftingCategory, com/groupon/db/models/GiftingTheme, com/groupon/db/models/DeliveryEstimation
    };
    public static final List dealTables = Collections.unmodifiableList(Arrays.asList(new Class[] {
        com/groupon/db/models/DealSummary, com/groupon/db/models/Deal, com/groupon/db/models/Location, com/groupon/db/models/Option, com/groupon/db/models/Price, com/groupon/db/models/PricingMetadata, com/groupon/db/models/Rating, com/groupon/db/models/Tip, com/groupon/db/models/Recommendation, com/groupon/db/models/Image, 
        com/groupon/db/models/Pagination, com/groupon/db/models/DealType, com/groupon/db/models/CategorizationItem, com/groupon/db/models/Division, com/groupon/db/models/Merchant, com/groupon/db/models/InAppMessage, com/groupon/db/models/ShippingOption, com/groupon/db/models/SchedulerOption, com/groupon/db/models/InventoryService, com/groupon/db/models/GiftWrappingCharge, 
        com/groupon/db/models/Shipment, com/groupon/db/models/DealSubsetAttribute, com/groupon/db/models/Trait, com/groupon/db/models/WidgetSummary, com/groupon/db/models/mygroupons/MyGrouponItem, com/groupon/db/models/mygroupons/MyGrouponItemSummary, com/groupon/db/models/Business, com/groupon/db/models/BusinessSummary, com/groupon/db/models/Special, com/groupon/db/models/Category, 
        com/groupon/db/models/CustomField, com/groupon/db/models/StockCategory, com/groupon/db/models/StockValue, com/groupon/db/models/Incentive, com/groupon/db/models/Video, com/groupon/db/models/LegalDisclosure, com/groupon/db/models/MarketRateResult, com/groupon/db/models/Hotel, com/groupon/db/models/HotelReviews, com/groupon/db/models/HotelReview, 
        com/groupon/db/models/CouponSummary, com/groupon/db/models/CouponDetail, com/groupon/db/models/CouponMerchant, com/groupon/db/models/CouponCategory, com/groupon/db/models/ExternalDealProvider, com/groupon/db/models/SnapGroceryDetail, com/groupon/db/models/Band, com/groupon/db/models/Finder, com/groupon/db/models/DealCollection, com/groupon/db/models/CollectionCardAttribute, 
        com/groupon/db/models/UiTreatment, com/groupon/db/models/GiftingCategory, com/groupon/db/models/GiftingTheme, com/groupon/db/models/DeliveryEstimation
    }));
    private static final Class doNotClearTables[] = {
        com/groupon/db/models/BugReportEmail
    };
    private static final Class otherTables[] = {
        com/groupon/db/models/BugReportEmail
    };
    private final Context context;
    private Logger logger;

    public GrouponOrmLiteHelper(Context context1)
    {
        super(context1.getApplicationContext(), "deals_v2.db", null, 61, 0x7f070005);
        context = context1.getApplicationContext();
    }

    public void checkTableAdded()
    {
        if (dealTables.size() + otherTables.length != cacheManagementTables.length + doNotClearTables.length)
        {
            throw new RuntimeException(new SQLException());
        } else
        {
            return;
        }
    }

    public void clearCacheManagementTables()
    {
        clearTables(cacheManagementTables);
    }

    public void clearTables(Class aclass[])
    {
        Class class1;
        int i;
        int j;
        try
        {
            j = aclass.length;
        }
        // Misplaced declaration of an exception variable
        catch (Class aclass[])
        {
            throw new RuntimeException(aclass);
        }
        i = 0;
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        class1 = aclass[i];
        TableUtils.clearTable(getConnectionSource(), class1);
        i++;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_6;
_L1:
    }

    public void onCreate(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource)
    {
        try
        {
            for (sqlitedatabase = dealTables.iterator(); sqlitedatabase.hasNext(); TableUtils.createTable(connectionsource, (Class)sqlitedatabase.next())) { }
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            throw new RuntimeException(sqlitedatabase);
        }
        int j;
        sqlitedatabase = otherTables;
        j = sqlitedatabase.length;
        int i = 0;
_L2:
        if (i >= j)
        {
            break; /* Loop/switch isn't completed */
        }
        TableUtils.createTable(connectionsource, sqlitedatabase[i]);
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        super.onOpen(sqlitedatabase);
        logger = (Logger)RoboGuice.getInjector(context).getInstance(com/groupon/tracking/mobile/sdk/Logger);
        sqlitedatabase.execSQL("PRAGMA foreign_keys=ON;");
        boolean flag = sqlitedatabase.enableWriteAheadLogging();
        if (!flag)
        {
            logger.logGeneralEvent("databaseV2", "enableWriteAheadLogging", "", 0, Logger.NULL_NST_FIELD);
        }
_L2:
        return;
        sqlitedatabase;
        Ln.w(sqlitedatabase);
        Crittercism.logHandledException(sqlitedatabase);
        if (false) goto _L2; else goto _L1
_L1:
        logger.logGeneralEvent("databaseV2", "enableWriteAheadLogging", "", 0, Logger.NULL_NST_FIELD);
        return;
        sqlitedatabase;
        if (true)
        {
            logger.logGeneralEvent("databaseV2", "enableWriteAheadLogging", "", 0, Logger.NULL_NST_FIELD);
        }
        throw sqlitedatabase;
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource, int i, int j)
    {
        Cursor cursor;
        Log.w(com/groupon/db/GrouponOrmLiteHelper.getName(), (new StringBuilder()).append("Upgrading database from version ").append(i).append(" to ").append(j).append(", which will destroy all old data").toString());
        cursor = sqlitedatabase.rawQuery("select tbl_name from sqlite_master where type=?", new String[] {
            "table"
        });
        if (cursor == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        break MISSING_BLOCK_LABEL_70;
        sqlitedatabase;
        cursor.close();
        throw sqlitedatabase;
        do
        {
            if (!cursor.moveToNext())
            {
                break;
            }
            String s = cursor.getString(0);
            if (!s.startsWith("android") && !s.startsWith("sqlite"))
            {
                sqlitedatabase.execSQL((new StringBuilder()).append("drop table ").append(s).toString());
            }
        } while (true);
        cursor.close();
        onCreate(sqlitedatabase, connectionsource);
        return;
    }

}
