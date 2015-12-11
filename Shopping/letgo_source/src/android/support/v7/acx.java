// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package android.support.v7:
//            ace, ado, aeb, ady, 
//            aei, aem, adp, adk, 
//            aeg, aao, aap, aav, 
//            aaw, abl, abm, aco, 
//            adg, abi, aci, adt, 
//            adu, adv, adw, adx, 
//            aec, aef, aek, aak, 
//            aal, aan, aas, aax, 
//            aay, abf, abh, abk, 
//            abq, abs, acf, ach, 
//            acl, acn, acp, acy, 
//            acz, adj, adq, aar, 
//            lt, abo, xh, adr, 
//            ads, aea, abr, aat, 
//            acq, acs, acw, acc, 
//            aah, act, aaq, aej, 
//            acr

class acx
{
    static interface a
    {

        public abstract void a(xh.e e1, Set set, Set set1, act act1);
    }

    private static class b
    {

        private ace a;
        private lv.a b;

        public ace a()
        {
            return a;
        }

        public lv.a b()
        {
            return b;
        }

        public int c()
        {
            int j1 = ((lv.a)a.a()).g();
            int i1;
            if (b == null)
            {
                i1 = 0;
            } else
            {
                i1 = b.g();
            }
            return i1 + j1;
        }

        public b(ace ace1, lv.a a1)
        {
            a = ace1;
            b = a1;
        }
    }

    private static class c
    {

        private final Set a = new HashSet();
        private final Map b = new HashMap();
        private final Map c = new HashMap();
        private final Map d = new HashMap();
        private final Map e = new HashMap();
        private xh.a f;

        public Set a()
        {
            return a;
        }

        public void a(xh.a a1)
        {
            f = a1;
        }

        public void a(xh.e e1)
        {
            a.add(e1);
        }

        public void a(xh.e e1, xh.a a1)
        {
            List list = (List)b.get(e1);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                b.put(e1, obj);
            }
            ((List) (obj)).add(a1);
        }

