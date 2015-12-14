// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.AnalyticsReceiver;
import com.google.android.gms.analytics.AnalyticsService;
import com.google.android.gms.common.internal.zzu;
import com.google.android.gms.internal.zzns;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

// Referenced classes of package com.google.android.gms.analytics.internal:
//            zzd, zzg, zzl, zzf, 
//            zzh, zzab, zzw

public class zzb extends zzd
{

    private final zzl zzJq;

    public zzb(zzf zzf, zzg zzg1)
    {
        super(zzf);
        zzu.zzu(zzg1);
        zzJq = zzg1.zzj(zzf);
    }

    static zzl zza(zzb zzb1)
    {
        return zzb1.zzJq;
    }

    void onServiceConnected()
    {
        zzhO();
        zzJq.onServiceConnected();
    }

    public void setLocalDispatchPeriod(int i)
    {
        zzia();
        zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(i));
        zzhS().zze(new _cls1(i));
    }

    public void start()
    {
        zzJq.start();
    }

    public void zzG(boolean flag)
    {
        zza("Network connectivity status changed", Boolean.valueOf(flag));
        zzhS().zze(new _cls2(flag));
    }

    public long zza(zzh zzh)
    {
        zzia();
        zzu.zzu(zzh);
        zzhO();
        long l = zzJq.zza(zzh, true);
        if (l == 0L)
        {
            zzJq.zzc(zzh);
        }
        return l;
    }

    public void zza(zzab zzab)
    {
        zzu.zzu(zzab);
        zzia();
        zzb("Hit delivery requested", zzab);
        zzhS().zze(new _cls4(zzab));
    }

    public void zza(zzw zzw)
    {
        zzia();
        zzhS().zze(new _cls6(zzw));
    }

    public void zza(String s, Runnable runnable)
    {
        zzu.zzh(s, "campaign param can't be empty");
        zzhS().zze(new _cls3(s, runnable));
    }

    public void zzhG()
    {
        zzia();
        zzhN();
        zzhS().zze(new _cls5());
    }

    public void zzhH()
    {
        zzia();
        Context context = getContext();
        if (AnalyticsReceiver.zzT(context) && AnalyticsService.zzU(context))
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

    public boolean zzhI()
    {
        zzia();
        Future future = zzhS().zzb(new _cls7());
        try
        {
            future.get();
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
        return true;
    }

    public void zzhJ()
    {
        zzia();
        zzns.zzhO();
        zzJq.zzhJ();
    }

    public void zzhK()
    {
        zzaT("Radio powered up");
        zzhH();
    }

    void zzhL()
    {
        zzhO();
        zzJq.zzhL();
    }

    protected void zzhn()
    {
        zzJq.zza();
    }

    private class _cls1
        implements Runnable
    {

        final int zzJr;
        final zzb zzJs;

        public void run()
        {
            zzb.zza(zzJs).zzs((long)zzJr * 1000L);
        }

        _cls1(int i)
        {
            zzJs = zzb.this;
            zzJr = i;
            super();
        }
    }


    private class _cls2
        implements Runnable
    {

        final zzb zzJs;
        final boolean zzJt;

        public void run()
        {
            zzb.zza(zzJs).zzG(zzJt);
        }

        _cls2(boolean flag)
        {
            zzJs = zzb.this;
            zzJt = flag;
            super();
        }
    }


    private class _cls4
        implements Runnable
    {

        final zzb zzJs;
        final zzab zzJw;

        public void run()
        {
            zzb.zza(zzJs).zza(zzJw);
        }

        _cls4(zzab zzab)
        {
            zzJs = zzb.this;
            zzJw = zzab;
            super();
        }
    }


    private class _cls6
        implements Runnable
    {

        final zzb zzJs;
        final zzw zzJx;

        public void run()
        {
            zzb.zza(zzJs).zzb(zzJx);
        }

        _cls6(zzw zzw)
        {
            zzJs = zzb.this;
            zzJx = zzw;
            super();
        }
    }


    private class _cls3
        implements Runnable
    {

        final zzb zzJs;
        final String zzJu;
        final Runnable zzJv;

        public void run()
        {
            zzb.zza(zzJs).zzbb(zzJu);
            if (zzJv != null)
            {
                zzJv.run();
            }
        }

        _cls3(String s, Runnable runnable)
        {
            zzJs = zzb.this;
            zzJu = s;
            zzJv = runnable;
            super();
        }
    }


    private class _cls5
        implements Runnable
    {

        final zzb zzJs;

        public void run()
        {
            zzb.zza(zzJs).zzhG();
        }

        _cls5()
        {
            zzJs = zzb.this;
            super();
        }
    }


    private class _cls7
        implements Callable
    {

        final zzb zzJs;

        public Object call()
        {
            return zzgk();
        }

        public Void zzgk()
        {
            zzb.zza(zzJs).zziF();
            return null;
        }

        _cls7()
        {
            zzJs = zzb.this;
            super();
        }
    }

}
