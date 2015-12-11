// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eoe extends eug
{

    private List a;
    private List b;
    private List c;
    private List d;
    private boolean e;
    private String f;
    private boolean g;
    private eub h;
    private boolean i;
    private String j;
    private boolean k;
    private eub l;
    private int m;

    public eoe()
    {
        a = Collections.emptyList();
        b = Collections.emptyList();
        c = Collections.emptyList();
        d = Collections.emptyList();
        f = "";
        h = null;
        j = "";
        l = null;
        m = -1;
    }

    public final int a()
    {
        if (m < 0)
        {
            b();
        }
        return m;
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
                enm enm1 = new enm();
                eud1.a(enm1);
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(enm1);
                break;

            case 18: // '\022'
                enm enm2 = new enm();
                eud1.a(enm2);
                if (c.isEmpty())
                {
                    c = new ArrayList();
                }
                c.add(enm2);
                break;

            case 26: // '\032'
                enm enm3 = new enm();
                eud1.a(enm3);
                if (d.isEmpty())
                {
                    d = new ArrayList();
                }
                d.add(enm3);
                break;

            case 34: // '"'
                String s = eud1.i();
                e = true;
                f = s;
                break;

            case 42: // '*'
                String s1 = eud1.i();
                i = true;
                j = s1;
                break;

            case 50: // '2'
                eub eub1 = new eub();
                eud1.a(eub1);
                g = true;
                h = eub1;
                break;

            case 58: // ':'
                eub eub2 = new eub();
                eud1.a(eub2);
                k = true;
                l = eub2;
                break;

            case 66: // 'B'
                erd erd1 = new erd();
                eud1.a(erd1);
                if (b.isEmpty())
                {
                    b = new ArrayList();
                }
                b.add(erd1);
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(1, (enm)iterator.next())) { }
        for (Iterator iterator1 = c.iterator(); iterator1.hasNext(); eue1.b(2, (enm)iterator1.next())) { }
        for (Iterator iterator2 = d.iterator(); iterator2.hasNext(); eue1.b(3, (enm)iterator2.next())) { }
        if (e)
        {
            eue1.a(4, f);
        }
        if (i)
        {
            eue1.a(5, j);
        }
        if (g)
        {
            eue1.b(6, h);
        }
        if (k)
        {
            eue1.b(7, l);
        }
        for (Iterator iterator3 = b.iterator(); iterator3.hasNext(); eue1.b(8, (erd)iterator3.next())) { }
    }

    public final int b()
    {
        Iterator iterator = a.iterator();
        int i1;
        for (i1 = 0; iterator.hasNext(); i1 = eue.d(1, (enm)iterator.next()) + i1) { }
        for (iterator = c.iterator(); iterator.hasNext();)
        {
            i1 += eue.d(2, (enm)iterator.next());
        }

        iterator = d.iterator();
        int j1;
        for (j1 = i1; iterator.hasNext(); j1 += eue.d(3, (enm)iterator.next())) { }
        i1 = j1;
        if (e)
        {
            i1 = j1 + eue.b(4, f);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.b(5, j);
        }
        i1 = j1;
        if (g)
        {
            i1 = j1 + eue.d(6, h);
        }
        j1 = i1;
        if (k)
        {
            j1 = i1 + eue.d(7, l);
        }
        for (Iterator iterator1 = b.iterator(); iterator1.hasNext();)
        {
            j1 += eue.d(8, (erd)iterator1.next());
        }

        m = j1;
        return j1;
    }
}
