// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.e;

import android.content.Context;
import com.google.android.gms.d.f;
import com.google.android.gms.d.kf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.e:
//            az, cj, cw, ct, 
//            dd, dh, ck, cf, 
//            db, j, k, q, 
//            r, ag, ah, bj, 
//            cb, ad, bd, co, 
//            cp, cq, cr, cs, 
//            cx, da, df, f, 
//            g, i, n, s, 
//            t, aa, ac, af, 
//            al, an, ba, bc, 
//            bg, bi, bk, bt, 
//            bu, ce, cl, aj, 
//            cm, cn, bo, cv, 
//            am, o, bl, bn, 
//            br, ax, c, m, 
//            l, de

final class bs
{
    static interface a
    {

        public abstract void a(com.google.android.gms.d.kf.e e1, Set set, Set set1, bo bo1);
    }

    private static final class b
    {

        az a;
        com.google.android.gms.d.h.a b;

        public b(az az1, com.google.android.gms.d.h.a a1)
        {
            a = az1;
            b = a1;
        }
    }

    private static final class c
    {

        final Set a = new HashSet();
        final Map b = new HashMap();
        final Map c = new HashMap();
        final Map d = new HashMap();
        final Map e = new HashMap();
        com.google.android.gms.d.kf.a f;

        public final void a(com.google.android.gms.d.kf.e e1)
        {
            a.add(e1);
        }

        public c()
        {
        }
    }


    private static final az a = new az(com.google.android.gms.e.cj.f(), true);
    private final com.google.android.gms.d.kf.c b;
    private final m c;
    private final Map d = new HashMap();
    private final Map e = new HashMap();
    private final Map f = new HashMap();
    private final cv g;
    private final cv h;
    private final Set i;
    private final com.google.android.gms.e.c j;
    private final Map k = new HashMap();
    private volatile String l;
    private int m;

    public bs(Context context, com.google.android.gms.d.kf.c c1, com.google.android.gms.e.c c2, dd.a a1, dd.a a2, m m1)
    {
        if (c1 == null)
        {
            throw new NullPointerException("resource cannot be null");
        }
        b = c1;
        i = new HashSet(c1.a);
        j = c2;
        c = m1;
        c1 = new cw.a() {

            final bs a;

            public final int a(Object obj, Object obj1)
            {
                return ((com.google.android.gms.d.h.a)((az)obj1).a).e();
            }

            
            {
                a = bs.this;
                super();
            }
        };
        new cw();
        g = cw.a(c1);
        c1 = new cw.a() {

            final bs a;

            public final int a(Object obj, Object obj1)
            {
                obj = (String)obj;
                obj1 = (b)obj1;
                int l1 = ((String) (obj)).length();
                int i2 = ((com.google.android.gms.d.h.a)((b) (obj1)).a.a).e();
                int k1;
                if (((b) (obj1)).b == null)
                {
                    k1 = 0;
                } else
                {
                    k1 = ((b) (obj1)).b.e();
                }
                return k1 + i2 + l1;
            }

            
            {
                a = bs.this;
                super();
            }
        };
        new cw();
        h = cw.a(c1);
        b(new ct(context));
        b(new dd(a2));
        b(new dh(c2));
        b(new ck(context, c2));
        b(new cf(context, c2));
        c(new db());
        c(new j());
        c(new k());
        c(new q());
        c(new r());
        c(new ag());
        c(new ah());
        c(new bj());
        c(new cb());
        a(new ad(context));
        a(new bd(context));
        a(new co(context));
        a(new cp(context));
        a(new cq(context));
        a(new cr(context));
        a(new cs(context));
        a(new cx());
        a(new da(b.c));
        a(new dd(a1));
        a(new df(c2));
        a(new com.google.android.gms.e.f(context));
        a(new g());
        a(new i());
        a(new n(this));
        a(new s());
        a(new t());
        a(new aa(context));
        a(new ac());
        a(new af());
        a(new al());
        a(new an(context));
        a(new ba());
        a(new bc());
        a(new bg());
        a(new bi());
        a(new bk(context));
        a(new bt());
        a(new bu());
        a(new ce());
        a(new cl());
        for (c2 = i.iterator(); c2.hasNext();)
        {
            a1 = (com.google.android.gms.d.kf.e)c2.next();
            for (int i1 = 0; i1 < ((com.google.android.gms.d.kf.e) (a1)).e.size(); i1++)
            {
                m1 = (com.google.android.gms.d.kf.a)((com.google.android.gms.d.kf.e) (a1)).e.get(i1);
                a2 = a(k, a(m1));
                a2.a(a1);
                c1 = (List)((c) (a2)).b.get(a1);
                context = c1;
                if (c1 == null)
                {
                    context = new ArrayList();
                    ((c) (a2)).b.put(a1, context);
                }
                context.add(m1);
                c1 = (List)((c) (a2)).d.get(a1);
                context = c1;
                if (c1 == null)
                {
                    context = new ArrayList();
                    ((c) (a2)).d.put(a1, context);
                }
                context.add("Unknown");
            }

            int j1 = 0;
            while (j1 < ((com.google.android.gms.d.kf.e) (a1)).f.size()) 
            {
                m1 = (com.google.android.gms.d.kf.a)((com.google.android.gms.d.kf.e) (a1)).f.get(j1);
                a2 = a(k, a(m1));
                a2.a(a1);
                c1 = (List)((c) (a2)).c.get(a1);
                context = c1;
                if (c1 == null)
                {
                    context = new ArrayList();
                    ((c) (a2)).c.put(a1, context);
                }
                context.add(m1);
                c1 = (List)((c) (a2)).e.get(a1);
                context = c1;
                if (c1 == null)
                {
                    context = new ArrayList();
                    ((c) (a2)).e.put(a1, context);
                }
                context.add("Unknown");
                j1++;
            }
        }

        for (context = b.b.entrySet().iterator(); context.hasNext();)
        {
            c1 = (java.util.Map.Entry)context.next();
            c2 = ((List)c1.getValue()).iterator();
            while (c2.hasNext()) 
            {
                a1 = (com.google.android.gms.d.kf.a)c2.next();
                if (!cj.d((com.google.android.gms.d.h.a)Collections.unmodifiableMap(((com.google.android.gms.d.kf.a) (a1)).a).get(f.bM.toString())).booleanValue())
                {
                    a(k, (String)c1.getKey()).f = a1;
                }
            }
        }

    }

