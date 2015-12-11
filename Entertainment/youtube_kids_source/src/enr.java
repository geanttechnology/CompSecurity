// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class enr extends eug
{

    private boolean a;
    private eqm b;
    private List c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;

    public enr()
    {
        b = null;
        c = Collections.emptyList();
        e = false;
        g = false;
        i = 0;
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

            case 10: // '\n'
                eqm eqm1 = new eqm();
                eud1.a(eqm1);
                a = true;
                b = eqm1;
                break;

            case 18: // '\022'
                eqg eqg1 = new eqg();
                eud1.a(eqg1);
                if (c.isEmpty())
                {
                    c = new ArrayList();
                }
                c.add(eqg1);
                break;

            case 24: // '\030'
                boolean flag = eud1.h();
                d = true;
                e = flag;
                break;

            case 32: // ' '
                boolean flag1 = eud1.h();
                f = true;
                g = flag1;
                break;

            case 40: // '('
                int l = eud1.f();
                h = true;
                i = l;
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
        for (Iterator iterator = c.iterator(); iterator.hasNext(); eue1.b(2, (eqg)iterator.next())) { }
        if (d)
        {
            eue1.a(3, e);
        }
        if (f)
        {
            eue1.a(4, g);
        }
        if (h)
        {
            eue1.a(5, i);
        }
    }

    public final int b()
    {
        int k = 0;
        if (a)
        {
            k = eue.d(1, b) + 0;
        }
        Iterator iterator = c.iterator();
        int l;
        for (l = k; iterator.hasNext(); l = eue.d(2, (eqg)iterator.next()) + l) { }
        k = l;
        if (d)
        {
            k = l + eue.b(3, e);
        }
        l = k;
        if (f)
        {
            l = k + eue.b(4, g);
        }
        k = l;
        if (h)
        {
            k = l + eue.d(5, i);
        }
        j = k;
        return k;
    }
}
