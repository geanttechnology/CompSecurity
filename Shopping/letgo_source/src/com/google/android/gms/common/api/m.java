// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.q;
import com.google.android.gms.common.internal.x;
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
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.google.android.gms.common.api:
//            p, a, o, q

public class m
    implements p
{
    private static class a extends com.google.android.gms.signin.internal.b
    {

        private final WeakReference a;

        public void a(ConnectionResult connectionresult, AuthAccountResult authaccountresult)
        {
            authaccountresult = (m)a.get();
            if (authaccountresult == null)
            {
                return;
            } else
            {
                com.google.android.gms.common.api.m.d(authaccountresult).a(new o.b(this, authaccountresult, authaccountresult, connectionresult) {

                    final m a;
                    final ConnectionResult b;
                    final a c;

                    public void a()
                    {
                        m.c(a, b);
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

    private static class b extends com.google.android.gms.common.internal.u.a
    {

        private final WeakReference a;

        public void a(ResolveAccountResponse resolveaccountresponse)
        {
            m m1 = (m)a.get();
            if (m1 == null)
            {
                return;
            } else
            {
                com.google.android.gms.common.api.m.d(m1).a(new o.b(this, m1, m1, resolveaccountresponse) {

                    final m a;
                    final ResolveAccountResponse b;
                    final b c;

                    public void a()
                    {
                        m.a(a, b);
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

    private class c extends i
    {

        final m a;

        public void a()
        {
            m.f(a).a(m.g(a), com.google.android.gms.common.api.m.d(a).f, new a(a));
        }

        private c()
        {
            a = m.this;
            super();
        }

    }

    private static class d
        implements c.e
    {

        private final WeakReference a;
        private final com.google.android.gms.common.api.a b;
        private final int c;

        public void a(ConnectionResult connectionresult)
        {
            m m1;
            boolean flag = false;
            m1 = (m)a.get();
            if (m1 == null)
            {
                return;
            }
            if (Looper.myLooper() == com.google.android.gms.common.api.m.d(m1).a())
            {
                flag = true;
            }
            x.a(flag, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            m.c(m1).lock();
            boolean flag1 = m.a(m1, 0);
            if (!flag1)
            {
                m.c(m1).unlock();
                return;
            }
            if (!connectionresult.b())
            {
                m.a(m1, connectionresult, b, c);
            }
            if (m.k(m1))
            {
                m.l(m1);
            }
            m.c(m1).unlock();
            return;
            connectionresult;
            m.c(m1).unlock();
            throw connectionresult;
        }

        public void b(ConnectionResult connectionresult)
        {
            m m1;
            boolean flag = true;
            m1 = (m)a.get();
            if (m1 == null)
            {
                return;
            }
            if (Looper.myLooper() != com.google.android.gms.common.api.m.d(m1).a())
            {
                flag = false;
            }
            x.a(flag, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
            m.c(m1).lock();
            flag = m.a(m1, 1);
            if (!flag)
            {
                m.c(m1).unlock();
                return;
            }
            if (!connectionresult.b())
            {
                m.a(m1, connectionresult, b, c);
            }
            if (m.k(m1))
            {
                m.m(m1);
            }
            m.c(m1).unlock();
            return;
            connectionresult;
            m.c(m1).unlock();
            throw connectionresult;
        }

        public d(m m1, com.google.android.gms.common.api.a a1, int i1)
        {
            a = new WeakReference(m1);
            b = a1;
            c = i1;
        }
    }

    private class e extends i
    {

        final m a;
        private final Map c;

        public void a()
        {
            int i1 = com.google.android.gms.common.api.m.b(a).a(m.a(a));
            if (i1 != 0)
            {
                ConnectionResult connectionresult = new ConnectionResult(i1, null);
                com.google.android.gms.common.api.m.d(a).a(new o.b(this, a, connectionresult) {

                    final ConnectionResult a;
                    final e b;

                    public void a()
                    {
                        m.a(b.a, a);
                    }

            
            {
                b = e1;
                a = connectionresult;
                super(p1);
            }
                });
            } else
            {
                if (m.e(a))
                {
                    m.f(a).b();
                }
                Iterator iterator = c.keySet().iterator();
                while (iterator.hasNext()) 
                {
                    a.c c1 = (a.c)iterator.next();
                    c1.zza((c.e)c.get(c1));
                }
            }
        }

        public e(Map map)
        {
            a = m.this;
            super();
            c = map;
        }
    }

    private class f extends i
    {

        final m a;
        private final ArrayList c;

        public void a()
        {
            Set set = com.google.android.gms.common.api.m.d(a).f;
            if (set.isEmpty())
            {
                set = com.google.android.gms.common.api.m.h(a);
            }
            for (Iterator iterator = c.iterator(); iterator.hasNext(); ((a.c)iterator.next()).zza(m.g(a), set)) { }
        }

        public f(ArrayList arraylist)
        {
            a = m.this;
            super();
            c = arraylist;
        }
    }

    private class g
        implements c.b, c.c
    {

        final m a;

        public void onConnected(Bundle bundle)
        {
            m.f(a).a(new b(a));
        }

        public void onConnectionFailed(ConnectionResult connectionresult)
        {
            m.c(a).lock();
            if (!com.google.android.gms.common.api.m.b(a, connectionresult)) goto _L2; else goto _L1
_L1:
            m.i(a);
            m.j(a);
_L4:
            m.c(a).unlock();
            return;
_L2:
            m.a(a, connectionresult);
            if (true) goto _L4; else goto _L3
_L3:
            connectionresult;
            m.c(a).unlock();
            throw connectionresult;
        }

        public void onConnectionSuspended(int i1)
        {
        }

        private g()
        {
            a = m.this;
            super();
        }

    }

    private class h extends i
    {

        final m a;
        private final ArrayList c;

        public void a()
        {
            for (Iterator iterator = c.iterator(); iterator.hasNext(); ((a.c)iterator.next()).zza(m.g(a))) { }
        }

        public h(ArrayList arraylist)
        {
            a = m.this;
            super();
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
            m.c(b).lock();
            boolean flag = Thread.interrupted();
            if (flag)
            {
                m.c(b).unlock();
                return;
            }
            a();
            m.c(b).unlock();
            return;
            Object obj;
            obj;
            com.google.android.gms.common.api.m.d(b).a(((RuntimeException) (obj)));
            m.c(b).unlock();
            return;
            obj;
            m.c(b).unlock();
            throw obj;
        }

        private i()
        {
            b = m.this;
            super();
        }

    }


    private final o a;
    private final Lock b;
    private final Context c;
    private final com.google.android.gms.common.b d;
    private ConnectionResult e;
    private int f;
    private int g;
    private boolean h;
    private int i;
    private final Bundle j = new Bundle();
    private final Set k = new HashSet();
    private com.google.android.gms.signin.d l;
    private int m;
    private boolean n;
    private boolean o;
    private q p;
    private boolean q;
    private boolean r;
    private final com.google.android.gms.common.internal.h s;
    private final Map t;
    private final a.b u;
    private ArrayList v;

    public m(o o1, com.google.android.gms.common.internal.h h1, Map map, com.google.android.gms.common.b b1, a.b b2, Lock lock, Context context)
    {
        g = 0;
        h = false;
        v = new ArrayList();
        a = o1;
        s = h1;
        t = map;
        d = b1;
        u = b2;
        b = lock;
        c = context;
    }

    static Context a(m m1)
    {
        return m1.c;
    }

    private void a(ConnectionResult connectionresult)
    {
        if (!b(2))
        {
            return;
        }
        if (connectionresult.b())
        {
            i();
            return;
        }
        if (c(connectionresult))
        {
            k();
            i();
            return;
        } else
        {
            d(connectionresult);
            return;
        }
    }

    static void a(m m1, ConnectionResult connectionresult)
    {
        m1.d(connectionresult);
    }

    static void a(m m1, ConnectionResult connectionresult, com.google.android.gms.common.api.a a1, int i1)
    {
        m1.b(connectionresult, a1, i1);
    }

    static void a(m m1, ResolveAccountResponse resolveaccountresponse)
    {
        m1.a(resolveaccountresponse);
    }

    private void a(ResolveAccountResponse resolveaccountresponse)
    {
        if (!b(0))
        {
            return;
        }
        ConnectionResult connectionresult = resolveaccountresponse.b();
        if (connectionresult.b())
        {
            p = resolveaccountresponse.a();
            o = true;
            q = resolveaccountresponse.c();
            r = resolveaccountresponse.d();
            f();
            return;
        }
        if (c(connectionresult))
        {
            k();
            f();
            return;
        } else
        {
            d(connectionresult);
            return;
        }
    }

    private void a(boolean flag)
    {
        if (l != null)
        {
            if (l.isConnected() && flag)
            {
                l.a();
            }
            l.disconnect();
            p = null;
        }
    }

    private boolean a(int i1, int j1, ConnectionResult connectionresult)
    {
        while (j1 == 1 && !b(connectionresult) || e != null && i1 >= f) 
        {
            return false;
        }
        return true;
    }

    static boolean a(m m1, int i1)
    {
        return m1.b(i1);
    }

    static com.google.android.gms.common.b b(m m1)
    {
        return m1.d;
    }

    private void b(ConnectionResult connectionresult, com.google.android.gms.common.api.a a1, int i1)
    {
        if (i1 != 2)
        {
            int j1 = a1.a().a();
            if (a(j1, i1, connectionresult))
            {
                e = connectionresult;
                f = j1;
            }
        }
        a.e.put(a1.c(), connectionresult);
    }

    private boolean b(int i1)
    {
        if (g != i1)
        {
            Log.wtf("GoogleApiClientConnecting", (new StringBuilder()).append("GoogleApiClient connecting is in step ").append(c(g)).append(" but received callback for step ").append(c(i1)).toString());
            d(new ConnectionResult(8, null));
            return false;
        } else
        {
            return true;
        }
    }

    private boolean b(ConnectionResult connectionresult)
    {
        while (connectionresult.a() || d.a(connectionresult.c()) != null) 
        {
            return true;
        }
        return false;
    }

    static boolean b(m m1, ConnectionResult connectionresult)
    {
        return m1.c(connectionresult);
    }

    private String c(int i1)
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

    static Lock c(m m1)
    {
        return m1.b;
    }

    static void c(m m1, ConnectionResult connectionresult)
    {
        m1.a(connectionresult);
    }

    private boolean c(ConnectionResult connectionresult)
    {
        return m == 2 || m == 1 && !connectionresult.a();
    }

    static o d(m m1)
    {
        return m1.a;
    }

    private void d(ConnectionResult connectionresult)
    {
        boolean flag = false;
        h = false;
        l();
        if (!connectionresult.a())
        {
            flag = true;
        }
        a(flag);
        a.e.clear();
        a.a(connectionresult);
        if (!a.j() || !d.a(c, connectionresult.c()))
        {
            a.l();
            a.a.a(connectionresult);
        }
        a.a.a();
    }

    private boolean e()
    {
        i = i - 1;
        if (i > 0)
        {
            return false;
        }
        if (i < 0)
        {
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.");
            d(new ConnectionResult(8, null));
            return false;
        }
        if (e != null)
        {
            d(e);
            return false;
        } else
        {
            return true;
        }
    }

    static boolean e(m m1)
    {
        return m1.n;
    }

    static com.google.android.gms.signin.d f(m m1)
    {
        return m1.l;
    }

    private void f()
    {
        if (i == 0)
        {
            if (n)
            {
                if (o)
                {
                    g();
                    return;
                }
            } else
            {
                i();
                return;
            }
        }
    }

    static q g(m m1)
    {
        return m1.p;
    }

    private void g()
    {
        ArrayList arraylist = new ArrayList();
        g = 1;
        i = a.d.size();
        Iterator iterator = a.d.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            a.d d1 = (a.d)iterator.next();
            if (a.e.containsKey(d1))
            {
                if (e())
                {
                    h();
                }
            } else
            {
                arraylist.add(a.d.get(d1));
            }
        } while (true);
        if (!arraylist.isEmpty())
        {
            v.add(com.google.android.gms.common.api.q.a().submit(new h(arraylist)));
        }
    }

    static Set h(m m1)
    {
        return m1.m();
    }

    private void h()
    {
        g = 2;
        a.f = m();
        v.add(com.google.android.gms.common.api.q.a().submit(new c()));
    }

    private void i()
    {
        ArrayList arraylist = new ArrayList();
        g = 3;
        i = a.d.size();
        Iterator iterator = a.d.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            a.d d1 = (a.d)iterator.next();
            if (a.e.containsKey(d1))
            {
                if (e())
                {
                    j();
                }
            } else
            {
                arraylist.add(a.d.get(d1));
            }
        } while (true);
        if (!arraylist.isEmpty())
        {
            v.add(com.google.android.gms.common.api.q.a().submit(new f(arraylist)));
        }
    }

    static void i(m m1)
    {
        m1.k();
    }

    private void j()
    {
        a.i();
        com.google.android.gms.common.api.q.a().execute(new Runnable() {

            final m a;

            public void run()
            {
                com.google.android.gms.common.api.m.b(a).b(m.a(a));
            }

            
            {
                a = m.this;
                super();
            }
        });
        if (l != null)
        {
            if (q)
            {
                l.a(p, r);
            }
            a(false);
        }
        a.d d1;
        for (Iterator iterator = a.e.keySet().iterator(); iterator.hasNext(); ((a.c)a.d.get(d1)).disconnect())
        {
            d1 = (a.d)iterator.next();
        }

        if (h)
        {
            h = false;
            b();
            return;
        }
        Bundle bundle;
        if (j.isEmpty())
        {
            bundle = null;
        } else
        {
            bundle = j;
        }
        a.a.a(bundle);
    }

    static void j(m m1)
    {
        m1.i();
    }

    private void k()
    {
        n = false;
        a.f = Collections.emptySet();
        Iterator iterator = k.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            a.d d1 = (a.d)iterator.next();
            if (!a.e.containsKey(d1))
            {
                a.e.put(d1, new ConnectionResult(17, null));
            }
        } while (true);
    }

    static boolean k(m m1)
    {
        return m1.e();
    }

    private void l()
    {
        for (Iterator iterator = v.iterator(); iterator.hasNext(); ((Future)iterator.next()).cancel(true)) { }
        v.clear();
    }

    static void l(m m1)
    {
        m1.f();
    }

    private Set m()
    {
        HashSet hashset = new HashSet(s.d());
        Map map = s.f();
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.google.android.gms.common.api.a a1 = (com.google.android.gms.common.api.a)iterator.next();
            if (!a.e.containsKey(a1.c()))
            {
                hashset.addAll(((com.google.android.gms.common.internal.h.a)map.get(a1)).a);
            }
        } while (true);
        return hashset;
    }

    static void m(m m1)
    {
        m1.h();
    }

    public k.a a(k.a a1)
    {
        a.b.add(a1);
        return a1;
    }

    public void a()
    {
        a.a.b();
        a.e.clear();
        h = false;
        n = false;
        e = null;
        g = 0;
        m = 2;
        o = false;
        q = false;
        HashMap hashmap = new HashMap();
        Iterator iterator = t.keySet().iterator();
        boolean flag = false;
        while (iterator.hasNext()) 
        {
            com.google.android.gms.common.api.a a1 = (com.google.android.gms.common.api.a)iterator.next();
            a.c c1 = (a.c)a.d.get(a1.c());
            int i1 = ((Integer)t.get(a1)).intValue();
            boolean flag1;
            if (a1.a().a() == 1)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if (c1.zzlm())
            {
                n = true;
                if (i1 < m)
                {
                    m = i1;
                }
                if (i1 != 0)
                {
                    k.add(a1.c());
                }
            }
            hashmap.put(c1, new d(this, a1, i1));
            flag = flag1 | flag;
        }
        if (flag)
        {
            n = false;
        }
        if (n)
        {
            s.a(Integer.valueOf(a.m()));
            g g1 = new g();
            l = (com.google.android.gms.signin.d)u.a(c, a.a(), s, s.i(), g1, g1);
        }
        i = a.d.size();
        v.add(com.google.android.gms.common.api.q.a().submit(new e(hashmap)));
    }

    public void a(int i1)
    {
        d(new ConnectionResult(8, null));
    }

    public void a(Bundle bundle)
    {
        if (b(3))
        {
            if (bundle != null)
            {
                j.putAll(bundle);
            }
            if (e())
            {
                j();
                return;
            }
        }
    }

    public void a(ConnectionResult connectionresult, com.google.android.gms.common.api.a a1, int i1)
    {
        if (b(3))
        {
            b(connectionresult, a1, i1);
            if (e())
            {
                j();
                return;
            }
        }
    }

    public k.a b(k.a a1)
    {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public void b()
    {
        Iterator iterator = a.b.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            o.e e1 = (o.e)iterator.next();
            if (e1.f() != 1)
            {
                e1.b();
                iterator.remove();
            }
        } while (true);
        a.f();
        if (e == null && !a.b.isEmpty())
        {
            h = true;
            return;
        } else
        {
            l();
            a(true);
            a.e.clear();
            a.a(null);
            a.a.a();
            return;
        }
    }

    public void c()
    {
        h = false;
    }

    public String d()
    {
        return "CONNECTING";
    }
}
