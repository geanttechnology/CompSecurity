// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.os.Handler;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzf, zzaf

abstract class zzt
{

    private static volatile Handler zzNX;
    private final zzf zzME;
    private volatile long zzNY;
    private boolean zzNZ;
    private final Runnable zzx = new _cls1();

    zzt(zzf zzf1)
    {
        com.google.android.gms.common.internal.zzx.zzw(zzf1);
        zzME = zzf1;
    }

    private Handler getHandler()
    {
        if (zzNX != null)
        {
            return zzNX;
        }
        com/google/android/gms/analytics/internal/zzt;
        JVM INSTR monitorenter ;
        Handler handler;
        if (zzNX == null)
        {
            zzNX = new Handler(zzME.getContext().getMainLooper());
        }
        handler = zzNX;
        com/google/android/gms/analytics/internal/zzt;
        JVM INSTR monitorexit ;
        return handler;
        Exception exception;
        exception;
        com/google/android/gms/analytics/internal/zzt;
        JVM INSTR monitorexit ;
        throw exception;
    }

    static long zza(zzt zzt1, long l)
    {
        zzt1.zzNY = l;
        return l;
    }

    static zzf zza(zzt zzt1)
    {
        return zzt1.zzME;
    }

    static boolean zzb(zzt zzt1)
    {
        return zzt1.zzNZ;
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

    public long zzkh()
    {
        if (zzNY == 0L)
        {
            return 0L;
        } else
        {
            return Math.abs(zzME.zzit().currentTimeMillis() - zzNY);
        }
    }

    public void zzt(long l)
    {
        cancel();
        if (l >= 0L)
        {
            zzNY = zzME.zzit().currentTimeMillis();
            if (!getHandler().postDelayed(zzx, l))
            {
                zzME.zziu().zze("Failed to schedule delayed post. time", Long.valueOf(l));
            }
        }
    }

    public void zzu(long l)
    {
        long l1 = 0L;
        if (zzbp())
        {
            if (l < 0L)
            {
                cancel();
                return;
            }
            l -= Math.abs(zzME.zzit().currentTimeMillis() - zzNY);
            if (l < 0L)
            {
                l = l1;
            }
            getHandler().removeCallbacks(zzx);
            if (!getHandler().postDelayed(zzx, l))
            {
                zzME.zziu().zze("Failed to adjust delayed post. time", Long.valueOf(l));
                return;
            }
        }
    }

    private class _cls1
        implements Runnable
    {

        final zzt zzOa;

        public void run()
        {
            if (Looper.myLooper() == Looper.getMainLooper())
            {
                zzt.zza(zzOa).zziw().zzg(this);
            } else
            {
                boolean flag = zzOa.zzbp();
                zzt.zza(zzOa, 0L);
                if (flag && !zzt.zzb(zzOa))
                {
                    zzOa.run();
                    return;
                }
            }
        }

        _cls1()
        {
            zzOa = zzt.this;
            super();
        }
    }

}
