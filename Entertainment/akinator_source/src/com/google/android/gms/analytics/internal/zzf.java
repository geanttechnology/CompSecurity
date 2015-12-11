// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzmn;
import com.google.android.gms.internal.zzmp;
import com.google.android.gms.measurement.zzg;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzg, zzaf, zzr, zze, 
//            zzai, zzan, zzn, zza, 
//            zzk, zzu, zzv, zzb, 
//            zzy, zzd

public class zzf
{

    private static zzf zzMI;
    private final Context mContext;
    private final Context zzMJ;
    private final zzr zzMK;
    private final zzaf zzML;
    private final zzg zzMM;
    private final zzb zzMN;
    private final zzv zzMO;
    private final zzan zzMP;
    private final zzai zzMQ;
    private final GoogleAnalytics zzMR;
    private final zzn zzMS;
    private final zza zzMT;
    private final zzk zzMU;
    private final zzu zzMV;
    private final zzmn zzpW;

    protected zzf(com.google.android.gms.analytics.internal.zzg zzg1)
    {
        Object obj = zzg1.getApplicationContext();
        zzx.zzb(obj, "Application context can't be null");
        zzx.zzb(obj instanceof Application, "getApplicationContext didn't return the application");
        Object obj1 = zzg1.zziG();
        zzx.zzw(obj1);
        mContext = ((Context) (obj));
        zzMJ = ((Context) (obj1));
        zzpW = zzg1.zzh(this);
        zzMK = zzg1.zzg(this);
        obj1 = zzg1.zzf(this);
        ((zzaf) (obj1)).zza();
        zzML = ((zzaf) (obj1));
        zzn zzn1;
        zza zza1;
        zzk zzk1;
        zzu zzu1;
        if (zziv().zzjA())
        {
            zziu().zzbc((new StringBuilder()).append("Google Analytics ").append(zze.VERSION).append(" is starting up.").toString());
        } else
        {
            zziu().zzbc((new StringBuilder()).append("Google Analytics ").append(zze.VERSION).append(" is starting up. ").append("To enable debug logging on a device run:\n").append("  adb shell setprop log.tag.GAv4 DEBUG\n").append("  adb logcat -s GAv4").toString());
        }
        obj1 = zzg1.zzq(this);
        ((zzai) (obj1)).zza();
        zzMQ = ((zzai) (obj1));
        obj1 = zzg1.zze(this);
        ((zzan) (obj1)).zza();
        zzMP = ((zzan) (obj1));
        obj1 = zzg1.zzl(this);
        zzn1 = zzg1.zzd(this);
        zza1 = zzg1.zzc(this);
        zzk1 = zzg1.zzb(this);
        zzu1 = zzg1.zza(this);
        obj = zzg1.zzY(((Context) (obj)));
        ((zzg) (obj)).zza(zziF());
        zzMM = ((zzg) (obj));
        obj = zzg1.zzi(this);
        zzn1.zza();
        zzMS = zzn1;
        zza1.zza();
        zzMT = zza1;
        zzk1.zza();
        zzMU = zzk1;
        zzu1.zza();
        zzMV = zzu1;
        zzg1 = zzg1.zzp(this);
        zzg1.zza();
        zzMO = zzg1;
        ((zzb) (obj1)).zza();
        zzMN = ((zzb) (obj1));
        if (zziv().zzjA())
        {
            zziu().zzb("Device AnalyticsService version", zze.VERSION);
        }
        ((GoogleAnalytics) (obj)).zza();
        zzMR = ((GoogleAnalytics) (obj));
        ((zzb) (obj1)).start();
    }

    public static zzf zzX(Context context)
    {
        zzx.zzw(context);
        if (zzMI != null) goto _L2; else goto _L1
_L1:
        com/google/android/gms/analytics/internal/zzf;
        JVM INSTR monitorenter ;
        long l;
        long l1;
        if (zzMI != null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        zzmn zzmn1 = zzmp.zzqt();
        l = zzmn1.elapsedRealtime();
        context = new zzf(new com.google.android.gms.analytics.internal.zzg(context.getApplicationContext()));
        zzMI = context;
        GoogleAnalytics.zzhN();
        l = zzmn1.elapsedRealtime() - l;
        l1 = ((Long)zzy.zzOU.get()).longValue();
        if (l <= l1)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        context.zziu().zzc("Slow initialization (ms)", Long.valueOf(l), Long.valueOf(l1));
        com/google/android/gms/analytics/internal/zzf;
        JVM INSTR monitorexit ;
_L2:
        return zzMI;
        context;
        com/google/android/gms/analytics/internal/zzf;
        JVM INSTR monitorexit ;
        throw context;
    }

    private void zza(zzd zzd1)
    {
        zzx.zzb(zzd1, "Analytics service not created/initialized");
        zzx.zzb(zzd1.isInitialized(), "Analytics service not initialized");
    }

    public Context getContext()
    {
        return mContext;
    }

    public zzb zzhP()
    {
        zza(zzMN);
        return zzMN;
    }

    public zzan zzhQ()
    {
        zza(zzMP);
        return zzMP;
    }

    public zzk zziB()
    {
        zza(zzMU);
        return zzMU;
    }

    public zzu zziC()
    {
        return zzMV;
    }

    protected Thread.UncaughtExceptionHandler zziF()
    {
        return new Thread.UncaughtExceptionHandler() {

            final zzf zzMW;

            public void uncaughtException(Thread thread, Throwable throwable)
            {
                thread = zzMW.zziH();
                if (thread != null)
                {
                    thread.zze("Job execution failed", throwable);
                }
            }

            
            {
                zzMW = zzf.this;
                super();
            }
        };
    }

    public Context zziG()
    {
        return zzMJ;
    }

    public zzaf zziH()
    {
        return zzML;
    }

    public GoogleAnalytics zziI()
    {
        zzx.zzw(zzMR);
        zzx.zzb(zzMR.isInitialized(), "Analytics instance not initialized");
        return zzMR;
    }

    public zzai zziJ()
    {
        if (zzMQ == null || !zzMQ.isInitialized())
        {
            return null;
        } else
        {
            return zzMQ;
        }
    }

    public zza zziK()
    {
        zza(zzMT);
        return zzMT;
    }

    public zzn zziL()
    {
        zza(zzMS);
        return zzMS;
    }

    public void zzis()
    {
        zzg.zzis();
    }

    public zzmn zzit()
    {
        return zzpW;
    }

    public zzaf zziu()
    {
        zza(zzML);
        return zzML;
    }

    public zzr zziv()
    {
        return zzMK;
    }

    public zzg zziw()
    {
        zzx.zzw(zzMM);
        return zzMM;
    }

    public zzv zzix()
    {
        zza(zzMO);
        return zzMO;
    }

    public zzai zziy()
    {
        zza(zzMQ);
        return zzMQ;
    }
}
