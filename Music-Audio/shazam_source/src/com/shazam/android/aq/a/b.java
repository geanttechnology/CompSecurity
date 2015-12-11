// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.aq.a;

import android.location.Location;
import com.shazam.android.util.g.c;
import com.shazam.model.Provider;
import com.shazam.model.location.SimpleLocation;

public final class b
    implements Provider
{

    private final c a;

    public b(c c1)
    {
        a = c1;
    }

    public final Object a()
    {
        return b();
    }

    public final SimpleLocation b()
    {
        Double double1 = null;
        Location location = a.a();
        if (location == null)
        {
            return null;
        }
        if (location.hasAltitude())
        {
            double1 = Double.valueOf(location.getAltitude());
        }
        return new SimpleLocation(location.getProvider(), location.getLatitude(), location.getLongitude(), double1);
    }
}
