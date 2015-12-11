// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import java.util.HashMap;

// Referenced classes of package com.groupon.activity:
//            GrouponLocationSelection

public class 
{

    public static void inject(com.f2prateek.dart.r r, GrouponLocationSelection grouponlocationselection, Object obj)
    {
        Object obj1 = r.r(obj, "location_address_id_pairs");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'location_address_id_pairs' for field 'locationAddressIdPairs' was not found. If this extra is optional add '@Optional' annotation.");
        }
        grouponlocationselection.locationAddressIdPairs = (HashMap)obj1;
        r = ((com.f2prateek.dart.ssIdPairs) (r.ssIdPairs(obj, "groupon_id")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'groupon_id' for field 'grouponId' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            grouponlocationselection.grouponId = (String)r;
            return;
        }
    }

    public ()
    {
    }
}
