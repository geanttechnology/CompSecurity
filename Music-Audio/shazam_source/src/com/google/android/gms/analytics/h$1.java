// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.internal.a;
import com.google.android.gms.analytics.internal.ag;
import com.google.android.gms.analytics.internal.c;
import com.google.android.gms.analytics.internal.e;
import com.google.android.gms.analytics.internal.g;
import com.google.android.gms.analytics.internal.l;
import com.google.android.gms.analytics.internal.n;
import com.google.android.gms.analytics.internal.o;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.analytics.internal.t;
import com.google.android.gms.analytics.internal.w;
import com.google.android.gms.d.jd;
import com.google.android.gms.d.jf;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.google.android.gms.analytics:
//            h, e

final class g
    implements Runnable
{

    final Map a;
    final boolean b;
    final String c;
    final long d;
    final boolean e;
    final boolean f;
    final String g;
    final h h;

    public final void run()
    {
        boolean flag1 = true;
        if (h.c.b())
        {
            a.put("sc", "start");
        }
        l.b(a, "cid", ((o) (h)).i.d().b());
        Object obj = (String)a.get("sf");
        if (obj != null)
        {
            double d1 = l.a(((String) (obj)));
            if (l.a(d1, (String)a.get("cid")))
            {
                h.b("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(d1));
                return;
            }
        }
        obj = ((o) (h)).i.f();
        boolean flag;
        if (b)
        {
            l.a(a, "ate", ((a) (obj)).b());
            l.a(a, "adid", ((a) (obj)).c());
        } else
        {
            a.remove("ate");
            a.remove("adid");
        }
        obj = ((o) (h)).i.h().b();
        l.a(a, "an", ((jd) (obj)).a);
        l.a(a, "av", ((jd) (obj)).b);
        l.a(a, "aid", ((jd) (obj)).c);
        l.a(a, "aiid", ((jd) (obj)).d);
        a.put("v", "1");
        a.put("_v", q.b);
        l.a(a, "ul", ((o) (h)).i.h.b().a);
        l.a(a, "sr", ((o) (h)).i.h.c());
        if (c.equals("transaction") || c.equals("item"))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (!flag && !h.b.a())
        {
            ((o) (h)).i.a().a(a, "Too many hits sent too quickly, rate limiting invoked");
            return;
        }
        long l2 = l.b((String)a.get("ht"));
        long l1 = l2;
        if (l2 == 0L)
        {
            l1 = d;
        }
        if (e)
        {
            obj = new c(h, a, l1, f);
            ((o) (h)).i.a().c("Dry run enabled. Would have sent hit", obj);
            return;
        }
        obj = (String)a.get("cid");
        HashMap hashmap = new HashMap();
        l.a(hashmap, "uid", a);
        l.a(hashmap, "an", a);
        l.a(hashmap, "aid", a);
        l.a(hashmap, "av", a);
        l.a(hashmap, "aiid", a);
        String s = g;
        if (TextUtils.isEmpty((CharSequence)a.get("adid")))
        {
            flag1 = false;
        }
        obj = new t(((String) (obj)), s, flag1, 0L, hashmap);
        l2 = ((o) (h)).i.c().a(((t) (obj)));
        a.put("_s", String.valueOf(l2));
        obj = new c(h, a, l1, f);
        ((o) (h)).i.c().a(((c) (obj)));
    }

    rnal.n(h h1, Map map, boolean flag, String s, long l1, boolean flag1, 
            boolean flag2, String s1)
    {
        h = h1;
        a = map;
        b = flag;
        c = s;
        d = l1;
        e = flag1;
        f = flag2;
        g = s1;
        super();
    }
}
