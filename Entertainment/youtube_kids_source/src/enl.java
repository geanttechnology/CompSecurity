// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class enl extends eug
{

    private boolean a;
    private String b;
    private List c;
    private List d;
    private List e;
    private boolean f;
    private String g;
    private boolean h;
    private String i;
    private boolean j;
    private exy k;
    private int l;

    public enl()
    {
        b = "";
        c = Collections.emptyList();
        d = Collections.emptyList();
        e = Collections.emptyList();
        g = "";
        i = "";
        k = null;
        l = -1;
    }

    public final int a()
    {
        if (l < 0)
        {
            b();
        }
        return l;
    }

    public final enl a(enz enz1)
    {
        if (c.isEmpty())
        {
            c = new ArrayList();
        }
        c.add(enz1);
        return this;
    }

    public final enl a(exy exy1)
    {
        j = true;
        k = exy1;
        return this;
    }

    public final enl a(String s)
    {
        a = true;
        b = s;
        return this;
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
                a(eud1.i());
                break;

            case 18: // '\022'
                enz enz1 = new enz();
                eud1.a(enz1);
                a(enz1);
                break;

            case 26: // '\032'
                eny eny1 = new eny();
                eud1.a(eny1);
                if (d.isEmpty())
                {
                    d = new ArrayList();
                }
                d.add(eny1);
                break;

            case 34: // '"'
                b(eud1.i());
                break;

            case 42: // '*'
                eoa eoa1 = new eoa();
                eud1.a(eoa1);
                if (e.isEmpty())
                {
                    e = new ArrayList();
                }
                e.add(eoa1);
                break;

            case 50: // '2'
                String s = eud1.i();
                f = true;
                g = s;
                break;

            case 312054450: 
                exy exy1 = new exy();
                eud1.a(exy1);
                a(exy1);
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
        for (Iterator iterator = c.iterator(); iterator.hasNext(); eue1.b(2, (enz)iterator.next())) { }
        for (Iterator iterator1 = d.iterator(); iterator1.hasNext(); eue1.b(3, (eny)iterator1.next())) { }
        if (h)
        {
            eue1.a(4, i);
        }
        for (Iterator iterator2 = e.iterator(); iterator2.hasNext(); eue1.b(5, (eoa)iterator2.next())) { }
        if (f)
        {
            eue1.a(6, g);
        }
        if (j)
        {
            eue1.b(0x2533256, k);
        }
    }

    public final int b()
    {
        int i1 = 0;
        if (a)
        {
            i1 = eue.b(1, b) + 0;
        }
        for (Iterator iterator = c.iterator(); iterator.hasNext();)
        {
            i1 = eue.d(2, (enz)iterator.next()) + i1;
        }

        for (Iterator iterator1 = d.iterator(); iterator1.hasNext();)
        {
            i1 += eue.d(3, (eny)iterator1.next());
        }

        int j1 = i1;
        if (h)
        {
            j1 = i1 + eue.b(4, i);
        }
        for (Iterator iterator2 = e.iterator(); iterator2.hasNext();)
        {
            j1 += eue.d(5, (eoa)iterator2.next());
        }

        i1 = j1;
        if (f)
        {
            i1 = j1 + eue.b(6, g);
        }
        j1 = i1;
        if (j)
        {
            j1 = i1 + eue.d(0x2533256, k);
        }
        l = j1;
        return j1;
    }

    public final enl b(String s)
    {
        h = true;
        i = s;
        return this;
    }
}
