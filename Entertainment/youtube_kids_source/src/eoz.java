// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eoz extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private List e;
    private boolean f;
    private double g;
    private boolean h;
    private int i;
    private int j;

    public eoz()
    {
        b = "";
        d = "";
        e = Collections.emptyList();
        g = 0.0D;
        i = 0;
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

            case 18: // '\022'
                String s1 = eud1.i();
                c = true;
                d = s1;
                break;

            case 26: // '\032'
                epa epa1 = new epa();
                eud1.a(epa1);
                if (e.isEmpty())
                {
                    e = new ArrayList();
                }
                e.add(epa1);
                break;

            case 33: // '!'
                double d1 = eud1.b();
                f = true;
                g = d1;
                break;

            case 40: // '('
                int l = eud1.f();
                h = true;
                i = l;
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
        for (Iterator iterator = e.iterator(); iterator.hasNext(); eue1.b(3, (epa)iterator.next())) { }
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
            k = eue.b(1, b) + 0;
        }
        int l = k;
        if (c)
        {
            l = k + eue.b(2, d);
        }
        for (Iterator iterator = e.iterator(); iterator.hasNext();)
        {
            l = eue.d(3, (epa)iterator.next()) + l;
        }

        k = l;
        if (f)
        {
            k = l + eue.b(4, g);
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
