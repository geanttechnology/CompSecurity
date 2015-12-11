// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.w;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
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

// Referenced classes of package com.google.android.gms.d:
//            iw, ix, jb, jd, 
//            iz

public final class ja
{
    private final class a extends ThreadPoolExecutor
    {

        final ja a;

        protected final RunnableFuture newTaskFor(Runnable runnable, Object obj)
        {
            return new FutureTask(this, runnable, obj) {

                final a a;

                protected final void setException(Throwable throwable)
                {
                    Thread.UncaughtExceptionHandler uncaughtexceptionhandler = ja.b(a.a);
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

            
            {
                a = a1;
                super(runnable, obj);
            }
            };
        }

        public a()
        {
            a = ja.this;
            super(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            setThreadFactory(new b((byte)0));
        }
    }

    private static final class b
        implements ThreadFactory
    {

        private static final AtomicInteger a = new AtomicInteger();

        public final Thread newThread(Runnable runnable)
        {
            return new c(runnable, (new StringBuilder("measurement-")).append(a.incrementAndGet()).toString());
        }


        private b()
        {
        }

        b(byte byte0)
        {
            this();
        }
    }

    private static final class c extends Thread
    {

        public final void run()
        {
            Process.setThreadPriority(10);
            super.run();
        }

        c(Runnable runnable, String s)
        {
            super(runnable, s);
        }
    }


    private static volatile ja d;
    public final Context a;
    public final a b = new a();
    public Thread.UncaughtExceptionHandler c;
    private final List e = new CopyOnWriteArrayList();
    private final iw f = new iw();
    private volatile jd g;

    private ja(Context context)
    {
        context = context.getApplicationContext();
        w.a(context);
        a = context;
    }

    public static ja a(Context context)
    {
        w.a(context);
        if (d != null) goto _L2; else goto _L1
_L1:
        com/google/android/gms/d/ja;
        JVM INSTR monitorenter ;
        if (d == null)
        {
            d = new ja(context);
        }
        com/google/android/gms/d/ja;
        JVM INSTR monitorexit ;
_L2:
        return d;
        context;
        com/google/android/gms/d/ja;
        JVM INSTR monitorexit ;
        throw context;
    }

    static List a(ja ja1)
    {
        return ja1.e;
    }

    static void a(ix ix1)
    {
        w.c("deliver should be called from worker thread");
        w.b(ix1.c, "Measurement must be submitted");
        Object obj = ix1.i;
        if (!((List) (obj)).isEmpty())
        {
            HashSet hashset = new HashSet();
            obj = ((List) (obj)).iterator();
            do
            {
                if (!((Iterator) (obj)).hasNext())
                {
                    break;
                }
                jb jb1 = (jb)((Iterator) (obj)).next();
                android.net.Uri uri = jb1.a();
                if (!hashset.contains(uri))
                {
                    hashset.add(uri);
                    jb1.a(ix1);
                }
            } while (true);
        }
    }

    static Thread.UncaughtExceptionHandler b(ja ja1)
    {
        return ja1.c;
    }

    public static void b()
    {
        if (!(Thread.currentThread() instanceof c))
        {
            throw new IllegalStateException("Call expected from worker thread");
        } else
        {
            return;
        }
    }

    public final jd a()
    {
        if (g != null) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorenter ;
        if (g != null) goto _L4; else goto _L3
_L3:
        String s1;
        jd jd1;
        PackageManager packagemanager;
        jd1 = new jd();
        packagemanager = a.getPackageManager();
        s1 = a.getPackageName();
        jd1.c = s1;
        jd1.d = packagemanager.getInstallerPackageName(s1);
        String s;
        Object obj3;
        obj3 = null;
        s = s1;
        PackageInfo packageinfo = packagemanager.getPackageInfo(a.getPackageName(), 0);
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
        jd1.a = ((String) (obj));
        jd1.b = ((String) (obj2));
        g = jd1;
_L4:
        this;
        JVM INSTR monitorexit ;
_L2:
        return g;
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

    public final Future a(Callable callable)
    {
        w.a(callable);
        if (Thread.currentThread() instanceof c)
        {
            callable = new FutureTask(callable);
            callable.run();
            return callable;
        } else
        {
            return b.submit(callable);
        }
    }

    public final void a(Runnable runnable)
    {
        w.a(runnable);
        b.submit(runnable);
    }

    // Unreferenced inner class com/google/android/gms/d/ja$1

/* anonymous class */
    public final class _cls1
        implements Runnable
    {

        final ix a;
        final ja b;

        public final void run()
        {
            a.a.a(a);
            for (Iterator iterator = ja.a(b).iterator(); iterator.hasNext(); iterator.next()) { }
            ja.a(a);
        }

            public 
            {
                b = ja.this;
                a = ix1;
                super();
            }
    }

}
