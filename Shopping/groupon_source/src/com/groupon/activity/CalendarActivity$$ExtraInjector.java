// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import java.util.Date;

// Referenced classes of package com.groupon.activity:
//            CalendarActivity

public class 
{

    public static void inject(com.f2prateek.dart.r r, CalendarActivity calendaractivity, Object obj)
    {
        Object obj1 = r.r(obj, "check_in_date");
        if (obj1 != null)
        {
            calendaractivity.checkInDate = (Date)obj1;
        }
        r = ((com.f2prateek.dart.r) (r.r(obj, "check_out_date")));
        if (r != null)
        {
            calendaractivity.checkOutDate = (Date)r;
        }
    }

    public ()
    {
    }
}
