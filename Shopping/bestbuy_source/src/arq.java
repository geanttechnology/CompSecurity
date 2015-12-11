// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

class arq
{

    private static final arf a = new arf(arz.a(), true);
    private final aqo b;
    private final Map c;
    private final Map d;
    private final Map e;
    private final asc f;
    private final asc g;
    private final Set h;
    private final aqg i;
    private final Map j;
    private volatile String k;
    private int l;

    private arf a(String s, Set set, aqx aqx1)
    {
        l = l + 1;
        Object obj = (ars)g.a(s);
        if (obj != null && !b.a())
        {
            a(((ars) (obj)).b(), set);
            l = l - 1;
            return ((ars) (obj)).a();
        }
        obj = (art)j.get(s);
        if (obj == null)
        {
            aqv.a((new StringBuilder()).append(a()).append("Invalid macro: ").append(s).toString());
            l = l - 1;
            return a;
        }
        arf arf1 = a(s, ((art) (obj)).a(), ((art) (obj)).b(), ((art) (obj)).c(), ((art) (obj)).e(), ((art) (obj)).d(), set, aqx1.b());
        if (((Set)arf1.a()).isEmpty())
        {
            obj = ((art) (obj)).f();
        } else
        {
            if (((Set)arf1.a()).size() > 1)
            {
                aqv.b((new StringBuilder()).append(a()).append("Multiple macros active for macroName ").append(s).toString());
            }
            obj = (arn)((Set)arf1.a()).iterator().next();
        }
        if (obj == null)
        {
            l = l - 1;
            return a;
        }
        aqx1 = a(e, ((arn) (obj)), set, aqx1.a());
        boolean flag;
        if (arf1.b() && aqx1.b())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (aqx1 == a)
        {
            aqx1 = a;
        } else
        {
            aqx1 = new arf(aqx1.a(), flag);
        }
        obj = ((arn) (obj)).b();
        if (aqx1.b())
        {
            g.a(s, new ars(aqx1, ((wk) (obj))));
        }
        a(((wk) (obj)), set);
        l = l - 1;
        return aqx1;
    }

