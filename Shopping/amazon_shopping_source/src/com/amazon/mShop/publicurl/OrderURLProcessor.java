// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.publicurl;

import android.content.Context;
import android.net.Uri;
import com.amazon.mShop.control.item.ClickStreamTag;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.Maps;
import com.amazon.mShop.util.Util;
import java.util.List;

// Referenced classes of package com.amazon.mShop.publicurl:
//            PublicURLProcessor

public class OrderURLProcessor extends PublicURLProcessor
{

    private boolean isSpecificOrder;

    public OrderURLProcessor(Uri uri)
    {
        super(uri);
    }

    protected void doProcess(Context context)
    {
        String s2 = null;
        Object obj = null;
        Object obj1 = null;
        Object obj2 = null;
        String s3 = obj1;
        String s1 = obj;
        String s = obj2;
        if (mPathSegments.size() >= 2)
        {
            String s4 = (String)mPathSegments.get(1);
            s2 = s4;
            s3 = obj1;
            s1 = obj;
            s = obj2;
            if (mPathSegments.size() >= 3)
            {
                s = (String)mPathSegments.get(2);
                s1 = mUri.getQueryParameter("tn");
                s3 = mUri.getQueryParameter("sm");
                s2 = s4;
            }
        }
        if (!Util.isEmpty(s2) && s2.matches("[0-9]{3}-[0-9]{7}-[0-9]{7}"))
        {
            isSpecificOrder = true;
            if ("track".equals(s) && !Util.isEmpty(s1) && !Util.isEmpty(s3))
            {
                s = "ORDER_TO_TRACK";
            } else
            {
                s = "order_to_view";
            }
        } else
        {
            s = null;
        }
        if (ClickStreamTag.ORIGIN_NOTIFICATION.getTag().equals(getOrigin()))
        {
            RefMarkerObserver.logRefMarker("pn_orders_t");
        }
        ActivityUtils.startYourOrdersActivity(context, Maps.of(com.amazon.mShop.order.WebViewOrderHelper.OrderActionParams.ORDER_ID, s2, com.amazon.mShop.order.WebViewOrderHelper.OrderActionParams.SHIP_METHOD, s3, com.amazon.mShop.order.WebViewOrderHelper.OrderActionParams.TRACKING_ID, s1), s, -1, getParams(), ActivityUtils.shouldReorderActivity(context), 0x80000);
    }

    public String getMetricIdentity()
    {
        if (isSpecificOrder)
        {
            return "ORDER";
        } else
        {
            return "ORDERS";
        }
    }
}
