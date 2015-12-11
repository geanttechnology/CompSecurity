// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;

// Referenced classes of package com.groupon.activity:
//            BaseRecyclerViewActivity

public class 
{

    public static void inject(com.f2prateek.dart.r r, BaseRecyclerViewActivity baserecyclerviewactivity, Object obj)
    {
        Object obj1 = r.r(obj, "channel");
        if (obj1 != null)
        {
            baserecyclerviewactivity.pagerChannel = (Channel)obj1;
        }
        r = ((com.f2prateek.dart.r) (r.r(obj, "db_channel")));
        if (r != null)
        {
            baserecyclerviewactivity.dbChannel = (String)r;
        }
    }

    public ()
    {
    }
}
