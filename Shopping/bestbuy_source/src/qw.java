// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.jg;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

final class qw
    implements qm
{

    final Queue a = new LinkedList();
    final Handler b;
    BroadcastReceiver c;
    final Set d = Collections.newSetFromMap(new ConcurrentHashMap());
    private final Lock e = new ReentrantLock();
    private final Condition f;
    private final ade g;
    private final int h;
    private final Context i;
    private final Looper j;
    private pp k;
    private int l;
    private volatile int m;
    private volatile boolean n;
    private boolean o;
    private int p;
    private long q;
    private long r;
    private final Bundle s = new Bundle();
    private final Map t = new HashMap();
    private final List u;
    private boolean v;
    private final Set w = Collections.newSetFromMap(new WeakHashMap());
    private final qy x = new qy() {

        final qw a;

        public void a(ra ra1)
        {
            a.d.remove(ra1);
        }

            
            {
                a = qw.this;
                super();
            }
    };
    private final qo y = new qo() {

        final qw a;

        public void onConnected(Bundle bundle)
        {
            qw.a(a).lock();
            if (qw.b(a) != 1)
            {
                break MISSING_BLOCK_LABEL_45;
            }
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_38;
            }
            qw.c(a).putAll(bundle);
            qw.d(a);
            qw.a(a).unlock();
            return;
            bundle;
            qw.a(a).unlock();
            throw bundle;
        }

        public void onConnectionSuspended(int j1)
        {
            qw.a(a).lock();
            j1;
            JVM INSTR tableswitch 1 2: default 36
        //                       1 82
        //                       2 49;
               goto _L1 _L2 _L3
_L1:
            qw.a(a).unlock();
            return;
_L3:
            qw.a(a, j1);
            a.b();
              goto _L1
            Exception exception;
            exception;
            qw.a(a).unlock();
            throw exception;
_L2:
            boolean flag = a.f();
            if (flag)
            {
                qw.a(a).unlock();
                return;
            }
            qw.a(a, true);
            a.c = new qx(a);
            IntentFilter intentfilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentfilter.addDataScheme("package");
            qw.e(a).registerReceiver(a.c, intentfilter);
            a.b.sendMessageDelayed(a.b.obtainMessage(1), qw.f(a));
            a.b.sendMessageDelayed(a.b.obtainMessage(2), qw.g(a));
            qw.a(a, j1);
              goto _L1
        }

            
            {
                a = qw.this;
                super();
            }
    };
    private final adg z = new adg() {

        final qw a;

        public boolean c()
        {
            return a.d();
        }

        public Bundle c_()
        {
            return null;
        }

        public boolean d_()
        {
            return qw.h(a);
        }

            
            {
                a = qw.this;
                super();
            }
    };

    public qw(Context context, Looper looper, jg jg1, Map map, Set set, Set set1, int i1)
    {
        f = e.newCondition();
        m = 4;
        o = false;
        q = 0x1d4c0L;
        r = 5000L;
        i = context;
        g = new ade(context, looper, z);
        j = looper;
        b = new qz(this, looper);
        h = i1;
        qo qo1;
        for (set = set.iterator(); set.hasNext(); g.a(qo1))
        {
            qo1 = (qo)set.next();
        }

        for (set = set1.iterator(); set.hasNext(); g.a(set1))
        {
            set1 = (qp)set.next();
        }

        qe qe1;
        Object obj;
        for (set = map.keySet().iterator(); set.hasNext(); t.put(set1.c(), a(qe1, obj, context, looper, jg1, y, new qp(qe1) {

        final qe a;
        final qw b;

        public void onConnectionFailed(pp pp1)
        {
            qw.a(b).lock();
            if (qw.k(b) == null || a.a() < qw.l(b))
            {
                qw.a(b, pp1);
                qw.b(b, a.a());
            }
            qw.d(b);
            qw.a(b).unlock();
            return;
            pp1;
            qw.a(b).unlock();
            throw pp1;
        }

            
            {
                b = qw.this;
                a = qe1;
                super();
            }
    })))
        {
            set1 = (px)set.next();
            qe1 = set1.a();
            obj = map.get(set1);
        }

        u = Collections.unmodifiableList(jg1.b());
    }

    static Lock a(qw qw1)
    {
        return qw1.e;
    }

    static pp a(qw qw1, pp pp1)
    {
        qw1.k = pp1;
        return pp1;
    }

    private static qd a(qe qe1, Object obj, Context context, Looper looper, jg jg1, qo qo1, qp qp1)
    {
        return qe1.a(context, looper, jg1, obj, qo1, qp1);
    }

    private void a(int i1)
    {
        e.lock();
        if (m == 3)
        {
            break MISSING_BLOCK_LABEL_357;
        }
        if (i1 != -1)
        {
            break MISSING_BLOCK_LABEL_226;
        }
        if (e())
        {
            Iterator iterator = a.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                ra ra1 = (ra)iterator.next();
                if (ra1.g() != 1)
                {
                    ra1.c();
                    iterator.remove();
                }
            } while (true);
            break MISSING_BLOCK_LABEL_104;
        }
        break MISSING_BLOCK_LABEL_95;
        Exception exception;
        exception;
        e.unlock();
        throw exception;
        a.clear();
        for (Iterator iterator1 = d.iterator(); iterator1.hasNext(); ((ra)iterator1.next()).c()) { }
        d.clear();
        for (Iterator iterator2 = w.iterator(); iterator2.hasNext(); ((rb)iterator2.next()).a()) { }
        w.clear();
        if (k != null || a.isEmpty())
        {
            break MISSING_BLOCK_LABEL_226;
        }
        o = true;
        e.unlock();
        return;
        boolean flag;
        boolean flag1;
        flag = e();
        flag1 = d();
        m = 3;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_267;
        }
        if (i1 != -1)
        {
            break MISSING_BLOCK_LABEL_258;
        }
        k = null;
        f.signalAll();
        v = false;
        Iterator iterator3 = t.values().iterator();
        do
        {
            if (!iterator3.hasNext())
            {
                break;
            }
            qd qd1 = (qd)iterator3.next();
            if (qd1.c())
            {
                qd1.b();
            }
        } while (true);
        v = true;
        m = 4;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_357;
        }
        if (i1 == -1)
        {
            break MISSING_BLOCK_LABEL_352;
        }
        g.a(i1);
        v = false;
        e.unlock();
        return;
    }

    static void a(qw qw1, int i1)
    {
        qw1.a(i1);
    }

    private void a(ra ra1)
    {
        e.lock();
        boolean flag;
        if (ra1.f() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ady.b(flag, "This task can not be executed or enqueued (it's probably a Batch or malformed)");
        d.add(ra1);
        ra1.a(x);
        if (!f())
        {
            break MISSING_BLOCK_LABEL_85;
        }
        ra1.b(new Status(8));
        e.unlock();
        return;
        ra1.a(a(ra1.f()));
        e.unlock();
        return;
        ra1;
        e.unlock();
        throw ra1;
    }

    static boolean a(qw qw1, boolean flag)
    {
        qw1.n = flag;
        return flag;
    }

    static int b(qw qw1)
    {
        return qw1.m;
    }

    static int b(qw qw1, int i1)
    {
        qw1.l = i1;
        return i1;
    }

    static Bundle c(qw qw1)
    {
        return qw1.s;
    }

    static void d(qw qw1)
    {
        qw1.g();
    }

    static Context e(qw qw1)
    {
        return qw1.i;
    }

    static long f(qw qw1)
    {
        return qw1.q;
    }

    static long g(qw qw1)
    {
        return qw1.r;
    }

    private void g()
    {
label0:
        {
            p = p - 1;
            if (p == 0)
            {
                if (k == null)
                {
                    break label0;
                }
                o = false;
                a(3);
                if (!f() || !pu.c(i, k.c()))
                {
                    j();
                    g.a(k);
                }
                v = false;
            }
            return;
        }
        m = 2;
        j();
        f.signalAll();
        h();
        if (o)
        {
            o = false;
            a(-1);
            return;
        }
        Bundle bundle;
        if (s.isEmpty())
        {
            bundle = null;
        } else
        {
            bundle = s;
        }
        g.a(bundle);
    }

    private void h()
    {
        e.lock();
        Object obj;
        boolean flag;
        if (!d() && !f())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        ady.a(flag, "GoogleApiClient is not connected yet.");
_L1:
        flag = a.isEmpty();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        a((ra)a.remove());
          goto _L1
        obj;
        Log.w("GoogleApiClientImpl", "Service died while flushing queue", ((Throwable) (obj)));
          goto _L1
        obj;
        e.unlock();
        throw obj;
        e.unlock();
        return;
    }

    static boolean h(qw qw1)
    {
        return qw1.v;
    }

    private void i()
    {
        e.lock();
        if (f())
        {
            b();
        }
        e.unlock();
        return;
        Exception exception;
        exception;
        e.unlock();
        throw exception;
    }

    static void i(qw qw1)
    {
        qw1.j();
    }

    private void j()
    {
        e.lock();
        boolean flag = n;
        if (!flag)
        {
            e.unlock();
            return;
        }
        n = false;
        b.removeMessages(2);
        b.removeMessages(1);
        i.unregisterReceiver(c);
        e.unlock();
        return;
        Exception exception;
        exception;
        e.unlock();
        throw exception;
    }

    static void j(qw qw1)
    {
        qw1.i();
    }

    static pp k(qw qw1)
    {
        return qw1.k;
    }

    static int l(qw qw1)
    {
        return qw1.l;
    }

    public Looper a()
    {
        return j;
    }

    public pp a(long l1, TimeUnit timeunit)
    {
        long l2;
        boolean flag;
        if (Looper.myLooper() != Looper.getMainLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ady.a(flag, "blockingConnect must not be called on the UI thread");
        e.lock();
        b();
        l1 = timeunit.toNanos(l1);
_L2:
        flag = e();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_129;
        }
        l2 = f.awaitNanos(l1);
        l1 = l2;
        if (l2 > 0L) goto _L2; else goto _L1
_L1:
        timeunit = new pp(14, null);
        e.unlock();
        return timeunit;
        timeunit;
        Thread.currentThread().interrupt();
        timeunit = new pp(15, null);
        e.unlock();
        return timeunit;
        if (!d())
        {
            break MISSING_BLOCK_LABEL_151;
        }
        timeunit = pp.a;
        e.unlock();
        return timeunit;
        if (k == null)
        {
            break MISSING_BLOCK_LABEL_174;
        }
        timeunit = k;
        e.unlock();
        return timeunit;
        timeunit = new pp(13, null);
        e.unlock();
        return timeunit;
        timeunit;
        e.unlock();
        throw timeunit;
    }

    public qd a(qf qf)
    {
        qf = (qd)t.get(qf);
        ady.a(qf, "Appropriate Api was not requested.");
        return qf;
    }

    public qj a(qj qj)
    {
        e.lock();
        if (!d()) goto _L2; else goto _L1
_L1:
        b(qj);
_L4:
        e.unlock();
        return qj;
_L2:
        a.add(qj);
        if (true) goto _L4; else goto _L3
_L3:
        qj;
        e.unlock();
        throw qj;
    }

    public void a(qo qo1)
    {
        g.a(qo1);
    }

    public void a(qp qp1)
    {
        g.a(qp1);
    }

    public qj b(qj qj)
    {
        boolean flag;
        if (d() || f())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        ady.a(flag, "GoogleApiClient is not connected yet.");
        h();
        try
        {
            a(qj);
        }
        catch (DeadObjectException deadobjectexception)
        {
            a(1);
            return qj;
        }
        return qj;
    }

    public void b()
    {
        e.lock();
        boolean flag;
        o = false;
        if (d())
        {
            break MISSING_BLOCK_LABEL_30;
        }
        flag = e();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        e.unlock();
        return;
        v = true;
        k = null;
        m = 1;
        s.clear();
        p = t.size();
        for (Iterator iterator = t.values().iterator(); iterator.hasNext(); ((qd)iterator.next()).a()) { }
        break MISSING_BLOCK_LABEL_128;
        Exception exception;
        exception;
        e.unlock();
        throw exception;
        e.unlock();
        return;
    }

    public void b(qo qo1)
    {
        g.b(qo1);
    }

    public void b(qp qp1)
    {
        g.b(qp1);
    }

    public void c()
    {
        j();
        a(-1);
    }

    public boolean d()
    {
        return m == 2;
    }

    public boolean e()
    {
        return m == 1;
    }

    boolean f()
    {
        return n;
    }
}
