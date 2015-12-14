// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.pages.shareview;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

// Referenced classes of package com.cyberlink.youcammakeup.pages.shareview:
//            a

class a
    implements LocationListener
{

    final a a;

    public void onLocationChanged(Location location)
    {
        com.cyberlink.youcammakeup.pages.shareview.a.a(a, location);
        com.cyberlink.youcammakeup.pages.shareview.a.b(a).removeUpdates(this);
        com.cyberlink.youcammakeup.pages.shareview.a.b(a).removeUpdates(a.a);
    }

    public void onProviderDisabled(String s)
    {
        com.cyberlink.youcammakeup.pages.shareview.a.a(a, null);
    }

    public void onProviderEnabled(String s)
    {
    }

    public void onStatusChanged(String s, int i, Bundle bundle)
    {
    }

    (a a1)
    {
        a = a1;
        super();
    }
}