    private arf a(Map map, arn arn1, Set set, ari ari1)
    {
        boolean flag1 = true;
        Object obj = (wk)arn1.a().get(tl.aL.toString());
        if (obj == null)
        {
            aqv.a("No function id in properties");
            map = a;
        } else
        {
            obj = ((wk) (obj)).g;
            aqp aqp1 = (aqp)map.get(obj);
            if (aqp1 == null)
            {
                aqv.a((new StringBuilder()).append(((String) (obj))).append(" has no backing implementation.").toString());
                return a;
            }
            map = (arf)f.a(arn1);
            if (map == null || b.a())
            {
                map = new HashMap();
                Iterator iterator = arn1.a().entrySet().iterator();
                boolean flag = true;
                while (iterator.hasNext()) 
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    Object obj1 = ari1.a((String)entry.getKey());
                    obj1 = a((wk)entry.getValue(), set, ((ark) (obj1)).a((wk)entry.getValue()));
                    if (obj1 == a)
                    {
                        return a;
                    }
                    if (((arf) (obj1)).b())
                    {
                        arn1.a((String)entry.getKey(), (wk)((arf) (obj1)).a());
                    } else
                    {
                        flag = false;
                    }
                    map.put(entry.getKey(), ((arf) (obj1)).a());
                }
                if (!aqp1.a(map.keySet()))
                {
                    aqv.a((new StringBuilder()).append("Incorrect keys for function ").append(((String) (obj))).append(" required ").append(aqp1.b()).append(" had ").append(map.keySet()).toString());
                    return a;
                }
                if (!flag || !aqp1.a())
                {
                    flag1 = false;
                }
                map = new arf(aqp1.a(map), flag1);
                if (flag1)
                {
                    f.a(arn1, map);
                }
                ari1.a((wk)map.a());
                return map;
            }
        }
        return map;
    }

    private arf a(Set set, Set set1, arr arr1, arp arp1)
    {
        HashSet hashset = new HashSet();
        HashSet hashset1 = new HashSet();
        set = set.iterator();
        boolean flag = true;
        while (set.hasNext()) 
        {
            aro aro1 = (aro)set.next();
            arl arl1 = arp1.a();
            arf arf1 = a(aro1, set1, arl1);
            if (((Boolean)arf1.a()).booleanValue())
            {
                arr1.a(aro1, hashset, hashset1, arl1);
            }
            if (flag && arf1.b())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        hashset.removeAll(hashset1);
        arp1.a(hashset);
        return new arf(hashset, flag);
    }

    private arf a(wk wk1, Set set, asa asa1)
    {
        if (!wk1.l)
        {
            return new arf(wk1, true);
        }
        wk wk4;
        int k1;
        switch (wk1.a)
        {
        case 5: // '\005'
        case 6: // '\006'
        default:
            aqv.a((new StringBuilder()).append("Unknown type: ").append(wk1.a).toString());
            return a;

        case 2: // '\002'
            wk wk2 = arm.a(wk1);
            wk2.c = new wk[wk1.c.length];
            for (int i1 = 0; i1 < wk1.c.length; i1++)
            {
                arf arf1 = a(wk1.c[i1], set, asa1.a(i1));
                if (arf1 == a)
                {
                    return a;
                }
                wk2.c[i1] = (wk)arf1.a();
            }

            return new arf(wk2, false);

        case 3: // '\003'
            wk wk3 = arm.a(wk1);
            if (wk1.d.length != wk1.e.length)
            {
                aqv.a((new StringBuilder()).append("Invalid serving value: ").append(wk1.toString()).toString());
                return a;
            }
            wk3.d = new wk[wk1.d.length];
            wk3.e = new wk[wk1.d.length];
            for (int j1 = 0; j1 < wk1.d.length; j1++)
            {
                arf arf2 = a(wk1.d[j1], set, asa1.b(j1));
                arf arf4 = a(wk1.e[j1], set, asa1.c(j1));
                if (arf2 == a || arf4 == a)
                {
                    return a;
                }
                wk3.d[j1] = (wk)arf2.a();
                wk3.e[j1] = (wk)arf4.a();
            }

            return new arf(wk3, false);

        case 4: // '\004'
            if (set.contains(wk1.f))
            {
                aqv.a((new StringBuilder()).append("Macro cycle detected.  Current macro reference: ").append(wk1.f).append(".").append("  Previous macro references: ").append(set.toString()).append(".").toString());
                return a;
            } else
            {
                set.add(wk1.f);
                asa1 = asb.a(a(wk1.f, set, asa1.a()), wk1.k);
                set.remove(wk1.f);
                return asa1;
            }

        case 7: // '\007'
            wk4 = arm.a(wk1);
            wk4.j = new wk[wk1.j.length];
            k1 = 0;
            break;
        }
        for (; k1 < wk1.j.length; k1++)
        {
            arf arf3 = a(wk1.j[k1], set, asa1.d(k1));
            if (arf3 == a)
            {
                return a;
            }
            wk4.j[k1] = (wk)arf3.a();
        }

        return new arf(wk4, false);
    }

    private String a()
    {
        if (l <= 1)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(Integer.toString(l));
        for (int i1 = 2; i1 < l; i1++)
        {
            stringbuilder.append(' ');
        }

        stringbuilder.append(": ");
        return stringbuilder.toString();
    }

    private void a(wk wk1, Set set)
    {
        if (wk1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((wk1 = a(wk1, set, ((asa) (new are())))) != a)
        {
            wk1 = ((wk) (arz.c((wk)wk1.a())));
            if (wk1 instanceof Map)
            {
                wk1 = (Map)wk1;
                i.a(wk1);
                return;
            }
            if (wk1 instanceof List)
            {
                wk1 = ((List)wk1).iterator();
                while (wk1.hasNext()) 
                {
                    set = ((Set) (wk1.next()));
                    if (set instanceof Map)
                    {
                        set = (Map)set;
                        i.a(set);
                    } else
                    {
                        aqv.b("pushAfterEvaluate: value not a Map");
                    }
                }
            } else
            {
                aqv.b("pushAfterEvaluate: value not a Map or List");
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    arf a(arn arn1, Set set, ari ari1)
    {
        arn1 = a(d, arn1, set, ari1);
        set = arz.b((wk)arn1.a());
        ari1.a(arz.c(set));
        return new arf(set, arn1.b());
    }

    arf a(aro aro1, Set set, arl arl1)
    {
        Iterator iterator = aro1.b().iterator();
        boolean flag = true;
        while (iterator.hasNext()) 
        {
            arf arf2 = a((arn)iterator.next(), set, arl1.a());
            if (((Boolean)arf2.a()).booleanValue())
            {
                arl1.a(arz.c(Boolean.valueOf(false)));
                return new arf(Boolean.valueOf(false), arf2.b());
            }
            if (flag && arf2.b())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        for (aro1 = aro1.a().iterator(); aro1.hasNext();)
        {
            arf arf1 = a((arn)aro1.next(), set, arl1.b());
            if (!((Boolean)arf1.a()).booleanValue())
            {
                arl1.a(arz.c(Boolean.valueOf(false)));
                return new arf(Boolean.valueOf(false), arf1.b());
            }
            if (flag && arf1.b())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }

        arl1.a(arz.c(Boolean.valueOf(true)));
        return new arf(Boolean.valueOf(true), flag);
    }

    arf a(String s, Set set, Map map, Map map1, Map map2, Map map3, Set set1, 
            arp arp1)
    {
        return a(set, set1, new arr(map, map1, map2, map3) {

            final Map a;
            final Map b;
            final Map c;
            final Map d;
            final arq e;

            public void a(aro aro1, Set set2, Set set3, arl arl1)
            {
                List list = (List)a.get(aro1);
                List list1 = (List)b.get(aro1);
                if (list != null)
                {
                    set2.addAll(list);
                    arl1.c().a(list, list1);
                }
                set2 = (List)c.get(aro1);
                aro1 = (List)d.get(aro1);
                if (set2 != null)
                {
                    set3.addAll(set2);
                    arl1.d().a(set2, aro1);
                }
            }

            
            {
                e = arq.this;
                a = map;
                b = map1;
                c = map2;
                d = map3;
                super();
            }
        }, arp1);
    }

    arf a(Set set, arp arp1)
    {
        return a(set, ((Set) (new HashSet())), new arr() {

            final arq a;

            public void a(aro aro1, Set set1, Set set2, arl arl1)
            {
                set1.addAll(aro1.c());
                set2.addAll(aro1.d());
                arl1.e().a(aro1.c(), aro1.f());
                arl1.f().a(aro1.d(), aro1.g());
            }

            
            {
                a = arq.this;
                super();
            }
        }, arp1);
    }

    public void a(String s)
    {
        this;
        JVM INSTR monitorenter ;
        b(s);
        s = b.a(s);
        ash ash1 = s.a();
        arn arn1;
        for (Iterator iterator = ((Set)a(h, ash1.b()).a()).iterator(); iterator.hasNext(); a(c, arn1, ((Set) (new HashSet())), ash1.a()))
        {
            arn1 = (arn)iterator.next();
        }

        break MISSING_BLOCK_LABEL_103;
        s;
        throw s;
        s.b();
        b(null);
        this;
        JVM INSTR monitorexit ;
    }

    void b(String s)
    {
        this;
        JVM INSTR monitorenter ;
        k = s;
        this;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

}
