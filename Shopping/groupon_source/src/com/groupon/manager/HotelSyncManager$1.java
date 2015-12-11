// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.db.dao.DaoHotel;
import com.groupon.models.hotel.HotelDealResponse;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.groupon.manager:
//            HotelSyncManager

class nse
    implements Callable
{

    final HotelSyncManager this$0;
    final HotelDealResponse val$hotelObject;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
        throws Exception
    {
        HotelSyncManager.access$000(HotelSyncManager.this).replace(val$hotelObject.hotel);
        HotelSyncManager.access$100(HotelSyncManager.this).set(true);
        return null;
    }

    nse()
    {
        this$0 = final_hotelsyncmanager;
        val$hotelObject = HotelDealResponse.this;
        super();
    }
}
