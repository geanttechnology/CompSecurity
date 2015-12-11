// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class efv extends eug
{

    private boolean a;
    private efr b;
    private List c;
    private int d;

    public efv()
    {
        b = null;
        c = Collections.emptyList();
        d = -1;
    }

    public final int a()
    {
        if (d < 0)
        {
            b();
        }
        return d;
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
                efr efr1 = new efr();
                eud1.a(efr1);
                a = true;
                b = efr1;
                break;

            case 16: // '\020'
                int j = eud1.f();
                if (c.isEmpty())
                {
                    c = new ArrayList();
                }
                c.add(Integer.valueOf(j));
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        if (a)
        {
            eue1.b(1, b);
        }
        for (Iterator iterator = c.iterator(); iterator.hasNext(); eue1.a(2, ((Integer)iterator.next()).intValue())) { }
    }

    public final int b()
    {
        int j = 0;
        Iterator iterator;
        int i;
        if (a)
        {
            i = eue.d(1, b) + 0;
        } else
        {
            i = 0;
        }
        for (iterator = c.iterator(); iterator.hasNext();)
        {
            j += eue.a(((Integer)iterator.next()).intValue());
        }

        i = i + j + c.size() * 1;
        d = i;
        return i;
    }
}
