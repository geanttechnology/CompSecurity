// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.hotel.HotelReservation;
import com.groupon.util.Function1;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            MarketRateReservation

class this._cls0
    implements Function1
{

    final MarketRateReservation this$0;

    public volatile void execute(Object obj)
        throws Exception
    {
        execute((List)obj);
    }

    public void execute(List list)
    {
        if (!list.isEmpty())
        {
            MarketRateReservation.access$002(MarketRateReservation.this, (HotelReservation)list.get(0));
            MarketRateReservation.access$100(MarketRateReservation.this);
        }
    }

    ()
    {
        this$0 = MarketRateReservation.this;
        super();
    }
}
