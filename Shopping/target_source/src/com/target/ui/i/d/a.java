// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.i.d;

import android.content.Context;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListing;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingCollectionItem;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingDetail;
import com.target.ui.common.ProductFulfillmentOptions;

public class a
{

    public static ProductFulfillmentOptions a(Context context, WeeklyAdListing weeklyadlisting, boolean flag)
    {
        context = new ProductFulfillmentOptions();
        context.o(false);
        context.h(false);
        return context;
    }

    public static ProductFulfillmentOptions a(Context context, WeeklyAdListingCollectionItem weeklyadlistingcollectionitem, boolean flag)
    {
        context = new ProductFulfillmentOptions();
        context.o(false);
        context.h(false);
        return context;
    }

    public static ProductFulfillmentOptions a(Context context, WeeklyAdListingDetail weeklyadlistingdetail, boolean flag)
    {
        context = new ProductFulfillmentOptions();
        context.o(true);
        context.h(true);
        context.e(0x7f0900d4);
        return context;
    }
}
