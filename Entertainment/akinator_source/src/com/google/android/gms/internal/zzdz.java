// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

// Referenced classes of package com.google.android.gms.internal:
//            zzid, zzbd, zzbb

public class zzdz
{

    private final Context mContext;
    private final VersionInfoParcel zzpb;
    private final Object zzpd;
    private final String zzyo;
    private zzb zzyp;
    private zzb zzyq;
    private zze zzyr;
    private int zzys;

    public zzdz(Context context, VersionInfoParcel versioninfoparcel, String s)
    {
        zzpd = new Object();
        zzys = 1;
        zzyo = s;
        mContext = context.getApplicationContext();
        zzpb = versioninfoparcel;
    /* block-local class not found */
    class zzc {}

        zzyp = new zzc();
        zzyq = new zzc();
    }

    public zzdz(Context context, VersionInfoParcel versioninfoparcel, String s, zzb zzb1, zzb zzb2)
    {
        this(context, versioninfoparcel, s);
        zzyp = zzb1;
        zzyq = zzb2;
    }

    static int zza(zzdz zzdz1, int i)
    {
        zzdz1.zzys = i;
        return i;
    }

    static Context zza(zzdz zzdz1)
    {
        return zzdz1.mContext;
    }

    static zze zza(zzdz zzdz1, zze zze1)
    {
        zzdz1.zzyr = zze1;
        return zze1;
    }

    static VersionInfoParcel zzb(zzdz zzdz1)
    {
        return zzdz1.zzpb;
    }

    static Object zzc(zzdz zzdz1)
    {
        return zzdz1.zzpd;
    }

    static zzb zzd(zzdz zzdz1)
    {
        return zzdz1.zzyp;
    }

    private zze zzdM()
    {
    /* block-local class not found */
    class zze {}

        zze zze1 = new zze(zzyq);
        zzid.runOnUiThread(new _cls1(zze1));
        return zze1;
    }

    static int zze(zzdz zzdz1)
    {
        return zzdz1.zzys;
    }

    static String zzf(zzdz zzdz1)
    {
        return zzdz1.zzyo;
    }

    static zze zzg(zzdz zzdz1)
    {
        return zzdz1.zzyr;
    }

    protected zzbb zza(Context context, VersionInfoParcel versioninfoparcel)
    {
        return new zzbd(context, versioninfoparcel, null);
    }

    protected zze zzdN()
    {
        zze zze1 = zzdM();
        zze1.zza(new _cls2(zze1), new _cls3(zze1));
        return zze1;
    }

    public zzd zzdO()
    {
label0:
        {
            zzd zzd1;
            synchronized (zzpd)
            {
                if (zzyr != null && zzyr.getStatus() != -1)
                {
                    break label0;
                }
                zzys = 2;
                zzyr = zzdN();
                zzd1 = zzyr.zzdP();
            }
            return zzd1;
        }
        zzd zzd2;
        if (zzys != 0)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        zzd2 = zzyr.zzdP();
        obj;
        JVM INSTR monitorexit ;
        return zzd2;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (zzys != 1)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        zzys = 2;
        zzdN();
        exception = zzyr.zzdP();
        obj;
        JVM INSTR monitorexit ;
        return exception;
        if (zzys != 2)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        exception = zzyr.zzdP();
        obj;
        JVM INSTR monitorexit ;
        return exception;
        exception = zzyr.zzdP();
        obj;
        JVM INSTR monitorexit ;
        return exception;
    }

    // Unreferenced inner class com/google/android/gms/internal/zzdz$zza
    /* block-local class not found */
    class zza {}


    // Unreferenced inner class com/google/android/gms/internal/zzdz$zzb
    /* block-local class not found */
    class zzb {}


    // Unreferenced inner class com/google/android/gms/internal/zzdz$zzd
    /* block-local class not found */
    class zzd {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}

}
