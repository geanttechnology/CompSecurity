// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.g;
import android.support.v4.app.i;
import android.support.v7.vh;
import android.view.View;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.x;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.api:
//            c, u, o, v, 
//            a

public static final class f
{

    private Account a;
    private final Set b = new HashSet();
    private int c;
    private View d;
    private String e;
    private String f;
    private final Map g = new vh();
    private final Context h;
    private final Map i = new vh();
    private g j;
    private int k;
    private int l;
    private .h m;
    private Looper n;
    private b o;
    private .h p;
    private final ArrayList q = new ArrayList();
    private final ArrayList r = new ArrayList();
    private com.google.android.gms.signin.a.b s;

    static g a(f f1)
    {
        return f1.j;
    }

    static void a(j j1, u u1, c c1)
    {
        j1.a(u1, c1);
    }

    private void a(u u1, c c1)
    {
        u1.a(k, c1, m);
    }

    private c c()
    {
        o o1 = new o(h.getApplicationContext(), n, a(), o, p, i, q, r, k, -1);
        u u1 = u.a(j);
        if (u1 == null)
        {
            (new Handler(h.getMainLooper())).post(new Runnable(o1) {

                final c a;
                final c.a b;

                public void run()
                {
                    if (c.a.a(b).isFinishing() || c.a.a(b).f().d())
                    {
                        return;
                    } else
                    {
                        c.a.a(b, com.google.android.gms.common.api.u.b(c.a.a(b)), a);
                        return;
                    }
                }

            
            {
                b = c.a.this;
                a = c1;
                super();
            }
            });
            return o1;
        } else
        {
            a(u1, o1);
            return o1;
        }
    }

    private c d()
    {
        v v1 = v.a(j);
        c c1 = v1.b(l);
        Object obj = c1;
        if (c1 == null)
        {
            obj = new o(h.getApplicationContext(), n, a(), o, p, i, q, r, -1, l);
        }
        v1.a(l, ((c) (obj)), m);
        return ((c) (obj));
    }

    public m a(g g1, int i1, m m1)
    {
        boolean flag;
        if (i1 >= 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.b(flag, "clientId must be non-negative");
        k = i1;
        j = (g)x.a(g1, "Null activity is not permitted.");
        m = m1;
        return this;
    }

    public m a(a a1)
    {
        i.put(a1, null);
        b.addAll(a1.a().a(null));
        return this;
    }

    public a a(a a1)
    {
        q.add(a1);
        return this;
    }

    public q a(q q1)
    {
        r.add(q1);
        return this;
    }

    public h a()
    {
        return new h(a, b, g, c, d, e, f, s.a());
    }

    public c b()
    {
        boolean flag;
        if (!i.isEmpty())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        x.b(flag, "must call addApi() to add at least one API");
        if (k >= 0)
        {
            return c();
        }
        if (l >= 0)
        {
            return d();
        } else
        {
            return new o(h, n, a(), o, p, i, q, r, -1, -1);
        }
    }

    public _cls1.a(Context context)
    {
        k = -1;
        l = -1;
        o = com.google.android.gms.common.b.a();
        p = com.google.android.gms.signin.b.c;
        s = new com.google.android.gms.signin.<init>();
        h = context;
        n = context.getMainLooper();
        e = context.getPackageName();
        f = context.getClass().getName();
    }
}
