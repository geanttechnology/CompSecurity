// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eos extends eug
{

    private List a;
    private boolean b;
    private String c;
    private int d;

    public eos()
    {
        a = Collections.emptyList();
        c = "";
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
                eoq eoq1 = new eoq();
                eud1.a(eoq1);
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(eoq1);
                break;

            case 18: // '\022'
                String s = eud1.i();
                b = true;
                c = s;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(1, (eoq)iterator.next())) { }
        if (b)
        {
            eue1.a(2, c);
        }
    }

    public final int b()
    {
        Iterator iterator = a.iterator();
        int i;
        for (i = 0; iterator.hasNext(); i = eue.d(1, (eoq)iterator.next()) + i) { }
        int j = i;
        if (b)
        {
            j = i + eue.b(2, c);
        }
        d = j;
        return j;
    }
}
