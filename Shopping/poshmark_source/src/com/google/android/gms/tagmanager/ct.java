// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            by, di, l, i, 
//            s, w, dj, q, 
//            ad, ae, al, am, 
//            bd, be, ci, dc, 
//            b, c, e, f, 
//            g, h, m, p, 
//            u, z, aa, ac, 
//            ah, an, ao, ax, 
//            az, bc, bk, bz, 
//            cc, cf, ch, cj, 
//            cu, cv, de, ag, 
//            bh, cr, dk, dl, 
//            k, bj, aj, ck, 
//            cm, cs, bw, DataLayer, 
//            cn, af, t, ai, 
//            cl

class ct
{
    static interface a
    {

        public abstract void a(cr.e e1, Set set, Set set1, cn cn1);
    }

    private static class b
    {

        private by WY;
        private com.google.android.gms.internal.d.a Wt;

        public int getSize()
        {
            int i1 = ((com.google.android.gms.internal.d.a)WY.getObject()).eW();
            int j;
            if (Wt == null)
            {
                j = 0;
            } else
            {
                j = Wt.eW();
            }
            return j + i1;
        }

        public com.google.android.gms.internal.d.a jG()
        {
            return Wt;
        }

        public by ka()
        {
            return WY;
        }

        public b(by by1, com.google.android.gms.internal.d.a a1)
        {
            WY = by1;
            Wt = a1;
        }
    }

    private static class c
    {

        private final Set WP = new HashSet();
        private final Map WZ = new HashMap();
        private final Map Xa = new HashMap();
        private final Map Xb = new HashMap();
        private final Map Xc = new HashMap();
        private cr.a Xd;

        public void a(cr.e e1, cr.a a1)
        {
            List list = (List)WZ.get(e1);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                WZ.put(e1, obj);
            }
            ((List) (obj)).add(a1);
        }

