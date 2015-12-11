// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ClientSettings;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
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

final class awq
    implements awi
{

    final int a;
    final Lock b = new ReentrantLock();
    avq c;
    int d;
    volatile int e;
    volatile int f;
    long g;
    final Handler h;
    final Bundle i = new Bundle();
    boolean j;
    final Set k = Collections.newSetFromMap(new ConcurrentHashMap());
    private final Condition l;
    private final axp m;
    private final Looper n;
    private Queue o;
    private boolean p;
    private int q;
    private final Map r = new HashMap();
    private final Set s = Collections.newSetFromMap(new WeakHashMap());
    private final awv t = new awr(this);
    private final awk u = new aws(this);
    private final axr v = new awt(this);

    public awq(Context context, Looper looper, ClientSettings clientsettings, Map map, Set set, Set set1, int i1, 
            int j1)
    {
        l = b.newCondition();
        o = new LinkedList();
        e = 4;
        p = false;
        g = 5000L;
        m = new axp(looper, v);
        n = looper;
        h = new aww(this, looper);
        a = j1;
        awk awk1;
        for (set = set.iterator(); set.hasNext(); m.a(awk1))
        {
            awk1 = (awk)set.next();
        }

        for (set = set1.iterator(); set.hasNext(); m.a(set1))
        {
            set1 = (avt)set.next();
        }

        awc awc1;
        Object obj;
        for (set = map.keySet().iterator(); set.hasNext(); r.put(((awa) (set1)).b, awc1.a(context, looper, clientsettings, obj, u, new awu(this, awc1))))
        {
            set1 = (awa)set.next();
            awc1 = ((awa) (set1)).a;
            obj = map.get(set1);
        }

        Collections.unmodifiableList(clientsettings.a.a());
    }

    static void a(awq awq1)
    {
label0:
        {
            awq1.q = awq1.q - 1;
            if (awq1.q == 0)
            {
                if (awq1.c == null)
                {
                    break label0;
                }
                awq1.p = false;
                awq1.a(3);
                if (awq1.e())
                {
                    awq1.h.sendMessageDelayed(awq1.h.obtainMessage(1), awq1.g);
                } else
                {
                    awq1.m.a(awq1.c);
                }
                awq1.j = false;
            }
            return;
        }
        awq1.e = 2;
        awq1.g();
        awq1.l.signalAll();
        awq1.f();
        if (awq1.p)
        {
            awq1.p = false;
            awq1.a(-1);
            return;
        }
        Bundle bundle;
        if (awq1.i.isEmpty())
        {
            bundle = null;
        } else
        {
            bundle = awq1.i;
        }
        awq1.m.a(bundle);
    }

    private void a(awx awx1)
    {
        b.lock();
        boolean flag;
        if (awx1.c() != null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.b(flag, "This task can not be executed or enqueued (it's probably a Batch or malformed)");
        k.add(awx1);
        awx1.a(t);
        if (!e())
        {
            break MISSING_BLOCK_LABEL_85;
        }
        awx1.c(new Status(8));
        b.unlock();
        return;
        awx1.b(a(awx1.c()));
        b.unlock();
        return;
        awx1;
        b.unlock();
        throw awx1;
    }

    private void f()
    {
        b.lock();
        Object obj;
        boolean flag;
        if (!c() && !e())
        {
            flag = false;
        } else
        {
            flag = true;
        }
        a.a(flag, "GoogleApiClient is not connected yet.");
_L1:
        flag = o.isEmpty();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        a((awx)o.remove());
          goto _L1
        obj;
        Log.w("GoogleApiClientImpl", "Service died while flushing queue", ((Throwable) (obj)));
          goto _L1
        obj;
        b.unlock();
        throw obj;
        b.unlock();
        return;
    }

    private void g()
    {
        b.lock();
        f = 0;
        h.removeMessages(1);
        b.unlock();
        return;
        Exception exception;
        exception;
        b.unlock();
        throw exception;
    }

    public final awb a(awd awd)
    {
        awd = (awb)r.get(awd);
        a.f(awd, "Appropriate Api was not requested.");
        return awd;
    }

    public final awg a(awg awg)
    {
        b.lock();
        awg.b = new awf(n);
        if (!c()) goto _L2; else goto _L1
_L1:
        b(awg);
_L4:
        b.unlock();
        return awg;
_L2:
        o.add(awg);
        if (true) goto _L4; else goto _L3
_L3:
        awg;
        b.unlock();
        throw awg;
    }

    public final void a()
    {
        b.lock();
        boolean flag;
        p = false;
        if (c())
        {
            break MISSING_BLOCK_LABEL_30;
        }
        flag = d();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_40;
        }
        b.unlock();
        return;
        j = true;
        c = null;
        e = 1;
        i.clear();
        q = r.size();
        for (Iterator iterator = r.values().iterator(); iterator.hasNext(); ((awb)iterator.next()).a()) { }
        break MISSING_BLOCK_LABEL_128;
        Exception exception;
        exception;
        b.unlock();
        throw exception;
        b.unlock();
        return;
    }

    void a(int i1)
    {
        b.lock();
        if (e == 3)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        if (i1 != -1)
        {
            break MISSING_BLOCK_LABEL_214;
        }
        if (d())
        {
            for (Iterator iterator = o.iterator(); iterator.hasNext(); iterator.remove())
            {
                ((awx)iterator.next()).a();
            }

            break MISSING_BLOCK_LABEL_92;
        }
        break MISSING_BLOCK_LABEL_83;
        Exception exception;
        exception;
        b.unlock();
        throw exception;
        o.clear();
        for (Iterator iterator1 = k.iterator(); iterator1.hasNext(); ((awx)iterator1.next()).a()) { }
        k.clear();
        for (Iterator iterator2 = s.iterator(); iterator2.hasNext(); ((cm)iterator2.next()).e()) { }
        s.clear();
        if (c != null || o.isEmpty())
        {
            break MISSING_BLOCK_LABEL_214;
        }
        p = true;
        b.unlock();
        return;
        boolean flag;
        boolean flag1;
        flag = d();
        flag1 = c();
        e = 3;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_255;
        }
        if (i1 != -1)
        {
            break MISSING_BLOCK_LABEL_246;
        }
        c = null;
        l.signalAll();
        j = false;
        Iterator iterator3 = r.values().iterator();
        do
        {
            if (!iterator3.hasNext())
            {
                break;
            }
            awb awb1 = (awb)iterator3.next();
            if (awb1.c())
            {
                awb1.b();
            }
        } while (true);
        j = true;
        e = 4;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_345;
        }
        if (i1 == -1)
        {
            break MISSING_BLOCK_LABEL_340;
        }
        m.a(i1);
        j = false;
        b.unlock();
        return;
    }

    public final void a(avt avt1)
    {
        m.a(avt1);
    }

    public final void a(awk awk1)
    {
        m.a(awk1);
    }

    public final awg b(awg awg)
    {
        boolean flag;
        if (c() || e())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a.a(flag, "GoogleApiClient is not connected yet.");
        f();
        try
        {
            a(awg);
        }
        catch (DeadObjectException deadobjectexception)
        {
            a(1);
            return awg;
        }
        return awg;
    }

    public final void b()
    {
        g();
        a(-1);
    }

    public final void b(avt avt1)
    {
        axp axp1 = m;
        a.d(avt1);
        synchronized (axp1.e)
        {
            ArrayList arraylist1 = axp1.e;
            if (!axp1.e.remove(avt1))
            {
                Log.w("GmsClientEvents", (new StringBuilder("unregisterConnectionFailedListener(): listener ")).append(avt1).append(" not found").toString());
            }
        }
        return;
        avt1;
        arraylist;
        JVM INSTR monitorexit ;
        throw avt1;
    }

    public final void b(awk awk1)
    {
        axp axp1;
        axp1 = m;
        a.d(awk1);
        ArrayList arraylist = axp1.b;
        arraylist;
        JVM INSTR monitorenter ;
        ArrayList arraylist1 = axp1.b;
        if (axp1.b.remove(awk1)) goto _L2; else goto _L1
_L1:
        Log.w("GmsClientEvents", (new StringBuilder("unregisterConnectionCallbacks(): listener ")).append(awk1).append(" not found").toString());
_L4:
        return;
_L2:
        if (axp1.d)
        {
            axp1.c.add(awk1);
        }
        if (true) goto _L4; else goto _L3
_L3:
        awk1;
        arraylist;
        JVM INSTR monitorexit ;
        throw awk1;
    }

    public final boolean c()
    {
        return e == 2;
    }

    public final boolean d()
    {
        return e == 1;
    }

    boolean e()
    {
        return f != 0;
    }
}
