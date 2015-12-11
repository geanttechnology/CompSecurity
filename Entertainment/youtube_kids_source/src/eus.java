// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eus extends eug
{

    public int a;
    public int b;
    public List c;
    private boolean d;
    private boolean e;
    private boolean f;
    private float g;
    private int h;

    public eus()
    {
        a = 0;
        b = 0;
        c = Collections.emptyList();
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
                d = true;
                a = j;
                break;

            case 16: // '\020'
                int k = eud1.f();
                e = true;
                b = k;
                break;

            case 26: // '\032'
                euq euq1 = new euq();
                eud1.a(euq1);
                if (c.isEmpty())
                {
                    c = new ArrayList();
                }
                c.add(euq1);
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
        if (d)
        {
            eue1.a(1, a);
        }
        if (e)
        {
            eue1.a(2, b);
        }
        for (Iterator iterator = c.iterator(); iterator.hasNext(); eue1.b(3, (euq)iterator.next())) { }
        if (f)
        {
            eue1.a(4, g);
        }
    }

    public final int b()
    {
        int i = 0;
        if (d)
        {
            i = eue.d(1, a) + 0;
        }
        int j = i;
        if (e)
        {
            j = i + eue.d(2, b);
        }
        Iterator iterator = c.iterator();
        for (i = j; iterator.hasNext(); i = eue.d(3, (euq)iterator.next()) + i) { }
        j = i;
        if (f)
        {
            j = i + eue.b(4, g);
        }
        h = j;
        return j;
    }
}
