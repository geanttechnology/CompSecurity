// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class esm extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private boolean e;
    private int f;
    private List g;
    private boolean h;
    private String i;
    private int j;

    public esm()
    {
        b = "";
        d = "";
        f = 0;
        g = Collections.emptyList();
        i = "";
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
                String s = eud1.i();
                a = true;
                b = s;
                break;

            case 18: // '\022'
                String s1 = eud1.i();
                c = true;
                d = s1;
                break;

            case 24: // '\030'
                int l = eud1.f();
                e = true;
                f = l;
                break;

            case 32: // ' '
                int i1 = eud1.f();
                if (g.isEmpty())
                {
                    g = new ArrayList();
                }
                g.add(Integer.valueOf(i1));
                break;

            case 42: // '*'
                String s2 = eud1.i();
                h = true;
                i = s2;
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
        for (Iterator iterator = g.iterator(); iterator.hasNext(); eue1.a(4, ((Integer)iterator.next()).intValue())) { }
        if (h)
        {
            eue1.a(5, i);
        }
    }

    public final int b()
    {
        boolean flag = false;
        Iterator iterator;
        int k;
        int l;
        if (a)
        {
            k = eue.b(1, b) + 0;
        } else
        {
            k = 0;
        }
        l = k;
        if (c)
        {
            l = k + eue.b(2, d);
        }
        if (e)
        {
            k = l + eue.d(3, f);
        } else
        {
            k = l;
        }
        iterator = g.iterator();
        for (l = ((flag) ? 1 : 0); iterator.hasNext(); l += eue.a(((Integer)iterator.next()).intValue())) { }
        l = k + l + g.size() * 1;
        k = l;
        if (h)
        {
            k = l + eue.b(5, i);
        }
        j = k;
        return k;
    }
}
