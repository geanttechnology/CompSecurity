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

public class WebViewOrderHelper
{
    public static final class OrderAction extends Enum
    {

        private static final OrderAction $VALUES[];
        public static final OrderAction CANCEL_ORDER;
        public static final OrderAction TRACK_PACKAGE;
        public static final OrderAction VIEW_ALL_ORDERS;
        public static final OrderAction VIEW_ORDER;
        private int mBaseUrlId;
        private String mDataStoreDebugKey;
        private OrderActionParams mRequiredParams[];

        public static OrderAction valueOf(String s)
        {
            return (OrderAction)Enum.valueOf(com/amazon/mShop/order/WebViewOrderHelper$OrderAction, s);
        }

        public static OrderAction[] values()
        {
            return (OrderAction[])$VALUES.clone();
        }

        public String getUrl(Context context, Map map, Map map1)
            throws IllegalArgumentException
        {
            String s = null;
            if (!Util.isEmpty(mDataStoreDebugKey))
            {
                s = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString(mDataStoreDebugKey);
            }
            String s1 = s;
            if (Util.isEmpty(s))
            {
                s1 = context.getString(mBaseUrlId);
            }
            context = Uri.parse(s1).buildUpon();
            if (!Util.isEmpty(mRequiredParams))
            {
                OrderActionParams aorderactionparams[] = mRequiredParams;
                int j = aorderactionparams.length;
                for (int i = 0; i < j; i++)
                {
                    OrderActionParams orderactionparams = aorderactionparams[i];
                    String s2 = (String)Maps.get(map, orderactionparams, java/lang/String);
                    if (Util.isEmpty(s2))
                    {
                        throw new IllegalArgumentException(String.format("Value %s is invalid for %s", new Object[] {
                            s2, orderactionparams.name()
                        }));
                    }
                    if (map1 != null && map1.containsKey(orderactionparams.mKey))
                    {
                        map1.remove(orderactionparams.mKey);
                    }
                    context.appendQueryParameter(orderactionparams.mKey, s2);
                }

            }
            ActivityUtils.appendParamsToURL(context, map1);
            return context.build().toString();
        }

        static 
        {
            CANCEL_ORDER = new OrderAction("CANCEL_ORDER", 0, com.amazon.mShop.android.lib.R.string.cancel_order_web_page_url, "currentCancelOrderUrl", new OrderActionParams[] {
                OrderActionParams.ORDER_ID
            });
            TRACK_PACKAGE = new OrderAction("TRACK_PACKAGE", 1, com.amazon.mShop.android.lib.R.string.ship_track_order_web_page_url, new OrderActionParams[] {
                OrderActionParams.ORDER_ID, OrderActionParams.TRACKING_ID, OrderActionParams.SHIP_METHOD
            });
            VIEW_ALL_ORDERS = new OrderAction("VIEW_ALL_ORDERS", 2, com.amazon.mShop.android.lib.R.string.your_orders_web_page_url, "currentYourOrdersUrl", new OrderActionParams[0]);
            VIEW_ORDER = new OrderAction("VIEW_ORDER", 3, com.amazon.mShop.android.lib.R.string.order_detail_web_page_url, "currentOrderDetailUrl", new OrderActionParams[] {
                OrderActionParams.ORDER_ID
            });
            $VALUES = (new OrderAction[] {
                CANCEL_ORDER, TRACK_PACKAGE, VIEW_ALL_ORDERS, VIEW_ORDER
            });
        }

        private transient OrderAction(String s, int i, int j, String s1, OrderActionParams aorderactionparams[])
        {
            super(s, i);
            mBaseUrlId = j;
            mDataStoreDebugKey = s1;
            mRequiredParams = aorderactionparams;
        }

        private transient OrderAction(String s, int i, int j, OrderActionParams aorderactionparams[])
        {
            this(s, i, j, null, aorderactionparams);
        }
    }

    public static final class OrderActionParams extends Enum
    {

        private static final OrderActionParams $VALUES[];
        public static final OrderActionParams ORDER_ID;
        public static final OrderActionParams SHIP_METHOD;
        public static final OrderActionParams TRACKING_ID;
        private String mKey;

        public static OrderActionParams valueOf(String s)
        {
            return (OrderActionParams)Enum.valueOf(com/amazon/mShop/order/WebViewOrderHelper$OrderActionParams, s);
        }

        public static OrderActionParams[] values()
        {
            return (OrderActionParams[])$VALUES.clone();
        }

        static 
        {
            ORDER_ID = new OrderActionParams("ORDER_ID", 0, "oid");
            TRACKING_ID = new OrderActionParams("TRACKING_ID", 1, "tn");
            SHIP_METHOD = new OrderActionParams("SHIP_METHOD", 2, "sm");
            $VALUES = (new OrderActionParams[] {
                ORDER_ID, TRACKING_ID, SHIP_METHOD
            });
        }


        private OrderActionParams(String s, int i, String s1)
        {
            super(s, i);
            mKey = s1;
        }
    }


    public WebViewOrderHelper()
    {
    }
}
