// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;

// Referenced classes of package com.groupon.activity:
//            BookingDealCalendarActivity

public class 
{

    public static void inject(com.f2prateek.dart.r r, BookingDealCalendarActivity bookingdealcalendaractivity, Object obj)
    {
        (r, bookingdealcalendaractivity, obj);
        Object obj1 = r.r(obj, "dealId");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'dealId' for field 'dealId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        bookingdealcalendaractivity.dealId = (String)obj1;
        obj1 = r.r(obj, "channel");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'channel' for field 'channel' was not found. If this extra is optional add '@Optional' annotation.");
        }
        bookingdealcalendaractivity.channel = (Channel)obj1;
        obj1 = r.r(obj, "optionId");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'optionId' for field 'optionId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        bookingdealcalendaractivity.optionId = (String)obj1;
        r = ((com.f2prateek.dart.r) (r.r(obj, "redirect_to_enter_code")));
        if (r != null)
        {
            bookingdealcalendaractivity.redirectToEnterCode = ((Boolean)r).booleanValue();
        }
    }

    public ()
    {
    }
}
