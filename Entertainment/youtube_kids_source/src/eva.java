// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eva extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private float d;
    private boolean e;
    private int f;
    private List g;
    private int h;

    public eva()
    {
        b = 0;
        d = 0.0F;
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

            case 21: // '\025'
                float f1 = eud1.c();
                c = true;
                d = f1;
                break;

            case 24: // '\030'
                int k = eud1.f();
                e = true;
                f = k;
                break;

            case 34: // '"'
                evb evb1 = new evb();
                eud1.a(evb1);
                if (g.isEmpty())
                {
                    g = new ArrayList();
                }
                g.add(evb1);
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
        for (Iterator iterator = g.iterator(); iterator.hasNext(); eue1.b(4, (evb)iterator.next())) { }
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
            j = eue.d(4, (evb)iterator.next()) + j;
        }

        h = j;
        return j;
    }
}
