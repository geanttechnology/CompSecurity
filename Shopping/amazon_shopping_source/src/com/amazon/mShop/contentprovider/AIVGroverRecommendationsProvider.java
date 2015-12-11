// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.contentprovider;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.sqlite.SQLiteDatabase;
import com.amazon.client.metrics.AndroidMetricsFactoryImpl;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.client.metrics.MetricsFactory;
import com.amazon.mShop.aiv.AIVAvailabilityUtils;
import com.amazon.mShop.aiv.AmazonInstantVideoProxy;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.HomeItem;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.mShop.contentprovider:
//            AIVWidgetDatabaseHelper, WidgetContentProvider

public class AIVGroverRecommendationsProvider
{
    private static class UpdateAIVShovelerItemsTask
        implements Runnable
    {

        private final AIVWidgetDatabaseHelper mAIVWidgetDatabaseHelper;
        private final Context mContext;
        private final SharedPreferences mSharedPreferences;

        private HomeShoveler itemListToHomeShoveler(List list)
        {
            ArrayList arraylist = new ArrayList();
            HomeItem homeitem;
            for (list = list.iterator(); list.hasNext(); arraylist.add(homeitem))
            {
                Map map = (Map)list.next();
                BasicProductInfo basicproductinfo = new BasicProductInfo();
                basicproductinfo.setTitle((String)map.get("title"));
                basicproductinfo.setImageUrl((String)map.get("imageUrl"));
                homeitem = new HomeItem();
                homeitem.setAsin((String)map.get("asin"));
                homeitem.setBasicProduct(basicproductinfo);
            }

            list = new HomeShoveler();
            list.setDisplayType(Integer.valueOf(1));
            list.setItems(arraylist);
            return list;
        }

        public void run()
        {
            com.amazon.mShop.util.DebugUtil.Log.i(AIVGroverRecommendationsProvider.TAG, "Refreshing cached AIV shoveler items");
            List list = AmazonInstantVideoProxy.getInstance().getGroverRecommendations();
            if (list.isEmpty())
            {
                return;
            } else
            {
                mAIVWidgetDatabaseHelper.updateHomeShovelerItems(itemListToHomeShoveler(list));
                mSharedPreferences.edit().putLong("aiv_shoveler_items_refreshed_time_pref_key", System.currentTimeMillis()).putString("aiv_shoveler_items_cust_id", SSOUtil.getCurrentAccount(mContext)).putString("aiv_shoveler_items_marketplace", AppLocale.getInstance().getCurrentLocaleName()).apply();
                WidgetContentProvider.sendContentUpdatedIntent(mContext);
                return;
            }
        }

        public UpdateAIVShovelerItemsTask(Context context, AIVWidgetDatabaseHelper aivwidgetdatabasehelper, SharedPreferences sharedpreferences)
        {
            mContext = context;
            mAIVWidgetDatabaseHelper = aivwidgetdatabasehelper;
            mSharedPreferences = sharedpreferences;
        }
    }


    private static final Cursor EMPTY_CURSOR;
    private static final Executor EXECUTOR = Executors.newSingleThreadExecutor();
    private static final String TAG = com/amazon/mShop/contentprovider/AIVGroverRecommendationsProvider.getSimpleName();
    private final AIVWidgetDatabaseHelper mAIVWidgetDatabaseHelper;
    private final AmazonInstantVideoProxy mAmazonInstantVideoProxy;
    private final Context mContext;
    private final MetricsFactory mMetricsFactory;
    private final MetricEvent mRecommendationsToGroverEvent;
    private final SharedPreferences mSharedPreferences;

    public AIVGroverRecommendationsProvider(Context context)
    {
        this(context, AIVWidgetDatabaseHelper.getInstance(context), context.getSharedPreferences("aiv_shoveler_items_pref", 0), AmazonInstantVideoProxy.getInstance(), AndroidMetricsFactoryImpl.getInstance(context));
    }

