// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;


// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker, Parameters

final class ag
    implements Runnable
{

    final String a;
    final int b;
    final MobileAppTracker c;

    ag(MobileAppTracker mobileapptracker, String s, int i)
    {
        c = mobileapptracker;
        a = s;
        b = i;
        super();
    }

    public final void run()
    {
        c.params.setGoogleAdvertisingId(a);
        c.params.setGoogleAdTrackingLimited(Integer.toString(b));
    }
}
