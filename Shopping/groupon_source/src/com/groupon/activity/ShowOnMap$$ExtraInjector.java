// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            ShowOnMap

public class 
{

    public static void inject(com.f2prateek.dart.r r, ShowOnMap showonmap, Object obj)
    {
        Object obj1 = r.r(obj, "vendorName");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'vendorName' for field 'vendorName' was not found. If this extra is optional add '@Optional' annotation.");
        }
        showonmap.vendorName = (String)obj1;
        obj1 = r.r(obj, "locationIds");
        if (obj1 != null)
        {
            showonmap.locationIds = (long[])(long[])obj1;
        }
        obj1 = r.r(obj, "lat");
        if (obj1 != null)
        {
            showonmap.lat = ((Double)obj1).doubleValue();
        }
        obj1 = r.r(obj, "lng");
        if (obj1 != null)
        {
            showonmap.lng = ((Double)obj1).doubleValue();
        }
        r = ((com.f2prateek.dart.r) (r.r(obj, "locationIndex")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'locationIndex' for field 'index' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            showonmap.index = ((Integer)r).intValue();
            return;
        }
    }

    public ()
    {
    }
}
