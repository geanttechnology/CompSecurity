// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import com.google.android.gms.internal.zzpb;
import com.google.android.gms.measurement.zzg;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzd, zzan, zzf

public class zzk extends zzd
{

    private final zzpb zzNs = new zzpb();

    zzk(zzf zzf)
    {
        super(zzf);
    }

    public void zzhM()
    {
        Object obj = zzhQ();
        String s = ((zzan) (obj)).zzkp();
        if (s != null)
        {
            zzNs.setAppName(s);
        }
        obj = ((zzan) (obj)).zzkr();
        if (obj != null)
        {
            zzNs.setAppVersion(((String) (obj)));
        }
    }

    protected void zzhR()
    {
        zziw().zzyr().zza(zzNs);
        zzhM();
    }

    public zzpb zzjb()
    {
        zziE();
        return zzNs;
    }
}
