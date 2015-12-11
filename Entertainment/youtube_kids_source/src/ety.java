// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class ety extends eug
{

    private boolean a;
    private int b;
    private boolean c;
    private eqc d;
    private boolean e;
    private String f;
    private List g;
    private boolean h;
    private int i;
    private int j;

    public ety()
    {
        b = 1;
        d = null;
        f = "";
        g = Collections.emptyList();
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

            case 8: // '\b'
                int l = eud1.f();
                a = true;
                b = l;
                break;

            case 18: // '\022'
                eqc eqc1 = new eqc();
                eud1.a(eqc1);
                c = true;
                d = eqc1;
                break;

            case 26: // '\032'
                String s = eud1.i();
                e = true;
                f = s;
                break;

            case 34: // '"'
                eqd eqd1 = new eqd();
                eud1.a(eqd1);
                if (g.isEmpty())
                {
                    g = new ArrayList();
                }
                g.add(eqd1);
                break;

            case 40: // '('
                int i1 = eud1.k();
                h = true;
                i = i1;
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
            eue1.b(2, d);
        }
        if (e)
        {
            eue1.a(3, f);
        }
        for (Iterator iterator = g.iterator(); iterator.hasNext(); eue1.b(4, (eqd)iterator.next())) { }
        if (h)
        {
            eue1.b(5, i);
        }
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
            l = k + eue.b(3, f);
        }
        Iterator iterator = g.iterator();
        for (k = l; iterator.hasNext(); k = eue.d(4, (eqd)iterator.next()) + k) { }
        l = k;
        if (h)
        {
            l = k + eue.e(5, i);
        }
        j = l;
        return l;
    }
}
