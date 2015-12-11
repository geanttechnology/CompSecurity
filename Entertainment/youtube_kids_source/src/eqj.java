// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eqj extends eug
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
    private eqi j;
    private boolean k;
    private eqi l;
    private boolean m;
    private boolean n;
    private List o;
    private boolean p;
    private boolean q;
    private List r;
    private int s;

    public eqj()
    {
        b = "";
        d = "";
        f = "";
        h = "";
        j = null;
        l = null;
        n = false;
        o = Collections.emptyList();
        q = false;
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
                eqi eqi1 = new eqi();
                eud1.a(eqi1);
                i = true;
                j = eqi1;
                break;

            case 50: // '2'
                eqi eqi2 = new eqi();
                eud1.a(eqi2);
                k = true;
                l = eqi2;
                break;

            case 58: // ':'
                eqk eqk1 = new eqk();
                eud1.a(eqk1);
                if (o.isEmpty())
                {
                    o = new ArrayList();
                }
                o.add(eqk1);
                break;

            case 64: // '@'
                boolean flag = eud1.h();
                p = true;
                q = flag;
                break;

            case 72: // 'H'
                boolean flag1 = eud1.h();
                m = true;
                n = flag1;
                break;

            case 82: // 'R'
                eql eql1 = new eql();
                eud1.a(eql1);
                if (r.isEmpty())
                {
                    r = new ArrayList();
                }
                r.add(eql1);
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
            eue1.b(5, j);
        }
        if (k)
        {
            eue1.b(6, l);
        }
        for (Iterator iterator = o.iterator(); iterator.hasNext(); eue1.b(7, (eqk)iterator.next())) { }
        if (p)
        {
            eue1.a(8, q);
        }
        if (m)
        {
            eue1.a(9, n);
        }
        for (Iterator iterator1 = r.iterator(); iterator1.hasNext(); eue1.b(10, (eql)iterator1.next())) { }
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
            j1 = i1 + eue.d(5, j);
        }
        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.d(6, l);
        }
        Iterator iterator = o.iterator();
        for (j1 = i1; iterator.hasNext(); j1 = eue.d(7, (eqk)iterator.next()) + j1) { }
        i1 = j1;
        if (p)
        {
            i1 = j1 + eue.b(8, q);
        }
        j1 = i1;
        if (m)
        {
            j1 = i1 + eue.b(9, n);
        }
        for (Iterator iterator1 = r.iterator(); iterator1.hasNext();)
        {
            j1 += eue.d(10, (eql)iterator1.next());
        }

        s = j1;
        return j1;
    }
}
