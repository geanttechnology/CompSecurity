// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package me.lyft.android.ui.passenger;

import java.util.List;
import me.lyft.android.ui.ride.RideMap;
import rx.functions.Action1;

// Referenced classes of package me.lyft.android.ui.passenger:
//            PassengerCourierRideInProgressView

class this._cls0
    implements Action1
{

    final PassengerCourierRideInProgressView this$0;

    public volatile void call(Object obj)
    {
        call((List)obj);
    }

    public void call(List list)
    {
        rideMap.showCourierRouteMarkers(list);
    }

    ()
    {
        this$0 = PassengerCourierRideInProgressView.this;
        super();
    }
}
