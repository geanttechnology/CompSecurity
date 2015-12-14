// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.b;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Referenced classes of package com.google.android.gms.tagmanager:
//            dh, bh

class cq
{

    private static com.google.android.gms.internal.d.a a(int i, com.google.android.gms.internal.c.f f, com.google.android.gms.internal.d.a aa[], Set set)
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
            cd((new StringBuilder()).append("Value cycle detected.  Current value reference: ").append(i).append(".").append("  Previous value references: ").append(set).append(".").toString());
        }
        a1 = (com.google.android.gms.internal.d.a)a(((Object []) (f.eX)), i, "values");
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
            cd((new StringBuilder()).append("Invalid value: ").append(a1).toString());
        }
        aa[i] = ((com.google.android.gms.internal.d.a) (obj));
        set.remove(Integer.valueOf(i));
        return ((com.google.android.gms.internal.d.a) (obj));
_L3:
        obj = h(a1);
        com.google.android.gms.internal.d.a a2 = g(a1);
        a2.fO = new com.google.android.gms.internal.d.a[((com.google.android.gms.internal.c.h) (obj)).fz.length];
        int ai[] = ((com.google.android.gms.internal.c.h) (obj)).fz;
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
            a2.fO[j] = a(l2, f, aa, set);
            j1++;
            j++;
        } while (true);
_L4:
        com.google.android.gms.internal.d.a a3 = g(a1);
        obj = h(a1);
        if (((com.google.android.gms.internal.c.h) (obj)).fA.length != ((com.google.android.gms.internal.c.h) (obj)).fB.length)
        {
            cd((new StringBuilder()).append("Uneven map keys (").append(((com.google.android.gms.internal.c.h) (obj)).fA.length).append(") and map values (").append(((com.google.android.gms.internal.c.h) (obj)).fB.length).append(")").toString());
        }
        a3.fP = new com.google.android.gms.internal.d.a[((com.google.android.gms.internal.c.h) (obj)).fA.length];
        a3.fQ = new com.google.android.gms.internal.d.a[((com.google.android.gms.internal.c.h) (obj)).fA.length];
        int ai1[] = ((com.google.android.gms.internal.c.h) (obj)).fA;
        l2 = ai1.length;
        int k1 = 0;
        for (int k = 0; k1 < l2; k++)
        {
            int j3 = ai1[k1];
            a3.fP[k] = a(j3, f, aa, set);
            k1++;
        }

        ai1 = ((com.google.android.gms.internal.c.h) (obj)).fB;
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
            a3.fQ[l] = a(j2, f, aa, set);
            k1++;
            l++;
        } while (true);
_L5:
        obj = g(a1);
        obj.fR = dh.j(a(h(a1).fE, f, aa, set));
        continue; /* Loop/switch isn't completed */
_L6:
        com.google.android.gms.internal.d.a a4 = g(a1);
        obj = h(a1);
        a4.fV = new com.google.android.gms.internal.d.a[((com.google.android.gms.internal.c.h) (obj)).fD.length];
        int ai2[] = ((com.google.android.gms.internal.c.h) (obj)).fD;
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
            a4.fV[i1] = a(i3, f, aa, set);
            l1++;
            i1++;
        } while (true);
_L2:
        obj = a1;
        if (true) goto _L1; else goto _L7
