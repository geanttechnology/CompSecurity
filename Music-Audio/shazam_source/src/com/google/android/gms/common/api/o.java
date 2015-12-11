// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.b;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.w;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.google.android.gms.common.api:
//            c, n, a, m, 
//            l, p, Status, r

final class o
    implements com.google.android.gms.common.api.c
{
    final class a extends Handler
    {

        final o a;

        public final void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                (new StringBuilder("Unknown message id: ")).append(message.what);
                return;

            case 1: // '\001'
                o.d(a);
                return;

            case 2: // '\002'
                o.c(a);
                return;

            case 3: // '\003'
                ((b)message.obj).a(a);
                return;

            case 4: // '\004'
                throw (RuntimeException)message.obj;
            }
        }

        a(Looper looper)
        {
            a = o.this;
            super(looper);
        }
    }

    static abstract class b
    {

        private final p a;

        protected abstract void a();

        public final void a(o o1)
        {
            o.a(o1).lock();
            p p1;
            p p2;
            p1 = com.google.android.gms.common.api.o.b(o1);
            p2 = a;
            if (p1 != p2)
            {
                o.a(o1).unlock();
                return;
            }
            a();
            o.a(o1).unlock();
            return;
            Exception exception;
            exception;
            o.a(o1).unlock();
            throw exception;
        }

        protected b(p p1)
        {
            a = p1;
        }
    }

    private static final class c extends BroadcastReceiver
    {

        private WeakReference a;

        public final void onReceive(Context context, Intent intent)
        {
            intent = intent.getData();
            context = null;
            if (intent != null)
            {
                context = intent.getSchemeSpecificPart();
            }
            if (context != null && context.equals("com.google.android.gms"))
            {
                if ((context = (o)a.get()) != null)
                {
                    o.c(context);
                    return;
                }
            }
        }

        c(o o1)
        {
            a = new WeakReference(o1);
        }
    }

    static interface d
    {

        public abstract void a(e e1);
    }

    static interface e
    {

        public abstract void a(d d1);

        public abstract void b();

        public abstract void b(Status status);

        public abstract void b(a.b b1);

        public abstract void c(Status status);

        public abstract a.c d();
    }


    private final com.google.android.gms.common.internal.m.a A = new com.google.android.gms.common.internal.m.a() {

        final o a;

        public final boolean e()
        {
            return a.s instanceof l;
        }

            
            {
                a = o.this;
                super();
            }
    };
    final Lock a = new ReentrantLock();
    final Condition b;
    final m c;
    final Context d;
    final Looper e;
    final Queue f = new LinkedList();
    volatile boolean g;
    long h;
    long i;
    final a j;
    final com.google.android.gms.common.b k;
    BroadcastReceiver l;
    final Map m = new HashMap();
    final Map n = new HashMap();
    Set o;
    final h p;
    final Map q = new HashMap();
    final a.a r;
    volatile p s;
    final Set t = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75F, 2));
    private final int u;
    private final int v;
    private ConnectionResult w;
    private final Set x = Collections.newSetFromMap(new WeakHashMap());
    private final d y = new d() {

        final o a;

        public final void a(e e1)
        {
            a.t.remove(e1);
        }

            
            {
                a = o.this;
                super();
            }
    };
    private final c.b z = new c.b() {

        final o a;

        public final void a(int k1)
        {
            o.a(a).lock();
            com.google.android.gms.common.api.o.b(a).a(k1);
            o.a(a).unlock();
            return;
            Exception exception;
            exception;
            o.a(a).unlock();
            throw exception;
        }

        public final void a(Bundle bundle)
        {
            o.a(a).lock();
            com.google.android.gms.common.api.o.b(a).a(bundle);
            o.a(a).unlock();
            return;
            bundle;
            o.a(a).unlock();
            throw bundle;
        }

            
            {
                a = o.this;
                super();
            }
    };

    public o(Context context, Looper looper, h h1, com.google.android.gms.common.b b1, a.a a1, Map map, ArrayList arraylist, 
            ArrayList arraylist1, int i1, int j1)
    {
        h = 0x1d4c0L;
        i = 5000L;
        o = new HashSet();
        w = null;
        d = context;
        c = new m(looper, A);
        e = looper;
        j = new a(looper);
        k = b1;
        u = i1;
        v = j1;
        b = a.newCondition();
        s = new n(this);
        for (b1 = arraylist.iterator(); b1.hasNext(); c.a(arraylist))
        {
            arraylist = (c.b)b1.next();
        }

        for (b1 = arraylist1.iterator(); b1.hasNext(); c.a(arraylist))
        {
            arraylist = (c.c)b1.next();
        }

        arraylist = h1.d;
        arraylist1 = map.keySet().iterator();
        while (arraylist1.hasNext()) 
        {
            com.google.android.gms.common.api.a a2 = (com.google.android.gms.common.api.a)arraylist1.next();
            b1 = ((com.google.android.gms.common.b) (map.get(a2)));
            if (arraylist.get(a2) != null)
            {
                if (((com.google.android.gms.common.internal.h.a)arraylist.get(a2)).b)
                {
                    i1 = 1;
                } else
                {
                    i1 = 2;
                }
            } else
            {
                i1 = 0;
            }
            q.put(a2, Integer.valueOf(i1));
            if (a2.b != null)
            {
                j1 = 1;
            } else
            {
                j1 = 0;
            }
            if (j1 != 0)
            {
                c.b b2;
                c.c c1;
                boolean flag;
                if (a2.a != null)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                com.google.android.gms.common.internal.w.a(flag, "This API was constructed with a ClientBuilder. Use getClientBuilder");
                b1 = a2.a;
                b2 = z;
                c1 = a(a2, i1);
                b1 = new com.google.android.gms.common.internal.b(context, looper, b1.b(), b2, c1, h1, b1.a());
            } else
            {
                b1 = a2.a().a(context, looper, h1, b1, z, a(a2, i1));
            }
            m.put(a2.b(), b1);
        }
        p = h1;
        r = a1;
    }

    private final c.c a(com.google.android.gms.common.api.a a1, int i1)
    {
        return new c.c(a1, i1) {

            final com.google.android.gms.common.api.a a;
            final int b;
            final o c;

            public final void a(ConnectionResult connectionresult)
            {
                o.a(c).lock();
                com.google.android.gms.common.api.o.b(c).a(connectionresult, a, b);
                o.a(c).unlock();
                return;
                connectionresult;
                o.a(c).unlock();
                throw connectionresult;
            }

            
            {
                c = o.this;
                a = a1;
                b = i1;
                super();
            }
        };
    }

    static Lock a(o o1)
    {
        return o1.a;
    }

    static p b(o o1)
    {
        return o1.s;
    }

    static void c(o o1)
    {
        o1.a.lock();
        if (o1.g)
        {
            o1.b();
        }
        o1.a.unlock();
        return;
        Exception exception;
        exception;
        o1.a.unlock();
        throw exception;
    }

    static void d(o o1)
    {
        o1.a.lock();
        if (o1.g())
        {
            o1.b();
        }
        o1.a.unlock();
        return;
        Exception exception;
        exception;
        o1.a.unlock();
        throw exception;
    }

    public final Looper a()
    {
        return e;
    }

    public final ConnectionResult a(TimeUnit timeunit)
    {
        long l1;
        long l2;
        boolean flag;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.android.gms.common.internal.w.a(flag, "blockingConnect must not be called on the UI thread");
        a.lock();
        b();
        l1 = timeunit.toNanos(250L);
_L2:
        flag = s instanceof com.google.android.gms.common.api.m;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_134;
        }
        l2 = b.awaitNanos(l1);
        l1 = l2;
        if (l2 > 0L) goto _L2; else goto _L1
