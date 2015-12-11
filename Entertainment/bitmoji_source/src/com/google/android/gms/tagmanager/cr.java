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

        private final Map Ws;
        private final com.google.android.gms.internal.d.a Wt;

        public static b jE()
        {
            return new b();
        }

        public void a(String s, com.google.android.gms.internal.d.a a1)
        {
            Ws.put(s, a1);
        }

        public Map jF()
        {
            return Collections.unmodifiableMap(Ws);
        }

        public com.google.android.gms.internal.d.a jG()
        {
            return Wt;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Properties: ").append(jF()).append(" pushAfterEvaluate: ").append(Wt).toString();
        }

        private a(Map map, com.google.android.gms.internal.d.a a1)
        {
            Ws = map;
            Wt = a1;
        }

    }

    public static class b
    {

        private final Map Ws;
        private com.google.android.gms.internal.d.a Wt;

        public b b(String s, com.google.android.gms.internal.d.a a1)
        {
            Ws.put(s, a1);
            return this;
        }

        public b i(com.google.android.gms.internal.d.a a1)
        {
            Wt = a1;
            return this;
        }

        public a jH()
        {
            return new a(Ws, Wt);
        }

        private b()
        {
            Ws = new HashMap();
        }

    }

    public static class c
    {

        private final String Un;
        private final List Wu;
        private final Map Wv;
        private final int Ww;

        public static d jI()
        {
            return new d();
        }

        public String getVersion()
        {
            return Un;
        }

        public List jJ()
        {
            return Wu;
        }

        public Map jK()
        {
            return Wv;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Rules: ").append(jJ()).append("  Macros: ").append(Wv).toString();
        }

        private c(List list, Map map, String s, int i)
        {
            Wu = Collections.unmodifiableList(list);
            Wv = Collections.unmodifiableMap(map);
            Un = s;
            Ww = i;
        }

    }

    public static class d
    {

        private String Un;
        private final List Wu;
        private final Map Wv;
        private int Ww;

        public d a(a a1)
        {
            String s = di.j((com.google.android.gms.internal.d.a)a1.jF().get(com.google.android.gms.internal.b.cT.toString()));
            List list = (List)Wv.get(s);
            Object obj = list;
            if (list == null)
            {
                obj = new ArrayList();
                Wv.put(s, obj);
            }
            ((List) (obj)).add(a1);
            return this;
        }

        public d a(e e1)
        {
            Wu.add(e1);
            return this;
        }

        public d bW(int i)
        {
            Ww = i;
            return this;
        }

        public d bx(String s)
        {
            Un = s;
            return this;
        }

        public c jL()
        {
            return new c(Wu, Wv, Un, Ww);
        }

        private d()
        {
            Wu = new ArrayList();
            Wv = new HashMap();
            Un = "";
            Ww = 0;
        }

    }

    public static class e
    {

        private final List WA;
        private final List WB;
        private final List WC;
        private final List WD;
        private final List WE;
        private final List WF;
        private final List WG;
        private final List Wx;
        private final List Wy;
        private final List Wz;

        public static f jM()
        {
            return new f();
        }

        public List jN()
        {
            return Wx;
        }

        public List jO()
        {
            return Wy;
        }

        public List jP()
        {
            return Wz;
        }

        public List jQ()
        {
            return WA;
        }

        public List jR()
        {
            return WB;
        }

        public List jS()
        {
            return WD;
        }

        public List jT()
        {
            return WE;
        }

        public List jU()
        {
            return WF;
        }

        public List jV()
        {
            return WG;
        }

        public List jW()
        {
            return WC;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Positive predicates: ").append(jN()).append("  Negative predicates: ").append(jO()).append("  Add tags: ").append(jP()).append("  Remove tags: ").append(jQ()).append("  Add macros: ").append(jR()).append("  Remove macros: ").append(jW()).toString();
        }

        private e(List list, List list1, List list2, List list3, List list4, List list5, List list6, 
                List list7, List list8, List list9)
        {
            Wx = Collections.unmodifiableList(list);
            Wy = Collections.unmodifiableList(list1);
            Wz = Collections.unmodifiableList(list2);
            WA = Collections.unmodifiableList(list3);
            WB = Collections.unmodifiableList(list4);
            WC = Collections.unmodifiableList(list5);
            WD = Collections.unmodifiableList(list6);
            WE = Collections.unmodifiableList(list7);
            WF = Collections.unmodifiableList(list8);
            WG = Collections.unmodifiableList(list9);
        }

    }

    public static class f
    {

        private final List WA;
        private final List WB;
        private final List WC;
        private final List WD;
        private final List WE;
        private final List WF;
        private final List WG;
        private final List Wx;
        private final List Wy;
        private final List Wz;

        public f b(a a1)
        {
            Wx.add(a1);
            return this;
        }

        public f bA(String s)
        {
            WD.add(s);
            return this;
        }

        public f bB(String s)
        {
            WE.add(s);
            return this;
        }

        public f by(String s)
        {
            WF.add(s);
            return this;
        }

        public f bz(String s)
        {
            WG.add(s);
            return this;
        }

        public f c(a a1)
        {
            Wy.add(a1);
            return this;
        }

        public f d(a a1)
        {
            Wz.add(a1);
            return this;
        }

        public f e(a a1)
        {
            WA.add(a1);
            return this;
        }

        public f f(a a1)
        {
            WB.add(a1);
            return this;
        }

        public f g(a a1)
        {
            WC.add(a1);
            return this;
        }

        public e jX()
        {
            return new e(Wx, Wy, Wz, WA, WB, WC, WD, WE, WF, WG);
        }

        private f()
        {
            Wx = new ArrayList();
            Wy = new ArrayList();
            Wz = new ArrayList();
            WA = new ArrayList();
            WB = new ArrayList();
            WC = new ArrayList();
            WD = new ArrayList();
            WE = new ArrayList();
            WF = new ArrayList();
            WG = new ArrayList();
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
            bw((new StringBuilder()).append("Value cycle detected.  Current value reference: ").append(i).append(".").append("  Previous value references: ").append(set).append(".").toString());
        }
        a1 = (com.google.android.gms.internal.d.a)a(((Object []) (f1.fi)), i, "values");
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
            bw((new StringBuilder()).append("Invalid value: ").append(a1).toString());
        }
        aa[i] = ((com.google.android.gms.internal.d.a) (obj));
        set.remove(Integer.valueOf(i));
        return ((com.google.android.gms.internal.d.a) (obj));
