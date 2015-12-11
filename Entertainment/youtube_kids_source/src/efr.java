// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class efr extends eug
{

    private List a;
    private boolean b;
    private boolean c;
    private boolean d;
    private int e;
    private boolean f;
    private int g;
    private boolean h;
    private boolean i;
    private int j;

    public efr()
    {
        a = Collections.emptyList();
        c = false;
        e = 1;
        g = 0;
        i = false;
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
                if (a.isEmpty())
                {
                    a = new ArrayList();
                }
                a.add(Integer.valueOf(l));
                break;

            case 16: // '\020'
                boolean flag = eud1.h();
                b = true;
                c = flag;
                break;

            case 24: // '\030'
                int i1 = eud1.f();
                d = true;
                e = i1;
                break;

            case 32: // ' '
                int j1 = eud1.f();
                f = true;
                g = j1;
                break;

            case 40: // '('
                boolean flag1 = eud1.h();
                h = true;
                i = flag1;
                break;
            }
        } while (true);
    }

    public final void a(eue eue1)
    {
        for (Iterator iterator = a.iterator(); iterator.hasNext(); eue1.a(1, ((Integer)iterator.next()).intValue())) { }
        if (b)
        {
            eue1.a(2, c);
        }
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
        Iterator iterator = a.iterator();
        int k;
        for (k = 0; iterator.hasNext(); k = eue.a(((Integer)iterator.next()).intValue()) + k) { }
        int l = k + 0 + a.size() * 1;
        k = l;
        if (b)
        {
            k = l + eue.b(2, c);
        }
        l = k;
        if (d)
        {
            l = k + eue.d(3, e);
        }
        k = l;
        if (f)
        {
            k = l + eue.d(4, g);
        }
        l = k;
        if (h)
        {
            l = k + eue.b(5, i);
        }
        j = l;
        return l;
    }
}
