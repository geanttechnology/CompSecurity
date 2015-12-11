// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.models.hotel;

import com.groupon.models.Bucks;
import com.groupon.models.FailureReason;
import com.groupon.models.ReservationHotel;
import java.util.List;

// Referenced classes of package com.groupon.models.hotel:
//            HotelPricing

public class HotelReservation
{

    public Bucks bucks;
    public List cancellationPolicies;
    public String checkInUtc;
    public String checkOutUtc;
    public List childAges;
    public String crsPolicyHtml;
    public FailureReason failureReason;
    public String firstName;
    public ReservationHotel hotel;
    public String hotelName;
    public String hotelTimeZoneIdentifier;
    public String lastName;
    public int numberOfAdults;
    public int numberOfNights;
    public HotelPricing pricing;
    public String recordLocator;
    public String roomName;
    public String source;
    public String status;
    public String updatedAt;
    public String uuid;

    public HotelReservation()
    {
    }
}
