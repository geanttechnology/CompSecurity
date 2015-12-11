// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class evu extends eug
{

    private List a;
    private boolean b;
    private boolean c;
    private int d;

    public evu()
    {
        a = Collections.emptyList();
        c = false;
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
                evv evv1 = new evv();
                eud1.a(evv1);
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(evv1);
                break;

            case 16: // '\020'
                boolean flag = eud1.h();
                b = true;
                c = flag;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(1, (evv)iterator.next())) { }
        if (b)
        {
            eue1.a(2, c);
        }
    }

    public final int b()
    {
        Iterator iterator = a.iterator();
        int i;
        for (i = 0; iterator.hasNext(); i = eue.d(1, (evv)iterator.next()) + i) { }
        int j = i;
        if (b)
        {
            j = i + eue.b(2, c);
        }
        d = j;
        return j;
    }
}
