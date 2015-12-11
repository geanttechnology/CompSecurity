// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.device.ads;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.device.ads:
//            co, cn, at

final class ds
{
    public static final class a extends i
    {

        public a(l l1)
        {
            super(l1, new j());
        }
    }

    public static final class b extends Enum
    {

        public static final b a;
        public static final b b;
        private static final b c[];

        public static b valueOf(String s)
        {
            return (b)Enum.valueOf(com/amazon/device/ads/ds$b, s);
        }

        public static b[] values()
        {
            return (b[])c.clone();
        }

        static 
        {
            a = new b("RUN_ASAP", 0);
            b = new b("SCHEDULE", 1);
            c = (new b[] {
                a, b
            });
        }

        private b(String s, int i1)
        {
            super(s, i1);
        }
    }

    public static final class c extends Enum
    {

        public static final c a;
        public static final c b;
        private static final c c[];

        public static c valueOf(String s)
        {
            return (c)Enum.valueOf(com/amazon/device/ads/ds$c, s);
        }

        public static c[] values()
        {
            return (c[])c.clone();
        }

        static 
        {
            a = new c("MAIN_THREAD", 0);
            b = new c("BACKGROUND_THREAD", 1);
            c = (new c[] {
                a, b
            });
        }

        private c(String s, int i1)
        {
            super(s, i1);
        }
    }

    public static final class d extends i
    {

        public d(l l1)
        {
            super(l1, new e());
        }
    }

    public static final class e extends g
    {

        public final void a(Runnable runnable)
        {
            (new Handler(Looper.getMainLooper())).post(runnable);
        }

        public e()
        {
            super(b.b, c.a);
        }
    }

    static abstract class f extends AsyncTask
    {

        protected transient abstract Object doInBackground(Object aobj[]);

        protected void onPostExecute(Object obj)
        {
            super.onPostExecute(obj);
        }

        protected void onPreExecute()
        {
            super.onPreExecute();
        }

        f()
        {
        }
    }

    public static abstract class g
    {

        final b a;
        final c b;

        public abstract void a(Runnable runnable);

        public g(b b1, c c1)
        {
            a = b1;
            b = c1;
        }
    }

    public static final class h extends g
    {

        private ExecutorService c;

        public final void a(Runnable runnable)
        {
            c.submit(runnable);
        }

        public h()
        {
            super(b.b, c.b);
            c = Executors.newSingleThreadExecutor();
        }
    }

    public static class i extends g
    {

        private final l c;
        private final g d;

        public final void a(Runnable runnable)
        {
            boolean flag = false;
            static final class _cls1
            {

                static final int a[];

                static 
                {
                    a = new int[c.values().length];
                    try
                    {
                        a[c.a.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        a[c.b.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            _cls1.a[d.b.ordinal()];
            JVM INSTR tableswitch 1 2: default 40
        //                       1 53
        //                       2 64;
               goto _L1 _L2 _L3
_L1:
            break; /* Loop/switch isn't completed */
_L3:
            break MISSING_BLOCK_LABEL_64;
_L4:
            if (flag)
            {
                d.a(runnable);
                return;
            } else
            {
                runnable.run();
                return;
            }
_L2:
            if (!l.b())
            {
                flag = true;
            }
              goto _L4
            flag = l.b();
              goto _L4
        }

        public i(l l1, g g1)
        {
            super(b.a, g1.b);
            c = l1;
            d = g1;
        }
    }

    public static final class j extends g
    {

        private final ExecutorService c;

        public final void a(Runnable runnable)
        {
            c.submit(runnable);
        }

        public j()
        {
            super(b.b, c.b);
            c = new ThreadPoolExecutor(1, 3, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        }
    }

    /* member class not found */
    class k {}

    static final class l
    {

        private static l a = new l();

        static l a()
        {
            return a;
        }

        static boolean b()
        {
            return Looper.getMainLooper().getThread() == Thread.currentThread();
        }


        l()
        {
        }
    }


    private static k a = new k();

    public static k a()
    {
        return a;
    }

    public static void a(Runnable runnable)
    {
        a.a(runnable, b.b, c.b);
    }

    public static void b(Runnable runnable)
    {
        a.a(runnable, b.b, c.a);
    }

    public static boolean b()
    {
        l.a();
        return l.b();
    }

    static k c()
    {
        return a;
    }

    public static void c(Runnable runnable)
    {
        a.a(runnable, b.a, c.a);
    }


    // Unreferenced inner class com/amazon/device/ads/ds$k$1

/* anonymous class */
    final class k._cls1
        implements Runnable
    {

        final f a;
        final Object b[];
        final k c;

        public final void run()
        {
            at.a(a, b);
        }

            
            {
                c = k1;
                a = f1;
                b = aobj;
                super();
            }
    }

}
