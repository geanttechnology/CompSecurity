// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eeu extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private eez d;
    private List e;
    private boolean f;
    private int g;
    private boolean h;
    private int i;
    private int j;

    public eeu()
    {
        b = 0;
        d = null;
        e = Collections.emptyList();
        g = -1;
        i = -1;
        j = -1;
    }

    public final int a()
    {
        if (j < 0)
        {
            b();
        }
        return j;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int k = eud1.a();
            switch (k)
            {
            default:
                if (a(eud1, k))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                int l = eud1.f();
                a = true;
                b = l;
                break;

            case 18: // '\022'
                eez eez1 = new eez();
                eud1.a(eez1);
                c = true;
                d = eez1;
                break;

            case 26: // '\032'
                eey eey1 = new eey();
                eud1.a(eey1);
                if (e.isEmpty())
                {
                    e = new ArrayList();
                }
                e.add(eey1);
                break;

            case 32: // ' '
                int i1 = eud1.f();
                f = true;
                g = i1;
                break;

            case 40: // '('
                int j1 = eud1.f();
                h = true;
                i = j1;
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
            eue1.b(2, d);
        }
        for (Iterator iterator = e.iterator(); iterator.hasNext(); eue1.b(3, (eey)iterator.next())) { }
        if (f)
        {
            eue1.a(4, g);
        }
        if (h)
        {
            eue1.a(5, i);
        }
    }

    public final int b()
    {
        int k = 0;
        if (a)
        {
            k = eue.d(1, b) + 0;
        }
        int l = k;
        if (c)
        {
            l = k + eue.d(2, d);
        }
        for (Iterator iterator = e.iterator(); iterator.hasNext();)
        {
            l = eue.d(3, (eey)iterator.next()) + l;
        }

        k = l;
        if (f)
        {
            k = l + eue.d(4, g);
        }
        l = k;
        if (h)
        {
            l = k + eue.d(5, i);
        }
        j = l;
        return l;
    }
}
