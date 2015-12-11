// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.search;

import java.util.Date;

// Referenced classes of package com.groupon.getaways.search:
//            GetawaysSearchResultsActivity

public class 
{

    public static void inject(com.f2prateek.dart.Injector injector, GetawaysSearchResultsActivity getawayssearchresultsactivity, Object obj)
    {
        Object obj1 = injector.Injector(obj, "destination_name");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'destination_name' for field 'destinationName' was not found. If this extra is optional add '@Optional' annotation.");
        }
        getawayssearchresultsactivity.destinationName = (String)obj1;
        obj1 = injector.ationName(obj, "destination_id");
        if (obj1 != null)
        {
            getawayssearchresultsactivity.destinationId = (String)obj1;
        }
        obj1 = injector.ationId(obj, "check_in_date");
        if (obj1 != null)
        {
            getawayssearchresultsactivity.checkInDate = (Date)obj1;
        }
        injector = ((com.f2prateek.dart.nDate) (injector.nDate(obj, "check_out_date")));
        if (injector != null)
        {
            getawayssearchresultsactivity.checkOutDate = (Date)injector;
        }
    }

    public ()
    {
    }
}
