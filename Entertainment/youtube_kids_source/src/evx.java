// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class evx extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private boolean d;
    private boolean e;
    private int f;
    private List g;
    private int h;

    public evx()
    {
        b = 0;
        d = false;
        f = 0;
        g = Collections.emptyList();
        h = -1;
    }

    public final int a()
    {
        if (h < 0)
        {
            b();
        }
        return h;
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
                int j = eud1.f();
                a = true;
                b = j;
                break;

            case 16: // '\020'
                boolean flag = eud1.h();
                c = true;
                d = flag;
                break;

            case 24: // '\030'
                int k = eud1.f();
                e = true;
                f = k;
                break;

            case 34: // '"'
                evw evw1 = new evw();
                eud1.a(evw1);
                if (g.isEmpty())
                {
                    g = new ArrayList();
                }
                g.add(evw1);
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
        for (Iterator iterator = g.iterator(); iterator.hasNext(); eue1.b(4, (evw)iterator.next())) { }
    }

    public final int b()
    {
        int j = 0;
        if (a)
        {
            j = eue.d(1, b) + 0;
        }
        int i = j;
        if (c)
        {
            i = j + eue.b(2, d);
        }
        j = i;
        if (e)
        {
            j = i + eue.d(3, f);
        }
        for (Iterator iterator = g.iterator(); iterator.hasNext();)
        {
            j = eue.d(4, (evw)iterator.next()) + j;
        }

        h = j;
        return j;
    }
}
