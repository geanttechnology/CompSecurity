// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eth extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private int d;
    private boolean e;
    private etk f;
    private boolean g;
    private etk h;
    private List i;
    private int j;

    public eth()
    {
        b = "";
        d = 0;
        f = null;
        h = null;
        i = Collections.emptyList();
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

            case 10: // '\n'
                String s = eud1.i();
                a = true;
                b = s;
                break;

            case 16: // '\020'
                int l = eud1.f();
                c = true;
                d = l;
                break;

            case 26: // '\032'
                etk etk1 = new etk();
                eud1.a(etk1);
                e = true;
                f = etk1;
                break;

            case 34: // '"'
                etk etk2 = new etk();
                eud1.a(etk2);
                g = true;
                h = etk2;
                break;

            case 42: // '*'
                eti eti1 = new eti();
                eud1.a(eti1);
                if (i.isEmpty())
                {
                    i = new ArrayList();
                }
                i.add(eti1);
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
            eue1.b(3, f);
        }
        if (g)
        {
            eue1.b(4, h);
        }
        for (Iterator iterator = i.iterator(); iterator.hasNext(); eue1.b(5, (eti)iterator.next())) { }
    }

    public final int b()
    {
        int l = 0;
        if (a)
        {
            l = eue.b(1, b) + 0;
        }
        int k = l;
        if (c)
        {
            k = l + eue.d(2, d);
        }
        l = k;
        if (e)
        {
            l = k + eue.d(3, f);
        }
        k = l;
        if (g)
        {
            k = l + eue.d(4, h);
        }
        for (Iterator iterator = i.iterator(); iterator.hasNext();)
        {
            k = eue.d(5, (eti)iterator.next()) + k;
        }

        j = k;
        return k;
    }
}
