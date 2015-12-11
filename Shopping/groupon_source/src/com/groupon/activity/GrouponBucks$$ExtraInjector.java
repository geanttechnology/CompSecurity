// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.models.GenericAmount;

// Referenced classes of package com.groupon.activity:
//            GrouponBucks

public class 
{

    public static void inject(com.f2prateek.dart.r r, GrouponBucks grouponbucks, Object obj)
    {
        Object obj1 = r.r(obj, "g_bucks");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'g_bucks' for field 'gBucksAmount' was not found. If this extra is optional add '@Optional' annotation.");
        }
        grouponbucks.gBucksAmount = (GenericAmount)obj1;
        r = ((com.f2prateek.dart.r) (r.r(obj, "g_bucks_disclaimer")));
        if (r != null)
        {
            grouponbucks.gBucksDisclaimerValue = (String)r;
        }
    }

    public ()
    {
    }
}
