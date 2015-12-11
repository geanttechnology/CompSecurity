// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eym extends eug
{

    public String a;
    public List b;
    private boolean c;
    private int d;

    public eym()
    {
        a = "";
        b = Collections.emptyList();
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
                String s = eud1.i();
                c = true;
                a = s;
                break;

            case 18: // '\022'
                eyf eyf1 = new eyf();
                eud1.a(eyf1);
                if (b.isEmpty())
                {
                    b = new ArrayList();
                }
                b.add(eyf1);
                break;
            }
        } while (true);
    }

    public final eyf a(int i)
    {
        return (eyf)b.get(i);
    }

    public final void a(eue eue1)
    {
        if (c)
        {
            eue1.a(1, a);
        }
        for (Iterator iterator = b.iterator(); iterator.hasNext(); eue1.b(2, (eyf)iterator.next())) { }
    }

    public final int b()
    {
        int i = 0;
        if (c)
        {
            i = eue.b(1, a) + 0;
        }
        for (Iterator iterator = b.iterator(); iterator.hasNext();)
        {
            i = eue.d(2, (eyf)iterator.next()) + i;
        }

        d = i;
        return i;
    }

    public final int d()
    {
        return b.size();
    }
}