    private az a(com.google.android.gms.d.h.a a1, Set set, cm cm1)
    {
        if (!a1.l)
        {
            return new az(a1, true);
        }
        com.google.android.gms.d.h.a a4;
        int k1;
        switch (a1.a)
        {
        case 5: // '\005'
        case 6: // '\006'
        default:
            aj.a((new StringBuilder("Unknown type: ")).append(a1.a).toString());
            return a;

        case 2: // '\002'
            com.google.android.gms.d.h.a a2 = kf.a(a1);
            a2.c = new com.google.android.gms.d.h.a[a1.c.length];
            for (int i1 = 0; i1 < a1.c.length; i1++)
            {
                az az1 = a(a1.c[i1], set, cm1.a());
                if (az1 == a)
                {
                    return a;
                }
                a2.c[i1] = (com.google.android.gms.d.h.a)az1.a;
            }

            return new az(a2, false);

        case 3: // '\003'
            com.google.android.gms.d.h.a a3 = kf.a(a1);
            if (a1.d.length != a1.e.length)
            {
                aj.a((new StringBuilder("Invalid serving value: ")).append(a1.toString()).toString());
                return a;
            }
            a3.d = new com.google.android.gms.d.h.a[a1.d.length];
            a3.e = new com.google.android.gms.d.h.a[a1.d.length];
            for (int j1 = 0; j1 < a1.d.length; j1++)
            {
                az az2 = a(a1.d[j1], set, cm1.b());
                az az4 = a(a1.e[j1], set, cm1.c());
                if (az2 == a || az4 == a)
                {
                    return a;
                }
                a3.d[j1] = (com.google.android.gms.d.h.a)az2.a;
                a3.e[j1] = (com.google.android.gms.d.h.a)az4.a;
            }

            return new az(a3, false);

        case 4: // '\004'
            if (set.contains(a1.f))
            {
                aj.a((new StringBuilder("Macro cycle detected.  Current macro reference: ")).append(a1.f).append(".  Previous macro references: ").append(set.toString()).append(".").toString());
                return a;
            } else
            {
                set.add(a1.f);
                cm1 = cn.a(a(a1.f, set, cm1.e()), a1.k);
                set.remove(a1.f);
                return cm1;
            }

        case 7: // '\007'
            a4 = kf.a(a1);
            a4.j = new com.google.android.gms.d.h.a[a1.j.length];
            k1 = 0;
            break;
        }
        for (; k1 < a1.j.length; k1++)
        {
            az az3 = a(a1.j[k1], set, cm1.d());
            if (az3 == a)
            {
                return a;
            }
            a4.j[k1] = (com.google.android.gms.d.h.a)az3.a;
        }

        return new az(a4, false);
    }

    private az a(com.google.android.gms.d.kf.a a1, Set set, bl bl1)
    {
        a1 = a(e, a1, set, bl1);
        set = cj.d((com.google.android.gms.d.h.a)((az) (a1)).a);
        cj.a(set);
        return new az(set, ((az) (a1)).b);
    }

