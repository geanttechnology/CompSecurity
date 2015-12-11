// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eoj extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private int d;
    private List e;
    private List f;
    private List g;
    private boolean h;
    private String i;
    private List j;
    private boolean k;
    private eoo l;
    private boolean m;
    private String n;
    private boolean o;
    private enc p;
    private boolean q;
    private int r;
    private boolean s;
    private int t;
    private int u;

    public eoj()
    {
        b = 0;
        d = 0;
        e = Collections.emptyList();
        f = Collections.emptyList();
        g = Collections.emptyList();
        i = "";
        j = Collections.emptyList();
        l = null;
        n = "";
        p = null;
        r = 0;
        t = 0;
        u = -1;
    }

    public final int a()
    {
        if (u < 0)
        {
            b();
        }
        return u;
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
                int j1 = eud1.f();
                a = true;
                b = j1;
                break;

            case 16: // '\020'
                int k1 = eud1.f();
                c = true;
                d = k1;
                break;

            case 26: // '\032'
                String s1 = eud1.i();
                if (s1 == null)
                {
                    throw new NullPointerException();
                }
                if (e.isEmpty())
                {
                    e = new ArrayList();
                }
                e.add(s1);
                break;

            case 32: // ' '
                int l1 = eud1.f();
                if (f.isEmpty())
                {
                    f = new ArrayList();
                }
                f.add(Integer.valueOf(l1));
                break;

            case 48: // '0'
                int i2 = eud1.f();
                if (j.isEmpty())
                {
                    j = new ArrayList();
                }
                j.add(Integer.valueOf(i2));
                break;

            case 58: // ':'
                String s2 = eud1.i();
                m = true;
                n = s2;
                break;

            case 66: // 'B'
                enc enc1 = new enc();
                eud1.a(enc1);
                o = true;
                p = enc1;
                break;

            case 72: // 'H'
                int j2 = eud1.f();
                q = true;
                r = j2;
                break;

            case 80: // 'P'
                int k2 = eud1.f();
                s = true;
                t = k2;
                break;

            case 90: // 'Z'
                eoo eoo1 = new eoo();
                eud1.a(eoo1);
                k = true;
                l = eoo1;
                break;

            case 98: // 'b'
                eop eop1 = new eop();
                eud1.a(eop1);
                if (g.isEmpty())
                {
                    g = new ArrayList();
                }
                g.add(eop1);
                break;

            case 106: // 'j'
                String s3 = eud1.i();
                h = true;
                i = s3;
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
        for (Iterator iterator1 = f.iterator(); iterator1.hasNext(); eue1.a(4, ((Integer)iterator1.next()).intValue())) { }
        for (Iterator iterator2 = j.iterator(); iterator2.hasNext(); eue1.a(6, ((Integer)iterator2.next()).intValue())) { }
        if (m)
        {
            eue1.a(7, n);
        }
        if (o)
        {
            eue1.b(8, p);
        }
        if (q)
        {
            eue1.a(9, r);
        }
        if (s)
        {
            eue1.a(10, t);
        }
        if (k)
        {
            eue1.b(11, l);
        }
        for (Iterator iterator3 = g.iterator(); iterator3.hasNext(); eue1.b(12, (eop)iterator3.next())) { }
        if (h)
        {
            eue1.a(13, i);
        }
    }

    public final int b()
    {
        int l1 = 0;
        Iterator iterator;
        int i1;
        int j1;
        int k1;
        int i2;
        int j2;
        if (a)
        {
            i1 = eue.d(1, b) + 0;
        } else
        {
            i1 = 0;
        }
        if (c)
        {
            i1 += eue.d(2, d);
        }
        iterator = e.iterator();
        for (j1 = 0; iterator.hasNext(); j1 = eue.a((String)iterator.next()) + j1) { }
        i2 = e.size();
        iterator = f.iterator();
        for (k1 = 0; iterator.hasNext(); k1 = eue.a(((Integer)iterator.next()).intValue()) + k1) { }
        j2 = f.size();
        for (Iterator iterator1 = j.iterator(); iterator1.hasNext();)
        {
            l1 += eue.a(((Integer)iterator1.next()).intValue());
        }

        j1 = j2 * 1 + (i1 + j1 + i2 * 1 + k1) + l1 + j.size() * 1;
        i1 = j1;
        if (m)
        {
            i1 = j1 + eue.b(7, n);
        }
        j1 = i1;
        if (o)
        {
            j1 = i1 + eue.d(8, p);
        }
        i1 = j1;
        if (q)
        {
            i1 = j1 + eue.d(9, r);
        }
        j1 = i1;
        if (s)
        {
            j1 = i1 + eue.d(10, t);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.d(11, l);
        }
        for (Iterator iterator2 = g.iterator(); iterator2.hasNext();)
        {
            i1 = eue.d(12, (eop)iterator2.next()) + i1;
        }

        j1 = i1;
        if (h)
        {
            j1 = i1 + eue.b(13, i);
        }
        u = j1;
        return j1;
    }
}
