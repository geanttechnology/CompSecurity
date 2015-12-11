// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzpb;
import com.google.android.gms.internal.zzpd;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

// Referenced classes of package com.google.android.gms.measurement:
//            zzb, zzc, zzi

public final class zzg
{

    private static volatile zzg zzaLc;
    private final Context mContext;
    private volatile zzpb zzNs;
    private final List zzaLd = new CopyOnWriteArrayList();
    private final com.google.android.gms.measurement.zzb zzaLe = new com.google.android.gms.measurement.zzb();
    private final zza zzaLf = new zza();
    private Thread.UncaughtExceptionHandler zzaLg;

    zzg(Context context)
    {
        context = context.getApplicationContext();
        zzx.zzw(context);
        mContext = context;
    }

    static List zza(zzg zzg1)
    {
        return zzg1.zzaLd;
    }

    static void zza(zzg zzg1, zzc zzc1)
    {
        zzg1.zzb(zzc1);
    }

    public static zzg zzaJ(Context context)
    {
        zzx.zzw(context);
        if (zzaLc != null) goto _L2; else goto _L1
_L1:
        com/google/android/gms/measurement/zzg;
        JVM INSTR monitorenter ;
        if (zzaLc == null)
        {
            zzaLc = new zzg(context);
        }
        com/google/android/gms/measurement/zzg;
        JVM INSTR monitorexit ;
_L2:
        return zzaLc;
        context;
        com/google/android/gms/measurement/zzg;
        JVM INSTR monitorexit ;
        throw context;
    }

    static Thread.UncaughtExceptionHandler zzb(zzg zzg1)
    {
        return zzg1.zzaLg;
    }

