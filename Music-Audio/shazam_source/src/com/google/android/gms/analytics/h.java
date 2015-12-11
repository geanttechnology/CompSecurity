// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.analytics;

import android.text.TextUtils;
import com.google.android.gms.analytics.internal.ag;
import com.google.android.gms.analytics.internal.c;
import com.google.android.gms.analytics.internal.e;
import com.google.android.gms.analytics.internal.g;
import com.google.android.gms.analytics.internal.l;
import com.google.android.gms.analytics.internal.m;
import com.google.android.gms.analytics.internal.n;
import com.google.android.gms.analytics.internal.o;
import com.google.android.gms.analytics.internal.p;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.analytics.internal.t;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.d.ii;
import com.google.android.gms.d.ja;
import com.google.android.gms.d.jd;
import com.google.android.gms.d.jf;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// Referenced classes of package com.google.android.gms.analytics:
//            e

public final class h extends p
{
    private final class a extends p
    {

        final h a;
        private long b;
        private boolean c;

        protected final void a()
        {
        }

        public final boolean b()
        {
            this;
            JVM INSTR monitorenter ;
            boolean flag;
            flag = c;
            c = false;
            this;
            JVM INSTR monitorexit ;
            return flag;
            Exception exception;
            exception;
            throw exception;
        }

        protected a(r r1)
        {
            a = h.this;
            super(r1);
            b = -1L;
        }
    }


    public boolean a;
    final e b = new e("tracking", (byte)0);
    final a c;
    private final Map d = new HashMap();
    private final Map e = new HashMap();

    h(r r1, String s)
    {
        super(r1);
        if (s != null)
        {
            d.put("&tid", s);
        }
        d.put("useSecure", "1");
        d.put("&a", Integer.toString((new Random()).nextInt(0x7fffffff) + 1));
        c = new a(r1);
    }

    private static String a(java.util.Map.Entry entry)
    {
        String s = (String)entry.getKey();
        entry.getValue();
        boolean flag;
        if (!s.startsWith("&") || s.length() < 2)
        {
            flag = false;
        } else
        {
            flag = true;
        }
        if (!flag)
        {
            return null;
        } else
        {
            return ((String)entry.getKey()).substring(1);
        }
    }

    private static void a(Map map, Map map1)
    {
        w.a(map1);
        if (map != null)
        {
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                String s = a(entry);
                if (s != null)
                {
                    map1.put(s, entry.getValue());
                }
            }
        }
    }

    private static void b(Map map, Map map1)
    {
        w.a(map1);
        if (map != null)
        {
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                String s = a(entry);
                if (s != null && !map1.containsKey(s))
                {
                    map1.put(s, entry.getValue());
                }
            }
        }
    }

    protected final void a()
    {
        c.p();
        String s = super.i.e().c();
        if (s != null)
        {
            a("&an", s);
        }
        s = super.i.e().b();
        if (s != null)
        {
            a("&av", s);
        }
    }

    public final void a(String s, String s1)
    {
        w.a(s, "Key should be non-null");
        if (TextUtils.isEmpty(s))
        {
            return;
        } else
        {
            d.put(s, s1);
            return;
        }
    }

    public final void a(Map map)
    {
        HashMap hashmap;
        String s;
        long l1;
        boolean flag;
        boolean flag1;
        l1 = super.i.c.a();
        if (super.i.d().d)
        {
            c("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        flag = super.i.d().c;
        hashmap = new HashMap();
        a(d, ((Map) (hashmap)));
        a(map, ((Map) (hashmap)));
        flag1 = l.c((String)d.get("useSecure"));
        b(e, hashmap);
        e.clear();
        map = (String)hashmap.get("t");
        if (TextUtils.isEmpty(map))
        {
            super.i.a().a(hashmap, "Missing hit type parameter");
            return;
        }
        s = (String)hashmap.get("tid");
        if (TextUtils.isEmpty(s))
        {
            super.i.a().a(hashmap, "Missing tracking id parameter");
            return;
        }
        boolean flag2 = a;
        this;
        JVM INSTR monitorenter ;
        int j;
        if (!"screenview".equalsIgnoreCase(map) && !"pageview".equalsIgnoreCase(map) && !"appview".equalsIgnoreCase(map) && !TextUtils.isEmpty(map))
        {
            break MISSING_BLOCK_LABEL_263;
        }
        j = Integer.parseInt((String)d.get("&a")) + 1;
        int i;
        i = j;
        if (j >= 0x7fffffff)
        {
            i = 1;
        }
        d.put("&a", Integer.toString(i));
        this;
        JVM INSTR monitorexit ;
        super.i.b().a(new Runnable(hashmap, flag2, map, l1, flag, flag1, s) {

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
                boolean flag4 = true;
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
                boolean flag3;
                if (b)
                {
                    l.a(a, "ate", ((com.google.android.gms.analytics.internal.a) (obj)).b());
                    l.a(a, "adid", ((com.google.android.gms.analytics.internal.a) (obj)).c());
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
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                if (!flag3 && !h.b.a())
                {
                    ((o) (h)).i.a().a(a, "Too many hits sent too quickly, rate limiting invoked");
                    return;
                }
                long l3 = l.b((String)a.get("ht"));
                long l2 = l3;
                if (l3 == 0L)
                {
                    l2 = d;
                }
                if (e)
                {
                    obj = new c(h, a, l2, f);
                    ((o) (h)).i.a().c("Dry run enabled. Would have sent hit", obj);
                    return;
                }
                obj = (String)a.get("cid");
                HashMap hashmap1 = new HashMap();
                l.a(hashmap1, "uid", a);
                l.a(hashmap1, "an", a);
                l.a(hashmap1, "aid", a);
                l.a(hashmap1, "av", a);
                l.a(hashmap1, "aiid", a);
                String s1 = g;
                if (TextUtils.isEmpty((CharSequence)a.get("adid")))
                {
                    flag4 = false;
                }
                obj = new t(((String) (obj)), s1, flag4, 0L, hashmap1);
                l3 = ((o) (h)).i.c().a(((t) (obj)));
                a.put("_s", String.valueOf(l3));
                obj = new c(h, a, l2, f);
                ((o) (h)).i.c().a(((c) (obj)));
            }

            
            {
                h = h.this;
                a = map;
                b = flag;
                c = s;
                d = l1;
                e = flag1;
                f = flag2;
                g = s1;
                super();
            }
        });
        return;
        map;
        this;
        JVM INSTR monitorexit ;
        throw map;
    }
}
