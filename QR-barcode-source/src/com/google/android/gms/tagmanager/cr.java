// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            di, bh

class cr
{
    public static class a
    {

        private final Map aqD;
        private final com.google.android.gms.internal.d.a aqE;

        public static b oT()
        {
            return new b();
        }

        public void a(String s, com.google.android.gms.internal.d.a a1)
        {
            aqD.put(s, a1);
        }

        public Map oU()
        {
            return Collections.unmodifiableMap(aqD);
        }

        public com.google.android.gms.internal.d.a oV()
        {
            return aqE;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Properties: ").append(oU()).append(" pushAfterEvaluate: ").append(aqE).toString();
        }

        private a(Map map, com.google.android.gms.internal.d.a a1)
        {
            aqD = map;
            aqE = a1;
        }

    }

    public static class b
    {

        private final Map aqD;
        private com.google.android.gms.internal.d.a aqE;

        public b b(String s, com.google.android.gms.internal.d.a a1)
        {
            aqD.put(s, a1);
            return this;
        }

        public b i(com.google.android.gms.internal.d.a a1)
        {
            aqE = a1;
            return this;
        }

        public a oW()
        {
            return new a(aqD, aqE);
        }

        private b()
        {
            aqD = new HashMap();
        }

    }

    public static class c
    {

        private final String Sx;
        private final List aqF;
        private final Map aqG;
        private final int aqH;

        public static d oX()
        {
            return new d();
        }

        public String getVersion()
        {
            return Sx;
        }

        public List oY()
        {
            return aqF;
        }

        public Map oZ()
        {
            return aqG;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Rules: ").append(oY()).append("  Macros: ").append(aqG).toString();
        }

        private c(List list, Map map, String s, int i)
        {
            aqF = Collections.unmodifiableList(list);
            aqG = Collections.unmodifiableMap(map);
            Sx = s;
            aqH = i;
        }

    }

    public static class d
    {

        private String Sx;
        private final List aqF;
        private final Map aqG;
        private int aqH;

        public d a(a a1)
        {
            String s = di.j((com.google.android.gms.internal.d.a)a1.oU().get(com.google.android.gms.internal.b.df.toString()));
            List list = (List)aqG.get(s);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                aqG.put(s, obj);
            }
            ((List) (obj)).add(a1);
            return this;
        }

        public d a(e e1)
        {
            aqF.add(e1);
            return this;
        }

        public d cM(String s)
        {
            Sx = s;
            return this;
        }

        public d fm(int i)
        {
            aqH = i;
            return this;
        }

        public c pa()
        {
            return new c(aqF, aqG, Sx, aqH);
        }

