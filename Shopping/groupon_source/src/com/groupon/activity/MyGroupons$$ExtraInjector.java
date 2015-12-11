// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;


// Referenced classes of package com.groupon.activity:
//            MyGroupons

public class 
{

    public static void inject(com.f2prateek.dart.r r, MyGroupons mygroupons, Object obj)
    {
        Object obj1 = r.r(obj, "from_thank_you");
        if (obj1 != null)
        {
            mygroupons.isFromThankYou = ((Boolean)obj1).booleanValue();
        }
        obj1 = r.u(obj, "from_cancel_order");
        if (obj1 != null)
        {
            mygroupons.isFromCancelOrder = ((Boolean)obj1).booleanValue();
        }
        r = ((com.f2prateek.dart.rder) (r.rder(obj, "my_groupons_tab_position")));
        if (r != null)
        {
            mygroupons.myGrouponsExternalTabPosition = ((Integer)r).intValue();
        }
    }

    public ()
    {
    }
}
