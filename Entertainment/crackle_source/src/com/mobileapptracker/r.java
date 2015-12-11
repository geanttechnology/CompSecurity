// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;


// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker, Parameters

final class r
    implements Runnable
{

    final int a;
    final MobileAppTracker b;

    r(MobileAppTracker mobileapptracker, int i)
    {
        b = mobileapptracker;
        a = i;
        super();
    }

    public final void run()
    {
        b.params.setEventLevel(Integer.toString(a));
    }
}
