// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class esy extends eug
{

    private boolean a;
    private esx b;
    private boolean c;
    private esz d;
    private boolean e;
    private String f;
    private List g;
    private boolean h;
    private esb i;
    private boolean j;
    private boolean k;
    private int l;

    public esy()
    {
        b = null;
        d = null;
        f = "";
        g = Collections.emptyList();
        i = null;
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
                esx esx1 = new esx();
                eud1.a(esx1);
                a = true;
                b = esx1;
                break;

            case 18: // '\022'
                esz esz1 = new esz();
                eud1.a(esz1);
                c = true;
                d = esz1;
                break;

            case 26: // '\032'
                String s = eud1.i();
                e = true;
                f = s;
                break;

            case 34: // '"'
                erp erp1 = new erp();
                eud1.a(erp1);
                if (g.isEmpty())
                {
                    g = new ArrayList();
                }
                g.add(erp1);
                break;

            case 42: // '*'
                esb esb1 = new esb();
                eud1.a(esb1);
                h = true;
                i = esb1;
                break;

            case 48: // '0'
                boolean flag = eud1.h();
                j = true;
                k = flag;
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
        if (c)
        {
            eue1.b(2, d);
        }
        if (e)
        {
            eue1.a(3, f);
        }
        for (Iterator iterator = g.iterator(); iterator.hasNext(); eue1.b(4, (erp)iterator.next())) { }
        if (h)
        {
            eue1.b(5, i);
        }
        if (j)
        {
            eue1.a(6, k);
        }
    }

    public final int b()
    {
        int j1 = 0;
        if (a)
        {
            j1 = eue.d(1, b) + 0;
        }
        int i1 = j1;
        if (c)
        {
            i1 = j1 + eue.d(2, d);
        }
        j1 = i1;
        if (e)
        {
            j1 = i1 + eue.b(3, f);
        }
        for (Iterator iterator = g.iterator(); iterator.hasNext();)
        {
            j1 = eue.d(4, (erp)iterator.next()) + j1;
        }

        i1 = j1;
        if (h)
        {
            i1 = j1 + eue.d(5, i);
        }
        j1 = i1;
        if (j)
        {
            j1 = i1 + eue.b(6, k);
        }
        l = j1;
        return j1;
    }
}
