// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.i;
import android.support.v4.app.k;
import android.support.v4.app.o;
import android.support.v4.app.p;
import android.util.SparseArray;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ia;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.google.android.gms.common.api:
//            a, u, o, v

public interface com.google.android.gms.common.api.c
{
    public static final class a
    {

        public final Set a;
        public final Map b;
        i c;
        private Account d;
        private int e;
        private View f;
        private String g;
        private String h;
        private final Map i;
        private final Context j;
        private int k;
        private int l;
        private c m;
        private Looper n;
        private com.google.android.gms.common.b o;
        private a.a p;
        private final ArrayList q;
        private final ArrayList r;
        private com.google.android.gms.signin.e.a s;

        public final a a(com.google.android.gms.common.api.a a1)
        {
            b.put(a1, null);
            a.addAll(a1.a().b());
            return this;
        }

        public final a a(b b1)
        {
            q.add(b1);
            return this;
        }

        public final a a(c c1)
        {
            r.add(c1);
            return this;
        }

        public final h a()
        {
            return new h(d, a, i, e, f, g, h, s.a());
        }

        final void a(u u1, com.google.android.gms.common.api.c c1)
        {
            int i1 = k;
            Object obj = m;
            w.a(c1, "GoogleApiClient instance cannot be null");
            boolean flag;
            if (u1.c.indexOfKey(i1) < 0)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            w.a(flag, (new StringBuilder("Already managing a GoogleApiClient with id ")).append(i1).toString());
            obj = new u.a(u1, i1, c1, ((c) (obj)));
            u1.c.put(i1, obj);
            if (u1.a && !u1.b)
            {
                c1.b();
            }
        }

        public final com.google.android.gms.common.api.c b()
        {
            Object obj1;
            boolean flag2;
            flag2 = true;
            boolean flag;
            if (!b.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            w.b(flag, "must call addApi() to add at least one API");
            if (k < 0) goto _L2; else goto _L1
_L1:
            obj1 = new com.google.android.gms.common.api.o(j.getApplicationContext(), n, a(), o, p, b, q, r, k, -1);
            u u1 = u.a(c);
            if (u1 == null)
            {
                (new Handler(j.getMainLooper())).post(new Runnable(this, ((com.google.android.gms.common.api.c) (obj1))) {

                    final com.google.android.gms.common.api.c a;
                    final a b;

                    public final void run()
                    {
                        if (b.c.isFinishing() || b.c.getSupportFragmentManager().g())
                        {
                            return;
                        } else
                        {
                            b.a(u.b(b.c), a);
                            return;
                        }
                    }

            
            {
                b = a1;
                a = c1;
                super();
            }
                });
            } else
            {
                a(u1, ((com.google.android.gms.common.api.c) (obj1)));
            }
_L6:
            return ((com.google.android.gms.common.api.c) (obj1));
_L2:
            v v1;
            int i1;
            if (l < 0)
            {
                break MISSING_BLOCK_LABEL_348;
            }
            v1 = v.a(c);
            i1 = l;
            if (v1.getActivity() == null) goto _L4; else goto _L3
_L3:
            v.a a1 = v1.b(i1);
            if (a1 == null) goto _L4; else goto _L5
_L5:
            obj1 = a1.a;
_L7:
            Object obj = obj1;
            if (obj1 == null)
            {
                obj = new com.google.android.gms.common.api.o(j.getApplicationContext(), n, a(), o, p, b, q, r, -1, l);
            }
            int j1 = l;
            obj1 = m;
            w.a(obj, "GoogleApiClient instance cannot be null");
            boolean flag1;
            if (v1.a.indexOfKey(j1) < 0)
            {
                flag1 = flag2;
            } else
            {
                flag1 = false;
            }
            w.a(flag1, (new StringBuilder("Already managing a GoogleApiClient with id ")).append(j1).toString());
            obj1 = new v.b(((com.google.android.gms.common.api.c) (obj)), ((c) (obj1)), (byte)0);
            v1.a.put(j1, obj1);
            obj1 = obj;
            if (v1.getActivity() != null)
            {
                p.a = false;
                v1.getLoaderManager().a(j1, v1);
                return ((com.google.android.gms.common.api.c) (obj));
            }
            if (true) goto _L6; else goto _L4
_L4:
            obj1 = null;
              goto _L7
            return new com.google.android.gms.common.api.o(j, n, a(), o, p, b, q, r, -1, -1);
        }

        public a(Context context)
        {
            a = new HashSet();
            i = new ia();
            b = new ia();
            k = -1;
            l = -1;
            o = com.google.android.gms.common.b.a();
            p = com.google.android.gms.signin.b.c;
            q = new ArrayList();
            r = new ArrayList();
            s = new com.google.android.gms.signin.e.a();
            j = context;
            n = context.getMainLooper();
            g = context.getPackageName();
            h = context.getClass().getName();
        }

        public a(Context context, b b1, c c1)
        {
            this(context);
            w.a(b1, "Must provide a connected listener");
            q.add(b1);
            w.a(c1, "Must provide a connection failed listener");
            r.add(c1);
        }
    }

    public static interface b
    {

        public abstract void a(int i);

        public abstract void a(Bundle bundle);
    }

    public static interface c
    {

        public abstract void a(ConnectionResult connectionresult);
    }

    public static interface d
    {

        public abstract a a();

        public abstract boolean b();
    }

    public static final class d.a
    {

        public boolean a;
        public Set b;
    }

    public static interface e
    {

        public abstract void a(ConnectionResult connectionresult);

        public abstract void b(ConnectionResult connectionresult);
    }


    public abstract Looper a();

    public abstract ConnectionResult a(TimeUnit timeunit);

    public abstract a.b a(a.c c1);

    public abstract k.a a(k.a a1);

    public abstract void a(b b1);

    public abstract void a(c c1);

    public abstract void a(String s, PrintWriter printwriter);

    public abstract boolean a(com.google.android.gms.common.api.a a1);

    public abstract k.a b(k.a a1);

    public abstract void b();

    public abstract void b(b b1);

    public abstract void b(c c1);

    public abstract boolean b(com.google.android.gms.common.api.a a1);

    public abstract void c();

    public abstract boolean d();

    public abstract boolean e();
}
