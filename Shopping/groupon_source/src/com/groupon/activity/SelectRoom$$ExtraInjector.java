// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;
import java.util.List;

// Referenced classes of package com.groupon.activity:
//            SelectRoom, BookingMetaData

public class 
{

    public static void inject(com.f2prateek.dart.r r, SelectRoom selectroom, Object obj)
    {
        Object obj1 = r.r(obj, "hotel_inventory");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'hotel_inventory' for field 'availableHotelRooms' was not found. If this extra is optional add '@Optional' annotation.");
        }
        selectroom.availableHotelRooms = (List)obj1;
        obj1 = r.lRooms(obj, "hotel_name");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'hotel_name' for field 'hotelName' was not found. If this extra is optional add '@Optional' annotation.");
        }
        selectroom.hotelName = (String)obj1;
        obj1 = r.lRooms(obj, "hotel_location");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'hotel_location' for field 'hotelLocation' was not found. If this extra is optional add '@Optional' annotation.");
        }
        selectroom.hotelLocation = (String)obj1;
        obj1 = r.(obj, "hotel_image_url");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'hotel_image_url' for field 'hotelImageUrl' was not found. If this extra is optional add '@Optional' annotation.");
        }
        selectroom.hotelImageUrl = (String)obj1;
        obj1 = r.(obj, "g_bucks_disclaimer");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'g_bucks_disclaimer' for field 'gBucksDisclaimer' was not found. If this extra is optional add '@Optional' annotation.");
        }
        selectroom.gBucksDisclaimer = (String)obj1;
        obj1 = r.mer(obj, "channel");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'channel' for field 'channel' was not found. If this extra is optional add '@Optional' annotation.");
        }
        selectroom.channel = (Channel)obj1;
        obj1 = r.mer(obj, "id");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'id' for field 'hotelId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        selectroom.hotelId = (String)obj1;
        obj1 = r.mer(obj, "getaways_booking");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'getaways_booking' for field 'bookingMetaData' was not found. If this extra is optional add '@Optional' annotation.");
        }
        selectroom.bookingMetaData = (BookingMetaData)obj1;
        r = ((com.f2prateek.dart.ta) (r.ta(obj, "productType")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'productType' for field 'productType' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            selectroom.productType = (String)r;
            return;
        }
    }

    public ()
    {
    }
}