_L3:
        obj = h(a1);
        com.google.android.gms.internal.d.a a2 = g(a1);
        a2.fZ = new com.google.android.gms.internal.d.a[((com.google.android.gms.internal.c.h) (obj)).fK.length];
        int ai[] = ((com.google.android.gms.internal.c.h) (obj)).fK;
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
            a2.fZ[j] = a(l2, f1, aa, set);
            j1++;
            j++;
        } while (true);
_L4:
        com.google.android.gms.internal.d.a a3 = g(a1);
        obj = h(a1);
        if (((com.google.android.gms.internal.c.h) (obj)).fL.length != ((com.google.android.gms.internal.c.h) (obj)).fM.length)
        {
            bw((new StringBuilder()).append("Uneven map keys (").append(((com.google.android.gms.internal.c.h) (obj)).fL.length).append(") and map values (").append(((com.google.android.gms.internal.c.h) (obj)).fM.length).append(")").toString());
        }
        a3.ga = new com.google.android.gms.internal.d.a[((com.google.android.gms.internal.c.h) (obj)).fL.length];
        a3.gb = new com.google.android.gms.internal.d.a[((com.google.android.gms.internal.c.h) (obj)).fL.length];
        int ai1[] = ((com.google.android.gms.internal.c.h) (obj)).fL;
        l2 = ai1.length;
        int k1 = 0;
        for (int k = 0; k1 < l2; k++)
        {
            int j3 = ai1[k1];
            a3.ga[k] = a(j3, f1, aa, set);
            k1++;
        }

        ai1 = ((com.google.android.gms.internal.c.h) (obj)).fM;
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
            a3.gb[l] = a(j2, f1, aa, set);
            k1++;
            l++;
        } while (true);
_L5:
        obj = g(a1);
        obj.gc = di.j(a(h(a1).fP, f1, aa, set));
        continue; /* Loop/switch isn't completed */