    protected AIVGroverRecommendationsProvider(Context context, AIVWidgetDatabaseHelper aivwidgetdatabasehelper, SharedPreferences sharedpreferences, AmazonInstantVideoProxy amazoninstantvideoproxy, MetricsFactory metricsfactory)
    {
        mContext = context;
        mSharedPreferences = sharedpreferences;
        mAIVWidgetDatabaseHelper = aivwidgetdatabasehelper;
        mAmazonInstantVideoProxy = amazoninstantvideoproxy;
        mMetricsFactory = metricsfactory;
        mRecommendationsToGroverEvent = mMetricsFactory.createMetricEvent("ATVAndroid", "AIVGroverRecommendationsProvider:getAIVItems");
    }

    private void cleanOldShovelerData()
    {
        mAIVWidgetDatabaseHelper.cleanOldHomeShovelerContent();
        mSharedPreferences.edit().putLong("aiv_shoveler_items_refreshed_time_pref_key", 0L).putString("aiv_shoveler_items_cust_id", "").putString("aiv_shoveler_items_marketplace", "").apply();
    }

    private void executeUpdateAIVShovelerTask()
    {
        incrementAndRecordCounter("counter_recommendations_service_call");
        EXECUTOR.execute(new UpdateAIVShovelerItemsTask(mContext, mAIVWidgetDatabaseHelper, mSharedPreferences));
    }

    private void incrementAndRecordCounter(String s)
    {
        mRecommendationsToGroverEvent.addCounter(s, 1.0D);
        mMetricsFactory.record(mRecommendationsToGroverEvent);
    }

    private boolean isAIVShovelerItemsExpired()
    {
        return System.currentTimeMillis() - mSharedPreferences.getLong("aiv_shoveler_items_refreshed_time_pref_key", 0L) > mAmazonInstantVideoProxy.getGroverRecommendationsTTLMillis();
    }

    private boolean isMarketplaceChanged()
    {
        return !AppLocale.getInstance().getCurrentLocaleName().equals(mSharedPreferences.getString("aiv_shoveler_items_marketplace", ""));
    }

    private boolean isUserChanged(String s)
    {
        return !s.equals(mSharedPreferences.getString("aiv_shoveler_items_cust_id", ""));
    }

    private boolean isWeblabEnabled()
    {
        return "T1".equals(Features.getInstance().getFeatureState("AIVGROVERINTEGRATION_42456"));
    }

    public Cursor getAIVItems(String as[], String s, String as1[], String s1)
    {
        if (!AIVAvailabilityUtils.isAIVAvailable() || !isWeblabEnabled())
        {
            return EMPTY_CURSOR;
        }
        Object obj = SSOUtil.getCurrentAccount(mContext.getApplicationContext());
        boolean flag;
        boolean flag1;
        boolean flag2;
        if (!Util.isEmpty(((String) (obj))))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (isUserChanged(((String) (obj))) || isMarketplaceChanged())
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag1 || !flag)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        obj = mAIVWidgetDatabaseHelper.getReadableDatabase();
        if (flag2)
        {
            s = EMPTY_CURSOR;
        } else
        {
            s = ((SQLiteDatabase) (obj)).query("mShop_aiv", as, s, as1, null, null, s1);
        }
        if (flag2)
        {
            as = "counter_empty_cursor";
        } else
        {
            as = "counter_items_from_cache";
        }
        incrementAndRecordCounter(as);
        if (flag2)
        {
            cleanOldShovelerData();
        }
        if (flag1 || isAIVShovelerItemsExpired())
        {
            executeUpdateAIVShovelerTask();
        }
        if (!flag)
        {
            as = "User is invalid. Cleaning old AIV shoveler items";
        } else
        if (flag2)
        {
            as = "User/Marketplace changed. Will refresh AIV shoveler items in cache";
        } else
        {
            as = "Returning cached AIV shoveler items from DB";
        }
        com.amazon.mShop.util.DebugUtil.Log.i(TAG, as);
        return s;
    }

    static 
    {
        EMPTY_CURSOR = new MatrixCursor(AIVWidgetDatabaseHelper.FIREVIEW_CONTENT_COLUMN);
    }

}
