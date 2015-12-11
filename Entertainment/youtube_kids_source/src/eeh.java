// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eeh extends eug
{

    private int A;
    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private String h;
    private boolean i;
    private boolean j;
    private boolean k;
    private String l;
    private boolean m;
    private String n;
    private List o;
    private List p;
    private boolean q;
    private euc r;
    private boolean s;
    private String t;
    private boolean u;
    private String v;
    private boolean w;
    private double x;
    private boolean y;
    private boolean z;

    public eeh()
    {
        b = "";
        d = "";
        f = "";
        h = "";
        j = false;
        l = "";
        n = "";
        o = Collections.emptyList();
        p = Collections.emptyList();
        r = euc.b;
        t = "";
        v = "";
        x = 0.0D;
        z = false;
        A = -1;
    }

    public final int a()
    {
        if (A < 0)
        {
            b();
        }
        return A;
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

            case 18: // '\022'
                String s2 = eud1.i();
                e = true;
                f = s2;
                break;

            case 26: // '\032'
                String s3 = eud1.i();
                g = true;
                h = s3;
                break;

            case 34: // '"'
                String s4 = eud1.i();
                k = true;
                l = s4;
                break;

            case 42: // '*'
                eel eel1 = new eel();
                eud1.a(eel1);
                if (o.isEmpty())
                {
                    o = new ArrayList();
                }
                o.add(eel1);
                break;

            case 50: // '2'
                eei eei1 = new eei();
                eud1.a(eei1);
                if (p.isEmpty())
                {
                    p = new ArrayList();
                }
                p.add(eei1);
                break;

            case 58: // ':'
                euc euc1 = eud1.j();
                q = true;
                r = euc1;
                break;

            case 66: // 'B'
                String s5 = eud1.i();
                m = true;
                n = s5;
                break;

            case 74: // 'J'
                String s6 = eud1.i();
                s = true;
                t = s6;
                break;

            case 81: // 'Q'
                double d1 = eud1.b();
                w = true;
                x = d1;
                break;

            case 90: // 'Z'
                String s7 = eud1.i();
                u = true;
                v = s7;
                break;

            case 98: // 'b'
                String s8 = eud1.i();
                c = true;
                d = s8;
                break;

            case 104: // 'h'
                boolean flag = eud1.h();
                y = true;
                z = flag;
                break;

            case 112: // 'p'
                boolean flag1 = eud1.h();
                i = true;
                j = flag1;
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
            eue1.a(3, h);
        }
        if (k)
        {
            eue1.a(4, l);
        }
        for (Iterator iterator = o.iterator(); iterator.hasNext(); eue1.b(5, (eel)iterator.next())) { }
        for (Iterator iterator1 = p.iterator(); iterator1.hasNext(); eue1.b(6, (eei)iterator1.next())) { }
        if (q)
        {
            eue1.a(7, r);
        }
        if (m)
        {
            eue1.a(8, n);
        }
        if (s)
        {
            eue1.a(9, t);
        }
        if (w)
        {
            eue1.a(10, x);
        }
        if (u)
        {
            eue1.a(11, v);
        }
        if (c)
        {
            eue1.a(12, d);
        }
        if (y)
        {
            eue1.a(13, z);
        }
        if (i)
        {
            eue1.a(14, j);
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
            j1 = i1 + eue.b(3, h);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.b(4, l);
        }
        Iterator iterator = o.iterator();
        for (j1 = i1; iterator.hasNext(); j1 = eue.d(5, (eel)iterator.next()) + j1) { }
        for (Iterator iterator1 = p.iterator(); iterator1.hasNext();)
        {
            j1 += eue.d(6, (eei)iterator1.next());
        }

        i1 = j1;
        if (q)
        {
            i1 = j1 + eue.b(7, r);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.b(8, n);
        }
        i1 = j1;
        if (s)
        {
            i1 = j1 + eue.b(9, t);
        }
        j1 = i1;
        if (w)
        {
            j1 = i1 + eue.b(10, x);
        }
        i1 = j1;
        if (u)
        {
            i1 = j1 + eue.b(11, v);
        }
        j1 = i1;
        if (c)
        {
            j1 = i1 + eue.b(12, d);
        }
        i1 = j1;
        if (y)
        {
            i1 = j1 + eue.b(13, z);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.b(14, j);
        }
        A = j1;
        return j1;
    }
}
