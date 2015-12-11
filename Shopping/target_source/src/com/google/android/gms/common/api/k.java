// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.b.dw;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.a;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.u;
import com.google.android.gms.signin.internal.AuthAccountResult;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.locks.Lock;

// Referenced classes of package com.google.android.gms.common.api:
//            n, b, m

public class k
    implements n
{
    private static class a extends com.google.android.gms.signin.internal.b
    {

        private final WeakReference a;

        public void a(ConnectionResult connectionresult, AuthAccountResult authaccountresult)
        {
            authaccountresult = (k)a.get();
            if (authaccountresult == null)
            {
                return;
            } else
            {
                k.b(authaccountresult).c.post(new Runnable(this, authaccountresult, connectionresult) {

                    final k a;
                    final ConnectionResult b;
                    final a c;

                    public void run()
                    {
                        k.c(a, b);
                    }

            
            {
                c = a1;
                a = k1;
                b = connectionresult;
                super();
            }
                });
                return;
            }
        }

        a(k k1)
        {
            a = new WeakReference(k1);
        }
    }

    private static class b extends com.google.android.gms.common.internal.s.a
    {

        private final WeakReference a;

        public void a(ResolveAccountResponse resolveaccountresponse)
        {
            k k1 = (k)a.get();
            if (k1 == null)
            {
                return;
            } else
            {
                k.b(k1).c.post(new Runnable(this, k1, resolveaccountresponse) {

                    final k a;
                    final ResolveAccountResponse b;
                    final b c;

                    public void run()
                    {
                        com.google.android.gms.common.api.k.a(a, b);
                    }

            
            {
                c = b1;
                a = k1;
                b = resolveaccountresponse;
                super();
            }
                });
                return;
            }
        }

        b(k k1)
        {
            a = new WeakReference(k1);
        }
    }

    private static class c
        implements d.c
    {

        private final WeakReference a;
        private final com.google.android.gms.common.api.b b;
        private final int c;

        public void a(ConnectionResult connectionresult)
        {
            k k1;
            boolean flag = false;
            k1 = (k)a.get();
            if (k1 == null)
            {
                return;
            }
            if (Looper.myLooper() == k.b(k1).b())
            {
                flag = true;
            }
            u.a(flag, "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            com.google.android.gms.common.api.k.a(k1).lock();
            boolean flag1 = com.google.android.gms.common.api.k.a(k1, 0);
            if (!flag1)
            {
                com.google.android.gms.common.api.k.a(k1).unlock();
                return;
            }
            if (!connectionresult.b())
            {
                com.google.android.gms.common.api.k.a(k1, connectionresult, b, c);
            }
            if (k.f(k1))
            {
                k.g(k1);
            }
            com.google.android.gms.common.api.k.a(k1).unlock();
            return;
            connectionresult;
            com.google.android.gms.common.api.k.a(k1).unlock();
            throw connectionresult;
        }

        public void b(ConnectionResult connectionresult)
        {
            k k1;
            boolean flag = true;
            k1 = (k)a.get();
            if (k1 == null)
            {
                return;
            }
            if (Looper.myLooper() != k.b(k1).b())
            {
                flag = false;
            }
            u.a(flag, "onReportAccountValidation must be called on the GoogleApiClient handler thread");
            com.google.android.gms.common.api.k.a(k1).lock();
            flag = com.google.android.gms.common.api.k.a(k1, 1);
            if (!flag)
            {
                com.google.android.gms.common.api.k.a(k1).unlock();
                return;
            }
            if (!connectionresult.b())
            {
                com.google.android.gms.common.api.k.a(k1, connectionresult, b, c);
            }
            if (k.f(k1))
            {
                com.google.android.gms.common.api.k.h(k1);
            }
            com.google.android.gms.common.api.k.a(k1).unlock();
            return;
            connectionresult;
            com.google.android.gms.common.api.k.a(k1).unlock();
            throw connectionresult;
        }

        public c(k k1, com.google.android.gms.common.api.b b1, int i1)
        {
            a = new WeakReference(k1);
            b = b1;
            c = i1;
        }
    }

    private class d
        implements d.b, d.d
    {

        final k a;

        public void a(int i1)
        {
        }

        public void a(Bundle bundle)
        {
            k.c(a).a(new b(a));
        }

        public void a(ConnectionResult connectionresult)
        {
            com.google.android.gms.common.api.k.a(a).lock();
            if (!k.b(a, connectionresult)) goto _L2; else goto _L1
_L1:
            k.d(a);
            com.google.android.gms.common.api.k.e(a);
_L4:
            com.google.android.gms.common.api.k.a(a).unlock();
            return;
_L2:
            com.google.android.gms.common.api.k.a(a, connectionresult);
            if (true) goto _L4; else goto _L3
_L3:
            connectionresult;
            com.google.android.gms.common.api.k.a(a).unlock();
            throw connectionresult;
        }

        private d()
        {
            a = k.this;
            super();
        }

    }


    private final com.google.android.gms.common.api.m a;
    private final Lock b;
    private final Context c;
    private ConnectionResult d;
    private int e;
    private int f;
    private boolean g;
    private int h;
    private final Bundle i = new Bundle();
    private final Set j = new HashSet();
    private dw k;
    private int l;
    private boolean m;
    private boolean n;
    private com.google.android.gms.common.internal.a o;
    private boolean p;
    private boolean q;
    private final h r;
    private final Map s;
    private final b.d t;

    public k(com.google.android.gms.common.api.m m1, h h1, Map map, b.d d1, Lock lock, Context context)
    {
        f = 0;
        g = false;
        a = m1;
        r = h1;
        s = map;
        t = d1;
        b = lock;
        c = context;
    }

    static Lock a(k k1)
    {
        return k1.b;
    }

    private void a(ConnectionResult connectionresult)
    {
        b.lock();
        boolean flag = c(2);
        if (!flag)
        {
            b.unlock();
            return;
        }
        if (!connectionresult.b()) goto _L2; else goto _L1
_L1:
        h();
_L3:
        b.unlock();
        return;
_L2:
        if (!c(connectionresult))
        {
            break MISSING_BLOCK_LABEL_81;
        }
        j();
        h();
          goto _L3
        connectionresult;
        b.unlock();
        throw connectionresult;
        d(connectionresult);
          goto _L3
    }

    static void a(k k1, ConnectionResult connectionresult)
    {
        k1.d(connectionresult);
    }

    static void a(k k1, ConnectionResult connectionresult, com.google.android.gms.common.api.b b1, int i1)
    {
        k1.b(connectionresult, b1, i1);
    }

    static void a(k k1, ResolveAccountResponse resolveaccountresponse)
    {
        k1.a(resolveaccountresponse);
    }

    private void a(ResolveAccountResponse resolveaccountresponse)
    {
        ConnectionResult connectionresult;
        connectionresult = resolveaccountresponse.b();
        b.lock();
        boolean flag = c(0);
        if (!flag)
        {
            b.unlock();
            return;
        }
        if (!connectionresult.b()) goto _L2; else goto _L1
_L1:
        o = resolveaccountresponse.a();
        n = true;
        p = resolveaccountresponse.c();
        q = resolveaccountresponse.d();
        f();
_L3:
        b.unlock();
        return;
_L2:
        if (!c(connectionresult))
        {
            break MISSING_BLOCK_LABEL_122;
        }
        j();
        if (h == 0)
        {
            h();
        }
          goto _L3
        resolveaccountresponse;
        b.unlock();
        throw resolveaccountresponse;
        d(connectionresult);
          goto _L3
    }

    private void a(boolean flag)
    {
        if (k != null)
        {
            if (k.b())
            {
                if (flag)
                {
                    k.d_();
                }
                k.a();
            }
            o = null;
        }
    }

    private boolean a(int i1, int j1, ConnectionResult connectionresult)
    {
        while (j1 == 1 && !b(connectionresult) || d != null && i1 >= e) 
        {
            return false;
        }
        return true;
    }

    static boolean a(k k1, int i1)
    {
        return k1.c(i1);
    }

    static com.google.android.gms.common.api.m b(k k1)
    {
        return k1.a;
    }

    private void b(ConnectionResult connectionresult, com.google.android.gms.common.api.b b1, int i1)
    {
        if (i1 != 2)
        {
            int j1 = b1.a().a();
            if (a(j1, i1, connectionresult))
            {
                d = connectionresult;
                e = j1;
            }
        }
        a.f.put(b1.d(), connectionresult);
    }

    private static boolean b(ConnectionResult connectionresult)
    {
        while (connectionresult.a() || com.google.android.gms.common.e.a(connectionresult.c()) != null) 
        {
            return true;
        }
        return false;
    }

    static boolean b(k k1, ConnectionResult connectionresult)
    {
        return k1.c(connectionresult);
    }

    static dw c(k k1)
    {
        return k1.k;
    }

    static void c(k k1, ConnectionResult connectionresult)
    {
        k1.a(connectionresult);
    }

    private boolean c(int i1)
    {
        if (f != i1)
        {
            Log.wtf("GoogleApiClientConnecting", (new StringBuilder()).append("GoogleApiClient connecting is in step ").append(d(f)).append(" but received callback for step ").append(d(i1)).toString());
            d(new ConnectionResult(8, null));
            return false;
        } else
        {
            return true;
        }
    }

    private boolean c(ConnectionResult connectionresult)
    {
        return l == 2 || l == 1 && !connectionresult.a();
    }

    private String d(int i1)
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

    private void d(ConnectionResult connectionresult)
    {
        boolean flag = false;
        g = false;
        a.g.clear();
        d = connectionresult;
        if (!connectionresult.a())
        {
            flag = true;
        }
        a(flag);
        a(3);
        if (!a.k() || !com.google.android.gms.common.e.b(c, connectionresult.c()))
        {
            a.m();
            a.a.a(connectionresult);
        }
        a.a.a();
    }

    static void d(k k1)
    {
        k1.j();
    }

    private boolean d()
    {
        h = h - 1;
        if (h > 0)
        {
            return false;
        }
        if (h < 0)
        {
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.");
            d(new ConnectionResult(8, null));
            return false;
        }
        if (d != null)
        {
            d(d);
            return false;
        } else
        {
            return true;
        }
    }

    private void e()
    {
        if (m)
        {
            f();
            return;
        } else
        {
            h();
            return;
        }
    }

    static void e(k k1)
    {
        k1.h();
    }

    private void f()
    {
        if (n && h == 0)
        {
            f = 1;
            h = a.e.size();
            Iterator iterator = a.e.keySet().iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                b.c c1 = (b.c)iterator.next();
                if (a.f.containsKey(c1))
                {
                    if (d())
                    {
                        g();
                    }
                } else
                {
                    ((b.b)a.e.get(c1)).a(o);
                }
            } while (true);
        }
    }

    static boolean f(k k1)
    {
        return k1.d();
    }

    private void g()
    {
        f = 2;
        a.g = k();
        k.a(o, a.g, new a(this));
    }

    static void g(k k1)
    {
        k1.e();
    }

    private void h()
    {
        Set set = a.g;
        if (set.isEmpty())
        {
            set = k();
        }
        f = 3;
        h = a.e.size();
        Iterator iterator = a.e.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            b.c c1 = (b.c)iterator.next();
            if (a.f.containsKey(c1))
            {
                if (d())
                {
                    i();
                }
            } else
            {
                ((b.b)a.e.get(c1)).a(o, set);
            }
        } while (true);
    }

    static void h(k k1)
    {
        k1.g();
    }

    private void i()
    {
        a.j();
        if (k != null)
        {
            if (p)
            {
                k.a(o, q);
            }
            a(false);
        }
        b.c c1;
        for (Iterator iterator = a.f.keySet().iterator(); iterator.hasNext(); ((b.b)a.e.get(c1)).a())
        {
            c1 = (b.c)iterator.next();
        }

        if (g)
        {
            g = false;
            a(-1);
            return;
        }
        Bundle bundle;
        if (i.isEmpty())
        {
            bundle = null;
        } else
        {
            bundle = i;
        }
        a.a.a(bundle);
    }

    private void j()
    {
        m = false;
        a.g.clear();
        Iterator iterator = j.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            b.c c1 = (b.c)iterator.next();
            if (!a.f.containsKey(c1))
            {
                a.f.put(c1, new ConnectionResult(17, null));
            }
        } while (true);
    }

    private Set k()
    {
        HashSet hashset = new HashSet(r.d());
        Map map = r.f();
        Iterator iterator = map.keySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            com.google.android.gms.common.api.b b1 = (com.google.android.gms.common.api.b)iterator.next();
            if (!a.f.containsKey(b1.d()))
            {
                hashset.addAll(((com.google.android.gms.common.internal.h.a)map.get(b1)).a);
            }
        } while (true);
        return hashset;
    }

    public i.a a(i.a a1)
    {
        a.b.add(a1);
        return a1;
    }

    public void a()
    {
        a.a.b();
        a.f.clear();
        g = false;
        m = false;
        d = null;
        f = 0;
        l = 2;
        n = false;
        p = false;
        int i1 = com.google.android.gms.common.e.a(c);
        if (i1 != 0)
        {
            ConnectionResult connectionresult = new ConnectionResult(i1, null);
            a.c.post(new Runnable(connectionresult) {

                final ConnectionResult a;
                final k b;

                public void run()
                {
                    com.google.android.gms.common.api.k.a(b).lock();
                    com.google.android.gms.common.api.k.a(b, a);
                    com.google.android.gms.common.api.k.a(b).unlock();
                    return;
                    Exception exception;
                    exception;
                    com.google.android.gms.common.api.k.a(b).unlock();
                    throw exception;
                }

            
            {
                b = k.this;
                a = connectionresult;
                super();
            }
            });
        } else
        {
            HashMap hashmap = new HashMap();
            Object obj = s.keySet().iterator();
            boolean flag = false;
            while (((Iterator) (obj)).hasNext()) 
            {
                com.google.android.gms.common.api.b b1 = (com.google.android.gms.common.api.b)((Iterator) (obj)).next();
                b.b b3 = (b.b)a.e.get(b1.d());
                int j1 = ((Integer)s.get(b1)).intValue();
                boolean flag1;
                if (b1.a().a() == 1)
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                if (b3.c())
                {
                    m = true;
                    if (j1 < l)
                    {
                        l = j1;
                    }
                    if (j1 != 0)
                    {
                        j.add(b1.d());
                    }
                }
                hashmap.put(b3, new c(this, b1, j1));
                flag = flag1 | flag;
            }
            if (flag)
            {
                m = false;
            }
            if (m)
            {
                r.a(Integer.valueOf(a.n()));
                obj = new d();
                k = (dw)t.a(c, a.b(), r, r.i(), ((d.b) (obj)), ((d.d) (obj)));
                k.g();
            }
            h = a.e.size();
            obj = a.e.values().iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                b.b b2 = (b.b)((Iterator) (obj)).next();
                b2.a((d.c)hashmap.get(b2));
            }
        }
    }

    public void a(int i1)
    {
        if (i1 == -1)
        {
            Iterator iterator = a.b.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                m.e e1 = (m.e)iterator.next();
                if (e1.f() != 1)
                {
                    e1.c();
                    iterator.remove();
                }
            } while (true);
            a.g();
            if (d == null && !a.b.isEmpty())
            {
                g = true;
                return;
            }
            a.f.clear();
            d = null;
            a(true);
        }
        a.a(d);
    }

    public void a(Bundle bundle)
    {
        if (c(3))
        {
            if (bundle != null)
            {
                i.putAll(bundle);
            }
            if (d())
            {
                i();
                return;
            }
        }
    }

    public void a(ConnectionResult connectionresult, com.google.android.gms.common.api.b b1, int i1)
    {
        if (c(3))
        {
            b(connectionresult, b1, i1);
            if (d())
            {
                i();
                return;
            }
        }
    }

    public i.a b(i.a a1)
    {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public void b()
    {
        g = false;
    }

    public void b(int i1)
    {
        d(new ConnectionResult(8, null));
    }

    public String c()
    {
        return "CONNECTING";
    }
}
