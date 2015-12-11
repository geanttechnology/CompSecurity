// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.doubleclick;

import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.internal.p;
import java.util.Date;

// Referenced classes of package com.google.android.gms.ads.doubleclick:
//            PublisherAdRequest

public final class 
{

    private final p dX = new p();

    static p a( )
    {
        return .dX;
    }

    public final dX addKeyword(String s)
    {
        dX.a(s);
        return this;
    }

    public final dX addNetworkExtras(NetworkExtras networkextras)
    {
        dX.a(networkextras);
        return this;
    }

    public final dX addTestDevice(String s)
    {
        dX.b(s);
        return this;
    }

    public final PublisherAdRequest build()
    {
        return new PublisherAdRequest(this, null);
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

    public final dX setManualImpressionsEnabled(boolean flag)
    {
        dX.g = flag;
        return this;
    }

    public final dX setPublisherProvidedId(String s)
    {
        dX.h = s;
        return this;
    }

    public final dX tagForChildDirectedTreatment(boolean flag)
    {
        dX.a(flag);
        return this;
    }

    public ()
    {
    }
}
