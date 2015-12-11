// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class end extends eug
{

    private boolean a;
    private String b;
    private List c;
    private boolean d;
    private String e;
    private int f;

    public end()
    {
        b = "";
        c = Collections.emptyList();
        e = "";
        f = -1;
    }

    public final int a()
    {
        if (f < 0)
        {
            b();
        }
        return f;
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
                String s = eud1.i();
                a = true;
                b = s;
                break;

            case 16: // '\020'
                int j = eud1.f();
                if (c.isEmpty())
                {
                    c = new ArrayList();
                }
                c.add(Integer.valueOf(j));
                break;

            case 26: // '\032'
                String s1 = eud1.i();
                d = true;
                e = s1;
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
        for (Iterator iterator = c.iterator(); iterator.hasNext(); eue1.a(2, ((Integer)iterator.next()).intValue())) { }
        if (d)
        {
            eue1.a(3, e);
        }
    }

    public final int b()
    {
        int j = 0;
        Iterator iterator;
        int i;
        if (a)
        {
            i = eue.b(1, b) + 0;
        } else
        {
            i = 0;
        }
        for (iterator = c.iterator(); iterator.hasNext();)
        {
            j += eue.a(((Integer)iterator.next()).intValue());
        }

        j = i + j + c.size() * 1;
        i = j;
        if (d)
        {
            i = j + eue.b(3, e);
        }
        f = i;
        return i;
    }
}
