// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            GrouponBookNowActivity

public class 
{

    public static void inject(com.f2prateek.dart.r r, GrouponBookNowActivity grouponbooknowactivity, Object obj)
    {
        r = ((com.f2prateek.dart.r) (r.r(obj, "url")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'url' for field 'travelBookingUrlExtra' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            grouponbooknowactivity.travelBookingUrlExtra = (String)r;
            return;
        }
    }

    public ()
    {
    }
}
