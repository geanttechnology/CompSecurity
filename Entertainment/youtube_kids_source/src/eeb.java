// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eeb extends eug
{

    private boolean a;
    private String b;
    private List c;
    private boolean d;
    private int e;
    private boolean f;
    private boolean g;
    private boolean h;
    private String i;
    private boolean j;
    private String k;
    private boolean l;
    private String m;
    private boolean n;
    private String o;
    private boolean p;
    private String q;
    private List r;
    private int s;

    public eeb()
    {
        b = "";
        c = Collections.emptyList();
        e = 0;
        g = false;
        i = "";
        k = "";
        m = "";
        o = "";
        q = "";
        r = Collections.emptyList();
        s = -1;
    }

    public final int a()
    {
        if (s < 0)
        {
            b();
        }
        return s;
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

            case 16: // '\020'
                int j1 = eud1.f();
                if (c.isEmpty())
                {
                    c = new ArrayList();
                }
                c.add(Integer.valueOf(j1));
                break;

            case 24: // '\030'
                boolean flag = eud1.h();
                f = true;
                g = flag;
                break;

            case 34: // '"'
                String s2 = eud1.i();
                h = true;
                i = s2;
                break;

            case 42: // '*'
                String s3 = eud1.i();
                j = true;
                k = s3;
                break;

            case 50: // '2'
                String s4 = eud1.i();
                l = true;
                m = s4;
                break;

            case 58: // ':'
                String s5 = eud1.i();
                p = true;
                q = s5;
                break;

            case 64: // '@'
                int k1 = eud1.f();
                d = true;
                e = k1;
                break;

            case 74: // 'J'
                String s6 = eud1.i();
                n = true;
                o = s6;
                break;

            case 82: // 'R'
                String s7 = eud1.i();
                if (s7 == null)
                {
                    throw new NullPointerException();
                }
                if (r.isEmpty())
                {
                    r = new ArrayList();
                }
                r.add(s7);
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
        for (Iterator iterator = c.iterator(); iterator.hasNext(); eue1.a(2, ((Integer)iterator.next()).intValue())) { }
        if (f)
        {
            eue1.a(3, g);
        }
        if (h)
        {
            eue1.a(4, i);
        }
        if (j)
        {
            eue1.a(5, k);
        }
        if (l)
        {
            eue1.a(6, m);
        }
        if (p)
        {
            eue1.a(7, q);
        }
        if (d)
        {
            eue1.a(8, e);
        }
        if (n)
        {
            eue1.a(9, o);
        }
        for (Iterator iterator1 = r.iterator(); iterator1.hasNext(); eue1.a(10, (String)iterator1.next())) { }
    }

    public final int b()
    {
        boolean flag = false;
        Iterator iterator;
        int i1;
        int j1;
        if (a)
        {
            i1 = eue.b(1, b) + 0;
        } else
        {
            i1 = 0;
        }
        iterator = c.iterator();
        for (j1 = 0; iterator.hasNext(); j1 = eue.a(((Integer)iterator.next()).intValue()) + j1) { }
        j1 = i1 + j1 + c.size() * 1;
        i1 = j1;
        if (f)
        {
            i1 = j1 + eue.b(3, g);
        }
        j1 = i1;
        if (h)
        {
            j1 = i1 + eue.b(4, i);
        }
        i1 = j1;
        if (j)
        {
            i1 = j1 + eue.b(5, k);
        }
        j1 = i1;
        if (l)
        {
            j1 = i1 + eue.b(6, m);
        }
        i1 = j1;
        if (p)
        {
            i1 = j1 + eue.b(7, q);
        }
        j1 = i1;
        if (d)
        {
            j1 = i1 + eue.d(8, e);
        }
        if (n)
        {
            i1 = j1 + eue.b(9, o);
        } else
        {
            i1 = j1;
        }
        iterator = r.iterator();
        for (j1 = ((flag) ? 1 : 0); iterator.hasNext(); j1 += eue.a((String)iterator.next())) { }
        i1 = i1 + j1 + r.size() * 1;
        s = i1;
        return i1;
    }
}
