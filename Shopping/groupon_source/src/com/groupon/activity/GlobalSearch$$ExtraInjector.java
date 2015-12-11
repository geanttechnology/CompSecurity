// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            GlobalSearch

public class 
{

    public static void inject(com.f2prateek.dart.r r, GlobalSearch globalsearch, Object obj)
    {
        Object obj1 = r.r(obj, "show_nearby_tonight");
        if (obj1 != null)
        {
            globalsearch.showNearbyTonight = ((Boolean)obj1).booleanValue();
        }
        obj1 = r.ight(obj, "browse_by_category");
        if (obj1 != null)
        {
            globalsearch.isBrowseByCategory = ((Boolean)obj1).booleanValue();
        }
        r = ((com.f2prateek.dart.egory) (r.egory(obj, "wasDeepLinked")));
        if (r != null)
        {
            globalsearch.wasDeepLinked = ((Boolean)r).booleanValue();
        }
    }

    public ()
    {
    }
}
