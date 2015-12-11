// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.contentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import com.amazon.mShop.details.ProductDetailsActivity;
import com.amazon.mShop.ui.resources.BadgeType;
import com.amazon.mShop.util.DBException;
import com.amazon.mShop.util.DataUtil;
import com.amazon.mShop.util.DatabaseHelper;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.Badge;
import com.amazon.rio.j2me.client.services.mShop.BadgeInfo;
import com.amazon.rio.j2me.client.services.mShop.BasicOfferListing;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.HomeItem;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class WidgetDatabaseHelper extends DatabaseHelper
{
    private static final class DealCategory extends Enum
    {

        private static final DealCategory $VALUES[];
        public static final DealCategory FEATURED;
        public static final DealCategory S9;

        public static DealCategory valueOf(String s)
        {
            return (DealCategory)Enum.valueOf(com/amazon/mShop/contentprovider/WidgetDatabaseHelper$DealCategory, s);
        }

        public static DealCategory[] values()
        {
            return (DealCategory[])$VALUES.clone();
        }

        static 
        {
            FEATURED = new DealCategory("FEATURED", 0);
            S9 = new DealCategory("S9", 1);
            $VALUES = (new DealCategory[] {
                FEATURED, S9
            });
        }

        private DealCategory(String s, int i)
        {
            super(s, i);
        }
    }

    private static class FeaturedCategory extends Enum
    {

        private static final FeaturedCategory $VALUES[];
        public static final FeaturedCategory AIV_CONTENT_CATEGORY;
        public static final FeaturedCategory MSHOP_CONTENT_CATEGORY;

        public static FeaturedCategory valueOf(String s)
        {
            return (FeaturedCategory)Enum.valueOf(com/amazon/mShop/contentprovider/WidgetDatabaseHelper$FeaturedCategory, s);
        }

        public static FeaturedCategory[] values()
        {
            return (FeaturedCategory[])$VALUES.clone();
        }

        static 
        {
            MSHOP_CONTENT_CATEGORY = new FeaturedCategory("MSHOP_CONTENT_CATEGORY", 0) {

                public String toString()
                {
                    return "mshop_shoveler_item";
                }

            };
            AIV_CONTENT_CATEGORY = new FeaturedCategory("AIV_CONTENT_CATEGORY", 1) {

                public String toString()
                {
                    return "aiv_shoveler_item";
                }

            };
            $VALUES = (new FeaturedCategory[] {
                MSHOP_CONTENT_CATEGORY, AIV_CONTENT_CATEGORY
            });
        }

        private FeaturedCategory(String s, int i)
        {
            super(s, i);
        }

    }


    public static final String FIREVIEW_CONTENT_COLUMN[] = {
        "key", "thumbnailUri", "previewUri", "viewIntentUri", "productTitle", "reviewQty", "reviewAvg", "violatesMap", "buyingPrice", "isPrimeEligible", 
        "dealTitle", "dealCategory", "listPrice", "byLine", "savingsMessage", "prePromoPrice", "featuredCategory"
    };
    private static final String TAG = com/amazon/mShop/contentprovider/WidgetDatabaseHelper.getSimpleName();
    private static WidgetDatabaseHelper sInstance = null;
    private Executor mExecutor;

    private WidgetDatabaseHelper(Context context)
    {
        super(context, "mShop.db", 2);
        mExecutor = Executors.newSingleThreadExecutor();
    }

    public static WidgetDatabaseHelper getInstance(Context context)
    {
        com/amazon/mShop/contentprovider/WidgetDatabaseHelper;
        JVM INSTR monitorenter ;
        if (sInstance == null)
        {
            sInstance = new WidgetDatabaseHelper(context.getApplicationContext());
        }
        context = sInstance;
        com/amazon/mShop/contentprovider/WidgetDatabaseHelper;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private void handleDBUpgradeAndDowngrade(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.beginTransaction();
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS mShop");
        onCreate(sqlitedatabase);
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return;
        Exception exception;
        exception;
        sqlitedatabase.endTransaction();
        throw exception;
    }

    private boolean updateFireviewContent(HomeItem homeitem, Integer integer)
        throws DBException
    {
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = getWritableDatabase();
        sqlitedatabase.beginTransaction();
        ContentValues contentvalues;
        contentvalues = new ContentValues();
        contentvalues.put("key", homeitem.getAsin());
        contentvalues.put("viewIntentUri", ProductDetailsActivity.getViewIntentUri(homeitem.getAsin(), mContext));
        contentvalues.put("dealCategory", DealCategory.FEATURED.name());
        if (homeitem.getBasicProduct() != null)
        {
            if (homeitem.getBasicProduct().getImageUrl() != null)
            {
                contentvalues.put("thumbnailUri", homeitem.getBasicProduct().getImageUrl());
                contentvalues.put("previewUri", homeitem.getBasicProduct().getImageUrl());
            }
            if (homeitem.getBasicProduct().getTitle() != null)
            {
                contentvalues.put("productTitle", homeitem.getBasicProduct().getTitle());
            }
            contentvalues.put("reviewQty", Integer.toString(homeitem.getBasicProduct().getCustomerReviewsCount()));
            if (homeitem.getBasicProduct().getAverageOverallRating() != null)
            {
                contentvalues.put("reviewAvg", homeitem.getBasicProduct().getAverageOverallRating().toString());
            }
            if (homeitem.getBasicProduct().getListPrice() != null)
            {
                contentvalues.put("listPrice", homeitem.getBasicProduct().getListPrice());
            }
            if (homeitem.getBasicProduct().getByLine() != null)
            {
                contentvalues.put("byLine", homeitem.getBasicProduct().getByLine());
            }
        }
        if (homeitem.getBasicOffer() == null)
        {
            break MISSING_BLOCK_LABEL_350;
        }
        boolean flag1 = false;
        Object obj = homeitem.getBasicOffer().getBadgeInfo();
        boolean flag;
        flag = flag1;
        if (obj == null)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        flag = flag1;
        if (((BadgeInfo) (obj)).getBadge() == null)
        {
            break MISSING_BLOCK_LABEL_297;
        }
        obj = ((BadgeInfo) (obj)).getBadge().getType();
        BasicOfferListing basicofferlisting;
        BasicProductInfo basicproductinfo;
        if (!BadgeType.PRIME.name().equals(obj) && !BadgeType.PRIME_PLUS.name().equals(obj))
        {
            flag = false;
        } else
        {
            flag = true;
        }
        contentvalues.put("isPrimeEligible", Boolean.toString(flag));
        contentvalues.put("violatesMap", Boolean.toString(homeitem.getBasicOffer().getPriceViolatesMap()));
        if (homeitem.getBasicOffer().getPriceMessage() != null)
        {
            contentvalues.put("savingsMessage", homeitem.getBasicOffer().getPriceMessage());
        }
        obj = null;
        basicofferlisting = homeitem.getBasicOffer();
        basicproductinfo = homeitem.getBasicProduct();
        if (basicofferlisting != null) goto _L2; else goto _L1
_L1:
        homeitem = ((HomeItem) (obj));
        if (basicproductinfo == null)
        {
            break MISSING_BLOCK_LABEL_392;
        }
        homeitem = ((HomeItem) (obj));
        if (basicproductinfo.getVariationPriceRange() != null)
        {
            homeitem = basicproductinfo.getVariationPriceRange();
        }
_L6:
        if (!Util.isEmpty(homeitem))
        {
            contentvalues.put("buyingPrice", homeitem);
        }
        if (!DataUtil.isEqual(integer, 1)) goto _L4; else goto _L3
_L3:
        homeitem = FeaturedCategory.AIV_CONTENT_CATEGORY.toString();
_L8:
        if (!Util.isEmpty(homeitem))
        {
            contentvalues.put("featuredCategory", homeitem);
        }
        sqlitedatabase.insert("mShop", null, contentvalues);
        sqlitedatabase.setTransactionSuccessful();
        sqlitedatabase.endTransaction();
        return true;
_L2:
        homeitem = ((HomeItem) (obj));
        if (basicofferlisting.getPriceViolatesMap()) goto _L6; else goto _L5
_L5:
        if (basicproductinfo == null)
        {
            break MISSING_BLOCK_LABEL_499;
        }
        if (basicproductinfo.getVariationPriceRange() == null)
        {
            break MISSING_BLOCK_LABEL_499;
        }
        homeitem = basicproductinfo.getVariationPriceRange();
          goto _L6
        homeitem = ((HomeItem) (obj));
        if (basicofferlisting.getPrice() == null) goto _L6; else goto _L7
_L7:
        homeitem = basicofferlisting.getPrice();
          goto _L6
_L4:
        homeitem = FeaturedCategory.MSHOP_CONTENT_CATEGORY.toString();
          goto _L8
        homeitem;
        Log.e(TAG, homeitem.getMessage(), homeitem);
        sqlitedatabase.endTransaction();
        return false;
        homeitem;
        sqlitedatabase.endTransaction();
        throw homeitem;
          goto _L6
    }

    public void cleanOldHomeShovelerContent()
        throws DBException
    {
        SQLiteDatabase sqlitedatabase;
        sqlitedatabase = getWritableDatabase();
        sqlitedatabase.beginTransaction();
        sqlitedatabase.delete("mShop", null, null);
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
        StringBuilder stringbuilder = new StringBuilder("CREATE TABLE mShop(id INTEGER PRIMARY KEY AUTOINCREMENT, ");
        int i = 0;
        while (i < FIREVIEW_CONTENT_COLUMN.length) 
        {
            stringbuilder.append((new StringBuilder()).append(FIREVIEW_CONTENT_COLUMN[i]).append(" TEXT").toString());
            if (i == FIREVIEW_CONTENT_COLUMN.length - 1)
            {
                stringbuilder.append(")");
            } else
            {
                stringbuilder.append(", ");
            }
            i++;
        }
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

    public void postDbOperation(Runnable runnable)
    {
        mExecutor.execute(runnable);
    }

    public void updateHomeShovelerItems(HomeShoveler homeshoveler)
        throws DBException
    {
        Object obj = new ArrayList(homeshoveler.getItems());
        homeshoveler = homeshoveler.getDisplayType();
        obj = ((List) (obj)).iterator();
        do
        {
            if (!((Iterator) (obj)).hasNext())
            {
                break;
            }
            HomeItem homeitem = (HomeItem)((Iterator) (obj)).next();
            if (homeitem.getBasicOffer() != null || homeitem.getBasicProduct() != null)
            {
                updateFireviewContent(homeitem, homeshoveler);
            }
        } while (true);
    }

}
