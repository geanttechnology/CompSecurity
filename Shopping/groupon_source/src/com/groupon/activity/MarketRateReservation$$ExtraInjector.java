// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            MarketRateReservation

public class 
{

    public static void inject(com.f2prateek.dart.r r, MarketRateReservation marketratereservation, Object obj)
    {
        Object obj1 = r.r(obj, "reservation_id");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'reservation_id' for field 'reservationId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        marketratereservation.reservationId = (String)obj1;
        r = ((com.f2prateek.dart.) (r.(obj, "hotel_timezone_identifier")));
        if (r != null)
        {
            marketratereservation.hotelTimeZoneIdentifier = (String)r;
        }
    }

    public ()
    {
    }
}
