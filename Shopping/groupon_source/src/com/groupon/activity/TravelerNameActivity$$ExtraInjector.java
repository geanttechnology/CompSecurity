// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.util.ImageUrl;

// Referenced classes of package com.groupon.activity:
//            BookingMetaData, TravelerNameActivity

public class 
{

    public static void inject(com.f2prateek.dart.r r, TravelerNameActivity travelernameactivity, Object obj)
    {
        Object obj1 = r.r(obj, "getaways_booking");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'getaways_booking' for field 'bookingMetaData' was not found. If this extra is optional add '@Optional' annotation.");
        }
        travelernameactivity.bookingMetaData = (BookingMetaData)obj1;
        obj1 = r.ta(obj, "dealTitle");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'dealTitle' for field 'dealTitle' was not found. If this extra is optional add '@Optional' annotation.");
        }
        travelernameactivity.dealTitle = (String)obj1;
        r = ((com.f2prateek.dart.ta) (r.ta(obj, "imageUrl")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'imageUrl' for field 'imageUrl' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            travelernameactivity.imageUrl = (ImageUrl)r;
            return;
        }
    }

    public ()
    {
    }
}
