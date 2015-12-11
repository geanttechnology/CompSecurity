// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads;

import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import java.util.Date;

// Referenced classes of package com.google.android.gms.ads:
//            AdRequest

public static final class xtras
{

    private final com.google.android.gms.internal. dX = new com.google.android.gms.internal.();

    static com.google.android.gms.internal. a(xtras xtras)
    {
        return xtras.dX;
    }

    public dX addKeyword(String s)
    {
        dX.(s);
        return this;
    }

    public xtras addNetworkExtras(NetworkExtras networkextras)
    {
        dX.(networkextras);
        return this;
    }

    public xtras addTestDevice(String s)
    {
        dX.(s);
        return this;
    }

    public AdRequest build()
    {
        return new AdRequest(this, null);
    }

    public dX setBirthday(Date date)
    {
        dX.(date);
        return this;
    }

    public dX setGender(int i)
    {
        dX.(i);
        return this;
    }

    public dX setLocation(Location location)
    {
        dX.(location);
        return this;
    }

    public dX tagForChildDirectedTreatment(boolean flag)
    {
        dX.(flag);
        return this;
    }

    public xtras()
    {
    }
}
