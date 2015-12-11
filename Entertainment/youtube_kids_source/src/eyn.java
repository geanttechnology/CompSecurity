// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eyn extends eug
{

    public String a;
    public int b;
    public String c;
    public List d;
    public boolean e;
    public int f;
    public boolean g;
    public int h;
    private boolean i;
    private List j;
    private boolean k;
    private String l;
    private boolean m;
    private boolean n;
    private int o;
    private boolean p;
    private boolean q;
    private String r;
    private List s;
    private int t;

    public eyn()
    {
        a = "";
        j = Collections.emptyList();
        l = "";
        b = 0;
        o = 0;
        c = "";
        d = Collections.emptyList();
        f = 0;
        r = "";
        h = 0;
        s = Collections.emptyList();
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
        return b(eud1);
    }

    public final void a(eue eue1)
    {
        if (i)
        {
            eue1.a(1, a);
        }
        for (Iterator iterator = j.iterator(); iterator.hasNext(); eue1.a(2, (String)iterator.next())) { }
        if (k)
        {
            eue1.a(3, l);
        }
        if (m)
        {
            eue1.a(4, b);
        }
        if (n)
        {
            eue1.a(5, o);
        }
        if (p)
        {
            eue1.a(6, c);
        }
        for (Iterator iterator1 = d.iterator(); iterator1.hasNext(); eue1.a(7, ((Integer)iterator1.next()).intValue())) { }
        if (e)
        {
            eue1.a(8, f);
        }
        if (q)
        {
            eue1.a(9, r);
        }
        if (g)
        {
            eue1.a(10, h);
        }
        for (Iterator iterator2 = s.iterator(); iterator2.hasNext(); eue1.b(11, (eyo)iterator2.next())) { }
    }

    public final int b()
    {
        boolean flag = false;
        Iterator iterator;
        int i1;
        int j1;
        if (i)
        {
            i1 = eue.b(1, a) + 0;
        } else
        {
            i1 = 0;
        }
        iterator = j.iterator();
        for (j1 = 0; iterator.hasNext(); j1 = eue.a((String)iterator.next()) + j1) { }
        j1 = i1 + j1 + j.size() * 1;
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.b(3, l);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.d(4, b);
        }
        i1 = j1;
        if (n)
        {
            i1 = j1 + eue.d(5, o);
        }
        if (p)
        {
            i1 += eue.b(6, c);
        }
        iterator = d.iterator();
        for (j1 = ((flag) ? 1 : 0); iterator.hasNext(); j1 += eue.a(((Integer)iterator.next()).intValue())) { }
        j1 = i1 + j1 + d.size() * 1;
        i1 = j1;
        if (e)
        {
            i1 = j1 + eue.d(8, f);
        }
        j1 = i1;
        if (q)
        {
            j1 = i1 + eue.b(9, r);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.d(10, h);
        }
        for (Iterator iterator1 = s.iterator(); iterator1.hasNext();)
        {
            i1 = eue.d(11, (eyo)iterator1.next()) + i1;
        }

        t = i1;
        return i1;
    }

    public final eyn b(eud eud1)
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
                i = true;
                a = s1;
                break;

            case 18: // '\022'
                String s2 = eud1.i();
                if (s2 == null)
                {
                    throw new NullPointerException();
                }
                if (j.isEmpty())
                {
                    j = new ArrayList();
                }
                j.add(s2);
                break;

            case 26: // '\032'
                String s3 = eud1.i();
                k = true;
                l = s3;
                break;

            case 32: // ' '
                int j1 = eud1.f();
                m = true;
                b = j1;
                break;

            case 40: // '('
                int k1 = eud1.f();
                n = true;
                o = k1;
                break;

            case 50: // '2'
                String s4 = eud1.i();
                p = true;
                c = s4;
                break;

            case 56: // '8'
                int l1 = eud1.f();
                if (d.isEmpty())
                {
                    d = new ArrayList();
                }
                d.add(Integer.valueOf(l1));
                break;

            case 64: // '@'
                int i2 = eud1.f();
                e = true;
                f = i2;
                break;

            case 74: // 'J'
                String s5 = eud1.i();
                q = true;
                r = s5;
                break;

            case 80: // 'P'
                int j2 = eud1.f();
                g = true;
                h = j2;
                break;

            case 90: // 'Z'
                eyo eyo1 = new eyo();
                eud1.a(eyo1);
                if (s.isEmpty())
                {
                    s = new ArrayList();
                }
                s.add(eyo1);
                break;
            }
        } while (true);
    }
}
