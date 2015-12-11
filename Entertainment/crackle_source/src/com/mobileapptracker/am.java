// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mobileapptracker;

import android.location.Location;

// Referenced classes of package com.mobileapptracker:
//            MobileAppTracker, Parameters

final class am
    implements Runnable
{

    final Location a;
    final MobileAppTracker b;

    am(MobileAppTracker mobileapptracker, Location location)
    {
        b = mobileapptracker;
        a = location;
        super();
    }

    public final void run()
    {
        b.params.setLocation(a);
    }
}
