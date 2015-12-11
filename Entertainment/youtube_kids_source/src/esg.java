// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class esg extends eug
{

    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private List e;
    private int f;

    public esg()
    {
        b = false;
        d = false;
        e = Collections.emptyList();
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

            case 8: // '\b'
                boolean flag = eud1.h();
                a = true;
                b = flag;
                break;

            case 16: // '\020'
                boolean flag1 = eud1.h();
                c = true;
                d = flag1;
                break;

            case 26: // '\032'
                esf esf1 = new esf();
                eud1.a(esf1);
                if (e.isEmpty())
                {
                    e = new ArrayList();
                }
                e.add(esf1);
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
        for (Iterator iterator = e.iterator(); iterator.hasNext(); eue1.b(3, (esf)iterator.next())) { }
    }

    public final int b()
    {
        int i = 0;
        if (a)
        {
            i = eue.b(1, b) + 0;
        }
        int j = i;
        if (c)
        {
            j = i + eue.b(2, d);
        }
        for (Iterator iterator = e.iterator(); iterator.hasNext();)
        {
            j = eue.d(3, (esf)iterator.next()) + j;
        }

        f = j;
        return j;
    }
}
