// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.common.api;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import android.support.v4.app.f;
import android.view.View;
import com.google.android.gms.b.du;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.u;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.common.api:
//            d, zzm, m, zzn, 
//            b

public static final class o
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
    private .h m;
    private Looper n;
    private .h o;
    private final Set p = new HashSet();
    private final Set q = new HashSet();
    private com.google.android.gms.b. r;

    private d c()
    {
        zzm zzm1 = zzm.a(j);
        m m1 = new m(h.getApplicationContext(), n, a(), o, i, p, q, k, -1);
        zzm1.a(k, m1, m);
        return m1;
    }

    private d d()
    {
        zzn zzn1 = zzn.a(j);
        d d1 = zzn1.a(l);
        Object obj = d1;
        if (d1 == null)
        {
            obj = new m(h.getApplicationContext(), n, a(), o, i, p, q, -1, l);
        }
        zzn1.a(l, ((d) (obj)), m);
        return ((d) (obj));
    }

    public m a(b b1)
    {
        i.put(b1, null);
        b.addAll(b1.c());
        return this;
    }

    public b a(b b1)
    {
        p.add(b1);
        return this;
    }

    public p a(p p1)
    {
        q.add(p1);
        return this;
    }

    public h a()
    {
        return new h(a, b, g, c, d, e, f, r.a());
    }

    public d b()
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

    public .h(Context context)
    {
        k = -1;
        l = -1;
        r = new com.google.android.gms.b.();
        h = context;
        n = context.getMainLooper();
        e = context.getPackageName();
        f = context.getClass().getName();
        o = du.c;
    }
}
