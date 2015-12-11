// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cn.jpush.android.a;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

// Referenced classes of package cn.jpush.android.a:
//            g

final class h
    implements LocationListener
{

    final g a;

    h(g g1)
    {
        a = g1;
        super();
    }

    public final void onLocationChanged(Location location)
    {
        g.a(a, location);
    }

    public final void onProviderDisabled(String s)
    {
        g.a(a, null);
        a.c();
    }

    public final void onProviderEnabled(String s)
    {
        a.b();
    }

    public final void onStatusChanged(String s, int i, Bundle bundle)
    {
    }
}
