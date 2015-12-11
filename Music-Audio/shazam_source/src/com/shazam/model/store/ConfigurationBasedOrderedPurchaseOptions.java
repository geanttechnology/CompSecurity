// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.model.store;

import com.shazam.b.a.a;
import java.util.Map;

// Referenced classes of package com.shazam.model.store:
//            OrderedPurchaseOptions, StoresAnalyticsDecorator, Stores, StoreAnalyticsInfo

public class ConfigurationBasedOrderedPurchaseOptions
    implements OrderedPurchaseOptions
{

    private final StoresAnalyticsDecorator storesAnalyticsDecorator;
    private final a storesConverter;

    public ConfigurationBasedOrderedPurchaseOptions(a a1, StoresAnalyticsDecorator storesanalyticsdecorator)
    {
        storesConverter = a1;
        storesAnalyticsDecorator = storesanalyticsdecorator;
    }

    private Stores b(Stores stores, StoreAnalyticsInfo storeanalyticsinfo, Map map)
    {
        ParameterizedStores.Builder builder = com.shazam.model.store.ParameterizedStores.Builder.a();
        builder.stores = stores;
        builder.urlParameters = map;
        stores = builder.b();
        return storesAnalyticsDecorator.a(stores, storeanalyticsinfo);
    }

    public final Stores a(Stores stores, StoreAnalyticsInfo storeanalyticsinfo, Map map)
    {
        return b(stores, storeanalyticsinfo, map);
    }

    public final Stores a(Map map, StoreAnalyticsInfo storeanalyticsinfo, Map map1)
    {
        Object obj = null;
        Stores stores = obj;
        if (map != null)
        {
            stores = obj;
            if (!map.isEmpty())
            {
                stores = (Stores)storesConverter.a(map);
            }
        }
        return b(stores, storeanalyticsinfo, map1);
    }
}
