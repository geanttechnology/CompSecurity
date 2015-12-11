// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class etg extends eug
{

    private List a;
    private boolean b;
    private String c;
    private boolean d;
    private String e;
    private List f;
    private int g;

    public etg()
    {
        a = Collections.emptyList();
        c = "";
        e = "";
        f = Collections.emptyList();
        g = -1;
    }

    public final int a()
    {
        if (g < 0)
        {
            b();
        }
        return g;
    }

    public final etg a(ett ett1)
    {
        if (a.isEmpty())
        {
            a = new ArrayList();
        }
        a.add(ett1);
        return this;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int i = eud1.a();
            switch (i)
            {
            default:
                if (a(eud1, i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                ett ett1 = new ett();
                eud1.a(ett1);
                a(ett1);
                break;

            case 18: // '\022'
                String s = eud1.i();
                b = true;
                c = s;
                break;

            case 26: // '\032'
                String s1 = eud1.i();
                d = true;
                e = s1;
                break;

            case 34: // '"'
                erj erj1 = new erj();
                eud1.a(erj1);
                if (f.isEmpty())
                {
                    f = new ArrayList();
                }
                f.add(erj1);
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(1, (ett)iterator.next())) { }
        if (b)
        {
            eue1.a(2, c);
        }
        if (d)
        {
            eue1.a(3, e);
        }
        for (Iterator iterator1 = f.iterator(); iterator1.hasNext(); eue1.b(4, (erj)iterator1.next())) { }
    }

    public final int b()
    {
        Iterator iterator = a.iterator();
        int j;
        for (j = 0; iterator.hasNext(); j = eue.d(1, (ett)iterator.next()) + j) { }
        int i = j;
        if (b)
        {
            i = j + eue.b(2, c);
        }
        j = i;
        if (d)
        {
            j = i + eue.b(3, e);
        }
        for (Iterator iterator1 = f.iterator(); iterator1.hasNext();)
        {
            j += eue.d(4, (erj)iterator1.next());
        }

        g = j;
        return j;
    }
}
