// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.maps.model;

import com.google.android.gms.common.internal.zzx;

// Referenced classes of package com.google.android.gms.maps.model:
//            LatLngBounds, LatLng

public final class zzaKi
{

    private double zzaKf;
    private double zzaKg;
    private double zzaKh;
    private double zzaKi;

    private boolean zzi(double d)
    {
        if (zzaKh > zzaKi) goto _L2; else goto _L1
_L1:
        if (zzaKh > d || d > zzaKi) goto _L4; else goto _L3
_L3:
        return true;
_L4:
        return false;
_L2:
        if (zzaKh > d && d > zzaKi)
        {
            return false;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public final LatLngBounds build()
    {
        boolean flag;
        if (!Double.isNaN(zzaKh))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        zzx.zza(flag, "no included points");
        return new LatLngBounds(new LatLng(zzaKf, zzaKh), new LatLng(zzaKg, zzaKi));
    }

    public final zzaKi include(LatLng latlng)
    {
        double d;
        zzaKf = Math.min(zzaKf, latlng.latitude);
        zzaKg = Math.max(zzaKg, latlng.latitude);
        d = latlng.longitude;
        if (!Double.isNaN(zzaKh)) goto _L2; else goto _L1
_L1:
        zzaKh = d;
_L6:
        zzaKi = d;
_L4:
        return this;
_L2:
        if (zzi(d)) goto _L4; else goto _L3
_L3:
        if (LatLngBounds.zzd(zzaKh, d) < LatLngBounds.zze(zzaKi, d))
        {
            zzaKh = d;
            return this;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    public ()
    {
        zzaKf = (1.0D / 0.0D);
        zzaKg = (-1.0D / 0.0D);
        zzaKh = (0.0D / 0.0D);
        zzaKi = (0.0D / 0.0D);
    }
}
