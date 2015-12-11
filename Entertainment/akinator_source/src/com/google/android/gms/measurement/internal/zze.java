// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzv, zzp, zzu

abstract class zze
{

    private static volatile Handler zzNX;
    private volatile long zzNY;
    private final zzv zzaKG;
    private boolean zzaLX;
    private final Runnable zzx = new Runnable() {

        final zze zzaLY;

        public void run()
        {
            if (Looper.myLooper() == Looper.getMainLooper())
            {
                zze.zza(zzaLY).zzzr().zzh(this);
            } else
            {
                boolean flag = zzaLY.zzbp();
                zze.zza(zzaLY, 0L);
                if (flag && zze.zzb(zzaLY))
                {
                    zzaLY.run();
                    return;
                }
            }
        }

            
            {
                zzaLY = zze.this;
                super();
            }
    };

    zze(zzv zzv1)
    {
        com.google.android.gms.common.internal.zzx.zzw(zzv1);
        zzaKG = zzv1;
        zzaLX = true;
    }

    private Handler getHandler()
    {
        if (zzNX != null)
        {
            return zzNX;
        }
        com/google/android/gms/measurement/internal/zze;
        JVM INSTR monitorenter ;
        Handler handler;
        if (zzNX == null)
        {
            zzNX = new Handler(zzaKG.getContext().getMainLooper());
        }
        handler = zzNX;
        com/google/android/gms/measurement/internal/zze;
        JVM INSTR monitorexit ;
        return handler;
        Exception exception;
        exception;
        com/google/android/gms/measurement/internal/zze;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static long zza(zze zze1, long l)
    {
        zze1.zzNY = l;
        return l;
    }

    static zzv zza(zze zze1)
    {
        return zze1.zzaKG;
    }

    static boolean zzb(zze zze1)
    {
        return zze1.zzaLX;
    }

    public void cancel()
    {
        zzNY = 0L;
        getHandler().removeCallbacks(zzx);
    }

    public abstract void run();

    public boolean zzbp()
    {
        return zzNY != 0L;
    }

    public void zzt(long l)
    {
        cancel();
        if (l >= 0L)
        {
            zzNY = zzaKG.zzit().currentTimeMillis();
            if (!getHandler().postDelayed(zzx, l))
            {
                zzaKG.zzyd().zzzK().zzj("Failed to schedule delayed post. time", Long.valueOf(l));
            }
        }
    }
}
