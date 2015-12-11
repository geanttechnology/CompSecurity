// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class epu extends eug
{

    private List a;
    private boolean b;
    private erd c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;

    public epu()
    {
        a = Collections.emptyList();
        c = null;
        e = false;
        g = false;
        i = false;
        k = false;
        l = -1;
    }

    public final int a()
    {
        if (l < 0)
        {
            b();
        }
        return l;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int i1 = eud1.a();
            switch (i1)
            {
            default:
                if (a(eud1, i1))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                enl enl1 = new enl();
                eud1.a(enl1);
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(enl1);
                break;

            case 16: // '\020'
                boolean flag = eud1.h();
                d = true;
                e = flag;
                break;

            case 24: // '\030'
                boolean flag1 = eud1.h();
                f = true;
                g = flag1;
                break;

            case 32: // ' '
                boolean flag2 = eud1.h();
                h = true;
                i = flag2;
                break;

            case 40: // '('
                boolean flag3 = eud1.h();
                j = true;
                k = flag3;
                break;

            case 50: // '2'
                erd erd1 = new erd();
                eud1.a(erd1);
                b = true;
                c = erd1;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.b(1, (enl)iterator.next())) { }
        if (d)
        {
            eue1.a(2, e);
        }
        if (f)
        {
            eue1.a(3, g);
        }
        if (h)
        {
            eue1.a(4, i);
        }
        if (j)
        {
            eue1.a(5, k);
        }
        if (b)
        {
            eue1.b(6, c);
        }
    }

    public final int b()
    {
        Iterator iterator = a.iterator();
        int j1;
        for (j1 = 0; iterator.hasNext(); j1 = eue.d(1, (enl)iterator.next()) + j1) { }
        int i1 = j1;
        if (d)
        {
            i1 = j1 + eue.b(2, e);
        }
        j1 = i1;
        if (f)
        {
            j1 = i1 + eue.b(3, g);
        }
        i1 = j1;
        if (h)
        {
            i1 = j1 + eue.b(4, i);
        }
        j1 = i1;
        if (j)
        {
            j1 = i1 + eue.b(5, k);
        }
        i1 = j1;
        if (b)
        {
            i1 = j1 + eue.d(6, c);
        }
        l = i1;
        return i1;
    }
}
