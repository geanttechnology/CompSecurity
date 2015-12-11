// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.support.v4.app.f;
import android.view.View;
import com.google.android.gms.b.du;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.u;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.api:
//            zzm, m, zzn, b

public interface com.google.android.gms.common.api.d
{
    public static final class a
    {

        private Account a;
        private final Set b = new HashSet();
        private int c;
        private View d;
        private String e;
        private String f;
        private final Map g = new HashMap();
        private final Context h;
        private final Map i = new HashMap();
        private f j;
        private int k;
        private int l;
        private d m;
        private Looper n;
        private b.d o;
        private final Set p = new HashSet();
        private final Set q = new HashSet();
        private com.google.android.gms.b.dx.a r;

        private com.google.android.gms.common.api.d c()
        {
            zzm zzm1 = zzm.a(j);
            m m1 = new m(h.getApplicationContext(), n, a(), o, i, p, q, k, -1);
            zzm1.a(k, m1, m);
            return m1;
        }

        private com.google.android.gms.common.api.d d()
        {
            zzn zzn1 = zzn.a(j);
            com.google.android.gms.common.api.d d1 = zzn1.a(l);
            Object obj = d1;
            if (d1 == null)
            {
                obj = new m(h.getApplicationContext(), n, a(), o, i, p, q, -1, l);
            }
            zzn1.a(l, ((com.google.android.gms.common.api.d) (obj)), m);
            return ((com.google.android.gms.common.api.d) (obj));
        }

        public a a(com.google.android.gms.common.api.b b1)
        {
            i.put(b1, null);
            b.addAll(b1.c());
            return this;
        }

        public a a(b b1)
        {
            p.add(b1);
            return this;
        }

        public a a(d d1)
        {
            q.add(d1);
            return this;
        }

        public h a()
        {
            return new h(a, b, g, c, d, e, f, r.a());
        }

        public com.google.android.gms.common.api.d b()
        {
            boolean flag;
            if (!i.isEmpty())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            u.b(flag, "must call addApi() to add at least one API");
            if (k >= 0)
            {
                return c();
            }
            if (l >= 0)
            {
                return d();
            } else
            {
                return new m(h, n, a(), o, i, p, q, -1, -1);
            }
        }

        public a(Context context)
        {
            k = -1;
            l = -1;
            r = new com.google.android.gms.b.dx.a();
            h = context;
            n = context.getMainLooper();
            e = context.getPackageName();
            f = context.getClass().getName();
            o = du.c;
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

        public abstract void b(ConnectionResult connectionresult);
    }

    public static interface d
    {

        public abstract void a(ConnectionResult connectionresult);
    }

    public static interface e
    {

        public abstract a a(String s, Set set);

        public abstract boolean a(String s, String s1);
    }

    public static class e.a
    {

        private boolean a;
        private Set b;

        public boolean a()
        {
            return a;
        }

        public Set b()
        {
            return b;
        }
    }


    public abstract Context a();

    public abstract b.b a(b.c c1);

    public abstract i.a a(i.a a1);

    public abstract void a(b b1);

    public abstract void a(d d1);

    public abstract void a(String s, FileDescriptor filedescriptor, PrintWriter printwriter, String as[]);

    public abstract Looper b();

    public abstract i.a b(i.a a1);

    public abstract void b(b b1);

    public abstract void b(d d1);

    public abstract void c();

    public abstract void d();

    public abstract boolean e();

    public abstract boolean f();
}
