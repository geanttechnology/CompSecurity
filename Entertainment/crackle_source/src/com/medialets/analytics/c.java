// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.medialets.analytics;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

// Referenced classes of package com.medialets.analytics:
//            MMAnalyticsManager

final class c
    implements LocationListener
{

    private MMAnalyticsManager a;

    c(MMAnalyticsManager mmanalyticsmanager)
    {
        a = mmanalyticsmanager;
        super();
    }

    public final void onLocationChanged(Location location)
    {
        a.mCachedLocation = location;
    }

    public final void onProviderDisabled(String s)
    {
    }

    public final void onProviderEnabled(String s)
    {
    }

    public final void onStatusChanged(String s, int i, Bundle bundle)
    {
    }
}