        private d()
        {
            aqF = new ArrayList();
            aqG = new HashMap();
            Sx = "";
            aqH = 0;
        }

    }

    public static class e
    {

        private final List aqI;
        private final List aqJ;
        private final List aqK;
        private final List aqL;
        private final List aqM;
        private final List aqN;
        private final List aqO;
        private final List aqP;
        private final List aqQ;
        private final List aqR;

        public static f pb()
        {
            return new f();
        }

        public List pc()
        {
            return aqI;
        }

        public List pd()
        {
            return aqJ;
        }

        public List pe()
        {
            return aqK;
        }

        public List pf()
        {
            return aqL;
        }

        public List pg()
        {
            return aqM;
        }

        public List ph()
        {
            return aqO;
        }

        public List pi()
        {
            return aqP;
        }

        public List pj()
        {
            return aqQ;
        }

        public List pk()
        {
            return aqR;
        }

        public List pl()
        {
            return aqN;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Positive predicates: ").append(pc()).append("  Negative predicates: ").append(pd()).append("  Add tags: ").append(pe()).append("  Remove tags: ").append(pf()).append("  Add macros: ").append(pg()).append("  Remove macros: ").append(pl()).toString();
        }

        private e(List list, List list1, List list2, List list3, List list4, List list5, List list6, 
                List list7, List list8, List list9)
        {
            aqI = Collections.unmodifiableList(list);
            aqJ = Collections.unmodifiableList(list1);
            aqK = Collections.unmodifiableList(list2);
            aqL = Collections.unmodifiableList(list3);
            aqM = Collections.unmodifiableList(list4);
            aqN = Collections.unmodifiableList(list5);
            aqO = Collections.unmodifiableList(list6);
            aqP = Collections.unmodifiableList(list7);
            aqQ = Collections.unmodifiableList(list8);
            aqR = Collections.unmodifiableList(list9);
        }

    }

    public static class f
    {

        private final List aqI;
        private final List aqJ;
        private final List aqK;
        private final List aqL;
        private final List aqM;
        private final List aqN;
        private final List aqO;
        private final List aqP;
        private final List aqQ;
        private final List aqR;

        public f b(a a1)
        {
            aqI.add(a1);
            return this;
        }

        public f c(a a1)
        {
            aqJ.add(a1);
            return this;
        }

        public f cN(String s)
        {
            aqQ.add(s);
            return this;
        }

        public f cO(String s)
        {
            aqR.add(s);
            return this;
        }

        public f cP(String s)
        {
            aqO.add(s);
            return this;
        }

        public f cQ(String s)
        {
            aqP.add(s);
            return this;
        }

        public f d(a a1)
        {
            aqK.add(a1);
            return this;
        }

        public f e(a a1)
        {
            aqL.add(a1);
            return this;
        }

        public f f(a a1)
        {
            aqM.add(a1);
            return this;
        }

        public f g(a a1)
        {
            aqN.add(a1);
            return this;
        }

        public e pm()
        {
            return new e(aqI, aqJ, aqK, aqL, aqM, aqN, aqO, aqP, aqQ, aqR);
        }

        private f()
        {
            aqI = new ArrayList();
            aqJ = new ArrayList();
            aqK = new ArrayList();
            aqL = new ArrayList();
            aqM = new ArrayList();
            aqN = new ArrayList();
            aqO = new ArrayList();
            aqP = new ArrayList();
            aqQ = new ArrayList();
            aqR = new ArrayList();
        }

    }

    public static class g extends Exception
    {

        public g(String s)
        {
            super(s);
        }
    }


    private static com.google.android.gms.internal.d.a a(int i, com.google.android.gms.internal.c.f f1, com.google.android.gms.internal.d.a aa[], Set set)
        throws g
    {
        Object obj;
        com.google.android.gms.internal.d.a a1;
        int j1;
        int i2;
        int l2;
        i2 = 0;
        l2 = 0;
        j1 = 0;
        if (set.contains(Integer.valueOf(i)))
        {
            cL((new StringBuilder()).append("Value cycle detected.  Current value reference: ").append(i).append(".").append("  Previous value references: ").append(set).append(".").toString());
        }
        a1 = (com.google.android.gms.internal.d.a)a(((Object []) (f1.fG)), i, "values");
        if (aa[i] != null)
        {
            return aa[i];
        }
        obj = null;
        set.add(Integer.valueOf(i));
        a1.type;
        JVM INSTR tableswitch 1 8: default 152
    //                   1 653
    //                   2 199
    //                   3 291
    //                   4 525
    //                   5 653
    //                   6 653
    //                   7 557
    //                   8 653;
           goto _L1 _L2 _L3 _L4 _L5 _L2 _L2 _L6 _L2
_L1:
        if (obj == null)
        {
            cL((new StringBuilder()).append("Invalid value: ").append(a1).toString());
        }
        aa[i] = ((com.google.android.gms.internal.d.a) (obj));
        set.remove(Integer.valueOf(i));
        return ((com.google.android.gms.internal.d.a) (obj));
_L3:
        obj = h(a1);
        com.google.android.gms.internal.d.a a2 = g(a1);
        a2.gw = new com.google.android.gms.internal.d.a[((com.google.android.gms.internal.c.h) (obj)).gh.length];
        int ai[] = ((com.google.android.gms.internal.c.h) (obj)).gh;
        i2 = ai.length;
        int j = 0;
        do
        {
            obj = a2;
            if (j1 >= i2)
            {
                continue; /* Loop/switch isn't completed */
            }
            l2 = ai[j1];
            a2.gw[j] = a(l2, f1, aa, set);
            j1++;
            j++;
        } while (true);
_L4:
        com.google.android.gms.internal.d.a a3 = g(a1);
        obj = h(a1);
        if (((com.google.android.gms.internal.c.h) (obj)).gi.length != ((com.google.android.gms.internal.c.h) (obj)).gj.length)
        {
            cL((new StringBuilder()).append("Uneven map keys (").append(((com.google.android.gms.internal.c.h) (obj)).gi.length).append(") and map values (").append(((com.google.android.gms.internal.c.h) (obj)).gj.length).append(")").toString());
        }
        a3.gx = new com.google.android.gms.internal.d.a[((com.google.android.gms.internal.c.h) (obj)).gi.length];
        a3.gy = new com.google.android.gms.internal.d.a[((com.google.android.gms.internal.c.h) (obj)).gi.length];
        int ai1[] = ((com.google.android.gms.internal.c.h) (obj)).gi;
        l2 = ai1.length;
        int k1 = 0;
        for (int k = 0; k1 < l2; k++)
        {
            int j3 = ai1[k1];
            a3.gx[k] = a(j3, f1, aa, set);
            k1++;
        }

        ai1 = ((com.google.android.gms.internal.c.h) (obj)).gj;
        l2 = ai1.length;
        int l = 0;
        k1 = i2;
        do
        {
            obj = a3;
            if (k1 >= l2)
            {
                continue; /* Loop/switch isn't completed */
            }
            int j2 = ai1[k1];
            a3.gy[l] = a(j2, f1, aa, set);
            k1++;
            l++;
        } while (true);
_L5:
        obj = g(a1);
        obj.gz = di.j(a(h(a1).gm, f1, aa, set));
        continue; /* Loop/switch isn't completed */
_L6:
        com.google.android.gms.internal.d.a a4 = g(a1);
        obj = h(a1);
        a4.gD = new com.google.android.gms.internal.d.a[((com.google.android.gms.internal.c.h) (obj)).gl.length];
        int ai2[] = ((com.google.android.gms.internal.c.h) (obj)).gl;
        int k2 = ai2.length;
        int i1 = 0;
        int l1 = l2;
        do
        {
            obj = a4;
            if (l1 >= k2)
            {
                continue; /* Loop/switch isn't completed */
            }
            int i3 = ai2[l1];
            a4.gD[i1] = a(i3, f1, aa, set);
            l1++;
            i1++;
        } while (true);
_L2:
        obj = a1;
        if (true) goto _L1; else goto _L7
_L7:
    }

    private static a a(com.google.android.gms.internal.c.b b1, com.google.android.gms.internal.c.f f1, com.google.android.gms.internal.d.a aa[], int i)
        throws g
    {
        b b2 = a.oT();
        b1 = b1.fq;
        int j = b1.length;
        i = 0;
        while (i < j) 
        {
            int k = b1[i];
            Object obj = (com.google.android.gms.internal.c.e)a(((Object []) (f1.fH)), Integer.valueOf(k).intValue(), "properties");
            String s = (String)a(((Object []) (f1.fF)), ((com.google.android.gms.internal.c.e) (obj)).key, "keys");
            obj = (com.google.android.gms.internal.d.a)a(((Object []) (aa)), ((com.google.android.gms.internal.c.e) (obj)).value, "values");
            if (com.google.android.gms.internal.b.ec.toString().equals(s))
            {
                b2.i(((com.google.android.gms.internal.d.a) (obj)));
            } else
            {
                b2.b(s, ((com.google.android.gms.internal.d.a) (obj)));
            }
            i++;
        }
        return b2.oW();
    }

    private static e a(com.google.android.gms.internal.c.g g1, List list, List list1, List list2, com.google.android.gms.internal.c.f f1)
    {
        f f2 = e.pb();
        int ai[] = g1.fV;
        int k2 = ai.length;
        for (int i = 0; i < k2; i++)
        {
            f2.b((a)list2.get(Integer.valueOf(ai[i]).intValue()));
        }

        ai = g1.fW;
        k2 = ai.length;
        for (int j = 0; j < k2; j++)
        {
            f2.c((a)list2.get(Integer.valueOf(ai[j]).intValue()));
        }

        list2 = g1.fX;
        k2 = list2.length;
        for (int k = 0; k < k2; k++)
        {
            f2.d((a)list.get(Integer.valueOf(list2[k]).intValue()));
        }

        list2 = g1.fZ;
        k2 = list2.length;
        for (int l = 0; l < k2; l++)
        {
            int l2 = list2[l];
            f2.cN(f1.fG[Integer.valueOf(l2).intValue()].gv);
        }

        list2 = g1.fY;
        k2 = list2.length;
        for (int i1 = 0; i1 < k2; i1++)
        {
            f2.e((a)list.get(Integer.valueOf(list2[i1]).intValue()));
        }

        list = g1.ga;
        k2 = list.length;
        for (int j1 = 0; j1 < k2; j1++)
        {
            int i3 = list[j1];
            f2.cO(f1.fG[Integer.valueOf(i3).intValue()].gv);
        }

        list = g1.gb;
        k2 = list.length;
        for (int k1 = 0; k1 < k2; k1++)
        {
            f2.f((a)list1.get(Integer.valueOf(list[k1]).intValue()));
        }

        list = g1.gd;
        k2 = list.length;
        for (int l1 = 0; l1 < k2; l1++)
        {
            int j3 = list[l1];
            f2.cP(f1.fG[Integer.valueOf(j3).intValue()].gv);
        }

        list = g1.gc;
        k2 = list.length;
        for (int i2 = 0; i2 < k2; i2++)
        {
            f2.g((a)list1.get(Integer.valueOf(list[i2]).intValue()));
        }

        g1 = g1.ge;
        k2 = g1.length;
        for (int j2 = 0; j2 < k2; j2++)
        {
            int k3 = g1[j2];
            f2.cQ(f1.fG[Integer.valueOf(k3).intValue()].gv);
        }

        return f2.pm();
    }

    private static Object a(Object aobj[], int i, String s)
        throws g
    {
        if (i < 0 || i >= aobj.length)
        {
            cL((new StringBuilder()).append("Index out of bounds detected: ").append(i).append(" in ").append(s).toString());
        }
        return aobj[i];
    }

    public static c b(com.google.android.gms.internal.c.f f1)
        throws g
    {
        boolean flag = false;
        Object aobj[] = new com.google.android.gms.internal.d.a[f1.fG.length];
        for (int i = 0; i < f1.fG.length; i++)
        {
            a(i, f1, ((com.google.android.gms.internal.d.a []) (aobj)), new HashSet(0));
        }

        d d1 = c.oX();
        ArrayList arraylist = new ArrayList();
        for (int j = 0; j < f1.fJ.length; j++)
        {
            arraylist.add(a(f1.fJ[j], f1, ((com.google.android.gms.internal.d.a []) (aobj)), j));
        }

        ArrayList arraylist1 = new ArrayList();
        for (int k = 0; k < f1.fK.length; k++)
        {
            arraylist1.add(a(f1.fK[k], f1, ((com.google.android.gms.internal.d.a []) (aobj)), k));
        }

        ArrayList arraylist2 = new ArrayList();
        for (int l = 0; l < f1.fI.length; l++)
        {
            a a1 = a(f1.fI[l], f1, ((com.google.android.gms.internal.d.a []) (aobj)), l);
            d1.a(a1);
            arraylist2.add(a1);
        }

        aobj = f1.fL;
        int j1 = aobj.length;
        for (int i1 = ((flag) ? 1 : 0); i1 < j1; i1++)
        {
            d1.a(a(aobj[i1], arraylist, arraylist2, arraylist1, f1));
        }

        d1.cM(f1.version);
        d1.fm(f1.fT);
        return d1.pa();
    }

    public static void b(InputStream inputstream, OutputStream outputstream)
        throws IOException
    {
        byte abyte0[] = new byte[1024];
        do
        {
            int i = inputstream.read(abyte0);
            if (i == -1)
            {
                return;
            }
            outputstream.write(abyte0, 0, i);
        } while (true);
    }

    private static void cL(String s)
        throws g
    {
        bh.T(s);
        throw new g(s);
    }

    public static com.google.android.gms.internal.d.a g(com.google.android.gms.internal.d.a a1)
    {
        com.google.android.gms.internal.d.a a2 = new com.google.android.gms.internal.d.a();
        a2.type = a1.type;
        a2.gE = (int[])a1.gE.clone();
        if (a1.gF)
        {
            a2.gF = a1.gF;
        }
        return a2;
    }

    private static com.google.android.gms.internal.c.h h(com.google.android.gms.internal.d.a a1)
        throws g
    {
        if ((com.google.android.gms.internal.c.h)a1.a(com.google.android.gms.internal.c.h.gf) == null)
        {
            cL((new StringBuilder()).append("Expected a ServingValue and didn't get one. Value is: ").append(a1).toString());
        }
        return (com.google.android.gms.internal.c.h)a1.a(com.google.android.gms.internal.c.h.gf);
    }
}
