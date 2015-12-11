// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;


// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker

final class z
    implements Runnable
{

    final MobileAppTracker a;

    z(MobileAppTracker mobileapptracker)
    {
        a = mobileapptracker;
        super();
    }

    public final void run()
    {
        MobileAppTracker.a(a, "session", null, 0.0D, a.getCurrencyCode(), a.getRefId(), null, null);
    }
}
