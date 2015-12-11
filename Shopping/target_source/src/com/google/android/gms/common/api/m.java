// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.common.internal.x;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.ref.WeakReference;
import java.util.Collection;
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
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Referenced classes of package com.google.android.gms.common.api:
//            d, l, b, n, 
//            Status, j, k, o

final class m
    implements com.google.android.gms.common.api.d
{
    final class a extends Handler
    {

        final m a;

        public void handleMessage(Message message)
        {
            switch (message.what)
            {
            default:
                Log.w("GoogleApiClientImpl", (new StringBuilder()).append("Unknown message id: ").append(message.what).toString());
                return;

            case 1: // '\001'
                m.d(a);
                return;

            case 2: // '\002'
                m.c(a);
                break;
            }
        }

        a(Looper looper)
        {
            a = m.this;
            super(looper);
        }
    }

    private static class b extends BroadcastReceiver
    {

        private WeakReference a;

        public void onReceive(Context context, Intent intent)
        {
            intent = intent.getData();
            context = null;
            if (intent != null)
            {
                context = intent.getSchemeSpecificPart();
            }
            if (context != null && context.equals("com.google.android.gms"))
            {
                if ((context = (m)a.get()) != null)
                {
                    m.c(context);
                    return;
                }
            }
        }

        b(m m1)
        {
            a = new WeakReference(m1);
        }
    }

    static interface c
    {

        public abstract void a(e e1);
    }

    public abstract class d
        implements d.b
    {

        final m b;

        public void a(int i1)
        {
            m.b(b).lock();
            m.a(b).b(i1);
            m.b(b).unlock();
            return;
            Exception exception;
            exception;
            m.b(b).unlock();
            throw exception;
        }

        public d()
        {
            b = m.this;
            super();
        }
    }

    static interface e
    {

        public abstract void a(Status status);

        public abstract void a(b.b b1)
            throws DeadObjectException;

        public abstract void a(c c1);

        public abstract void c();

        public abstract void c(Status status);

        public abstract b.c e();

        public abstract int f();
    }


    final com.google.android.gms.common.internal.m a;
    final Queue b = new LinkedList();
    final a c;
    BroadcastReceiver d;
    final Map e = new HashMap();
    final Map f = new HashMap();
    Set g;
    final h h;
    final Map i = new HashMap();
    final b.d j;
    final Set k = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75F, 2));
    private final Lock l = new ReentrantLock();
    private final Condition m;
    private final int n;
    private final int o;
    private final Context p;
    private final Looper q;
    private volatile boolean r;
    private long s;
    private long t;
    private volatile n u;
    private ConnectionResult v;
    private final Set w = Collections.newSetFromMap(new WeakHashMap());
    private final c x = new c() {

        final m a;

        public void a(e e1)
        {
            a.k.remove(e1);
        }

            
            {
                a = m.this;
                super();
            }
    };
    private final d.b y = new d() {

        final m a;

        public void a(Bundle bundle)
        {
            m.a(a).a(bundle);
        }

            
            {
                a = m.this;
                super();
            }
    };
    private final com.google.android.gms.common.internal.a z = new com.google.android.gms.common.internal.a() {

        final m a;

        public boolean b()
        {
            return a.e();
        }

        public Bundle c_()
        {
            return null;
        }

            
            {
                a = m.this;
                super();
            }
    };

    public m(Context context, Looper looper, h h1, b.d d1, Map map, Set set, Set set1, 
            int i1, int j1)
    {
        s = 0x1d4c0L;
        t = 5000L;
        g = new HashSet();
        v = null;
        p = context;
        a = new com.google.android.gms.common.internal.m(looper, z);
        q = looper;
        c = new a(looper);
        n = i1;
        o = j1;
        m = l.newCondition();
        u = new l(this);
        d.b b1;
        for (set = set.iterator(); set.hasNext(); a.a(b1))
        {
            b1 = (d.b)set.next();
        }

        for (set = set1.iterator(); set.hasNext(); a.a(set1))
        {
            set1 = (d.d)set.next();
        }

        set1 = h1.f();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) 
        {
            com.google.android.gms.common.api.b b2 = (com.google.android.gms.common.api.b)iterator.next();
            set = ((Set) (map.get(b2)));
            if (set1.get(b2) != null)
            {
                if (((com.google.android.gms.common.internal.h.a)set1.get(b2)).b)
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
            i.put(b2, Integer.valueOf(i1));
            if (b2.e())
            {
                set = a(b2.b(), set, context, looper, h1, y, a(b2, i1));
            } else
            {
                set = a(b2.a(), set, context, looper, h1, y, a(b2, i1));
            }
            e.put(b2.d(), set);
        }
        h = h1;
        j = d1;
    }

    private static b.b a(b.d d1, Object obj, Context context, Looper looper, h h1, d.b b1, d.d d2)
    {
        return d1.a(context, looper, h1, obj, b1, d2);
    }

    private final d.d a(com.google.android.gms.common.api.b b1, int i1)
    {
        return new d.d(b1, i1) {

            final com.google.android.gms.common.api.b a;
            final int b;
            final m c;

            public void a(ConnectionResult connectionresult)
            {
                m.a(c).a(connectionresult, a, b);
            }

            
            {
                c = m.this;
                a = b1;
                b = i1;
                super();
            }
        };
    }

    static n a(m m1)
    {
        return m1.u;
    }

    private static x a(b.f f1, Object obj, Context context, Looper looper, h h1, d.b b1, d.d d1)
    {
        return new x(context, looper, f1.a(), b1, d1, h1, f1.a(obj));
    }

    private void a(int i1)
    {
        l.lock();
        u.a(i1);
        l.unlock();
        return;
        Exception exception;
        exception;
        l.unlock();
        throw exception;
    }

    static Lock b(m m1)
    {
        return m1.l;
    }

    static void c(m m1)
    {
        m1.o();
    }

    static void d(m m1)
    {
        m1.p();
    }

    private void o()
    {
        l.lock();
        if (k())
        {
            c();
        }
        l.unlock();
        return;
        Exception exception;
        exception;
        l.unlock();
        throw exception;
    }

    private void p()
    {
        l.lock();
        if (m())
        {
            c();
        }
        l.unlock();
        return;
        Exception exception;
        exception;
        l.unlock();
        throw exception;
    }

    public Context a()
    {
        return p;
    }

    public b.b a(b.c c1)
    {
        c1 = (b.b)e.get(c1);
        com.google.android.gms.common.internal.u.a(c1, "Appropriate Api was not requested.");
        return c1;
    }

    public i.a a(i.a a1)
    {
        boolean flag;
        if (a1.e() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.android.gms.common.internal.u.b(flag, "This task can not be enqueued (it's probably a Batch or malformed)");
        com.google.android.gms.common.internal.u.b(e.containsKey(a1.e()), "GoogleApiClient is not configured to use the API required for this call.");
        l.lock();
        a1 = u.a(a1);
        l.unlock();
        return a1;
        a1;
        l.unlock();
        throw a1;
    }

    void a(ConnectionResult connectionresult)
    {
        l.lock();
        v = connectionresult;
        u = new l(this);
        u.a();
        m.signalAll();
        l.unlock();
        return;
        connectionresult;
        l.unlock();
        throw connectionresult;
    }

    public void a(d.b b1)
    {
        a.a(b1);
    }

    public void a(d.d d1)
    {
        a.a(d1);
    }

    void a(e e1)
    {
        k.add(e1);
        e1.a(x);
    }

    public void a(String s1, FileDescriptor filedescriptor, PrintWriter printwriter, String as[])
    {
        printwriter.append(s1).append("mState=").append(u.c());
        printwriter.append(" mResuming=").print(r);
        printwriter.append(" mWorkQueue.size()=").print(b.size());
        printwriter.append(" mUnconsumedRunners.size()=").println(k.size());
        String s2 = (new StringBuilder()).append(s1).append("  ").toString();
        com.google.android.gms.common.api.b b1;
        for (Iterator iterator = i.keySet().iterator(); iterator.hasNext(); ((b.b)e.get(b1.d())).a(s2, filedescriptor, printwriter, as))
        {
            b1 = (com.google.android.gms.common.api.b)iterator.next();
            printwriter.append(s1).append(b1.f()).println(":");
        }

    }

    public Looper b()
    {
        return q;
    }

    public i.a b(i.a a1)
    {
        e e1;
        boolean flag;
        if (a1.e() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        com.google.android.gms.common.internal.u.b(flag, "This task can not be executed (it's probably a Batch or malformed)");
        l.lock();
        if (!k())
        {
            break MISSING_BLOCK_LABEL_113;
        }
        b.add(a1);
        for (; !b.isEmpty(); e1.c(Status.c))
        {
            e1 = (e)b.remove();
            a(e1);
        }

        break MISSING_BLOCK_LABEL_102;
        a1;
        l.unlock();
        throw a1;
        l.unlock();
        return a1;
        a1 = u.b(a1);
        l.unlock();
        return a1;
    }

    public void b(d.b b1)
    {
        a.b(b1);
    }

    public void b(d.d d1)
    {
        a.b(d1);
    }

    public void c()
    {
        l.lock();
        u.b();
        l.unlock();
        return;
        Exception exception;
        exception;
        l.unlock();
        throw exception;
    }

    public void d()
    {
        m();
        a(-1);
    }

    public boolean e()
    {
        return u instanceof j;
    }

    public boolean f()
    {
        return u instanceof k;
    }

    void g()
    {
        e e1;
        for (Iterator iterator = k.iterator(); iterator.hasNext(); e1.c())
        {
            e1 = (e)iterator.next();
            e1.a(null);
        }

        k.clear();
        for (Iterator iterator1 = w.iterator(); iterator1.hasNext(); ((o)iterator1.next()).a()) { }
        w.clear();
        g.clear();
    }

    void h()
    {
        for (Iterator iterator = e.values().iterator(); iterator.hasNext(); ((b.b)iterator.next()).a()) { }
    }

    void i()
    {
        l.lock();
        u = new k(this, h, i, j, l, p);
        u.a();
        m.signalAll();
        l.unlock();
        return;
        Exception exception;
        exception;
        l.unlock();
        throw exception;
    }

    void j()
    {
        l.lock();
        m();
        u = new j(this);
        u.a();
        m.signalAll();
        l.unlock();
        return;
        Exception exception;
        exception;
        l.unlock();
        throw exception;
    }

    boolean k()
    {
        return r;
    }

    void l()
    {
        if (k())
        {
            return;
        }
        r = true;
        if (d == null)
        {
            d = new b(this);
            IntentFilter intentfilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentfilter.addDataScheme("package");
            p.getApplicationContext().registerReceiver(d, intentfilter);
        }
        c.sendMessageDelayed(c.obtainMessage(1), s);
        c.sendMessageDelayed(c.obtainMessage(2), t);
    }

    boolean m()
    {
        l.lock();
        boolean flag = k();
        if (!flag)
        {
            l.unlock();
            return false;
        }
        r = false;
        c.removeMessages(2);
        c.removeMessages(1);
        if (d != null)
        {
            p.getApplicationContext().unregisterReceiver(d);
            d = null;
        }
        l.unlock();
        return true;
        Exception exception;
        exception;
        l.unlock();
        throw exception;
    }

    public int n()
    {
        return System.identityHashCode(this);
    }
}
