// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import com.google.android.gms.ads.internal.reward.client.zzf;
import com.google.android.gms.ads.internal.util.client.zza;
import com.google.android.gms.internal.zzda;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zze, zzm, zzad

public class zzl
{

    private static final Object zzpy = new Object();
    private static zzl zztl;
    private final zza zztm = new zza();
    private final zze zztn = new zze();
    private final zzm zzto = new zzm();
    private final zzad zztp = new zzad();
    private final zzda zztq = new zzda();
    private final zzf zztr = new zzf();

    protected zzl()
    {
    }

    protected static void zza(zzl zzl1)
    {
        synchronized (zzpy)
        {
            zztl = zzl1;
        }
        return;
        zzl1;
        obj;
        JVM INSTR monitorexit ;
        throw zzl1;
    }

    private static zzl zzcE()
    {
        zzl zzl1;
        synchronized (zzpy)
        {
            zzl1 = zztl;
        }
        return zzl1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public static zza zzcF()
    {
        return zzcE().zztm;
    }

    public static zze zzcG()
    {
        return zzcE().zztn;
    }

    public static zzm zzcH()
    {
        return zzcE().zzto;
    }

    public static zzad zzcI()
    {
        return zzcE().zztp;
    }

    public static zzda zzcJ()
    {
        return zzcE().zztq;
    }

    public static zzf zzcK()
    {
        return zzcE().zztr;
    }

    static 
    {
        zza(new zzl());
    }
}
