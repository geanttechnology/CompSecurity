// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.contentprovider;

import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.mShop.aiv.AmazonInstantVideoProxy;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.rio.j2me.client.services.mShop.BasicProductInfo;
import com.amazon.rio.j2me.client.services.mShop.HomeItem;
import com.amazon.rio.j2me.client.services.mShop.HomeShoveler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.contentprovider:
//            AIVGroverRecommendationsProvider, AIVWidgetDatabaseHelper, WidgetContentProvider

private static class mSharedPreferences
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
        com.amazon.mShop.util.rItemsTask(AIVGroverRecommendationsProvider.access$000(), "Refreshing cached AIV shoveler items");
        List list = AmazonInstantVideoProxy.getInstance().getGroverRecommendations();
        if (list.isEmpty())
        {
            return;
        } else
        {
            mAIVWidgetDatabaseHelper.updateHomeShovelerItems(itemListToHomeShoveler(list));
            mSharedPreferences.edit().mSharedPreferences("aiv_shoveler_items_refreshed_time_pref_key", System.currentTimeMillis()).mSharedPreferences("aiv_shoveler_items_cust_id", SSOUtil.getCurrentAccount(mContext)).mContext("aiv_shoveler_items_marketplace", AppLocale.getInstance().getCurrentLocaleName()).mContext();
            WidgetContentProvider.sendContentUpdatedIntent(mContext);
            return;
        }
    }

    public (Context context, AIVWidgetDatabaseHelper aivwidgetdatabasehelper, SharedPreferences sharedpreferences)
    {
        mContext = context;
        mAIVWidgetDatabaseHelper = aivwidgetdatabasehelper;
        mSharedPreferences = sharedpreferences;
    }
}
