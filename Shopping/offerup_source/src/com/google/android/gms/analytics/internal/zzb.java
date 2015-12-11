// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.measurement.zzg;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzd, zzg, zzl, zzf, 
//            zzh, zzab, zzw

public class zzb extends zzd
{

    private final zzl zzMw;

    public zzb(zzf zzf, com.google.android.gms.analytics.internal.zzg zzg1)
    {
        super(zzf);
        zzx.zzw(zzg1);
        zzMw = zzg1.zzj(zzf);
    }

    static zzl zza(zzb zzb1)
    {
        return zzb1.zzMw;
    }

    void onServiceConnected()
    {
        zzis();
        zzMw.onServiceConnected();
    }

    public void setLocalDispatchPeriod(int i)
    {
        zziE();
        zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(i));
        zziw().zzg(new _cls1(i));
    }

    public void start()
    {
        zzMw.start();
    }

    public void zzI(boolean flag)
    {
        zza("Network connectivity status changed", Boolean.valueOf(flag));
        zziw().zzg(new _cls2(flag));
    }

    public long zza(zzh zzh)
    {
        zziE();
        zzx.zzw(zzh);
        zzis();
        long l = zzMw.zza(zzh, true);
        if (l == 0L)
        {
            zzMw.zzc(zzh);
        }
        return l;
    }

    public void zza(zzab zzab)
    {
        zzx.zzw(zzab);
        zziE();
        zzb("Hit delivery requested", zzab);
        zziw().zzg(new _cls4(zzab));
    }

    public void zza(zzw zzw)
    {
        zziE();
        zziw().zzg(new _cls6(zzw));
    }

    public void zza(String s, Runnable runnable)
    {
        zzx.zzh(s, "campaign param can't be empty");
        zziw().zzg(new _cls3(s, runnable));
    }

    protected void zzhR()
    {
        zzMw.zza();
    }

    public void zzik()
    {
        zziE();
        zzir();
        zziw().zzg(new _cls5());
    }

    public void zzil()
    {
        zziE();
        Context context = getContext();
        if (AnalyticsReceiver.zzV(context) && AnalyticsService.zzW(context))
        {
            Intent intent = new Intent(context, com/google/android/gms/analytics/AnalyticsService);
            intent.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            context.startService(intent);
            return;
        } else
        {
            zza(((zzw) (null)));
            return;
        }
    }

    public boolean zzim()
    {
        zziE();
        Future future = zziw().zzb(new _cls7());
        try
        {
            future.get(4L, TimeUnit.SECONDS);
        }
        catch (InterruptedException interruptedexception)
        {
            zzd("syncDispatchLocalHits interrupted", interruptedexception);
            return false;
        }
        catch (ExecutionException executionexception)
        {
            zze("syncDispatchLocalHits failed", executionexception);
            return false;
        }
        catch (TimeoutException timeoutexception)
        {
            zzd("syncDispatchLocalHits timed out", timeoutexception);
            return false;
        }
        return true;
    }

    public void zzin()
    {
        zziE();
        zzg.zzis();
        zzMw.zzin();
    }

    public void zzio()
    {
        zzba("Radio powered up");
        zzil();
    }

    void zzip()
    {
        zzis();
        zzMw.zzip();
    }

    private class _cls1
        implements Runnable
    {

        final int zzMx;
        final zzb zzMy;

        public void run()
        {
            zzb.zza(zzMy).zzs((long)zzMx * 1000L);
        }

        _cls1(int i)
        {
            zzMy = zzb.this;
            zzMx = i;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final zzb zzMy;
        final boolean zzMz;

        public void run()
        {
            zzb.zza(zzMy).zzI(zzMz);
        }

        _cls2(boolean flag)
        {
            zzMy = zzb.this;
            zzMz = flag;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final zzab zzMC;
        final zzb zzMy;

        public void run()
        {
            zzb.zza(zzMy).zza(zzMC);
        }

        _cls4(zzab zzab)
        {
            zzMy = zzb.this;
            zzMC = zzab;
            super();
        }
    }


    private class _cls6
        implements Runnable
    {

        final zzw zzMD;
        final zzb zzMy;

        public void run()
        {
            zzb.zza(zzMy).zzb(zzMD);
        }

        _cls6(zzw zzw)
        {
            zzMy = zzb.this;
            zzMD = zzw;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final String zzMA;
        final Runnable zzMB;
        final zzb zzMy;

        public void run()
        {
            zzb.zza(zzMy).zzbi(zzMA);
            if (zzMB != null)
            {
                zzMB.run();
            }
        }

        _cls3(String s, Runnable runnable)
        {
            zzMy = zzb.this;
            zzMA = s;
            zzMB = runnable;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final zzb zzMy;

        public void run()
        {
            zzb.zza(zzMy).zzik();
        }

        _cls5()
        {
            zzMy = zzb.this;
            super();
        }
    }


    private class _cls7
        implements Callable
    {

        final zzb zzMy;

        public Object call()
        {
            return zzgA();
        }

        public Void zzgA()
        {
            zzb.zza(zzMy).zzjj();
            return null;
        }

        _cls7()
        {
            zzMy = zzb.this;
            super();
        }
    }

}
