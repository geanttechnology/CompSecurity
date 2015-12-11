// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.http.AndroidHttpClient;
import android.util.Log;
import android.util.TimingLogger;
import com.threatmetrix.TrustDefenderMobile.NativeGatherer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpConnectionParams;

// Referenced classes of package com.tapjoy.internal:
//            fl, fj, em, ex, 
//            es, ff, en, fd, 
//            ey, fa, eq, eo, 
//            fg, fc, ez, eu, 
//            fn

public class fk
{
    final class a
        implements Runnable
    {

        final Thread a;
        final fk b;

        public final void run()
        {
            fk.f();
            (new StringBuilder("sending interrupt to TID: ")).append(a.getId());
            a.interrupt();
        }

        a(Thread thread)
        {
            b = fk.this;
            super();
            a = thread;
        }
    }

    final class b
        implements Runnable
    {

        final AndroidHttpClient a;
        final fk b;

        public final void run()
        {
            if (a == null)
            {
                return;
            }
            try
            {
                a.close();
                a.getConnectionManager().shutdown();
                return;
            }
            catch (RuntimeException runtimeexception)
            {
                Log.e(fk.f(), "Swallowing", runtimeexception);
            }
        }

        b(AndroidHttpClient androidhttpclient)
        {
            b = fk.this;
            super();
            a = androidhttpclient;
        }
    }

    public static final class c extends Enum
    {

        public static final c a;
        public static final c b;
        public static final c c;
        public static final c d;
        public static final c e;
        public static final c f;
        public static final c g;
        public static final c h;
        public static final c i;
        public static final c j;
        public static final c k;
        private static final c n[];
        private final String l;
        private final String m;

        static c a(eu eu1)
        {
            return valueOf(eu1.name());
        }

        public static c valueOf(String s1)
        {
            return (c)Enum.valueOf(com/tapjoy/internal/fk$c, s1);
        }

        public static c[] values()
        {
            return (c[])n.clone();
        }

        public final String a()
        {
            return m;
        }

        final eu b()
        {
            return eu.valueOf(name());
        }

        public final String toString()
        {
            return l;
        }

        static 
        {
            a = new c("THM_NotYet", 0);
            b = new c("THM_OK", 1);
            c = new c("THM_Connection_Error", 2);
            d = new c("THM_HostNotFound_Error", 3);
            e = new c("THM_NetworkTimeout_Error", 4);
            f = new c("THM_Internal_Error", 5);
            g = new c("THM_HostVerification_Error", 6);
            h = new c("THM_Interrupted_Error", 7);
            i = new c("THM_InvalidOrgID", 8);
            j = new c("THM_ConfigurationError", 9);
            k = new c("THM_PartialProfile", 10);
            n = (new c[] {
                a, b, c, d, e, f, g, h, i, j, 
                k
            });
        }

        private c(String s1, int i1)
        {
            super(s1, i1);
            s1 = eu.valueOf(name());
            l = s1.toString();
            m = s1.a();
        }
    }


    private static final String w = com/tapjoy/internal/fk.getSimpleName();
    private static final Executor x = Executors.newFixedThreadPool(6);
    final fl a = new fl();
    AndroidHttpClient b;
    private final ArrayList c = new ArrayList();
    private final ReadWriteLock d = new ReentrantReadWriteLock();
    private final Lock e;
    private final Lock f;
    private final ReentrantLock g = new ReentrantLock();
    private ez h;
    private Thread i;
    private volatile boolean j;
    private volatile AtomicBoolean k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private AtomicBoolean q;
    private CountDownLatch r;
    private final fj s = new fj();
    private final em t = new em();
    private Context u;
    private TimingLogger v;

    public fk()
    {
        e = d.readLock();
        f = d.writeLock();
        h = null;
        i = null;
        j = false;
        k = new AtomicBoolean(false);
        l = 0;
        m = 10000;
        n = 0;
        o = false;
        p = false;
        q = new AtomicBoolean(false);
        r = new CountDownLatch(1);
        b = null;
        u = null;
        v = null;
    }

    static em a(fk fk1)
    {
        return fk1.t;
    }