        public void a(xh.e e1, String s)
        {
            List list = (List)d.get(e1);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                d.put(e1, obj);
            }
            ((List) (obj)).add(s);
        }

        public Map b()
        {
            return b;
        }

        public void b(xh.e e1, xh.a a1)
        {
            List list = (List)c.get(e1);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                c.put(e1, obj);
            }
            ((List) (obj)).add(a1);
        }

        public void b(xh.e e1, String s)
        {
            List list = (List)e.get(e1);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                e.put(e1, obj);
            }
            ((List) (obj)).add(s);
        }

        public Map c()
        {
            return d;
        }

        public Map d()
        {
            return e;
        }

        public Map e()
        {
            return c;
        }

        public xh.a f()
        {
            return f;
        }

        public c()
        {
        }
    }


    private static final ace a = new ace(ado.f(), true);
    private final xh.c b;
    private final aar c;
    private final Map d = new HashMap();
    private final Map e = new HashMap();
    private final Map f = new HashMap();
    private final aea g;
    private final aea h;
    private final Set i;
    private final aah j;
    private final Map k = new HashMap();
    private volatile String l;
    private int m;

    public acx(Context context, xh.c c1, aah aah1, aei.a a1, aei.a a2, aar aar1)
    {
        if (c1 == null)
        {
            throw new NullPointerException("resource cannot be null");
        }
        b = c1;
        i = new HashSet(c1.b());
        j = aah1;
        c = aar1;
        c1 = new aeb.a() {

            final acx a;

            public int a(xh.a a3, ace ace1)
            {
                return ((lv.a)ace1.a()).g();
            }

            public int a(Object obj, Object obj1)
            {
                return a((xh.a)obj, (ace)obj1);
            }

            
            {
                a = acx.this;
                super();
            }
        };
        g = (new aeb()).a(0x100000, c1);
        c1 = new aeb.a() {

            final acx a;

            public int a(Object obj, Object obj1)
            {
                return a((String)obj, (b)obj1);
            }

            public int a(String s, b b1)
            {
                return s.length() + b1.c();
            }

            
            {
                a = acx.this;
                super();
            }
        };
        h = (new aeb()).a(0x100000, c1);
        b(new ady(context));
        b(new aei(a2));
        b(new aem(aah1));
        b(new adp(context, aah1));
        b(new adk(context, aah1));
        c(new aeg());
        c(new aao());
        c(new aap());
        c(new aav());
        c(new aaw());
        c(new abl());
        c(new abm());
        c(new aco());
        c(new adg());
        a(new abi(context));
        a(new aci(context));
        a(new adt(context));
        a(new adu(context));
        a(new adv(context));
        a(new adw(context));
        a(new adx(context));
        a(new aec());
        a(new aef(b.c()));
        a(new aei(a1));
        a(new aek(aah1));
        a(new aak(context));
        a(new aal());
        a(new aan());
        a(new aas(this));
        a(new aax());
        a(new aay());
        a(new abf(context));
        a(new abh());
        a(new abk());
        a(new abq());
        a(new abs(context));
        a(new acf());
        a(new ach());
        a(new acl());
        a(new acn());
        a(new acp(context));
        a(new acy());
        a(new acz());
        a(new adj());
        a(new adq());
        for (aah1 = i.iterator(); aah1.hasNext();)
        {
            a1 = (xh.e)aah1.next();
            if (aar1.a())
            {
                a(a1.f(), a1.g(), "add macro");
                a(a1.k(), a1.h(), "remove macro");
                a(a1.d(), a1.i(), "add tag");
                a(a1.e(), a1.j(), "remove tag");
            }
            for (int i1 = 0; i1 < a1.f().size(); i1++)
            {
                a2 = (xh.a)a1.f().get(i1);
                c1 = "Unknown";
                context = c1;
                if (aar1.a())
                {
                    context = c1;
                    if (i1 < a1.g().size())
                    {
                        context = (String)a1.g().get(i1);
                    }
                }
                c1 = a(k, a(a2));
                c1.a(a1);
                c1.a(a1, a2);
                c1.a(a1, context);
            }

            int j1 = 0;
            while (j1 < a1.k().size()) 
            {
                a2 = (xh.a)a1.k().get(j1);
                c1 = "Unknown";
                context = c1;
                if (aar1.a())
                {
                    context = c1;
                    if (j1 < a1.h().size())
                    {
                        context = (String)a1.h().get(j1);
                    }
                }
                c1 = a(k, a(a2));
                c1.a(a1);
                c1.b(a1, a2);
                c1.b(a1, context);
                j1++;
            }
        }

        for (context = b.d().entrySet().iterator(); context.hasNext();)
        {
            c1 = (java.util.Map.Entry)context.next();
            aah1 = ((List)c1.getValue()).iterator();
            while (aah1.hasNext()) 
            {
                a1 = (xh.a)aah1.next();
                if (!ado.d((lv.a)a1.b().get(lt.bM.toString())).booleanValue())
                {
                    a(k, (String)c1.getKey()).a(a1);
                }
            }
        }

    }

    private ace a(lv.a a1, Set set, adr adr1)
    {
        if (!a1.l)
        {
            return new ace(a1, true);
        }
        lv.a a4;
        int k1;
        switch (a1.a)
        {
        case 5: // '\005'
        case 6: // '\006'
        default:
            abo.a((new StringBuilder()).append("Unknown type: ").append(a1.a).toString());
            return a;

        case 2: // '\002'
            lv.a a2 = xh.a(a1);
            a2.c = new lv.a[a1.c.length];
            for (int i1 = 0; i1 < a1.c.length; i1++)
            {
                ace ace1 = a(a1.c[i1], set, adr1.a(i1));
                if (ace1 == a)
                {
                    return a;
                }
                a2.c[i1] = (lv.a)ace1.a();
            }

            return new ace(a2, false);

        case 3: // '\003'
            lv.a a3 = xh.a(a1);
            if (a1.d.length != a1.e.length)
            {
                abo.a((new StringBuilder()).append("Invalid serving value: ").append(a1.toString()).toString());
                return a;
            }
            a3.d = new lv.a[a1.d.length];
            a3.e = new lv.a[a1.d.length];
            for (int j1 = 0; j1 < a1.d.length; j1++)
            {
                ace ace2 = a(a1.d[j1], set, adr1.b(j1));
                ace ace4 = a(a1.e[j1], set, adr1.c(j1));
                if (ace2 == a || ace4 == a)
                {
                    return a;
                }
                a3.d[j1] = (lv.a)ace2.a();
                a3.e[j1] = (lv.a)ace4.a();
            }

            return new ace(a3, false);

        case 4: // '\004'
            if (set.contains(a1.f))
            {
                abo.a((new StringBuilder()).append("Macro cycle detected.  Current macro reference: ").append(a1.f).append(".").append("  Previous macro references: ").append(set.toString()).append(".").toString());
                return a;
            } else
            {
                set.add(a1.f);
                adr1 = ads.a(a(a1.f, set, adr1.a()), a1.k);
                set.remove(a1.f);
                return adr1;
            }

        case 7: // '\007'
            a4 = xh.a(a1);
            a4.j = new lv.a[a1.j.length];
            k1 = 0;
            break;
        }
        for (; k1 < a1.j.length; k1++)
        {
            ace ace3 = a(a1.j[k1], set, adr1.d(k1));
            if (ace3 == a)
            {
                return a;
            }
            a4.j[k1] = (lv.a)ace3.a();
        }

        return new ace(a4, false);
    }

    private ace a(String s, Set set, abr abr1)
    {
        m = m + 1;
        Object obj = (b)h.a(s);
        if (obj != null && !c.a())
        {
            a(((b) (obj)).b(), set);
            m = m - 1;
            return ((b) (obj)).a();
        }
        obj = (c)k.get(s);
        if (obj == null)
        {
            abo.a((new StringBuilder()).append(b()).append("Invalid macro: ").append(s).toString());
            m = m - 1;
            return a;
        }
        ace ace1 = a(s, ((c) (obj)).a(), ((c) (obj)).b(), ((c) (obj)).c(), ((c) (obj)).e(), ((c) (obj)).d(), set, abr1.b());
        if (((Set)ace1.a()).isEmpty())
        {
            obj = ((c) (obj)).f();
        } else
        {
            if (((Set)ace1.a()).size() > 1)
            {
                abo.b((new StringBuilder()).append(b()).append("Multiple macros active for macroName ").append(s).toString());
            }
            obj = (xh.a)((Set)ace1.a()).iterator().next();
        }
        if (obj == null)
        {
            m = m - 1;
            return a;
        }
        abr1 = a(f, ((xh.a) (obj)), set, abr1.a());
        boolean flag;
        if (ace1.b() && abr1.b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (abr1 == a)
        {
            abr1 = a;
        } else
        {
            abr1 = new ace(abr1.a(), flag);
        }
        obj = ((xh.a) (obj)).c();
        if (abr1.b())
        {
            h.a(s, new b(abr1, ((lv.a) (obj))));
        }
        a(((lv.a) (obj)), set);
        m = m - 1;
        return abr1;
    }

    private ace a(Map map, xh.a a1, Set set, acq acq1)
    {
        boolean flag1 = true;
        Object obj = (lv.a)a1.b().get(lt.aZ.toString());
        if (obj == null)
        {
            abo.a("No function id in properties");
            map = a;
        } else
        {
            obj = ((lv.a) (obj)).g;
            aat aat1 = (aat)map.get(obj);
            if (aat1 == null)
            {
                abo.a((new StringBuilder()).append(((String) (obj))).append(" has no backing implementation.").toString());
                return a;
            }
            map = (ace)g.a(a1);
            if (map == null || c.a())
            {
                map = new HashMap();
                Iterator iterator = a1.b().entrySet().iterator();
                boolean flag = true;
                while (iterator.hasNext()) 
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    Object obj1 = acq1.a((String)entry.getKey());
                    obj1 = a((lv.a)entry.getValue(), set, ((acs) (obj1)).a((lv.a)entry.getValue()));
                    if (obj1 == a)
                    {
                        return a;
                    }
                    if (((ace) (obj1)).b())
                    {
                        a1.a((String)entry.getKey(), (lv.a)((ace) (obj1)).a());
                    } else
                    {
                        flag = false;
                    }
                    map.put(entry.getKey(), ((ace) (obj1)).a());
                }
                if (!aat1.a(map.keySet()))
                {
                    abo.a((new StringBuilder()).append("Incorrect keys for function ").append(((String) (obj))).append(" required ").append(aat1.c()).append(" had ").append(map.keySet()).toString());
                    return a;
                }
                if (!flag || !aat1.a())
                {
                    flag1 = false;
                }
                map = new ace(aat1.a(map), flag1);
                if (flag1)
                {
                    g.a(a1, map);
                }
                acq1.a((lv.a)map.a());
                return map;
            }
        }
        return map;
    }

    private ace a(Set set, Set set1, a a1, acw acw1)
    {
        HashSet hashset = new HashSet();
        HashSet hashset1 = new HashSet();
        set = set.iterator();
        boolean flag = true;
        while (set.hasNext()) 
        {
            xh.e e1 = (xh.e)set.next();
            act act1 = acw1.a();
            ace ace1 = a(e1, set1, act1);
            if (((Boolean)ace1.a()).booleanValue())
            {
                a1.a(e1, hashset, hashset1, act1);
            }
            if (flag && ace1.b())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        hashset.removeAll(hashset1);
        acw1.a(hashset);
        return new ace(hashset, flag);
    }

    private static c a(Map map, String s)
    {
        c c2 = (c)map.get(s);
        c c1 = c2;
        if (c2 == null)
        {
            c1 = new c();
            map.put(s, c1);
        }
        return c1;
    }

    private static String a(xh.a a1)
    {
        return ado.a((lv.a)a1.b().get(lt.bk.toString()));
    }

    private void a(lv.a a1, Set set)
    {
        if (a1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((a1 = a(a1, set, ((adr) (new acc())))) != a)
        {
            a1 = ((lv.a) (ado.e((lv.a)a1.a())));
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
                        abo.b("pushAfterEvaluate: value not a Map");
                    }
                }
            } else
            {
                abo.b("pushAfterEvaluate: value not a Map or List");
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private static void a(List list, List list1, String s)
    {
        if (list.size() != list1.size())
        {
            abo.c((new StringBuilder()).append("Invalid resource: imbalance of rule names of functions for ").append(s).append(" operation. Using default rule name instead").toString());
        }
    }

    private static void a(Map map, aat aat1)
    {
        if (map.containsKey(aat1.b()))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate function type name: ").append(aat1.b()).toString());
        } else
        {
            map.put(aat1.b(), aat1);
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

    ace a(xh.a a1, Set set, acq acq1)
    {
        a1 = a(e, a1, set, acq1);
        set = ado.d((lv.a)a1.a());
        acq1.a(ado.e(set));
        return new ace(set, a1.b());
    }

    ace a(xh.e e1, Set set, act act1)
    {
        Iterator iterator = e1.c().iterator();
        boolean flag = true;
        while (iterator.hasNext()) 
        {
            ace ace2 = a((xh.a)iterator.next(), set, act1.a());
            if (((Boolean)ace2.a()).booleanValue())
            {
                act1.a(ado.e(Boolean.valueOf(false)));
                return new ace(Boolean.valueOf(false), ace2.b());
            }
            if (flag && ace2.b())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        for (e1 = e1.b().iterator(); e1.hasNext();)
        {
            ace ace1 = a((xh.a)e1.next(), set, act1.b());
            if (!((Boolean)ace1.a()).booleanValue())
            {
                act1.a(ado.e(Boolean.valueOf(false)));
                return new ace(Boolean.valueOf(false), ace1.b());
            }
            if (flag && ace1.b())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }

        act1.a(ado.e(Boolean.valueOf(true)));
        return new ace(Boolean.valueOf(true), flag);
    }

    ace a(String s, Set set, Map map, Map map1, Map map2, Map map3, Set set1, 
            acw acw1)
    {
        return a(set, set1, new a(map, map1, map2, map3) {

            final Map a;
            final Map b;
            final Map c;
            final Map d;
            final acx e;

            public void a(xh.e e1, Set set2, Set set3, act act1)
            {
                List list = (List)a.get(e1);
                List list1 = (List)b.get(e1);
                if (list != null)
                {
                    set2.addAll(list);
                    act1.c().a(list, list1);
                }
                set2 = (List)c.get(e1);
                e1 = (List)d.get(e1);
                if (set2 != null)
                {
                    set3.addAll(set2);
                    act1.d().a(set2, e1);
                }
            }

            
            {
                e = acx.this;
                a = map;
                b = map1;
                c = map2;
                d = map3;
                super();
            }
        }, acw1);
    }

    ace a(Set set, acw acw1)
    {
        return a(set, ((Set) (new HashSet())), new a() {

            final acx a;

            public void a(xh.e e1, Set set1, Set set2, act act1)
            {
                set1.addAll(e1.d());
                set2.addAll(e1.e());
                act1.e().a(e1.d(), e1.i());
                act1.f().a(e1.e(), e1.j());
            }

            
            {
                a = acx.this;
                super();
            }
        }, acw1);
    }

    String a()
    {
        this;
        JVM INSTR monitorenter ;
        String s = l;
        this;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    void a(aat aat1)
    {
        a(f, aat1);
    }

    public void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        c(s);
        s = c.b(s);
        aej aej1 = s.b();
        xh.a a1;
        for (Iterator iterator = ((Set)a(i, aej1.b()).a()).iterator(); iterator.hasNext(); a(d, a1, ((Set) (new HashSet())), aej1.a()))
        {
            a1 = (xh.a)iterator.next();
        }

        break MISSING_BLOCK_LABEL_103;
        s;
        throw s;
        s.c();
        c(((String) (null)));
        this;
        JVM INSTR monitorexit ;
    }

    public ace b(String s)
    {
        m = 0;
        aaq aaq1 = c.a(s);
        s = a(s, new HashSet(), aaq1.a());
        aaq1.c();
        return s;
    }

    void b(aat aat1)
    {
        a(d, aat1);
    }

    void c(aat aat1)
    {
        a(e, aat1);
    }

    void c(String s)
    {
        this;
        JVM INSTR monitorenter ;
        l = s;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

}
