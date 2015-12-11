// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.util.i;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class a
{

    private static final String DEEP_LINK_TO_DEALS_PAGE = "target://deals?source=widgetDeals";
    private static final String DEEP_LINK_TO_FEATURED_PAGE = "target://featured?source=widgetShop";
    private static final String DEEP_LINK_TO_LIST_PAGE = "target://lists/view?source=widgetList";
    private static final String DEEP_LINK_TO_PRODUCT_SCAN = "target://product/scan?source=widgetScan";
    private static final String DEEP_LINK_TO_PRODUCT_SEARCH = "target://product/search?source=widgetSearch";
    private static final int WIDGET_REQUEST_CODE = 0;

    public static PendingIntent a(Context context)
    {
        return a(context, "target://lists/view?source=widgetList");
    }

    private static PendingIntent a(Context context, String s)
    {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse(s));
        return PendingIntent.getActivity(context, 0, intent, 0x8000000);
    }

    public static PendingIntent b(Context context)
    {
        return a(context, "target://deals?source=widgetDeals");
    }

    public static PendingIntent c(Context context)
    {
        return a(context, "target://product/scan?source=widgetScan");
    }

    public static PendingIntent d(Context context)
    {
        return a(context, "target://featured?source=widgetShop");
    }

    public static PendingIntent e(Context context)
    {
        return a(context, "target://product/search?source=widgetSearch");
    }
}
