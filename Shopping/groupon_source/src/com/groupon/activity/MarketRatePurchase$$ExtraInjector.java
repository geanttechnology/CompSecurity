// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;

// Referenced classes of package com.groupon.activity:
//            MarketRatePurchase, BookingMetaData

public class 
{

    public static void inject(com.f2prateek.dart.r r, MarketRatePurchase marketratepurchase, Object obj)
    {
        Object obj1 = r.r(obj, "room_token");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'room_token' for field 'roomToken' was not found. If this extra is optional add '@Optional' annotation.");
        }
        marketratepurchase.roomToken = (String)obj1;
        obj1 = r.r(obj, "id");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'id' for field 'hotelId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        marketratepurchase.hotelId = (String)obj1;
        obj1 = r.r(obj, "hotel_name");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'hotel_name' for field 'hotelName' was not found. If this extra is optional add '@Optional' annotation.");
        }
        marketratepurchase.hotelName = (String)obj1;
        obj1 = r.r(obj, "hotel_location");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'hotel_location' for field 'hotelLocation' was not found. If this extra is optional add '@Optional' annotation.");
        }
        marketratepurchase.hotelLocation = (String)obj1;
        obj1 = r.(obj, "hotel_image_url");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'hotel_image_url' for field 'hotelImageUrl' was not found. If this extra is optional add '@Optional' annotation.");
        }
        marketratepurchase.hotelImageUrl = (String)obj1;
        obj1 = r.(obj, "g_bucks_disclaimer");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'g_bucks_disclaimer' for field 'gBucksDisclaimer' was not found. If this extra is optional add '@Optional' annotation.");
        }
        marketratepurchase.gBucksDisclaimer = (String)obj1;
        obj1 = r.mer(obj, "channel");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'channel' for field 'channel' was not found. If this extra is optional add '@Optional' annotation.");
        }
        marketratepurchase.channel = (Channel)obj1;
        obj1 = r.mer(obj, "productType");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'productType' for field 'productType' was not found. If this extra is optional add '@Optional' annotation.");
        }
        marketratepurchase.productType = (String)obj1;
        r = ((com.f2prateek.dart.mer) (r.mer(obj, "getaways_booking")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'getaways_booking' for field 'bookingMetaData' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            marketratepurchase.bookingMetaData = (BookingMetaData)r;
            return;
        }
    }

    public ()
    {
    }
}
