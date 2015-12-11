// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eoi extends eug
{

    private boolean a;
    private epz b;
    private List c;
    private int d;

    public eoi()
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
                epz epz1 = new epz();
                eud1.a(epz1);
                a = true;
                b = epz1;
                break;

            case 18: // '\022'
                eoj eoj1 = new eoj();
                eud1.a(eoj1);
                if (c.isEmpty())
                {
                    c = new ArrayList();
                }
                c.add(eoj1);
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
        for (Iterator iterator = c.iterator(); iterator.hasNext(); eue1.b(2, (eoj)iterator.next())) { }
    }

    public final int b()
    {
        int i = 0;
        if (a)
        {
            i = eue.d(1, b) + 0;
        }
        for (Iterator iterator = c.iterator(); iterator.hasNext();)
        {
            i = eue.d(2, (eoj)iterator.next()) + i;
        }

        d = i;
        return i;
    }
}