_L1:
        timeunit = new ConnectionResult(14, null);
        a.unlock();
        return timeunit;
        timeunit;
        Thread.currentThread().interrupt();
        timeunit = new ConnectionResult(15, null);
        a.unlock();
        return timeunit;
        if (!(s instanceof l))
        {
            break MISSING_BLOCK_LABEL_159;
        }
        timeunit = ConnectionResult.a;
        a.unlock();
        return timeunit;
        if (w == null)
        {
            break MISSING_BLOCK_LABEL_182;
        }
        timeunit = w;
        a.unlock();
        return timeunit;
        timeunit = new ConnectionResult(13, null);
        a.unlock();
        return timeunit;
        timeunit;
        a.unlock();
        throw timeunit;
    }

    public final a.b a(a.c c1)
    {
        c1 = (a.b)m.get(c1);
        com.google.android.gms.common.internal.w.a(c1, "Appropriate Api was not requested.");
        return c1;
    }

    public final k.a a(k.a a1)
    {
        boolean flag;
        if (a1.b != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.android.gms.common.internal.w.b(flag, "This task can not be enqueued (it's probably a Batch or malformed)");
        com.google.android.gms.common.internal.w.b(m.containsKey(a1.b), "GoogleApiClient is not configured to use the API required for this call.");
        a.lock();
        a1 = s.a(a1);
        a.unlock();
        return a1;
        a1;
        a.unlock();
        throw a1;
    }

    final void a(ConnectionResult connectionresult)
    {
        a.lock();
        w = connectionresult;
        s = new n(this);
        s.a();
        b.signalAll();
        a.unlock();
        return;
        connectionresult;
        a.unlock();
        throw connectionresult;
    }

    public final void a(c.b b1)
    {
        c.a(b1);
    }

    public final void a(c.c c1)
    {
        c.a(c1);
    }

    final void a(b b1)
    {
        b1 = j.obtainMessage(3, b1);
        j.sendMessage(b1);
    }

    final void a(e e1)
    {
        t.add(e1);
        e1.a(y);
    }

    public final void a(String s1, PrintWriter printwriter)
    {
        printwriter.append(s1).append("mState=").append(s.d());
        printwriter.append(" mResuming=").print(g);
        printwriter.append(" mWorkQueue.size()=").print(f.size());
        printwriter.append(" mUnconsumedRunners.size()=").println(t.size());
        String s2 = (new StringBuilder()).append(s1).append("  ").toString();
        com.google.android.gms.common.api.a a1;
        for (Iterator iterator = q.keySet().iterator(); iterator.hasNext(); ((a.b)m.get(a1.b())).a(s2, printwriter))
        {
            a1 = (com.google.android.gms.common.api.a)iterator.next();
            printwriter.append(s1).append(a1.c).println(":");
        }

    }

    public final boolean a(com.google.android.gms.common.api.a a1)
    {
        return m.containsKey(a1.b());
    }

    public final k.a b(k.a a1)
    {
        e e1;
        boolean flag;
        if (a1.b != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.android.gms.common.internal.w.b(flag, "This task can not be executed (it's probably a Batch or malformed)");
        a.lock();
        if (!g)
        {
            break MISSING_BLOCK_LABEL_113;
        }
        f.add(a1);
        for (; !f.isEmpty(); e1.c(Status.c))
        {
            e1 = (e)f.remove();
            a(e1);
        }

        break MISSING_BLOCK_LABEL_102;
        a1;
        a.unlock();
        throw a1;
        a.unlock();
        return a1;
        a1 = s.b(a1);
        a.unlock();
        return a1;
    }

    public final void b()
    {
        a.lock();
        s.c();
        a.unlock();
        return;
        Exception exception;
        exception;
        a.unlock();
        throw exception;
    }

    public final void b(c.b b1)
    {
        m m1;
        m1 = c;
        com.google.android.gms.common.internal.w.a(b1);
        Object obj = m1.i;
        obj;
        JVM INSTR monitorenter ;
        if (m1.b.remove(b1)) goto _L2; else goto _L1
_L1:
        (new StringBuilder("unregisterConnectionCallbacks(): listener ")).append(b1).append(" not found");
_L4:
        return;
_L2:
        if (m1.g)
        {
            m1.c.add(b1);
        }
        if (true) goto _L4; else goto _L3
_L3:
        b1;
        obj;
        JVM INSTR monitorexit ;
        throw b1;
    }

    public final void b(c.c c1)
    {
        m m1 = c;
        com.google.android.gms.common.internal.w.a(c1);
        synchronized (m1.i)
        {
            if (!m1.d.remove(c1))
            {
                (new StringBuilder("unregisterConnectionFailedListener(): listener ")).append(c1).append(" not found");
            }
        }
        return;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }

    public final boolean b(com.google.android.gms.common.api.a a1)
    {
        a1 = (a.b)m.get(a1.b());
        if (a1 == null)
        {
            return false;
        } else
        {
            return a1.e();
        }
    }

    public final void c()
    {
        a.lock();
        g();
        s.b();
        a.unlock();
        return;
        Exception exception;
        exception;
        a.unlock();
        throw exception;
    }

    public final boolean d()
    {
        return s instanceof l;
    }

    public final boolean e()
    {
        return s instanceof com.google.android.gms.common.api.m;
    }

    final void f()
    {
        e e1;
        for (Iterator iterator = t.iterator(); iterator.hasNext(); e1.b())
        {
            e1 = (e)iterator.next();
            e1.a(null);
        }

        t.clear();
        for (Iterator iterator1 = x.iterator(); iterator1.hasNext();)
        {
            ((r)iterator1.next()).a = null;
        }

        x.clear();
    }

    final boolean g()
    {
        if (!g)
        {
            return false;
        }
        g = false;
        j.removeMessages(2);
        j.removeMessages(1);
        if (l != null)
        {
            d.getApplicationContext().unregisterReceiver(l);
            l = null;
        }
        return true;
    }
}
