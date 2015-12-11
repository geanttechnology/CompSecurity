// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.Channel;

// Referenced classes of package com.groupon.fragment:
//            FilterSheetViewFragment

public class A
{

    public static void inject(com.f2prateek.dart.r r, FilterSheetViewFragment filtersheetviewfragment, Object obj)
    {
        Object obj1 = r.r(obj, "search_term");
        if (obj1 != null)
        {
            filtersheetviewfragment.searchTerm = (String)obj1;
        }
        r = ((com.f2prateek.dart.r) (r.r(obj, "channel")));
        if (r == null)
        {
            throw new IllegalStateException("Required extra with key 'channel' for field 'channel' was not found. If this extra is optional add '@Optional' annotation.");
        } else
        {
            filtersheetviewfragment.channel = (Channel)r;
            return;
        }
    }

    public A()
    {
    }
}
