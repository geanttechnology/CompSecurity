// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ett extends eug
{

    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private boolean F;
    private boolean G;
    private String H;
    private int I;
    private boolean a;
    private String b;
    private boolean c;
    private float d;
    private boolean e;
    private float f;
    private boolean g;
    private etv h;
    private List i;
    private boolean j;
    private String k;
    private List l;
    private List m;
    private List n;
    private boolean o;
    private eqw p;
    private List q;
    private List r;
    private boolean s;
    private boolean t;
    private boolean u;
    private int v;
    private boolean w;
    private String x;
    private boolean y;
    private boolean z;

    public ett()
    {
        b = "";
        d = 0.0F;
        f = 0.0F;
        h = null;
        i = Collections.emptyList();
        k = "";
        l = Collections.emptyList();
        m = Collections.emptyList();
        n = Collections.emptyList();
        p = null;
        q = Collections.emptyList();
        r = Collections.emptyList();
        t = false;
        v = 0;
        x = "";
        z = true;
        B = false;
        D = false;
        F = false;
        H = "";
        I = -1;
    }

    public final int a()
    {
        if (I < 0)
        {
            b();
        }
        return I;
    }

    public final ett a(int i1)
    {
        u = true;
        v = i1;
        return this;
    }

    public final ett a(enn enn1)
    {
        if (enn1 == null)
        {
            throw new NullPointerException();
        }
        if (r.isEmpty())
        {
            r = new ArrayList();
        }
        r.add(enn1);
        return this;
    }

    public final ett a(boolean flag)
    {
        y = true;
        z = flag;
        return this;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int i1 = eud1.a();
            switch (i1)
            {
            default:
                if (a(eud1, i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                String s1 = eud1.i();
                a = true;
                b = s1;
                break;

            case 21: // '\025'
                float f1 = eud1.c();
                e = true;
                f = f1;
                break;

            case 26: // '\032'
                etv etv1 = new etv();
                eud1.a(etv1);
                g = true;
                h = etv1;
                break;

            case 42: // '*'
                ets ets1 = new ets();
                eud1.a(ets1);
                if (i.isEmpty())
                {
                    i = new ArrayList();
                }
                i.add(ets1);
                break;

            case 50: // '2'
                etw etw1 = new etw();
                eud1.a(etw1);
                if (l.isEmpty())
                {
                    l = new ArrayList();
                }
                l.add(etw1);
                break;

            case 58: // ':'
                etf etf1 = new etf();
                eud1.a(etf1);
                if (m.isEmpty())
                {
                    m = new ArrayList();
                }
                m.add(etf1);
                break;

            case 64: // '@'
                boolean flag = eud1.h();
                s = true;
                t = flag;
                break;

            case 72: // 'H'
                a(eud1.f());
                break;

            case 82: // 'R'
                String s2 = eud1.i();
                G = true;
                H = s2;
                break;

            case 90: // 'Z'
                etr etr1 = new etr();
                eud1.a(etr1);
                if (q.isEmpty())
                {
                    q = new ArrayList();
                }
                q.add(etr1);
                break;

            case 101: // 'e'
                float f2 = eud1.c();
                c = true;
                d = f2;
                break;

            case 106: // 'j'
                eqw eqw1 = new eqw();
                eud1.a(eqw1);
                o = true;
                p = eqw1;
                break;

            case 114: // 'r'
                etx etx1 = new etx();
                eud1.a(etx1);
                if (n.isEmpty())
                {
                    n = new ArrayList();
                }
                n.add(etx1);
                break;

            case 122: // 'z'
                enn enn1 = new enn();
                eud1.a(enn1);
                a(enn1);
                break;

            case 130: 
                String s3 = eud1.i();
                w = true;
                x = s3;
                break;

            case 136: 
                a(eud1.h());
                break;

            case 144: 
                boolean flag1 = eud1.h();
                A = true;
                B = flag1;
                break;

            case 152: 
                boolean flag2 = eud1.h();
                E = true;
                F = flag2;
                break;

            case 160: 
                boolean flag3 = eud1.h();
                C = true;
                D = flag3;
                break;

            case 170: 
                String s4 = eud1.i();
                j = true;
                k = s4;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.a(1, b);
        }
        if (e)
        {
            eue1.a(2, f);
        }
        if (g)
        {
            eue1.b(3, h);
        }
        for (Iterator iterator = i.iterator(); iterator.hasNext(); eue1.b(5, (ets)iterator.next())) { }
        for (Iterator iterator1 = l.iterator(); iterator1.hasNext(); eue1.b(6, (etw)iterator1.next())) { }
        for (Iterator iterator2 = m.iterator(); iterator2.hasNext(); eue1.b(7, (etf)iterator2.next())) { }
        if (s)
        {
            eue1.a(8, t);
        }
        if (u)
        {
            eue1.a(9, v);
        }
        if (G)
        {
            eue1.a(10, H);
        }
        for (Iterator iterator3 = q.iterator(); iterator3.hasNext(); eue1.b(11, (etr)iterator3.next())) { }
        if (c)
        {
            eue1.a(12, d);
        }
        if (o)
        {
            eue1.b(13, p);
        }
        for (Iterator iterator4 = n.iterator(); iterator4.hasNext(); eue1.b(14, (etx)iterator4.next())) { }
        for (Iterator iterator5 = r.iterator(); iterator5.hasNext(); eue1.b(15, (enn)iterator5.next())) { }
        if (w)
        {
            eue1.a(16, x);
        }
        if (y)
        {
            eue1.a(17, z);
        }
        if (A)
        {
            eue1.a(18, B);
        }
        if (E)
        {
            eue1.a(19, F);
        }
        if (C)
        {
            eue1.a(20, D);
        }
        if (j)
        {
            eue1.a(21, k);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.b(1, b) + 0;
        }
        int i1 = j1;
        if (e)
        {
            i1 = j1 + eue.b(2, f);
        }
        j1 = i1;
        if (g)
        {
            j1 = i1 + eue.d(3, h);
        }
        Iterator iterator = i.iterator();
        for (i1 = j1; iterator.hasNext(); i1 = eue.d(5, (ets)iterator.next()) + i1) { }
        for (iterator = l.iterator(); iterator.hasNext();)
        {
            i1 += eue.d(6, (etw)iterator.next());
        }

        iterator = m.iterator();
        for (j1 = i1; iterator.hasNext(); j1 += eue.d(7, (etf)iterator.next())) { }
        i1 = j1;
        if (s)
        {
            i1 = j1 + eue.b(8, t);
        }
        j1 = i1;
        if (u)
        {
            j1 = i1 + eue.d(9, v);
        }
        i1 = j1;
        if (G)
        {
            i1 = j1 + eue.b(10, H);
        }
        iterator = q.iterator();
        for (j1 = i1; iterator.hasNext(); j1 += eue.d(11, (etr)iterator.next())) { }
        i1 = j1;
        if (c)
        {
            i1 = j1 + eue.b(12, d);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.d(13, p);
        }
        for (Iterator iterator1 = n.iterator(); iterator1.hasNext();)
        {
            j1 += eue.d(14, (etx)iterator1.next());
        }

        for (Iterator iterator2 = r.iterator(); iterator2.hasNext();)
        {
            j1 += eue.d(15, (enn)iterator2.next());
        }

        i1 = j1;
        if (w)
        {
            i1 = j1 + eue.b(16, x);
        }
        j1 = i1;
        if (y)
        {
            j1 = i1 + eue.b(17, z);
        }
        i1 = j1;
        if (A)
        {
            i1 = j1 + eue.b(18, B);
        }
        j1 = i1;
        if (E)
        {
            j1 = i1 + eue.b(19, F);
        }
        i1 = j1;
        if (C)
        {
            i1 = j1 + eue.b(20, D);
        }
        j1 = i1;
        if (j)
        {
            j1 = i1 + eue.b(21, k);
        }
        I = j1;
        return j1;
    }
}
