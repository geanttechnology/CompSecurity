// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eqo extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private List e;
    private boolean f;
    private int g;
    private boolean h;
    private String i;
    private boolean j;
    private long k;
    private boolean l;
    private String m;
    private boolean n;
    private int o;
    private boolean p;
    private String q;
    private boolean r;
    private boolean s;
    private int t;

    public eqo()
    {
        b = "";
        d = "";
        e = Collections.emptyList();
        g = 0;
        i = "";
        k = 0L;
        m = "";
        o = 0;
        q = "";
        s = false;
        t = -1;
    }

    public final int a()
    {
        if (t < 0)
        {
            b();
        }
        return t;
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
                if (s3 == null)
                {
                    throw new NullPointerException();
                }
                if (e.isEmpty())
                {
                    e = new ArrayList();
                }
                e.add(s3);
                break;

            case 34: // '"'
                String s4 = eud1.i();
                h = true;
                i = s4;
                break;

            case 40: // '('
                long l1 = eud1.e();
                j = true;
                k = l1;
                break;

            case 50: // '2'
                String s5 = eud1.i();
                l = true;
                m = s5;
                break;

            case 56: // '8'
                boolean flag = eud1.h();
                r = true;
                s = flag;
                break;

            case 64: // '@'
                int j1 = eud1.f();
                n = true;
                o = j1;
                break;

            case 74: // 'J'
                String s6 = eud1.i();
                p = true;
                q = s6;
                break;

            case 80: // 'P'
                int k1 = eud1.f();
                f = true;
                g = k1;
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
        for (Iterator iterator = e.iterator(); iterator.hasNext(); eue1.a(3, (String)iterator.next())) { }
        if (h)
        {
            eue1.a(4, i);
        }
        if (j)
        {
            eue1.b(5, k);
        }
        if (l)
        {
            eue1.a(6, m);
        }
        if (r)
        {
            eue1.a(7, s);
        }
        if (n)
        {
            eue1.a(8, o);
        }
        if (p)
        {
            eue1.a(9, q);
        }
        if (f)
        {
            eue1.a(10, g);
        }
    }

    public final int b()
    {
        int j1 = 0;
        int i1;
        if (a)
        {
            i1 = eue.b(1, b) + 0;
        } else
        {
            i1 = 0;
        }
        if (c)
        {
            i1 += eue.b(2, d);
        }
        for (Iterator iterator = e.iterator(); iterator.hasNext();)
        {
            j1 += eue.a((String)iterator.next());
        }

        j1 = i1 + j1 + e.size() * 1;
        i1 = j1;
        if (h)
        {
            i1 = j1 + eue.b(4, i);
        }
        j1 = i1;
        if (j)
        {
            j1 = i1 + eue.e(5, k);
        }
        i1 = j1;
        if (l)
        {
            i1 = j1 + eue.b(6, m);
        }
        j1 = i1;
        if (r)
        {
            j1 = i1 + eue.b(7, s);
        }
        i1 = j1;
        if (n)
        {
            i1 = j1 + eue.d(8, o);
        }
        j1 = i1;
        if (p)
        {
            j1 = i1 + eue.b(9, q);
        }
        i1 = j1;
        if (f)
        {
            i1 = j1 + eue.d(10, g);
        }
        t = i1;
        return i1;
    }
}
