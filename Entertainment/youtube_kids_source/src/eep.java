// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eep extends eug
{

    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private String E;
    private int F;
    private boolean a;
    private String b;
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
    private List m;
    private boolean n;
    private String o;
    private boolean p;
    private int q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private boolean x;
    private int y;
    private boolean z;

    public eep()
    {
        b = "";
        d = "";
        f = "";
        h = "";
        j = "";
        l = "";
        m = Collections.emptyList();
        o = "";
        q = 0;
        s = false;
        u = false;
        w = -1;
        y = 0;
        A = false;
        C = false;
        E = "";
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

            case 10: // '\n'
                String s1 = eud1.i();
                a = true;
                b = s1;
                break;

            case 18: // '\022'
                String s2 = eud1.i();
                c = true;
                d = s2;
                break;

            case 26: // '\032'
                String s3 = eud1.i();
                e = true;
                f = s3;
                break;

            case 34: // '"'
                String s4 = eud1.i();
                g = true;
                h = s4;
                break;

            case 42: // '*'
                String s5 = eud1.i();
                i = true;
                j = s5;
                break;

            case 50: // '2'
                String s6 = eud1.i();
                k = true;
                l = s6;
                break;

            case 58: // ':'
                String s7 = eud1.i();
                n = true;
                o = s7;
                break;

            case 64: // '@'
                int j1 = eud1.f();
                p = true;
                q = j1;
                break;

            case 72: // 'H'
                boolean flag = eud1.h();
                r = true;
                s = flag;
                break;

            case 80: // 'P'
                boolean flag1 = eud1.h();
                t = true;
                u = flag1;
                break;

            case 88: // 'X'
                int k1 = eud1.f();
                v = true;
                w = k1;
                break;

            case 104: // 'h'
                boolean flag2 = eud1.h();
                z = true;
                A = flag2;
                break;

            case 112: // 'p'
                boolean flag3 = eud1.h();
                B = true;
                C = flag3;
                break;

            case 120: // 'x'
                int l1 = eud1.f();
                x = true;
                y = l1;
                break;

            case 128: 
                int i2 = eud1.f();
                if (m.isEmpty())
                {
                    m = new ArrayList();
                }
                m.add(Integer.valueOf(i2));
                break;

            case 138: 
                String s8 = eud1.i();
                D = true;
                E = s8;
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
        if (e)
        {
            eue1.a(3, f);
        }
        if (g)
        {
            eue1.a(4, h);
        }
        if (i)
        {
            eue1.a(5, j);
        }
        if (k)
        {
            eue1.a(6, l);
        }
        if (n)
        {
            eue1.a(7, o);
        }
        if (p)
        {
            eue1.a(8, q);
        }
        if (r)
        {
            eue1.a(9, s);
        }
        if (t)
        {
            eue1.a(10, u);
        }
        if (v)
        {
            eue1.a(11, w);
        }
        if (z)
        {
            eue1.a(13, A);
        }
        if (B)
        {
            eue1.a(14, C);
        }
        if (x)
        {
            eue1.a(15, y);
        }
        for (Iterator iterator = m.iterator(); iterator.hasNext(); eue1.a(16, ((Integer)iterator.next()).intValue())) { }
        if (D)
        {
            eue1.a(17, E);
        }
    }

    public final int b()
    {
        boolean flag = false;
        Iterator iterator;
        int i1;
        int j1;
        if (a)
        {
            j1 = eue.b(1, b) + 0;
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
        if (e)
        {
            j1 = i1 + eue.b(3, f);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.b(4, h);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.b(5, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.b(6, l);
        }
        j1 = i1;
        if (n)
        {
            j1 = i1 + eue.b(7, o);
        }
        i1 = j1;
        if (p)
        {
            i1 = j1 + eue.d(8, q);
        }
        j1 = i1;
        if (r)
        {
            j1 = i1 + eue.b(9, s);
        }
        i1 = j1;
        if (t)
        {
            i1 = j1 + eue.b(10, u);
        }
        j1 = i1;
        if (v)
        {
            j1 = i1 + eue.d(11, w);
        }
        i1 = j1;
        if (z)
        {
            i1 = j1 + eue.b(13, A);
        }
        j1 = i1;
        if (B)
        {
            j1 = i1 + eue.b(14, C);
        }
        if (x)
        {
            i1 = j1 + eue.d(15, y);
        } else
        {
            i1 = j1;
        }
        iterator = m.iterator();
        for (j1 = ((flag) ? 1 : 0); iterator.hasNext(); j1 += eue.a(((Integer)iterator.next()).intValue())) { }
        j1 = i1 + j1 + m.size() * 2;
        i1 = j1;
        if (D)
        {
            i1 = j1 + eue.b(17, E);
        }
        F = i1;
        return i1;
    }
}
