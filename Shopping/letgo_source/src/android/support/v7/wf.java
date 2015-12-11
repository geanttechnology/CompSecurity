// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Process;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.android.gms.analytics.internal.l;
import com.google.android.gms.common.internal.x;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package android.support.v7:
//            wa, wb, wh, wk, 
//            wm, we, wg

public final class wf
{
    private class a extends ThreadPoolExecutor
    {

        final wf a;

        protected RunnableFuture newTaskFor(Runnable runnable, Object obj)
        {
            return new FutureTask(this, runnable, obj) {

                final a a;

                protected void setException(Throwable throwable)
                {
                    Thread.UncaughtExceptionHandler uncaughtexceptionhandler = wf.b(a.a);
                    if (uncaughtexceptionhandler == null) goto _L2; else goto _L1
_L1:
                    uncaughtexceptionhandler.uncaughtException(Thread.currentThread(), throwable);
_L4:
                    super.setException(throwable);
                    return;
_L2:
                    if (Log.isLoggable("GAv4", 6))
                    {
                        Log.e("GAv4", (new StringBuilder()).append("MeasurementExecutor: job failed with ").append(throwable).toString());
                    }
                    if (true) goto _L4; else goto _L3
_L3:
                }

            
            {
                a = a1;
                super(runnable, obj);
            }
            };
        }

        public a()
        {
            a = wf.this;
            super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            setThreadFactory(new b());
        }
    }

    private static class b
        implements ThreadFactory
    {

        private static final AtomicInteger a = new AtomicInteger();

        public Thread newThread(Runnable runnable)
        {
            return new c(runnable, (new StringBuilder()).append("measurement-").append(a.incrementAndGet()).toString());
        }


        private b()
        {
        }

    }

    private static class c extends Thread
    {

        public void run()
        {
            Process.setThreadPriority(10);
            super.run();
        }

        c(Runnable runnable, String s)
        {
            super(runnable, s);
        }
    }


    private static volatile wf a;
    private final Context b;
    private final List c = new CopyOnWriteArrayList();
    private final wa d = new wa();
    private final a e = new a();
    private volatile wk f;
    private Thread.UncaughtExceptionHandler g;

    wf(Context context)
    {
        context = context.getApplicationContext();
        x.a(context);
        b = context;
    }

    public static wf a(Context context)
    {
        x.a(context);
        if (a != null) goto _L2; else goto _L1
_L1:
        android/support/v7/wf;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = new wf(context);
        }
        android/support/v7/wf;
        JVM INSTR monitorexit ;
_L2:
        return a;
        context;
        android/support/v7/wf;
        JVM INSTR monitorexit ;
        throw context;
    }

    static List a(wf wf1)
    {
        return wf1.c;
    }

    static void a(wf wf1, wb wb1)
    {
        wf1.b(wb1);
    }

    static Thread.UncaughtExceptionHandler b(wf wf1)
    {
        return wf1.g;
    }

    private void b(wb wb1)
    {
        x.c("deliver should be called from worker thread");
        x.b(wb1.f(), "Measurement must be submitted");
        Object obj = wb1.c();
        if (!((List) (obj)).isEmpty())
        {
            HashSet hashset = new HashSet();
            obj = ((List) (obj)).iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                wh wh1 = (wh)((Iterator) (obj)).next();
                android.net.Uri uri = wh1.a();
                if (!hashset.contains(uri))
                {
                    hashset.add(uri);
                    wh1.a(wb1);
                }
            }
        }
    }

    public static void d()
    {
        if (!(Thread.currentThread() instanceof c))
        {
            throw new IllegalStateException("Call expected from worker thread");
        } else
        {
            return;
        }
    }

    public wk a()
    {
        if (f != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (f != null) goto _L4; else goto _L3
_L3:
        String s1;
        wk wk1;
        PackageManager packagemanager;
        wk1 = new wk();
        packagemanager = b.getPackageManager();
        s1 = b.getPackageName();
        wk1.c(s1);
        wk1.d(packagemanager.getInstallerPackageName(s1));
        String s;
        Object obj3;
        obj3 = null;
        s = s1;
        PackageInfo packageinfo = packagemanager.getPackageInfo(b.getPackageName(), 0);
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
        wk1.a(((String) (obj)));
        wk1.b(((String) (obj2)));
        f = wk1;
_L4:
        this;
        JVM INSTR monitorexit ;
_L2:
        return f;
        Object obj1;
        obj1;
        Log.e("GAv4", (new StringBuilder()).append("Error retrieving package info: appName set to ").append(s).toString());
        obj2 = obj3;
        obj1 = s;
          goto _L5
        obj1;
        this;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    public Future a(Callable callable)
    {
        x.a(callable);
        if (Thread.currentThread() instanceof c)
        {
            callable = new FutureTask(callable);
            callable.run();
            return callable;
        } else
        {
            return e.submit(callable);
        }
    }

    void a(wb wb1)
    {
        if (wb1.j())
        {
            throw new IllegalStateException("Measurement prototype can't be submitted");
        }
        if (wb1.f())
        {
            throw new IllegalStateException("Measurement can only be submitted once");
        } else
        {
            wb1 = wb1.a();
            wb1.g();
            e.execute(new Runnable(wb1) {

                final wb a;
                final wf b;

                public void run()
                {
                    a.h().a(a);
                    for (Iterator iterator = wf.a(b).iterator(); iterator.hasNext(); ((wg)iterator.next()).a(a)) { }
                    wf.a(b, a);
                }

            
            {
                b = wf.this;
                a = wb1;
                super();
            }
            });
            return;
        }
    }

    public void a(Runnable runnable)
    {
        x.a(runnable);
        e.submit(runnable);
    }

    public void a(Thread.UncaughtExceptionHandler uncaughtexceptionhandler)
    {
        g = uncaughtexceptionhandler;
    }

    public wm b()
    {
        DisplayMetrics displaymetrics = b.getResources().getDisplayMetrics();
        wm wm1 = new wm();
        wm1.a(l.a(Locale.getDefault()));
        wm1.b(displaymetrics.widthPixels);
        wm1.c(displaymetrics.heightPixels);
        return wm1;
    }

    public Context c()
    {
        return b;
    }
}