    private void zzb(zzc zzc1)
    {
        zzx.zzcj("deliver should be called from worker thread");
        zzx.zzb(zzc1.zzyj(), "Measurement must be submitted");
        Object obj = zzc1.zzyg();
        if (!((List) (obj)).isEmpty())
        {
            HashSet hashset = new HashSet();
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                zzi zzi1 = (zzi)((Iterator) (obj)).next();
                android.net.Uri uri = zzi1.zzhI();
                if (!hashset.contains(uri))
                {
                    hashset.add(uri);
                    zzi1.zzb(zzc1);
                }
            }
        }
    }

    public static void zzis()
    {
        if (!(Thread.currentThread() instanceof zzc))
        {
            throw new IllegalStateException("Call expected from worker thread");
        } else
        {
            return;
        }
    }

    public final Context getContext()
    {
        return mContext;
    }

    public final void zza(Thread.UncaughtExceptionHandler uncaughtexceptionhandler)
    {
        zzaLg = uncaughtexceptionhandler;
    }

    public final Future zzb(Callable callable)
    {
        zzx.zzw(callable);
        if (Thread.currentThread() instanceof zzc)
        {
            callable = new FutureTask(callable);
            callable.run();
            return callable;
        } else
        {
            return zzaLf.submit(callable);
        }
    }

    final void zze(com.google.android.gms.measurement.zzc zzc1)
    {
        if (zzc1.zzyn())
        {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        }
        if (zzc1.zzyj())
        {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else
        {
            zzc1 = zzc1.zzye();
            zzc1.zzyk();
            zzaLf.execute(new _cls1(zzc1));
            return;
        }
    }

    public final void zzg(Runnable runnable)
    {
        zzx.zzw(runnable);
        zzaLf.submit(runnable);
    }

    public final zzpb zzyr()
    {
        if (zzNs != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (zzNs != null) goto _L4; else goto _L3
_L3:
        String s1;
        zzpb zzpb1;
        PackageManager packagemanager;
        zzpb1 = new zzpb();
        packagemanager = mContext.getPackageManager();
        s1 = mContext.getPackageName();
        zzpb1.setAppId(s1);
        zzpb1.setAppInstallerId(packagemanager.getInstallerPackageName(s1));
        String s;
        Object obj3;
        obj3 = null;
        s = s1;
        PackageInfo packageinfo = packagemanager.getPackageInfo(mContext.getPackageName(), 0);
        Object obj;
        Object obj2;
        obj2 = obj3;
        obj = s1;
        if (packageinfo == null)
        {
            break MISSING_BLOCK_LABEL_135;
        }
        s = s1;
        obj2 = packagemanager.getApplicationLabel(packageinfo.applicationInfo);
        obj = s1;
        s = s1;
        if (TextUtils.isEmpty(((CharSequence) (obj2))))
        {
            break MISSING_BLOCK_LABEL_126;
        }
        s = s1;
        obj = ((CharSequence) (obj2)).toString();
        s = ((String) (obj));
        obj2 = packageinfo.versionName;
_L5:
        zzpb1.setAppName(((String) (obj)));
        zzpb1.setAppVersion(((String) (obj2)));
        zzNs = zzpb1;
_L4:
        this;
        JVM INSTR monitorexit ;
_L2:
        return zzNs;
        Object obj1;
        obj1;
        Log.e("GAv4", (new StringBuilder("Error retrieving package info: appName set to ")).append(s).toString());
        obj2 = obj3;
        obj1 = s;
          goto _L5
        obj1;
        this;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public final zzpd zzys()
    {
        DisplayMetrics displaymetrics = mContext.getResources().getDisplayMetrics();
        zzpd zzpd1 = new zzpd();
        zzpd1.setLanguage(zzam.zza(Locale.getDefault()));
        zzpd1.zzhX(displaymetrics.widthPixels);
        zzpd1.zzhY(displaymetrics.heightPixels);
        return zzpd1;
    }

    private class zza extends ThreadPoolExecutor
    {
        private class zzb
            implements ThreadFactory
        {

            private static final AtomicInteger zzaLk = new AtomicInteger();

            public Thread newThread(Runnable runnable)
            {
                return new zzc(runnable, (new StringBuilder("measurement-")).append(zzaLk.incrementAndGet()).toString());
            }


            private zzb()
            {
            }

            zzb(_cls1 _pcls1)
            {
                this();
            }
        }


        final zzg zzaLi;

        protected RunnableFuture newTaskFor(Runnable runnable, Object obj)
        {
            class _cls1 extends FutureTask
            {

                final zza zzaLj;

                protected void setException(Throwable throwable)
                {
                    Thread.UncaughtExceptionHandler uncaughtexceptionhandler = zzg.zzb(zzaLj.zzaLi);
                    if (uncaughtexceptionhandler == null) goto _L2; else goto _L1
_L1:
                    uncaughtexceptionhandler.uncaughtException(Thread.currentThread(), throwable);
_L4:
                    super.setException(throwable);
                    return;
_L2:
                    if (Log.isLoggable("GAv4", 6))
                    {
                        Log.e("GAv4", (new StringBuilder("MeasurementExecutor: job failed with ")).append(throwable).toString());
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

                _cls1(Runnable runnable, Object obj)
                {
                    zzaLj = zza.this;
                    super(runnable, obj);
                }
            }

            return new _cls1(runnable, obj);
        }

        public zza()
        {
            zzaLi = zzg.this;
            super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            setThreadFactory(new zzb(null));
        }
    }


    private class zzc extends Thread
    {

        public void run()
        {
            Process.setThreadPriority(10);
            super.run();
        }

        zzc(Runnable runnable, String s)
        {
            super(runnable, s);
        }
    }


    private class _cls1
        implements Runnable
    {

        final com.google.android.gms.measurement.zzc zzaLh;
        final zzg zzaLi;

        public void run()
        {
            zzaLh.zzyl().zza(zzaLh);
            for (Iterator iterator = zzg.zza(zzaLi).iterator(); iterator.hasNext(); ((zzh)iterator.next()).zza(zzaLh)) { }
            zzg.zza(zzaLi, zzaLh);
        }

        _cls1(com.google.android.gms.measurement.zzc zzc1)
        {
            zzaLi = zzg.this;
            zzaLh = zzc1;
            super();
        }
    }

}
