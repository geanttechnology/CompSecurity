// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ams extends eug
{

    private boolean A;
    private boolean B;
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    public String a;
    public List b;
    public String c;
    public int d;
    public String e;
    public euc f;
    public boolean g;
    public boolean h;
    public boolean i;
    public int j;
    public int k;
    public String l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public String q;
    private boolean r;
    private boolean s;
    private boolean t;
    private boolean u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public ams()
    {
        a = "";
        b = Collections.emptyList();
        c = "";
        d = 0;
        e = "";
        f = euc.b;
        g = false;
        h = false;
        i = false;
        j = 0;
        k = 0;
        l = "";
        m = false;
        n = false;
        o = false;
        q = "";
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

    public final ams a(int i1)
    {
        t = true;
        d = i1;
        return this;
    }

    public final ams a(euc euc1)
    {
        v = true;
        f = euc1;
        return this;
    }

    public final ams a(String s1)
    {
        r = true;
        a = s1;
        return this;
    }

    public final ams a(boolean flag)
    {
        w = true;
        g = flag;
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
                if (eud1.b(i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                a(eud1.i());
                break;

            case 18: // '\022'
                String s1 = eud1.i();
                if (s1 == null)
                {
                    throw new NullPointerException();
                }
                if (b.isEmpty())
                {
                    b = new ArrayList();
                }
                b.add(s1);
                break;

            case 26: // '\032'
                b(eud1.i());
                break;

            case 32: // ' '
                a(eud1.f());
                break;

            case 42: // '*'
                c(eud1.i());
                break;

            case 50: // '2'
                a(eud1.j());
                break;

            case 56: // '8'
                a(eud1.h());
                break;

            case 64: // '@'
                b(eud1.h());
                break;

            case 72: // 'H'
                c(eud1.h());
                break;

            case 80: // 'P'
                b(eud1.f());
                break;

            case 88: // 'X'
                c(eud1.f());
                break;

            case 98: // 'b'
                d(eud1.i());
                break;

            case 104: // 'h'
                d(eud1.h());
                break;

            case 112: // 'p'
                boolean flag = eud1.h();
                D = true;
                n = flag;
                break;

            case 120: // 'x'
                boolean flag1 = eud1.h();
                E = true;
                o = flag1;
                break;

            case 130: 
                e(eud1.i());
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (r)
        {
            eue1.a(1, a);
        }
        for (Iterator iterator = b.iterator(); iterator.hasNext(); eue1.a(2, (String)iterator.next())) { }
        if (s)
        {
            eue1.a(3, c);
        }
        if (t)
        {
            eue1.a(4, d);
        }
        if (u)
        {
            eue1.a(5, e);
        }
        if (v)
        {
            eue1.a(6, f);
        }
        if (w)
        {
            eue1.a(7, g);
        }
        if (x)
        {
            eue1.a(8, h);
        }
        if (y)
        {
            eue1.a(9, i);
        }
        if (z)
        {
            eue1.a(10, j);
        }
        if (A)
        {
            eue1.a(11, k);
        }
        if (B)
        {
            eue1.a(12, l);
        }
        if (C)
        {
            eue1.a(13, m);
        }
        if (D)
        {
            eue1.a(14, n);
        }
        if (E)
        {
            eue1.a(15, o);
        }
        if (p)
        {
            eue1.a(16, q);
        }
    }

    public final int b()
    {
        int j1 = 0;
        Iterator iterator;
        int i1;
        if (r)
        {
            i1 = eue.b(1, a) + 0;
        } else
        {
            i1 = 0;
        }
        for (iterator = b.iterator(); iterator.hasNext();)
        {
            j1 += eue.a((String)iterator.next());
        }

        j1 = i1 + j1 + b.size() * 1;
        i1 = j1;
        if (s)
        {
            i1 = j1 + eue.b(3, c);
        }
        j1 = i1;
        if (t)
        {
            j1 = i1 + eue.d(4, d);
        }
        i1 = j1;
        if (u)
        {
            i1 = j1 + eue.b(5, e);
        }
        j1 = i1;
        if (v)
        {
            j1 = i1 + eue.b(6, f);
        }
        i1 = j1;
        if (w)
        {
            boolean flag = g;
            i1 = j1 + (eue.b(7) + 1);
        }
        j1 = i1;
        if (x)
        {
            boolean flag1 = h;
            j1 = i1 + (eue.b(8) + 1);
        }
        i1 = j1;
        if (y)
        {
            boolean flag2 = i;
            i1 = j1 + (eue.b(9) + 1);
        }
        j1 = i1;
        if (z)
        {
            j1 = i1 + eue.d(10, j);
        }
        i1 = j1;
        if (A)
        {
            i1 = j1 + eue.d(11, k);
        }
        j1 = i1;
        if (B)
        {
            j1 = i1 + eue.b(12, l);
        }
        i1 = j1;
        if (C)
        {
            boolean flag3 = m;
            i1 = j1 + (eue.b(13) + 1);
        }
        j1 = i1;
        if (D)
        {
            boolean flag4 = n;
            j1 = i1 + (eue.b(14) + 1);
        }
        i1 = j1;
        if (E)
        {
            boolean flag5 = o;
            i1 = j1 + (eue.b(15) + 1);
        }
        j1 = i1;
        if (p)
        {
            j1 = i1 + eue.b(16, q);
        }
        F = j1;
        return j1;
    }

    public final ams b(int i1)
    {
        z = true;
        j = i1;
        return this;
    }

    public final ams b(String s1)
    {
        s = true;
        c = s1;
        return this;
    }

    public final ams b(boolean flag)
    {
        x = true;
        h = flag;
        return this;
    }

    public final ams c(int i1)
    {
        A = true;
        k = i1;
        return this;
    }

    public final ams c(String s1)
    {
        u = true;
        e = s1;
        return this;
    }

    public final ams c(boolean flag)
    {
        y = true;
        i = flag;
        return this;
    }

    public final ams d(String s1)
    {
        B = true;
        l = s1;
        return this;
    }

    public final ams d(boolean flag)
    {
        C = true;
        m = flag;
        return this;
    }

    public final ams e(String s1)
    {
        p = true;
        q = s1;
        return this;
    }
}
