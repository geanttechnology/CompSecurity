// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.text.TextUtils;
import com.google.android.gms.analytics.internal.a;
import com.google.android.gms.analytics.internal.ag;
import com.google.android.gms.analytics.internal.c;
import com.google.android.gms.analytics.internal.e;
import com.google.android.gms.analytics.internal.g;
import com.google.android.gms.analytics.internal.l;
import com.google.android.gms.analytics.internal.m;
import com.google.android.gms.analytics.internal.n;
import com.google.android.gms.analytics.internal.p;
import com.google.android.gms.analytics.internal.q;
import com.google.android.gms.analytics.internal.r;
import com.google.android.gms.analytics.internal.t;
import com.google.android.gms.analytics.internal.w;
import com.google.android.gms.common.internal.x;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            vn, kx, wf, wk, 
//            wm

public class la extends p
{
    private class a extends p
    {

        final la a;
        private long b;
        private boolean c;

        protected void a()
        {
        }

        public boolean b()
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

        protected a(r r)
        {
            a = la.this;
            super(r);
            b = -1L;
        }
    }


    private boolean a;
    private final Map b = new HashMap();
    private final Map c = new HashMap();
    private final e d;
    private final a e;

    la(r r, String s, e e1)
    {
        super(r);
        if (s != null)
        {
            b.put("&tid", s);
        }
        b.put("useSecure", "1");
        b.put("&a", Integer.toString((new Random()).nextInt(0x7fffffff) + 1));
        if (e1 == null)
        {
            d = new e("tracking");
        } else
        {
            d = e1;
        }
        e = new a(r);
    }

    static a a(la la1)
    {
        return la1.e;
    }

    private static void a(Map map, Map map1)
    {
        x.a(map1);
        if (map != null)
        {
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                String s = b(entry);
                if (s != null)
                {
                    map1.put(s, entry.getValue());
                }
            }
        }
    }

    private static boolean a(java.util.Map.Entry entry)
    {
        String s = (String)entry.getKey();
        entry = (String)entry.getValue();
        return s.startsWith("&") && s.length() >= 2;
    }

    static com.google.android.gms.analytics.internal.a b(la la1)
    {
        return la1.y();
    }

    private static String b(java.util.Map.Entry entry)
    {
        if (!a(entry))
        {
            return null;
        } else
        {
            return ((String)entry.getKey()).substring(1);
        }
    }

    private static void b(Map map, Map map1)
    {
        x.a(map1);
        if (map != null)
        {
            map = map.entrySet().iterator();
            while (map.hasNext()) 
            {
                java.util.Map.Entry entry = (java.util.Map.Entry)map.next();
                String s = b(entry);
                if (s != null && !map1.containsKey(s))
                {
                    map1.put(s, entry.getValue());
                }
            }
        }
    }

    static w c(la la1)
    {
        return la1.z();
    }

    static ag d(la la1)
    {
        return la1.A();
    }

    static ag e(la la1)
    {
        return la1.A();
    }

    static e f(la la1)
    {
        return la1.d;
    }

    static g g(la la1)
    {
        return la1.p();
    }

    static g h(la la1)
    {
        return la1.p();
    }

    static n i(la la1)
    {
        return la1.t();
    }

    static n j(la la1)
    {
        return la1.t();
    }

    protected void a()
    {
        e.E();
        String s = v().c();
        if (s != null)
        {
            a("&an", s);
        }
        s = v().b();
        if (s != null)
        {
            a("&av", s);
        }
    }

    public void a(String s)
    {
        a("&cd", s);
    }

    public void a(String s, String s1)
    {
        x.a(s, "Key should be non-null");
        if (TextUtils.isEmpty(s))
        {
            return;
        } else
        {
            b.put(s, s1);
            return;
        }
    }

    public void a(Map map)
    {
        HashMap hashmap;
        String s;
        long l1;
        boolean flag;
        boolean flag1;
        l1 = n().a();
        if (s().f())
        {
            c("AppOptOut is set to true. Not sending Google Analytics hit");
            return;
        }
        flag = s().e();
        hashmap = new HashMap();
        a(b, ((Map) (hashmap)));
        a(map, ((Map) (hashmap)));
        flag1 = l.a((String)b.get("useSecure"), true);
        b(c, hashmap);
        c.clear();
        map = (String)hashmap.get("t");
        if (TextUtils.isEmpty(map))
        {
            p().a(hashmap, "Missing hit type parameter");
            return;
        }
        s = (String)hashmap.get("tid");
        if (TextUtils.isEmpty(s))
        {
            p().a(hashmap, "Missing tracking id parameter");
            return;
        }
        boolean flag2 = b();
        this;
        JVM INSTR monitorenter ;
        int i1;
        if (!"screenview".equalsIgnoreCase(map) && !"pageview".equalsIgnoreCase(map) && !"appview".equalsIgnoreCase(map) && !TextUtils.isEmpty(map))
        {
            break MISSING_BLOCK_LABEL_252;
        }
        i1 = Integer.parseInt((String)b.get("&a")) + 1;
        int k;
        k = i1;
        if (i1 >= 0x7fffffff)
        {
            k = 1;
        }
        b.put("&a", Integer.toString(k));
        this;
        JVM INSTR monitorexit ;
        r().a(new Runnable(hashmap, flag2, map, l1, flag, flag1, s) {

            final Map a;
            final boolean b;
            final String c;
            final long d;
            final boolean e;
            final boolean f;
            final String g;
            final la h;

            public void run()
            {
                boolean flag4 = true;
                if (android.support.v7.la.a(h).b())
                {
                    a.put("sc", "start");
                }
                l.b(a, "cid", h.s().h());
                Object obj = (String)a.get("sf");
                if (obj != null)
                {
                    double d1 = l.a(((String) (obj)), 100D);
                    if (l.a(d1, (String)a.get("cid")))
                    {
                        h.b("Sampling enabled. Hit sampled out. sample rate", Double.valueOf(d1));
                        return;
                    }
                }
                obj = la.b(h);
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
                obj = android.support.v7.la.c(h).c();
                l.a(a, "an", ((wk) (obj)).a());
                l.a(a, "av", ((wk) (obj)).b());
                l.a(a, "aid", ((wk) (obj)).c());
                l.a(a, "aiid", ((wk) (obj)).d());
                a.put("v", "1");
                a.put("_v", q.b);
                l.a(a, "ul", la.d(h).b().f());
                l.a(a, "sr", android.support.v7.la.e(h).c());
                if (c.equals("transaction") || c.equals("item"))
                {
                    flag3 = true;
                } else
                {
                    flag3 = false;
                }
                if (!flag3 && !la.f(h).a())
                {
                    android.support.v7.la.g(h).a(a, "Too many hits sent too quickly, rate limiting invoked");
                    return;
                }
                long l3 = l.a((String)a.get("ht"));
                long l2 = l3;
                if (l3 == 0L)
                {
                    l2 = d;
                }
                if (e)
                {
                    obj = new c(h, a, l2, f);
                    la.h(h).c("Dry run enabled. Would have sent hit", obj);
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
                obj = new t(0L, ((String) (obj)), s1, flag4, 0L, hashmap1);
                l3 = la.i(h).a(((t) (obj)));
                a.put("_s", String.valueOf(l3));
                obj = new c(h, a, l2, f);
                la.j(h).a(((c) (obj)));
            }

            
            {
                h = la.this;
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

    public void a(boolean flag)
    {
        a = flag;
    }

    boolean b()
    {
        return a;
    }
}
