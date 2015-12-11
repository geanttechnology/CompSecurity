// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.order;

import android.content.Context;
import android.net.Uri;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Maps;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import java.util.Map;

// Referenced classes of package com.amazon.mShop.order:
//            WebViewOrderHelper

public static final class arams extends Enum
{

    private static final VIEW_ORDER $VALUES[];
    public static final VIEW_ORDER CANCEL_ORDER;
    public static final VIEW_ORDER TRACK_PACKAGE;
    public static final VIEW_ORDER VIEW_ALL_ORDERS;
    public static final VIEW_ORDER VIEW_ORDER;
    private int mBaseUrlId;
    private String mDataStoreDebugKey;
    private arams mRequiredParams[];

    public static arams valueOf(String s)
    {
        return (arams)Enum.valueOf(com/amazon/mShop/order/WebViewOrderHelper$OrderAction, s);
    }

    public static arams[] values()
    {
        return (arams[])$VALUES.clone();
    }

    public String getUrl(Context context, Map map, Map map1)
        throws IllegalArgumentException
    {
        String s = null;
        if (!Util.isEmpty(mDataStoreDebugKey))
        {
            s = com.amazon.mShop.platform.taStoreDebugKey().getDataStore().getString(mDataStoreDebugKey);
        }
        String s1 = s;
        if (Util.isEmpty(s))
        {
            s1 = context.getString(mBaseUrlId);
        }
        context = Uri.parse(s1).buildUpon();
        if (!Util.isEmpty(mRequiredParams))
        {
            arams aarams[] = mRequiredParams;
            int j = aarams.length;
            for (int i = 0; i < j; i++)
            {
                arams arams = aarams[i];
                String s2 = (String)Maps.get(map, arams, java/lang/String);
                if (Util.isEmpty(s2))
                {
                    throw new IllegalArgumentException(String.format("Value %s is invalid for %s", new Object[] {
                        s2, arams.name()
                    }));
                }
                if (map1 != null && map1.containsKey(arams.access._mth000(arams)))
                {
                    map1.remove(arams.access._mth000(arams));
                }
                context.r(arams.access._mth000(arams), s2);
            }

        }
        ActivityUtils.appendParamsToURL(context, map1);
        return context.aramsToURL().toString();
    }

    static 
    {
        CANCEL_ORDER = new <init>("CANCEL_ORDER", 0, com.amazon.mShop.android.lib.url, "currentCancelOrderUrl", new arams[] {
            arams.ORDER_ID
        });
        TRACK_PACKAGE = new <init>("TRACK_PACKAGE", 1, com.amazon.mShop.android.lib.age_url, new arams[] {
            arams.ORDER_ID, arams.TRACKING_ID, arams.SHIP_METHOD
        });
        VIEW_ALL_ORDERS = new <init>("VIEW_ALL_ORDERS", 2, com.amazon.mShop.android.lib.rl, "currentYourOrdersUrl", new arams[0]);
        VIEW_ORDER = new <init>("VIEW_ORDER", 3, com.amazon.mShop.android.lib.url, "currentOrderDetailUrl", new arams[] {
            arams.ORDER_ID
        });
        $VALUES = (new .VALUES[] {
            CANCEL_ORDER, TRACK_PACKAGE, VIEW_ALL_ORDERS, VIEW_ORDER
        });
    }

    private transient arams(String s, int i, int j, String s1, arams aarams[])
    {
        super(s, i);
        mBaseUrlId = j;
        mDataStoreDebugKey = s1;
        mRequiredParams = aarams;
    }

    private transient arams(String s, int i, int j, arams aarams[])
    {
        this(s, i, j, null, aarams);
    }
}
