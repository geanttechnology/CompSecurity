// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class etn extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private int d;
    private List e;
    private List f;
    private boolean g;
    private eth h;
    private int i;

    public etn()
    {
        b = "";
        d = 0;
        e = Collections.emptyList();
        f = Collections.emptyList();
        h = null;
        i = -1;
    }

    public final int a()
    {
        if (i < 0)
        {
            b();
        }
        return i;
    }

    public final eug a(eud eud1)
    {
        do
        {
            int j = eud1.a();
            switch (j)
            {
            default:
                if (a(eud1, j))
                {
                    continue;
                }
                // fall through

            case 0: // '\0'
                return this;

            case 10: // '\n'
                String s = eud1.i();
                a = true;
                b = s;
                break;

            case 16: // '\020'
                int k = eud1.f();
                c = true;
                d = k;
                break;

            case 24: // '\030'
                int l = eud1.f();
                if (e.isEmpty())
                {
                    e = new ArrayList();
                }
                e.add(Integer.valueOf(l));
                break;

            case 32: // ' '
                int i1 = eud1.f();
                if (f.isEmpty())
                {
                    f = new ArrayList();
                }
                f.add(Integer.valueOf(i1));
                break;

            case 8002: 
                eth eth1 = new eth();
                eud1.a(eth1);
                g = true;
                h = eth1;
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
        for (Iterator iterator = e.iterator(); iterator.hasNext(); eue1.a(3, ((Integer)iterator.next()).intValue())) { }
        for (Iterator iterator1 = f.iterator(); iterator1.hasNext(); eue1.a(4, ((Integer)iterator1.next()).intValue())) { }
        if (g)
        {
            eue1.b(1000, h);
        }
    }

    public final int b()
    {
        int l = 0;
        Iterator iterator;
        int j;
        int k;
        int i1;
        if (a)
        {
            j = eue.b(1, b) + 0;
        } else
        {
            j = 0;
        }
        if (c)
        {
            j += eue.d(2, d);
        }
        iterator = e.iterator();
        for (k = 0; iterator.hasNext(); k = eue.a(((Integer)iterator.next()).intValue()) + k) { }
        i1 = e.size();
        for (Iterator iterator1 = f.iterator(); iterator1.hasNext();)
        {
            l += eue.a(((Integer)iterator1.next()).intValue());
        }

        k = i1 * 1 + (j + k) + l + f.size() * 1;
        j = k;
        if (g)
        {
            j = k + eue.d(1000, h);
        }
        i = j;
        return j;
    }
}
