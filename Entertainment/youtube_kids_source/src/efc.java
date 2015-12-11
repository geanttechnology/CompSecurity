// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class efc extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private String f;
    private List g;
    private int h;

    public efc()
    {
        b = "";
        d = "";
        f = "";
        g = Collections.emptyList();
        h = -1;
    }

    public final int a()
    {
        if (h < 0)
        {
            b();
        }
        return h;
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
                String s = eud1.i();
                a = true;
                b = s;
                break;

            case 18: // '\022'
                String s1 = eud1.i();
                e = true;
                f = s1;
                break;

            case 26: // '\032'
                String s2 = eud1.i();
                c = true;
                d = s2;
                break;

            case 58: // ':'
                efd efd1 = new efd();
                eud1.a(efd1);
                if (g.isEmpty())
                {
                    g = new ArrayList();
                }
                g.add(efd1);
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
        if (e)
        {
            eue1.a(2, f);
        }
        if (c)
        {
            eue1.a(3, d);
        }
        for (Iterator iterator = g.iterator(); iterator.hasNext(); eue1.b(7, (efd)iterator.next())) { }
    }

    public final int b()
    {
        int j = 0;
        if (a)
        {
            j = eue.b(1, b) + 0;
        }
        int i = j;
        if (e)
        {
            i = j + eue.b(2, f);
        }
        j = i;
        if (c)
        {
            j = i + eue.b(3, d);
        }
        for (Iterator iterator = g.iterator(); iterator.hasNext();)
        {
            j = eue.d(7, (efd)iterator.next()) + j;
        }

        h = j;
        return j;
    }
}
