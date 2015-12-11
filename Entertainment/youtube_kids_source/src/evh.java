// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class evh extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private int d;
    private boolean e;
    private int f;
    private boolean g;
    private long h;
    private List i;
    private int j;

    public evh()
    {
        b = 0;
        d = 0;
        f = 0;
        h = 0L;
        i = Collections.emptyList();
        j = -1;
    }

    public final int a()
    {
        if (j < 0)
        {
            b();
        }
        return j;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int k = eud1.a();
            switch (k)
            {
            default:
                if (a(eud1, k))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 8: // '\b'
                int l = eud1.f();
                a = true;
                b = l;
                break;

            case 16: // '\020'
                int i1 = eud1.f();
                c = true;
                d = i1;
                break;

            case 24: // '\030'
                int j1 = eud1.f();
                e = true;
                f = j1;
                break;

            case 32: // ' '
                long l1 = eud1.e();
                g = true;
                h = l1;
                break;

            case 42: // '*'
                evf evf1 = new evf();
                eud1.a(evf1);
                if (i.isEmpty())
                {
                    i = new ArrayList();
                }
                i.add(evf1);
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
        if (e)
        {
            eue1.a(3, f);
        }
        if (g)
        {
            eue1.b(4, h);
        }
        for (Iterator iterator = i.iterator(); iterator.hasNext(); eue1.b(5, (evf)iterator.next())) { }
    }

    public final int b()
    {
        int l = 0;
        if (a)
        {
            l = eue.d(1, b) + 0;
        }
        int k = l;
        if (c)
        {
            k = l + eue.d(2, d);
        }
        l = k;
        if (e)
        {
            l = k + eue.d(3, f);
        }
        k = l;
        if (g)
        {
            k = l + eue.e(4, h);
        }
        for (Iterator iterator = i.iterator(); iterator.hasNext();)
        {
            k = eue.d(5, (evf)iterator.next()) + k;
        }

        j = k;
        return k;
    }
}
