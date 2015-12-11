// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eoo extends eug
{

    private boolean a;
    private String b;
    private List c;
    private boolean d;
    private int e;
    private int f;

    public eoo()
    {
        b = "";
        c = Collections.emptyList();
        e = 0;
        f = -1;
    }

    public final int a()
    {
        if (f < 0)
        {
            b();
        }
        return f;
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
                eop eop1 = new eop();
                eud1.a(eop1);
                if (c.isEmpty())
                {
                    c = new ArrayList();
                }
                c.add(eop1);
                break;

            case 24: // '\030'
                int j = eud1.f();
                d = true;
                e = j;
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
        for (Iterator iterator = c.iterator(); iterator.hasNext(); eue1.b(2, (eop)iterator.next())) { }
        if (d)
        {
            eue1.a(3, e);
        }
    }

    public final int b()
    {
        int i = 0;
        if (a)
        {
            i = eue.b(1, b) + 0;
        }
        for (Iterator iterator = c.iterator(); iterator.hasNext();)
        {
            i = eue.d(2, (eop)iterator.next()) + i;
        }

        int j = i;
        if (d)
        {
            j = i + eue.d(3, e);
        }
        f = j;
        return j;
    }
}
