// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.deal.SharedDealInfo;

// Referenced classes of package com.groupon.activity:
//            HotelDetails

public class jector
{

    public static void inject(com.f2prateek.dart.r r, HotelDetails hoteldetails, Object obj)
    {
        jector.inject(r, hoteldetails, obj);
        Object obj1 = r.inject(obj, "id");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'id' for field 'hotelId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        hoteldetails.hotelId = (String)obj1;
        obj1 = r.inject(obj, "uuid");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'uuid' for field 'hotelUuid' was not found. If this extra is optional add '@Optional' annotation.");
        }
        hoteldetails.hotelUuid = (String)obj1;
        obj1 = r.inject(obj, "channel_id");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'channel_id' for field 'channelId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        hoteldetails.channelId = (String)obj1;
        obj1 = r.inject(obj, "check_in_date");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'check_in_date' for field 'checkInDateString' was not found. If this extra is optional add '@Optional' annotation.");
        }
        hoteldetails.checkInDateString = (String)obj1;
        obj1 = r.ring(obj, "check_out_date");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'check_out_date' for field 'checkOutDateString' was not found. If this extra is optional add '@Optional' annotation.");
        }
        hoteldetails.checkOutDateString = (String)obj1;
        obj1 = r.tring(obj, "adults");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'adults' for field 'adults' was not found. If this extra is optional add '@Optional' annotation.");
        }
        hoteldetails.adults = ((Integer)obj1).intValue();
        obj1 = r.tring(obj, "children");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'children' for field 'children' was not found. If this extra is optional add '@Optional' annotation.");
        }
        hoteldetails.children = ((Integer)obj1).intValue();
        obj1 = r.tring(obj, "search_flow");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'search_flow' for field 'isSearchFlow' was not found. If this extra is optional add '@Optional' annotation.");
        }
        hoteldetails.isSearchFlow = ((Boolean)obj1).booleanValue();
        obj1 = r.tring(obj, "productType");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'productType' for field 'productType' was not found. If this extra is optional add '@Optional' annotation.");
        }
        hoteldetails.productType = (String)obj1;
        obj1 = r.tring(obj, "hasRaO");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'hasRaO' for field 'hasRaO' was not found. If this extra is optional add '@Optional' annotation.");
        }
        hoteldetails.hasRaO = ((Boolean)obj1).booleanValue();
        r = ((com.f2prateek.dart.tring) (r.tring(obj, "shared_deal_info")));
        if (r != null)
        {
            hoteldetails.sharedDealInfo = (SharedDealInfo)r;
        }
    }

    public jector()
    {
    }
}
