// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class eor extends eug
{

    private boolean a;
    private eoq b;
    private List c;
    private boolean d;
    private eon e;
    private boolean f;
    private int g;
    private int h;

    public eor()
    {
        b = null;
        c = Collections.emptyList();
        e = null;
        g = 0;
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

            case 10: // '\n'
                eoq eoq1 = new eoq();
                eud1.a(eoq1);
                a = true;
                b = eoq1;
                break;

            case 16: // '\020'
                int j = eud1.f();
                f = true;
                g = j;
                break;

            case 26: // '\032'
                eon eon1 = new eon();
                eud1.a(eon1);
                if (c.isEmpty())
                {
                    c = new ArrayList();
                }
                c.add(eon1);
                break;

            case 34: // '"'
                eon eon2 = new eon();
                eud1.a(eon2);
                d = true;
                e = eon2;
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
        if (f)
        {
            eue1.a(2, g);
        }
        for (Iterator iterator = c.iterator(); iterator.hasNext(); eue1.b(3, (eon)iterator.next())) { }
        if (d)
        {
            eue1.b(4, e);
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
        if (f)
        {
            j = i + eue.d(2, g);
        }
        Iterator iterator = c.iterator();
        for (i = j; iterator.hasNext(); i = eue.d(3, (eon)iterator.next()) + i) { }
        j = i;
        if (d)
        {
            j = i + eue.d(4, e);
        }
        h = j;
        return j;
    }
}
