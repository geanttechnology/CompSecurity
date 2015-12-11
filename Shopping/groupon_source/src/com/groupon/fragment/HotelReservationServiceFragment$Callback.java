// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.models.hotel.HotelReservation;

// Referenced classes of package com.groupon.fragment:
//            HotelReservationServiceFragment

public static interface 
{

    public abstract void onNewReservationFinished(HotelReservation hotelreservation, Exception exception);

    public abstract void onUpdateReservationFinished(HotelReservation hotelreservation, Exception exception);
}