    private az a(com.google.android.gms.d.kf.e e1, Set set, bo bo1)
    {
        Iterator iterator = e1.b.iterator();
        boolean flag = true;
        while (iterator.hasNext()) 
        {
            az az2 = a((com.google.android.gms.d.kf.a)iterator.next(), set, bo1.a());
            if (((Boolean)az2.a).booleanValue())
            {
                cj.a(Boolean.valueOf(false));
                return new az(Boolean.valueOf(false), az2.b);
            }
            if (flag && az2.b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        for (e1 = e1.a.iterator(); e1.hasNext();)
        {
            az az1 = a((com.google.android.gms.d.kf.a)e1.next(), set, bo1.b());
            if (!((Boolean)az1.a).booleanValue())
            {
                cj.a(Boolean.valueOf(false));
                return new az(Boolean.valueOf(false), az1.b);
            }
            if (flag && az1.b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }

        cj.a(Boolean.valueOf(true));
        return new az(Boolean.valueOf(true), flag);
    }

    private az a(String s1, Set set, am am1)
    {
        m = m + 1;
        Object obj = (b)h.a(s1);
        if (obj != null)
        {
            a(((b) (obj)).b, set);
            m = m - 1;
            return ((b) (obj)).a;
        }
        obj = (c)k.get(s1);
        if (obj == null)
        {
            aj.a((new StringBuilder()).append(b()).append("Invalid macro: ").append(s1).toString());
            m = m - 1;
            return a;
        }
        az az1 = a(((c) (obj)).a, ((c) (obj)).b, ((c) (obj)).d, ((c) (obj)).c, ((c) (obj)).e, set, am1.b());
        if (((Set)az1.a).isEmpty())
        {
            obj = ((c) (obj)).f;
        } else
        {
            if (((Set)az1.a).size() > 1)
            {
                (new StringBuilder()).append(b()).append("Multiple macros active for macroName ").append(s1);
                aj.a();
            }
            obj = (com.google.android.gms.d.kf.a)((Set)az1.a).iterator().next();
        }
        if (obj == null)
        {
            m = m - 1;
            return a;
        }
        am1 = a(f, ((com.google.android.gms.d.kf.a) (obj)), set, am1.a());
        boolean flag;
        if (az1.b && ((az) (am1)).b)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (am1 == a)
        {
            am1 = a;
        } else
        {
            am1 = new az(((az) (am1)).a, flag);
        }
        obj = ((com.google.android.gms.d.kf.a) (obj)).b;
        if (((az) (am1)).b)
        {
            h.a(s1, new b(am1, ((com.google.android.gms.d.h.a) (obj))));
        }
        a(((com.google.android.gms.d.h.a) (obj)), set);
        m = m - 1;
        return am1;
    }

    private az a(Map map, com.google.android.gms.d.kf.a a1, Set set, bl bl1)
    {
        Object obj = (com.google.android.gms.d.h.a)Collections.unmodifiableMap(a1.a).get(f.aZ.toString());
        if (obj == null)
        {
            aj.a("No function id in properties");
            map = a;
        } else
        {
            String s1 = ((com.google.android.gms.d.h.a) (obj)).g;
            o o1 = (o)map.get(s1);
            if (o1 == null)
            {
                aj.a((new StringBuilder()).append(s1).append(" has no backing implementation.").toString());
                return a;
            }
            obj = (az)g.a(a1);
            map = ((Map) (obj));
            if (obj == null)
            {
                map = new HashMap();
                Iterator iterator = Collections.unmodifiableMap(a1.a).entrySet().iterator();
                boolean flag = true;
                while (iterator.hasNext()) 
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    entry.getKey();
                    Object obj1 = bl1.a();
                    com.google.android.gms.d.h.a a2 = (com.google.android.gms.d.h.a)entry.getValue();
                    entry.getValue();
                    obj1 = a(a2, set, ((bn) (obj1)).a());
                    if (obj1 == a)
                    {
                        return a;
                    }
                    if (((az) (obj1)).b)
                    {
                        String s2 = (String)entry.getKey();
                        com.google.android.gms.d.h.a a3 = (com.google.android.gms.d.h.a)((az) (obj1)).a;
                        a1.a.put(s2, a3);
                    } else
                    {
                        flag = false;
                    }
                    map.put(entry.getKey(), ((az) (obj1)).a);
                }
                if (!map.keySet().containsAll(o1.a))
                {
                    aj.a((new StringBuilder("Incorrect keys for function ")).append(s1).append(" required ").append(o1.c()).append(" had ").append(map.keySet()).toString());
                    return a;
                }
                boolean flag1;
                if (flag && o1.a())
                {
                    flag1 = true;
                } else
                {
                    flag1 = false;
                }
                map = new az(o1.a(map), flag1);
                if (flag1)
                {
                    g.a(a1, map);
                }
                return map;
            }
        }
        return map;
    }

    private az a(Set set, Map map, Map map1, Map map2, Map map3, Set set1, br br1)
    {
        return a(set, set1, new a(map, map1, map2, map3) {

            final Map a;
            final Map b;
            final Map c;
            final Map d;
            final bs e;

            public final void a(com.google.android.gms.d.kf.e e1, Set set2, Set set3, bo bo1)
            {
                List list = (List)a.get(e1);
                b.get(e1);
                if (list != null)
                {
                    set2.addAll(list);
                    bo1.c();
                }
                set2 = (List)c.get(e1);
                d.get(e1);
                if (set2 != null)
                {
                    set3.addAll(set2);
                    bo1.d();
                }
            }

            
            {
                e = bs.this;
                a = map;
                b = map1;
                c = map2;
                d = map3;
                super();
            }
        }, br1);
    }

    private az a(Set set, Set set1, a a1, br br1)
    {
        HashSet hashset = new HashSet();
        HashSet hashset1 = new HashSet();
        set = set.iterator();
        boolean flag = true;
        while (set.hasNext()) 
        {
            com.google.android.gms.d.kf.e e1 = (com.google.android.gms.d.kf.e)set.next();
            bo bo1 = br1.a();
            az az1 = a(e1, set1, bo1);
            if (((Boolean)az1.a).booleanValue())
            {
                a1.a(e1, hashset, hashset1, bo1);
            }
            if (flag && az1.b)
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        hashset.removeAll(hashset1);
        return new az(hashset, flag);
    }

    private static c a(Map map, String s1)
    {
        c c2 = (c)map.get(s1);
        c c1 = c2;
        if (c2 == null)
        {
            c1 = new c();
            map.put(s1, c1);
        }
        return c1;
    }

    private static String a(com.google.android.gms.d.kf.a a1)
    {
        return cj.a((com.google.android.gms.d.h.a)Collections.unmodifiableMap(a1.a).get(f.bk.toString()));
    }

    private void a(com.google.android.gms.d.h.a a1, Set set)
    {
        if (a1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((a1 = a(a1, set, ((cm) (new ax())))) != a)
        {
            a1 = ((com.google.android.gms.d.h.a) (cj.e((com.google.android.gms.d.h.a)((az) (a1)).a)));
            if (a1 instanceof Map)
            {
                a1 = (Map)a1;
                j.a(a1);
                return;
            }
            if (a1 instanceof List)
            {
                a1 = ((List)a1).iterator();
                while (a1.hasNext()) 
                {
                    set = ((Set) (a1.next()));
                    if (set instanceof Map)
                    {
                        set = (Map)set;
                        j.a(set);
                    } else
                    {
                        aj.a();
                    }
                }
            } else
            {
                aj.a();
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private void a(o o1)
    {
        a(f, o1);
    }

    private static void a(Map map, o o1)
    {
        if (map.containsKey(o1.b()))
        {
            throw new IllegalArgumentException((new StringBuilder("Duplicate function type name: ")).append(o1.b()).toString());
        } else
        {
            map.put(o1.b(), o1);
            return;
        }
    }

    private String b()
    {
        if (m <= 1)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(Integer.toString(m));
        for (int i1 = 2; i1 < m; i1++)
        {
            stringbuilder.append(' ');
        }

        stringbuilder.append(": ");
        return stringbuilder.toString();
    }

    private void b(o o1)
    {
        a(d, o1);
    }

    private void c(o o1)
    {
        a(e, o1);
    }

    private void c(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        l = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    final String a()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = l;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

    public final void a(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        c(s1);
        s1 = c.b().b();
        Object obj = i;
        Object obj1 = s1.b();
        for (obj = ((Set)a(((Set) (obj)), ((Set) (new HashSet())), new a() {

        final bs a;

        public final void a(com.google.android.gms.d.kf.e e1, Set set, Set set1, bo bo1)
        {
            set.addAll(e1.c);
            set1.addAll(e1.d);
            bo1.e();
            bo1.f();
        }

            
            {
                a = bs.this;
                super();
            }
    }, ((br) (obj1))).a).iterator(); ((Iterator) (obj)).hasNext(); a(d, ((com.google.android.gms.d.kf.a) (obj1)), ((Set) (new HashSet())), s1.a()))
        {
            obj1 = (com.google.android.gms.d.kf.a)((Iterator) (obj)).next();
        }

        break MISSING_BLOCK_LABEL_117;
        s1;
        throw s1;
        c(((String) (null)));
        this;
        JVM INSTR monitorexit ;
    }

    public final az b(String s1)
    {
        m = 0;
        l l1 = c.a();
        return a(s1, new HashSet(), l1.a());
    }

}
