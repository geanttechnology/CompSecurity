// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class esh extends eug
{

    private boolean a;
    private String b;
    private boolean c;
    private String d;
    private List e;
    private int f;

    public esh()
    {
        b = "";
        d = "";
        e = Collections.emptyList();
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

            case 18: // '\022'
                String s1 = eud1.i();
                c = true;
                d = s1;
                break;

            case 26: // '\032'
                String s2 = eud1.i();
                if (s2 == null)
                {
                    throw new NullPointerException();
                }
                if (e.isEmpty())
                {
                    e = new ArrayList();
                }
                e.add(s2);
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
        for (Iterator iterator = e.iterator(); iterator.hasNext(); eue1.a(3, (String)iterator.next())) { }
    }

    public final int b()
    {
        int j = 0;
        int i;
        if (a)
        {
            i = eue.b(1, b) + 0;
        } else
        {
            i = 0;
        }
        if (c)
        {
            i += eue.b(2, d);
        }
        for (Iterator iterator = e.iterator(); iterator.hasNext();)
        {
            j += eue.a((String)iterator.next());
        }

        i = i + j + e.size() * 1;
        f = i;
        return i;
    }
}
