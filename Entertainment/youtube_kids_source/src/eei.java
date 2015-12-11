// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eei extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private List g;
    private List h;
    private boolean i;
    private String j;
    private boolean k;
    private String l;
    private int m;

    public eei()
    {
        b = 0;
        d = "";
        f = "";
        g = Collections.emptyList();
        h = Collections.emptyList();
        j = "";
        l = "";
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

            case 8: // '\b'
                int j1 = eud1.f();
                a = true;
                b = j1;
                break;

            case 18: // '\022'
                String s = eud1.i();
                c = true;
                d = s;
                break;

            case 26: // '\032'
                String s1 = eud1.i();
                e = true;
                f = s1;
                break;

            case 34: // '"'
                eej eej1 = new eej();
                eud1.a(eej1);
                if (g.isEmpty())
                {
                    g = new ArrayList();
                }
                g.add(eej1);
                break;

            case 42: // '*'
                String s2 = eud1.i();
                i = true;
                j = s2;
                break;

            case 50: // '2'
                eej eej2 = new eej();
                eud1.a(eej2);
                if (h.isEmpty())
                {
                    h = new ArrayList();
                }
                h.add(eej2);
                break;

            case 58: // ':'
                String s3 = eud1.i();
                k = true;
                l = s3;
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
        for (Iterator iterator = g.iterator(); iterator.hasNext(); eue1.b(4, (eej)iterator.next())) { }
        if (i)
        {
            eue1.a(5, j);
        }
        for (Iterator iterator1 = h.iterator(); iterator1.hasNext(); eue1.b(6, (eej)iterator1.next())) { }
        if (k)
        {
            eue1.a(7, l);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.d(1, b) + 0;
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
        Iterator iterator = g.iterator();
        for (i1 = j1; iterator.hasNext(); i1 = eue.d(4, (eej)iterator.next()) + i1) { }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.b(5, j);
        }
        for (Iterator iterator1 = h.iterator(); iterator1.hasNext();)
        {
            j1 += eue.d(6, (eej)iterator1.next());
        }

        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.b(7, l);
        }
        m = i1;
        return i1;
    }
}
