// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class exa extends eug
{

    public boolean a;
    public String b;
    private boolean c;
    private String d;
    private List e;
    private boolean f;
    private String g;
    private boolean h;
    private String i;
    private boolean j;
    private String k;
    private boolean l;
    private String m;
    private boolean n;
    private String o;
    private boolean p;
    private int q;
    private boolean r;
    private int s;
    private boolean t;
    private int u;
    private List v;
    private boolean w;
    private String x;
    private int y;

    public exa()
    {
        d = "";
        b = "";
        e = Collections.emptyList();
        g = "";
        i = "";
        k = "";
        m = "";
        o = "";
        q = 0;
        s = 0;
        u = 0;
        v = Collections.emptyList();
        x = "";
        y = -1;
    }

    public final int a()
    {
        if (y < 0)
        {
            b();
        }
        return y;
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
                a(eud1.i());
                break;

            case 18: // '\022'
                f(eud1.i());
                break;

            case 34: // '"'
                b(eud1.i());
                break;

            case 42: // '*'
                c(eud1.i());
                break;

            case 66: // 'B'
                d(eud1.i());
                break;

            case 74: // 'J'
                e(eud1.i());
                break;

            case 82: // 'R'
                g(eud1.i());
                break;

            case 90: // 'Z'
                h(eud1.i());
                break;

            case 96: // '`'
                a(eud1.f());
                break;

            case 104: // 'h'
                b(eud1.f());
                break;

            case 112: // 'p'
                c(eud1.f());
                break;

            case 122: // 'z'
                String s1 = eud1.i();
                if (s1 == null)
                {
                    throw new NullPointerException();
                }
                if (v.isEmpty())
                {
                    v = new ArrayList();
                }
                v.add(s1);
                break;

            case 130: 
                i(eud1.i());
                break;
            }
        } while (true);
    }

    public final exa a(int i1)
    {
        p = true;
        q = i1;
        return this;
    }

    public final exa a(String s1)
    {
        c = true;
        d = s1;
        return this;
    }

    public final void a(eue eue1)
    {
        if (c)
        {
            eue1.a(1, d);
        }
        if (j)
        {
            eue1.a(2, k);
        }
        if (a)
        {
            eue1.a(4, b);
        }
        for (Iterator iterator = e.iterator(); iterator.hasNext(); eue1.a(5, (String)iterator.next())) { }
        if (f)
        {
            eue1.a(8, g);
        }
        if (h)
        {
            eue1.a(9, i);
        }
        if (l)
        {
            eue1.a(10, m);
        }
        if (n)
        {
            eue1.a(11, o);
        }
        if (p)
        {
            eue1.a(12, q);
        }
        if (r)
        {
            eue1.a(13, s);
        }
        if (t)
        {
            eue1.a(14, u);
        }
        for (Iterator iterator1 = v.iterator(); iterator1.hasNext(); eue1.a(15, (String)iterator1.next())) { }
        if (w)
        {
            eue1.a(16, x);
        }
    }

    public final int b()
    {
        boolean flag = false;
        Iterator iterator;
        int i1;
        int j1;
        if (c)
        {
            i1 = eue.b(1, d) + 0;
        } else
        {
            i1 = 0;
        }
        j1 = i1;
        if (j)
        {
            j1 = i1 + eue.b(2, k);
        }
        if (a)
        {
            i1 = j1 + eue.b(4, b);
        } else
        {
            i1 = j1;
        }
        iterator = e.iterator();
        for (j1 = 0; iterator.hasNext(); j1 = eue.a((String)iterator.next()) + j1) { }
        j1 = i1 + j1 + e.size() * 1;
        i1 = j1;
        if (f)
        {
            i1 = j1 + eue.b(8, g);
        }
        j1 = i1;
        if (h)
        {
            j1 = i1 + eue.b(9, i);
        }
        i1 = j1;
        if (l)
        {
            i1 = j1 + eue.b(10, m);
        }
        j1 = i1;
        if (n)
        {
            j1 = i1 + eue.b(11, o);
        }
        i1 = j1;
        if (p)
        {
            i1 = j1 + eue.d(12, q);
        }
        j1 = i1;
        if (r)
        {
            j1 = i1 + eue.d(13, s);
        }
        if (t)
        {
            i1 = j1 + eue.d(14, u);
        } else
        {
            i1 = j1;
        }
        iterator = v.iterator();
        for (j1 = ((flag) ? 1 : 0); iterator.hasNext(); j1 += eue.a((String)iterator.next())) { }
        j1 = i1 + j1 + v.size() * 1;
        i1 = j1;
        if (w)
        {
            i1 = j1 + eue.b(16, x);
        }
        y = i1;
        return i1;
    }

    public final exa b(int i1)
    {
        r = true;
        s = i1;
        return this;
    }

    public final exa b(String s1)
    {
        a = true;
        b = s1;
        return this;
    }

    public final exa c(int i1)
    {
        t = true;
        u = i1;
        return this;
    }

    public final exa c(String s1)
    {
        if (s1 == null)
        {
            throw new NullPointerException();
        }
        if (e.isEmpty())
        {
            e = new ArrayList();
        }
        e.add(s1);
        return this;
    }

    public final exa d(String s1)
    {
        f = true;
        g = s1;
        return this;
    }

    public final exa e(String s1)
    {
        h = true;
        i = s1;
        return this;
    }

    public final exa f(String s1)
    {
        j = true;
        k = s1;
        return this;
    }

    public final exa g(String s1)
    {
        l = true;
        m = s1;
        return this;
    }

    public final exa h(String s1)
    {
        n = true;
        o = s1;
        return this;
    }

    public final exa i(String s1)
    {
        w = true;
        x = s1;
        return this;
    }
}
