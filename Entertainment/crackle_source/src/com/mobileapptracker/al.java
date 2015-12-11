// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;


// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker, Parameters

final class al
    implements Runnable
{

    final double a;
    final MobileAppTracker b;

    al(MobileAppTracker mobileapptracker, double d)
    {
        b = mobileapptracker;
        a = d;
        super();
    }

    public final void run()
    {
        b.params.setLatitude(Double.toString(a));
    }
}
