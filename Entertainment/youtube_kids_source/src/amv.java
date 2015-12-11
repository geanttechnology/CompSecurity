// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class amv extends eug
{

    public boolean a;
    public String b;
    public boolean c;
    public long d;
    public long e;
    private boolean f;
    private List g;
    private int h;

    public amv()
    {
        b = "";
        d = 0L;
        e = 0L;
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

    public final amv a(long l)
    {
        c = true;
        d = l;
        return this;
    }

    public final amv a(String s)
    {
        a = true;
        b = s;
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
                if (eud1.b(i))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 18: // '\022'
                a(eud1.i());
                break;

            case 24: // '\030'
                a(eud1.n());
                break;

            case 32: // ' '
                b(eud1.n());
                break;

            case 58: // ':'
                amu amu1 = new amu();
                eud1.a(amu1);
                if (g.isEmpty())
                {
                    g = new ArrayList();
                }
                g.add(amu1);
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.a(2, b);
        }
        if (c)
        {
            eue1.b(3, d);
        }
        if (f)
        {
            eue1.b(4, e);
        }
        for (Iterator iterator = g.iterator(); iterator.hasNext(); eue1.b(7, (amu)iterator.next())) { }
    }

    public final int b()
    {
        int j = 0;
        if (a)
        {
            j = eue.b(2, b) + 0;
        }
        int i = j;
        if (c)
        {
            i = j + eue.e(3, d);
        }
        j = i;
        if (f)
        {
            j = i + eue.e(4, e);
        }
        for (Iterator iterator = g.iterator(); iterator.hasNext();)
        {
            j = eue.d(7, (amu)iterator.next()) + j;
        }

        h = j;
        return j;
    }

    public final amv b(long l)
    {
        f = true;
        e = l;
        return this;
    }
}
