// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.contentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.amazon.mShop.details.ProductDetailsActivity;
import com.amazon.mShop.util.DBException;
import com.amazon.mShop.util.DatabaseHelper;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.HomeItem;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import java.util.Iterator;
import java.util.List;

public class AIVWidgetDatabaseHelper extends DatabaseHelper
{

    protected static final String FIREVIEW_CONTENT_COLUMN[] = {
        "key", "thumbnailUri", "previewUri", "viewIntentUri", "productTitle", "reviewQty", "reviewAvg", "violatesMap", "buyingPrice", "isPrimeEligible", 
        "dealTitle", "dealCategory", "listPrice", "byLine", "savingsMessage", "prePromoPrice", "featuredCategory"
    };
    private static final String TAG = com/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper.getSimpleName();
    private static volatile AIVWidgetDatabaseHelper sInstance = null;

    private AIVWidgetDatabaseHelper(Context context)
    {
        super(context.getApplicationContext(), "mShop_aiv.db", 1);
    }

    public static AIVWidgetDatabaseHelper getInstance(Context context)
    {
        com/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;
        JVM INSTR monitorenter ;
        if (sInstance == null)
        {
            sInstance = new AIVWidgetDatabaseHelper(context.getApplicationContext());
        }
        context = sInstance;
        com/amazon/mShop/contentprovider/AIVWidgetDatabaseHelper;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private void handleDBUpgradeAndDowngrade(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.beginTransaction();
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS mShop_aiv");
        onCreate(sqlitedatabase);
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
        Exception exception;
        exception;
        sqlitedatabase.endTransaction();
        throw exception;
    }

    private void updateFireviewContent(HomeItem homeitem)
    {
        SQLiteDatabase sqlitedatabase;
        if (homeitem.getBasicProduct() == null)
        {
            return;
        }
        sqlitedatabase = getWritableDatabase();
        sqlitedatabase.beginTransaction();
        ContentValues contentvalues;
        String s;
        contentvalues = new ContentValues();
        contentvalues.put("key", homeitem.getAsin());
        contentvalues.put("viewIntentUri", ProductDetailsActivity.getViewIntentUri(homeitem.getAsin(), mContext));
        contentvalues.put("dealCategory", "FEATURED");
        contentvalues.put("featuredCategory", "aiv_shoveler_item");
        s = homeitem.getBasicProduct().getImageUrl();
        if (s == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        contentvalues.put("thumbnailUri", s);
        contentvalues.put("previewUri", s);
        homeitem = homeitem.getBasicProduct().getTitle();
        if (homeitem == null)
        {
            break MISSING_BLOCK_LABEL_117;
        }
        contentvalues.put("productTitle", homeitem);
        sqlitedatabase.insert("mShop_aiv", null, contentvalues);
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
        homeitem;
        com.amazon.mShop.util.DebugUtil.Log.e(TAG, homeitem.getMessage(), homeitem);
        sqlitedatabase.endTransaction();
        return;
        homeitem;
        sqlitedatabase.endTransaction();
        throw homeitem;
    }

    public void cleanOldHomeShovelerContent()
        throws DBException
    {
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = getWritableDatabase();
        sqlitedatabase.beginTransaction();
        sqlitedatabase.delete("mShop_aiv", null, null);
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
        Exception exception;
        exception;
        sqlitedatabase.endTransaction();
        throw exception;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        StringBuilder stringbuilder = new StringBuilder("CREATE TABLE mShop_aiv(id INTEGER PRIMARY KEY AUTOINCREMENT");
        String as[] = FIREVIEW_CONTENT_COLUMN;
        int j = as.length;
        for (int i = 0; i < j; i++)
        {
            String s = as[i];
            stringbuilder.append(", ").append(s).append(" TEXT");
        }

        stringbuilder.append(")");
        sqlitedatabase.execSQL(stringbuilder.toString());
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        handleDBUpgradeAndDowngrade(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        handleDBUpgradeAndDowngrade(sqlitedatabase);
    }

    public void updateHomeShovelerItems(HomeShoveler homeshoveler)
    {
        cleanOldHomeShovelerContent();
        for (homeshoveler = homeshoveler.getItems().iterator(); homeshoveler.hasNext(); updateFireviewContent((HomeItem)homeshoveler.next())) { }
    }

}
