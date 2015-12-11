// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eve extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private boolean g;
    private boolean h;
    private boolean i;
    private String j;
    private boolean k;
    private String l;
    private boolean m;
    private int n;
    private boolean o;
    private int p;
    private boolean q;
    private String r;
    private boolean s;
    private String t;
    private List u;
    private int v;

    public eve()
    {
        b = "";
        d = "";
        f = "";
        h = false;
        j = "";
        l = "";
        n = 0;
        p = 0;
        r = "";
        t = "";
        u = Collections.emptyList();
        v = -1;
    }

    public final int a()
    {
        if (v < 0)
        {
            b();
        }
        return v;
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

            case 32: // ' '
                boolean flag = eud1.h();
                g = true;
                h = flag;
                break;

            case 42: // '*'
                String s4 = eud1.i();
                i = true;
                j = s4;
                break;

            case 50: // '2'
                String s5 = eud1.i();
                k = true;
                l = s5;
                break;

            case 56: // '8'
                int j1 = eud1.f();
                m = true;
                n = j1;
                break;

            case 64: // '@'
                int k1 = eud1.f();
                o = true;
                p = k1;
                break;

            case 74: // 'J'
                String s6 = eud1.i();
                q = true;
                r = s6;
                break;

            case 82: // 'R'
                String s7 = eud1.i();
                s = true;
                t = s7;
                break;

            case 90: // 'Z'
                String s8 = eud1.i();
                if (s8 == null)
                {
                    throw new NullPointerException();
                }
                if (u.isEmpty())
                {
                    u = new ArrayList();
                }
                u.add(s8);
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
        if (m)
        {
            eue1.a(7, n);
        }
        if (o)
        {
            eue1.a(8, p);
        }
        if (q)
        {
            eue1.a(9, r);
        }
        if (s)
        {
            eue1.a(10, t);
        }
        for (Iterator iterator = u.iterator(); iterator.hasNext(); eue1.a(11, (String)iterator.next())) { }
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
        if (m)
        {
            j1 = i1 + eue.d(7, n);
        }
        i1 = j1;
        if (o)
        {
            i1 = j1 + eue.d(8, p);
        }
        j1 = i1;
        if (q)
        {
            j1 = i1 + eue.b(9, r);
        }
        if (s)
        {
            i1 = j1 + eue.b(10, t);
        } else
        {
            i1 = j1;
        }
        iterator = u.iterator();
        for (j1 = ((flag) ? 1 : 0); iterator.hasNext(); j1 += eue.a((String)iterator.next())) { }
        i1 = i1 + j1 + u.size() * 1;
        v = i1;
        return i1;
    }
}
