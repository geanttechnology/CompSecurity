// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import android.os.SystemClock;
import com.groupon.tracking.mobile.sdk.Logger;
import com.groupon.util.Function1;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            HotelDetails

class val.startTime
    implements Function1
{

    final HotelDetails this$0;
    final long val$startTime;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((List)obj);
    }

    public void execute(List list)
    {
        if (HotelDetails.access$700(HotelDetails.this) == null)
        {
            HotelDetails.access$702(HotelDetails.this, new ArrayList());
        }
        HotelDetails.access$700(HotelDetails.this).clear();
        HotelDetails.access$700(HotelDetails.this).addAll(list);
        HotelDetails.access$800(HotelDetails.this);
        long l = SystemClock.elapsedRealtime();
        logger.logGeneralEvent("hotel_performance", "on_hotel_images_loaded", hotelId, (int)(l - val$startTime), Logger.NULL_NST_FIELD);
    }

    er()
    {
        this$0 = final_hoteldetails;
        val$startTime = J.this;
        super();
    }
}
