// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.p;
import java.util.Date;

// Referenced classes of package com.google.android.gms.ads:
//            AdRequest

public final class xtras
{

    private final p dX = new p();

    static p a(xtras xtras)
    {
        return xtras.dX;
    }

    public final dX addKeyword(String s)
    {
        dX.a(s);
        return this;
    }

    public final xtras addNetworkExtras(NetworkExtras networkextras)
    {
        dX.a(networkextras);
        return this;
    }

    public final xtras addTestDevice(String s)
    {
        dX.b(s);
        return this;
    }

    public final AdRequest build()
    {
        return new AdRequest(this, null);
    }

    public final dX setBirthday(Date date)
    {
        dX.d = date;
        return this;
    }

    public final dX setGender(int i)
    {
        dX.e = i;
        return this;
    }

    public final dX setLocation(Location location)
    {
        dX.f = location;
        return this;
    }

    public final dX tagForChildDirectedTreatment(boolean flag)
    {
        dX.a(flag);
        return this;
    }

    public xtras()
    {
    }
}