    private ex a(Runnable runnable)
    {
        while (runnable == null || k.get()) 
        {
            return null;
        }
        ex ex1;
        ex1 = new ex(runnable);
        if (!(runnable instanceof es))
        {
            break MISSING_BLOCK_LABEL_59;
        }
        f.lock();
        c.add(ex1);
        f.unlock();
        ex1.start();
        return ex1;
        runnable;
        try
        {
            f.unlock();
            throw runnable;
        }
        // Misplaced declaration of an exception variable
        catch (Runnable runnable)
        {
            runnable = w;
        }
        return null;
    }

    private c a(boolean flag)
    {
        Object obj = c.a;
        Iterator iterator;
        e.lockInterruptibly();
        iterator = c.iterator();
_L7:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        Object obj3 = (ex)iterator.next();
        if (!k.get() && !Thread.currentThread().isInterrupted()) goto _L4; else goto _L3
_L3:
        obj = c.h;
_L2:
        if (v != null)
        {
            v.addSplit("wait for network threads");
        }
        e.unlock();
        Object obj1 = obj;
        if (obj == c.a)
        {
            obj1 = c.b;
        }
        return ((c) (obj1));
_L4:
        Object obj2 = obj;
        ((ex) (obj3)).join(m);
        obj2 = obj;
        if (((ex) (obj3)).getState() == Thread.State.TERMINATED) goto _L6; else goto _L5
_L5:
        obj2 = obj;
        obj = c.c;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_152;
        }
        obj2 = obj;
        b(true);
          goto _L2
        obj2 = obj;
        a(((Thread) (obj3)));
          goto _L7
        obj;
_L10:
        if (obj2 != c.a)
        {
            break MISSING_BLOCK_LABEL_391;
        }
        obj = c.c;
_L13:
        b(true);
        obj2 = w;
          goto _L2
_L6:
        obj2 = obj;
        es es1 = ((ex) (obj3)).a();
        if (es1 == null) goto _L7; else goto _L8
_L8:
        obj2 = obj;
        obj3 = ((ex) (obj3)).a().a();
        obj2 = obj;
        if (obj3 != c.b)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        obj2 = obj;
        if (es1.b() == 200)
        {
            break MISSING_BLOCK_LABEL_298;
        }
        obj2 = obj;
        obj3 = w;
        obj2 = obj;
        (new StringBuilder("Connection returned http status code:")).append(es1.b());
        obj2 = obj;
        obj3 = c.c;
        obj = obj3;
        if (flag) goto _L7; else goto _L9
_L9:
        obj = obj3;
        b(true);
        obj = obj3;
          goto _L2
        obj2;
        obj2 = obj;
          goto _L10
        obj2 = obj;
        if (obj3 == c.b) goto _L7; else goto _L11
_L11:
        obj2 = obj;
        String s1 = w;
        obj2 = obj;
        (new StringBuilder("Connection returned status :")).append(es1.a().a());
        obj = obj3;
        if (flag) goto _L7; else goto _L12
_L12:
        obj = obj3;
        b(true);
        obj = obj3;
          goto _L2
        Exception exception;
        exception;
        if (v != null)
        {
            v.addSplit("wait for network threads");
        }
        e.unlock();
        throw exception;
        exception = ((Exception) (obj2));
          goto _L13
    }

    private void a(Thread thread)
    {
        x.execute(new a(thread));
    }

    static TimingLogger b(fk fk1)
    {
        return fk1.v;
    }

    private void b(boolean flag)
    {
        if (flag)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        e.lock();
        for (Iterator iterator = c.iterator(); iterator.hasNext(); a((ex)iterator.next())) { }
        break MISSING_BLOCK_LABEL_62;
        Exception exception;
        exception;
        if (!flag)
        {
            e.unlock();
        }
        throw exception;
        if (!flag)
        {
            e.unlock();
        }
        return;
    }

    static Context c(fk fk1)
    {
        return fk1.u;
    }

    static int d(fk fk1)
    {
        return fk1.m;
    }

    static CountDownLatch e(fk fk1)
    {
        return fk1.r;
    }

    static String f()
    {
        return w;
    }

    private void g()
    {
        this;
        JVM INSTR monitorenter ;
        Object obj = w;
        if (k.compareAndSet(false, true)) goto _L2; else goto _L1
_L1:
        Log.w(w, "Cancel already happened");
_L5:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        if (!j)
        {
            break MISSING_BLOCK_LABEL_190;
        }
        obj = w;
        b(false);
        if (i != null)
        {
            obj = w;
            (new StringBuilder("sending interrupt to profile thread TID: ")).append(i.getId());
            i.interrupt();
        }
        obj = w;
        e.lock();
        obj = c.iterator();
_L3:
        Object obj1;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_145;
        }
        obj1 = (ex)((Iterator) (obj)).next();
        String s1 = w;
        ((ex) (obj1)).join();
          goto _L3
        InterruptedException interruptedexception1;
        interruptedexception1;
        interruptedexception1 = w;
          goto _L3
        boolean flag;
        e.unlock();
        if (i == null)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        flag = i.isAlive();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_186;
        }
        Exception exception;
        try
        {
            obj = w;
            i.join();
        }
        catch (InterruptedException interruptedexception) { }
        obj = w;
        f.lock();
        c.clear();
        f.unlock();
        if (true) goto _L5; else goto _L4
