// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.signin.d;
import com.google.android.gms.signin.internal.AuthAccountResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.google.android.gms.common.api:
//            p, o, l, q, 
//            a

public final class m
    implements p
{
    private static final class a extends com.google.android.gms.signin.internal.b
    {

        private final WeakReference a;

        public final void a(ConnectionResult connectionresult, AuthAccountResult authaccountresult)
        {
            authaccountresult = (m)a.get();
            if (authaccountresult == null)
            {
                return;
            } else
            {
                ((m) (authaccountresult)).a.a(new o.b(this, authaccountresult, authaccountresult, connectionresult) {

                    final m a;
                    final ConnectionResult b;
                    final a c;

                    public final void a()
                    {
                        m m1;
                        ConnectionResult connectionresult;
label0:
                        {
                            m1 = a;
                            connectionresult = b;
                            if (m1.b(2))
                            {
                                if (!connectionresult.b())
                                {
                                    break label0;
                                }
                                m1.h();
                            }
                            return;
                        }
                        if (m1.a(connectionresult))
                        {
                            m1.i();
                            m1.h();
                            return;
                        } else
                        {
                            m1.b(connectionresult);
                            return;
                        }
                    }

            
            {
                c = a1;
                a = m1;
                b = connectionresult;
                super(p1);
            }
                });
                return;
            }
        }

        a(m m1)
        {
            a = new WeakReference(m1);
        }
    }

    private static final class b extends com.google.android.gms.common.internal.u.a
    {

        private final WeakReference a;

        public final void a(ResolveAccountResponse resolveaccountresponse)
        {
            m m1 = (m)a.get();
            if (m1 == null)
            {
                return;
            } else
            {
                m1.a.a(new o.b(this, m1, m1, resolveaccountresponse) {

                    final m a;
                    final ResolveAccountResponse b;
                    final b c;

                    public final void a()
                    {
                        m m1;
                        ConnectionResult connectionresult;
label0:
                        {
                            m1 = a;
                            ResolveAccountResponse resolveaccountresponse = b;
                            if (m1.b(0))
                            {
                                connectionresult = resolveaccountresponse.c;
                                if (!connectionresult.b())
                                {
                                    break label0;
                                }
                                m1.g = com.google.android.gms.common.internal.q.a.a(resolveaccountresponse.b);
                                m1.f = true;
                                m1.h = resolveaccountresponse.d;
                                m1.i = resolveaccountresponse.e;
                                m1.f();
                            }
                            return;
                        }
                        if (m1.a(connectionresult))
                        {
                            m1.i();
                            m1.f();
                            return;
                        } else
                        {
                            m1.b(connectionresult);
                            return;
                        }
                    }

            
            {
                c = b1;
                a = m1;
                b = resolveaccountresponse;
                super(p1);
            }
                });
                return;
            }
        }

        b(m m1)
        {
            a = new WeakReference(m1);
        }
    }

    private final class c extends i
    {

        final m a;

        public final void a()
        {
            a.d.a(a.g, a.a.o, new a(a));
        }

        private c()
        {
            a = m.this;
            super((byte)0);
        }

        c(byte byte0)
        {
            this();
        }
    }

    private static final class d
        implements c.e
    {

        private final WeakReference a;
        private final com.google.android.gms.common.api.a b;
        private final int c;

        public final void a(ConnectionResult connectionresult)
        {
            m m1;
            boolean flag = false;
            m1 = (m)a.get();
            if (m1 == null)
            {
                return;
            }
            if (Looper.myLooper() == m1.a.e)
            {
                flag = true;
            }
            w.a(flag, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            m1.b.lock();
            boolean flag1 = m1.b(0);
            if (!flag1)
            {
                m1.b.unlock();
                return;
            }
            if (!connectionresult.b())
            {
                m1.b(connectionresult, b, c);
            }
            if (m1.e())
            {
                m1.f();
            }
            m1.b.unlock();
            return;
            connectionresult;
            m1.b.unlock();
            throw connectionresult;
        }

        public final void b(ConnectionResult connectionresult)
        {
            m m1;
            boolean flag = true;
            m1 = (m)a.get();
            if (m1 == null)
            {
                return;
            }
            if (Looper.myLooper() != m1.a.e)
            {
                flag = false;
            }
            w.a(flag, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
            m1.b.lock();
            flag = m1.b(1);
            if (!flag)
            {
                m1.b.unlock();
                return;
            }
            if (!connectionresult.b())
            {
                m1.b(connectionresult, b, c);
            }
            if (m1.e())
            {
                m1.g();
            }
            m1.b.unlock();
            return;
            connectionresult;
            m1.b.unlock();
            throw connectionresult;
        }

        public d(m m1, com.google.android.gms.common.api.a a1, int i1)
        {
            a = new WeakReference(m1);
            b = a1;
            c = i1;
        }
    }

    private final class e extends i
    {

        final m a;
        private final Map c;

        public final void a()
        {
            int i1 = com.google.android.gms.common.b.a(a.c);
            if (i1 != 0)
            {
                ConnectionResult connectionresult = new ConnectionResult(i1, null);
                a.a.a(new o.b(this, a, connectionresult) {

                    final ConnectionResult a;
                    final e b;

                    public final void a()
                    {
                        b.a.b(a);
                    }

            
            {
                b = e1;
                a = connectionresult;
                super(p1);
            }
                });
            } else
            {
                if (a.e)
                {
                    a.d.p();
                }
                Iterator iterator = c.keySet().iterator();
                while (iterator.hasNext()) 
                {
                    a.b b1 = (a.b)iterator.next();
                    b1.a((c.e)c.get(b1));
                }
            }
        }

        public e(Map map)
        {
            a = m.this;
            super((byte)0);
            c = map;
        }
    }

    private final class f extends i
    {

        final m a;
        private final ArrayList c;

        public final void a()
        {
            Set set = a.a.o;
            if (set.isEmpty())
            {
                set = a.j();
            }
            for (Iterator iterator = c.iterator(); iterator.hasNext(); ((a.b)iterator.next()).a(a.g, set)) { }
        }

        public f(ArrayList arraylist)
        {
            a = m.this;
            super((byte)0);
            c = arraylist;
        }
    }

    private final class g
        implements c.b, c.c
    {

        final m a;

        public final void a(int i1)
        {
        }

        public final void a(Bundle bundle)
        {
            a.d.a(new b(a));
        }

        public final void a(ConnectionResult connectionresult)
        {
            a.b.lock();
            if (!a.a(connectionresult)) goto _L2; else goto _L1
_L1:
            a.i();
            a.h();
_L4:
            a.b.unlock();
            return;
_L2:
            a.b(connectionresult);
            if (true) goto _L4; else goto _L3
_L3:
            connectionresult;
            a.b.unlock();
            throw connectionresult;
        }

        private g()
        {
            a = m.this;
            super();
        }

        g(byte byte0)
        {
            this();
        }
    }

    private final class h extends i
    {

        final m a;
        private final ArrayList c;

        public final void a()
        {
            for (Iterator iterator = c.iterator(); iterator.hasNext(); ((a.b)iterator.next()).a(a.g)) { }
        }

        public h(ArrayList arraylist)
        {
            a = m.this;
            super((byte)0);
            c = arraylist;
        }
    }

    private abstract class i
        implements Runnable
    {

        final m b;

        protected abstract void a();

        public void run()
        {
            b.b.lock();
            boolean flag = Thread.interrupted();
            if (flag)
            {
                b.b.unlock();
                return;
            }
            a();
            b.b.unlock();
            return;
            RuntimeException runtimeexception;
            runtimeexception;
            o o1 = b.a;
            android.os.Message message = o1.j.obtainMessage(4, runtimeexception);
            o1.j.sendMessage(message);
            b.b.unlock();
            return;
            Exception exception;
            exception;
            b.b.unlock();
            throw exception;
        }

        private i()
        {
            b = m.this;
            super();
        }

        i(byte byte0)
        {
            this();
        }
    }


    final o a;
    final Lock b;
    final Context c;
    com.google.android.gms.signin.d d;
    boolean e;
    boolean f;
    q g;
    boolean h;
    boolean i;
    private final com.google.android.gms.common.b j;
    private ConnectionResult k;
    private int l;
    private int m;
    private boolean n;
    private int o;
    private final Bundle p = new Bundle();
    private final Set q = new HashSet();
    private int r;
    private final com.google.android.gms.common.internal.h s;
    private final Map t;
    private final a.a u;
    private ArrayList v;

    public m(o o1, com.google.android.gms.common.internal.h h1, Map map, com.google.android.gms.common.b b1, a.a a1, Lock lock, Context context)
    {
        m = 0;
        n = false;
        v = new ArrayList();
        a = o1;
        s = h1;
        t = map;
        j = b1;
        u = a1;
        b = lock;
        c = context;
    }

    private void a(boolean flag)
    {
        if (d != null)
        {
            if (d.e() && flag)
            {
                d.c();
            }
            d.d();
            g = null;
        }
    }

    private static String c(int i1)
    {
        switch (i1)
        {
        default:
            return "UNKNOWN";

        case 0: // '\0'
            return "STEP_GETTING_SERVICE_BINDINGS";

        case 1: // '\001'
            return "STEP_VALIDATING_ACCOUNT";

        case 2: // '\002'
            return "STEP_AUTHENTICATING";

        case 3: // '\003'
            return "STEP_GETTING_REMOTE_SERVICE";
        }
    }

    private void k()
    {
        Object obj;
        boolean flag1;
        flag1 = true;
        obj = a;
        ((o) (obj)).a.lock();
        ((o) (obj)).g();
        obj.s = new l(((o) (obj)));
        ((o) (obj)).s.a();
        ((o) (obj)).b.signalAll();
        ((o) (obj)).a.unlock();
        com.google.android.gms.common.api.q.a().execute(new Runnable() {

            final m a;

            public final void run()
            {
                com.google.android.gms.common.b.b(a.c);
            }

            
            {
                a = m.this;
                super();
            }
        });
        if (d != null)
        {
            if (h)
            {
                d.a(g, i);
            }
            a(false);
        }
        a.c c1;
        for (obj = a.n.keySet().iterator(); ((Iterator) (obj)).hasNext(); ((a.b)a.m.get(c1)).d())
        {
            c1 = (a.c)((Iterator) (obj)).next();
        }

        break MISSING_BLOCK_LABEL_186;
        Exception exception;
        exception;
        ((o) (obj)).a.unlock();
        throw exception;
        Object obj2;
        com.google.android.gms.common.internal.m m1;
        boolean flag;
        if (n)
        {
            n = false;
            b();
            return;
        }
        Object obj1;
        Object obj3;
        c.b b1;
        int i1;
        if (p.isEmpty())
        {
            obj1 = null;
        } else
        {
            obj1 = p;
        }
        m1 = a.c;
        if (Looper.myLooper() == m1.h.getLooper())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag, "onConnectionSuccess must only be called on the Handler thread");
        obj2 = m1.i;
        obj2;
        JVM INSTR monitorenter ;
        if (!m1.g)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        w.a(flag);
        m1.h.removeMessages(1);
        m1.g = true;
        if (m1.c.size() == 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        w.a(flag);
        obj3 = new ArrayList(m1.b);
        i1 = m1.f.get();
        obj3 = ((ArrayList) (obj3)).iterator();
        do
        {
            if (!((Iterator) (obj3)).hasNext())
            {
                break;
            }
            b1 = (c.b)((Iterator) (obj3)).next();
            if (!m1.e || !m1.a.e() || m1.f.get() != i1)
            {
                break;
            }
            if (!m1.c.contains(b1))
            {
                b1.a(((Bundle) (obj1)));
            }
        } while (true);
        break MISSING_BLOCK_LABEL_436;
        obj1;
        obj2;
        JVM INSTR monitorexit ;
        throw obj1;
        m1.c.clear();
        m1.g = false;
        obj2;
        JVM INSTR monitorexit ;
    }

    private void l()
    {
        for (Iterator iterator = v.iterator(); iterator.hasNext(); ((Future)iterator.next()).cancel(true)) { }
        v.clear();
    }

    public final k.a a(k.a a1)
    {
        a.f.add(a1);
        return a1;
    }

    public final void a()
    {
        a.c.e = true;
        a.n.clear();
        n = false;
        e = false;
        k = null;
        m = 0;
        r = 2;
        f = false;
        h = false;
        HashMap hashmap = new HashMap();
        Iterator iterator = t.keySet().iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            com.google.android.gms.common.api.a a1 = (com.google.android.gms.common.api.a)iterator.next();
            a.b b1 = (a.b)a.m.get(a1.b());
            int i1 = ((Integer)t.get(a1)).intValue();
            boolean flag1;
            if (a1.a().a() == 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (b1.f())
            {
                e = true;
                if (i1 < r)
                {
                    r = i1;
                }
                if (i1 != 0)
                {
                    q.add(a1.b());
                }
            }
            hashmap.put(b1, new d(this, a1, i1));
            flag = flag1 | flag;
        }
        if (flag)
        {
            e = false;
        }
        if (e)
        {
            s.h = Integer.valueOf(System.identityHashCode(a));
            g g1 = new g((byte)0);
            d = (com.google.android.gms.signin.d)u.a(c, a.e, s, s.g, g1, g1);
        }
        o = a.m.size();
        v.add(com.google.android.gms.common.api.q.a().submit(new e(hashmap)));
    }

    public final void a(int i1)
    {
        b(new ConnectionResult(8, null));
    }

    public final void a(Bundle bundle)
    {
        if (b(3))
        {
            if (bundle != null)
            {
                p.putAll(bundle);
            }
            if (e())
            {
                k();
                return;
            }
        }
    }

    public final void a(ConnectionResult connectionresult, com.google.android.gms.common.api.a a1, int i1)
    {
        if (b(3))
        {
            b(connectionresult, a1, i1);
            if (e())
            {
                k();
                return;
            }
        }
    }

    final boolean a(ConnectionResult connectionresult)
    {
        return r == 2 || r == 1 && !connectionresult.a();
    }

    public final k.a b(k.a a1)
    {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void b()
    {
        for (Iterator iterator = a.f.iterator(); iterator.hasNext(); iterator.remove())
        {
            ((o.e)iterator.next()).b();
        }

        a.f();
        if (k == null && !a.f.isEmpty())
        {
            n = true;
            return;
        } else
        {
            l();
            a(true);
            a.n.clear();
            a.a(null);
            a.c.a();
            return;
        }
    }

    final void b(ConnectionResult connectionresult)
    {
        Object obj;
        com.google.android.gms.common.internal.m m1;
        c.c c1;
        boolean flag1 = false;
        n = false;
        l();
        Object obj1;
        int i1;
        boolean flag;
        if (!connectionresult.a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        a(flag);
        a.n.clear();
        a.a(connectionresult);
        if (a.g && com.google.android.gms.common.b.a(c, connectionresult.c)) goto _L2; else goto _L1
_L1:
        a.g();
        m1 = a.c;
        flag = flag1;
        if (Looper.myLooper() == m1.h.getLooper())
        {
            flag = true;
        }
        w.a(flag, "onConnectionFailure must only be called on the Handler thread");
        m1.h.removeMessages(1);
        obj = m1.i;
        obj;
        JVM INSTR monitorenter ;
        obj1 = new ArrayList(m1.d);
        i1 = m1.f.get();
        obj1 = ((ArrayList) (obj1)).iterator();
_L7:
        if (!((Iterator) (obj1)).hasNext()) goto _L4; else goto _L3
_L3:
        c1 = (c.c)((Iterator) (obj1)).next();
        if (m1.e && m1.f.get() == i1) goto _L5; else goto _L2
_L2:
        a.c.a();
        return;
_L5:
        if (!m1.d.contains(c1)) goto _L7; else goto _L6
_L6:
        c1.a(connectionresult);
          goto _L7
        connectionresult;
        obj;
        JVM INSTR monitorexit ;
        throw connectionresult;
_L4:
        obj;
        JVM INSTR monitorexit ;
          goto _L2
    }

    final void b(ConnectionResult connectionresult, com.google.android.gms.common.api.a a1, int i1)
    {
        boolean flag = true;
        if (i1 == 2) goto _L2; else goto _L1
_L1:
        int j1 = a1.a().a();
        if (i1 != 1) goto _L4; else goto _L3
_L3:
        if (connectionresult.a())
        {
            i1 = 1;
        } else
        if (com.google.android.gms.common.b.a(connectionresult.c) != null)
        {
            i1 = 1;
        } else
        {
            i1 = 0;
        }
        if (i1 == 0) goto _L5; else goto _L4
_L4:
        i1 = ((flag) ? 1 : 0);
        if (k == null) goto _L7; else goto _L6
_L6:
        if (j1 >= l) goto _L5; else goto _L8
_L8:
        i1 = ((flag) ? 1 : 0);
_L7:
        if (i1 != 0)
        {
            k = connectionresult;
            l = j1;
        }
_L2:
        a.n.put(a1.b(), connectionresult);
        return;
_L5:
        i1 = 0;
        if (true) goto _L7; else goto _L9
_L9:
    }

    final boolean b(int i1)
    {
        if (m != i1)
        {
            Log.wtf("GoogleApiClientConnecting", (new StringBuilder("GoogleApiClient connecting is in step ")).append(c(m)).append(" but received callback for step ").append(c(i1)).toString());
            b(new ConnectionResult(8, null));
            return false;
        } else
        {
            return true;
        }
    }

    public final void c()
    {
        n = false;
    }

    public final String d()
    {
        return "CONNECTING";
    }

    final boolean e()
    {
        o = o - 1;
        if (o > 0)
        {
            return false;
        }
        if (o < 0)
        {
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.");
            b(new ConnectionResult(8, null));
            return false;
        }
        if (k != null)
        {
            b(k);
            return false;
        } else
        {
            return true;
        }
    }

    final void f()
    {
        if (o == 0)
        {
            if (e)
            {
                if (f)
                {
                    ArrayList arraylist = new ArrayList();
                    m = 1;
                    o = a.m.size();
                    Iterator iterator = a.m.keySet().iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        a.c c1 = (a.c)iterator.next();
                        if (a.n.containsKey(c1))
                        {
                            if (e())
                            {
                                g();
                            }
                        } else
                        {
                            arraylist.add(a.m.get(c1));
                        }
                    } while (true);
                    if (!arraylist.isEmpty())
                    {
                        v.add(com.google.android.gms.common.api.q.a().submit(new h(arraylist)));
                        return;
                    }
                }
            } else
            {
                h();
                return;
            }
        }
    }

    final void g()
    {
        m = 2;
        a.o = j();
        v.add(com.google.android.gms.common.api.q.a().submit(new c((byte)0)));
    }

    final void h()
    {
        ArrayList arraylist = new ArrayList();
        m = 3;
        o = a.m.size();
        Iterator iterator = a.m.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            a.c c1 = (a.c)iterator.next();
            if (a.n.containsKey(c1))
            {
                if (e())
                {
                    k();
                }
            } else
            {
                arraylist.add(a.m.get(c1));
            }
        } while (true);
        if (!arraylist.isEmpty())
        {
            v.add(com.google.android.gms.common.api.q.a().submit(new f(arraylist)));
        }
    }

    final void i()
    {
        e = false;
        a.o = Collections.emptySet();
        Iterator iterator = q.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            a.c c1 = (a.c)iterator.next();
            if (!a.n.containsKey(c1))
            {
                a.n.put(c1, new ConnectionResult(17, null));
            }
        } while (true);
    }

    final Set j()
    {
        HashSet hashset = new HashSet(s.b);
        Map map = s.d;
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.google.android.gms.common.api.a a1 = (com.google.android.gms.common.api.a)iterator.next();
            if (!a.n.containsKey(a1.b()))
            {
                hashset.addAll(((com.google.android.gms.common.internal.h.a)map.get(a1)).a);
            }
        } while (true);
        return hashset;
    }
}
