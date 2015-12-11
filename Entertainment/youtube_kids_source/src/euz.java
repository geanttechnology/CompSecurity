// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class euz extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private int d;
    private List e;
    private boolean f;
    private float g;
    private int h;

    public euz()
    {
        b = 0;
        d = 0;
        e = Collections.emptyList();
        g = 0.0F;
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
                int k = eud1.f();
                c = true;
                d = k;
                break;

            case 26: // '\032'
                euy euy1 = new euy();
                eud1.a(euy1);
                if (e.isEmpty())
                {
                    e = new ArrayList();
                }
                e.add(euy1);
                break;

            case 37: // '%'
                float f1 = eud1.c();
                f = true;
                g = f1;
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
        for (Iterator iterator = e.iterator(); iterator.hasNext(); eue1.b(3, (euy)iterator.next())) { }
        if (f)
        {
            eue1.a(4, g);
        }
    }

    public final int b()
    {
        int i = 0;
        if (a)
        {
            i = eue.d(1, b) + 0;
        }
        int j = i;
        if (c)
        {
            j = i + eue.d(2, d);
        }
        Iterator iterator = e.iterator();
        for (i = j; iterator.hasNext(); i = eue.d(3, (euy)iterator.next()) + i) { }
        j = i;
        if (f)
        {
            j = i + eue.b(4, g);
        }
        h = j;
        return j;
    }
}