_L4:
        exception;
        throw exception;
        exception;
        e.unlock();
        throw exception;
        exception;
        f.unlock();
        throw exception;
    }

    private boolean h()
    {
        if (q.get()) goto _L2; else goto _L1
_L1:
        boolean flag1 = true;
_L4:
        return flag1;
_L2:
        String s1 = w;
        boolean flag = r.await(m, TimeUnit.MILLISECONDS);
        flag1 = flag;
        if (flag) goto _L4; else goto _L3
_L3:
        Log.e(w, "Timed out waiting for init to complete");
        return flag;
        InterruptedException interruptedexception;
        interruptedexception;
_L6:
        Log.e(w, "Waiting for init to complete interrupted", interruptedexception);
        return flag;
        interruptedexception;
        flag = false;
        if (true) goto _L6; else goto _L5
_L5:
    }

    private void i()
    {
        f.lockInterruptibly();
        c.clear();
        f.unlock();
        return;
        Exception exception;
        exception;
        f.unlock();
        throw exception;
    }

    public final c a(Context context, String s1, String s2, String s3)
    {
        if (context == null)
        {
            return c.f;
        }
        f.lockInterruptibly();
        String s4 = w;
        new StringBuilder("starting profile request using - 2.5-16 with options 3097");
        if (!j)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        context = c.a;
        f.unlock();
        return context;
        a.g();
        n = 3097;
        a.a();
        s.a();
        a.a(k);
        k.set(false);
        a.a(c.a.b());
        if (c.size() > 0)
        {
            String s5 = w;
            b(true);
        }
        c.clear();
        if (a.b(s2))
        {
            break MISSING_BLOCK_LABEL_169;
        }
        context = c.j;
        f.unlock();
        return context;
        if (a.c(s1))
        {
            break MISSING_BLOCK_LABEL_209;
        }
        if (v != null)
        {
            v.dumpToLog();
        }
        context = c.i;
        f.unlock();
        return context;
        j = true;
        if (o || a.b() == null)
        {
            a.a(ff.a());
        }
        if (p && o)
        {
            Log.w(w, "Previous profile used manually specified session ID, but generated session ID used this time. This is likely a bug, make sure setSessionID() is called before every profile");
        }
        o = true;
        u = context.getApplicationContext();
        a.a(u);
        context = u.getPackageName();
        a.a(s3, context);
        context = (new StringBuilder()).append(context).append("TDM").toString();
        l = 0;
        context = u.getSharedPreferences(context, 0);
        l = context.getInt("options", 0);
_L1:
        if (k.get())
        {
            throw new InterruptedException();
        }
        break MISSING_BLOCK_LABEL_419;
        context;
        if (i != null)
        {
            i.interrupt();
        }
        j = false;
        context = c.h;
        f.unlock();
        return context;
        context;
        context = w;
          goto _L1
        context = w;
        (new StringBuilder("applying inverted saved options - ")).append(l).append(" with options, resulting in  ").append(n);
        n = n ^ l & 0x26 | l & 0x300;
        if ((n & 1) != 0)
        {
            break MISSING_BLOCK_LABEL_514;
        }
        e();
        context = c.a(a.c());
        f.unlock();
        return context;
        i = new Thread(new en(this));
        i.start();
        context = c.b;
        f.unlock();
        return context;
        context;
        f.unlock();
        throw context;
    }

    public final void a()
    {
        m = 10000;
    }

    public final void a(ez ez)
    {
        g.lockInterruptibly();
        h = ez;
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
        return;
        ez;
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
        throw ez;
    }

    final void a(c c1)
    {
        a.a(c1.b());
    }

    public final String b()
    {
        return a.b();
    }

    public final c c()
    {
        return c.a(a.c());
    }

    public final void d()
    {
        String s1 = w;
        g();
        s.a();
        h();
        if (b != null)
        {
            if (b.getConnectionManager() != null)
            {
                x.execute(new b(b));
            }
            b = null;
        }
        t.b();
        fd.b();
        q.set(false);
        r = new CountDownLatch(1);
    }

    final void e()
    {
        boolean flag1 = true;
        Object obj2;
        String s1 = w;
        obj2 = new StringBuilder("continuing profile request ");
        Object obj;
        if (q.get())
        {
            obj = "inited already";
        } else
        {
            obj = " needs init";
        }
        ((StringBuilder) (obj2)).append(((String) (obj)));
        if (v != null)
        {
            v.addSplit("after startup and thread split");
        }
        if (k.get() || Thread.currentThread().isInterrupted())
        {
            throw new InterruptedException();
        }
          goto _L1
        obj;
        obj = w;
        a.a(c.f.b());
        if (k.get())
        {
            a.a(c.h.b());
            Thread.interrupted();
        }
        g.lockInterruptibly();
        if (h == null) goto _L3; else goto _L2
_L2:
        if (!(h instanceof ey)) goto _L5; else goto _L4
_L4:
        ((ey)h).a();
_L3:
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
_L51:
        j = false;
        return;
_L1:
        if (q.get()) goto _L7; else goto _L6
_L6:
        obj = w;
        obj = u;
        boolean flag;
        if ((n & 0x26) != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (q.compareAndSet(false, true)) goto _L9; else goto _L8
_L8:
        obj = w;
_L7:
        if (h()) goto _L11; else goto _L10
_L10:
        Log.e(w, "Timed out waiting for init thread, aborting");
        a.a(c.f.b());
        if (k.get())
        {
            a.a(c.h.b());
            Thread.interrupted();
        }
        g.lockInterruptibly();
        if (h == null) goto _L13; else goto _L12
_L12:
        if (!(h instanceof ey)) goto _L15; else goto _L14
_L14:
        ((ey)h).a();
_L13:
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
_L21:
        j = false;
        return;
_L9:
        (new Thread(new en(this, ((Context) (obj)), flag) {

            final Context a;
            final boolean b;
            final fk c;

            public final void run()
            {
                fk.f();
                fk.a(c).a(a, b, 0);
                if (fk.b(c) != null)
                {
                    fk.b(c).addSplit("init - initJSExecutor");
                }
                Object obj3 = fk.a(c).a();
                if (fk.b(c) != null)
                {
                    fk.b(c).addSplit("getUserAgent");
                }
                if (c.b == null)
                {
                    c.b = AndroidHttpClient.newInstance(((String) (obj3)), fk.c(c));
                    obj3 = c.b.getParams();
                    HttpConnectionParams.setConnectionTimeout(((org.apache.http.params.HttpParams) (obj3)), fk.d(c));
                    HttpConnectionParams.setSoTimeout(((org.apache.http.params.HttpParams) (obj3)), fk.d(c));
                    fn.a(a, c.b, fk.d(c));
                    HttpConnectionParams.setTcpNoDelay(((org.apache.http.params.HttpParams) (obj3)), true);
                    HttpConnectionParams.setStaleCheckingEnabled(((org.apache.http.params.HttpParams) (obj3)), false);
                }
                if (fk.b(c) != null)
                {
                    fk.b(c).addSplit("create AndroidHttpClient");
                }
                NativeGatherer.a.a();
                ff.b(null);
                if (fk.e(c) != null)
                {
                    fk.e(c).countDown();
                }
                return;
                Exception exception;
                exception;
                if (fk.e(c) != null)
                {
                    fk.e(c).countDown();
                }
                throw exception;
            }

            
            {
                c = fk.this;
                a = context;
                b = flag;
                super(fk2);
            }
        })).start();
          goto _L7
        Object obj1;
        obj1;
        a.a(c.f.b());
        obj1 = w;
        if (k.get())
        {
            a.a(c.h.b());
            Thread.interrupted();
        }
        g.lockInterruptibly();
        if (h == null) goto _L17; else goto _L16
_L16:
        if (!(h instanceof ey)) goto _L19; else goto _L18
_L18:
        ((ey)h).a();
_L17:
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
_L53:
        j = false;
        return;
_L15:
        if (!(h instanceof fa)) goto _L13; else goto _L20
_L20:
        obj1 = h;
        c.a(a.c());
          goto _L13
        obj1;
        Log.e(w, "profileNotify callback interrupted", ((Throwable) (obj1)));
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
          goto _L21
        obj1;
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
        throw obj1;
_L11:
        obj1 = t;
        obj2 = u;
        if ((n & 0x26) != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        ((em) (obj1)).a(((Context) (obj2)), flag, n);
        if (v != null)
        {
            v.addSplit("initJSExecutor");
        }
        if (k.get() || Thread.currentThread().isInterrupted())
        {
            throw new InterruptedException();
        }
          goto _L22
        obj1;
        if (k.get())
        {
            a.a(c.h.b());
            Thread.interrupted();
        }
        g.lockInterruptibly();
        if (h == null) goto _L24; else goto _L23
_L23:
        if (!(h instanceof ey)) goto _L26; else goto _L25
_L25:
        ((ey)h).a();
_L24:
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
_L55:
        j = false;
        throw obj1;
_L22:
        obj1 = a.h();
        obj2 = a.i();
        obj1 = new eq(b, ((String) (obj1)), ((er) (obj2)), a.k(), this);
        if (a(((Runnable) (obj1))) == null)
        {
            obj1 = null;
        }
        if (v != null)
        {
            v.addSplit("get Config");
        }
        if (obj1 != null)
        {
            break MISSING_BLOCK_LABEL_1009;
        }
        Log.e(w, "Failed to connect to server, aborting");
        a.a(c.f.b());
        if (k.get())
        {
            a.a(c.h.b());
            Thread.interrupted();
        }
        g.lockInterruptibly();
        if (h == null) goto _L28; else goto _L27
_L27:
        if (!(h instanceof ey)) goto _L30; else goto _L29
_L29:
        ((ey)h).a();
_L28:
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
_L32:
        j = false;
        return;
_L30:
        if (!(h instanceof fa)) goto _L28; else goto _L31
_L31:
        obj1 = h;
        c.a(a.c());
          goto _L28
        obj1;
        Log.e(w, "profileNotify callback interrupted", ((Throwable) (obj1)));
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
          goto _L32
        obj1;
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
        throw obj1;
        if (k.get() || Thread.currentThread().isInterrupted())
        {
            throw new InterruptedException();
        }
        flag = t.c();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_1074;
        }
        t.d();
        if (v != null)
        {
            v.addSplit("get browser info");
        }
        a.j();
        if (k.get() || Thread.currentThread().isInterrupted())
        {
            throw new InterruptedException();
        }
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_1131;
        }
        t.b();
        a.a(t);
        if (v != null)
        {
            v.addSplit("wait for browser info");
        }
        if ((n & 0x400) == 0) goto _L34; else goto _L33
_L33:
        String s2 = (new StringBuilder()).append(a.f()).append("-").append(ff.c(a.b())).append("-mob").toString();
        if (s2.length() < 64) goto _L36; else goto _L35
_L35:
        Log.w(w, "combined session id and org id too long for host name fragment");
_L41:
        if (v != null)
        {
            v.addSplit("Started DNS request");
        }
_L34:
        obj2 = a(false);
        if (v != null)
        {
            v.addSplit("wait for config network request");
        }
        i();
        if (obj2 == c.b)
        {
            break MISSING_BLOCK_LABEL_1553;
        }
        Log.e(w, (new StringBuilder("Failed to retrieve config, aborting: ")).append(((c) (obj2)).toString()).toString());
        a.a(((c) (obj2)).b());
        if (k.get())
        {
            a.a(c.h.b());
            Thread.interrupted();
        }
        g.lockInterruptibly();
        if (h == null) goto _L38; else goto _L37
_L37:
        if (!(h instanceof ey)) goto _L40; else goto _L39
_L39:
        ((ey)h).a();
_L38:
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
_L43:
        j = false;
        return;
_L36:
        obj2 = w;
        obj2 = "d";
        if (a.e().equals("qa2-h.online-metrix.net"))
        {
            obj2 = "q";
        }
        a(new eo((new StringBuilder()).append(s2).append(".").append(((String) (obj2))).append(".aa.online-metrix.net").toString()));
          goto _L41
_L40:
        if (!(h instanceof fa)) goto _L38; else goto _L42
_L42:
        obj1 = h;
        c.a(a.c());
          goto _L38
        obj1;
        Log.e(w, "profileNotify callback interrupted", ((Throwable) (obj1)));
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
          goto _L43
        obj1;
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
        throw obj1;
        a.a(((eq) (obj1)).a);
        if (a.d().a != l)
        {
            obj1 = w;
            (new StringBuilder("dynamic options (")).append(a.d().a).append(") != saved: ").append(l);
            obj1 = (new StringBuilder()).append(u.getPackageName()).append("TDM").toString();
            obj1 = u.getSharedPreferences(((String) (obj1)), 0).edit();
            ((android.content.SharedPreferences.Editor) (obj1)).putInt("options", a.d().a);
            ((android.content.SharedPreferences.Editor) (obj1)).apply();
            if (v != null)
            {
                v.addSplit("Processed stored options");
            }
        }
        a.a(s.b());
        obj1 = a.m();
        java.util.Map map = a.l();
        a(new es(b, es.a.d, (new StringBuilder("https://")).append(a.e()).append("/fp/clear.png").toString(), ((er) (obj1)), map, this));
        if ((n & 0x40) != 0)
        {
            a(new fc(a.e(), a.f(), a.b(), a.d().b, m));
        }
        if (v != null)
        {
            v.addSplit("build network threads");
        }
        obj1 = a(true);
        a.a(((c) (obj1)).b());
        if (obj1 != c.b)
        {
            Log.w(w, (new StringBuilder("Received ")).append(((c) (obj1)).a()).append(" error, profiling will be incomplete").toString());
            a.a(c.k.b());
        }
        i();
        obj1 = w;
        if (v != null)
        {
            v.dumpToLog();
        }
        if (k.get())
        {
            a.a(c.h.b());
            Thread.interrupted();
        }
        g.lockInterruptibly();
        if (h == null) goto _L45; else goto _L44
_L44:
        if (!(h instanceof ey)) goto _L47; else goto _L46
_L46:
        ((ey)h).a();
_L45:
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
_L49:
        j = false;
        return;
_L47:
        if (!(h instanceof fa)) goto _L45; else goto _L48
_L48:
        ez ez = h;
        c.a(a.c());
          goto _L45
        ez;
        Log.e(w, "profileNotify callback interrupted", ez);
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
          goto _L49
        ez;
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
        throw ez;
_L5:
        if (!(h instanceof fa)) goto _L3; else goto _L50
_L50:
        ez ez1 = h;
        c.a(a.c());
          goto _L3
        ez1;
        Log.e(w, "profileNotify callback interrupted", ez1);
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
          goto _L51
        ez1;
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
        throw ez1;
_L19:
        if (!(h instanceof fa)) goto _L17; else goto _L52
_L52:
        ez ez2 = h;
        c.a(a.c());
          goto _L17
        ez2;
        Log.e(w, "profileNotify callback interrupted", ez2);
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
          goto _L53
        ez2;
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
        throw ez2;
_L26:
        if (!(h instanceof fa)) goto _L24; else goto _L54
_L54:
        ez ez3 = h;
        c.a(a.c());
          goto _L24
        InterruptedException interruptedexception;
        interruptedexception;
        Log.e(w, "profileNotify callback interrupted", interruptedexception);
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
          goto _L55
        ez2;
        if (g.isHeldByCurrentThread())
        {
            g.unlock();
        }
        throw ez2;
          goto _L21
    }

}
