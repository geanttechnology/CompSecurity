// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.service.countryanddivision.CurrentDivisionManager;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.DivisionTimeZone;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import org.restlet.engine.util.InternetDateFormat;
import org.restlet.engine.util.InternetUsDateFormat;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.manager:
//            WidgetsSyncHelper

public class WidgetOnShoppingCartSyncHelper extends WidgetsSyncHelper
{

    private static final String SHOPPING_CART_MEGAMIND_SCENARIO_PREFIX = "android_cart_ver1_";
    private String dealUuids[];
    private Logger logger;

    public WidgetOnShoppingCartSyncHelper(Context context)
    {
        super(context, Channel.UNKNOWN.toString(), Channel.DEAL_WIDGET.toString(), "android_cart_ver1_");
    }

    protected List getNameValueParams()
    {
        List list = super.getNameValueParams();
        list.addAll(Arrays.asList(new String[] {
            "datetime", ((InternetUsDateFormat)internetDateFormat.get()).toString((new DivisionTimeZone(((CurrentDivisionManager)currentDivisionManager.get()).getCurrentDivision())).getNow().getTimeInMillis(), InternetDateFormat.UTC, false)
        }));
        list.addAll(Arrays.asList(new String[] {
            "deal_ids", logger.encodeAsCSV(dealUuids)
        }));
        return list;
    }

    public void setDealUuids(String as[])
    {
        dealUuids = as;
        setChannel(Channel.SHOPPING_CART.extendedDatabaseChannel(dealUuids));
    }
}
