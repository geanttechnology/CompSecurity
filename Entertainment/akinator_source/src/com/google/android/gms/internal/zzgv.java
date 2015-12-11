// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.util.concurrent.Future;

// Referenced classes of package com.google.android.gms.internal:
//            zzin, zziz, zzdk

public final class zzgv
{

    private String zzBY;
    private String zzFO;
    private zzin zzFP;
    zzdz.zzd zzFQ;
    public final zzdk zzFR = new _cls1();
    public final zzdk zzFS = new _cls2();
    zziz zzoM;
    private final Object zzpd = new Object();

    public zzgv(String s, String s1)
    {
        zzFP = new zzin();
        zzFO = s1;
        zzBY = s;
    }

    static Object zza(zzgv zzgv1)
    {
        return zzgv1.zzpd;
    }

    static zzin zzb(zzgv zzgv1)
    {
        return zzgv1.zzFP;
    }

    static String zzc(zzgv zzgv1)
    {
        return zzgv1.zzBY;
    }

    static String zzd(zzgv zzgv1)
    {
        return zzgv1.zzFO;
    }

    public void zzb(zzdz.zzd zzd1)
    {
        zzFQ = zzd1;
    }

    public void zze(zziz zziz1)
    {
        zzoM = zziz1;
    }

    public zzdz.zzd zzfR()
    {
        return zzFQ;
    }

    public Future zzfS()
    {
        return zzFP;
    }

    public void zzfT()
    {
        if (zzoM != null)
        {
            zzoM.destroy();
            zzoM = null;
        }
    }

    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}

}
