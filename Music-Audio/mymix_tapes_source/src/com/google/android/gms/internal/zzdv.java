// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

// Referenced classes of package com.google.android.gms.internal:
//            zzhu, zzbd, zzbb

public class zzdv
{

    private final Context mContext;
    private final VersionInfoParcel zzpa;
    private final Object zzpc;
    private final String zzxF;
    private zzb zzxG;
    private zzb zzxH;
    private zze zzxI;
    private int zzxJ;

    public zzdv(Context context, VersionInfoParcel versioninfoparcel, String s)
    {
        zzpc = new Object();
        zzxJ = 1;
        zzxF = s;
        mContext = context.getApplicationContext();
        zzpa = versioninfoparcel;
    /* block-local class not found */
    class zzc {}

        zzxG = new zzc();
        zzxH = new zzc();
    }

    public zzdv(Context context, VersionInfoParcel versioninfoparcel, String s, zzb zzb1, zzb zzb2)
    {
        this(context, versioninfoparcel, s);
        zzxG = zzb1;
        zzxH = zzb2;
    }

    static int zza(zzdv zzdv1, int i)
    {
        zzdv1.zzxJ = i;
        return i;
    }

    static Context zza(zzdv zzdv1)
    {
        return zzdv1.mContext;
    }

    static zze zza(zzdv zzdv1, zze zze1)
    {
        zzdv1.zzxI = zze1;
        return zze1;
    }

    static VersionInfoParcel zzb(zzdv zzdv1)
    {
        return zzdv1.zzpa;
    }

    static Object zzc(zzdv zzdv1)
    {
        return zzdv1.zzpc;
    }

    static zzb zzd(zzdv zzdv1)
    {
        return zzdv1.zzxG;
    }

    private zze zzdJ()
    {
    /* block-local class not found */
    class zze {}

        zze zze1 = new zze(zzxH);
        zzhu.runOnUiThread(new _cls1(zze1));
        return zze1;
    }

    static int zze(zzdv zzdv1)
    {
        return zzdv1.zzxJ;
    }

    static String zzf(zzdv zzdv1)
    {
        return zzdv1.zzxF;
    }

    static zze zzg(zzdv zzdv1)
    {
        return zzdv1.zzxI;
    }

    protected zzbb zza(Context context, VersionInfoParcel versioninfoparcel)
    {
        return new zzbd(context, versioninfoparcel, null);
    }

    protected zze zzdK()
    {
        zze zze1 = zzdJ();
        zze1.zza(new _cls2(zze1), new _cls3(zze1));
        return zze1;
    }

    public zzd zzdL()
    {
label0:
        {
            zzd zzd1;
            synchronized (zzpc)
            {
                if (zzxI != null && zzxI.getStatus() != -1)
                {
                    break label0;
                }
                zzxJ = 2;
                zzxI = zzdK();
                zzd1 = zzxI.zzdM();
            }
            return zzd1;
        }
        zzd zzd2;
        if (zzxJ != 0)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        zzd2 = zzxI.zzdM();
        obj;
        JVM INSTR monitorexit ;
        return zzd2;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
        if (zzxJ != 1)
        {
            break MISSING_BLOCK_LABEL_104;
        }
        zzxJ = 2;
        zzdK();
        exception = zzxI.zzdM();
        obj;
        JVM INSTR monitorexit ;
        return exception;
        if (zzxJ != 2)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        exception = zzxI.zzdM();
        obj;
        JVM INSTR monitorexit ;
        return exception;
        exception = zzxI.zzdM();
        obj;
        JVM INSTR monitorexit ;
        return exception;
    }

    // Unreferenced inner class com/google/android/gms/internal/zzdv$zza
    /* block-local class not found */
    class zza {}


    // Unreferenced inner class com/google/android/gms/internal/zzdv$zzb
    /* block-local class not found */
    class zzb {}


    // Unreferenced inner class com/google/android/gms/internal/zzdv$zzd
    /* block-local class not found */
    class zzd {}


    /* member class not found */
    class _cls1 {}


    /* member class not found */
    class _cls2 {}


    /* member class not found */
    class _cls3 {}

}
