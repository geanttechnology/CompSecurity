// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;


// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker, MATParameters

final class i
    implements Runnable
{

    final boolean a;
    final MobileAppTracker b;

    i(MobileAppTracker mobileapptracker, boolean flag)
    {
        b = mobileapptracker;
        a = flag;
        super();
    }

    public final void run()
    {
        if (a)
        {
            b.params.setAppAdTrackingEnabled(Integer.toString(1));
            return;
        } else
        {
            b.params.setAppAdTrackingEnabled(Integer.toString(0));
            return;
        }
    }
}
