// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eto extends eug
{

    private List a;
    private List b;
    private int c;

    public eto()
    {
        a = Collections.emptyList();
        b = Collections.emptyList();
        c = -1;
    }

    public final int a()
    {
        if (c < 0)
        {
            b();
        }
        return c;
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
                etj etj1 = new etj();
                eud1.a(etj1);
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(etj1);
                break;

            case 18: // '\022'
                etq etq1 = new etq();
                eud1.a(etq1);
                if (b.isEmpty())
                {
                    b = new ArrayList();
                }
                b.add(etq1);
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(1, (etj)iterator.next())) { }
        for (Iterator iterator1 = b.iterator(); iterator1.hasNext(); eue1.b(2, (etq)iterator1.next())) { }
    }

    public final int b()
    {
        Iterator iterator = a.iterator();
        int i;
        for (i = 0; iterator.hasNext(); i = eue.d(1, (etj)iterator.next()) + i) { }
        for (Iterator iterator1 = b.iterator(); iterator1.hasNext();)
        {
            i += eue.d(2, (etq)iterator1.next());
        }

        c = i;
        return i;
    }
}
