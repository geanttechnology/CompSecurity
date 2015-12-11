// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eru extends eug
{

    private List a;
    private List b;
    private boolean c;
    private String d;
    private boolean e;
    private euc f;
    private boolean g;
    private String h;
    private boolean i;
    private int j;
    private boolean k;
    private int l;
    private int m;

    public eru()
    {
        a = Collections.emptyList();
        b = Collections.emptyList();
        d = "";
        f = euc.b;
        h = "";
        j = 0;
        l = 0;
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
                ert ert1 = new ert();
                eud1.a(ert1);
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(ert1);
                break;

            case 18: // '\022'
                String s = eud1.i();
                c = true;
                d = s;
                break;

            case 24: // '\030'
                int j1 = eud1.f();
                i = true;
                j = j1;
                break;

            case 34: // '"'
                ert ert2 = new ert();
                eud1.a(ert2);
                if (b.isEmpty())
                {
                    b = new ArrayList();
                }
                b.add(ert2);
                break;

            case 40: // '('
                int k1 = eud1.f();
                k = true;
                l = k1;
                break;

            case 50: // '2'
                String s1 = eud1.i();
                g = true;
                h = s1;
                break;

            case 58: // ':'
                euc euc1 = eud1.j();
                e = true;
                f = euc1;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(1, (ert)iterator.next())) { }
        if (c)
        {
            eue1.a(2, d);
        }
        if (i)
        {
            eue1.a(3, j);
        }
        for (Iterator iterator1 = b.iterator(); iterator1.hasNext(); eue1.b(4, (ert)iterator1.next())) { }
        if (k)
        {
            eue1.a(5, l);
        }
        if (g)
        {
            eue1.a(6, h);
        }
        if (e)
        {
            eue1.a(7, f);
        }
    }

    public final int b()
    {
        Iterator iterator = a.iterator();
        int j1;
        for (j1 = 0; iterator.hasNext(); j1 = eue.d(1, (ert)iterator.next()) + j1) { }
        int i1 = j1;
        if (c)
        {
            i1 = j1 + eue.b(2, d);
        }
        j1 = i1;
        if (i)
        {
            j1 = i1 + eue.d(3, j);
        }
        for (Iterator iterator1 = b.iterator(); iterator1.hasNext();)
        {
            j1 += eue.d(4, (ert)iterator1.next());
        }

        i1 = j1;
        if (k)
        {
            i1 = j1 + eue.d(5, l);
        }
        j1 = i1;
        if (g)
        {
            j1 = i1 + eue.b(6, h);
        }
        i1 = j1;
        if (e)
        {
            i1 = j1 + eue.b(7, f);
        }
        m = i1;
        return i1;
    }
}