        public void a(cr.e e1, String s1)
        {
            List list = (List)Xb.get(e1);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                Xb.put(e1, obj);
            }
            ((List) (obj)).add(s1);
        }

        public void b(cr.e e1)
        {
            WP.add(e1);
        }

        public void b(cr.e e1, cr.a a1)
        {
            List list = (List)Xa.get(e1);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                Xa.put(e1, obj);
            }
            ((List) (obj)).add(a1);
        }

        public void b(cr.e e1, String s1)
        {
            List list = (List)Xc.get(e1);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                Xc.put(e1, obj);
            }
            ((List) (obj)).add(s1);
        }

        public void i(cr.a a1)
        {
            Xd = a1;
        }

        public Set kb()
        {
            return WP;
        }

        public Map kc()
        {
            return WZ;
        }

        public Map kd()
        {
            return Xb;
        }

        public Map ke()
        {
            return Xc;
        }

        public Map kf()
        {
            return Xa;
        }

        public cr.a kg()
        {
            return Xd;
        }

        public c()
        {
        }
    }


    private static final by WH = new by(di.ku(), true);
    private final DataLayer TN;
    private final cr.c WI;
    private final ag WJ;
    private final Map WK = new HashMap();
    private final Map WL = new HashMap();
    private final Map WM = new HashMap();
    private final k WN;
    private final k WO;
    private final Set WP;
    private final Map WQ = new HashMap();
    private volatile String WR;
    private int WS;

    public ct(Context context, cr.c c1, DataLayer datalayer, s.a a1, s.a a2, ag ag1)
    {
        if (c1 == null)
        {
            throw new NullPointerException("resource cannot be null");
        }
        WI = c1;
        WP = new HashSet(c1.jJ());
        TN = datalayer;
        WJ = ag1;
        c1 = new l.a() {

            final ct WT;

            public int a(cr.a a3, by by1)
            {
                return ((com.google.android.gms.internal.d.a)by1.getObject()).eW();
            }

            public int sizeOf(Object obj, Object obj1)
            {
                return a((cr.a)obj, (by)obj1);
            }

            
            {
                WT = ct.this;
                super();
            }
        };
        WN = (new l()).a(0x100000, c1);
        c1 = new l.a() {

            final ct WT;

            public int a(String s1, b b1)
            {
                return s1.length() + b1.getSize();
            }

            public int sizeOf(Object obj, Object obj1)
            {
                return a((String)obj, (b)obj1);
            }

            
            {
                WT = ct.this;
                super();
            }
        };
        WO = (new l()).a(0x100000, c1);
        b(new i(context));
        b(new s(a2));
        b(new w(datalayer));
        b(new dj(context, datalayer));
        c(new q());
        c(new ad());
        c(new ae());
        c(new al());
        c(new am());
        c(new bd());
        c(new be());
        c(new ci());
        c(new dc());
        a(new com.google.android.gms.tagmanager.b(context));
        a(new com.google.android.gms.tagmanager.c(context));
        a(new e(context));
        a(new f(context));
        a(new g(context));
        a(new h(context));
        a(new m());
        a(new p(WI.getVersion()));
        a(new s(a1));
        a(new u(datalayer));
        a(new z(context));
        a(new aa());
        a(new ac());
        a(new ah(this));
        a(new an());
        a(new ao());
        a(new ax(context));
        a(new az());
        a(new bc());
        a(new bk(context));
        a(new bz());
        a(new cc());
        a(new cf());
        a(new ch());
        a(new cj(context));
        a(new cu());
        a(new cv());
        a(new de());
        for (datalayer = WP.iterator(); datalayer.hasNext();)
        {
            a1 = (cr.e)datalayer.next();
            if (ag1.jb())
            {
                a(a1.jR(), a1.jS(), "add macro");
                a(a1.jW(), a1.jT(), "remove macro");
                a(a1.jP(), a1.jU(), "add tag");
                a(a1.jQ(), a1.jV(), "remove tag");
            }
            for (int j = 0; j < a1.jR().size(); j++)
            {
                a2 = (cr.a)a1.jR().get(j);
                c1 = "Unknown";
                context = c1;
                if (ag1.jb())
                {
                    context = c1;
                    if (j < a1.jS().size())
                    {
                        context = (String)a1.jS().get(j);
                    }
                }
                c1 = c(WQ, h(a2));
                c1.b(a1);
                c1.a(a1, a2);
                c1.a(a1, context);
            }

            int i1 = 0;
            while (i1 < a1.jW().size()) 
            {
                a2 = (cr.a)a1.jW().get(i1);
                c1 = "Unknown";
                context = c1;
                if (ag1.jb())
                {
                    context = c1;
                    if (i1 < a1.jT().size())
                    {
                        context = (String)a1.jT().get(i1);
                    }
                }
                c1 = c(WQ, h(a2));
                c1.b(a1);
                c1.b(a1, a2);
                c1.b(a1, context);
                i1++;
            }
        }

        for (context = WI.jK().entrySet().iterator(); context.hasNext();)
        {
            c1 = (java.util.Map.Entry)context.next();
            datalayer = ((List)c1.getValue()).iterator();
            while (datalayer.hasNext()) 
            {
                a1 = (cr.a)datalayer.next();
                if (!di.n((com.google.android.gms.internal.d.a)a1.jF().get(com.google.android.gms.internal.b.ds.toString())).booleanValue())
                {
                    c(WQ, (String)c1.getKey()).i(a1);
                }
            }
        }

    }

    private by a(com.google.android.gms.internal.d.a a1, Set set, dk dk1)
    {
        if (!a1.gi)
        {
            return new by(a1, true);
        }
        com.google.android.gms.internal.d.a a4;
        int j1;
        switch (a1.type)
        {
        case 5: // '\005'
        case 6: // '\006'
        default:
            bh.t((new StringBuilder()).append("Unknown type: ").append(a1.type).toString());
            return WH;

        case 2: // '\002'
            com.google.android.gms.internal.d.a a2 = cr.g(a1);
            a2.fZ = new com.google.android.gms.internal.d.a[a1.fZ.length];
            for (int j = 0; j < a1.fZ.length; j++)
            {
                by by1 = a(a1.fZ[j], set, dk1.bS(j));
                if (by1 == WH)
                {
                    return WH;
                }
                a2.fZ[j] = (com.google.android.gms.internal.d.a)by1.getObject();
            }

            return new by(a2, false);

        case 3: // '\003'
            com.google.android.gms.internal.d.a a3 = cr.g(a1);
            if (a1.ga.length != a1.gb.length)
            {
                bh.t((new StringBuilder()).append("Invalid serving value: ").append(a1.toString()).toString());
                return WH;
            }
            a3.ga = new com.google.android.gms.internal.d.a[a1.ga.length];
            a3.gb = new com.google.android.gms.internal.d.a[a1.ga.length];
            for (int i1 = 0; i1 < a1.ga.length; i1++)
            {
                by by2 = a(a1.ga[i1], set, dk1.bT(i1));
                by by4 = a(a1.gb[i1], set, dk1.bU(i1));
                if (by2 == WH || by4 == WH)
                {
                    return WH;
                }
                a3.ga[i1] = (com.google.android.gms.internal.d.a)by2.getObject();
                a3.gb[i1] = (com.google.android.gms.internal.d.a)by4.getObject();
            }

            return new by(a3, false);

        case 4: // '\004'
            if (set.contains(a1.gc))
            {
                bh.t((new StringBuilder()).append("Macro cycle detected.  Current macro reference: ").append(a1.gc).append(".").append("  Previous macro references: ").append(set.toString()).append(".").toString());
                return WH;
            } else
            {
                set.add(a1.gc);
                dk1 = dl.a(a(a1.gc, set, dk1.jq()), a1.gh);
                set.remove(a1.gc);
                return dk1;
            }

        case 7: // '\007'
            a4 = cr.g(a1);
            a4.gg = new com.google.android.gms.internal.d.a[a1.gg.length];
            j1 = 0;
            break;
        }
        for (; j1 < a1.gg.length; j1++)
        {
            by by3 = a(a1.gg[j1], set, dk1.bV(j1));
            if (by3 == WH)
            {
                return WH;
            }
            a4.gg[j1] = (com.google.android.gms.internal.d.a)by3.getObject();
        }

        return new by(a4, false);
    }

    private by a(String s1, Set set, bj bj1)
    {
        WS = WS + 1;
        Object obj = (b)WO.get(s1);
        if (obj != null && !WJ.jb())
        {
            a(((b) (obj)).jG(), set);
            WS = WS - 1;
            return ((b) (obj)).ka();
        }
        obj = (c)WQ.get(s1);
        if (obj == null)
        {
            bh.t((new StringBuilder()).append(jZ()).append("Invalid macro: ").append(s1).toString());
            WS = WS - 1;
            return WH;
        }
        by by1 = a(s1, ((c) (obj)).kb(), ((c) (obj)).kc(), ((c) (obj)).kd(), ((c) (obj)).kf(), ((c) (obj)).ke(), set, bj1.iS());
        if (((Set)by1.getObject()).isEmpty())
        {
            obj = ((c) (obj)).kg();
        } else
        {
            if (((Set)by1.getObject()).size() > 1)
            {
                bh.w((new StringBuilder()).append(jZ()).append("Multiple macros active for macroName ").append(s1).toString());
            }
            obj = (cr.a)((Set)by1.getObject()).iterator().next();
        }
        if (obj == null)
        {
            WS = WS - 1;
            return WH;
        }
        bj1 = a(WM, ((cr.a) (obj)), set, bj1.jh());
        boolean flag;
        if (by1.jr() && bj1.jr())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (bj1 == WH)
        {
            bj1 = WH;
        } else
        {
            bj1 = new by(bj1.getObject(), flag);
        }
        obj = ((cr.a) (obj)).jG();
        if (bj1.jr())
        {
            WO.e(s1, new b(bj1, ((com.google.android.gms.internal.d.a) (obj))));
        }
        a(((com.google.android.gms.internal.d.a) (obj)), set);
        WS = WS - 1;
        return bj1;
    }

    private by a(Map map, cr.a a1, Set set, ck ck1)
    {
        boolean flag1 = true;
        Object obj = (com.google.android.gms.internal.d.a)a1.jF().get(com.google.android.gms.internal.b.cI.toString());
        if (obj == null)
        {
            bh.t("No function id in properties");
            map = WH;
        } else
        {
            obj = ((com.google.android.gms.internal.d.a) (obj)).gd;
            aj aj1 = (aj)map.get(obj);
            if (aj1 == null)
            {
                bh.t((new StringBuilder()).append(((String) (obj))).append(" has no backing implementation.").toString());
                return WH;
            }
            map = (by)WN.get(a1);
            if (map == null || WJ.jb())
            {
                map = new HashMap();
                Iterator iterator = a1.jF().entrySet().iterator();
                boolean flag = true;
                while (iterator.hasNext()) 
                {
                    java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
                    Object obj1 = ck1.bs((String)entry.getKey());
                    obj1 = a((com.google.android.gms.internal.d.a)entry.getValue(), set, ((cm) (obj1)).e((com.google.android.gms.internal.d.a)entry.getValue()));
                    if (obj1 == WH)
                    {
                        return WH;
                    }
                    if (((by) (obj1)).jr())
                    {
                        a1.a((String)entry.getKey(), (com.google.android.gms.internal.d.a)((by) (obj1)).getObject());
                    } else
                    {
                        flag = false;
                    }
                    map.put(entry.getKey(), ((by) (obj1)).getObject());
                }
                if (!aj1.a(map.keySet()))
                {
                    bh.t((new StringBuilder()).append("Incorrect keys for function ").append(((String) (obj))).append(" required ").append(aj1.jd()).append(" had ").append(map.keySet()).toString());
                    return WH;
                }
                if (!flag || !aj1.iy())
                {
                    flag1 = false;
                }
                map = new by(aj1.u(map), flag1);
                if (flag1)
                {
                    WN.e(a1, map);
                }
                ck1.d((com.google.android.gms.internal.d.a)map.getObject());
                return map;
            }
        }
        return map;
    }

    private by a(Set set, Set set1, a a1, cs cs1)
    {
        HashSet hashset = new HashSet();
        HashSet hashset1 = new HashSet();
        set = set.iterator();
        boolean flag = true;
        while (set.hasNext()) 
        {
            cr.e e1 = (cr.e)set.next();
            cn cn1 = cs1.jp();
            by by1 = a(e1, set1, cn1);
            if (((Boolean)by1.getObject()).booleanValue())
            {
                a1.a(e1, hashset, hashset1, cn1);
            }
            if (flag && by1.jr())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        hashset.removeAll(hashset1);
        cs1.b(hashset);
        return new by(hashset, flag);
    }

    private void a(com.google.android.gms.internal.d.a a1, Set set)
    {
        if (a1 != null) goto _L2; else goto _L1
_L1:
        return;
_L2:
        if ((a1 = a(a1, set, ((dk) (new bw())))) != WH)
        {
            a1 = ((com.google.android.gms.internal.d.a) (di.o((com.google.android.gms.internal.d.a)a1.getObject())));
            if (a1 instanceof Map)
            {
                a1 = (Map)a1;
                TN.push(a1);
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
                        TN.push(set);
                    } else
                    {
                        bh.w("pushAfterEvaluate: value not a Map");
                    }
                }
            } else
            {
                bh.w("pushAfterEvaluate: value not a Map or List");
                return;
            }
        }
        if (true) goto _L1; else goto _L3
