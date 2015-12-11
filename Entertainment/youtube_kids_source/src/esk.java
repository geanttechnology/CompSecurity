// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class esk extends eug
{

    private boolean a;
    private String b;
    private List c;
    private int d;

    public esk()
    {
        b = "";
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
                String s = eud1.i();
                a = true;
                b = s;
                break;

            case 18: // '\022'
                esh esh1 = new esh();
                eud1.a(esh1);
                if (c.isEmpty())
                {
                    c = new ArrayList();
                }
                c.add(esh1);
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
        for (Iterator iterator = c.iterator(); iterator.hasNext(); eue1.b(2, (esh)iterator.next())) { }
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
            i = eue.d(2, (esh)iterator.next()) + i;
        }

        d = i;
        return i;
    }
}
