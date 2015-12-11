// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            Groupon

public class 
{

    public static void inject(com.f2prateek.dart.r r, Groupon groupon, Object obj)
    {
        Object obj1 = r.r(obj, "dealId");
        if (obj1 == null)
        {
            throw new IllegalStateException("Required extra with key 'dealId' for field 'grouponId' was not found. If this extra is optional add '@Optional' annotation.");
        }
        groupon.grouponId = (String)obj1;
        r = ((com.f2prateek.dart.r) (r.r(obj, "my_groupons_tab_position")));
        if (r != null)
        {
            groupon.myGrouponsTabPosition = ((Integer)r).intValue();
        }
    }

    public ()
    {
    }
}