_L7:
    }

    private static a a(com.google.android.gms.internal.c.b b1, com.google.android.gms.internal.c.f f, com.google.android.gms.internal.d.a aa[], int i)
    {
        b b2 = a.mn();
        b1 = b1.eH;
        int j = b1.length;
        i = 0;
        while (i < j) 
        {
            int k = b1[i];
            Object obj = (com.google.android.gms.internal.c.e)a(((Object []) (f.eY)), Integer.valueOf(k).intValue(), "properties");
            String s = (String)a(((Object []) (f.eW)), ((com.google.android.gms.internal.c.e) (obj)).key, "keys");
            obj = (com.google.android.gms.internal.d.a)a(((Object []) (aa)), ((com.google.android.gms.internal.c.e) (obj)).value, "values");
            if (com.google.android.gms.internal.b.dB.toString().equals(s))
            {
                b2.i(((com.google.android.gms.internal.d.a) (obj)));
            } else
            {
                b2.b(s, ((com.google.android.gms.internal.d.a) (obj)));
            }
            i++;
        }
        return b2.mq();
    }

    private static e a(com.google.android.gms.internal.c.g g1, List list, List list1, List list2, com.google.android.gms.internal.c.f f1)
    {
        f f2 = e.mv();
        int ai[] = g1.fn;
        int k2 = ai.length;
        for (int i = 0; i < k2; i++)
        {
            f2.b((a)list2.get(Integer.valueOf(ai[i]).intValue()));
        }

        ai = g1.fo;
        k2 = ai.length;
        for (int j = 0; j < k2; j++)
        {
            f2.c((a)list2.get(Integer.valueOf(ai[j]).intValue()));
        }

        list2 = g1.fp;
        k2 = list2.length;
        for (int k = 0; k < k2; k++)
        {
            f2.d((a)list.get(Integer.valueOf(list2[k]).intValue()));
        }

        list2 = g1.fr;
        k2 = list2.length;
        for (int l = 0; l < k2; l++)
        {
            int l2 = list2[l];
            f2.cf(f1.eX[Integer.valueOf(l2).intValue()].fN);
        }

        list2 = g1.fq;
        k2 = list2.length;
        for (int i1 = 0; i1 < k2; i1++)
        {
            f2.e((a)list.get(Integer.valueOf(list2[i1]).intValue()));
        }

        list = g1.fs;
        k2 = list.length;
        for (int j1 = 0; j1 < k2; j1++)
        {
            int i3 = list[j1];
            f2.cg(f1.eX[Integer.valueOf(i3).intValue()].fN);
        }

        list = g1.ft;
        k2 = list.length;
        for (int k1 = 0; k1 < k2; k1++)
        {
            f2.f((a)list1.get(Integer.valueOf(list[k1]).intValue()));
        }

        list = g1.fv;
        k2 = list.length;
        for (int l1 = 0; l1 < k2; l1++)
        {
            int j3 = list[l1];
            f2.ch(f1.eX[Integer.valueOf(j3).intValue()].fN);
        }

        list = g1.fu;
        k2 = list.length;
        for (int i2 = 0; i2 < k2; i2++)
        {
            f2.g((a)list1.get(Integer.valueOf(list[i2]).intValue()));
        }

        g1 = g1.fw;
        k2 = g1.length;
        for (int j2 = 0; j2 < k2; j2++)
        {
            int k3 = g1[j2];
            f2.ci(f1.eX[Integer.valueOf(k3).intValue()].fN);
        }

        return f2.mG();
    }

    private static Object a(Object aobj[], int i, String s)
    {
        if (i < 0 || i >= aobj.length)
        {
            cd((new StringBuilder()).append("Index out of bounds detected: ").append(i).append(" in ").append(s).toString());
        }
        return aobj[i];
    }

    public static c b(com.google.android.gms.internal.c.f f1)
    {
        boolean flag = false;
        Object aobj[] = new com.google.android.gms.internal.d.a[f1.eX.length];
        for (int i = 0; i < f1.eX.length; i++)
        {
            a(i, f1, ((com.google.android.gms.internal.d.a []) (aobj)), new HashSet(0));
        }

        d d1 = c.mr();
        ArrayList arraylist = new ArrayList();
        for (int j = 0; j < f1.fa.length; j++)
        {
            arraylist.add(a(f1.fa[j], f1, ((com.google.android.gms.internal.d.a []) (aobj)), j));
        }

        ArrayList arraylist1 = new ArrayList();
        for (int k = 0; k < f1.fb.length; k++)
        {
            arraylist1.add(a(f1.fb[k], f1, ((com.google.android.gms.internal.d.a []) (aobj)), k));
        }

        ArrayList arraylist2 = new ArrayList();
        for (int l = 0; l < f1.eZ.length; l++)
        {
            a a1 = a(f1.eZ[l], f1, ((com.google.android.gms.internal.d.a []) (aobj)), l);
            d1.a(a1);
            arraylist2.add(a1);
        }

        aobj = f1.fc;
        int j1 = aobj.length;
        for (int i1 = ((flag) ? 1 : 0); i1 < j1; i1++)
        {
            d1.a(a(aobj[i1], arraylist, arraylist2, arraylist1, f1));
        }

        d1.ce(f1.fg);
        d1.du(f1.fl);
        return d1.mu();
    }

    public static void b(InputStream inputstream, OutputStream outputstream)
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

    private static void cd(String s)
    {
        bh.A(s);
        throw new g(s);
    }

    public static com.google.android.gms.internal.d.a g(com.google.android.gms.internal.d.a a1)
    {
        com.google.android.gms.internal.d.a a2 = new com.google.android.gms.internal.d.a();
        a2.type = a1.type;
        a2.fW = (int[])a1.fW.clone();
        if (a1.fX)
        {
            a2.fX = a1.fX;
        }
        return a2;
    }

    private static com.google.android.gms.internal.c.h h(com.google.android.gms.internal.d.a a1)
    {
        if ((com.google.android.gms.internal.c.h)a1.a(com.google.android.gms.internal.c.h.fx) == null)
        {
            cd((new StringBuilder()).append("Expected a ServingValue and didn't get one. Value is: ").append(a1).toString());
        }
        return (com.google.android.gms.internal.c.h)a1.a(com.google.android.gms.internal.c.h.fx);
    }

    /* member class not found */
    class a {}


    private class b
    {

        private final Map agX;
        private com.google.android.gms.internal.d.a agY;

        public b b(String s, com.google.android.gms.internal.d.a a1)
        {
            agX.put(s, a1);
            return this;
        }

        public b i(com.google.android.gms.internal.d.a a1)
        {
            agY = a1;
            return this;
        }

        public a mq()
        {
            return new a(agX, agY);
        }

        private b()
        {
            agX = new HashMap();
        }

    }


    /* member class not found */
    class e {}


    /* member class not found */
    class f {}


    private class c
    {

        private final String aeU;
        private final List agZ;
        private final Map aha;
        private final int ahb;

        public static d mr()
        {
            return new d();
        }

        public String getVersion()
        {
            return aeU;
        }

        public List ms()
        {
            return agZ;
        }

        public Map mt()
        {
            return aha;
        }

        public String toString()
        {
            return (new StringBuilder()).append("Rules: ").append(ms()).append("  Macros: ").append(aha).toString();
        }

        private c(List list, Map map, String s, int i)
        {
            agZ = Collections.unmodifiableList(list);
            aha = Collections.unmodifiableMap(map);
            aeU = s;
            ahb = i;
        }

    }


    /* member class not found */
    class d {}


    private class g extends Exception
    {

        public g(String s)
        {
            super(s);
        }
    }

}
