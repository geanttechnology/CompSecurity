// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ewb extends eug
{

    private boolean A;
    private boolean B;
    private List C;
    private List D;
    private List E;
    private int F;
    private boolean a;
    private long b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private String h;
    private boolean i;
    private String j;
    private boolean k;
    private String l;
    private boolean m;
    private String n;
    private boolean o;
    private String p;
    private boolean q;
    private String r;
    private boolean s;
    private String t;
    private boolean u;
    private String v;
    private boolean w;
    private int x;
    private boolean y;
    private int z;

    public ewb()
    {
        b = 0L;
        d = "";
        f = "";
        h = "";
        j = "";
        l = "";
        n = "";
        p = "";
        r = "";
        t = "";
        v = "";
        x = 0;
        z = 0;
        B = false;
        C = Collections.emptyList();
        D = Collections.emptyList();
        E = Collections.emptyList();
        F = -1;
    }

    public final int a()
    {
        if (F < 0)
        {
            b();
        }
        return F;
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

            case 8: // '\b'
                long l2 = eud1.d();
                a = true;
                b = l2;
                break;

            case 18: // '\022'
                String s1 = eud1.i();
                c = true;
                d = s1;
                break;

            case 26: // '\032'
                String s2 = eud1.i();
                g = true;
                h = s2;
                break;

            case 34: // '"'
                String s3 = eud1.i();
                i = true;
                j = s3;
                break;

            case 42: // '*'
                String s4 = eud1.i();
                k = true;
                l = s4;
                break;

            case 50: // '2'
                String s5 = eud1.i();
                m = true;
                n = s5;
                break;

            case 58: // ':'
                String s6 = eud1.i();
                o = true;
                p = s6;
                break;

            case 66: // 'B'
                String s7 = eud1.i();
                q = true;
                r = s7;
                break;

            case 74: // 'J'
                String s8 = eud1.i();
                u = true;
                v = s8;
                break;

            case 82: // 'R'
                evm evm1 = new evm();
                eud1.a(evm1);
                if (C.isEmpty())
                {
                    C = new ArrayList();
                }
                C.add(evm1);
                break;

            case 90: // 'Z'
                String s9 = eud1.i();
                e = true;
                f = s9;
                break;

            case 96: // '`'
                int j1 = eud1.f();
                w = true;
                x = j1;
                break;

            case 104: // 'h'
                int k1 = eud1.f();
                y = true;
                z = k1;
                break;

            case 112: // 'p'
                boolean flag = eud1.h();
                A = true;
                B = flag;
                break;

            case 122: // 'z'
                String s10 = eud1.i();
                if (s10 == null)
                {
                    throw new NullPointerException();
                }
                if (D.isEmpty())
                {
                    D = new ArrayList();
                }
                D.add(s10);
                break;

            case 130: 
                String s11 = eud1.i();
                s = true;
                t = s11;
                break;

            case 136: 
                int l1 = eud1.f();
                if (E.isEmpty())
                {
                    E = new ArrayList();
                }
                E.add(Integer.valueOf(l1));
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
        if (c)
        {
            eue1.a(2, d);
        }
        if (g)
        {
            eue1.a(3, h);
        }
        if (i)
        {
            eue1.a(4, j);
        }
        if (k)
        {
            eue1.a(5, l);
        }
        if (m)
        {
            eue1.a(6, n);
        }
        if (o)
        {
            eue1.a(7, p);
        }
        if (q)
        {
            eue1.a(8, r);
        }
        if (u)
        {
            eue1.a(9, v);
        }
        for (Iterator iterator = C.iterator(); iterator.hasNext(); eue1.b(10, (evm)iterator.next())) { }
        if (e)
        {
            eue1.a(11, f);
        }
        if (w)
        {
            eue1.a(12, x);
        }
        if (y)
        {
            eue1.a(13, z);
        }
        if (A)
        {
            eue1.a(14, B);
        }
        for (Iterator iterator1 = D.iterator(); iterator1.hasNext(); eue1.a(15, (String)iterator1.next())) { }
        if (s)
        {
            eue1.a(16, t);
        }
        for (Iterator iterator2 = E.iterator(); iterator2.hasNext(); eue1.a(17, ((Integer)iterator2.next()).intValue())) { }
    }

    public final int b()
    {
        boolean flag = false;
        Iterator iterator1;
        int i1;
        int j1;
        if (a)
        {
            j1 = eue.d(1, b) + 0;
        } else
        {
            j1 = 0;
        }
        i1 = j1;
        if (c)
        {
            i1 = j1 + eue.b(2, d);
        }
        j1 = i1;
        if (g)
        {
            j1 = i1 + eue.b(3, h);
        }
        i1 = j1;
        if (i)
        {
            i1 = j1 + eue.b(4, j);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.b(5, l);
        }
        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.b(6, n);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.b(7, p);
        }
        i1 = j1;
        if (q)
        {
            i1 = j1 + eue.b(8, r);
        }
        j1 = i1;
        if (u)
        {
            j1 = i1 + eue.b(9, v);
        }
        for (Iterator iterator = C.iterator(); iterator.hasNext();)
        {
            j1 = eue.d(10, (evm)iterator.next()) + j1;
        }

        i1 = j1;
        if (e)
        {
            i1 = j1 + eue.b(11, f);
        }
        j1 = i1;
        if (w)
        {
            j1 = i1 + eue.d(12, x);
        }
        i1 = j1;
        if (y)
        {
            i1 = j1 + eue.d(13, z);
        }
        j1 = i1;
        if (A)
        {
            j1 = i1 + eue.b(14, B);
        }
        iterator1 = D.iterator();
        for (i1 = 0; iterator1.hasNext(); i1 = eue.a((String)iterator1.next()) + i1) { }
        i1 = j1 + i1 + D.size() * 1;
        if (s)
        {
            i1 += eue.b(16, t);
        }
        iterator1 = E.iterator();
        for (j1 = ((flag) ? 1 : 0); iterator1.hasNext(); j1 += eue.a(((Integer)iterator1.next()).intValue())) { }
        i1 = i1 + j1 + E.size() * 2;
        F = i1;
        return i1;
    }
}
