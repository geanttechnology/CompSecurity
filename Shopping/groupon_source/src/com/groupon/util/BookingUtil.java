// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import android.content.Intent;
import com.groupon.Channel;
import com.groupon.activity.IntentFactory;
import com.groupon.db.models.Deal;
import com.groupon.models.DateTimeFinderReservationDetails;
import com.groupon.service.core.AbTestService;

// Referenced classes of package com.groupon.util:
//            DealUtils

public class BookingUtil
{

    private AbTestService abTestService;
    private IntentFactory intentFactory;

    public BookingUtil()
    {
    }

    public Intent createDateTimeFinderSchedulerIntent(DateTimeFinderReservationDetails datetimefinderreservationdetails, Deal deal, String s, String s1, Channel channel, boolean flag, boolean flag1)
    {
        com.groupon.models.mobilescheduler.MobileSchedulerData mobileschedulerdata = DealUtils.getSchedulerInputData(deal, s, channel, null);
        deal = intentFactory.newPurchaseIntentWithPredefinedReservation(deal, s, s1, null, flag, flag1, datetimefinderreservationdetails);
        return intentFactory.newMobileSchedulerIntentWithPredefinedReservation(mobileschedulerdata, datetimefinderreservationdetails, channel, false, false, false, deal);
    }

    public Intent createPrePurchaseSchedulerIntent(Deal deal, String s, Channel channel, boolean flag, boolean flag1)
    {
        com.groupon.models.mobilescheduler.MobileSchedulerData mobileschedulerdata = DealUtils.getSchedulerInputData(deal, s, channel, null);
        deal = intentFactory.newPurchaseLoginIntent(deal, s, null, flag, flag1);
        return intentFactory.newMobileSchedulerIntent(mobileschedulerdata, channel, false, false, true, deal);
    }

    public boolean supportsPrePurchaseBooking(Deal deal)
    {
        return abTestService.isVariantEnabledAndUSCA("bookingUpdatesPreBook1506USCA", "on") && DealUtils.isBookingEngineDeal(deal, true);
    }
}
