// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class err extends eug
{

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
    private List p;
    private boolean q;
    private erq r;
    private boolean s;
    private erq t;
    private List u;
    private int v;

    public err()
    {
        b = "";
        d = "";
        f = "";
        h = "";
        j = "";
        l = "";
        m = Collections.emptyList();
        o = "";
        p = Collections.emptyList();
        r = null;
        t = null;
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
                esk esk1 = new esk();
                eud1.a(esk1);
                if (m.isEmpty())
                {
                    m = new ArrayList();
                }
                m.add(esk1);
                break;

            case 66: // 'B'
                String s7 = eud1.i();
                n = true;
                o = s7;
                break;

            case 74: // 'J'
                est est1 = new est();
                eud1.a(est1);
                if (p.isEmpty())
                {
                    p = new ArrayList();
                }
                p.add(est1);
                break;

            case 82: // 'R'
                erq erq1 = new erq();
                eud1.a(erq1);
                q = true;
                r = erq1;
                break;

            case 90: // 'Z'
                erq erq2 = new erq();
                eud1.a(erq2);
                s = true;
                t = erq2;
                break;

            case 98: // 'b'
                erq erq3 = new erq();
                eud1.a(erq3);
                if (u.isEmpty())
                {
                    u = new ArrayList();
                }
                u.add(erq3);
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
        for (Iterator iterator = m.iterator(); iterator.hasNext(); eue1.b(7, (esk)iterator.next())) { }
        if (n)
        {
            eue1.a(8, o);
        }
        for (Iterator iterator1 = p.iterator(); iterator1.hasNext(); eue1.b(9, (est)iterator1.next())) { }
        if (q)
        {
            eue1.b(10, r);
        }
        if (s)
        {
            eue1.b(11, t);
        }
        for (Iterator iterator2 = u.iterator(); iterator2.hasNext(); eue1.b(12, (erq)iterator2.next())) { }
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.b(1, b) + 0;
        }
        int i1 = j1;
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
        for (Iterator iterator = m.iterator(); iterator.hasNext();)
        {
            i1 = eue.d(7, (esk)iterator.next()) + i1;
        }

        j1 = i1;
        if (n)
        {
            j1 = i1 + eue.b(8, o);
        }
        for (Iterator iterator1 = p.iterator(); iterator1.hasNext();)
        {
            j1 += eue.d(9, (est)iterator1.next());
        }

        i1 = j1;
        if (q)
        {
            i1 = j1 + eue.d(10, r);
        }
        j1 = i1;
        if (s)
        {
            j1 = i1 + eue.d(11, t);
        }
        for (Iterator iterator2 = u.iterator(); iterator2.hasNext();)
        {
            j1 += eue.d(12, (erq)iterator2.next());
        }

        v = j1;
        return j1;
    }
}
