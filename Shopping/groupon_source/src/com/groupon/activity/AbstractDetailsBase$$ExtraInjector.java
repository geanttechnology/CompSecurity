// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.activity;

import com.groupon.Channel;

// Referenced classes of package com.groupon.activity:
//            AbstractDetailsBase

public class 
{

    public static void inject(com.f2prateek.dart.r r, AbstractDetailsBase abstractdetailsbase, Object obj)
    {
        r = ((com.f2prateek.dart.r) (r.r(obj, "channel")));
        if (r != null)
        {
            abstractdetailsbase.channel = (Channel)r;
        }
    }

    public ()
    {
    }
}
