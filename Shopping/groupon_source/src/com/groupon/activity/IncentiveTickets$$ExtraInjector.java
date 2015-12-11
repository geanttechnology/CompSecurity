// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            IncentiveTickets

public class 
{

    public static void inject(com.f2prateek.dart.r r, IncentiveTickets incentivetickets, Object obj)
    {
        Object obj1 = r.r(obj, "comingFromCheckout");
        if (obj1 != null)
        {
            incentivetickets.isComingFromCheckout = (Boolean)obj1;
        }
        obj1 = r.heckout(obj, "incentive_ticket_type");
        if (obj1 != null)
        {
            incentivetickets.selectedTicketType = (String)obj1;
        }
        obj1 = r.tType(obj, "isUsingGiftCodes");
        if (obj1 != null)
        {
            incentivetickets.isUsingGiftCodes = (Boolean)obj1;
        }
        r = ((com.f2prateek.dart.des) (r.des(obj, "dealId")));
        if (r != null)
        {
            incentivetickets.dealId = (String)r;
        }
    }

    public ()
    {
    }
}
