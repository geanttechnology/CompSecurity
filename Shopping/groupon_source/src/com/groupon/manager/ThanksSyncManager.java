// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.Channel;
import com.groupon.service.LocationService;
import com.groupon.util.ApiGenerateShowParamBuilder;
import com.groupon.util.CountryNotSupportedException;
import com.groupon.util.DivisionUtil;
import java.util.Arrays;
import java.util.List;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.manager:
//            AnyChannelSyncManager

public class ThanksSyncManager extends AnyChannelSyncManager
{

    private LocationService locationService;
    private String orderId;

    public ThanksSyncManager(Context context)
    {
        super(context, Channel.POST_PURCHASE.name());
    }

    protected List getNameValueParams(int i, int j)
    {
        List list = super.getNameValueParams(i, j);
        String s;
        try
        {
            list.addAll(((DivisionUtil)divisionUtil.get()).getDivisionNameValuePairs(locationService.getLocation()));
        }
        catch (CountryNotSupportedException countrynotsupportedexception)
        {
            throw new RuntimeException(countrynotsupportedexception);
        }
        s = (new ApiGenerateShowParamBuilder()).dealSpecificAttributes(true).dealOptionGiftWrappingCharge(true).bookingUpdatesSchedulerOptions(true).build();
        list.addAll(Arrays.asList(new String[] {
            "post_purchase", "true"
        }));
        list.addAll(Arrays.asList(new String[] {
            "order_id", orderId
        }));
        list.addAll(Arrays.asList(new String[] {
            "metadata", "true"
        }));
        list.addAll(Arrays.asList(new String[] {
            "show", s
        }));
        return list;
    }

    public void setOrderId(String s)
    {
        orderId = s;
    }
}