_L6:
        com.google.android.gms.internal.d.a a4 = g(a1);
        obj = h(a1);
        a4.gg = new com.google.android.gms.internal.d.a[((com.google.android.gms.internal.c.h) (obj)).fO.length];
        int ai2[] = ((com.google.android.gms.internal.c.h) (obj)).fO;
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
            a4.gg[i1] = a(i3, f1, aa, set);
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
        b b2 = a.jE();
        b1 = b1.eS;
        int j = b1.length;
        i = 0;
        while (i < j) 
        {
            int k = b1[i];
            Object obj = (com.google.android.gms.internal.c.e)a(((Object []) (f1.fj)), Integer.valueOf(k).intValue(), "properties");
            String s = (String)a(((Object []) (f1.fh)), ((com.google.android.gms.internal.c.e) (obj)).key, "keys");
            obj = (com.google.android.gms.internal.d.a)a(((Object []) (aa)), ((com.google.android.gms.internal.c.e) (obj)).value, "values");
            if (com.google.android.gms.internal.b.dM.toString().equals(s))
            {
                b2.i(((com.google.android.gms.internal.d.a) (obj)));
            } else
            {
                b2.b(s, ((com.google.android.gms.internal.d.a) (obj)));
            }
            i++;
        }
        return b2.jH();
    }

    private static e a(com.google.android.gms.internal.c.g g1, List list, List list1, List list2, com.google.android.gms.internal.c.f f1)
    {
        f f2 = e.jM();
        int ai[] = g1.fy;
        int k2 = ai.length;
        for (int i = 0; i < k2; i++)
        {
            f2.b((a)list2.get(Integer.valueOf(ai[i]).intValue()));
        }

        ai = g1.fz;
        k2 = ai.length;
        for (int j = 0; j < k2; j++)
        {
            f2.c((a)list2.get(Integer.valueOf(ai[j]).intValue()));
        }

        list2 = g1.fA;
        k2 = list2.length;
        for (int k = 0; k < k2; k++)
        {
            f2.d((a)list.get(Integer.valueOf(list2[k]).intValue()));
        }

        list2 = g1.fC;
        k2 = list2.length;
        for (int l = 0; l < k2; l++)
        {
            int l2 = list2[l];
            f2.by(f1.fi[Integer.valueOf(l2).intValue()].fY);
        }

        list2 = g1.fB;
        k2 = list2.length;
        for (int i1 = 0; i1 < k2; i1++)
        {
            f2.e((a)list.get(Integer.valueOf(list2[i1]).intValue()));
        }

        list = g1.fD;
        k2 = list.length;
        for (int j1 = 0; j1 < k2; j1++)
        {
            int i3 = list[j1];
            f2.bz(f1.fi[Integer.valueOf(i3).intValue()].fY);
        }

        list = g1.fE;
        k2 = list.length;
        for (int k1 = 0; k1 < k2; k1++)
        {
            f2.f((a)list1.get(Integer.valueOf(list[k1]).intValue()));
        }

        list = g1.fG;
        k2 = list.length;
        for (int l1 = 0; l1 < k2; l1++)
        {
            int j3 = list[l1];
            f2.bA(f1.fi[Integer.valueOf(j3).intValue()].fY);
        }

        list = g1.fF;
        k2 = list.length;
        for (int i2 = 0; i2 < k2; i2++)
        {
            f2.g((a)list1.get(Integer.valueOf(list[i2]).intValue()));
        }

        g1 = g1.fH;
        k2 = g1.length;
        for (int j2 = 0; j2 < k2; j2++)
        {
            int k3 = g1[j2];
            f2.bB(f1.fi[Integer.valueOf(k3).intValue()].fY);
        }

        return f2.jX();
    }

    private static Object a(Object aobj[], int i, String s)
        throws g
    {
        if (i < 0 || i >= aobj.length)
        {
            bw((new StringBuilder()).append("Index out of bounds detected: ").append(i).append(" in ").append(s).toString());
        }
        return aobj[i];
    }

    public static c b(com.google.android.gms.internal.c.f f1)
        throws g
    {
        boolean flag = false;
        Object aobj[] = new com.google.android.gms.internal.d.a[f1.fi.length];
        for (int i = 0; i < f1.fi.length; i++)
        {
            a(i, f1, ((com.google.android.gms.internal.d.a []) (aobj)), new HashSet(0));
        }

        d d1 = c.jI();
        ArrayList arraylist = new ArrayList();
        for (int j = 0; j < f1.fl.length; j++)
        {
            arraylist.add(a(f1.fl[j], f1, ((com.google.android.gms.internal.d.a []) (aobj)), j));
        }

        ArrayList arraylist1 = new ArrayList();
        for (int k = 0; k < f1.fm.length; k++)
        {
            arraylist1.add(a(f1.fm[k], f1, ((com.google.android.gms.internal.d.a []) (aobj)), k));
        }

        ArrayList arraylist2 = new ArrayList();
        for (int l = 0; l < f1.fk.length; l++)
        {
            a a1 = a(f1.fk[l], f1, ((com.google.android.gms.internal.d.a []) (aobj)), l);
            d1.a(a1);
            arraylist2.add(a1);
        }

        aobj = f1.fn;
        int j1 = aobj.length;
        for (int i1 = ((flag) ? 1 : 0); i1 < j1; i1++)
        {
            d1.a(a(aobj[i1], arraylist, arraylist2, arraylist1, f1));
        }

        d1.bx(f1.fr);
        d1.bW(f1.fw);
        return d1.jL();
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

    private static void bw(String s)
        throws g
    {
        bh.t(s);
        throw new g(s);
    }

    public static com.google.android.gms.internal.d.a g(com.google.android.gms.internal.d.a a1)
    {
        com.google.android.gms.internal.d.a a2 = new com.google.android.gms.internal.d.a();
        a2.type = a1.type;
        a2.gh = (int[])a1.gh.clone();
        if (a1.gi)
        {
            a2.gi = a1.gi;
        }
        return a2;
    }

    private static com.google.android.gms.internal.c.h h(com.google.android.gms.internal.d.a a1)
        throws g
    {
        if ((com.google.android.gms.internal.c.h)a1.a(com.google.android.gms.internal.c.h.fI) == null)
        {
            bw((new StringBuilder()).append("Expected a ServingValue and didn't get one. Value is: ").append(a1).toString());
        }
        return (com.google.android.gms.internal.c.h)a1.a(com.google.android.gms.internal.c.h.fI);
    }
}
