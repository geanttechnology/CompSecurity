// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.doubleclick;

import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import java.util.Date;

// Referenced classes of package com.google.android.gms.ads.doubleclick:
//            PublisherAdRequest

public static final class 
{

    private final com.google.android.gms.internal.uilder.dX dX = new com.google.android.gms.internal.uilder.dX();

    static com.google.android.gms.internal.uilder a( )
    {
        return .dX;
    }

    public dX addKeyword(String s)
    {
        dX.dX(s);
        return this;
    }

    public dX addNetworkExtras(NetworkExtras networkextras)
    {
        dX.dX(networkextras);
        return this;
    }

    public dX addTestDevice(String s)
    {
        dX.dX(s);
        return this;
    }

    public PublisherAdRequest build()
    {
        return new PublisherAdRequest(this, null);
    }

    public dX setBirthday(Date date)
    {
        dX.dX(date);
        return this;
    }

    public dX setGender(int i)
    {
        dX.dX(i);
        return this;
    }

    public dX setLocation(Location location)
    {
        dX.dX(location);
        return this;
    }

    public dX setManualImpressionsEnabled(boolean flag)
    {
        dX.dX(flag);
        return this;
    }

    public dX setPublisherProvidedId(String s)
    {
        dX.dX(s);
        return this;
    }

    public dX tagForChildDirectedTreatment(boolean flag)
    {
        dX.dX(flag);
        return this;
    }

    public ()
    {
    }
}