_L3:
    }

    private static void a(List list, List list1, String s1)
    {
        if (list.size() != list1.size())
        {
            bh.u((new StringBuilder()).append("Invalid resource: imbalance of rule names of functions for ").append(s1).append(" operation. Using default rule name instead").toString());
        }
    }

    private static void a(Map map, aj aj1)
    {
        if (map.containsKey(aj1.jc()))
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Duplicate function type name: ").append(aj1.jc()).toString());
        } else
        {
            map.put(aj1.jc(), aj1);
            return;
        }
    }

    private static c c(Map map, String s1)
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

    private static String h(cr.a a1)
    {
        return di.j((com.google.android.gms.internal.d.a)a1.jF().get(com.google.android.gms.internal.b.cT.toString()));
    }

    private String jZ()
    {
        if (WS <= 1)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append(Integer.toString(WS));
        for (int j = 2; j < WS; j++)
        {
            stringbuilder.append(' ');
        }

        stringbuilder.append(": ");
        return stringbuilder.toString();
    }

    by a(cr.a a1, Set set, ck ck1)
    {
        a1 = a(WL, a1, set, ck1);
        set = di.n((com.google.android.gms.internal.d.a)a1.getObject());
        ck1.d(di.r(set));
        return new by(set, a1.jr());
    }

    by a(cr.e e1, Set set, cn cn1)
    {
        Iterator iterator = e1.jO().iterator();
        boolean flag = true;
        while (iterator.hasNext()) 
        {
            by by2 = a((cr.a)iterator.next(), set, cn1.jj());
            if (((Boolean)by2.getObject()).booleanValue())
            {
                cn1.f(di.r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), by2.jr());
            }
            if (flag && by2.jr())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }
        for (e1 = e1.jN().iterator(); e1.hasNext();)
        {
            by by1 = a((cr.a)e1.next(), set, cn1.jk());
            if (!((Boolean)by1.getObject()).booleanValue())
            {
                cn1.f(di.r(Boolean.valueOf(false)));
                return new by(Boolean.valueOf(false), by1.jr());
            }
            if (flag && by1.jr())
            {
                flag = true;
            } else
            {
                flag = false;
            }
        }

        cn1.f(di.r(Boolean.valueOf(true)));
        return new by(Boolean.valueOf(true), flag);
    }

    by a(String s1, Set set, Map map, Map map1, Map map2, Map map3, Set set1, 
            cs cs1)
    {
        return a(set, set1, new a(map, map1, map2, map3) {

            final ct WT;
            final Map WU;
            final Map WV;
            final Map WW;
            final Map WX;

            public void a(cr.e e1, Set set2, Set set3, cn cn1)
            {
                List list = (List)WU.get(e1);
                List list1 = (List)WV.get(e1);
                if (list != null)
                {
                    set2.addAll(list);
                    cn1.jl().b(list, list1);
                }
                set2 = (List)WW.get(e1);
                e1 = (List)WX.get(e1);
                if (set2 != null)
                {
                    set3.addAll(set2);
                    cn1.jm().b(set2, e1);
                }
            }

            
            {
                WT = ct.this;
                WU = map;
                WV = map1;
                WW = map2;
                WX = map3;
                super();
            }
        }, cs1);
    }

    by a(Set set, cs cs1)
    {
        return a(set, ((Set) (new HashSet())), new a() {

            final ct WT;

            public void a(cr.e e1, Set set1, Set set2, cn cn1)
            {
                set1.addAll(e1.jP());
                set2.addAll(e1.jQ());
                cn1.jn().b(e1.jP(), e1.jU());
                cn1.jo().b(e1.jQ(), e1.jV());
            }

            
            {
                WT = ct.this;
                super();
            }
        }, cs1);
    }

    void a(aj aj1)
    {
        a(WM, aj1);
    }

    void b(aj aj1)
    {
        a(WK, aj1);
    }

    public by bC(String s1)
    {
        WS = 0;
        af af1 = WJ.bl(s1);
        s1 = a(s1, new HashSet(), af1.iY());
        af1.ja();
        return s1;
    }

    void bD(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        WR = s1;
        this;
        JVM INSTR monitorexit ;
        return;
        s1;
        throw s1;
    }

    public void ba(String s1)
    {
        this;
        JVM INSTR monitorenter ;
        bD(s1);
        s1 = WJ.bm(s1);
        t t1 = s1.iZ();
        cr.a a1;
        for (Iterator iterator = ((Set)a(WP, t1.iS()).getObject()).iterator(); iterator.hasNext(); a(WK, a1, new HashSet(), t1.iR()))
        {
            a1 = (cr.a)iterator.next();
        }

        break MISSING_BLOCK_LABEL_103;
        s1;
        throw s1;
        s1.ja();
        bD(null);
        this;
        JVM INSTR monitorexit ;
    }

    void c(aj aj1)
    {
        a(WL, aj1);
    }

    public void f(List list)
    {
        this;
        JVM INSTR monitorenter ;
        list = list.iterator();
_L2:
        com.google.android.gms.internal.c.i j;
        do
        {
            if (!list.hasNext())
            {
                break MISSING_BLOCK_LABEL_90;
            }
            j = (com.google.android.gms.internal.c.i)list.next();
            if (j.name != null && j.name.startsWith("gaExperiment:"))
            {
                break MISSING_BLOCK_LABEL_79;
            }
            bh.v((new StringBuilder()).append("Ignored supplemental: ").append(j).toString());
        } while (true);
        list;
        throw list;
        ai.a(TN, j);
        if (true) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
    }

    String jY()
    {
        this;
        JVM INSTR monitorenter ;
        String s1 = WR;
        this;
        JVM INSTR monitorexit ;
        return s1;
        Exception exception;
        exception;
        throw exception;
    }

}
