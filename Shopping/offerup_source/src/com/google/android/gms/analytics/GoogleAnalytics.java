// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzae;
import com.google.android.gms.analytics.internal.zzak;
import com.google.android.gms.analytics.internal.zzal;
import com.google.android.gms.analytics.internal.zzan;
import com.google.android.gms.analytics.internal.zzb;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.analytics.internal.zzn;
import com.google.android.gms.analytics.internal.zzy;
import com.google.android.gms.common.internal.zzx;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.analytics:
//            zza, Tracker, Logger

public final class GoogleAnalytics extends zza
{

    private static List zzLz = new ArrayList();
    private boolean zzLA;
    private Set zzLB;
    private boolean zzLC;
    private boolean zzLD;
    private volatile boolean zzLE;
    private boolean zzLF;
    private boolean zzpA;

    public GoogleAnalytics(zzf zzf1)
    {
        super(zzf1);
        zzLB = new HashSet();
    }

    public static GoogleAnalytics getInstance(Context context)
    {
        return zzf.zzX(context).zziI();
    }

    public static void zzhN()
    {
        com/google/android/gms/analytics/GoogleAnalytics;
        JVM INSTR monitorenter ;
        if (zzLz == null)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        for (Iterator iterator = zzLz.iterator(); iterator.hasNext(); ((Runnable)iterator.next()).run()) { }
        break MISSING_BLOCK_LABEL_50;
        Exception exception;
        exception;
        com/google/android/gms/analytics/GoogleAnalytics;
        JVM INSTR monitorexit ;
        throw exception;
        zzLz = null;
        com/google/android/gms/analytics/GoogleAnalytics;
        JVM INSTR monitorexit ;
    }

    private zzb zzhP()
    {
        return zzhF().zzhP();
    }

    private zzan zzhQ()
    {
        return zzhF().zzhQ();
    }

    public final void dispatchLocalHits()
    {
        zzhP().zzil();
    }

    public final void enableAutoActivityReports(Application application)
    {
        if (android.os.Build.VERSION.SDK_INT >= 14 && !zzLC)
        {
            application.registerActivityLifecycleCallbacks(new zzb());
            zzLC = true;
        }
    }

    public final boolean getAppOptOut()
    {
        return zzLE;
    }

    public final String getClientId()
    {
        zzx.zzcj("getClientId can not be called from the main thread");
        return zzhF().zziL().zzjt();
    }

    public final Logger getLogger()
    {
        return zzae.getLogger();
    }

    public final boolean isDryRunEnabled()
    {
        return zzLD;
    }

    public final boolean isInitialized()
    {
        return zzpA && !zzLA;
    }

    public final Tracker newTracker(int i)
    {
        this;
        JVM INSTR monitorenter ;
        Tracker tracker = new Tracker(zzhF(), null, null);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        zzal zzal1 = (zzal)(new zzak(zzhF())).zzad(i);
        if (zzal1 == null)
        {
            break MISSING_BLOCK_LABEL_48;
        }
        tracker.zza(zzal1);
        tracker.zza();
        this;
        JVM INSTR monitorexit ;
        return tracker;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public final Tracker newTracker(String s)
    {
        this;
        JVM INSTR monitorenter ;
        s = new Tracker(zzhF(), s, null);
        s.zza();
        this;
        JVM INSTR monitorexit ;
        return s;
        s;
        this;
        JVM INSTR monitorexit ;
        throw s;
    }

    public final void reportActivityStart(Activity activity)
    {
        if (!zzLC)
        {
            zzl(activity);
        }
    }

    public final void reportActivityStop(Activity activity)
    {
        if (!zzLC)
        {
            zzm(activity);
        }
    }

    public final void setAppOptOut(boolean flag)
    {
        zzLE = flag;
        if (zzLE)
        {
            zzhP().zzik();
        }
    }

    public final void setDryRun(boolean flag)
    {
        zzLD = flag;
    }

    public final void setLocalDispatchPeriod(int i)
    {
        zzhP().setLocalDispatchPeriod(i);
    }

    public final void setLogger(Logger logger)
    {
        zzae.setLogger(logger);
        if (!zzLF)
        {
            Log.i((String)zzy.zzOg.get(), (new StringBuilder("GoogleAnalytics.setLogger() is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.")).append((String)zzy.zzOg.get()).append(" DEBUG").toString());
            zzLF = true;
        }
    }

    public final void zza()
    {
        zzhM();
        zzpA = true;
    }

    final void zza(zza zza1)
    {
        zzLB.add(zza1);
        zza1 = zzhF().getContext();
        if (zza1 instanceof Application)
        {
            enableAutoActivityReports((Application)zza1);
        }
    }

    final void zzb(zza zza1)
    {
        zzLB.remove(zza1);
    }

    final void zzhM()
    {
        zzan zzan1 = zzhQ();
        if (zzan1.zzks())
        {
            getLogger().setLogLevel(zzan1.getLogLevel());
        }
        if (zzan1.zzkw())
        {
            setDryRun(zzan1.zzkx());
        }
        if (zzan1.zzks())
        {
            Logger logger = zzae.getLogger();
            if (logger != null)
            {
                logger.setLogLevel(zzan1.getLogLevel());
            }
        }
    }

    final void zzhO()
    {
        zzhP().zzim();
    }

    final void zzl(Activity activity)
    {
        for (Iterator iterator = zzLB.iterator(); iterator.hasNext(); ((zza)iterator.next()).zzn(activity)) { }
    }

    final void zzm(Activity activity)
    {
        for (Iterator iterator = zzLB.iterator(); iterator.hasNext(); ((zza)iterator.next()).zzo(activity)) { }
    }


    private class zzb
        implements android.app.Application.ActivityLifecycleCallbacks
    {

        final GoogleAnalytics zzLG;

        public void onActivityCreated(Activity activity, Bundle bundle)
        {
        }

        public void onActivityDestroyed(Activity activity)
        {
        }

        public void onActivityPaused(Activity activity)
        {
        }

        public void onActivityResumed(Activity activity)
        {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle)
        {
        }

        public void onActivityStarted(Activity activity)
        {
            zzLG.zzl(activity);
        }

        public void onActivityStopped(Activity activity)
        {
            zzLG.zzm(activity);
        }

        zzb()
        {
            zzLG = GoogleAnalytics.this;
            super();
        }
    }


    private class zza
    {

        public abstract void zzn(Activity activity);

        public abstract void zzo(Activity activity);
    }

}
